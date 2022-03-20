/**
 * 
 */
package uvg.edu.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import uvg.edu.io.Reader;

/**
 * @author Brian Carrillo
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Instancia del scanner
		Scanner scanner = new Scanner(System.in);
		
		//Mensaje inicial
		System.out.println("--ONLINE STORE--");
		System.out.println("Bienvenido\n");
		
		//Solicitud de la ruta del archivo.
		System.out.println("Ingrese la ruta en la que se encuentra el archivo .txt a escanear.");
		String ruta = scanner.nextLine();
		
		//Instancia de la clase que escaneara datos.txt
		Reader reader = new Reader(ruta);
		
		
		
		//Instancia del ArrayList con las filas obtenidas del archivo.
		Map filas = reader.obtenerData(reader.leerTxt(),"HashMap");
		
		Iterator it = filas.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry) it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	    }

	}

}
