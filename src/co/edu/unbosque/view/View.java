package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.controller.Controller;
//import marvin.gui.MarvinImagePanel;
//import marvin.image.MarvinImage;
//import marvin.io.MarvinImageIO;

import java.awt.*;
import java.io.IOException;

/**
 * @author Gabriel Blanco & Ricardo Sanchez
 * Clase para definir la ventana principal
 */
public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private Dialogos dialogos = new Dialogos();
	private PanelJuego panelJuego = new PanelJuego();
	private BufferedImage img;
	private MarvinImage img;
	//private MarvinImagePanel marvinPanel = new MarvinImagePanel();
	//private ImageIcon image;
	//private JLabel background;
	
	
	/**
	 * Método para iniciar la ventana principal
	 * @author Gabriel Blanco 
	 * @param control
	 */
	public void iniciar(Controller control) {
		try {
			cargar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addComponentes();
		escucharComponentes(control);
		//this.validate();
		/*this.getDialogos().output("Advertencia", "Pasa el mouse por debajo de la casilla central inferior para que aparezca el botón de juego\n"
				+ "Nos disculpamos por el bug", JOptionPane.WARNING_MESSAGE);
				*/
	}
	/**
	 * Método para cargar la configuración de la ventana principal
	 * @author Gabriel Blanco & Ricardo Sanchez
	 */
	public void cargar() throws Exception {
		img = MarvinImageIO.loadImage("./docs/Lib/cuadriculado2.png");
		marvinPanel.setImage(img);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		setTitle("tIctActoe");
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	/**
	 * Método para añadir los componentes de la ventana principal
	 * @author Gabriel Blanco & Ricardo Sanchez 
	 */
	public void addComponentes() {
		//TODO: Añadir aquí los componentes
	//	add(marvinPanel);
		add(panelJuego);
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
		panelJuego.getPanelBoton().getJuego().addActionListener(control);
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
	
	public PanelJuego getPanelJuego() {
		return panelJuego;
	}
	public void setDialogos(Dialogos dialogos) {
		this.dialogos = dialogos;
	}
	
	
	
	
}
