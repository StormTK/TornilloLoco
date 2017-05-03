package Codigo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Lista_Producto_201212925 {
	Nodo_Producto_201212925 PrimerProducto;
	Nodo_Producto_201212925 ProductoActual;
	Nodo_Producto_201212925 UltimoProductoRegistrado;
    int tamano;
    private File Productos = new File("Producto.csv");
    
    public Lista_Producto_201212925() {
        this.PrimerProducto = null;
        this.UltimoProductoRegistrado = null;
        this.tamano = 0;
    }
    
    public long UltimoCodigo(){
    	return UltimoProductoRegistrado.Codigo;
    }
    
    public boolean Empty(){
    	if(PrimerProducto == null){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public void add(long Codigo, String Nombre, long cantidad, float sin_Iva){
        if(Empty() == true) {
        	Nodo_Producto_201212925 nuevo_Usuario = new Nodo_Producto_201212925(Codigo, Nombre, cantidad, sin_Iva);
            PrimerProducto = nuevo_Usuario;
            UltimoProductoRegistrado = nuevo_Usuario;
            nuevo_Usuario.Derecha = null;
            nuevo_Usuario.Izquierda = null;
        }
        else {
        	Nodo_Producto_201212925 nuevo_Producto = new Nodo_Producto_201212925(Codigo, Nombre, cantidad, sin_Iva);
        	nuevo_Producto.Derecha = null;
        	UltimoProductoRegistrado.Derecha = nuevo_Producto;
        	nuevo_Producto.Izquierda = UltimoProductoRegistrado;
        	UltimoProductoRegistrado = nuevo_Producto;
        }
        tamano++;
    }
    
    public int tamañoUsuarios(){
    	return tamano;
    }
    
    public void GuardarLista(){
    	if(Empty() == true){
    		FileWriter Archivo;
			try {
				Archivo = new FileWriter(Productos);
				PrintWriter Escritor = new PrintWriter(Archivo);
				Escritor.print("");
				Archivo.close();
			} catch (IOException e) {
			
			}
    	}else{
    		ProductoActual = PrimerProducto;
        	Nodo_Producto_201212925 Nodo_temp_Siguiente = null;
        	int tam_temp = tamano;
        	String Datos = "";
        	FileWriter Archivo;
    		PrintWriter Escritor;
    		try {
    			do{
    				Archivo = new FileWriter(Productos);
    				Escritor = new PrintWriter(Archivo);
    				Datos += ProductoActual.Codigo + ";" + ProductoActual.Nombre + ";" + ProductoActual.Cantidad + ";" + ProductoActual.Precio_no_IVA + "\n";
    				Nodo_temp_Siguiente = ProductoActual.Derecha;
    				ProductoActual = Nodo_temp_Siguiente;
    				tam_temp--;
    			}while(tam_temp > 0);
    			Escritor.print(Datos);
    			Archivo.close();
    		} catch (IOException e) {
    			JOptionPane.showMessageDialog(null,"Error! Reinicie el Programa!");
    		}
    	}
    	
    	
    }
    
    public void Modificar(int numIteracion){
    	ProductoActual = PrimerProducto;
    	Nodo_Producto_201212925 Nodo_temp_Siguiente = null;
    	for(int x = 0; x < numIteracion; x++){
	    	Nodo_temp_Siguiente = ProductoActual.Derecha;
	    	ProductoActual = Nodo_temp_Siguiente;
	    }
    }
    
    public void Eliminar(int numIteracion){
    	Modificar(numIteracion);
    	Nodo_Producto_201212925 Nodo_temp_iz = null;
    	Nodo_Producto_201212925 Nodo_temp_de = null;
    	if(tamano == 1 ){
    		PrimerProducto = null;
    		ProductoActual.Izquierda = null;
    		ProductoActual.Derecha = null;
    	}
    	else{
    		
    		if(ProductoActual == UltimoProductoRegistrado){
    			ProductoActual.Izquierda = UltimoProductoRegistrado;
    			UltimoProductoRegistrado.Derecha = null;
        		ProductoActual.Izquierda = null;
        	}else{
	    		Nodo_temp_iz = ProductoActual.Izquierda;
	    		Nodo_temp_de = ProductoActual.Derecha;
	        	Nodo_temp_iz.Derecha = Nodo_temp_de;
	        	Nodo_temp_de.Izquierda = Nodo_temp_iz;
	        	ProductoActual.Derecha = null;
	        	ProductoActual.Izquierda = null;
        	}
	    	tamano--;
    	}
    }
    
    public void setVariable(long Codigo, String Nombre, long cantidad, float sin_Iva){
        ProductoActual.Codigo = Codigo;
        ProductoActual.Nombre = Nombre;
        ProductoActual.Cantidad = cantidad;
        ProductoActual.Precio_no_IVA = sin_Iva;
    }
    
    public long getCodigo(){
    	return ProductoActual.Codigo;
    }
    
    public String getNombre(){
    	return ProductoActual.Nombre;
    }
    
    public long getCantidad(){
    	return ProductoActual.Cantidad;
    }
    
    public float getPrecio(){
    	return ProductoActual.Precio_no_IVA;
    }
    
}
