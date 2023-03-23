import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JOptionPane;

public class TA07Ejercicio4App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declaración de variables
		
		Hashtable<String, Double> StockProductos=new Hashtable<String, Double>();
		ArrayList<String> CarroCompra = new ArrayList<String>();
		
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
		
		accionRealizar(StockProductos, CarroCompra);
	}
	
	public static void accionRealizar(Hashtable<String, Double> StockProductos, ArrayList<String> CarroCompra) {
		String AccionRealizar; 
		
		AccionRealizar = JOptionPane.showInputDialog("¿Que acción desea realizar? [ AÑADIR | VER | COMPRAR | SALIR ] articulos");
		AccionRealizar = AccionRealizar.toUpperCase();  
		
		switch (AccionRealizar) {
			case "AÑADIR":
				añadirArticulos(StockProductos, CarroCompra);
			break;
			case "VER":
				mostrarArticulos(StockProductos);
			break;
			case "COMPRAR":
				comprar(StockProductos, CarroCompra);
			break;
			case "SALIR":
				
			break;
		}
	}
	
	public static void añadirArticulos(Hashtable<String, Double> StockProductos, ArrayList<String> CarroCompra) {
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
			añadirArticulos(StockProductos, CarroCompra);	
		} else {
			accionRealizar(StockProductos, CarroCompra);
		}
	}
	
	public static void mostrarArticulos(Hashtable<String, Double> StockProductos){
		Enumeration <String> Productos = StockProductos.keys();
		Enumeration<Double> Precios = StockProductos.elements();
		String Producto = "";
		String ListadoProductos = "";
		

		while (Productos.hasMoreElements()) {
			//Aqui sale la id inversa y no se como cambiarlo
			Producto = "\n" + Productos.nextElement() + "\n" + "Precio: " + Precios.nextElement() + "\n";
			ListadoProductos = ListadoProductos + Producto;
		}
		JOptionPane.showMessageDialog(null, "Productos en stock\n" + ListadoProductos);
	}
	
	public static void comprar(Hashtable<String, Double> StockProductos, ArrayList<String> CarroCompra) {
		String NumeroArticulos;
		String IvaAplicado;
		int Iva;
		String PrecioBrutoTexto;
		double PrecioBruto;
		double PrecioConIva;
		String PrecioConIvaTexto;
		String CantidadPagadaTexto;
		double CantidadPagada;
		String Cambio;

		NumeroArticulos = JOptionPane.showInputDialog("Introdiuce el número de articulos comprados:");
		
		IvaAplicado = JOptionPane.showInputDialog("Introdiuce el iva apricado: [ 21% | 4% ]");
		Iva = Integer.parseInt(IvaAplicado);
	
		PrecioConIvaTexto = JOptionPane.showInputDialog("Introdiuce el precio");
		PrecioConIva = Double.parseDouble(PrecioConIvaTexto);
		
		PrecioBruto = calcularPrecioBruto(Iva, PrecioConIva);
		PrecioBrutoTexto = PrecioBruto + "";
		
		CantidadPagadaTexto = JOptionPane.showInputDialog("Introdiuce la cantidad pagada");
		CantidadPagada = Double.parseDouble(CantidadPagadaTexto);
		
		Cambio = "" + (CantidadPagada - PrecioConIva);

		CarroCompra.add(NumeroArticulos);
		CarroCompra.add(IvaAplicado+"%");
		CarroCompra.add(PrecioConIvaTexto);
		CarroCompra.add(PrecioBrutoTexto);
		CarroCompra.add(CantidadPagadaTexto);
		CarroCompra.add(Cambio);
		
		mostrarCarro(CarroCompra);
	}
	
	public static double calcularPrecioBruto(int Iva, double Precio) {
		double PrecioBruto;
		
		if (Iva == 21) {
			PrecioBruto = Precio / 1.21;
		} else {
			PrecioBruto = Precio / 1.04;
		}
		return PrecioBruto;
	}
	
	public static void mostrarCarro(ArrayList<String> CarroCompra){
        System.out.println("Cantidad de articulos comprados: " + CarroCompra.get(0) + "\n" +
        					"Iva aplicado: " + CarroCompra.get(1) + "\n" +
        					"Precio total: " + CarroCompra.get(2) + "\n" +
        					"Precio sin Iva: " + CarroCompra.get(3) + "\n" +
        					"Cantidad pagada: " + CarroCompra.get(4) + "\n" +
        					"Cantidad a devolver: " + CarroCompra.get(5) + "\n ");
		
	}
}
