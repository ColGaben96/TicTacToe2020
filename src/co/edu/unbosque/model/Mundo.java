package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.GabenFile;
import co.edu.unbosque.model.persistence.GabenProperties;

/**
 * @author Gabriel Blanco
 * Clase "multitoma" donde se define la solución de la problemática
 */
public class Mundo {
	private IA ia = new IA();
	private TicTacToe tictactoe = new TicTacToe();
	private GabenFile archivo = new GabenFile();
	private GabenProperties propiedad = new GabenProperties();

	public GabenFile getArchivo() {
		return archivo;
	}

	public GabenProperties getPropiedad() {
		return propiedad;
	}

	public IA getIa() {
		return ia;
	}

	public TicTacToe getTictactoe() {
		return tictactoe;
	}
	
	
}
