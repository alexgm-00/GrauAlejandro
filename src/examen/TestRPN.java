package examen;

import java.util.Scanner;
/*
* @author Alex
* @version 4.0
* 
*/

public class TestRPN{
		
	
	//Constantes que hemos extraido
	private static final String FIN_DE_PROGRAMA = "Fin de programa";
	private static final String INTRODUCE_EXPRESION_POSTFIJA_O_TECLEA_FIN = "Introduce expresion Postfija o teclea \"fin\".";
//main ejecución
	public static void main(String args[]) {
		while(true) {
			Scanner in = new Scanner(System.in);
			System.out.println(INTRODUCE_EXPRESION_POSTFIJA_O_TECLEA_FIN);
			String linea = in.nextLine( );
			if(linea.equals("fin")) {
				System.out.println(FIN_DE_PROGRAMA);
				break;
			} else {
				RPN calc = new RPN(linea);
				System.out.printf("El resultado es %f\n", calc.resultado( ));
			}
		}
	}
}   