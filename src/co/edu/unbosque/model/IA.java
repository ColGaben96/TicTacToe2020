package co.edu.unbosque.model;

import java.util.Scanner;

/*
         Se enumeran las posiciones del tablero de triqui de la siguente manera:
         
         | 1 |  | 2 |  | 3 |        
         | 4 |  | 5 |  | 6 | 
         | 7 |  | 8 |  | 9 | 
         
         Cuando el jugador da clic en uno del los botones de la posicion le envia el número de posicion a esta clase (con interfaz grafica)
    
         La celdas esquineras son: 1,3,7,9 estos valores se guardan en el vector esquina[][]
         la celdas de los lados son: 2,4,6,8 estos valores se guardan en el vector lado[][]
         la celda central es la numero 5 este valor se guarda en la variable centro
         las esquinas vecinas a los lados son: lado 2 --> celdas 1,3 lado 4 --> celdas 1,7 lado 6 --> celdas 3,9 lado 8 --> celdas 7,9
         Estos valores se utlizan para seleccionar la estrategia a seguir. 
          
         Se tienen tres estrategias de defensa y una estrategia de ataque.
         
         Estrategia de defensa:
         
         1.si el jugador juega en una celda esquinera, la cpu debe seleccionar el centro del tablero
         2.Si el jugador selecciona una casilla de lado del tablero la cpu puede seleccioanr cualquier esquina vecina del lado seleccionado
         3.El programa debe identificar las filas o columnas en las que el jugador pueda hacer triqui y jugar para evitarlo
         
         Estrategia de ataque:
         
         1.Estrategia de ataque: Consiste en identifcar las filas o columnas en la que la cpu puede completar el triqui.para esto se utliza el
         metodo llamado estanAtacando().
 */


public class IA {
	
	int jugada[][] = new int[3][3];
	int tablero[][] = new int[3][3];
	int esquina[] = new int[4];
	int lados[] = new int[4];
	int centro = 5; // la variable centro guarda la posicion central del tablero
	int estrategia = 0;
	int posicion = 0;
	int posicionCpu = 0;
	int gameOver=0;
	int jugoCpu=0;  // Si es cero la cpu no ha jugado

	public boolean estanAtacando() {
		
	
		int triquit=0;
	/*	
	   Estos bucles  revisan todas las columnas y filas en donde exista la posibilidad de que la cpu haga triqui
	   Si la suma de las filas es igual a 4 indica que hay posibilidades de hacer triqui.Esto teniendo encuenta que cuando juega la cpu coloca 
	   un dos en la posicion de la matriz jugada
	 */
		for(int y=0; y<=2 ; y++) {
			triquit=0;
			for(int x=0; x<=2 ; x++) {
				if(jugada[x][y] == 2) {
			       triquit=triquit + jugada[x][y];
				}
			}
			
			if(triquit == 4) {
				for(int k=0; k<=2 ; k++) {
					if(jugada[k][y] == 0 && jugoCpu == 0) {
						jugada[k][y]=2;
						System.out.print("Triqui Gané!!!!!! \n");
						/*
						for (int a = 0; a <= 2; a++) {
							for (int b = 0;b <= 2; b++) {

								 System.out.print("Fila : "+ a + " Columna :" + b + "=" + jugada[a][b] + "\n");
							}			
						}
						*/
						gameOver=1;
						jugoCpu=1;
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
					if(jugada[x][yy] == 0 && jugoCpu == 0 ) {
						jugada[x][yy]=2;
						System.out.print("Triqui Gané!!!!!! \n");
						/*
						for (int a = 0; a <= 2; a++) {
							for (int b = 0; b <= 2; b++) {

								 System.out.print("Fila : "+ a + " Columna :" + b + "=" + jugada[a][b] + "\n");
							}			
						}
						*/
						gameOver=1;
						jugoCpu=1;
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

		// Se alimenta el vector esquina con las posiones esquinas del tablero
		//Esta matriz se utiliza para encotrar la estrategia, en el caso de que la primera jugada sea  una esquina del tablero 
		esquina[0] = 1;
		esquina[1] = 3;
		esquina[2] = 7;
		esquina[3] = 9;

		// Se alimenta el vector lados con las posiciones laterales del tablero
		//Esta matriz se utiliza para encotrar la estrategia2, en el caso de que la primera jugada sea un lado del tablero 
		lados[0] = 2;
		lados[1] = 4;
		lados[2] = 6;
		//lados[3] = 8;

		
		// ============================================= La primera jugada	// =============================================
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite la posicion de la primera jugada: ");
		posicion = sc.nextInt();
		
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {

				if (tablero[i][j] == posicion) {
					jugada[i][j] = 1;
				}

			}
		}
		
       /*
         Este ciclo identifica la primera jugada para definir que estrategia seguir.
         
        */
		
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
			 System.out.print("\n Cpu juego en la posicion: " + tablero[1][1]);

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

		

//	        ============================================= La segunda jugada =============================================
		System.out.print("La posicion es: " + posicion + " La estrategia es: " + estrategia);
		System.out.print("\n Digite la posicion de la segunda jugada: ");
		posicion = sc.nextInt();
        jugoCpu=0;
		System.out.print("\n La posicion es: " + posicion + " La estrategia es: " + estrategia+ "\n");
		
		int triquit=0;
		
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {

				if (tablero[i][j] == posicion) {
					jugada[i][j] = 1;
				}

			}
		}
		
		//Los siguentes dos bucles escananea las 3 columnas y las 3 filas respectivamente, revisando si el jugador pueda hacer triqui en la siguiente jugada
		//de manera, que la cpu juegue en la celda que evita el triqui. La celda elijidad por le jugador se almacena 1 en la matriz jugada[][].
		//cuando juega la cpu se almacena dos en la matriz jugada. 
		
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
						 System.out.print("\n Cpu juego en la posicion: " + tablero[k][y]);
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
						jugoCpu=1;
						 System.out.print("\n Cpu juego en la posicion: " + tablero[x][yy]);
					}else {
						triquit=0;
					}
						
				}
			}
		}
		//================ Si no ha jugado la cpu realiza su mejor jugada donde exista una fila o columna que haya jugado ==================== 
		
		if(jugoCpu == 0) {
			System.out.print("\n No juego en la segunda" + jugoCpu );
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
								 System.out.print("\n Cpu juego en la posicion: " + tablero[k][y]);
								jugoCpu = 1;
							}else {
								triquit=0;
							}
								
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
								 System.out.print("\n Cpu juego en la posicion: " + tablero[x][yy]);
								jugoCpu = 1;
							}else {
								triquit=0;
							}
								
						}
					}
				}
			}
		 // fin jugada cpu
		
	
		
//        ============================================= La tercera jugada =============================================
		
		
		jugoCpu=0;
		
		System.out.print("\n Digite la posicion de la tercera jugada: ");
		posicion = sc.nextInt();

		System.out.print("La posicion es: " + posicion + " La estrategia es: " + estrategia+ "\n");
		

		
	
		
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {

				if (tablero[i][j] == posicion) {
					jugada[i][j] = 1;
				}

			}
		}
	    
		jugoCpu=0;
		estanAtacando();
	
		//Los siguentes dos bucles escananea las 3 columnas y las 3 filas respectivamente, revisando si el jugador pueda hacer triqui en la siguiente jugada
		//de manera, que la cpu juegue en la celda que evita el triqui. La celda elijidad por le jugador se almacena 1 en la matriz jugada[][].
		//cuando juega la cpu se almacena dos en la matriz jugada. 
		
		
		
		for(int y=0; y<=2 ; y++) {
			triquit=0;
			for(int x=0; x<=2 ; x++) {
				if(jugada[x][y] != 2) {
			       triquit=triquit + jugada[x][y];
				}
			}
			
			if(triquit == 2) {
				for(int k=0; k<=2 ; k++) {
					if(jugada[k][y] == 0 && jugoCpu == 0) {
						jugada[k][y]=2;
						 System.out.print("\n Cpu juego en la posicion: " + tablero[k][y]);
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
					if(jugada[x][yy] == 0 && jugoCpu == 0) {
						jugada[x][yy]=2;
						 System.out.print("\n Cpu juego en la posicion: " + tablero[x][yy]);
						 jugoCpu=1;
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
								 System.out.print("\n Cpu juego en la posicion: " + tablero[k][y]);
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
								 System.out.print("\n Cpu juego en la posicion: " + tablero[x][yy]);
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

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {

				if (tablero[i][j] == posicion) {
					jugada[i][j] = 1;
				}

			}
		}
		
		//Los siguentes dos bucles escananea las 3 columnas y las 3 filas respectivamente, revisando si el jugador pueda hacer triqui en la siguiente jugada
		//de manera, que la cpu juegue en la celda que evita el triqui. La celda elijidad por le jugador se almacena 1 en la matriz jugada[][].
		//cuando juega la cpu se almacena dos en la matriz jugada. 

		
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
						 System.out.print("\n Cpu juego en la posicion: " + tablero[k][y]);
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
						 System.out.print("\n Cpu juego en la posicion: " + tablero[x][yy]);
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
								 System.out.print("\n Cpu juego en la posicion: " + tablero[k][y]);
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
								 System.out.print("\n Cpu juego en la posicion: " + tablero[x][yy]);
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
