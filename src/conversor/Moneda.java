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
  
    String apiKey = "a87b9818de26537a0cb94e0c63c71a9d";
    String apiUrl = "https://api.exchangeratesapi.io/v1/latest?access_key=" + apiKey;



    public Moneda() {
   

        // Definir los factores de conversión entre cada par de monedas
        
//        tiposDeCambio = new HashMap<>();
//        Map<String, Double> conversionesUSD = new HashMap<>();
//        conversionesUSD.put("MXN - Pesos Mexicanos", 16.87);
//        conversionesUSD.put("USD - Dólares Estadounidenses", 1.0);
//        conversionesUSD.put("EUR - Euro", 0.89);
//        conversionesUSD.put("JPY - Yen Japonés", 138.205);
//        conversionesUSD.put("KRW - Won Surcoreano", 1275.63);
//        conversionesUSD.put("GBP - Libra Esterlina britanica", 0.77);
//        tiposDeCambio.put("USD - Dólares Estadounidenses", conversionesUSD);
//
//        Map<String, Double> conversionesEUR = new HashMap<>();
//        conversionesEUR.put("MXN - Pesos Mexicanos", 18.79);
//        conversionesEUR.put("USD - Dólares Estadounidenses", 1.11);
//        conversionesEUR.put("EUR - Euro", 1.0);
//        conversionesEUR.put("JPY - Yen Japonés", 154.03);
//        conversionesEUR.put("KRW - Won Surcoreano", 1419.6);
//        conversionesUSD.put("GBP - Libra Esterlina britanica", 0.85);
//        tiposDeCambio.put("EUR - Euro", conversionesEUR);
//        
//        Map<String, Double> conversionesMXN = new HashMap<>();
//        conversionesMXN.put("MXN - Pesos Mexicanos", 1.00);
//        conversionesMXN.put("USD - Dólares Estadounidenses", 0.05858);
//        conversionesMXN.put("EUR - Euro", 0.05);
//        conversionesMXN.put("JPY - Yen Japonés", 8.1);
//        conversionesMXN.put("KRW - Won Surcoreano", 75.5);
//        conversionesMXN.put("GBP - Libra Esterlina britanica", 0.04);
//        tiposDeCambio.put("MXN - Pesos Mexicanos", conversionesMXN);
//        
//        Map<String, Double> conversionesKRW = new HashMap<>();
//        conversionesKRW.put("MXN - Pesos Mexicanos",  0.01);
//        conversionesKRW.put("USD - Dólares Estadounidenses", 0.0007);
//        conversionesKRW.put("EUR - Euro", 0.0007);
//        conversionesKRW.put("JPY - Yen Japonés", 0.10);
//        conversionesKRW.put("KRW - Won Surcoreano", 1.0);
//        conversionesKRW.put("GBP - Libra Esterlina britanica", 0.0006);
//        tiposDeCambio.put("KRW - Won Surcoreano", conversionesKRW);
//        
//        Map<String, Double> conversionesJPY = new HashMap<>();
//        conversionesJPY.put("MXN - Pesos Mexicanos", 0.12);
//        conversionesJPY.put("USD - Dólares Estadounidenses", 1.18);
//        conversionesJPY.put("EUR - Euro", 1.0);
//        conversionesJPY.put("JPY - Yen Japonés", 1.00);
//        conversionesJPY.put("KRW - Won Surcoreano", 9.21);
//        conversionesJPY.put("GBP - Libra Esterlina britanica", 0.006);
//        tiposDeCambio.put("JPY - Yen Japonés", conversionesJPY);
//        
//        Map<String, Double> conversionesGBP = new HashMap<>();
//        conversionesGBP.put("MXN - Pesos Mexicanos", 21.92);
//        conversionesGBP.put("USD - Dólares Estadounidenses", 1.29);
//        conversionesGBP.put("EUR - Euro", 1.16);
//        conversionesGBP.put("JPY - Yen Japonés", 179.72);
//        conversionesGBP.put("KRW - Won Surcoreano", 1656.33);
//        conversionesGBP.put("GBP - Libra Esterlina britanica", 1.00);
//        tiposDeCambio.put("GBP - Libra Esterlina britanica", conversionesGBP);

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
        
        double factorConversion = obtenerFactorConversion(monedaOrigen, monedaDestino);
        if (factorConversion == -1.0) {
            resultadoLbl.setText("Resultado: No se encontró el tipo de cambio para convertir de " + monedaOrigen + " a " + monedaDestino);
            return;
        }

        double resultado = cantidad * factorConversion;
        String resultadoFormateado = String.format("%.2f", resultado);

        String resultadoTexto = "Resultado: " + cantidad + " " + monedaOrigen + " = " + resultadoFormateado + " " + monedaDestino;
        resultadoLbl.setText(resultadoTexto);

      //  Map<String, Double> conversionesOrigen = tiposDeCambio.get(monedaOrigen);
//        if (conversionesOrigen == null) {
//            resultadoLbl.setText("Resultado: No se encontró el tipo de cambio para la moneda de origen");
//            return;
//        }

//        Double factorConversion = conversionesOrigen.get(monedaDestino);
//        if (factorConversion == null) {
//            resultadoLbl.setText("Resultado: No se encontró el tipo de cambio para convertir de " + monedaOrigen + " a " + monedaDestino);
//            return;
//        }

//        double resultado = cantidad * factorConversion;
//        String resultadoFormateado = String.format("%.2f", resultado);
//
//        String resultadoTexto = "Resultado: " + cantidad + " " + monedaOrigen + " = " + resultadoFormateado + " " + monedaDestino;
//        resultadoLbl.setText(resultadoTexto);
    }

//    public double convertir(double cantidad, String monedaOrigen, String monedaDestino) {
//    	   if (monedaOrigen.equals(monedaDestino)) {
//               return cantidad; // No se requiere conversión si las monedas son iguales
//           }
//
//           double factorConversion = obtenerFactorConversion(monedaOrigen, monedaDestino);
//           if (factorConversion == -1.0) {
//               throw new IllegalArgumentException("No se encontró el tipo de cambio para convertir de " + monedaOrigen + " a " + monedaDestino);
//           }
//
//        return cantidad * factorConversion;
//    }
    private double obtenerFactorConversion(String monedaOrigen, String monedaDestino) {
        String url = "https://api.exchangeratesapi.io/v1/latest/" + monedaOrigen.substring(0, 3);

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
                JSONObject rates = jsonResponse.getJSONObject("rates");
                if (rates.has(monedaDestino)) {
                    return rates.getDouble(monedaDestino.substring(0, 3));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1.0;
    }
}