
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JOptionPane;

public class TA07Ejercicio3App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declaración de variables
		
		Hashtable<String, Double> StockProductos=new Hashtable<String, Double>();
		
		StockProductos.put("Television", 567.0);
		StockProductos.put("Portatil", 350.0);
		StockProductos.put("Nevera", 832.75);
		StockProductos.put("Reproductor de cds", 25.50);
		StockProductos.put("Tostador", 20.0);
		StockProductos.put("Play Satation", 725.75);
		StockProductos.put("Ordenador de sobremesa", 400.0);
		StockProductos.put("Nintendo ds", 158.15);
		StockProductos.put("Aire acondicionado", 1500.0);
		StockProductos.put("Horno", 750.33);
		
		accionRealizar(StockProductos);
	}
	
	public static void accionRealizar(Hashtable<String, Double> StockProductos) {
		String AccionRealizar; 
		
		AccionRealizar = JOptionPane.showInputDialog("¿Que acción desea realizar? [ AÑADIR | VER | SALIR ] articulos");
		AccionRealizar = AccionRealizar.toUpperCase();  
		
		switch (AccionRealizar) {
			case "AÑADIR":
				añadirArticulos(StockProductos);
			break;
			case "VER":
				mostrarArticulos(StockProductos);
			break;
			case "SALIR":
				
			break;
		}
	}
	
	public static void añadirArticulos(Hashtable<String, Double> StockProductos) {
		String NombreArticulo;
		String PrecioTexto;
		double Precio;
		String PedirArticulos = "SI";
		
		NombreArticulo = JOptionPane.showInputDialog("Introdiuce el nombre del articulo:");
		
		PrecioTexto = JOptionPane.showInputDialog("Introdiuce el precio:");
		Precio = Double.parseDouble(PrecioTexto);
		
		StockProductos.put(NombreArticulo, Precio);

		PedirArticulos = JOptionPane.showInputDialog("¿Desea entrar otro articulo? [ SI | NO ]");
		PedirArticulos = PedirArticulos.toUpperCase();
		
		if(PedirArticulos.equals("SI")) {
			añadirArticulos(StockProductos);	
		} else {
			accionRealizar(StockProductos);
		}
	}
	
	public static void mostrarArticulos(Hashtable<String, Double> StockProductos){
		Enumeration <String> Productos = StockProductos.keys();
		Enumeration<Double> Precios = StockProductos.elements();
		
		System.out.println("Lista de stock de productos");
		System.out.println("");
		while (Productos.hasMoreElements()) {
			//Aqui sale la id inversa y no se como cambiarlo
			System.out.println(Productos.nextElement());
			System.out.println("Precio: " + Precios.nextElement());
			System.out.println("");
		}
	}
}
