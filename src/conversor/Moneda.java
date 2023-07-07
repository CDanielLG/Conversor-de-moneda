package conversor;

import javax.swing.JPanel;
import java.awt.Choice;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.List;

public class Moneda extends JPanel {

	/**
	 * Create the panel.
	 */
	public Moneda() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Convertir A");
		lblNewLabel.setBounds(221, 71, 122, 28);
		add(lblNewLabel);
		
		Choice choice = new Choice();
		choice.setBounds(56, 81, 122, 20);
		add(choice);
		choice.add("Peso");

	}
}
