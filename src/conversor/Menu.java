package conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Panel;
import java.awt.Label;
import java.awt.ScrollPane;
import java.awt.Choice;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		JPanel content = new JPanel();
		setTitle("Conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Unidades de conversión");
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(10, 30, 256, 51);
		contentPane.add(label);
		
		Button monedaBtn = new Button("Moneda");
		monedaBtn.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				
			
			
			}
		});
		monedaBtn.setFont(new Font("Arial", Font.BOLD, 15));
		monedaBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Moneda moneda = new Moneda();
				moneda.setSize(500, 420);
				moneda.setLocation(0, 0);
				
				content.removeAll();
				content.add(moneda, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
			}
		});
		monedaBtn.setBounds(20, 87, 119, 38);
		contentPane.add(monedaBtn);
		
		Button temperaturaBtn = new Button("Temperatura\r\n");
		temperaturaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		temperaturaBtn.setFont(new Font("Arial", Font.BOLD, 15));
		temperaturaBtn.setBounds(20, 141, 119, 38);
		contentPane.add(temperaturaBtn);
		
		Button longitudBtn = new Button("Longitud");
		longitudBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
			
		});
	
		longitudBtn.setFont(new Font("Arial", Font.BOLD, 15));
		longitudBtn.setBounds(20, 197, 119, 38);
		contentPane.add(longitudBtn);
		
		Button volumenBtn = new Button("Volumen");
		volumenBtn.setFont(new Font("Arial", Font.BOLD, 15));
		volumenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		volumenBtn.setBounds(20, 249, 119, 38);
		
		contentPane.add(volumenBtn);
		
		
		content.setBounds(181, 87, 441, 235);
		contentPane.add(content);

		Temperatura temperatura = new Temperatura();
		Volumen volumen = new Volumen();
		Longitud longitud = new Longitud();
		
	
	}
	

}
