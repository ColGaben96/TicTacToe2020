package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.IA;
import co.edu.unbosque.model.Mundo;
import co.edu.unbosque.view.View;

/**
 * @author Gabriel Blanco Clase Controlador
 *
 */
public class Controller implements ActionListener {

	private Mundo mundo = new Mundo();
	private View view = new View();

	/**
	 * Método Constructor del Controlador
	 * 
	 * @throws IOException
	 */
	public Controller() throws Exception {
		Consola();
		// Estoy subiendo un cambio chimbo
	}

	/**
	 * Método para probar casos puntuales en consola
	 * 
	 * @throws IOException
	 */
	public void Consola() throws Exception {
		// Se inicializa gui aqui ya que es necesario para probar por via JOptionPane
		/*
		 * TODO: Buscar un método mas eficiente para mostrar TODOS los errores por
		 * JOptionPane
		 */
		boolean activo = true;
		while (activo) {
			try {
				int comando = Integer.parseInt(view.getDialogos().input(System.in, "TicTacToe 2020:Debugger",
						view.getDialogos().ayuda(), JOptionPane.PLAIN_MESSAGE));
				switch (comando) {
				default:
					view.getDialogos().output("Error", "Bad command!", JOptionPane.ERROR_MESSAGE);
					break;
				case 0:
					activo = false;
					break;
				case 1:
					activo = false;
					GUI();
					break;
				}
			} catch (Exception e) {
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				mundo.getArchivo().makeLog(errors.toString());
				view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
						+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.txt en donde aparece el detalle específico del error causado.",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Método para iniciar la GUI
	 */
	public void GUI() throws Exception {
		try {
			view.iniciar(this);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			mundo.getArchivo().makeLog(errors.toString());
			view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
					+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.txt en donde aparece el detalle específico del error causado.",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/*
	 * TODO: Poner los métodos a probar aqui
	 */
	public void IA(int holi) {
		IA ia = new IA();
		ia.defender(holi);
	}

	/**
	 * @author Luis Ricardo Sanchez
	 * @param ActionEvent e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// TODO: Ingresar aquí las interacciones con Mundo

			boolean jugando = true;
			validarletraingresada();

			while (jugando) {

				jugando = false;
			}
		}
		/*
		 * Estas líneas son para controlar en caso de que por falta de memoria no genere
		 * el log. Esto es vital para el programa ya que me permite llevar una trazabilidad
		 */
		catch (Exception e2) {
			StringWriter errors = new StringWriter();
			e2.printStackTrace(new PrintWriter(errors));
			try {
				mundo.getArchivo().makeLog(errors.toString());
			} catch (IOException e1) {
				view.getDialogos().output("Error Fatal",
						"Ha ocurrido un error inesperado donde se debe salir del programa.\nMotivo: Error creando el log de archivos",
						JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
			view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
					+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.txt en donde aparece el detalle específico del error causado.",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void validarletraingresada() {
		if (view.getPanelJuego().getPanelTablero().getPos11().getText().equals("x")) {
			view.getPanelJuego().getPanelTablero().getPos11().setText("X");

		}
		if (!view.getPanelJuego().getPanelTablero().getPos11().getText().equals("x")
				&& !view.getPanelJuego().getPanelTablero().getPos11().getText().equals("X")) {
			view.getPanelJuego().getPanelTablero().getPos11().setText("");
			view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
		}

		if (view.getPanelJuego().getPanelTablero().getPos12().getText().equals("x")) {
			view.getPanelJuego().getPanelTablero().getPos12().setText("X");

		}
		if (!view.getPanelJuego().getPanelTablero().getPos12().getText().equals("x")
				&& !view.getPanelJuego().getPanelTablero().getPos12().getText().equals("X")) {
			view.getPanelJuego().getPanelTablero().getPos12().setText("");
			view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
		}

		if (view.getPanelJuego().getPanelTablero().getPos13().getText().equals("x")) {
			view.getPanelJuego().getPanelTablero().getPos13().setText("X");

		}
		if (!view.getPanelJuego().getPanelTablero().getPos13().getText().equals("x")
				&& !view.getPanelJuego().getPanelTablero().getPos13().getText().equals("X")) {
			view.getPanelJuego().getPanelTablero().getPos13().setText("");
			view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
		}

		if (view.getPanelJuego().getPanelTablero().getPos21().getText().equals("x")) {
			view.getPanelJuego().getPanelTablero().getPos21().setText("X");
		}
		if (!view.getPanelJuego().getPanelTablero().getPos21().getText().equals("x")
				&& !view.getPanelJuego().getPanelTablero().getPos21().getText().equals("X")) {
			view.getPanelJuego().getPanelTablero().getPos21().setText("");
			view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
		}

		if (view.getPanelJuego().getPanelTablero().getPos22().getText().equals("x")) {
			view.getPanelJuego().getPanelTablero().getPos22().setText("X");
		}
		if (!view.getPanelJuego().getPanelTablero().getPos22().getText().equals("x")
				&& !view.getPanelJuego().getPanelTablero().getPos22().getText().equals("X")) {
			view.getPanelJuego().getPanelTablero().getPos22().setText("");
			view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
		}

		if (view.getPanelJuego().getPanelTablero().getPos23().getText().equals("x")) {
			view.getPanelJuego().getPanelTablero().getPos23().setText("X");
		}
		if (!view.getPanelJuego().getPanelTablero().getPos23().getText().equals("x")
				&& !view.getPanelJuego().getPanelTablero().getPos23().getText().equals("X")) {
			view.getPanelJuego().getPanelTablero().getPos23().setText("");
			view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
		}

		if (view.getPanelJuego().getPanelTablero().getPos31().getText().equals("x")) {
			view.getPanelJuego().getPanelTablero().getPos31().setText("X");
		}
		if (!view.getPanelJuego().getPanelTablero().getPos31().getText().equals("x")
				&& !view.getPanelJuego().getPanelTablero().getPos31().getText().equals("X")) {
			view.getPanelJuego().getPanelTablero().getPos31().setText("");
			view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
		}

		if (view.getPanelJuego().getPanelTablero().getPos32().getText().equals("x")) {
			view.getPanelJuego().getPanelTablero().getPos32().setText("X");
		}
		if (!view.getPanelJuego().getPanelTablero().getPos32().getText().equals("x")
				&& !view.getPanelJuego().getPanelTablero().getPos32().getText().equals("X")) {
			view.getPanelJuego().getPanelTablero().getPos32().setText("");
			view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
		}

		if (view.getPanelJuego().getPanelTablero().getPos33().getText().equals("x")) {
			view.getPanelJuego().getPanelTablero().getPos33().setText("X");
		}
		if (!view.getPanelJuego().getPanelTablero().getPos33().getText().equals("x")
				&& !view.getPanelJuego().getPanelTablero().getPos33().getText().equals("X")) {
			view.getPanelJuego().getPanelTablero().getPos33().setText("");
			view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
		}

	}

}