package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.GabenFile;
import co.edu.unbosque.model.persistence.GabenProperties;

/**
 * @author Gabriel Blanco
 * Clase "multitoma" donde se define la soluci�n de la problem�tica
 */
public class Mundo {
	private IA ia = new IA();
	private TicTacToe tictactoe = new TicTacToe();
	private GabenFile archivo = new GabenFile();
	private GabenProperties propiedad = new GabenProperties();
	private TicTacToe tictactoe = new TicTacToe();
	private IA ia = new IA();

	public GabenFile getArchivo() {
		return archivo;
	}

	public GabenProperties getPropiedad() {
		return propiedad;
	}

	public TicTacToe getTictactoe() {
		return tictactoe;
	}

	public IA getIa() {
		return ia;
	}
	
}
