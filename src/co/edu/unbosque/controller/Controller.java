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
 * @author Gabriel Blanco & Ricardo Sanchez Clase Controlador
 *
 */
public class Controller implements ActionListener {
	private int contador =0;
    private String[] jugadascpu = new String[4];
    private String[] jugadasjug = new String[4];
	private Mundo mundo = new Mundo();
	private View view = new View();

	/**
	 * M�todo Constructor del Controlador
	 * 
	 * @throws IOException
	 */
	public Controller() throws Exception {
		Consola();
		// Estoy subiendo un cambio chimbo
	}

	/**
	 * M�todo para probar casos puntuales en consola
	 * 
	 * @throws IOException
	 */
	public void Consola() throws Exception {
		// Se inicializa gui aqui ya que es necesario para probar por via JOptionPane
		/*
		 * TODO: Buscar un m�todo mas eficiente para mostrar TODOS los errores por
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
						+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.txt en donde aparece el detalle espec�fico del error causado.",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * M�todo para iniciar la GUI
	 */
	public void GUI() throws Exception {
		try {
			view.iniciar(this);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			mundo.getArchivo().makeLog(errors.toString());
			view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
					+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.txt en donde aparece el detalle espec�fico del error causado.",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/*
	 * TODO: Poner los m�todos a probar aqui
	 */
	public void IA(int holi) {
		IA ia = new IA();
		int jugada = 0;
		int p1 = 0, p2 = 0, p3 = 0, p4 = 0,cpu1=0,cpu2=0,cpu3=0;
		// p1=1;p2=3;p3=8;p4=0; Este un ejemplo de tres jugadas con las posiciones 1,3,8
		// El panel debe enviar los valores p1,p2,p3,p4 y cpu1,cpu2,cpu3 que son las jugadas realizadasSSSSS
		ia.defender(jugada, p1, p2, p3, p4,cpu1,cpu2,cpu3);
	}

	/**
	 * @author Luis Ricardo Sanchez
	 * @param ActionEvent e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// TODO: Ingresar aqu� las interacciones con Mundo

			if (e.getActionCommand() == view.getPanelJuego().getPanelBoton().OPERAR) {
				if(contador == 0) {
				validarTurno1();
				}
				if(contador ==1) {
//				ValidarTurno2();	
				}
				if(contador ==2) {
					
				}
				if(contador ==3){
					
				}

			}
		}

		/*
		 * Estas l�neas son para controlar en caso de que por falta de memoria no
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
					+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.txt en donde aparece el detalle espec�fico del error causado.",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * @author Luis Ricardo Sanchez
	 * Este metodo valida el turno 1 y evita todos los errores.
	 * realizar verificacion con randoms y borrar los JOptions de prueba cuando se termine de probar
	 */
	public void validarTurno1() {
		
		
		
		if (mundo.getTictactoe().isTurno() == false) {
			mundo.getTictactoe().turnos();
		 	// Pos11
			if (view.getPanelJuego().getPanelTablero().getPos11().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos11().setText("X");
				jugadasjug[0] ="00";
				view.getPanelJuego().getPanelTablero().getPos11().setEditable(false);
				if (view.getPanelJuego().getPanelTablero().getPos12().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos13().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos21().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos22().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos23().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")) {
					// TODO Se pone la condicion
					
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 1, 0, 0, 0,0,0,0).subSequence(0,2));
					String guardado=jugadascpu[0];
					view.getDialogos().output("", String.valueOf(mundo.getIa().defender(1, 1, 0, 0, 0,0,0,0).subSequence(0,2)), JOptionPane.INFORMATION_MESSAGE);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos22().setText("O");
						view.getPanelJuego().getPanelTablero().getPos22().setEditable(false);
						mundo.getTictactoe().turnos();
						
					}
				} else if(!view.getPanelJuego().getPanelTablero().getPos11().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos11().setText("");
					
				}	
			 }else if(!view.getPanelJuego().getPanelTablero().getPos11().getText().equals("X")
					 &&!view.getPanelJuego().getPanelTablero().getPos11().getText().equals("")
					 &&!view.getPanelJuego().getPanelTablero().getPos12().getText().equals("O")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
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
					// TODO Se pone la condicion & hacer las conexiones del IA con el random y que verifique si el lado saca las dos probabilidades. 
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 2, 0, 0, 0,0,0,0).subSequence(0,2));
					String guardado=jugadascpu[0];
					view.getDialogos().output("", String.valueOf(mundo.getIa().defender(1, 2, 0, 0, 0,0,0,0).subSequence(0,2)), JOptionPane.INFORMATION_MESSAGE);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos11().setText("O");
						view.getPanelJuego().getPanelTablero().getPos11().setEditable(false);
						mundo.getTictactoe().turnos();
					    
					}
					
				} else if(!view.getPanelJuego().getPanelTablero().getPos12().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos12().setText("");
					
				}	
			 }else if(!view.getPanelJuego().getPanelTablero().getPos12().getText().equals("X")
					 &&!view.getPanelJuego().getPanelTablero().getPos12().getText().equals("")
					 &&!view.getPanelJuego().getPanelTablero().getPos12().getText().equals("O")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
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
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 3, 0, 0, 0,0,0,0).subSequence(0,2));
					String guardado=jugadascpu[0];
					view.getDialogos().output("", String.valueOf(mundo.getIa().defender(1, 3, 0, 0, 0,0,0,0).subSequence(0,2)), JOptionPane.INFORMATION_MESSAGE);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos22().setText("O");
						view.getPanelJuego().getPanelTablero().getPos22().setEditable(false);
						mundo.getTictactoe().turnos();
						
					}
				} else if(!view.getPanelJuego().getPanelTablero().getPos13().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos13().setText("");
					
				}	
			 }else if(!view.getPanelJuego().getPanelTablero().getPos13().getText().equals("X")
					 &&!view.getPanelJuego().getPanelTablero().getPos13().getText().equals("")
					 &&!view.getPanelJuego().getPanelTablero().getPos13().getText().equals("O")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
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
					// TODO Se pone la condicion & hacer las conexiones del IA con el random y que verifique si el lado saca las dos probabilidades. 
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 4, 0, 0, 0,0,0,0).subSequence(0,2));
					String guardado=jugadascpu[0];
					view.getDialogos().output("", String.valueOf(mundo.getIa().defender(1, 4, 0, 0, 0,0,0,0).subSequence(0,2)), JOptionPane.INFORMATION_MESSAGE);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos31().setText("O");
						view.getPanelJuego().getPanelTablero().getPos31().setEditable(false);
						mundo.getTictactoe().turnos();
						
					}
				} else if(!view.getPanelJuego().getPanelTablero().getPos21().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos21().setText("");
					
				}	
			 }else if(!view.getPanelJuego().getPanelTablero().getPos21().getText().equals("X")
					 &&!view.getPanelJuego().getPanelTablero().getPos21().getText().equals("")
					 &&!view.getPanelJuego().getPanelTablero().getPos21().getText().equals("O")){
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
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
					// TODO Se pone la condicion Solucionar el error de condicion y que sea random para las 4 esquinas.
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 5, 0, 0, 0,0,0,0).subSequence(0,2));
					String guardado=jugadascpu[0];
					view.getDialogos().output("", String.valueOf(mundo.getIa().defender(1, 5, 0, 0, 0,0,0,0).subSequence(0,2)), JOptionPane.INFORMATION_MESSAGE);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos13().setText("O");
						view.getPanelJuego().getPanelTablero().getPos13().setEditable(false);
						mundo.getTictactoe().turnos();
						
					}
				} else if(!view.getPanelJuego().getPanelTablero().getPos22().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos22().setText("");
					
				}	
			 }else if(!view.getPanelJuego().getPanelTablero().getPos22().getText().equals("X")
					 &&!view.getPanelJuego().getPanelTablero().getPos22().getText().equals("")
					 &&!view.getPanelJuego().getPanelTablero().getPos22().getText().equals("O")){
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
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
					// TODO Se pone la condicion & hacer las conexiones del IA con el random y que verifique si el lado saca las dos probabilidades. 
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 6, 0, 0, 0,0,0,0).subSequence(0,2));
					String guardado=jugadascpu[0];
					view.getDialogos().output("", String.valueOf(mundo.getIa().defender(1, 6, 0, 0, 0,0,0,0).subSequence(0,2)), JOptionPane.INFORMATION_MESSAGE);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos13().setText("O");
						view.getPanelJuego().getPanelTablero().getPos13().setEditable(false);
						mundo.getTictactoe().turnos();
						
					}
				} else if(!view.getPanelJuego().getPanelTablero().getPos23().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos23().setText("");
					
				}	
			 }else if(!view.getPanelJuego().getPanelTablero().getPos23().getText().equals("X")
					 &&!view.getPanelJuego().getPanelTablero().getPos23().getText().equals("")
					 &&!view.getPanelJuego().getPanelTablero().getPos23().getText().equals("O")){
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
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
					// TODO Se pone la condicion
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 7, 0, 0, 0,0,0,0).subSequence(0,2));
					String guardado=jugadascpu[0];
					view.getDialogos().output("", String.valueOf(mundo.getIa().defender(1, 7, 0, 0, 0,0,0,0).subSequence(0,2)), JOptionPane.INFORMATION_MESSAGE);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos22().setText("O");
						view.getPanelJuego().getPanelTablero().getPos22().setEditable(false);
						mundo.getTictactoe().turnos();
						
					}
				} else if(!view.getPanelJuego().getPanelTablero().getPos31().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos31().setText("");
					
				}	
			 }else if(!view.getPanelJuego().getPanelTablero().getPos31().getText().equals("X")
					 &&!view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")
					 &&!view.getPanelJuego().getPanelTablero().getPos31().getText().equals("O")){
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
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
					// TODO Se pone la condicion & hacer las conexiones del IA con el random y que verifique si el lado saca las dos probabilidades. 
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 8, 0, 0,0,0,0,0).subSequence(0,2));
					String guardado=jugadascpu[0];
					view.getDialogos().output("", String.valueOf(mundo.getIa().defender(1, 8, 0, 0, 0,0,0,0).subSequence(0,2)), JOptionPane.INFORMATION_MESSAGE);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos33().setText("O");
						view.getPanelJuego().getPanelTablero().getPos33().setEditable(false);
						mundo.getTictactoe().turnos();
						
					}
				} else if(!view.getPanelJuego().getPanelTablero().getPos32().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos32().setText("");
					
				}	
			 }else if(!view.getPanelJuego().getPanelTablero().getPos32().getText().equals("X")
					 &&!view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")
					 &&!view.getPanelJuego().getPanelTablero().getPos32().getText().equals("O")){
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
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
					// TODO Se pone la condicion
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 9, 0, 0, 0,0,0,0).subSequence(0,2));
					String guardado=jugadascpu[0];
					view.getDialogos().output("", String.valueOf(mundo.getIa().defender(1, 9, 0, 0, 0,0,0,0).subSequence(0,2)), JOptionPane.INFORMATION_MESSAGE);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos22().setText("O");
						view.getPanelJuego().getPanelTablero().getPos22().setEditable(false);
						mundo.getTictactoe().turnos();
						
					}
				} else if(!view.getPanelJuego().getPanelTablero().getPos33().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos33().setText("");
					
				}	
			 }else if(!view.getPanelJuego().getPanelTablero().getPos33().getText().equals("X")
					 &&!view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")
					 &&!view.getPanelJuego().getPanelTablero().getPos33().getText().equals("O")){
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos33().setText("");
				}	
			
			}contador++;
		}
	/**
	 * @author Luis Ricardo Sanchez
	 * Este metodo valida el turno 2 y evita todos los errores.
	 * realizar verificacion con randoms y borrar los JOptions de prueba cuando se termine de probar
	 */
		
	public void ValidarTurno2() {
		if (mundo.getTictactoe().isTurno() == false) {
			mundo.getTictactoe().turnos();
		 	// Pos11
			if (view.getPanelJuego().getPanelTablero().getPos11().getText().equalsIgnoreCase("x")) {
				view.getPanelJuego().getPanelTablero().getPos11().setText("X");
				jugadasjug[0] ="00";
				view.getPanelJuego().getPanelTablero().getPos11().setEditable(false);
				if (view.getPanelJuego().getPanelTablero().getPos12().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos13().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos21().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos22().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos23().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")
						&& view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")) {
					// Se pone la condicion
					
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 1, 0, 0, 0,0,0,0).subSequence(0,2));
					String guardado=jugadascpu[0];
					view.getDialogos().output("", String.valueOf(mundo.getIa().defender(1, 1, 0, 0, 0,0,0,0).subSequence(0,2)), JOptionPane.INFORMATION_MESSAGE);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos22().setText("O");
						view.getPanelJuego().getPanelTablero().getPos22().setEditable(false);
						mundo.getTictactoe().turnos();
						
					}
				} else if(!view.getPanelJuego().getPanelTablero().getPos11().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos11().setText("");
					
				}	
			 }else if(!view.getPanelJuego().getPanelTablero().getPos11().getText().equals("X")
					 &&!view.getPanelJuego().getPanelTablero().getPos11().getText().equals("")
					 &&!view.getPanelJuego().getPanelTablero().getPos12().getText().equals("O")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
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
					// Se pone la condicion
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 2, 0, 0, 0,0,0,0).subSequence(0,2));
					String guardado=jugadascpu[0];
					view.getDialogos().output("", String.valueOf(mundo.getIa().defender(1, 2, 0, 0, 0,0,0,0).subSequence(0,2)), JOptionPane.INFORMATION_MESSAGE);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos11().setText("O");
						view.getPanelJuego().getPanelTablero().getPos11().setEditable(false);
						mundo.getTictactoe().turnos();
						
					}
				} else if(!view.getPanelJuego().getPanelTablero().getPos12().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos12().setText("");
					
				}	
			 }else if(!view.getPanelJuego().getPanelTablero().getPos12().getText().equals("X")
					 &&!view.getPanelJuego().getPanelTablero().getPos12().getText().equals("")
					 &&!view.getPanelJuego().getPanelTablero().getPos12().getText().equals("O")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
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
					// Se pone la condicion
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 3, 0, 0, 0,0,0,0).subSequence(0,2));
					String guardado=jugadascpu[0];
					view.getDialogos().output("", String.valueOf(mundo.getIa().defender(1, 3, 0, 0, 0,0,0,0).subSequence(0,2)), JOptionPane.INFORMATION_MESSAGE);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos22().setText("O");
						view.getPanelJuego().getPanelTablero().getPos22().setEditable(false);
						mundo.getTictactoe().turnos();
						
					}
				} else if(!view.getPanelJuego().getPanelTablero().getPos13().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos13().setText("");
					
				}	
			 }else if(!view.getPanelJuego().getPanelTablero().getPos13().getText().equals("X")
					 &&!view.getPanelJuego().getPanelTablero().getPos13().getText().equals("")
					 &&!view.getPanelJuego().getPanelTablero().getPos13().getText().equals("O")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
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
					// Se pone la condicion
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 4, 0, 0, 0,0,0,0).subSequence(0,2));
					String guardado=jugadascpu[0];
					view.getDialogos().output("", String.valueOf(mundo.getIa().defender(1, 4, 0, 0, 0,0,0,0).subSequence(0,2)), JOptionPane.INFORMATION_MESSAGE);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos31().setText("O");
						view.getPanelJuego().getPanelTablero().getPos31().setEditable(false);
						mundo.getTictactoe().turnos();
						
					}
				} else if(!view.getPanelJuego().getPanelTablero().getPos21().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos21().setText("");
					
				}	
			 }else if(!view.getPanelJuego().getPanelTablero().getPos21().getText().equals("X")
					 &&!view.getPanelJuego().getPanelTablero().getPos21().getText().equals("")
					 &&!view.getPanelJuego().getPanelTablero().getPos21().getText().equals("O")){
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
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
					// Se pone la condicion
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 5, 0, 0, 0,0,0,0).subSequence(0,2));
					String guardado=jugadascpu[0];
					view.getDialogos().output("", String.valueOf(mundo.getIa().defender(1, 5, 0, 0, 0,0,0,0).subSequence(0,2)), JOptionPane.INFORMATION_MESSAGE);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos13().setText("O");
						view.getPanelJuego().getPanelTablero().getPos13().setEditable(false);
						mundo.getTictactoe().turnos();
						
					}
				} else if(!view.getPanelJuego().getPanelTablero().getPos22().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos22().setText("");
					
				}	
			 }else if(!view.getPanelJuego().getPanelTablero().getPos22().getText().equals("X")
					 &&!view.getPanelJuego().getPanelTablero().getPos22().getText().equals("")
					 &&!view.getPanelJuego().getPanelTablero().getPos22().getText().equals("O")){
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
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
					// Se pone la condicion
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 6, 0, 0, 0,0,0,0).subSequence(0,2));
					String guardado=jugadascpu[0];
					view.getDialogos().output("", String.valueOf(mundo.getIa().defender(1, 6, 0, 0, 0,0,0,0).subSequence(0,2)), JOptionPane.INFORMATION_MESSAGE);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos13().setText("O");
						view.getPanelJuego().getPanelTablero().getPos13().setEditable(false);
						mundo.getTictactoe().turnos();
						
					}
				} else if(!view.getPanelJuego().getPanelTablero().getPos23().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos23().setText("");
					
				}	
			 }else if(!view.getPanelJuego().getPanelTablero().getPos23().getText().equals("X")
					 &&!view.getPanelJuego().getPanelTablero().getPos23().getText().equals("")
					 &&!view.getPanelJuego().getPanelTablero().getPos23().getText().equals("O")){
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
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
					// Se pone la condicion
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 7, 0, 0, 0,0,0,0).subSequence(0,2));
					String guardado=jugadascpu[0];
					view.getDialogos().output("", String.valueOf(mundo.getIa().defender(1, 7, 0, 0, 0,0,0,0).subSequence(0,2)), JOptionPane.INFORMATION_MESSAGE);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos22().setText("O");
						view.getPanelJuego().getPanelTablero().getPos22().setEditable(false);
						mundo.getTictactoe().turnos();
						
					}
				} else if(!view.getPanelJuego().getPanelTablero().getPos31().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos31().setText("");
					
				}	
			 }else if(!view.getPanelJuego().getPanelTablero().getPos31().getText().equals("X")
					 &&!view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")
					 &&!view.getPanelJuego().getPanelTablero().getPos31().getText().equals("O")){
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
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
					// Se pone la condicion
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 8, 0, 0, 0,0,0,0).subSequence(0,2));
					String guardado=jugadascpu[0];
					view.getDialogos().output("", String.valueOf(mundo.getIa().defender(1, 8, 0, 0, 0,0,0,0).subSequence(0,2)), JOptionPane.INFORMATION_MESSAGE);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos33().setText("O");
						view.getPanelJuego().getPanelTablero().getPos33().setEditable(false);
						mundo.getTictactoe().turnos();
						
					}
				} else if(!view.getPanelJuego().getPanelTablero().getPos32().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos32().setText("");
					
				}	
			 }else if(!view.getPanelJuego().getPanelTablero().getPos32().getText().equals("X")
					 &&!view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")
					 &&!view.getPanelJuego().getPanelTablero().getPos32().getText().equals("O")){
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
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
					// Se pone la condicion
					jugadascpu[0] = String.valueOf(mundo.getIa().defender(1, 9, 0, 0, 0,0,0,0).subSequence(0,2));
					String guardado=jugadascpu[0];
					view.getDialogos().output("", String.valueOf(mundo.getIa().defender(1, 9, 0, 0, 0,0,0,0).subSequence(0,2)), JOptionPane.INFORMATION_MESSAGE);
					if (jugadascpu[0] == guardado) {
						view.getPanelJuego().getPanelTablero().getPos22().setText("O");
						view.getPanelJuego().getPanelTablero().getPos22().setEditable(false);
						mundo.getTictactoe().turnos();
						
					}
				} else if(!view.getPanelJuego().getPanelTablero().getPos33().getText().equalsIgnoreCase("x")) {
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos33().setText("");
					
				}	
			 }else if(!view.getPanelJuego().getPanelTablero().getPos33().getText().equals("X")
					 &&!view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")
					 &&!view.getPanelJuego().getPanelTablero().getPos33().getText().equals("O")){
					view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo",
							JOptionPane.ERROR_MESSAGE);
					view.getPanelJuego().getPanelTablero().getPos33().setText("");
				}	
			
			}contador++;
	}
	/**
	 /**
	 * @author Luis Ricardo Sanchez
	 * Este metodo valida el turno 3 y evita todos los errores. 
	 *  TODO que verifique si es empate, ganar o perder
	 * 
	 */
	public void validarTurno3() {
	}	
	/**
	 * @author Luis Ricardo Sanchez
	 * Este metodo valida el turno 4 y evita todos los errores.
	 * TODO que verifique si es empate, ganar o perder
	 */
	public void validarTurnos4() {
	}	
	// TODO manejo de excepciones cuando el programa funcione correctamente
	// TODO Intento de Arreglo del bug del boton si no se puede dejarlo asi

}
