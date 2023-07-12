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
import javax.swing.JLabel;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JPanel content;

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
		setTitle("Conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 453);
		content = new JPanel();
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
				   showPanel(moneda);
			
			}
		});
		monedaBtn.setBounds(20, 87, 119, 38);
		contentPane.add(monedaBtn);

		Button temperaturaBtn = new Button("Temperatura\r\n");
		temperaturaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   Temperatura temperatura = new Temperatura();
				   showPanel(temperatura);
			}
		});
		temperaturaBtn.setFont(new Font("Arial", Font.BOLD, 15));
		temperaturaBtn.setBounds(20, 141, 119, 38);
		contentPane.add(temperaturaBtn);

		Button longitudBtn = new Button("Longitud");
		longitudBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   Longitud longitud = new Longitud();
				   showPanel(longitud);
			}

		});

		longitudBtn.setFont(new Font("Arial", Font.BOLD, 15));
		longitudBtn.setBounds(20, 197, 119, 38);
		contentPane.add(longitudBtn);

		Button volumenBtn = new Button("Volumen");
		volumenBtn.setFont(new Font("Arial", Font.BOLD, 15));
		volumenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   Volumen volumen = new Volumen();
				   showPanel(volumen);
			}
		});
		
		
		volumenBtn.setBounds(20, 249, 119, 38);

		contentPane.add(volumenBtn);

	
		content.setBounds(176, 87, 502, 305);
		contentPane.add(content);
		content.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BIENVENIDO A SU \r\nCONVERSOR DE \r\nUNIDADES");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(20, 11, 482, 104);
		content.add(lblNewLabel);
		
		JLabel lblElijaUnaUnidad = new JLabel("ELIJA UNA UNIDAD PARA COMENZAR");
		lblElijaUnaUnidad.setFont(new Font("Arial", Font.BOLD, 20));
		lblElijaUnaUnidad.setBounds(58, 73, 492, 104);
		content.add(lblElijaUnaUnidad);

		Temperatura temperatura = new Temperatura();
		Volumen volumen = new Volumen();
		Longitud longitud = new Longitud();

	}
	private void showPanel(JPanel p) {
        p.setSize(500, 420);

        content.removeAll();
        content.setLayout(new BorderLayout()); // Establece un layout en el content JPanel
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
	}
}
