/**
 * 
 */
package uvg.edu.common;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import uvg.edu.store.Producto;

/**
 * @author Brian Carrillo
 *
 */
public class MapInstanceCreator<K,V> {
	
	public Map getInstance(String typeStructure) {
		
		Map myStructure;
		
		switch(typeStructure) {
		
			case "HashMap":
				myStructure = new HashMap<K,V>();
				break;
			
			case "TreeMap":
				myStructure = new TreeMap<K,V>();
				break;
				
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
