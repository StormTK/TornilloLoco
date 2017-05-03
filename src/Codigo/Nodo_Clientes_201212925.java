package Codigo;

public class Nodo_Clientes_201212925 {

	String name, apellido, telefono, celular, DPI;
	int codigo;
	public Nodo_Clientes_201212925 Derecha, Izquierda;
		
	public Nodo_Clientes_201212925(int codigo, String dpi, String name, String apellido, String telefono, String celular){
		this.codigo = codigo;
		this.DPI = dpi;
		this.name = name;
		this.telefono = telefono;
		this.apellido = apellido;
		this.telefono = telefono;
		this.celular = celular;
		this.Derecha = null;
		this.Izquierda = null;
	}
	
}
