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
	private int guardado=0;
	private int contador = 0;
	private int[] jugadascpu = new int[4];
	private int[] jugadasjug = new int[4];
	private int[] ultimajug = new int[4];
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
		
		jugadasjug[0]=0;
		jugadasjug[1]=0;
		jugadasjug[2]=0;
		jugadasjug[3]=0;
		
		jugadascpu[0]=0;
		jugadascpu[1]=0;
		jugadascpu[2]=0;
		jugadascpu[3]=0;
		
		ultimajug[0]=0;
		ultimajug[1]=0;
		ultimajug[2]=0;
		ultimajug[3]=0;
		
		
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

	public void jugarCelda(int celda) {

		/*
		 * El método coloca la jugada de la cpu en la celda del grafico que corresponda
		 * con la jugada realizada por IA.
		 */
		
		switch (celda) {
		case 1:
			view.getPanelJuego().getPanelTablero().getPos11().setText("O");
			view.getPanelJuego().getPanelTablero().getPos11().setEditable(false);
			System.out.println("Entro campo 1: " + celda);
			break;
		case 2:
			view.getPanelJuego().getPanelTablero().getPos12().setText("O");
			view.getPanelJuego().getPanelTablero().getPos12().setEditable(false);
			System.out.println("Entro campo 2: " + celda);
			break;
		case 3:
			view.getPanelJuego().getPanelTablero().getPos13().setText("O");
			view.getPanelJuego().getPanelTablero().getPos13().setEditable(false);
			System.out.println("Entro campo 3: " + celda);
			break;
		case 4:
			view.getPanelJuego().getPanelTablero().getPos21().setText("O");
			view.getPanelJuego().getPanelTablero().getPos21().setEditable(false);
			System.out.println("Entro campo 4: " + celda);
			break;
		case 5:
			view.getPanelJuego().getPanelTablero().getPos22().setText("O");
			view.getPanelJuego().getPanelTablero().getPos22().setEditable(false);
			System.out.println("Entro campo 5: " + celda);
			break;
		case 6:
			view.getPanelJuego().getPanelTablero().getPos23().setText("O");
			view.getPanelJuego().getPanelTablero().getPos23().setEditable(false);
			System.out.println("Entro campo 6: " + celda);
			break;
		case 7:
			view.getPanelJuego().getPanelTablero().getPos31().setText("O");
			view.getPanelJuego().getPanelTablero().getPos31().setEditable(false);
			System.out.println("Entro campo 7: " + celda);
			break;
		case 8:
			view.getPanelJuego().getPanelTablero().getPos32().setText("O");
			view.getPanelJuego().getPanelTablero().getPos32().setEditable(false);
			System.out.println("Entro campo 8: " + celda);
			break;
		case 9:
			view.getPanelJuego().getPanelTablero().getPos33().setText("O");
			view.getPanelJuego().getPanelTablero().getPos33().setEditable(false);
			System.out.println("Entro campo 9: " + celda);
			break;
		default:
			break;
		}
		
	
	}
	
	public boolean ultima(int pos) {
		boolean jugada=true;
		
		for(int i=0 ; i<=3 ; i++) {
			if(ultimajug[i] == pos) {jugada=false;}
		}
		
		return jugada;
	}
	
	public void imprimirResultados() {
		for(int i=0 ; i<=3 ; i++) {
			System.out.println(" Jugador " + i + " = " + jugadasjug[i]  + " Jugada CPU="+i+" = " + jugadascpu[i] );
			
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
			// System.out.println("Contador antes del if = " + contador);
			if (e.getActionCommand() == view.getPanelJuego().getPanelBoton().OPERAR) {

				switch (contador) {
				case 0:
					System.out.println("Contador en opcion cero = " + contador);
					validarTurno1();
					break;
				case 1:
					System.out.println("Contador en opcion uno = " + contador);
					ValidarTurno2();
					break;
				case 2:
					System.out.println("Contador en opcion dos = " + contador);
					validarTurno3();
					break;
				case 3:
					System.out.println("Contador en opcion tres = " + contador);
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
	public void validarTurno1() throws Exception {
		
		if (mundo.getTictactoe().isTurno() == false) {
			mundo.getTictactoe().turnos();
			// Pos11
			if (view.getPanelJuego().getPanelTablero().getPos11().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos11().setText("X");
				jugadasjug[0] = 1;
				view.getPanelJuego().getPanelTablero().getPos11().setEditable(false);

				jugadascpu[0] = mundo.getIa().defender(1, jugadasjug[0], jugadasjug[1], jugadasjug[2], jugadasjug[3], 0, 0, 0);
				
			    guardado = jugadascpu[0];
				
			        jugarCelda(guardado);
			        ultimajug[0]=1;
					mundo.getTictactoe().turnos();

			} else if (!view.getPanelJuego().getPanelTablero().getPos11().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos11().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos12().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos11().setText("");

			}
			// Pos12
			if (view.getPanelJuego().getPanelTablero().getPos12().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos12().setText("X");
				
				    jugadasjug[0]=2;
					jugadascpu[0] = mundo.getIa().defender(1, jugadasjug[0], jugadasjug[1], jugadasjug[2], jugadasjug[3], 0, 0, 0);
					guardado = jugadascpu[0];
				
						jugarCelda(guardado);
						 ultimajug[0]=2;
						mundo.getTictactoe().turnos();

			} else if (!view.getPanelJuego().getPanelTablero().getPos12().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos12().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos12().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos12().setText("");
			}
			// Pos13
			if (view.getPanelJuego().getPanelTablero().getPos13().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos13().setText("X");
				    jugadasjug[0]=3;
					// TODO Se pone la condicion
					jugadascpu[0] = mundo.getIa().defender(1, jugadasjug[0], jugadasjug[1], jugadasjug[2], jugadasjug[3], 0, 0, 0);
				    guardado = jugadascpu[0];
				
				        jugarCelda(guardado);
				        ultimajug[0]=3;
						mundo.getTictactoe().turnos();

			} else if (!view.getPanelJuego().getPanelTablero().getPos13().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos13().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos13().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos13().setText("");
			}
			// Pos21
			if (view.getPanelJuego().getPanelTablero().getPos21().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos21().setText("X");
				
                    jugadasjug[0]=4;
					jugadascpu[0] = mundo.getIa().defender(1, jugadasjug[0], jugadasjug[1], jugadasjug[2], jugadasjug[3], 0, 0, 0);
					guardado = jugadascpu[0];
					
						jugarCelda(guardado);
						 ultimajug[0]=4;
						mundo.getTictactoe().turnos();

			} else if (!view.getPanelJuego().getPanelTablero().getPos21().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos21().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos21().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos21().setText("");
			}
			// Pos22
			if (view.getPanelJuego().getPanelTablero().getPos22().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos22().setText("X");
				
				    jugadasjug[0]=5;
					jugadascpu[0] = mundo.getIa().defender(1, jugadasjug[0], jugadasjug[1], jugadasjug[2], jugadasjug[3], 0, 0, 0);
					guardado = jugadascpu[0];
			
						jugarCelda(guardado);
						 ultimajug[0]=5;
						mundo.getTictactoe().turnos();

			} else if (!view.getPanelJuego().getPanelTablero().getPos22().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos22().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos22().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos22().setText("");
			}
			// Pos23
			if (view.getPanelJuego().getPanelTablero().getPos23().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos23().setText("X");
				    jugadasjug[0]=6;
					jugadascpu[0] = mundo.getIa().defender(1, jugadasjug[0], jugadasjug[1], jugadasjug[2], jugadasjug[3], 0, 0, 0);
					guardado = jugadascpu[0];
				
						jugarCelda(guardado);
						 ultimajug[0]=6;
						mundo.getTictactoe().turnos();

			} else if (!view.getPanelJuego().getPanelTablero().getPos23().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos23().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos23().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos23().setText("");
			}
			// Pos31
			if (view.getPanelJuego().getPanelTablero().getPos31().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos31().setText("X");
				
			     	jugadasjug[0]=7;
					jugadascpu[0] = mundo.getIa().defender(1, jugadasjug[0], jugadasjug[1], jugadasjug[2], jugadasjug[3], 0, 0, 0);
				    guardado = jugadascpu[0];
					
				        jugarCelda(guardado);
				        ultimajug[0]=7;
						mundo.getTictactoe().turnos();

			} else if (!view.getPanelJuego().getPanelTablero().getPos31().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos31().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos31().setText("");
			}
			// Pos32
			if (view.getPanelJuego().getPanelTablero().getPos32().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos32().setText("X");
				    jugadasjug[0]=8;
					jugadascpu[0] = mundo.getIa().defender(1, jugadasjug[0], jugadasjug[1], jugadasjug[2], jugadasjug[3], 0, 0, 0);
					guardado = jugadascpu[0];

						jugarCelda(guardado);
						 ultimajug[0]=8;
						mundo.getTictactoe().turnos();

			} else if (!view.getPanelJuego().getPanelTablero().getPos32().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos32().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos32().setText("");
			}
			// Pos33
			if (view.getPanelJuego().getPanelTablero().getPos33().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos33().setText("X");
				
				    jugadasjug[0]=9;
					jugadascpu[0] = mundo.getIa().defender(1, jugadasjug[0], jugadasjug[1], jugadasjug[2], jugadasjug[3], 0, 0, 0);
				    guardado = jugadascpu[0];
	
				        jugarCelda(guardado);
				        ultimajug[0]=9;
						mundo.getTictactoe().turnos();

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

	public void ValidarTurno2() throws Exception {
        /*
		jugadascpu[1] = mundo.getIa().defender(2, 1, 3, 0, 0, 5, 0, 0);
		int guardado = jugadascpu[1];
		mundo.getIa().defender(2, 1, 3, 0, 0, 5, 0, 0);
		System.out.println("Entró al turno dos defender = " + jugadascpu[1]);
		if (jugadascpu[1] == guardado) {
			view.getPanelJuego().getPanelTablero().getPos12().setText("O");
			view.getPanelJuego().getPanelTablero().getPos12().setEditable(false);
			mundo.getTictactoe().turnos();

		}
       */
		    
		if (mundo.getTictactoe().isTurno() == false) { 
			mundo.getTictactoe().turnos();
			boolean jugadaRealizada=false;
			
			// Pos11
			   jugadasjug[1]=0;
			if (view.getPanelJuego().getPanelTablero().getPos11().getText().equalsIgnoreCase("x") && jugadaRealizada==false && ultima(1)) {
				view.getPanelJuego().getPanelTablero().getPos11().setText("X");
				jugadasjug[1] = 1;
				

				jugadascpu[1] = mundo.getIa().defender(2, jugadasjug[0], jugadasjug[1], jugadasjug[2], jugadasjug[3], jugadascpu[0], 0, 0);
			    guardado = jugadascpu[1];
			    
			        jugarCelda(guardado);
			        jugadaRealizada=true;
					//mundo.getTictactoe().turnos();

			}/* else if (!view.getPanelJuego().getPanelTablero().getPos11().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos11().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos12().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos11().setText("");

			}*/
			// Pos12
			if (view.getPanelJuego().getPanelTablero().getPos12().getText().equalsIgnoreCase("x") && jugadaRealizada==false  && ultima(2)) {
				view.getPanelJuego().getPanelTablero().getPos12().setText("X");
				
				    jugadasjug[1]=2;
					jugadascpu[1] = mundo.getIa().defender(2, jugadasjug[0], jugadasjug[1], jugadasjug[2], jugadasjug[3], jugadascpu[0], 0, 0);
					guardado = jugadascpu[1];
					
						jugarCelda(guardado);
						 jugadaRealizada=true;
						//mundo.getTictactoe().turnos();

			}/* else if (!view.getPanelJuego().getPanelTablero().getPos12().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos12().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos12().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos12().setText("");
			}*/
			// Pos13
			if (view.getPanelJuego().getPanelTablero().getPos13().getText().equalsIgnoreCase("x") && jugadaRealizada==false && ultima(3)) {
				view.getPanelJuego().getPanelTablero().getPos13().setText("X");
				    jugadasjug[1]=3;
					// TODO Se pone la condicion
					jugadascpu[1] = mundo.getIa().defender(2, jugadasjug[0], jugadasjug[1], jugadasjug[2], jugadasjug[3], jugadascpu[0], 0, 0);
				    guardado = jugadascpu[1];
					
				        jugarCelda(guardado);
				        jugadaRealizada=true;
						//mundo.getTictactoe().turnos();

			} /*else if (!view.getPanelJuego().getPanelTablero().getPos13().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos13().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos13().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos13().setText("");
			}*/
			// Pos21
			if (view.getPanelJuego().getPanelTablero().getPos21().getText().equalsIgnoreCase("x") && jugadaRealizada==false  && ultima(4)) {
				view.getPanelJuego().getPanelTablero().getPos21().setText("X");
				
                    jugadasjug[1]=4;
					jugadascpu[1] = mundo.getIa().defender(2, jugadasjug[0], jugadasjug[1], jugadasjug[2], jugadasjug[3], jugadascpu[0], 0, 0);
					guardado = jugadascpu[1];
					
						jugarCelda(guardado);
						 jugadaRealizada=true;
						//mundo.getTictactoe().turnos();

			}/* else if (!view.getPanelJuego().getPanelTablero().getPos21().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos21().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos21().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos21().setText("");
			}*/
			// Pos22
			if (view.getPanelJuego().getPanelTablero().getPos22().getText().equalsIgnoreCase("x") && jugadaRealizada==false  && ultima(5)) {
				view.getPanelJuego().getPanelTablero().getPos22().setText("X");
				
				    jugadasjug[1]=5;
					jugadascpu[1] = mundo.getIa().defender(2, jugadasjug[0], jugadasjug[1], jugadasjug[2], jugadasjug[3], jugadascpu[0], 0, 0);
					guardado = jugadascpu[1];
					
					//System.out.println("Jugador j1 = " + jugadasjug[0] + " Jugador j2 = " + jugadasjug[1] + " Jugadacpu1 = " + jugadascpu[0] + " Jugadacpu2 = " + jugadascpu[1]);
						jugarCelda(guardado);
						 jugadaRealizada=true;
						//mundo.getTictactoe().turnos();
                 
			}/* else if (!view.getPanelJuego().getPanelTablero().getPos22().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos22().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos22().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos22().setText("");
			}*/
			// Pos23
			if (view.getPanelJuego().getPanelTablero().getPos23().getText().equalsIgnoreCase("x") && jugadaRealizada==false && ultima(6)) {
				view.getPanelJuego().getPanelTablero().getPos23().setText("X");
				    jugadasjug[1]=6;
					jugadascpu[1] = mundo.getIa().defender(2, jugadasjug[0], jugadasjug[1], jugadasjug[2], jugadasjug[3], jugadascpu[0], 0, 0);
					guardado = jugadascpu[1];
					
				      jugarCelda(guardado);
				      jugadaRealizada=true;
					 // mundo.getTictactoe().turnos();

			} /*else if (!view.getPanelJuego().getPanelTablero().getPos23().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos23().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos23().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos23().setText("");
			}*/
			// Pos31
			if (view.getPanelJuego().getPanelTablero().getPos31().getText().equalsIgnoreCase("x") && jugadaRealizada==false && ultima(7)) {
				view.getPanelJuego().getPanelTablero().getPos31().setText("X");
				
			     	jugadasjug[1]=7;
					jugadascpu[1] = mundo.getIa().defender(2, jugadasjug[0], jugadasjug[1], jugadasjug[2], jugadasjug[3], jugadascpu[0], 0, 0);
				    guardado = jugadascpu[1];
					
				        jugarCelda(guardado);
				        jugadaRealizada=true;
						//mundo.getTictactoe().turnos();

			}/* else if (!view.getPanelJuego().getPanelTablero().getPos31().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos31().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos31().setText("");
			}*/
			// Pos32
			if (view.getPanelJuego().getPanelTablero().getPos32().getText().equalsIgnoreCase("x") && jugadaRealizada==false  && ultima(8)) {
				view.getPanelJuego().getPanelTablero().getPos32().setText("X");
				    jugadasjug[1]=8;
					jugadascpu[1] = mundo.getIa().defender(2, jugadasjug[0],8, jugadasjug[2], jugadasjug[3], jugadascpu[0], 0, 0);
					guardado = jugadascpu[1];
					
						jugarCelda(guardado);
						 jugadaRealizada=true;
						//mundo.getTictactoe().turnos();

			}/* else if (!view.getPanelJuego().getPanelTablero().getPos32().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos32().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos32().setText("");
			}*/
			// Pos33
			if (view.getPanelJuego().getPanelTablero().getPos33().getText().equalsIgnoreCase("x") && jugadaRealizada==false  && ultima(9)) {
				view.getPanelJuego().getPanelTablero().getPos33().setText("X");
				
				    jugadasjug[1]=9;
					jugadascpu[1] = mundo.getIa().defender(2, jugadasjug[0], jugadasjug[1], jugadasjug[2], jugadasjug[3], jugadascpu[0], 0, 0);
				    guardado = jugadascpu[1];
				 
				       jugarCelda(guardado);
				       jugadaRealizada=true;
					//	mundo.getTictactoe().turnos();
              
			}/* else if (!view.getPanelJuego().getPanelTablero().getPos33().getText().equals("X")
					&& !view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")
					&& !view.getPanelJuego().getPanelTablero().getPos33().getText().equals("O")) {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos33().setText("");
			}*/

		}
		 
		imprimirResultados();
		validarCasillasDisponibles();

		contador++;
	}

	/**
	 * /**
	 * 
	 * @author Luis Ricardo Sanchez Este metodo valida el turno 3 y evita todos los
	 *         errores.
	 * 
	 */
	public void validarTurno3() throws Exception {
       /*
		jugadascpu[2] = mundo.getIa().defender(3, 1, 3, 8, 0, 5, 2, 0);
		int guardado = jugadascpu[2];
		mundo.getIa().defender(3, 1, 3, 8, 0, 5, 2, 0);
		System.out.println("Entró al turno dos defender = " + jugadascpu[1]);
		if (jugadascpu[2] == guardado) {
			view.getPanelJuego().getPanelTablero().getPos21().setText("O");
			view.getPanelJuego().getPanelTablero().getPos21().setEditable(false);
			mundo.getTictactoe().turnos();

		}
*/
		validarCasillasDisponibles();

		contador++;
	}

	/**
	 * @author Luis Ricardo Sanchez Este metodo valida el turno 4 y evita todos los
	 *         errores.
	 */
	public void validarTurno4() throws Exception {
		/*
		jugadascpu[3] = mundo.getIa().defender(4, 1, 3, 8, 6, 5, 2, 4);
		int guardado = jugadascpu[3];
		mundo.getIa().defender(4, 1, 3, 8, 6, 5, 2, 4);
		System.out.println("Entró al turno dos defender = " + jugadascpu[3]);
		if (jugadascpu[3] == guardado) {
			view.getPanelJuego().getPanelTablero().getPos33().setText("O");
			view.getPanelJuego().getPanelTablero().getPos33().setEditable(false);
			mundo.getTictactoe().turnos();

		}
		*/
		validarCasillasDisponibles();

		contador++;
	}

}
