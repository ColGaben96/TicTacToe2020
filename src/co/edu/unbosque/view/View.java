package co.edu.unbosque.view;

import javax.swing.*;

import co.edu.unbosque.controller.Controller;

import java.awt.*;

/**
 * @author Gabriel Blanco
 * Clase para definir la ventana principal
 */
public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private Dialogos dialogos = new Dialogos();
	
	/**
	 * M�todo para iniciar la ventana principal
	 * @author Gabriel Blanco
	 * @param control
	 */
	public void iniciar(Controller control) {
		cargar();
		addComponentes();
		escucharComponentes(control);
	}
	/**
	 * M�todo para cargar la configuraci�n de la ventana principal
	 * @author Gabriel Blanco
	 */
	public void cargar() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		setTitle("TicTacToe");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setVisible(true);
	}
	
	/**
	 * M�todo para a�adir los componentes de la ventana principal
	 * @author Gabriel Blanco
	 */
	public void addComponentes() {
		//TODO: A�adir aqu� los componentes
		
	}
	
	/**
	 * M�todo para escuchar los componentes donde <pre>Controller</pre> va a manejar todas
	 * estas excepciones.
	 * @author Gabriel Blanco
	 * @param control
	 */
	public void escucharComponentes(Controller control) {
		//TODO: Poner aqu� los ActionListener y comentar a que panel pertenece
	}

	public Dialogos getDialogos() {
		return dialogos;
	}
}
