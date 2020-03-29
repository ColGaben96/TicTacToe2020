package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Mundo;
import co.edu.unbosque.view.View;

/**
 * @author Gabriel Blanco & Ricardo Sanchez Clase Controlador
 *
 */
public class Controller implements ActionListener {
	private int contador = 0;
	private String[] jugadascpu = new String[4];
	private String[] jugadasjug = new String[4];
	private Mundo mundo = new Mundo();
	private View view = new View();
	private boolean c1Enabled, c2Enabled, c3Enabled, c4Enabled, c5Enabled, c6Enabled, c7Enabled, c8Enabled, c9Enabled;

	/**
	 * Mï¿½todo Constructor del Controlador
	 * 
	 * @throws IOException
	 */
	public Controller() throws Exception {
		Consola();
		c1Enabled = true;
		c2Enabled = true;
		c3Enabled = true;
		c4Enabled = true;
		c5Enabled = true;
		c6Enabled = true;
		c7Enabled = true;
		c8Enabled = true;
		c9Enabled = true;
		// Estoy subiendo un cambio chimbo
	}

	/**
	 * Mï¿½todo para probar casos puntuales en consola
	 * 
	 * @throws IOException
	 */
	public void Consola() throws Exception {
		// Se inicializa gui aqui ya que es necesario para probar por via JOptionPane
		/*
		 * TODO: Buscar un mï¿½todo mas eficiente para mostrar TODOS los errores por
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
						+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.txt en donde aparece el detalle especï¿½fico del error causado.",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Mï¿½todo para iniciar la GUI
	 */
	public void GUI() throws Exception {
		try {
			view.iniciar(this);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			mundo.getArchivo().makeLog(errors.toString());
			view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
					+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.txt en donde aparece el detalle especï¿½fico del error causado.",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/*
	 * TODO: Poner los mï¿½todos a probar aqui
	 */

	/**
	 * @author Gabriel Blanco Método para validar que casillas sirven
	 */
	public void validarCasillasDisponibles() {
		/*
		 * NOTA: Solo usar de turno 2 para arriba. Por defecto todas deben estar
		 * habilitadas
		 */
		if (view.getPanelJuego().getPanelTablero().getPos11().isEditable()) {
			c1Enabled = true;
		} else {
			c1Enabled = false;
		}
		if (view.getPanelJuego().getPanelTablero().getPos12().isEditable()) {
			c2Enabled = true;
		} else {
			c2Enabled = false;
		}
		if (view.getPanelJuego().getPanelTablero().getPos13().isEditable()) {
			c3Enabled = true;
		} else {
			c3Enabled = false;
		}
		if (view.getPanelJuego().getPanelTablero().getPos21().isEditable()) {
			c4Enabled = true;
		} else {
			c4Enabled = false;
		}
		if (view.getPanelJuego().getPanelTablero().getPos22().isEditable()) {
			c5Enabled = true;
		} else {
			c5Enabled = false;
		}
		if (view.getPanelJuego().getPanelTablero().getPos23().isEditable()) {
			c6Enabled = true;
		} else {
			c6Enabled = false;
		}
		if (view.getPanelJuego().getPanelTablero().getPos31().isEditable()) {
			c7Enabled = true;
		} else {
			c7Enabled = false;
		}
		if (view.getPanelJuego().getPanelTablero().getPos32().isEditable()) {
			c8Enabled = true;
		} else {
			c8Enabled = false;
		}
		if (view.getPanelJuego().getPanelTablero().getPos33().isEditable()) {
			c9Enabled = true;
		} else {
			c9Enabled = false;
		}
	}

	/**
	 * @author Luis Ricardo Sanchez
	 * @param ActionEvent e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// TODO: Ingresar aquï¿½ las interacciones con Mundo

			if (e.getActionCommand() == view.getPanelJuego().getPanelBoton().OPERAR) {
				switch (contador) {
				case 0:
					validarTurno1();
					break;
				case 1:
					ValidarTurno2();
					break;
				case 2:
					validarTurno3();
					break;
				case 3:
					validarTurno4();
					break;
				}

			}
		}

		/*
		 * Estas lï¿½neas son para controlar en caso de que por falta de memoria no
		 * genere el log. Esto es vital para el programa ya que me permite llevar una
		 * trazabilidad
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
					+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.txt en donde aparece el detalle especï¿½fico del error causado.",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * @author Luis Ricardo Sanchez Este metodo valida el turno 1 y evita todos los
	 *         errores. realizar verificacion con randoms y borrar los JOptions de
	 *         prueba cuando se termine de probar
	 */
	public void validarTurno1() throws Exception{

		if (mundo.getTictactoe().isTurno() == false) {
			mundo.getTictactoe().turnos();
			// Pos11
			if (view.getPanelJuego().getPanelTablero().getPos11().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos11().setText("X");
				jugadasjug[0] = "00";
				view.getPanelJuego().getPanelTablero().getPos11().setEditable(false);
				if (view.getPanelJuego().getPanelTablero().getPos12().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos13().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos21().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos22().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos23().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")) {

					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 1, 0, 0, 0).subSequence(0, 2));
					String guardado = jugadascpu[0];
					mundo.getIa().defender(1, 1, 0, 0, 0).subSequence(0, 2);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos22().setText("O");
						view.getPanelJuego().getPanelTablero().getPos22().setEditable(false);
						mundo.getTictactoe().turnos();

					}
				} else if (!view.getPanelJuego().getPanelTablero().getPos11().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos11().setText("");

				}
			} else if (!view.getPanelJuego().getPanelTablero().getPos11().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos11().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos12().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos11().setText("");

			}
			// Pos12
			if (view.getPanelJuego().getPanelTablero().getPos12().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos12().setText("X");
				if (view.getPanelJuego().getPanelTablero().getPos11().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos13().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos21().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos22().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos23().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")) {

					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 2, 0, 0, 0).subSequence(0, 2));
					String guardado = jugadascpu[0];
					mundo.getIa().defender(1, 2, 0, 0, 0).subSequence(0, 2);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos11().setText("O");
						view.getPanelJuego().getPanelTablero().getPos11().setEditable(false);
						mundo.getTictactoe().turnos();

					}

				} else if (!view.getPanelJuego().getPanelTablero().getPos12().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos12().setText("");

				}
			} else if (!view.getPanelJuego().getPanelTablero().getPos12().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos12().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos12().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos12().setText("");
			}
			// Pos13
			if (view.getPanelJuego().getPanelTablero().getPos13().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos13().setText("X");
				if (view.getPanelJuego().getPanelTablero().getPos11().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos12().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos21().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos22().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos23().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")) {
					// TODO Se pone la condicion
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 3, 0, 0, 0).subSequence(0, 2));
					String guardado = jugadascpu[0];
					mundo.getIa().defender(1, 3, 0, 0, 0).subSequence(0, 2);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos22().setText("O");
						view.getPanelJuego().getPanelTablero().getPos22().setEditable(false);
						mundo.getTictactoe().turnos();

					}
				} else if (!view.getPanelJuego().getPanelTablero().getPos13().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos13().setText("");

				}
			} else if (!view.getPanelJuego().getPanelTablero().getPos13().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos13().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos13().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos13().setText("");
			}
			// Pos21
			if (view.getPanelJuego().getPanelTablero().getPos21().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos21().setText("X");
				if (view.getPanelJuego().getPanelTablero().getPos11().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos12().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos13().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos22().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos23().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")) {

					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 4, 0, 0, 0).subSequence(0, 2));
					String guardado = jugadascpu[0];
					mundo.getIa().defender(1, 4, 0, 0, 0).subSequence(0, 2);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos31().setText("O");
						view.getPanelJuego().getPanelTablero().getPos31().setEditable(false);
						mundo.getTictactoe().turnos();

					}
				} else if (!view.getPanelJuego().getPanelTablero().getPos21().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos21().setText("");

				}
			} else if (!view.getPanelJuego().getPanelTablero().getPos21().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos21().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos21().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos21().setText("");
			}
			// Pos22
			if (view.getPanelJuego().getPanelTablero().getPos22().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos22().setText("X");
				if (view.getPanelJuego().getPanelTablero().getPos11().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos12().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos13().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos21().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos23().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")) {

					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 5, 0, 0, 0).subSequence(0, 2));
					String guardado = jugadascpu[0];
					mundo.getIa().defender(1, 5, 0, 0, 0).subSequence(0, 2);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos13().setText("O");
						view.getPanelJuego().getPanelTablero().getPos13().setEditable(false);
						mundo.getTictactoe().turnos();

					}
				} else if (!view.getPanelJuego().getPanelTablero().getPos22().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos22().setText("");

				}
			} else if (!view.getPanelJuego().getPanelTablero().getPos22().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos22().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos22().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos22().setText("");
			}
			// Pos23
			if (view.getPanelJuego().getPanelTablero().getPos23().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos23().setText("X");
				if (view.getPanelJuego().getPanelTablero().getPos11().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos12().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos13().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos21().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos22().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")) {

					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 6, 0, 0, 0).subSequence(0, 2));
					String guardado = jugadascpu[0];
					mundo.getIa().defender(1, 6, 0, 0, 0).subSequence(0, 2);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos13().setText("O");
						view.getPanelJuego().getPanelTablero().getPos13().setEditable(false);
						mundo.getTictactoe().turnos();

					}
				} else if (!view.getPanelJuego().getPanelTablero().getPos23().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos23().setText("");

				}
			} else if (!view.getPanelJuego().getPanelTablero().getPos23().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos23().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos23().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos23().setText("");
			}
			// Pos31
			if (view.getPanelJuego().getPanelTablero().getPos31().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos31().setText("X");
				if (view.getPanelJuego().getPanelTablero().getPos11().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos12().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos13().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos21().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos22().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos23().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")) {

					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 7, 0, 0, 0).subSequence(0, 2));
					String guardado = jugadascpu[0];
					mundo.getIa().defender(1, 7, 0, 0, 0).subSequence(0, 2);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos22().setText("O");
						view.getPanelJuego().getPanelTablero().getPos22().setEditable(false);
						mundo.getTictactoe().turnos();

					}
				} else if (!view.getPanelJuego().getPanelTablero().getPos31().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos31().setText("");

				}
			} else if (!view.getPanelJuego().getPanelTablero().getPos31().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos31().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos31().setText("");
			}
			// Pos32
			if (view.getPanelJuego().getPanelTablero().getPos32().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos32().setText("X");
				if (view.getPanelJuego().getPanelTablero().getPos11().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos12().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos13().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos21().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos22().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos23().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")) {

					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 8, 0, 0, 0).subSequence(0, 2));
					String guardado = jugadascpu[0];
					mundo.getIa().defender(1, 8, 0, 0, 0).subSequence(0, 2);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos33().setText("O");
						view.getPanelJuego().getPanelTablero().getPos33().setEditable(false);
						mundo.getTictactoe().turnos();

					}
				} else if (!view.getPanelJuego().getPanelTablero().getPos32().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos32().setText("");

				}
			} else if (!view.getPanelJuego().getPanelTablero().getPos32().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos32().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos32().setText("");
			}
			// Pos33
			if (view.getPanelJuego().getPanelTablero().getPos33().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos33().setText("X");
				if (view.getPanelJuego().getPanelTablero().getPos11().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos12().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos13().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos21().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos22().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos23().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")) {

					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 9, 0, 0, 0).subSequence(0, 2));
					String guardado = jugadascpu[0];
					mundo.getIa().defender(1, 9, 0, 0, 0).subSequence(0, 2);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos22().setText("O");
						view.getPanelJuego().getPanelTablero().getPos22().setEditable(false);
						mundo.getTictactoe().turnos();

					}
				} else if (!view.getPanelJuego().getPanelTablero().getPos33().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos33().setText("");

				}
			} else if (!view.getPanelJuego().getPanelTablero().getPos33().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos33().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos33().setText("");
			}

		}
		contador++;
	}

	/**
	 * @author Luis Ricardo Sanchez Este metodo valida el turno 2 y evita todos los
	 *         errores. realizar verificacion con randoms y borrar los JOptions de
	 *         prueba cuando se termine de probar
	 */

	public void ValidarTurno2() throws Exception{
		validarCasillasDisponibles();
		if (!(c1Enabled || c2Enabled)) {
			
		}
		if (!(c1Enabled || c3Enabled)) {

		}
		if (!(c1Enabled || c4Enabled)) {

		}
		if (!(c1Enabled || c5Enabled)) {

		}
		if (!(c1Enabled || c6Enabled)) {

		}
		if (!(c1Enabled || c7Enabled)) {

		}
		if (!(c1Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c9Enabled)) {

		}
		if (!(c2Enabled || c3Enabled)) {

		}
		if (!(c2Enabled || c4Enabled)) {

		}
		if (!(c2Enabled || c5Enabled)) {

		}
		if (!(c2Enabled || c6Enabled)) {

		}
		if (!(c2Enabled || c7Enabled)) {

		}
		if (!(c2Enabled || c8Enabled)) {

		}
		if (!(c2Enabled || c9Enabled)) {

		}
		if (!(c3Enabled || c4Enabled)) {

		}
		if (!(c3Enabled || c5Enabled)) {

		}
		if (!(c3Enabled || c6Enabled)) {

		}
		if (!(c3Enabled || c7Enabled)) {

		}
		if (!(c3Enabled || c8Enabled)) {

		}
		if (!(c3Enabled || c9Enabled)) {

		}
		if (!(c4Enabled || c5Enabled)) {

		}
		if (!(c4Enabled || c6Enabled)) {

		}
		if (!(c4Enabled || c7Enabled)) {

		}
		if (!(c4Enabled || c8Enabled)) {

		}
		if (!(c4Enabled || c9Enabled)) {

		}
		if (!(c5Enabled || c6Enabled)) {

		}
		if (!(c5Enabled || c7Enabled)) {

		}
		if (!(c5Enabled || c8Enabled)) {

		}
		if (!(c5Enabled || c9Enabled)) {

		}
		if (!(c6Enabled || c7Enabled)) {

		}
		if (!(c6Enabled || c8Enabled)) {

		}
		if (!(c6Enabled || c9Enabled)) {

		}
		if (!(c7Enabled || c8Enabled)) {

		}
		if (!(c7Enabled || c9Enabled)) {

		}
		if (!(c8Enabled || c9Enabled)) {

		}
		contador++;
	}

	/**
	 * /**
	 * 
	 * @author Luis Ricardo Sanchez Este metodo valida el turno 3 y evita todos los
	 *         errores.
	 * 
	 */
	public void validarTurno3() throws Exception{
		validarCasillasDisponibles();
		if (!(c1Enabled || c2Enabled || c3Enabled || c4Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c5Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c6Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c7Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c4Enabled || c5Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c4Enabled || c6Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c4Enabled || c7Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c4Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c4Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c5Enabled || c6Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c5Enabled || c7Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c5Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c5Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c6Enabled || c7Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c6Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c6Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c3Enabled || c4Enabled || c5Enabled)) {

		}
		if (!(c1Enabled || c3Enabled || c4Enabled || c6Enabled)) {

		}
		if (!(c1Enabled || c3Enabled || c4Enabled || c7Enabled)) {

		}
		if (!(c1Enabled || c3Enabled || c4Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c3Enabled || c4Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c3Enabled || c5Enabled || c6Enabled)) {

		}
		if (!(c1Enabled || c3Enabled || c5Enabled || c7Enabled)) {

		}
		if (!(c1Enabled || c3Enabled || c5Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c3Enabled || c5Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c3Enabled || c6Enabled || c7Enabled)) {

		}
		if (!(c1Enabled || c3Enabled || c6Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c3Enabled || c6Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c3Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c3Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c3Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c4Enabled || c5Enabled || c6Enabled)) {

		}
		if (!(c1Enabled || c4Enabled || c5Enabled || c7Enabled)) {

		}
		if (!(c1Enabled || c4Enabled || c5Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c4Enabled || c5Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c4Enabled || c6Enabled || c7Enabled)) {

		}
		if (!(c1Enabled || c4Enabled || c6Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c4Enabled || c6Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c4Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c4Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c4Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c5Enabled || c6Enabled || c7Enabled)) {

		}
		if (!(c1Enabled || c5Enabled || c6Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c5Enabled || c6Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c5Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c5Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c5Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c6Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c6Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c6Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c7Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c2Enabled || c3Enabled || c4Enabled || c5Enabled)) {

		}
		if (!(c2Enabled || c3Enabled || c4Enabled || c6Enabled)) {

		}
		if (!(c2Enabled || c3Enabled || c4Enabled || c7Enabled)) {

		}
		if (!(c2Enabled || c3Enabled || c4Enabled || c8Enabled)) {

		}
		if (!(c2Enabled || c3Enabled || c4Enabled || c9Enabled)) {

		}
		if (!(c2Enabled || c3Enabled || c5Enabled || c6Enabled)) {

		}
		if (!(c2Enabled || c3Enabled || c5Enabled || c7Enabled)) {

		}
		if (!(c2Enabled || c3Enabled || c5Enabled || c8Enabled)) {

		}
		if (!(c2Enabled || c3Enabled || c5Enabled || c9Enabled)) {

		}
		if (!(c2Enabled || c3Enabled || c6Enabled || c7Enabled)) {

		}
		if (!(c2Enabled || c3Enabled || c6Enabled || c8Enabled)) {

		}
		if (!(c2Enabled || c3Enabled || c6Enabled || c9Enabled)) {

		}
		if (!(c2Enabled || c3Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c2Enabled || c3Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c2Enabled || c3Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c2Enabled || c4Enabled || c5Enabled || c6Enabled)) {

		}
		if (!(c2Enabled || c4Enabled || c5Enabled || c7Enabled)) {

		}
		if (!(c2Enabled || c4Enabled || c5Enabled || c8Enabled)) {

		}
		if (!(c2Enabled || c4Enabled || c5Enabled || c9Enabled)) {

		}
		if (!(c2Enabled || c4Enabled || c6Enabled || c7Enabled)) {

		}
		if (!(c2Enabled || c4Enabled || c6Enabled || c8Enabled)) {

		}
		if (!(c2Enabled || c4Enabled || c6Enabled || c9Enabled)) {

		}
		if (!(c2Enabled || c4Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c2Enabled || c4Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c2Enabled || c4Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c2Enabled || c5Enabled || c6Enabled || c7Enabled)) {

		}
		if (!(c2Enabled || c5Enabled || c6Enabled || c8Enabled)) {

		}
		if (!(c2Enabled || c5Enabled || c6Enabled || c9Enabled)) {

		}
		if (!(c2Enabled || c5Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c2Enabled || c5Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c2Enabled || c5Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c2Enabled || c6Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c2Enabled || c6Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c2Enabled || c6Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c2Enabled || c7Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c3Enabled || c4Enabled || c5Enabled || c6Enabled)) {

		}
		if (!(c3Enabled || c4Enabled || c5Enabled || c7Enabled)) {

		}
		if (!(c3Enabled || c4Enabled || c5Enabled || c8Enabled)) {

		}
		if (!(c3Enabled || c4Enabled || c5Enabled || c9Enabled)) {

		}
		if (!(c3Enabled || c4Enabled || c6Enabled || c7Enabled)) {

		}
		if (!(c3Enabled || c4Enabled || c6Enabled || c8Enabled)) {

		}
		if (!(c3Enabled || c4Enabled || c6Enabled || c7Enabled)) {

		}
		if (!(c3Enabled || c4Enabled || c6Enabled || c8Enabled)) {

		}
		if (!(c3Enabled || c4Enabled || c6Enabled || c9Enabled)) {

		}
		if (!(c3Enabled || c4Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c3Enabled || c4Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c3Enabled || c4Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c3Enabled || c5Enabled || c6Enabled || c7Enabled)) {

		}
		if (!(c3Enabled || c5Enabled || c6Enabled || c8Enabled)) {

		}
		if (!(c3Enabled || c5Enabled || c6Enabled || c9Enabled)) {

		}
		if (!(c3Enabled || c5Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c3Enabled || c5Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c3Enabled || c6Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c3Enabled || c6Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c3Enabled || c7Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c4Enabled || c5Enabled || c6Enabled || c7Enabled)) {

		}
		if (!(c4Enabled || c5Enabled || c6Enabled || c8Enabled)) {

		}
		if (!(c4Enabled || c5Enabled || c6Enabled || c9Enabled)) {

		}
		if (!(c4Enabled || c5Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c4Enabled || c5Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c4Enabled || c5Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c4Enabled || c6Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c4Enabled || c6Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c4Enabled || c6Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c4Enabled || c7Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c5Enabled || c6Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c5Enabled || c6Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c5Enabled || c6Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c5Enabled || c7Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c6Enabled || c7Enabled || c8Enabled || c9Enabled)) {

		}
		contador++;
	}

	/**
	 * @author Luis Ricardo Sanchez Este metodo valida el turno 4 y evita todos los
	 *         errores.
	 */
	public void validarTurno4() throws Exception{
		validarCasillasDisponibles();
		if (!(c1Enabled || c2Enabled || c3Enabled || c4Enabled || c5Enabled || c6Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c4Enabled || c5Enabled || c7Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c4Enabled || c5Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c4Enabled || c5Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c4Enabled || c6Enabled || c7Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c4Enabled || c6Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c4Enabled || c6Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c4Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c4Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c4Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c5Enabled || c6Enabled || c7Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c5Enabled || c6Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c5Enabled || c6Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c5Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c5Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c5Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c6Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c6Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c6Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c3Enabled || c7Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c4Enabled || c5Enabled || c6Enabled || c7Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c4Enabled || c5Enabled || c6Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c4Enabled || c5Enabled || c6Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c4Enabled || c5Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c4Enabled || c5Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c4Enabled || c5Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c4Enabled || c6Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c4Enabled || c6Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c4Enabled || c6Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c4Enabled || c7Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c5Enabled || c6Enabled || c7Enabled || c8Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c5Enabled || c6Enabled || c7Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c5Enabled || c6Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c5Enabled || c7Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c2Enabled || c6Enabled || c7Enabled || c8Enabled || c9Enabled)) {

		}
		if (!(c1Enabled || c3Enabled || c4Enabled || c5Enabled || c6Enabled || c7Enabled)) {

		}
		if (!(c1Enabled || c3Enabled || c4Enabled || c5Enabled || c6Enabled || c8Enabled)) {
			
		}
		if (!(c1Enabled || c3Enabled || c4Enabled || c5Enabled || c6Enabled || c9Enabled)) {
			
		}
		if (!(c1Enabled || c3Enabled || c4Enabled || c5Enabled || c7Enabled || c8Enabled)) {
			
		}
		if (!(c1Enabled || c3Enabled || c4Enabled || c5Enabled || c7Enabled || c9Enabled)) {
			
		}
		if (!(c1Enabled || c3Enabled || c4Enabled || c5Enabled || c8Enabled || c9Enabled)) {
			
		}
		if (!(c1Enabled || c3Enabled || c4Enabled || c6Enabled || c7Enabled || c8Enabled)) {
			
		}
		if (!(c1Enabled || c3Enabled || c4Enabled || c6Enabled || c7Enabled || c9Enabled)) {
			
		}
		if (!(c1Enabled || c3Enabled || c4Enabled || c6Enabled || c8Enabled || c9Enabled)) {
			
		}
		if (!(c1Enabled || c3Enabled || c4Enabled || c7Enabled || c8Enabled || c9Enabled)) {
			
		}
		if (!(c1Enabled || c3Enabled || c5Enabled || c6Enabled || c7Enabled || c8Enabled)) {
			
		}
		if (!(c1Enabled || c3Enabled || c5Enabled || c6Enabled || c7Enabled || c9Enabled)) {
			
		}
		if (!(c1Enabled || c3Enabled || c5Enabled || c6Enabled || c8Enabled || c9Enabled)) {
			
		}
		if (!(c1Enabled || c3Enabled || c5Enabled || c7Enabled || c8Enabled || c9Enabled)) {
			
		}
		if (!(c1Enabled || c3Enabled || c6Enabled || c7Enabled || c8Enabled || c9Enabled)) {
			
		}
		if (!(c1Enabled || c4Enabled || c5Enabled || c6Enabled || c7Enabled || c8Enabled)) {
			
		}
		if (!(c1Enabled || c4Enabled || c5Enabled || c6Enabled || c7Enabled || c9Enabled)) {
			
		}
		if (!(c1Enabled || c4Enabled || c5Enabled || c6Enabled || c8Enabled || c9Enabled)) {
			
		}
		if (!(c1Enabled || c4Enabled || c5Enabled || c7Enabled || c8Enabled || c9Enabled)) {
			
		}
		if (!(c1Enabled || c5Enabled || c6Enabled || c7Enabled || c8Enabled || c9Enabled)) {
			
		}
		if (!(c2Enabled || c3Enabled || c4Enabled || c5Enabled || c6Enabled || c7Enabled)) {
			
		}
		if (!(c2Enabled || c3Enabled || c4Enabled || c5Enabled || c6Enabled || c8Enabled)) {
			
		}
		if (!(c2Enabled || c3Enabled || c4Enabled || c5Enabled || c6Enabled || c9Enabled)) {
			
		}
		if (!(c2Enabled || c3Enabled || c4Enabled || c5Enabled || c7Enabled || c8Enabled)) {
			
		}
		if (!(c2Enabled || c3Enabled || c4Enabled || c5Enabled || c7Enabled || c9Enabled)) {
			
		}
		if (!(c2Enabled || c3Enabled || c4Enabled || c5Enabled || c8Enabled || c9Enabled)) {
			
		}
		if (!(c2Enabled || c3Enabled || c4Enabled || c6Enabled || c7Enabled || c8Enabled)) {
			
		}
		if (!(c2Enabled || c3Enabled || c4Enabled || c6Enabled || c7Enabled || c9Enabled)) {
			
		}
		if (!(c2Enabled || c3Enabled || c4Enabled || c6Enabled || c8Enabled || c9Enabled)) {
			
		}
		if (!(c2Enabled || c3Enabled || c4Enabled || c7Enabled || c8Enabled || c9Enabled)) {
			
		}
		if (!(c2Enabled || c3Enabled || c5Enabled || c6Enabled || c7Enabled || c8Enabled)) {
			
		}
		if (!(c2Enabled || c3Enabled || c5Enabled || c6Enabled || c7Enabled || c9Enabled)) {
			
		}
		if (!(c2Enabled || c3Enabled || c5Enabled || c6Enabled || c8Enabled || c9Enabled)) {
			
		}
		if (!(c2Enabled || c3Enabled || c5Enabled || c7Enabled || c8Enabled || c9Enabled)) {
			
		}
		if (!(c2Enabled || c4Enabled || c5Enabled || c6Enabled || c7Enabled || c8Enabled)) {
			
		}
		if (!(c2Enabled || c4Enabled || c5Enabled || c6Enabled || c7Enabled || c9Enabled)) {
			
		}
		if (!(c2Enabled || c4Enabled || c5Enabled || c6Enabled || c8Enabled || c9Enabled)) {
			
		}
		if (!(c2Enabled || c4Enabled || c5Enabled || c7Enabled || c8Enabled || c9Enabled)) {
			
		}
		if (!(c2Enabled || c4Enabled || c6Enabled || c7Enabled || c8Enabled || c9Enabled)) {
			
		}
		if (!(c2Enabled || c5Enabled || c6Enabled || c7Enabled || c8Enabled || c9Enabled)) {
			
		}
		if (!(c3Enabled || c4Enabled || c5Enabled || c7Enabled || c8Enabled || c9Enabled)) {
			
		}
		contador++;
	}

}
