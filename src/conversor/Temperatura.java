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
		
		JLabel lblNewLabel = new JLabel("CONVERTIR");
		lblNewLabel.setBounds(48, 88, 122, 28);
		add(lblNewLabel);
		
		JLabel lblConversinDeMoneda = new JLabel("TEMPERATURA");
		lblConversinDeMoneda.setFont(new Font("Arial", Font.BOLD, 20));
		lblConversinDeMoneda.setBounds(48, 22, 333, 24);
		add(lblConversinDeMoneda);
		
		textField = new JTextField();
		textField.setBounds(48, 137, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblA = new JLabel("A");
		lblA.setBounds(48, 168, 122, 28);
		add(lblA);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(215, 202, 70, 20);
		add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(48, 207, 122, 22);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(163, 136, 122, 22);
		add(comboBox_1);

	}

}
