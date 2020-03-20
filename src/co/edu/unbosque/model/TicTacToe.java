package co.edu.unbosque.model;

public class TicTacToe {
	private boolean turno = false;
	private int[][] posicion = new int[3][3];
	
	public TicTacToe() {
		for (int i = 0; i < posicion.length; i++) {
			for (int j = 0; j < posicion.length; j++) {
				posicion[i][j] = 0;
			}
		}
	}
	
	public boolean turnos() {
		if(!turno) {
			turno = true;
		} else {
			turno = false;
		}
		return turno;
	}
	public String definirGanador() {
		return null;
	}
}
