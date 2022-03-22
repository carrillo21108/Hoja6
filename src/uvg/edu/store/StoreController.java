/**
 * Clase StoreController
 * @author Brian_Anthony_Carrillo_Monzon
 * @version 1.0
 *
 * En esta clase se implementa el controlador
 * que maneja las operaciones en la tienda.
 */

package uvg.edu.store;

import java.util.Iterator;
import java.util.Map;

import uvg.edu.common.MapInstanceCreator;
import uvg.edu.io.Reader;

/**
 * @author Brian Carrillo
 *
 */
public class StoreController {
	
	//Atributos de instancia
	private MapInstanceCreator<String,Producto> mapFactory = new MapInstanceCreator<String,Producto>();
	private Map carrito;
	
	private String[] categorias = new String[7];
	
	/**
	 * Constructor parametrizado
	 * @param typeStructure
	 */
	public StoreController(String typeStructure) {
		carrito = mapFactory.getInstance(typeStructure);
		categorias[0]="Mueble de terraza";
		categorias[1]="Sillones de masaje";
		categorias[2]="Bebidas";
		categorias[3]="Condimentos";
		categorias[4]="Frutas";
		categorias[5]="Carnes";
		categorias[6]="Lácteos";
	}
	
	/**
	 * Metodo para agregar productos a carrito de usuario
	 * @param hashTable inventario
	 * @param categoria del producto
	 * @param descripcion del producto
	 * @param cantidad de producto
	 * @return mensaje de la operacion
	 */
	public String agregarProducto(Map hashTable, String categoria, String descripcion, int cantidad) {
		if(hashTable.containsKey(categoria.trim()+"-"+descripcion.trim())) {
			
			//En caso ya posea el producto, se actualiza al atributo cantidad
			if(carrito.containsKey(categoria.trim()+"-"+descripcion.trim())) {
				Producto producto = (Producto)carrito.get(categoria.trim()+"-"+descripcion.trim());
				producto.setCantidad(producto.getCantidad()+cantidad);
				
				return "Producto actualizado con exito";
			
			//Se agrega el producto al carrito
			}else {
				Producto producto = new Producto(categoria, descripcion, cantidad);
				carrito.put(hash_function(producto), producto);
				
				return "Producto agregado con exito.";
			}
		}else {
			return "Error: Categoria y/o descripcion del producto incorrectos.";
		}
	}
	
	/**
	 * Obtencion del carrito
	 * @return Map
	 */
	public Map getCarrito() {
		return carrito;
	}
	
	/**
	 * Insercion del carrito
	 * @param carrito del usuario
	 */
	public void setCarrito(Map carrito) {
		this.carrito = carrito;
	}
	
	/**
	 * Funcion hash para insercion en carrito
	 * @param producto
	 * @return string clave
	 */
	private String hash_function(Producto producto) {
		String code = producto.getCategoria().trim()+"-"+producto.getDescripcion().trim();
		
		return code;
	}
	
	/**
	 * Busqueda de categoria de producto
	 * @param descripcionBusqueda
	 * @param inventario
	 * @return mensaje
	 */
	public String categoryProducto(String descripcionBusqueda, Map inventario) {
		boolean busqueda = false;
		
		String resultado = "";
		
		//Iteracion sobre las entradas del inventario
		Iterator it = inventario.entrySet().iterator();
	    while (it.hasNext() && busqueda==false) {
	        Map.Entry pair = (Map.Entry) it.next();
	        String values = (String)pair.getKey();
	        if(values.split("-")[1].equals(descripcionBusqueda)) {
	        	resultado = "La categoria del producto ingresado es: " + values.split("-")[0];
	        	busqueda = true;
	        }
	    }
	    
	    if(busqueda==false) {
	    	resultado = "Producto no identificado en tienda.";
	    }
	    
	    return resultado;
	}
	
	/**
	 * Listado de productos en carrito
	 * @return mensaje
	 */
	public String carritoSearch() {
		String resultado = "";
		
		//Iteracion sobre las entradas del carrito
		Iterator it = carrito.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry) it.next();
	        
	        Producto producto = (Producto)pair.getValue();
	        
	        resultado += producto.toString();
	        resultado += "\n";
	    }
	    
	    if(carrito.size()==0) {
	    	resultado = "Actualmente el carrito esta vacio.";
	    }
	    
	    return resultado;
	}
	
	/**
	 * Listado de productos en carrito agrupados por categoria
	 * @return mensaje
	 */
	public String carritoCategorySearch() {
		String resultado = "";
		
		for(String categoria:categorias) {
			
			//Agregacion de las categorias y sus productos
			resultado += ("\n--"+categoria+"--");
			resultado += "\n";
			Iterator it = carrito.entrySet().iterator();
			
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry) it.next();
		        String llave = (String)pair.getKey();
		        
		        if(llave.split("-")[0].equals(categoria)) {
		        	resultado += pair.getValue();
		        	resultado += "\n";
		        }
		    }
		}
	    
	    if(carrito.size()==0) {
	    	resultado = "Actualmente el carrito esta vacio.";
	    }
	    
		return resultado;
	}
	
	/**
	 * Listado de inventario
	 * @param inventario
	 * @return mensaje
	 */
	public String inventarioSearch(Map inventario) {
		String resultado="";
		
		//Iteracion en las entradas del inventario
		Iterator it = inventario.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry) it.next();
	        String llave = (String) pair.getKey();
	        String[] values = llave.split("-");
	        resultado += values[0]+" | "+values[1];
	        resultado += "\n";
	        
	    }
		
		return resultado;
	}
	
	/**
	 * Listado de inventario agrupado por categorias
	 * @param inventario
	 * @return mensaje
	 */
	public String inventarioCategorySearch(Map inventario) {
		String resultado = "";
		
		for(String categoria:categorias) {
			
			//Inserción en mensaje de las categorias y sus productos
			resultado += ("\n--"+categoria+"--");
			resultado += "\n";
			Iterator it = inventario.entrySet().iterator();
			
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry) it.next();
		        String llave = (String)pair.getKey();
		        
		        if(llave.split("-")[0].equals(categoria)) {
		        	resultado += pair.getValue();
		        	resultado += "\n";
		        }
		    }
		}
	    
		return resultado;
	}
	
}
