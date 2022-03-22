/**
 * Clase Producto
 * @author Brian_Anthony_Carrillo_Monzon
 * @version 1.0
 *
 * En esta clase se define el producto
 */
package uvg.edu.store;

/**
 * @author Brian Carrillo
 *
 */
public class Producto {
	//Atributos de instancia
	private String categoria;
	private String descripcion;
	private int cantidad;
	
	/**
	 * Constructor parametrizado
	 * @param categoria del producto
	 * @param descripcion del producto
	 * @param cantidad del producto
	 */
	public Producto(String categoria, String descripcion, int cantidad) {
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}
	
	/**
	 * Obtencion de la categoria
	 * @return categoria del producto
	 */
	public String getCategoria() {
		return categoria;
	}
	
	/**
	 * Insercion de la categoria del producto
	 * @param categoria del producto
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * Obtencion de la descripcion del producto
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Insercion de la descripcion del producto
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * Obtencion de la cantidad del producto
	 * @return
	 */
	public int getCantidad() {
		return cantidad;
	}
	
	/**
	 * Insercion de la cantidad del producto
	 * @param cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	/**
	 * Metodo to String
	 * @return descripcion del objeto
	 */
	public String toString() {
		return "Producto [categoria=" + categoria + ", descripcion=" + descripcion + ", cantidad=" + cantidad + "]";
	}
	
}
