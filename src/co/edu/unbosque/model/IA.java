package co.edu.unbosque.model;

import java.util.Scanner;

public class IA {
	
	int jugada[][] = new int[3][3];
	int tablero[][] = new int[3][3];
	int triqui[] = new int[8];
	int esquina[] = new int[4];
	int lados[] = new int[4];
	int centro = 5; // la variable centro guarda la posicion central del tablero
	int estrategia = 0;
	int posicion = 0;
	int posicionCpu = 0;
	int gameOver=0;

	public boolean estanAtacando() {
		
		int tri1=0;
		int tri2=0;
		int tri3=0;
		int triquit=0;
		
		
		for(int y=0; y<=2 ; y++) {
			triquit=0;
			for(int x=0; x<=2 ; x++) {
				if(jugada[x][y] == 2) {
			       triquit=triquit + jugada[x][y];
				}
			}
			
			if(triquit == 4) {
				for(int k=0; k<=2 ; k++) {
					if(jugada[k][y] == 0) {
						jugada[k][y]=2;
						System.out.print("Triqui Gané!!!!!! \n");
						gameOver=1;
					}else {
						triquit=0;
					}
						
				}
			}
		}
		
		for(int x=0; x<=2 ; x++) {
			triquit=0;
			for(int y=0; y<=2 ; y++) {
				if(jugada[x][y] == 2) {
			       triquit=triquit + jugada[x][y];
				}
			}
			
			if(triquit == 4) {
				for(int yy=0; yy<=2 ; yy++) {
					if(jugada[x][yy] == 0) {
						jugada[x][yy]=2;
						System.out.print("Triqui Gané!!!!!! \n");
						gameOver=1;
					}else {
						triquit=0;
					}
						
				}
			}
		}
		
		
		return false;
	}

	public void defender() {
	

		// Se almacena las pociones del tablero del triqui en la matriz tablero.
		tablero[0][0] = 1;
		tablero[0][1] = 2;
		tablero[0][2] = 3;
		tablero[1][0] = 4;
		tablero[1][1] = 5;
		tablero[1][2] = 6;
		tablero[2][0] = 7;
		tablero[2][1] = 8;
		tablero[2][2] = 9;

		// Se inicializa la matriz jugada con ceros
		jugada[0][0] = 0;
		jugada[0][1] = 0;
		jugada[0][2] = 0;
		jugada[1][0] = 0;
		jugada[1][1] = 0;
		jugada[1][2] = 0;
		jugada[2][0] = 0;
		jugada[2][1] = 0;
		jugada[2][2] = 0;

		// Se alimenta el vector triqui con las posiones ganadoras de triqui
		triqui[0] = 123;
		triqui[1] = 456;
		triqui[2] = 789;
		triqui[3] = 159;
		triqui[4] = 357;
		triqui[5] = 147;
		triqui[6] = 258;
		triqui[7] = 369;

		// Se alimenta el vector esquina con las posiones esquinas del tablero
		esquina[0] = 1;
		esquina[1] = 3;
		esquina[2] = 7;
		esquina[3] = 9;

		// Se alimenta el vector lados con las posiciones laterales del tablero
		lados[0] = 2;
		lados[1] = 4;
		lados[2] = 6;
		lados[3] = 8;

		Scanner sc = new Scanner(System.in);
		// ============================================= La primera jugada	// =============================================
		System.out.print("Digite la posicion de la primera jugada: ");
		posicion = sc.nextInt();

		for (int i = 0; i <= 3; i++) {

			if (posicion == esquina[i]) {
				estrategia = 1;

			}
			if (posicion == lados[i]) {
				estrategia = 2;
			}
		}
		if (posicion == centro) {
			estrategia = 3;
		}

		// jugada de defensa
		if (estrategia == 1) {

			jugada[1][1] = 2;

		}
		if (estrategia == 2) {
			switch (posicion) {
			case 2:
				posicionCpu = 1;
				break;
			case 4:
				posicionCpu = 7;
				break;
			case 6:
				posicionCpu = 3;
				break;
			case 8:
				posicionCpu = 9;
				break;

			}
		if(estrategia == 3) {
			
			posicionCpu=1;
			
		}

		}

		System.out.print("La posicion es: " + posicion + " La estrategia es: " + estrategia);

//	        ============================================= La segunda jugada =============================================
		
		System.out.print("\n Digite la posicion de la segunda jugada: ");
		posicion = sc.nextInt();

		System.out.print("La posicion es: " + posicion + " La estrategia es: " + estrategia+ "\n");
		
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {

				if (tablero[i][j] == posicion) {
					jugada[i][j] = 1;
				}

				// System.out.print("Fila : "+ i + " Columna :" + j + "=" + jugada[i][j] + "\n");
			}
		}
		int tri1=0;
		int tri2=0;
		int tri3=0;
		int triquit=0;
		
		for(int y=0; y<=2 ; y++) {
			triquit=0;
			for(int x=0; x<=2 ; x++) {
				if(jugada[x][y] != 2) {
			       triquit=triquit + jugada[x][y];
				}
			}
			
			if(triquit == 2) {
				for(int k=0; k<=2 ; k++) {
					if(jugada[k][y] == 0) {
						jugada[k][y]=2;
					}else {
						triquit=0;
					}
						
				}
			}
		}
		
		for(int x=0; x<=2 ; x++) {
			triquit=0;
			for(int y=0; y<=2 ; y++) {
				if(jugada[x][y] != 2) {
			       triquit=triquit + jugada[x][y];
				}
			}
			
			if(triquit == 2) {
				for(int yy=0; yy<=2 ; yy++) {
					if(jugada[x][yy] == 0) {
						jugada[x][yy]=2;
					}else {
						triquit=0;
					}
						
				}
			}
		}
		
	
		
//        ============================================= La tercera jugada =============================================
		
		
		
		System.out.print("\n Digite la posicion de la tercera jugada: ");
		posicion = sc.nextInt();

		System.out.print("La posicion es: " + posicion + " La estrategia es: " + estrategia+ "\n");
		

		estanAtacando();
		int jugoCpu=0; // Si es cero la cpu no ha jugado
		
		for(int y=0; y<=2 ; y++) {
			triquit=0;
			for(int x=0; x<=2 ; x++) {
				if(jugada[x][y] != 2) {
			       triquit=triquit + jugada[x][y];
				}
			}
			
			if(triquit == 2) {
				for(int k=0; k<=2 ; k++) {
					if(jugada[k][y] == 0) {
						jugada[k][y]=2;
						jugoCpu=1;
					}else {
						triquit=0;
					}
						
				}
			}
		}
		//============= Ciclo que bloquea el triqui del jugador =============
		for(int x=0; x<=2 ; x++) {
			triquit=0;
			for(int y=0; y<=2 ; y++) {
				if(jugada[x][y] != 2) {
			       triquit=triquit + jugada[x][y];
				}
			}
			
			if(triquit == 2) {
				for(int yy=0; yy<=2 ; yy++) {
					if(jugada[x][yy] == 0) {
						jugada[x][yy]=2;
					}else {
						triquit=0;
					}
						
				}
			}
		}// fin del ciclo
		
		//================ Si no ha jugado la cpu realiza su mejor jugada donde exista una fila o columna que haya jugado ==================== 
		if(jugoCpu == 0) {
			
			 for(int y=0; y<=2 ; y++) {
					triquit=0;
					for(int x=0; x<=2 ; x++) {
						if(jugada[x][y] == 2) {
					       triquit=triquit + jugada[x][y];
						}
					}
					
					if(triquit == 2) {
						for(int k=0; k<=2 ; k++) {
							if(jugada[k][y] == 0 && jugoCpu ==0)  {
								jugada[k][y]=2;
								jugoCpu = 1;
							}else {
								triquit=0;
							}
								
						}
					}
				}
				if(jugoCpu == 0) {
				for(int x=0; x<=2 ; x++) {
					triquit=0;
					for(int y=0; y<=2 ; y++) {
						if(jugada[x][y] == 2) {
					       triquit=triquit + jugada[x][y];
						}
					}
					
					if(triquit == 2) {
						for(int yy=0; yy<=2 ; yy++) {
							if(jugada[x][yy] == 0 && jugoCpu ==0) {
								jugada[x][yy]=2;
								jugoCpu = 1;
							}else {
								triquit=0;
							}
								
						}
					}
				}
			}
		} // fin jugada cpu
		
//      ============================================= La cuarta jugada =============================================
		
		
		
		System.out.print("\n Digite la posicion de la cuarta jugada: ");
		posicion = sc.nextInt();

		System.out.print("La posicion es: " + posicion + " La estrategia es: " + estrategia+ "\n");

		estanAtacando();
		if(gameOver == 0) {
	    jugoCpu=0; // Si es cero la cpu no ha jugado
		
		for(int y=0; y<=2 ; y++) {
			triquit=0;
			for(int x=0; x<=2 ; x++) {
				if(jugada[x][y] != 2) {
			       triquit=triquit + jugada[x][y];
				}
			}
			
			if(triquit == 2) {
				for(int k=0; k<=2 ; k++) {
					if(jugada[k][y] == 0) {
						jugada[k][y]=2;
						jugoCpu=1;
					}else {
						triquit=0;
					}
						
				}
			}
		}
		//============= Ciclo que bloquea el triqui del jugador =============
		for(int x=0; x<=2 ; x++) {
			triquit=0;
			for(int y=0; y<=2 ; y++) {
				if(jugada[x][y] != 2) {
			       triquit=triquit + jugada[x][y];
				}
			}
			
			if(triquit == 2) {
				for(int yy=0; yy<=2 ; yy++) {
					if(jugada[x][yy] == 0) {
						jugada[x][yy]=2;
					}else {
						triquit=0;
					}
						
				}
			}
		}// fin del ciclo
		
		//================ Si no ha jugado la cpu realiza su mejor jugada donde exista una fila o columna que haya jugado ==================== 
		if(jugoCpu == 0) {
			
			 for(int y=0; y<=2 ; y++) {
					triquit=0;
					for(int x=0; x<=2 ; x++) {
						if(jugada[x][y] == 2) {
					       triquit=triquit + jugada[x][y];
						}
					}
					
					if(triquit == 2) {
						for(int k=0; k<=2 ; k++) {
							if(jugada[k][y] == 0 && jugoCpu ==0)  {
								jugada[k][y]=2;
								jugoCpu = 1;
							}else {
								triquit=0;
							}
								
						}
					}
				}
				if(jugoCpu == 0) {
				for(int x=0; x<=2 ; x++) {
					triquit=0;
					for(int y=0; y<=2 ; y++) {
						if(jugada[x][y] == 2) {
					       triquit=triquit + jugada[x][y];
						}
					}
					
					if(triquit == 2) {
						for(int yy=0; yy<=2 ; yy++) {
							if(jugada[x][yy] == 0 && jugoCpu ==0) {
								jugada[x][yy]=2;
								jugoCpu = 1;
							}else {
								triquit=0;
							}
								
						}
					}
				}
			}
		} // fin jugada cpu
		
	
		}
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {

				 System.out.print("Fila : "+ i + " Columna :" + j + "=" + jugada[i][j] + "\n");
			}			
		}
		System.out.print("GameOver");
	}
}
