
/**
 * Clase Principal
 * @author Brian_Anthony_Carrillo_Monzon
 * @version 1.0 21.03.2022
 *
 * En esta clase se maneja el metodo main que permite la ejecucion del 
 * programa. Desde el metodo main se ejecutan los metodos de la store.
 */
package uvg.edu.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import uvg.edu.io.Reader;
import uvg.edu.store.Producto;
import uvg.edu.store.StoreController;

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

		
		//Banderas de salida y errores
        boolean mapMenu = false;
        boolean menu = true;
        boolean error = false;
        
        //Opcion de menu
        int mapOption = 0;
        int menuOption = 0;
        
        //Tipo de estructura MAP
        String typeStructure="";
  
		
		//Mensaje inicial
		System.out.println("--ONLINE STORE--");
		System.out.println("Bienvenido\n");
		
		//Solicitud de la ruta del archivo.
		System.out.println("Ingrese la ruta en la que se encuentra el archivo .txt a escanear.");
		String ruta = scanner.nextLine();
		
		//Instancia de la clase que escaneara ListadoProducto.txt
		Reader reader = new Reader(ruta);
		
		do {
			do{
	            //Verificacion de entrada de las opciones de MAP
	            try{
	                //Solicitud de opcion map
	            	System.out.println("\nElija la implementacion de MAP que utilizara.");
		            //Opciones del menú
					System.out.println("1. HashMap.\n"
										+ "2. TreeMap.\n"
										+ "3. LinkedHashMap.\n");
		            mapOption = scanner.nextInt();
	                error = false;

	            //En caso de error
	            }catch(Exception e){
	                System.out.println("Error de ingreso, intente de nuevo.\n");
	                error = true;
	            //Finalmente
	            }finally{
	            	scanner.nextLine();
	            }
	        }while(error);
			
			switch(mapOption) {
				//Uso de Hashmap
				case 1:
					typeStructure = "HashMap";
					mapMenu=false;
					break;
				//Uso de Treemap
				case 2:
					typeStructure = "TreeMap";
					mapMenu=false;
					break;
				//Uso de LinkedHashmap
				case 3:
					typeStructure = "LinkedHashMap";
					mapMenu=false;
					break;
				
				default:
					System.out.println("Opcion incorrecta. Intentelo de nuevo.");
					mapMenu=true;
					break;
			}
		}while(mapMenu);
		
		//Instancia de la estructura MAP con las filas obtenidas del archivo.
		Map inventario = reader.obtenerData(reader.leerTxt(), typeStructure);
		
		//Obtencion del carrito de usuario
		StoreController store = new StoreController(typeStructure);
		Map carrito = store.getCarrito();
		
		do {
			do{
	            //Verificacion de entrada de las opciones del sistema
	            try{
	                //Solicitud de opcion del sistema
	            	System.out.println("\nEscoja una de las siguientes opciones:");
		            //Opciones del menú
					System.out.println("1. Agregar producto a carrito.\n"
										+ "2. Mostar categoria de producto.\n"
										+ "3. Mostrar carrito.\n"
										+ "4. Mostrar carrito ordenado por categoria.\n"
										+ "5. Mostrar inventario.\n"
										+ "6. Mostrar inventario ordenado por categoria.\n"
										+ "7. Salir.\n");
		            menuOption = scanner.nextInt();
	                error = false;

	            //En caso de error
	            }catch(Exception e){
	                System.out.println("Error de ingreso, intente de nuevo.\n");
	                error = true;
	            //Finalmente
	            }finally{
	            	scanner.nextLine();
	            }
	            
	        }while(error);
			
			switch(menuOption) {
				//Agregar
				case 1:
					System.out.println("Ingrese la categoria del producto.");
					String categoria = scanner.nextLine().trim();
					
					System.out.println("Ingrese la descripcion del producto.");
					String descripcion = scanner.nextLine().trim();
					
					int cantidad = 0;
					
					do {
						//Verificacion de entrada de cantidad
			            try{
			                //Solicitud de cantidad
			            	System.out.println("Ingrese la cantidad del producto");
				            cantidad = scanner.nextInt();
			                error = false;

			            //En caso de error
			            }catch(Exception e) {
			                System.out.println("Error de ingreso, intente de nuevo.\n");
			                error = true;
			            //Finalmente
			            }finally{
			            	scanner.nextLine();
			            }
			            
					}while(error);
					
					
					//Agregación del producto a carrito
					String resultado = store.agregarProducto(inventario, categoria, descripcion, cantidad);
					
					System.out.println(resultado);
					
					break;
				
				case 2:
					//Busqueda de categoria
					System.out.println("Ingrese la descripcion del producto");
					String descripcionBusqueda = scanner.nextLine();
					
					//Obtencion de la categoria del producto
					String busqueda_1 = store.categoryProducto(descripcionBusqueda, inventario);
					System.out.println(busqueda_1);
				    
					break;
					
				case 3:
					//Busqueda de los productos en carrito
					String busqueda_2 = store.carritoSearch();
					
					System.out.println(busqueda_2);
					
					break;
				
				case 4:
					//Busqueda de los productos en carrito agrupados por categoria
					String busqueda_3 = store.carritoCategorySearch();
					
					System.out.println(busqueda_3);
					
					break;
				
				case 5:
					//Busqueda de los productos en inventario
					String busqueda_4 = store.inventarioSearch(inventario);
					System.out.println(busqueda_4);
					
					break;
					
				case 6:
					//Busqueda de los productos en inventario agrupados por categoria
					String busqueda_5 = store.inventarioCategorySearch(inventario);
					System.out.println(busqueda_5);
					
					break;
					
				case 7:
					//Opcion salir
					System.out.println("Saliendo...");
					menu=false;
					break;
				
				default:
					System.out.println("Opcion incorrecta. Intentelo de nuevo.");
					break;
			}
		}while(menu);

	}

}
