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
public class MapInstanceCreator {
	
	public Map getInstance(String typeStructure) {
		
		Map myStructure;
		
		switch(typeStructure) {
		
			case "HashMap":
				myStructure = new HashMap<String,Producto>();
				break;
			
			case "TreeMap":
				myStructure = new TreeMap<String,Producto>();
				break;
				
			case "LinkedHashMap":
				myStructure = new LinkedHashMap<String,Producto>();
				break;
				
			default:
				myStructure = null;
				break;
		}
		
		return myStructure;
	}
}
