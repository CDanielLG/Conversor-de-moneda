package conversor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;

public class Volumen extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Volumen() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONVERSIÓN DE VOLUMEN");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(70, 5, 370, 41);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Convertir ");
		lblNewLabel_1_1.setBounds(54, 75, 113, 26);
		add(lblNewLabel_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(159, 105, 83, 22);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(54, 196, 83, 22);
		add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(54, 106, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel resultado = new JLabel("");
		resultado.setBackground(new Color(255, 255, 255));
		resultado.setBounds(268, 143, 46, 14);
		add(resultado);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("A");
		lblNewLabel_1_1_1.setBounds(54, 149, 113, 26);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(176, 200, 46, 14);
		add(lblNewLabel_1);

	}
}
