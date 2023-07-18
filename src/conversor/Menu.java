
//CARLOS DANIEL LÓPEZ GONZÁLEZ
//15/07/2023
//CONVERSOR DE TEMPERATURA Y MONEDAS PARA EL PROGRAMA ONE

package conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.Label;
import java.awt.ScrollPane;
import java.awt.Choice;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
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
		this.setLocationRelativeTo(this);
		setTitle("Conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 576);
		content = new JPanel();
		content.setBackground(new Color(255, 255, 255));
		contentPane = new JPanel();
	     contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		content.setBounds(188, 111, 493, 426);
		contentPane.add(content);
		content.setLayout(null);

		JLabel iconoConversor = new JLabel("");
		iconoConversor.setIcon(new ImageIcon(Menu.class.getResource("/com/imagenes/conversor.png")));
//		setImageLabel(iconoConversor,"/com/imagenes/conversor.png");
		iconoConversor.setBounds(71, 401, 400, -358);
		content.add(iconoConversor);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/com/imagenes/conversor.png")));
		lblNewLabel.setBounds(0, 0, 493, 426);
		content.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(0, 111, 189, 426);
		contentPane.add(panel);
		panel.setBackground(new Color(219, 238, 241));
		panel.setForeground(new Color(0, 0, 0));
		panel.setLayout(null);

		Button temperaturaBtn = new Button("Temperatura\r\n");
		temperaturaBtn.setBounds(25, 91, 115, 43);
		panel.add(temperaturaBtn);
		temperaturaBtn.setBackground(new Color(255, 255, 255));
		temperaturaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Temperatura temperatura = new Temperatura();
				showPanel(temperatura);
			}
		});
		temperaturaBtn.setFont(new Font("Arial", Font.BOLD, 15));

		Button monedaBtn = new Button("Moneda");
		monedaBtn.setBounds(25, 244, 115, 43);
		panel.add(monedaBtn);

		monedaBtn.setBackground(new Color(255, 255, 255));
		monedaBtn.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {

			}
		});

		monedaBtn.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-77, 0, 758, 111);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/com/imagenes/encabezado2.png")));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBackground(Color.WHITE);

		monedaBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Moneda moneda = new Moneda();
				showPanel(moneda);

			}
		});

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
	private void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT ));
		labelName.setIcon(icon);
		this.repaint();
		
	}
}
