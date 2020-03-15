package co.edu.unbosque.model;

public class IA {
	
	public boolean estanAtacando() {
		return false;
	}
	public void defender() {
		int jugada[][] = new int [3][3];
		int triqui[] = new int [8];
		int esquina[] = new int[4];
		int lados[] = new int [4];
		int centro=5; // la variable centro guarda la posicion central del tablero
		
		//Se almacena las pociones del tablero del triqui en la matriz jugada.
		jugada [0][0]=1;
		jugada [0][1]=2;
		jugada [0][2]=3;
		jugada [1][0]=4;
		jugada [1][1]=5;
		jugada [1][2]=6;
		jugada [2][0]=7;
		jugada [2][1]=8;
		jugada [2][2]=9;
		
		// Se alimenta el vector triqui con las posiones ganadoras de triqui
		triqui[0]=123;
		triqui[1]=456;
		triqui[2]=789;
		triqui[3]=159;
		triqui[4]=357;
		triqui[5]=147;
		triqui[6]=258;
		triqui[7]=369;
		
		//Se alimenta el vector esquina con las posiones esquinas del tablero
		 esquina[0]=1;
		 esquina[1]=3;
		 esquina[2]=7;
		 esquina[3]=9;
		 
		 //Se alimenta el vector lados con las posiciones laterales del tablero
		 lados[0]=2;
	     lados[1]=4;
	     lados[2]=6;
	     lados[3]=8;	 
	}
}
