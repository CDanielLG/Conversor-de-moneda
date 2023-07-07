package conversor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;

public class Temperatura extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Temperatura() {
		setLayout(null);
		
		JLabel lblConversinDeTemperatura = new JLabel("TEMPERATURA");
		lblConversinDeTemperatura.setBounds(45, 26, 333, 24);
		lblConversinDeTemperatura.setFont(new Font("Arial", Font.BOLD, 20));
		add(lblConversinDeTemperatura);
		
		JLabel lblNewLabel_1_1 = new JLabel("Convertir");
		lblNewLabel_1_1.setBounds(45, 84, 113, 26);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("A");
		lblNewLabel_1.setBounds(45, 173, 15, 26);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(45, 128, 86, 20);
		add(textField);
		
		JLabel resultado = new JLabel("");
		resultado.setBackground(new Color(0, 0, 0));
		resultado.setBounds(156, 199, 65, 14);
		add(resultado);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(156, 128, 122, 22);
		add(comboBox_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(45, 210, 122, 22);
		add(comboBox_1);

	}

}
