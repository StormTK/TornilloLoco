package Codigo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Lista_Usuarios_201212925 {
	Nodo_Usuarios_201212925 PrimerUsuario;
	Nodo_Usuarios_201212925 UsuarioActual;
	Nodo_Usuarios_201212925 UltimoUsuarioRegistrado;
    int tamano;
    private File Usuarios = new File("Empleado.csv");
    
    public Lista_Usuarios_201212925() {
        this.PrimerUsuario = null;
        this.UltimoUsuarioRegistrado = null;
        this.tamano = 0;
    }
    
    public int UltimoCodigo(){
    	return UltimoUsuarioRegistrado.codigo;
    }
    
    public boolean Empty(){
    	if(PrimerUsuario == null){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public void addEmpleado(int codigo, String name, int edad, String telefono, String direccion, String fecha, String usuario, String password, String tipo) {
        if(Empty() == true) {
        	Nodo_Usuarios_201212925 nuevo_Usuario = new Nodo_Usuarios_201212925(codigo, name, edad, telefono, direccion, fecha, usuario, password, tipo);
            PrimerUsuario = nuevo_Usuario;
            UltimoUsuarioRegistrado = nuevo_Usuario;
            nuevo_Usuario.Derecha = null;
            nuevo_Usuario.Izquierda = null;
        }
        else {
        	Nodo_Usuarios_201212925 nuevo_Usuario = new Nodo_Usuarios_201212925(codigo, name, edad, telefono, direccion, fecha, usuario, password, tipo);
        	nuevo_Usuario.Derecha = null;
        	UltimoUsuarioRegistrado.Derecha = nuevo_Usuario;
        	nuevo_Usuario.Izquierda = UltimoUsuarioRegistrado;
        	UltimoUsuarioRegistrado = nuevo_Usuario;
        }
        tamano++;
    }
    
    public int tamañoUsuarios(){
    	return tamano;
    }
    
    public void GuardarLista(){
    	
    	UsuarioActual = PrimerUsuario;
    	Nodo_Usuarios_201212925 Nodo_temp_Siguiente = null;
    	int tam_temp = tamano;
    	String Datos = "";
    	FileWriter Archivo;
		PrintWriter Escritor;
		try {
			do{
				Archivo = new FileWriter(Usuarios);
				Escritor = new PrintWriter(Archivo);
				Datos += UsuarioActual.codigo + ";" + UsuarioActual.name + ";" + UsuarioActual.edad + ";" + UsuarioActual.telefono + ";" + UsuarioActual.direccion + ";" + UsuarioActual.fecha + ";" + UsuarioActual.usuario + ";" + UsuarioActual.password + ";" + UsuarioActual.tipo +"\n";
				Nodo_temp_Siguiente = UsuarioActual.Derecha;
				UsuarioActual = Nodo_temp_Siguiente;
				tam_temp--;
			}while(tam_temp > 0);
			Escritor.print(Datos);
			Archivo.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Error! Reinicie el Programa!");
		}
    }
    
    public void OrdenarCodigo(){
    	UsuarioActual = PrimerUsuario;
    	Nodo_Usuarios_201212925 Nodo_temp_siguiente = UsuarioActual.Derecha;
    	Nodo_Usuarios_201212925 Nodo_temp = PrimerUsuario;
    		for(int x = 0; x < (tamano - 1); x++){
    			for(int y = x+1; y < tamano; y++){
    				if(UsuarioActual.codigo < Nodo_temp_siguiente.codigo){
    					Nodo_temp = UsuarioActual;
    					UsuarioActual = Nodo_temp_siguiente;
    					UsuarioActual.Derecha = Nodo_temp.Derecha;
    					UsuarioActual.Izquierda = Nodo_temp.Izquierda;
    					Nodo_temp.Derecha = Nodo_temp_siguiente.Derecha;
    					Nodo_temp.Izquierda = Nodo_temp_siguiente.Izquierda;
    					Nodo_temp_siguiente = Nodo_temp;
    				}
    				Nodo_temp = Nodo_temp_siguiente;
	    			Nodo_temp_siguiente = Nodo_temp.Derecha;
    			}
    			Nodo_temp = UsuarioActual;
    			UsuarioActual = Nodo_temp.Derecha;
    			Nodo_temp_siguiente = UsuarioActual.Derecha;
    		}
    }
    
    public void OrdenarEdad(){
    	UsuarioActual = PrimerUsuario;
    	Nodo_Usuarios_201212925 Nodo_temp_derecho = UsuarioActual.Derecha;
    	Nodo_Usuarios_201212925 Nodo_temp = null;
    		for(int x = 0; x < (tamano - 1); x++){
    			for(int y = (x + 1); y > tamano; y++){
    			
    				if(UsuarioActual.getEdad() > Nodo_temp_derecho.getEdad()){
    					Nodo_temp = UsuarioActual;
    					UsuarioActual = Nodo_temp_derecho;
    					UsuarioActual.Derecha = Nodo_temp.Derecha;
    					UsuarioActual.Izquierda = Nodo_temp.Izquierda;
    					Nodo_temp.Derecha = Nodo_temp_derecho.Derecha;
    					Nodo_temp.Izquierda = Nodo_temp_derecho.Izquierda;
    					Nodo_temp_derecho = Nodo_temp;
    				}
    				
    				if(UsuarioActual.getEdad() == Nodo_temp_derecho.getEdad()){
    					if(UsuarioActual.codigo < Nodo_temp_derecho.codigo){
        					Nodo_temp = UsuarioActual;
        					UsuarioActual = Nodo_temp_derecho;
        					UsuarioActual.Derecha = Nodo_temp.Derecha;
        					UsuarioActual.Izquierda = Nodo_temp.Izquierda;
        					Nodo_temp.Derecha = Nodo_temp_derecho.Derecha;
        					Nodo_temp.Izquierda = Nodo_temp_derecho.Izquierda;
        					Nodo_temp_derecho = Nodo_temp;
        				}
    				}
    				Nodo_temp = Nodo_temp_derecho;
	    			Nodo_temp_derecho = Nodo_temp.Derecha;
    			}
    			Nodo_temp = UsuarioActual;
    			UsuarioActual = Nodo_temp.Derecha;
    			Nodo_temp_derecho = UsuarioActual.Derecha;
    		}
    }
    
    public void Modificar(int numIteracion){
    	UsuarioActual = PrimerUsuario;
    	Nodo_Usuarios_201212925 Nodo_temp_Siguiente = null;
    	for(int x = 0; x < numIteracion; x++){
	    	Nodo_temp_Siguiente = UsuarioActual.Derecha;
	    	UsuarioActual = Nodo_temp_Siguiente;
	    }
    }
    
    public void Eliminar(int numIteracion){
    	Modificar(numIteracion);
    	Nodo_Usuarios_201212925 Nodo_temp_iz = null;
    	Nodo_Usuarios_201212925 Nodo_temp_de = null;
    	if(tamano == 1 || UsuarioActual == PrimerUsuario){
    		JOptionPane.showMessageDialog(null,"No se Puede Borrar esta Cuenta de Administrador!");
    	}
    	else{
    		
    		if(UsuarioActual == UltimoUsuarioRegistrado){
    			UsuarioActual.Izquierda = UltimoUsuarioRegistrado;
    			UltimoUsuarioRegistrado.Derecha = null;
        		UsuarioActual.Izquierda = null;
        	}else{
	    		Nodo_temp_iz = UsuarioActual.Izquierda;
	    		Nodo_temp_de = UsuarioActual.Derecha;
	        	Nodo_temp_iz.Derecha = Nodo_temp_de;
	        	Nodo_temp_de.Izquierda = Nodo_temp_iz;
	        	UsuarioActual.Derecha = null;
	        	UsuarioActual.Izquierda = null;
        	}
	    	tamano--;
    	}
    }
    
    public void setVariable(int codigo, String name, int edad, String telefono, String direccion, String fecha, String usuario, String password, String tipo){
        UsuarioActual.name = name;
        UsuarioActual.telefono = telefono;
        UsuarioActual.direccion = direccion;
        UsuarioActual.fecha = fecha;
        UsuarioActual.usuario = usuario;
        UsuarioActual.password = password;
        UsuarioActual.tipo = tipo;
    	UsuarioActual.codigo = codigo;
        UsuarioActual.edad = edad;
    }
    
    public int getCodigo(){
    	return UsuarioActual.codigo;
    }
    
    public String getNombre(){
    	return UsuarioActual.name;
    }
    
    public int getEdad(){
    	return UsuarioActual.edad;
    }
    
    public String getTelefono(){
    	return UsuarioActual.telefono;
    }
    
    public String getDireccion(){
    	return UsuarioActual.direccion;
    }
    
    public String getUsuario(){
    	return UsuarioActual.usuario;
    }
    
    public String getPassword(){
    	return UsuarioActual.password;
    }
    
    public String getFecha(){
    	return UsuarioActual.fecha;
    }
    
    public String getTipo(){
    	return UsuarioActual.tipo;
    }
}
