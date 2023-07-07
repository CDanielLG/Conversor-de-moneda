package conversor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Longitud extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Longitud() {
		setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Convertir");
		lblNewLabel_1_1.setBounds(32, 118, 45, 14);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("A");
		lblNewLabel_1.setBounds(32, 194, 33, 14);
		add(lblNewLabel_1);
		
		JLabel lblConversinDeLongitud = new JLabel("LONGITUD\r\n");
		lblConversinDeLongitud.setBounds(167, 25, 370, 24);
		lblConversinDeLongitud.setFont(new Font("Arial", Font.BOLD, 20));
		add(lblConversinDeLongitud);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(137, 142, 83, 22);
		add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(32, 143, 86, 20);
		add(textField);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(35, 219, 83, 22);
		add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(140, 223, 46, 14);
		add(lblNewLabel);

	}

}
