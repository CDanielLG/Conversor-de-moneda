package conversor;

import javax.swing.JPanel;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.List;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

//Importar clases para la APi conversion
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;


public class Moneda extends JPanel {
    private JTextField cantidad;
    private JComboBox<String> opcionesConvertir;
    private JComboBox<String> opcionesConversion;
    private JLabel resultadoLbl;
 
    private String[] opcionesMonedas = {
            "MXN - Pesos Mexicanos",
            "USD - Dólares Estadounidenses",
            "EUR - Euro",
            "JPY - Yen Japonés",
            "KRW - Won Surcoreano",
            "GBP - Libra Esterlina británica"
        };
  
    String apiKey = "1080300593cf9a67920fcddc";
    String apiUrl = "https://v6.exchangerate-api.com/v6/";



    public Moneda() {
   
    	try {
    	    URL url = new URL(apiUrl + apiKey + "latest/USD");
    	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    	    connection.setRequestMethod("GET");

    	    int responseCode = connection.getResponseCode();
    	    if (responseCode == HttpURLConnection.HTTP_OK) {
    	        System.out.println("Conexión exitosa a la API");
    	        // Puedes realizar otras operaciones con la respuesta de la API aquí
    	    } else {
    	        System.out.println("No se pudo conectar a la API. Código de respuesta: " + responseCode);
    	    }
    	} catch (IOException e) {
    	    System.out.println("Error al conectar a la API: " + e.getMessage());
    	}


        setLayout(null);

        JLabel lblNewLabel = new JLabel("Quiero convertir ");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
        lblNewLabel.setBounds(48, 88, 122, 28);
        add(lblNewLabel);

        JLabel lblConversinDeMoneda = new JLabel(" MONEDA");
        lblConversinDeMoneda.setFont(new Font("Arial", Font.BOLD, 20));
        lblConversinDeMoneda.setBounds(59, 30, 333, 24);
        add(lblConversinDeMoneda);

        cantidad = new JTextField();
        cantidad.setBounds(48, 127, 142, 20);
        add(cantidad);
        cantidad.setColumns(10);

        cantidad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarResultado();
            }
        });

        JLabel lblA = new JLabel("A");
        lblA.setBounds(48, 209, 122, 28);
        add(lblA);

        resultadoLbl = new JLabel("");
        resultadoLbl.setBounds(48, 281, 434, 20);
        add(resultadoLbl);

        opcionesConvertir = new JComboBox<>(opcionesMonedas);
        opcionesConvertir.setBounds(48, 176, 218, 22);
      

        add(opcionesConvertir);
        opcionesConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarResultado();
            }
        });

        opcionesConversion = new JComboBox<>(opcionesMonedas);
        opcionesConversion.setBounds(48, 248, 218, 22);
       
        add(opcionesConversion);
        opcionesConversion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarResultado();
            }
        });
    }

    private void actualizarResultado() {
        String monedaOrigen = (String) opcionesConvertir.getSelectedItem();
        String cantidadTexto = cantidad.getText();
        double cantidad;

        try {
            cantidad = Double.parseDouble(cantidadTexto);
        } catch (NumberFormatException e) {
            resultadoLbl.setText("Resultado: Error de conversión");
            return;
        }
        String monedaDestino = (String) opcionesConversion.getSelectedItem();
        
        double factorConversion = obtenerFactorConversion(cantidad,monedaOrigen, monedaDestino);
        if (factorConversion == -1.0) {
            resultadoLbl.setText("Resultado: No se encontró el tipo de cambio para convertir de "+ monedaOrigen + " a " + monedaDestino);
            return;
        }

        double resultado = cantidad * factorConversion;
        String resultadoFormateado = String.format("%.2f", resultado);

        String resultadoTexto = "Resultado: " + cantidad + " " + monedaOrigen + " = " + resultadoFormateado + " " + monedaDestino;
        resultadoLbl.setText(resultadoTexto);


    }


    private double obtenerFactorConversion(double cantidad, String monedaOrigen, String monedaDestino) {
        String apiKey = "1080300593cf9a67920fcddc"; // Reemplaza "TU_CLAVE_DE_API" por tu clave de API válida
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + monedaOrigen.substring(0, 3) + "/" + monedaDestino.substring(0, 3);

        try {
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parsear el JSON de respuesta para obtener el factor de conversión
                JSONObject jsonResponse = new JSONObject(response.toString());
                System.out.println("Respuesta JSON: " + response.toString());
                double resultado = jsonResponse.getDouble("conversion_rate");
                return resultado;
            } else {
                // Error en la respuesta de la API
                System.out.println("Error en la respuesta de la API: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1.0;
    }
}