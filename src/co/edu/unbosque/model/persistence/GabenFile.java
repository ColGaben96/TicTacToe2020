package co.edu.unbosque.model.persistence;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Gabriel Blanco Clase para usar Archivos. Usar leerArchivo() para leer
 *         archivos y escribirArchivo() para escribirlos. Suena redudante pero
 *         funciona
 */
public class GabenFile {

	private File carpetaDocs = new File("./docs");
	private File carpetaOutput = new File("./docs/Output");

	public GabenFile() {
		if (!carpetaDocs.exists())
			carpetaDocs.mkdir();
		if (!carpetaOutput.exists())
			carpetaOutput.mkdir();
	}

	/**
	 * Método para leer un archivo
	 * 
	 * @author Gabriel Blanco
	 * @param ubicacion
	 * @return
	 * @throws IOException
	 */
	public String leerArchivo(String ubicacion) throws IOException {
		String pastLine = "";
		File archivoAyuda = new File(ubicacion);
		FileReader reader = new FileReader(archivoAyuda);
		BufferedReader buffer = new BufferedReader(reader);
		String ayuda = buffer.readLine();
		while (ayuda != null) {
			pastLine += ayuda + "\n";
			ayuda = buffer.readLine();
		}
		reader.close();
		return pastLine;
	}

	/**
	 * Método para sobreescribir un archivo. Va al final del archivo y escribe la
	 * nueva informacion.
	 * 
	 * @author Gabriel Blanco
	 * @param linea
	 * @param ubicacion
	 * @throws IOException
	 */
	public void sobreescribirArchivo(String linea, String ubicacion) throws IOException {
		File file = new File(ubicacion);
		FileWriter writer = new FileWriter(file, true);
		PrintWriter printer = new PrintWriter(writer);
		printer.println(linea);
		writer.close();
	}

	/**
	 * Método para escribir un archivo. <b>ADVERTENCIA!</b> Si esta pensando en usar
	 * este método para sobreescribir un archivo, va a borrar el contenido de este e
	 * ingresar uno nuevo. Usar
	 * 
	 * <pre>
	 * sobreescribirArchivo(linea, ubicacion)
	 * </pre>
	 * 
	 * en ese caso.
	 * 
	 * @author Gabriel Blanco
	 * @param linea
	 * @param ubicacion
	 * @throws IOException
	 */
	public void escribirArchivo(String linea, String ubicacion) throws IOException {
		File file = new File(ubicacion);
		FileWriter writer = new FileWriter(file);
		PrintWriter printer = new PrintWriter(writer);
		printer.println(linea);
		writer.close();
	}

	/**
	 * Método para guardar un log con las excepciones.
	 * 
	 * @author Gabriel Blanco
	 * @param linea
	 * @throws IOException
	 */
	public void makeLog(String linea) throws IOException {
		Date date = new Date();
		SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat date2f = new SimpleDateFormat("HH:mm:ss");
		File myLog = new File(carpetaOutput + "/myLog " + datef.format(date) + ".txt");
		if (!myLog.exists()) {
			escribirArchivo(
					"An exception has occured on " + date2f.format(date) + "\n===================================\n"
							+ linea + "\n" + "===================================\n",
					carpetaOutput + "/myLog " + datef.format(date) + ".txt");
		} else {
			sobreescribirArchivo(
					"An exception has occured on " + date2f.format(date) + "\n===================================\n"
							+ linea + "\n" + "===================================\n",
					carpetaOutput + "/myLog " + datef.format(date) + ".txt");
		}
	}

}
