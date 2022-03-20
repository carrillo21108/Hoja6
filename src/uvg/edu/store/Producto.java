/**
 * 
 */
package uvg.edu.store;

/**
 * @author Brian Carrillo
 *
 */
public class Producto {
	private String categoria;
	private String descripcion;
	private int cantidad;
	
	public Producto(String categoria, String descripcion, int cantidad) {
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Producto [categoria=" + categoria + ", descripcion=" + descripcion + ", cantidad=" + cantidad + "]";
	}
	
}
