package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.controller.Controller;

import java.io.IOException;

/**
 * @author Gabriel Blanco & Ricardo Sanchez
 * Clase para definir la ventana principal
 */
public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private Dialogos dialogos = new Dialogos();
	private PanelTablero paneltablero = new PanelTablero();
	private PanelBoton panelboton = new PanelBoton();
	private ImageIcon img = new ImageIcon("./docs/Lib/cuadriculado2.png");
	private JLabel background;
	
	
	/**
	 * Método para iniciar la ventana principal
	 * @author Gabriel Blanco 
	 * @param control
	 */
	public void iniciar(Controller control) {
		cargar();
		addComponentes();
		escucharComponentes(control);
		this.validate();
		this.getDialogos().output("Advertencia", "Pasa el mouse por debajo de la casilla central inferior para que aparezca el botón de juego\n"
				+ "Nos disculpamos por el bug", JOptionPane.WARNING_MESSAGE);
	}
	/**
	 * Método para cargar la configuración de la ventana principal
	 * @author Gabriel Blanco & Ricardo Sanchez
	 */
	public void cargar() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		setTitle("tIctActoe");
		//setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		//Increible, pero se puede ingresar como un JLabel
    	background = new JLabel("", img, JLabel.CENTER);
    	background.setBounds(0, 0, 800, 600);
	}
	
	/**
	 * Método para añadir los componentes de la ventana principal
	 * @author Gabriel Blanco & Ricardo Sanchez 
	 */
	public void addComponentes() {
		//TODO: Añadir aquí los componentes
		add(background);
		add(paneltablero);
		add(panelboton);
	}
	
	/**
	 * Método para escuchar los componentes donde <pre>Controller</pre> va a manejar todas
	 * estas excepciones.
	 * @author Gabriel Blanco
	 * @param control
	 */
	public void escucharComponentes(Controller control) {
		//TODO: Poner aquí los ActionListener y comentar a que panel pertenece
		/*
		 * PanelBoton
		 */
		panelboton.getJuego().addActionListener(control);
	}
	
	/**
	 * @author Gabriel Blanco
	 * @return
	 * @throws IOException
	 */
	public String cargarArchivo() throws IOException {
		String path = "";
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", ".txt");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(chooser);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			path = chooser.getSelectedFile().getAbsolutePath();
			return path;
		} else {
			//No hace nada
			return null;
		}
	}
	
	/**
	 * Método para guardar un archivo via JFileChooser
	 * @author Gabriel Blanco 
	 * @param linea
	 * @throws IOException
	 */
	public String guardarArchivo() throws IOException {
		String path = "";
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", ".txt");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showSaveDialog(chooser);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			path = chooser.getSelectedFile().getAbsolutePath();
		} 
		else {
			//No hace nada
		}
		return path;
	}

	/**
	 * @author Ricardo Sanchez
	 * @return
	 */
	public Dialogos getDialogos() {
		return dialogos;
	}
	public PanelTablero getPaneltablero() {
		return paneltablero;
	}
	public void setPaneltablero(PanelTablero paneltablero) {
		this.paneltablero = paneltablero;
	}
	public PanelBoton getPanelboton() {
		return panelboton;
	}
	public void setPanelboton(PanelBoton panelboton) {
		this.panelboton = panelboton;
	}
	public void setDialogos(Dialogos dialogos) {
		this.dialogos = dialogos;
	}
	
	
}
