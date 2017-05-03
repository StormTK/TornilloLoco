package Codigo;

public class Nodo_Usuarios_201212925 {
	String name, telefono, direccion, fecha, tipo, usuario, password;
	int codigo, edad;
	public Nodo_Usuarios_201212925 Derecha, Izquierda;
	
	public Nodo_Usuarios_201212925(int codigo, String name, int edad, String telefono, String direccion, String fecha, String usuario, String password, String tipo){
		this.codigo = codigo;
		this.name = name;
		this.edad = edad;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fecha = fecha;
		this.usuario = usuario;
		this.password = password;
		this.tipo = tipo;
		this.Derecha = null;
		this.Izquierda = null;
	}
	
	public int getEdad(){
		return edad;
	}
	
	public void setCodigo(int codigo){
		this.codigo = codigo;
	}

}
