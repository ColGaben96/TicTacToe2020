package co.edu.unbosque.model;

import java.util.Scanner;


/**
 * @author Carlos Albarracín & Gabriel Blanco
 * 
 * Se enumeran las posiciones del tablero de triqui de la siguiente manera:
| 1 |  | 2 |  | 3 |
| 4 |  | 5 |  | 6 |
| 7 |  | 8 |  | 9 |
Cuando el jugador da clic en uno de los botones de la posición le envia el número de posición a esta clase (con interfaz gráfica)
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
 *
 */
public class IA {
	private int  resultado= 0;/*
	                           * la variable resultado se usa para verificar si es ganador el cpu, no gano el cpu o es empate.
	                           */
	private double random= Math.random()*1;
	private int jugada[][] = new int[3][3];
    private int tablero[][] = new int[3][3];
	private int esquina[] = new int[4];
	private int lados[] = new int[4];
	private int centro = 5; // la variable centro guarda la posicion central del tablero
	private int estrategia = 0;
	private int posicion = 0;
	private int posicionCpu = 0;
	private int gameOver=0;
	private int jugoCpu=0; // Si es cero la cpu no ha jugado
    private String juegaCpu,juegaCpu1,juegaCpu2,juegaCpu3,juegaCpu4;
    private int triquit=0;
	
	/**
	 * @author Carlos Albarracín
	 * @return
	 * Estos bucles  revisan todas las columnas y filas en donde exista la posibilidad de que la cpu haga triqui
	 * Si la suma de las filas es igual a 4 indica que hay posibilidades de hacer triqui.Esto teniendo encuenta que cuando juega la cpu coloca 
	 * un dos en la posicion de la matriz jugada
	 */
	public boolean estanAtacando() {
		
	
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
					if(jugada[k][y] == 0 && jugoCpu == 0) {
						jugada[k][y]=2;
						resultado = 1;
						gameOver=1;
						jugoCpu=1;
						juegaCpu2= String.valueOf(k) + String.valueOf(y) ;
						juegaCpu3= String.valueOf(k) + String.valueOf(y) ;
						juegaCpu4= String.valueOf(k) + String.valueOf(y) ;
						return true;
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
						resultado=1;
						gameOver=1;
						jugoCpu=1;
						juegaCpu2= String.valueOf(x) + String.valueOf(yy) ;
						juegaCpu3= String.valueOf(x) + String.valueOf(yy) ;
						juegaCpu4= String.valueOf(x) + String.valueOf(yy) ;
						return true;
					}else {
						triquit=0;
					}
						
				}
			}
		}
		
		
		return false;
	}

	/**
	 * @author Carlos Albarracín
	 */
	public String defender(int ordenJugada,int p1,int p2,int p3,int p4,int cpu1,int cpu2,int cpu3) {
		
		//TODO: Cambiar a método int[][] para responder las posiciones.
		//TODO: Pasar todas las variables a parámetros

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
		lados[3] = 8;

		//Actualiza las jugadas realizadas
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				
				if (tablero[i][j] == cpu1) {jugada[i][j] = 2;}
				if (tablero[i][j] == cpu2) {jugada[i][j] = 2;}
				if (tablero[i][j] == cpu3) {jugada[i][j] = 2;}
				if (tablero[i][j] == p1) {jugada[i][j] = 1;}
				if (tablero[i][j] == p2) {jugada[i][j] = 1;}
				if (tablero[i][j] == p3) {jugada[i][j] = 1;}
				if (tablero[i][j] == p4) {jugada[i][j] = 1;}
				
			}
		}
		
		// ============================================= La primera jugada	// =============================================
		posicion=p1;
	if(ordenJugada >= 1) {
	
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
			juegaCpu1 = "11";
			
		}
		if (estrategia == 2) {
			switch (posicion) {
			case 2:
				jugada[0][0] = 2;
				if(random<=0.5) {
				posicionCpu = 1;
				juegaCpu1 ="00";
				
				}
				else {
					posicionCpu = 3;
					juegaCpu1="02";
					
				}
				break;
			case 4:
				jugada[2][0] = 2;
				if(random<=0.5) {
					posicionCpu = 1;
					juegaCpu1="00";
				
				}else {
					posicionCpu = 7;
					juegaCpu1 ="20";
				}
				break;
			case 6:
				if(random<=0.5) {
					posicionCpu = 3;
					juegaCpu1="02";
				
				}else {
					posicionCpu = 9;
					juegaCpu1 ="22";
				}
				break;
			case 8:
				if(random<=0.5) {
					posicionCpu = 7;
					juegaCpu1="20";
				
				}else {
					posicionCpu = 9;
					juegaCpu1 ="22";
				}
				break;

			}
		if(estrategia == 3) {
			int decisiones=(int)(Math.random()*4)+1;
			switch (decisiones) {
			 case 1:
				posicionCpu=1;
				juegaCpu1 = "00";
				break;
             case 2:
            	 posicionCpu=3;
 				juegaCpu1 = "02";
 				
				break;
             case 3:
            	 posicionCpu=7;
 				juegaCpu1 = "20";
 				
				break;
             case 4:
            	 posicionCpu=9;
 				juegaCpu1 = "22";
 				
 				break;


			default:
				break;
			}
		
		}

		}
	}   
	
  /*
   * @ Carlos Manuel Albarracin & Ricardo Sanchez
   */
//	        ============================================= La segunda jugada =============================================
	posicion=p2;
	if(ordenJugada >= 2) {
		
        jugoCpu=0;
	    triquit=0;
		
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
						juegaCpu2= String.valueOf(k) + String.valueOf(y);
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
						juegaCpu2= String.valueOf(x) + String.valueOf(yy) ;
					}else {
						triquit=0;
					}
						
				}
			}
		}
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
								juegaCpu2= String.valueOf(k) + String.valueOf(y) ;
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
								jugoCpu = 1;
								juegaCpu2= String.valueOf(x) + String.valueOf(yy) ;
							}else {
								triquit=0;
							}
								
						}
					}
				}
			}
		 // fin jugada cpu
		
	}
		
//        ============================================= La tercera jugada =============================================
	posicion=p3;
	if(ordenJugada >= 3) {
		
		jugoCpu=0;
		
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
						jugoCpu=1;
						juegaCpu3= String.valueOf(k) + String.valueOf(y) ;
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
						 juegaCpu3= String.valueOf(x) + String.valueOf(yy) ;
						 jugoCpu=1;
					}else {
						triquit=0;
					}
						
				}
			}
		}// fin del ciclo
		
	   //Diagonal derecha evalua si puede haber triqui
		
		triquit= 0;
		if(jugoCpu==0) {
		    triquit= triquit + jugada[0][0] + jugada[1][1] + jugada[2][2]; 
		    if(triquit==2) {
		    	if(jugada[0][0] == 0) { jugada[0][0]=2; jugoCpu=1;  juegaCpu3="00";}
		    	if(jugada[1][1] == 0) { jugada[1][1]=2; jugoCpu=1;  juegaCpu3="11";}
		    	if(jugada[2][2] == 0) { jugada[2][2]=2; jugoCpu=1;  juegaCpu3="22";}
		    }
		}
		//Diagonal Izquierda evalua si puede haber triqui
		triquit= 0;
		if(jugoCpu==0) {
		    triquit=triquit + jugada[0][2] + jugada[1][1] + jugada[2][0]; 
		    if(triquit==2) {
		    	if(jugada[0][2] == 0) { jugada[0][2]=2; jugoCpu=1; juegaCpu3="02"; }
		    	if(jugada[1][1] == 0) { jugada[1][1]=2; jugoCpu=1; juegaCpu3="11"; }
		    	if(jugada[2][0] == 0) { jugada[2][0]=2; jugoCpu=1; juegaCpu3="20"; }
		    }
		}
		
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
								juegaCpu3= String.valueOf(k) + String.valueOf(y) ;
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
								juegaCpu3= String.valueOf(x) + String.valueOf(yy) ;
							}else {
								triquit=0;
							}
								
						}
					}
				}
			}
		} // fin jugada cpu
		
		
		estanAtacando();
	}
	
//         ============================================= La cuarta jugada =============================================
	posicion=p4;
	if(ordenJugada == 4) {
		
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
						jugoCpu=1;
						juegaCpu4= String.valueOf(k) + String.valueOf(y) ;
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
		
		
		triquit= 0;
		if(jugoCpu==0) {
		    triquit+= jugada[0][0] + jugada[1][1] + jugada[2][2]; 
		    if(triquit==2) {
		    	if(jugada[0][0] == 0) { jugada[0][0]=2; jugoCpu=1; juegaCpu4="00"; }
		    	if(jugada[1][1] == 0) { jugada[1][1]=2; jugoCpu=1; juegaCpu4="11";}
		    	if(jugada[2][2] == 0) { jugada[2][2]=2; jugoCpu=1; juegaCpu4="22";}
		    }
		}
		//Diagonal Izquierda evalua si puede haber triqui
		if(jugoCpu==0) {
		    triquit+= jugada[0][2] + jugada[1][1] + jugada[2][0]; 
		    if(triquit==2) {
		    	if(jugada[0][2] == 0) { jugada[0][2]=2; jugoCpu=1; juegaCpu4="02";}
		    	if(jugada[1][1] == 0) { jugada[1][1]=2; jugoCpu=1; juegaCpu4="11";}
		    	if(jugada[2][0] == 0) { jugada[2][0]=2; jugoCpu=1; juegaCpu4="20";}
		    }
		}
		
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
								juegaCpu4= String.valueOf(k) + String.valueOf(y) ;
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
								juegaCpu4= String.valueOf(x) + String.valueOf(yy) ;
							}else {
								triquit=0;
							}
								
						}
					}
				}
			}
			
		} // fin jugada cpu

	  }
	}// fin de cuarta jugada
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {

				 
			}			
		}

		switch(ordenJugada) {
		
		case 1:
			juegaCpu = juegaCpu1;
		 break;
		case 2:
			juegaCpu =juegaCpu2;
		 break;
		case 3:
			juegaCpu = juegaCpu3;
		 break;
		case 4:
			juegaCpu = juegaCpu4;
		 break;
		}
		
		return  juegaCpu.substring(0,2) + "\n"+"O" +"\n" + resultado;
	    
	}
	public int verPosicion(int fila , int columna) {

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
		
		int pos=0;
		
		for(int i = 0; i <= 2; i++) {
			
			for(int j = 0; j <= 2; j++) {
				
				if(fila == i && columna == j) {
					
					pos=tablero[i][j];
				}
				
			}
		}
		
		return pos;
	}

	public int getJugada(int x , int y) {
		int juego = jugada[x][y];
		return juego;
	}

	public void setJugada(int[][] jugada) {
		this.jugada = jugada;
	}

	public int[][] getTablero() {
		return tablero;
	}

	public void setTablero(int[][] tablero) {
		this.tablero = tablero;
	}

	public int[] getEsquina() {
		return esquina;
	}

	public void setEsquina(int[] esquina) {
		this.esquina = esquina;
	}

	public int[] getLados() {
		return lados;
	}

	public void setLados(int[] lados) {
		this.lados = lados;
	}

	public int getCentro() {
		return centro;
	}

	public void setCentro(int centro) {
		this.centro = centro;
	}

	public int getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(int estrategia) {
		this.estrategia = estrategia;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int getPosicionCpu() {
		return posicionCpu;
	}

	public void setPosicionCpu(int posicionCpu) {
		this.posicionCpu = posicionCpu;
	}

	public int getGameOver() {
		return gameOver;
	}

	public void setGameOver(int gameOver) {
		this.gameOver = gameOver;
	}

	public int getJugoCpu() {
		return jugoCpu;
	}

	public void setJugoCpu(int jugoCpu) {
		this.jugoCpu = jugoCpu;
	}
	
}