package Codigo;

public class Nodo_Producto_201212925 {
	float Precio_no_IVA;
	long Cantidad, Codigo;
	String Nombre;
	public Nodo_Producto_201212925 Derecha, Izquierda;
		
	public Nodo_Producto_201212925(long Codigo, String Nombre, long cantidad, float sin_Iva){
		this.Cantidad = cantidad;
		this.Codigo = Codigo;
		this.Precio_no_IVA = sin_Iva;
		this.Nombre = Nombre;
		this.Derecha = null;
		this.Izquierda = null;
	}
	
}
