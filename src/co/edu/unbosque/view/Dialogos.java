package co.edu.unbosque.view;

import java.io.InputStream;

import javax.swing.JOptionPane;

/**
 * @author Gabriel Blanco Clase para mostrar los diálogos
 */
public class Dialogos {

	/**
	 * Método utilizado para la entrada del usuario
	 * 
	 * @param systemIn
	 * @param title
	 * @param message
	 * @param messageType
	 * @return
	 */
	public String input(InputStream systemIn, String title, String message, int messageType) {
		return JOptionPane.showInputDialog(null, message, title, messageType);
	}

	/**
	 * Método utilizado para la salida del sistema
	 * 
	 * @param title
	 * @param message
	 * @param messageType
	 */
	public void output(String title, String message, int messageType) {
		JOptionPane.showMessageDialog(null, message, title, messageType);
	}

	/**
	 * Método para mostrar la ayuda del funcionamiento del programa al usuario
	 * 
	 * @return
	 */
	public String ayuda() {
		return "0. Salir\n"
				+ "1. Cargar GUI\n";
	}

}
