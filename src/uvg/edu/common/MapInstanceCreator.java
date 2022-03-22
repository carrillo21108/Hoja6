/**
 * Clase MapInstanceCreator
 * @author Brian Carrillo
 * @version 1.0
 *
 * En esta clase se utiliza el patron Factory para las instancias
 * de los tipos de implementacion de map.
 */

package uvg.edu.common;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Brian Carrillo
 *
 */
public class MapInstanceCreator<K,V> {
	
	/**
	 * Retorna la instancia segun el tipo ingresado
	 * @param typeStructure: Expresion del tipo de MAP (String)
	 */
	public Map getInstance(String typeStructure) {
		
		Map myStructure;
		
		switch(typeStructure) {
			//Instancia Hashmap
			case "HashMap":
				myStructure = new HashMap<K,V>();
				break;
			//Instancia Treemap
			case "TreeMap":
				myStructure = new TreeMap<K,V>();
				break;
			//Instancia Linkedhashmap
			case "LinkedHashMap":
				myStructure = new LinkedHashMap<K,V>();
				break;
				
			default:
				myStructure = null;
				break;
		}
		
		return myStructure;
	}
}
