package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.GabenFile;
import co.edu.unbosque.model.persistence.GabenProperties;

/**
 * @author Gabriel Blanco
 * Clase "multitoma" donde se define la soluci�n de la problem�tica
 */
public class Mundo {
	private GabenFile archivo = new GabenFile();
	private GabenProperties propiedad = new GabenProperties();

	public GabenFile getArchivo() {
		return archivo;
	}

	public GabenProperties getPropiedad() {
		return propiedad;
	}
}
