package UTILIDADES;

public class Using {

	// COMPROBAR SI UNA CADENA ES NUMERICA O NO
	public static boolean isNumeric(String cadena) {
		
		try {
			
			Integer.parseInt(cadena);
			
			return true; // EN CASO DE NO OCURRIR UN ERROR ES NUMERICO
			
		}catch(Exception e) {
			
		}
		
		return false; // EN CASO DE OCURRIR UN ERRPR NO ES NUMERICO
	}
	
}
