/**
 * Clase Reader
 * @author Brian Carrillo
 * @version 1.0
 *
 * En esta clase se utilizan las clases File, FileReader y BufferedReader 
 * para escanear el contenido del archivo de datos.
 */

package uvg.edu.io;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import uvg.edu.common.MapInstanceCreator;
import uvg.edu.store.Producto;
import java.security.*;

/**
 * Clase encargada de la manipulacion de archivos.
 * 
 * 
 */

public class Reader {
	
		private MapInstanceCreator<String,String> mapFactory = new MapInstanceCreator<String,String>();
		private String ruta;
		private Random rand = new Random();
		
		public Reader(String ruta){
			this.ruta = ruta;
		}
    
		/**
	     * Metodo leerTxt: sirve para leer el archivo y almacenar lo encontrado en un ArrayList de Strings.
	     * 
	     * @see System.out#println()
	     * @see java.io.File()
	     * @see java.io.FileReader()
	     * @see java.io.BufferedReader()
	     * @see java.util.ArrayList()
	     */
		public ArrayList<String> leerTxt(){

	        File archivo = null;
	        FileReader fr = null;
	        BufferedReader br = null;
	        
	        try {
	            archivo = new File (this.ruta);
	            fr = new FileReader (archivo);
	            br = new BufferedReader(fr);

	            // Lectura del fichero
	            ArrayList<String> filas = new ArrayList<String>();
	            
	            String linea;
	            
	            while((linea=br.readLine())!=null){
	            	filas.add(linea);
	            }
	            
	            return filas;
	            
	        }catch(Exception e){
	        	
	        	System.out.println("La ruta del archivo proporcionada no existe." + ruta);
	        	
	        }finally{
	            try{                    
	                if( null != fr ){   
	                    fr.close();     
	                }                  
	            }catch (Exception e2){ 
	                e2.printStackTrace();
	            }
	        }
	        return null;
	    }
		
		public Map obtenerData(ArrayList<String> filas, String typeStructure) {
			Map hashTable = mapFactory.getInstance(typeStructure);

			for(String fila:filas) {
				String[] data = fila.split("\\|\t");
				hashTable.put(hash_function(data[0],data[1]), data[1]);
			}
			
			return hashTable;
		}
		
		public static String hash_function(String categoria, String descripcion) {
			
			String code = categoria.trim()+"-"+descripcion.trim();
			
			return code;
		}
    
}