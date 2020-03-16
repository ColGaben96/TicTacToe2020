package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.controller.Controller;

import java.awt.*;
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
	
	
	/**
	 * Método para iniciar la ventana principal
	 * @author Gabriel Blanco 
	 * @param control
	 */
	public void iniciar(Controller control) {
		cargar();
		addComponentes();
		escucharComponentes(control);
	}
	/**
	 * Método para cargar la configuración de la ventana principal
	 * @author Gabriel Blanco & Ricardo Sanchez
	 */
	public void cargar() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		setTitle("tIctActoe");
		setBackground(SystemColor.activeCaption);
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
	
}
