package conversor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.json.JSONObject;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Temperatura extends JPanel {
	private JTextField cantidad;
	private JComboBox gradosConvertidos = new JComboBox();
	private JComboBox gradosConvertir = new JComboBox();
	private JLabel resultadoLbl = new JLabel();

	private String[] opcionesTemperaturas = { "°C - Celcius", "°F - Fahrenheit", "°K - Kelvin", "°R - Rankine" };

	public Temperatura() {
		setLayout(null);

		JLabel lblConversinDeMoneda = new JLabel("TEMPERATURA");
		lblConversinDeMoneda.setFont(new Font("Arial", Font.BOLD, 20));
		lblConversinDeMoneda.setBounds(48, 22, 333, 24);
		add(lblConversinDeMoneda);

		cantidad = new JTextField();
		cantidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarResultado();
			}
		});
		cantidad.setBounds(35, 120, 115, 20);
		add(cantidad);
		cantidad.setColumns(10);

		resultadoLbl = new JLabel("");
		resultadoLbl.setBounds(10, 285, 519, 35);
		add(resultadoLbl);

		gradosConvertidos = new JComboBox(opcionesTemperaturas);
		gradosConvertidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarResultado();
			}
		});
		gradosConvertidos.setBounds(35, 202, 122, 22);
		add(gradosConvertidos);

		gradosConvertir = new JComboBox(opcionesTemperaturas);
		gradosConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarResultado();
			}
		});
		gradosConvertir.setBounds(239, 119, 122, 22);
		add(gradosConvertir);

		JLabel lblNewLabel = new JLabel("Quiero convertir ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(35, 81, 122, 28);
		add(lblNewLabel);

		JLabel lblDe = new JLabel("De:");
		lblDe.setFont(new Font("Arial", Font.BOLD, 15));
		lblDe.setBounds(239, 81, 122, 28);
		add(lblDe);

		JLabel lblA = new JLabel("A:");
		lblA.setFont(new Font("Arial", Font.BOLD, 15));
		lblA.setBounds(35, 172, 122, 28);
		add(lblA);
		JButton buttonCh = new JButton("Intercambiar");
		buttonCh.setFont(new Font("Arial", Font.BOLD, 15));
		buttonCh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gradoOrigen = (String) gradosConvertir.getSelectedItem();
				String gradoDestino = (String) gradosConvertidos.getSelectedItem();
			
				gradosConvertir.setSelectedItem(gradoDestino);
				 gradosConvertidos.setSelectedItem(gradoOrigen);
			}
		});
		buttonCh.setBounds(239, 201, 142, 23);
		add(buttonCh);
		
		JButton btnNewButton = new JButton("Convertir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarResultado();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(239, 235, 142, 24);
		add(btnNewButton);
	
	}

	private void actualizarResultado() {
		String gradosOrigen = (String) gradosConvertir.getSelectedItem();
		String cantidadTexto = cantidad.getText();
		double cantidad;

		try {
			cantidad = Double.parseDouble(cantidadTexto);
		} catch (NumberFormatException e) {
			resultadoLbl.setText("Resultado: Error de conversión");
			return;
		}
		String gradosDestino = (String) gradosConvertidos.getSelectedItem();
	
			double factorConversion = obtenerFactorConversion(cantidad, gradosOrigen, gradosDestino);
			if (factorConversion == -1.0) {
				resultadoLbl.setText("Resultado: error de coversión, no se encontró: " + gradosOrigen + " a " + gradosDestino);
				return;
			}
		

		
		String resultadoFormateado = String.format("%.2f", factorConversion);

		String resultadoTexto = "Resultado: " + cantidad + " " + gradosOrigen + " = " + resultadoFormateado + " "
				+ gradosDestino;
		resultadoLbl.setText(resultadoTexto);

	}

	private double obtenerFactorConversion(double cantidad, String gradosOrigen, String gradosDestino) {
		
		switch (gradosOrigen.substring(0, 2)) {
		case "°C":
			if (gradosDestino.substring(0, 2).equals("°F")) {
				return (cantidad * 9 / 5) + 32;
			} else if (gradosDestino.substring(0, 2).equals("°K")) {
				return cantidad + 273.15;
			} else if (gradosDestino.substring(0, 2).equals("°R")) {
				return (cantidad + 273.15) * 9 / 5;
			}
			break;
		case "°K":
			if (gradosDestino.substring(0, 2).equals("°F")) {
				return (cantidad * 9 / 5) - 459.67;
			} else if (gradosDestino.substring(0, 2).equals("°C")) {
				return cantidad - 273.15;
			} else if (gradosDestino.substring(0, 2).equals("°R")) {
				return cantidad * 9 / 5;
			}
			break;
		case "°F":
			if (gradosDestino.substring(0, 2).equals("°K")) {
				return (cantidad + 459.67) * 5 / 9;
			} else if (gradosDestino.substring(0, 2).equals("°C")) {
				return (cantidad - 32) * 5 / 9;
			} else if (gradosDestino.substring(0, 2).equals("°R")) {
				return cantidad + 459.67;
			}
			break;
		case "°R":
			if (gradosDestino.substring(0, 2).equals("°K")) {
				return cantidad * 5 / 9;
			} else if (gradosDestino.substring(0, 2).equals("°C")) {
				return (cantidad - 491.67) * 5 / 9;
			} else if (gradosDestino.substring(0, 2).equals("°F")) {
				return cantidad - 459.67;
			}
			break;
		}
		return cantidad;
		
	}
}
