package co.edu.unbosque.model.persistence;

/**
 * @author Gabriel Blanco Clase para usar propiedades
 */

import java.io.*;
import java.util.Properties;

public class GabenProperties {
	private Properties property = new Properties();

	/**
	 * Método para escribir la propiedad
	 * 
	 * @author Gabriel Blanco
	 * @param key
	 * @param value
	 * @param location
	 * @param comments
	 * @throws IOException
	 */
	public void escribirPropiedad(String key, String value, String location, String comments) throws IOException {
		property.setProperty(key, value);
		property.store(new FileOutputStream(location), comments);
	}

	/**
	 * Método para leer la propiedad
	 * 
	 * @author Gabriel Blanco
	 * @param location
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String leerPropiedad(String location, String key) throws IOException {
		String linea = "";
		property.load(new FileInputStream(location));
		linea += property.getProperty(key);
		return linea;

	}
}
