package conversor;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


public class Moneda extends JPanel {
	private JTextField cantidad;
	private JComboBox<String> opcionesConvertir;
	private JComboBox<String> opcionesConversion;
	private JLabel resultadoLbl;
	private JLabel valorConversion;

	private String[] opcionesMonedas = { "MXN - Pesos Mexicanos", "USD - Dólares Estadounidenses", "EUR - Euro",
			"JPY - Yen Japonés", "KRW - Won Surcoreano", "GBP - Libra Esterlina británica" };
//API exchangerate
	String apiKey = "1080300593cf9a67920fcddc";
	String apiUrl = "https://v6.exchangerate-api.com/v6/";
	private JButton btnNewButton;

	public Moneda() {

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

		JLabel lblA = new JLabel("A:");
		lblA.setFont(new Font("Arial", Font.BOLD, 15));
		lblA.setBounds(48, 174, 122, 28);
		add(lblA);

		resultadoLbl = new JLabel("");
		resultadoLbl.setBounds(23, 300, 488, 39);
		add(resultadoLbl);

		opcionesConvertir = new JComboBox<>(opcionesMonedas);
		opcionesConvertir.setBounds(229, 126, 218, 22);

		add(opcionesConvertir);
		opcionesConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarResultado();
			}
		});

		opcionesConversion = new JComboBox<>(opcionesMonedas);
		opcionesConversion.setBounds(48, 214, 218, 22);

		add(opcionesConversion);

		JLabel lblDe = new JLabel("De:");
		lblDe.setFont(new Font("Arial", Font.BOLD, 15));
		lblDe.setBounds(229, 88, 122, 28);
		add(lblDe);

		valorConversion = new JLabel("");
		valorConversion.setBounds(34, 375, 488, 39);
		add(valorConversion);
		
		JButton buttonCh = new JButton("Intercambiar");
		buttonCh.setFont(new Font("Arial", Font.BOLD, 15));
		buttonCh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String monedaOrigen = (String) opcionesConvertir.getSelectedItem();
				String monedaDestino = (String) opcionesConversion.getSelectedItem();
			
				opcionesConvertir.setSelectedItem(monedaDestino);
				opcionesConversion.setSelectedItem(monedaOrigen);
			}
		});
	
		buttonCh.setBounds(316, 247, 142, 23);
		add(buttonCh);
		
		btnNewButton = new JButton("Convertir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarResultado();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(316, 212, 142, 24);
		add(btnNewButton);
		
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

		double factorConversion = obtenerFactorConversion(cantidad, monedaOrigen, monedaDestino);
		if (factorConversion == -1.0) {
			resultadoLbl.setText("Resultado: No se encontró el tipo de cambio para convertir de " + monedaOrigen + " a "
					+ monedaDestino);
			return;
		}

		double resultado = cantidad * factorConversion;
		System.out.println(factorConversion);
		String resultadoFormateado = String.format("%.2f", resultado);

		String resultadoTexto = "Resultado: " + cantidad + " " + monedaOrigen + " = " + resultadoFormateado + " "
				+ monedaDestino;
		resultadoLbl.setText(resultadoTexto);
		String valorMoneda = "1.0" + " " + monedaOrigen + " = " + factorConversion +" "+ monedaDestino;
		valorConversion.setText(valorMoneda);

	}

	private double obtenerFactorConversion(double cantidad, String monedaOrigen, String monedaDestino) {
		String apiKey = "1080300593cf9a67920fcddc";
		String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + monedaOrigen.substring(0, 3) + "/"
				+ monedaDestino.substring(0, 3);

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
	private void cambiarCheckBox() {
	
		
	}
}
