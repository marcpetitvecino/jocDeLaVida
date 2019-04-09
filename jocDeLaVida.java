// Joc de la vida
package jocDeLaVida;

public class jocDeLaVida {

	public static int TAMANY = 7;
	public static int TAULA = (TAMANY - 1);
	
	public static void main(String[] args) {
		
		jocDeLaVida programa = new jocDeLaVida();
		programa.inici();

	}
	
	public void inici() {
		
		// int[][] taulabidi = new int[TAMANY][TAMANY];
		
		int[][] taulabidi = { { 0, 0, 0, 0, 0, 0, 0 }, 
							  { 0, 0, 0, 0, 0, 0, 0 }, 
							  { 0, 0, 0, 1, 0, 0, 0 }, 
							  { 0, 0, 0, 1, 1, 0, 0 }, 
							  { 0, 0, 0, 0, 0, 0, 0 }, 
							  { 0, 0, 0, 0, 0, 0, 0,}, 
							  { 0, 0, 0, 0, 0, 0, 0,} };
		
		int[][] proxGen = new int [TAMANY][TAMANY];
		
		int fila = 0;
		int columna = 0;
		int suma;
		
		//Generar taula amb cel·les aleatories
		
		/*for (fila = 1; fila < TAULAREAL; fila++) {
		for (columna = 1; columna < TAULAREAL; columna++) {
			
			arrayBidi[fila][columna] = (int) (Math.random() * 2);
		}
	}*/
		
		// Primer print per mostrar estat inicial
		
		for (fila = 0; fila < TAMANY; fila++) {
			
			for (columna = 0; columna < TAMANY; columna++) {
				
				System.out.print(taulabidi[fila][columna] + " ");
				
			}
			System.out.println("");
		}
		System.out.println("");
		
		// Aquí s'apliquen els dos metodes, el primer per contar els veins, i el segon, ja tenint el numero de veins, genera la seguent taula
		
		for (int i = 0; i < 5; i++) {
			
			for (fila = 1; fila < TAULA; fila++) {
				
				for (columna = 1; columna < TAULA; columna++) {
					
					suma = sumaVeins(taulabidi, fila, columna);
					proxGen[fila][columna] = nextState(taulabidi[fila][columna], suma);
					
				}
				
			}
			
			// Print de la nova taula
			
			for (fila = 0; fila < TAMANY; fila++) {
				
				for (columna = 0; columna < TAMANY; columna++) {
					
					System.out.print(proxGen[fila][columna] + " ");
					
				}
				
				System.out.println("");
				
			}
			System.out.println("");
			
			// Convertir la nova taula en la actual per poder fer una nova generació
			
			for (fila = 1; fila < TAMANY; fila++) {
				
				for (columna = 1; columna < TAMANY; columna++) {
					
					taulabidi[fila][columna] = proxGen[fila][columna];
				}
			}
			
		}
		
	}	
	private int sumaVeins (int[][]actGen, int x, int y) {
		
		int suma = 0;
		int fila;
		int col;
		
		for (fila = (x - 1); fila <= (x + 1); fila++) {
			
			for (col = (y - 1); col <= (y + 1); col++ ) {
				
				if (fila != x || col != y) {
					
					suma = suma + actGen[fila][col];
					
				}
				
			}
			
		}
		return suma;
	}
	
	private int nextState (int actState, int veins) {
		
		int nouEstat = 0;
		
		if (actState == 0 && veins == 3) {
			
			nouEstat = 1;
			
		}
		
		else if (actState == 1 && (veins == 3 || veins == 2)) {
			
			nouEstat = 1;
			
		}
		
		else if (veins < 2 || veins > 3) {
			
			nouEstat = 0;
			
		}
		
		return nouEstat;
	}
}
