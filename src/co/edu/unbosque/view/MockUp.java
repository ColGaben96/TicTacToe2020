package co.edu.unbosque.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;

public class MockUp {

	private JFrame tIctActoe;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MockUp window = new MockUp();
					window.tIctActoe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MockUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		tIctActoe = new JFrame();
		
		tIctActoe.setBackground(SystemColor.menuText);
		tIctActoe.setForeground(SystemColor.desktop);
		tIctActoe.getContentPane().setBackground(SystemColor.activeCaption);
		tIctActoe.setTitle("tIctActoe");
		tIctActoe.setBounds(100, 100, 804, 605);
		tIctActoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tIctActoe.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(48, 27, 162, 111);
		tIctActoe.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(15, 16, 132, 79);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		panel_1.setBounds(294, 27, 162, 111);
		tIctActoe.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(15, 16, 132, 79);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.window);
		panel_2.setBounds(44, 185, 166, 111);
		tIctActoe.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(15, 16, 136, 79);
		panel_2.add(textField_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.window);
		panel_3.setBounds(294, 185, 162, 111);
		tIctActoe.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(15, 16, 132, 79);
		panel_3.add(textField_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.window);
		panel_4.setBounds(44, 343, 166, 111);
		tIctActoe.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(15, 16, 136, 79);
		panel_4.add(textField_6);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.window);
		panel_5.setBounds(294, 343, 162, 111);
		tIctActoe.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(15, 16, 132, 79);
		panel_5.add(textField_7);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.window);
		panel_6.setBounds(534, 27, 162, 111);
		tIctActoe.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(15, 16, 132, 79);
		panel_6.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.window);
		panel_7.setBounds(534, 185, 162, 111);
		tIctActoe.getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(15, 16, 132, 79);
		panel_7.add(textField_5);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(SystemColor.window);
		panel_8.setBounds(534, 343, 162, 111);
		tIctActoe.getContentPane().add(panel_8);
		panel_8.setLayout(null);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(15, 16, 132, 79);
		panel_8.add(textField_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(SystemColor.activeCaption);
		panel_9.setBounds(240, 470, 293, 75);
		tIctActoe.getContentPane().add(panel_9);
		panel_9.setLayout(null);
		
		JButton btnJuego = new JButton("Juego");
		btnJuego.setBounds(89, 16, 115, 41);
		panel_9.add(btnJuego);
	}
}
