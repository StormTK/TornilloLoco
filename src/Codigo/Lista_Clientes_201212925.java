package Codigo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;


public class Lista_Clientes_201212925 {
	Nodo_Clientes_201212925 PrimerCliente;
	Nodo_Clientes_201212925 ClienteActual;
	Nodo_Clientes_201212925 UltimoClienteRegistrado;
    int tamano;
    private File Clientes = new File("Cliente.csv");
	
    public Lista_Clientes_201212925(){
        this.PrimerCliente = null;
        this.UltimoClienteRegistrado = null;
        this.tamano = 0;
    }
    
    public int numClientes(){
    	return tamano;
    }
    
    public boolean Empty(){
    	if(PrimerCliente == null){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public void addCliente(int codigo, String dpi, String name, String apellido, String telefono, String celular) {
        if(Empty() == true) {
        	Nodo_Clientes_201212925 nuevo_Cliente = new Nodo_Clientes_201212925(codigo, dpi, name, apellido, telefono, celular);
            PrimerCliente = nuevo_Cliente;
            UltimoClienteRegistrado = nuevo_Cliente;
            nuevo_Cliente.Derecha = null;
            nuevo_Cliente.Izquierda = null;
        }
        else {
        	Nodo_Clientes_201212925 Nuevo_Cliente = new Nodo_Clientes_201212925(codigo, dpi, name, apellido, telefono, celular);
        	Nuevo_Cliente.Derecha = null;
        	UltimoClienteRegistrado.Derecha = Nuevo_Cliente;
        	Nuevo_Cliente.Izquierda = UltimoClienteRegistrado;
        	UltimoClienteRegistrado = Nuevo_Cliente;
        }
        tamano++;
    }
    
    public int tamañolistaClientes(){
    	return tamano;
    }
    
    public void GuardarLista(){
    	if(Empty() == true){
    		FileWriter Archivo;
			try {
				Archivo = new FileWriter(Clientes);
				PrintWriter Escritor = new PrintWriter(Archivo);
				Escritor.print("");
				Archivo.close();
			} catch (IOException e) {
			
			}
    	}else{
	    	ClienteActual = PrimerCliente;
	    	Nodo_Clientes_201212925 Nodo_temp_Siguiente = null;
	    	int tam_temp = tamano;
	    	String Datos = "";
	    	FileWriter Archivo;
			PrintWriter Escritor;
			if(!(tam_temp == 0)){
				try {
					do{
						Archivo = new FileWriter(Clientes);
						Escritor = new PrintWriter(Archivo);
						Datos += ClienteActual.codigo + ";" + ClienteActual.DPI + ";" + ClienteActual.name +  ";" + ClienteActual.apellido + ";" + ClienteActual.telefono + ";"  + ClienteActual.celular +"\n";
						Nodo_temp_Siguiente = ClienteActual.Derecha;
						ClienteActual = Nodo_temp_Siguiente;
						tam_temp--;
					}while(tam_temp > 0);
					Escritor.print(Datos);
					Archivo.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null,"Error! Reinicie el Programa!");
				}
			}
    	}
    }
    
    public void Modificar(int numIteracion){
    	ClienteActual = PrimerCliente;
    	Nodo_Clientes_201212925 Nodo_temp_Siguiente = null;
    	for(int x = 0; x < numIteracion; x++){
	    	Nodo_temp_Siguiente = ClienteActual.Derecha;
	    	ClienteActual = Nodo_temp_Siguiente;
	    }
    }
    
    public int UltimoCodigo(){
    	if(Empty() == true){
    		return 0;
    	}else{
    		return UltimoClienteRegistrado.codigo;
    	}
    }
    
    public void Eliminar(int numIteracion){
    	Modificar(numIteracion);
    	Nodo_Clientes_201212925 Nodo_temp_iz = null;
    	Nodo_Clientes_201212925 Nodo_temp_de = null;
    	if(tamano == 1){
    		PrimerCliente = null;
    		ClienteActual.Izquierda = null;
    		ClienteActual.Derecha = null;
    	}else{
    		if(ClienteActual == UltimoClienteRegistrado){
    			ClienteActual.Izquierda = UltimoClienteRegistrado;
    			UltimoClienteRegistrado.Derecha = null;
        		ClienteActual.Izquierda = null;
        	}else{
	    		Nodo_temp_iz = ClienteActual.Izquierda;
	    		Nodo_temp_de = ClienteActual.Derecha;
	        	Nodo_temp_iz.Derecha = Nodo_temp_de;
	        	Nodo_temp_de.Izquierda = Nodo_temp_iz;
	        	ClienteActual.Derecha = null;
	        	ClienteActual.Izquierda = null;
        	}
	    	tamano--;
    	}
    }
    
    public void setVariable(int codigo, String dpi, String name, String apellido, String telefono, String celular){
        ClienteActual.name = name;
        ClienteActual.telefono = telefono;
        ClienteActual.apellido = apellido;
        ClienteActual.celular = celular;
        ClienteActual.DPI = dpi;
    	ClienteActual.codigo = codigo;
    }
    
    public int getCodigo(){
    	return ClienteActual.codigo;
    }
    
    public String getNombre(){
    	return ClienteActual.name;
    }
    
    public String getApellido(){
    	return ClienteActual.apellido;
    }
    
    public String getTelefono(){
    	return ClienteActual.telefono;
    }
    
    public String getCelular(){
    	return ClienteActual.celular;
    }
    
    public String getDPI(){
    	return ClienteActual.DPI;
    }
    
}
