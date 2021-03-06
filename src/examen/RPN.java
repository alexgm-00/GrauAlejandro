package examen;
/*
 * @author Alex
 * @version 4.0
 * 
 */
public class RPN {
	/*@param push
	 * poner informacion 
	 */
	public void pushPila(double nuevo_dato) {
		NodoPila nuevo_nodo = new NodoPila(nuevo_dato, nodo);
		nodo = nuevo_nodo;
	}
	/* @param pop
	 * extraer informacion
	 */
	public double popPila( ) {
		double dato_arriba = nodo.dato;
		nodo = nodo.abajo;
		return dato_arriba;
	}
	public RPN(String commando) {
		nodo = null;
		this.commando = commando;
	}
	/* @param metodos
	 *  metodos de las operaciones 
	 */
	public double suma(double a, double b) {
		
		double result= a + b;
		return result;
	}
	
	public double resta(double a, double b) {
		double result= a - b;
		return result;
	}
	
	public double mult(double a, double b) {
		double result= a * b;
		return result;
	}
	
	public double div(double a, double b) {
		double result= a / b;
		return result;
	}
	/* @param resultado
	 * metodo para el resultado
	 */
	public double resultado( ) {
		double a, b;
	
		int j;
		for(int contador = 0; contador < commando.length( ); contador++) {
			// si es un digito
			if(Character.isDigit(commando.charAt(contador))) {
				double numero;
				// obtener un string a partir del numero
				String temp = "";
				for(j = 0; (j < 100) && (Character.isDigit(
						commando.charAt(contador)) || (commando.charAt(contador) == '.')); j++, contador++) {
					temp = temp + String.valueOf(commando.
							charAt(contador));
				}
				// convertir a double y añadir a la pila
				numero = Double.parseDouble(temp);
				
				pushPila(numero);
			} else if(commando.charAt(contador) == '+') {
				b = popPila( );
				a = popPila( );
				pushPila(suma(a,b));
			} else if(commando.charAt(contador) == '-') {
				b = popPila( );
				a = popPila( );
				pushPila(resta(a,b));
			} else if(commando.charAt(contador) == '*') {
				b = popPila( );
				a = popPila( );
				pushPila(mult(a,b));
			} else if(commando.charAt(contador) == '/') {
				b = popPila( );
				a = popPila( );
				pushPila(div(a,b));
			}
			else if(commando.charAt(contador) == '^') {
				b = popPila( );
				a = popPila( );
				pushPila(Math.pow(a, b));}
			else if(commando.charAt(contador) == '%') {
				b = popPila( );
				a = popPila( );
				pushPila(a%b);
			} else if(commando.charAt(contador) != ' ') {
				throw new IllegalArgumentException( );
			}
		}
		double valor = popPila( );
		if(nodo != null) {
			throw new IllegalArgumentException( );
		}
		return valor;
	}
	private String commando;
	private NodoPila nodo;
}