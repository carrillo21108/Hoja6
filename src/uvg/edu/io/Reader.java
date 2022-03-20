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
import java.util.Random;

import java.security.*;

/**
 * Clase encargada de la manipulacion de archivos.
 * 
 * 
 */

public class Reader {
	
		private MapInstanceCreator mapFactory = new MapInstanceCreator();
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
            	Producto producto = new Producto(data[0], data[1], rand.nextInt(100));
				hashTable.put(hash_function(producto), producto);
			}
			
			return hashTable;
		}
		
		public static String hash_function(Producto producto) {
			
			String root = producto.getCategoria()+producto.getDescripcion();
			String code="";
			
			byte[] bytes = root.getBytes(StandardCharsets.US_ASCII);
			byte[] theMD5digest;
			
			try {
				
				MessageDigest md = MessageDigest.getInstance("MD5");
				theMD5digest = md.digest(bytes);
				for(byte a:theMD5digest) {
					code = code+String.valueOf(a);
				}
				
			}catch(Exception e) {
				System.out.println("Error al generar key");
			}
			
			return code;
		}
    
}