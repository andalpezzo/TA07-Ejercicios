import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TA07Ejercicio2App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ArrayList<String> CarroCompra = new ArrayList<String>();
		pedirCarro(CarroCompra);
	}
	
	
	public static void pedirCarro(ArrayList<String> CarroCompra) {
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
