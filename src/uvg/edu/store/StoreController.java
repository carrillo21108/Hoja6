/**
 * 
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
	
	private MapInstanceCreator<String,Producto> mapFactory = new MapInstanceCreator<String,Producto>();
	private Map carrito;
	
	private String[] categorias = new String[7];
	
	public StoreController(String typeStructure) {
		carrito = mapFactory.getInstance(typeStructure);
		categorias[0]="Mueble de terraza";
		categorias[1]="Sillones de masaje";
		categorias[2]="Bebidas";
		categorias[3]="Condimentos";
		categorias[4]="Frutas";
		categorias[5]="Carnes";
		categorias[6]="Lacteos";
	}
	
	public String agregarProducto(Map hashTable, String categoria, String descripcion, int cantidad) {
		if(hashTable.containsKey(categoria.trim()+"-"+descripcion.trim())) {
			
			if(carrito.containsKey(categoria.trim()+"-"+descripcion.trim())) {
				Producto producto = (Producto)carrito.get(categoria.trim()+"-"+descripcion.trim());
				producto.setCantidad(producto.getCantidad()+cantidad);
				
				return "Producto actualizado con exito";
				
			}else {
				Producto producto = new Producto(categoria, descripcion, cantidad);
				carrito.put(hash_function(producto), producto);
				
				return "Producto agregado con exito.";
			}
		}else {
			return "Error: Categoria y/o descripcion del producto incorrectos.";
		}
	}
	
	public Map getCarrito() {
		return carrito;
	}

	public void setCarrito(Map carrito) {
		this.carrito = carrito;
	}

	private String hash_function(Producto producto) {
		String code = producto.getCategoria().trim()+"-"+producto.getDescripcion().trim();
		
		return code;
	}
	
	public String categoryProducto(String descripcionBusqueda, Map inventario) {
		boolean busqueda = false;
		
		String resultado = "";
		
		Iterator it = inventario.entrySet().iterator();
	    while (it.hasNext() && busqueda==false) {
	        Map.Entry pair = (Map.Entry) it.next();
	        Producto producto = (Producto) pair.getValue();
	        if(producto.getDescripcion().equals(descripcionBusqueda)) {
	        	resultado = "La categoria del producto ingresado es: " + producto.getCategoria();
	        	busqueda = true;
	        }
	    }
	    
	    if(busqueda==false) {
	    	resultado = "Producto no identificado en tienda.";
	    }
	    
	    return resultado;
	}
	
	public String carritoSearch() {
		String resultado = "";
		
		Iterator it = carrito.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry) it.next();
	        
	        resultado += (String)pair.getValue();
	    }
	    
	    if(carrito.size()==0) {
	    	resultado = "Actualmente el carrito esta vacio.";
	    }
	    
	    return resultado;
	}
	
	public String carritoCategorySearch() {
		String resultado = "";
		
		for(String categoria:categorias) {
			
			
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
	
	public String inventarioSearch(Map inventario) {
		String resultado="";
		
		Iterator it = inventario.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry) it.next();
	        String llave = (String) pair.getKey();
	        String[] values = llave.split("-");
	        resultado += values[0]+" | "+values[1];
	    }
		
		return resultado;
	}
	
	public String inventarioCategorySearch(Map inventario) {
		String resultado = "";
		
		for(String categoria:categorias) {
			
			
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
