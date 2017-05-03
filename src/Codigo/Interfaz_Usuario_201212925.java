package Codigo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Interfaz_Usuario_201212925 extends JFrame {
	private File Usuarios = new File("Empleado.csv");
	private File Clientes = new File("Cliente.csv");
	private File Productos = new File("Producto.csv");
	JTabbedPane Tbp_Tablero;
	JPanel Pnl_Reporte, Pnl_Producto, Pnl_Empleados, Pnl_Clientes, Pnl_Ventas;
	JLabel txt_nombre_modulo, txt_Usuario_modulo, lbl_empleado_ordenar, txt_empleados_fecha,  txt_cliente_codigo, lbl_producto_ordenar;
	JButton Btn_Salir, btn_empleado_nuevo, btn_empleado_editar, btn_empleado_eliminar, btn_empleado_guardar, btn_clientes_nuevo, btn_clientes_editar, btn_clientes_eliminar, btn_producto_nuevo, btn_producto_editar, btn_producto_eliminar, btn_producto_cargar;
	JTable Tabla_Empleados, Tabla_Clientes, Tabla_Producto;
	JScrollPane Scrooll_tabla_Empleados, Scrooll_tabla_Clientes, Scrooll_tabla_Producto;
	Lista_Usuarios_201212925 ListaUsuarios = new Lista_Usuarios_201212925();
	Lista_Clientes_201212925 ListaClientes = new Lista_Clientes_201212925();
	Lista_Producto_201212925 ListaProductos = new Lista_Producto_201212925();
	JComboBox<String> ordenamiento_usuarios, ordenamiento_producto; 
	
	public Interfaz_Usuario_201212925(String Usuario, String NombreUsuario, String CodigoUsuario){
		setTitle("Ferreteria \"El Tornillo Loco\" S.A.");//Titulo de la Aplicación
		setSize(806,526);//Tamaño 800*600
		setResizable(false);//No permite cambiar el tamaño de la pantalla
		setLocationRelativeTo(null);//Lo coloca en el centro de la pantalla
		setDefaultCloseOperation(EXIT_ON_CLOSE);//Poder cerrar la aplicacion
		setLayout(null);
		
		txt_nombre_modulo = new JLabel();
		txt_Usuario_modulo = new JLabel();
		
		//Para Todos los usuarios
		Tbp_Tablero = new JTabbedPane();  
        
        Btn_Salir = new JButton();
        
        if(Usuario.equals("Administrador")){ 
        	Pnl_Empleados = new JPanel();
        	Tbp_Tablero.addTab("Empleados", Pnl_Empleados);
        	InterfazUsuarios();
        	
        	Pnl_Clientes = new JPanel();
        	Tbp_Tablero.addTab("Clientes", Pnl_Clientes);
        	InterfazClientes();
        	
        	Pnl_Producto = new JPanel();
        	Tbp_Tablero.addTab("Producto", Pnl_Producto);
        	InterfazProducto();
        	
        	Pnl_Reporte = new JPanel();
        	Tbp_Tablero.addTab("Reporte", Pnl_Reporte);
            
            
            txt_nombre_modulo.setText("Modulo Administrador");
            
        }else{
        	Pnl_Clientes = new JPanel();
            Tbp_Tablero.addTab("Clientes", Pnl_Clientes);
            InterfazClientes();
            
            Pnl_Ventas = new JPanel();
            Tbp_Tablero.addTab("Ventas", Pnl_Ventas);
            
            txt_nombre_modulo.setText("Modulo Vendedor");
        }
        
   
        
        txt_nombre_modulo.setBounds(40,10,200,15);
        txt_nombre_modulo.setFont(new Font("Helvetica", Font.BOLD, 14));
        
        txt_Usuario_modulo.setText("Usuario: " + NombreUsuario);
        txt_Usuario_modulo.setBounds(60,30,400,30);
        txt_Usuario_modulo.setFont(new Font("Helvetica", Font.BOLD, 20));
        
        Tbp_Tablero.setBounds(40, 70, 720, 400);
        
        Btn_Salir.setText("Cerrar Sesión");
        Btn_Salir.setBounds(630,20,130,30);
        Btn_Salir.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
				Login_Interfaz_201212925 salir = new Login_Interfaz_201212925();
				salir.setVisible(true);
				setVisible(false);
			}
        
        });
        
        getContentPane().add(Btn_Salir);
        getContentPane().add(txt_Usuario_modulo);
        getContentPane().add(txt_nombre_modulo);
        getContentPane().add(Tbp_Tablero);
	}
	
	public void Empleados(){//------------------------------Frame para agregar Empleados---------------------------------------------------------	
		final JFrame Empleados = new JFrame();
		Empleados.setSize(656, 526);
		Empleados.setResizable(false);//No permite cambiar el tamaño de la pantalla
		Empleados.setLocationRelativeTo(null);//Lo coloca en el centro de la pantalla
		Empleados.setDefaultCloseOperation(HIDE_ON_CLOSE);//Poder cerrar la aplicacion
		Empleados.setVisible(true);
		Panel_201212925 AgregarEmpleados = new Panel_201212925(new ImageIcon(this.getClass().getResource("/Imagenes/Fondo_Empleado.png")).getImage());
		JLabel ImagenUsuario = new JLabel();
		final JTextField txt_empleados_direccion = new JTextField();
		final JTextField txt_empleados_nombre = new JTextField();
		final JTextField txt_empleados_Contraseña = new JTextField();
		final JTextField txt_empleados_edad = new JTextField();
		final JTextField txt_empleados_telefono = new JTextField();
		final JLabel txt_empleados_fecha = new JLabel();
		final JTextField txt_empleados_usuario = new JTextField();
		final JLabel txt_empleados_codigo = new JLabel();
		
		JButton Agregar_Imagen = new JButton();
        JButton Aceptar = new JButton();
        JButton Limpiar = new JButton();
        JButton Salir = new JButton();
        final JComboBox<String> tipo_usuario = new JComboBox<String>();

        ImagenUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImagenUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AgregarEmpleados.add(ImagenUsuario);
        ImagenUsuario.setBounds(30, 20, 160, 160);
        
        //Obtiene el Calendario
        Calendar Fecha_Ingreso = new GregorianCalendar();
        int año = Fecha_Ingreso.get(Calendar.YEAR);
        int mes = Fecha_Ingreso.get(Calendar.MONTH);
        int dia = Fecha_Ingreso.get(Calendar.DAY_OF_MONTH);
        	
        txt_empleados_codigo.setText(String.valueOf(ListaUsuarios.UltimoCodigo() + 1));
        txt_empleados_nombre.setText("");
        txt_empleados_edad.setText("");
        txt_empleados_telefono.setText("");
        txt_empleados_direccion.setText("");
        txt_empleados_usuario.setText("");
        txt_empleados_Contraseña.setText("");
        txt_empleados_fecha.setText(dia+"/"+mes+"/"+año);
        tipo_usuario.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "Administrador", "Vendedor" }));
        	 
        Aceptar.setText("Registrar");
        AgregarEmpleados.add(Aceptar);  
        Aceptar.setBounds(160, 450, 90, 30);
        Aceptar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
	        	if( (!(txt_empleados_nombre.getText().equals(""))) && (!(txt_empleados_edad.getText().equals(""))) && (!(txt_empleados_telefono.getText().equals(""))) && (!(txt_empleados_direccion.getText().equals(""))) && (!(txt_empleados_fecha.getText().equals(""))) && (!(txt_empleados_usuario.getText().equals(""))) && (!(txt_empleados_Contraseña.getText().equals(""))) ){
	        		String TipoUser = (String) tipo_usuario.getSelectedItem();
	                DefaultTableModel Tabla_LogModel = (DefaultTableModel) Tabla_Empleados.getModel();				 
	         		ListaUsuarios.addEmpleado(Integer.parseInt(txt_empleados_codigo.getText()),txt_empleados_nombre.getText(),Integer.parseInt(txt_empleados_edad.getText()),txt_empleados_telefono.getText(),txt_empleados_direccion.getText(), txt_empleados_fecha.getText(),txt_empleados_usuario.getText(),txt_empleados_Contraseña.getText(),TipoUser);
	         		Object nuevaFila[]= {txt_empleados_codigo.getText(), txt_empleados_nombre.getText(), txt_empleados_edad.getText(), txt_empleados_telefono.getText(), txt_empleados_direccion.getText(), txt_empleados_fecha.getText(),txt_empleados_usuario.getText(),txt_empleados_Contraseña.getText(),TipoUser};
	         		Tabla_LogModel.addRow(nuevaFila);
	         		ListaUsuarios.GuardarLista();
	         		Empleados.setVisible(false);
	        	}else{
	        		JOptionPane.showMessageDialog(null,"Se deben de llenar todas los requisitos!");
	        	}
     		} 
        });   
        
        txt_empleados_nombre.setBounds(230, 70, 150, 30);
        AgregarEmpleados.add(txt_empleados_nombre);
        
        txt_empleados_direccion.setBounds(360, 210, 250, 30);
        AgregarEmpleados.add(txt_empleados_direccion);
        
        AgregarEmpleados.add(txt_empleados_Contraseña);
        txt_empleados_Contraseña.setBounds(360, 330, 250, 30);

        AgregarEmpleados.add(txt_empleados_edad);
        txt_empleados_edad.setBounds(460, 70, 150, 30);

        AgregarEmpleados.add(txt_empleados_telefono);
        txt_empleados_telefono.setBounds(230, 140, 150, 30);
        
        txt_empleados_fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); 
        txt_empleados_fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AgregarEmpleados.add(txt_empleados_fecha);
        txt_empleados_fecha.setBounds(220, 410, 190, 30);
  
        AgregarEmpleados.add(txt_empleados_usuario);
        txt_empleados_usuario.setBounds(360, 270, 250, 30);
        
        txt_empleados_codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_empleados_codigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AgregarEmpleados.add(txt_empleados_codigo);
        txt_empleados_codigo.setBounds(460, 140, 150, 30);
        
        AgregarEmpleados.add(tipo_usuario);
        tipo_usuario.setBounds(50, 270, 130, 30);

        Agregar_Imagen.setText("Agregar Imagen");
        Agregar_Imagen.setToolTipText("");
        AgregarEmpleados.add(Agregar_Imagen);
        Agregar_Imagen.setBounds(40, 190, 150, 30);

        Limpiar.setText("Reiniciar");
        AgregarEmpleados.add(Limpiar);
        Limpiar.setBounds(260, 450, 90, 30);
        Limpiar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		txt_empleados_nombre.setText(""); 
        		txt_empleados_edad.setText(""); 
        		txt_empleados_telefono.setText(""); 
        		txt_empleados_direccion.setText(""); 
        		txt_empleados_usuario.setText("");
        		txt_empleados_Contraseña.setText("");
			}
        
        });

        Salir.setText("Salir");
        AgregarEmpleados.add(Salir);
        Salir.setBounds(360, 450, 90, 30);
        Salir.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		Empleados.setVisible(false);
			}
        
        }); 
        
        Empleados.getContentPane().add(AgregarEmpleados);
	}
	
    public void Empleados(final int codigo, String name, int edad, String telefono, String direccion, String fecha, String usuario, String password, String tipo, final int numfil){//------------------------------Frame para agregar Empleados---------------------------------------------------------	
    	final JFrame Empleados = new JFrame();
		Empleados.setSize(656, 526);
		Empleados.setResizable(false);//No permite cambiar el tamaño de la pantalla
		Empleados.setLocationRelativeTo(null);//Lo coloca en el centro de la pantalla
		Empleados.setDefaultCloseOperation(HIDE_ON_CLOSE);//Poder cerrar la aplicacion
		Empleados.setVisible(true);
		Panel_201212925 AgregarEmpleados = new Panel_201212925(new ImageIcon(this.getClass().getResource("/Imagenes/Fondo_Empleado.png")).getImage());
		JLabel ImagenUsuario = new JLabel();
		final JTextField txt_empleados_direccion = new JTextField();
		final JTextField txt_empleados_nombre = new JTextField();
		final JTextField txt_empleados_Contraseña = new JTextField();
		final JTextField txt_empleados_edad = new JTextField();
		final JTextField txt_empleados_telefono = new JTextField();
		final JLabel txt_empleados_fecha = new JLabel();
		final JTextField txt_empleados_usuario = new JTextField();
		final JLabel txt_empleados_codigo = new JLabel();

        ImagenUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImagenUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AgregarEmpleados.add(ImagenUsuario);
        ImagenUsuario.setBounds(30, 20, 160, 160);
        
        txt_empleados_codigo.setText(String.valueOf(codigo));
   	 	txt_empleados_nombre.setText(name);
        txt_empleados_edad.setText(String.valueOf(edad));
        txt_empleados_telefono.setText(telefono);
   	 	txt_empleados_direccion.setText(direccion);
   	 	txt_empleados_fecha.setText(fecha);
        txt_empleados_usuario.setText(usuario);      	 	
   	 	txt_empleados_Contraseña.setText(password);
   	 	
	   	JButton Agregar_Imagen = new JButton();
	    JButton Aceptar = new JButton();
	    JButton Limpiar = new JButton();
	    JButton Salir = new JButton();
	    final JComboBox<String> tipo_usuario = new JComboBox<String>();
       	 	
       	if(codigo == 1){
       	 	 tipo_usuario.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "Administrador" }));
       	 }else{
       		 if(tipo.equals("Administrador")){
	       	 	tipo_usuario.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "Administrador", "Vendedor" }));
	       	 }else{
	       	 	tipo_usuario.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "Vendedor" , "Administrador"}));
	       	 }
       	 }
        
        txt_empleados_nombre.setBounds(230, 70, 150, 30);
        AgregarEmpleados.add(txt_empleados_nombre);
        
        txt_empleados_direccion.setBounds(360, 210, 250, 30);
        AgregarEmpleados.add(txt_empleados_direccion);
        
        AgregarEmpleados.add(txt_empleados_Contraseña);
        txt_empleados_Contraseña.setBounds(360, 330, 250, 30);

        AgregarEmpleados.add(txt_empleados_edad);
        txt_empleados_edad.setBounds(460, 70, 150, 30);

        AgregarEmpleados.add(txt_empleados_telefono);
        txt_empleados_telefono.setBounds(230, 140, 150, 30);
        
        txt_empleados_fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); 
        txt_empleados_fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AgregarEmpleados.add(txt_empleados_fecha);
        txt_empleados_fecha.setBounds(220, 410, 190, 30);
  
        AgregarEmpleados.add(txt_empleados_usuario);
        txt_empleados_usuario.setBounds(360, 270, 250, 30);
        
        txt_empleados_codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_empleados_codigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AgregarEmpleados.add(txt_empleados_codigo);
        txt_empleados_codigo.setBounds(460, 140, 150, 30);
        
        AgregarEmpleados.add(tipo_usuario);
        tipo_usuario.setBounds(50, 270, 130, 30);

        Agregar_Imagen.setText("Agregar Imagen");
        AgregarEmpleados.add(Agregar_Imagen);
        Agregar_Imagen.setBounds(40, 190, 150, 30);

        Limpiar.setText("Reiniciar");
        AgregarEmpleados.add(Limpiar);
        Limpiar.setBounds(260, 450, 90, 30);
        Limpiar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		txt_empleados_nombre.setText(""); 
        		txt_empleados_edad.setText(""); 
        		txt_empleados_telefono.setText(""); 
        		txt_empleados_direccion.setText(""); 
        		txt_empleados_usuario.setText("");
        		txt_empleados_Contraseña.setText("");
			}
        
        });

        Salir.setText("Salir");
        AgregarEmpleados.add(Salir);
        Salir.setBounds(360, 450, 90, 30);
        Salir.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		Empleados.setVisible(false);
			}
        
        }); 
        
        Aceptar.setText("Guardar");
        AgregarEmpleados.add(Aceptar);
        Aceptar.setBounds(160, 450, 90, 30);
        Aceptar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        		if( (!(txt_empleados_nombre.getText().equals(""))) && (!(txt_empleados_edad.getText().equals(""))) && (!(txt_empleados_telefono.getText().equals(""))) && (!(txt_empleados_direccion.getText().equals(""))) && (!(txt_empleados_fecha.getText().equals(""))) && (!(txt_empleados_usuario.getText().equals(""))) && (!(txt_empleados_Contraseña.getText().equals(""))) ){
        			
        			        			
    			    String TipoUser = (String) tipo_usuario.getSelectedItem();
    			    ListaUsuarios.Modificar(numfil);
        			ListaUsuarios.setVariable(Integer.parseInt(txt_empleados_codigo.getText()),txt_empleados_nombre.getText(),Integer.parseInt(txt_empleados_edad.getText()),txt_empleados_telefono.getText(),txt_empleados_direccion.getText(), txt_empleados_fecha.getText(),txt_empleados_usuario.getText(),txt_empleados_Contraseña.getText(),TipoUser);
            		DefaultTableModel Tabla_Model = (DefaultTableModel) Tabla_Empleados.getModel();				 
    				Tabla_Model.setValueAt(txt_empleados_codigo.getText(), numfil, 0);
            		Tabla_Model.setValueAt(txt_empleados_nombre.getText(), numfil, 1);
            		Tabla_Model.setValueAt(txt_empleados_edad.getText(), numfil, 2);
            		Tabla_Model.setValueAt(txt_empleados_telefono.getText(), numfil, 3);
            		Tabla_Model.setValueAt(txt_empleados_direccion.getText(), numfil, 4);
            		Tabla_Model.setValueAt(txt_empleados_fecha.getText(), numfil, 5);
            		Tabla_Model.setValueAt(txt_empleados_usuario.getText(), numfil, 6);
            		Tabla_Model.setValueAt(txt_empleados_Contraseña.getText(), numfil, 7);
            		Tabla_Model.setValueAt(TipoUser, numfil, 8);
            		ListaUsuarios.GuardarLista();
            		Empleados.setVisible(false);
    			   
        		}else{
        			JOptionPane.showMessageDialog(null,"Se deben de llenar todas los requisitos!");
        		}
			} 
        });
        
        Empleados.getContentPane().add(AgregarEmpleados);
	}
    
    public void Archivo_Empleados(){//**************************************************************************************************************************
		try {
			 FileReader Archivo = new FileReader(Usuarios);
			 BufferedReader lector = new BufferedReader(Archivo);
			 String txt_leido;
			 while((txt_leido = lector.readLine()) != null){
				 StringTokenizer Token = new StringTokenizer(txt_leido,";");
				 String No_Usuario = Token.nextToken();
				 String Nombre_Empleado = Token.nextToken();
				 String Edad_Empleado = Token.nextToken();
				 String Tel_Empleado = Token.nextToken();
				 String Dir_Empleado = Token.nextToken();
				 String Año_Empleado = Token.nextToken();
				 String Nombre_Usuario = Token.nextToken();
				 String Pass_Usuario = Token.nextToken();
				 String Tipo_Usuario = Token.nextToken();				 
				 
				 DefaultTableModel Tabla_LogModel = (DefaultTableModel) Tabla_Empleados.getModel();				 
				 ListaUsuarios.addEmpleado(Integer.parseInt(No_Usuario),Nombre_Empleado,Integer.parseInt(Edad_Empleado),Tel_Empleado,Dir_Empleado,Año_Empleado,Nombre_Usuario,Pass_Usuario,Tipo_Usuario);
			     Object nuevaFila[]= {No_Usuario,Nombre_Empleado,Edad_Empleado,Tel_Empleado,Dir_Empleado,Año_Empleado,Nombre_Usuario,Pass_Usuario,Tipo_Usuario};
			     Tabla_LogModel.addRow(nuevaFila);
			 }
			 Archivo.close();
	     } catch (IOException evt) {
	    	
	     }
	}
    
    public void InterfazUsuarios(){//-----------------------------------------------Usuarios---------------------------------------------------------------	
    	lbl_empleado_ordenar = new JLabel();
    	ordenamiento_usuarios = new JComboBox<String>();
    	btn_empleado_nuevo = new JButton();
    	btn_empleado_editar = new JButton(); 
    	btn_empleado_eliminar = new JButton();
    	btn_empleado_guardar = new JButton();
    	
    	JLabel lbl_Ordenar = new JLabel("Ordenar Por:");
    	lbl_Ordenar.setBounds(175,5,100,30);
    	lbl_Ordenar.setFont(new Font("Helvetica", Font.BOLD, 14));
        
    	ordenamiento_usuarios.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "Por Codigo", "Por Año de Ingreso", "Por Edad", "Por Nombre" }));   
        ordenamiento_usuarios.setBounds(275,5,150,30);
        ordenamiento_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	String Orden = (String) ordenamiento_usuarios.getSelectedItem();
            	switch (Orden){
            		case "Por Codigo":{
            			DefaultTableModel Tabla_LogModel = (DefaultTableModel) Tabla_Empleados.getModel();
            			while (Tabla_LogModel.getRowCount() > 0){
            	        	Tabla_LogModel.removeRow(Tabla_LogModel.getRowCount()-1);
            	        }
            	        ListaUsuarios.OrdenarCodigo();
            	        for(int x = 0; x < ListaUsuarios.tamañoUsuarios(); x++){
            	        	ListaUsuarios.Modificar(x);			
            			    Object nuevaFila[]= {String.valueOf(ListaUsuarios.getCodigo()),ListaUsuarios.getNombre(),String.valueOf(ListaUsuarios.getEdad()),ListaUsuarios.getTelefono(),ListaUsuarios.getDireccion(),ListaUsuarios.getFecha(),ListaUsuarios.getUsuario(),ListaUsuarios.getPassword(),ListaUsuarios.getTipo()};
            			    Tabla_LogModel.addRow(nuevaFila);
            	        }
            	        break;	
            		}
            		case "Por Año de Ingreso":{
            			break;	
            		}
            		case "Por Edad":{
            			DefaultTableModel Tabla_LogModel = (DefaultTableModel) Tabla_Empleados.getModel();
            	        while (Tabla_LogModel.getRowCount() > 0){
            	        	Tabla_LogModel.removeRow(Tabla_LogModel.getRowCount()-1);
            	        }
            	        ListaUsuarios.OrdenarEdad();
            	        for(int x = 0; x < ListaUsuarios.tamañoUsuarios(); x++){
            	        	ListaUsuarios.Modificar(x);			
            			    Object nuevaFila[]= {String.valueOf(ListaUsuarios.getCodigo()),ListaUsuarios.getNombre(),String.valueOf(ListaUsuarios.getEdad()),ListaUsuarios.getTelefono(),ListaUsuarios.getDireccion(),ListaUsuarios.getFecha(),ListaUsuarios.getUsuario(),ListaUsuarios.getPassword(),ListaUsuarios.getTipo()};
            			    Tabla_LogModel.addRow(nuevaFila);
            	        }
            	        break;
            		}
            		case "Por Nombre":{
            			break;	
            		}
            	}
            }
        });    
        
    	btn_empleado_nuevo.setBounds(435,5,80,30);
    	btn_empleado_nuevo.setText("Nuevo");
    	btn_empleado_nuevo.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		Empleados();
        		ListaUsuarios.GuardarLista();
			}
        	
        });
    	
    	btn_empleado_editar.setBounds(525,5,80,30);
    	btn_empleado_editar.setText("Editar");
    	btn_empleado_editar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		int numFilaSeleccionada = Tabla_Empleados.getSelectedRow();
        		ListaUsuarios.Modificar(numFilaSeleccionada);
        		Empleados(ListaUsuarios.getCodigo(),ListaUsuarios.getNombre(),ListaUsuarios.getEdad(),ListaUsuarios.getTelefono(),ListaUsuarios.getDireccion(),ListaUsuarios.getFecha(),ListaUsuarios.getUsuario(),ListaUsuarios.getPassword(),ListaUsuarios.getTipo(),numFilaSeleccionada);
				ListaUsuarios.GuardarLista();
        	}

        });
    	
    	btn_empleado_eliminar.setBounds(615,5,80,30);
    	btn_empleado_eliminar.setText("Eliminar");
    	btn_empleado_eliminar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		int numFilaSeleccionada = Tabla_Empleados.getSelectedRow();
        	
        	    DefaultTableModel Tabla_LogModel = (DefaultTableModel) Tabla_Empleados.getModel();
            	 Tabla_LogModel.removeRow(numFilaSeleccionada);
        	 
        		ListaUsuarios.Eliminar(numFilaSeleccionada);   
        		ListaUsuarios.GuardarLista();
        	}
        
        });
    	
    	//Tabla de Contendio*****************************************************************
    	Tabla_Empleados = new JTable();
		Scrooll_tabla_Empleados = new JScrollPane();
		Scrooll_tabla_Empleados.setBounds(24, 40, 670, 300);
		Tabla_Empleados.setModel(new DefaultTableModel(
	            new Object [][] {
	            },
	            new String [] {
	                "Código", "Nombre", "Edad", "Teléfono", "Dirección", "Fecha de Ingreso" , "Usuario", "Contraseña", "Tipo"
	            }
	    ));
		Archivo_Empleados();
		Tabla_Empleados.getTableHeader().setReorderingAllowed(false);
		Tabla_Empleados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		Tabla_Empleados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Scrooll_tabla_Empleados.setViewportView(Tabla_Empleados);
		
		int[] AnchoColumnaEmpleados = {50, 300, 40, 60, 300, 100, 200, 80, 100};
		TableColumnModel columnModel = Tabla_Empleados.getColumnModel();
		for(int i = 0; i < Tabla_Empleados.getColumnCount(); i++){
			columnModel.getColumn(i).setMaxWidth(AnchoColumnaEmpleados[i]);
			columnModel.getColumn(i).setMinWidth(AnchoColumnaEmpleados[i]);
			columnModel.getColumn(i).setPreferredWidth(AnchoColumnaEmpleados[i]);
		}
		//Fin de la Tabla******************************************************************
		
		Pnl_Empleados.setLayout(null);
		Pnl_Empleados.add(btn_empleado_nuevo);
		Pnl_Empleados.add(btn_empleado_editar);
		Pnl_Empleados.add(btn_empleado_eliminar);
		Pnl_Empleados.add(btn_empleado_guardar);
		Pnl_Empleados.add(Scrooll_tabla_Empleados);
		Pnl_Empleados.add(ordenamiento_usuarios);
		Pnl_Empleados.add(lbl_Ordenar);
		
		//Fin del Panel Empleados---------------------------------------------------------------------------------------
	}
    
    public void Archivo_Clientes(){//*************************************************************************************************************************
		try {
			if(Usuarios.exists() == true){//Si el Archivo no exite crear el Archivo Usuarios
				FileReader Archivo = new FileReader(Clientes);
				 BufferedReader lector = new BufferedReader(Archivo);
				 String txt_leido;
				 while((txt_leido = lector.readLine()) != null){
					 StringTokenizer Token = new StringTokenizer(txt_leido,";");
					 String No_Codigo = Token.nextToken();
					 String No_DPI = Token.nextToken();
					 String Nombre = Token.nextToken();
					 String Apellidos = Token.nextToken();
					 String Telefono = Token.nextToken();
					 String Celular = Token.nextToken();				 
					 
					 DefaultTableModel Tabla_LogModel = (DefaultTableModel) Tabla_Clientes.getModel();				 
					 ListaClientes.addCliente(Integer.parseInt(No_Codigo),No_DPI,Nombre,Apellidos,Telefono,Celular);
				     Object nuevaFila[]= {No_Codigo,No_DPI,Nombre,Apellidos,Telefono,Celular};
				     Tabla_LogModel.addRow(nuevaFila);
				 }
				 Archivo.close();
			}	 
	     } catch (IOException evt) {
	    	
	     }
	}
    
    public void InterfazClientes(){//-----------------------------------------------clientes---------------------------------------------------------------	
    	btn_clientes_nuevo = new JButton();
    	btn_clientes_editar = new JButton(); 
    	btn_clientes_eliminar = new JButton();
    	
    	btn_clientes_nuevo.setBounds(435,5,80,30);
    	btn_clientes_nuevo.setText("Nuevo");
    	btn_clientes_nuevo.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		Clientes();
        		ListaClientes.GuardarLista();
			}
        	
        });
    	
    	btn_clientes_editar.setBounds(525,5,80,30);
    	btn_clientes_editar.setText("Editar");
    	btn_clientes_editar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		int numFilaSeleccionada = Tabla_Clientes.getSelectedRow();
        		ListaClientes.Modificar(numFilaSeleccionada);
        		Clientes(ListaClientes.getCodigo(),ListaClientes.getDPI(),ListaClientes.getNombre(),ListaClientes.getApellido(),ListaClientes.getTelefono(),ListaClientes.getCelular(),numFilaSeleccionada);
        		ListaClientes.GuardarLista();
        	}

        });
    	
    	btn_clientes_eliminar.setBounds(615,5,80,30);
    	btn_clientes_eliminar.setText("Eliminar");
    	btn_clientes_eliminar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		int aprobar = ListaClientes.numClientes();
        		int numFilaSeleccionada = Tabla_Clientes.getSelectedRow();
        		ListaClientes.Eliminar(numFilaSeleccionada);
        		if(ListaClientes.Empty() == true){
        			DefaultTableModel Tabla_LogModel = (DefaultTableModel) Tabla_Clientes.getModel();
        	        Tabla_LogModel.removeRow(0);
        	        ListaClientes.GuardarLista();
        		}else{
	        		if(aprobar > ListaClientes.numClientes()){
	        			DefaultTableModel Tabla_LogModel = (DefaultTableModel) Tabla_Clientes.getModel();
	        	        Tabla_LogModel.removeRow(numFilaSeleccionada);
	        		}
	        		ListaClientes.GuardarLista();
        		}
        	}
        
        });
    	
    	//Tabla de Contendio*****************************************************************
    	Tabla_Clientes = new JTable();
		Scrooll_tabla_Clientes = new JScrollPane();
		Scrooll_tabla_Clientes.setBounds(24, 40, 670, 300);
		Tabla_Clientes.setModel(new DefaultTableModel(
	            new Object [][] {
	            },
	            new String [] {
	                "Codigo", "DPI", "Nombre", "Apellidos", "Teléfono", "Celular"
	            }
	    ));
		Tabla_Clientes.getTableHeader().setReorderingAllowed(false);
		Tabla_Clientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		Tabla_Clientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Scrooll_tabla_Clientes.setViewportView(Tabla_Clientes);
		Archivo_Clientes();
		int[] AnchoColumnaEmpleados = {50, 100, 200, 200, 80, 80};
		TableColumnModel columnModel = Tabla_Clientes.getColumnModel();
		for(int i = 0; i < Tabla_Clientes.getColumnCount(); i++){
			columnModel.getColumn(i).setMaxWidth(AnchoColumnaEmpleados[i]);
			columnModel.getColumn(i).setMinWidth(AnchoColumnaEmpleados[i]);
			columnModel.getColumn(i).setPreferredWidth(AnchoColumnaEmpleados[i]);
		}
		//Fin de la Tabla******************************************************************
		
		Pnl_Clientes.setLayout(null);
		Pnl_Clientes.add(btn_clientes_nuevo);
		Pnl_Clientes.add(btn_clientes_editar);
		Pnl_Clientes.add(btn_clientes_eliminar);
		Pnl_Clientes.add(Scrooll_tabla_Clientes);
		
		//Fin del Panel Empleados---------------------------------------------------------------------------------------
	}
    
    public void Clientes(){//------------------------------Frame para agregar Clientes---------------------------------------------------------	
		final JFrame Clientes = new JFrame();
		Clientes.setSize(406, 476);
		Clientes.setResizable(false);//No permite cambiar el tamaño de la pantalla
		Clientes.setLocationRelativeTo(null);//Lo coloca en el centro de la pantalla
		Clientes.setDefaultCloseOperation(HIDE_ON_CLOSE);//Poder cerrar la aplicacion
		Clientes.setVisible(true);
		Panel_201212925 AgregarClientes= new Panel_201212925(new ImageIcon(this.getClass().getResource("/Imagenes/Fondo_Clientes.png")).getImage());
		final JTextField txt_clientes_dpi = new JTextField();
		final JTextField txt_Clientes_nombre = new JTextField();
		final JTextField txt_clientes_apellidos = new JTextField();
		final JTextField txt_clientes_telefono = new JTextField();
		final JTextField txt_clientes_celular = new JTextField();
		final JLabel lbl_clientes_codigo = new JLabel();
		
        JButton btn_Registrar = new JButton();
        JButton Limpiar = new JButton();
        JButton Salir = new JButton();

        lbl_clientes_codigo.setText(String.valueOf(ListaClientes.UltimoCodigo() + 1));
        txt_clientes_dpi.setText("");
        txt_Clientes_nombre.setText("");
        txt_clientes_apellidos.setText("");
        txt_clientes_telefono.setText("");
        txt_clientes_celular.setText("");  
        
        txt_Clientes_nombre.setBounds(190, 60, 180, 30);
        AgregarClientes.add(txt_Clientes_nombre);
        
        txt_clientes_apellidos.setBounds(190, 110, 180, 30);
        AgregarClientes.add(txt_clientes_apellidos);
        
        AgregarClientes.add(txt_clientes_dpi);
        txt_clientes_dpi.setBounds(190, 160, 180, 30);

        AgregarClientes.add(txt_clientes_celular);
        txt_clientes_celular.setBounds(210, 240, 160, 30);

        AgregarClientes.add(txt_clientes_telefono);
        txt_clientes_telefono.setBounds(30, 240, 140, 30);  
        
        lbl_clientes_codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_clientes_codigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AgregarClientes.add(lbl_clientes_codigo);
        lbl_clientes_codigo.setBounds(120, 320, 150, 30);  

        Limpiar.setText("Reiniciar");
        AgregarClientes.add(Limpiar);
        Limpiar.setBounds(150, 380, 90, 40);
        Limpiar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		txt_Clientes_nombre.setText("");
        		txt_clientes_celular.setText(""); 
        		txt_clientes_telefono.setText(""); 
        		txt_clientes_apellidos.setText(""); 
        		txt_clientes_dpi.setText("");
			}
        
        });

        Salir.setText("Salir");
        AgregarClientes.add(Salir);
        Salir.setBounds(250, 380, 90, 40);
        Salir.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		Clientes.setVisible(false);
			}
        
        }); 
        
        btn_Registrar.setText("Registrar");
        AgregarClientes.add(btn_Registrar);  
        btn_Registrar.setBounds(50, 380, 90, 40);
        btn_Registrar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
	        	if( (!(txt_Clientes_nombre.getText().equals(""))) && (!(txt_clientes_celular.getText().equals(""))) && (!(txt_clientes_telefono.getText().equals(""))) && (!(txt_clientes_apellidos.getText().equals(""))) &&  (!(txt_clientes_dpi.getText().equals(""))) ){
	                DefaultTableModel Tabla_LogModel = (DefaultTableModel) Tabla_Clientes.getModel();				 
	         		ListaClientes.addCliente(Integer.parseInt(lbl_clientes_codigo.getText()), txt_clientes_dpi.getText(), txt_Clientes_nombre.getText(), txt_clientes_apellidos.getText(), txt_clientes_telefono.getText(), txt_clientes_celular.getText());
	         		Object nuevaFila[]= {lbl_clientes_codigo.getText(), txt_clientes_dpi.getText(), txt_Clientes_nombre.getText(), txt_clientes_apellidos.getText(), txt_clientes_telefono.getText() ,txt_clientes_celular.getText()};
	         		Tabla_LogModel.addRow(nuevaFila);
	         		ListaClientes.GuardarLista();
	         		Clientes.setVisible(false);
	        	}else{
	        		JOptionPane.showMessageDialog(null,"Se deben de llenar todas los requisitos!");
	        	}
     		} 
        });   
        
        Clientes.getContentPane().add(AgregarClientes);
	}
	
    public void Clientes(int codigo, String dpi, String name, String apellido, String telefono, String celular, final int fila){//------------------------------Frame para agregar Empleados---------------------------------------------------------	
    	final JFrame Clientes = new JFrame();
		Clientes.setSize(406, 476);
		Clientes.setResizable(false);//No permite cambiar el tamaño de la pantalla
		Clientes.setLocationRelativeTo(null);//Lo coloca en el centro de la pantalla
		Clientes.setDefaultCloseOperation(HIDE_ON_CLOSE);//Poder cerrar la aplicacion
		Clientes.setVisible(true);
		Panel_201212925 AgregarClientes= new Panel_201212925(new ImageIcon(this.getClass().getResource("/Imagenes/Fondo_Clientes.png")).getImage());
		final JTextField txt_clientes_dpi = new JTextField();
		final JTextField txt_clientes_nombre = new JTextField();
		final JTextField txt_clientes_apellidos = new JTextField();
		final JTextField txt_clientes_telefono = new JTextField();
		final JTextField txt_clientes_celular = new JTextField();
		final JLabel lbl_clientes_codigo = new JLabel();
		
        JButton Aceptar = new JButton();
        JButton Limpiar = new JButton();
        JButton Salir = new JButton();

        lbl_clientes_codigo.setText(String.valueOf(codigo));
        txt_clientes_dpi.setText(String.valueOf(dpi));
        txt_clientes_nombre.setText(name);
        txt_clientes_apellidos.setText(apellido);
        txt_clientes_telefono.setText(telefono);
        txt_clientes_celular.setText(celular);  
       	 	
	    txt_clientes_nombre.setBounds(190, 60, 180, 30);
        AgregarClientes.add(txt_clientes_nombre);
        
        txt_clientes_apellidos.setBounds(190, 110, 180, 30);
        AgregarClientes.add(txt_clientes_apellidos);
        
        AgregarClientes.add(txt_clientes_dpi);
        txt_clientes_dpi.setBounds(190, 160, 180, 30);

        AgregarClientes.add(txt_clientes_celular);
        txt_clientes_celular.setBounds(210, 240, 160, 30);

        AgregarClientes.add(txt_clientes_telefono);
        txt_clientes_telefono.setBounds(30, 240, 140, 30);  
        
        lbl_clientes_codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_clientes_codigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AgregarClientes.add(lbl_clientes_codigo);
        lbl_clientes_codigo.setBounds(120, 320, 150, 30);  

        Limpiar.setText("Reiniciar");
        AgregarClientes.add(Limpiar);
        Limpiar.setBounds(150, 380, 90, 40);
        Limpiar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		txt_clientes_nombre.setText("");
        		txt_clientes_celular.setText(""); 
        		txt_clientes_telefono.setText(""); 
        		txt_clientes_apellidos.setText(""); 
        		txt_clientes_dpi.setText("");
			}
        
        });

        Salir.setText("Salir");
        AgregarClientes.add(Salir);
        Salir.setBounds(250, 380, 90, 40);
        Salir.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		Clientes.setVisible(false);
			}
        
        }); 
        
        Aceptar.setText("Guardar");
        AgregarClientes.add(Aceptar);
        Aceptar.setBounds(50, 380, 90, 40);
        Aceptar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        		if((!(txt_clientes_nombre.getText().equals(""))) && (!(txt_clientes_celular.getText().equals(""))) && (!(txt_clientes_telefono.getText().equals(""))) && (!(txt_clientes_apellidos.getText().equals(""))) &&  (!(txt_clientes_dpi.getText().equals("")))){	        			 
    			    ListaClientes.Modificar(fila);
        			ListaClientes.setVariable(Integer.parseInt(lbl_clientes_codigo.getText()),txt_clientes_dpi.getText(),txt_clientes_nombre.getText(),txt_clientes_apellidos.getText(),txt_clientes_telefono.getText(),txt_clientes_celular.getText());
        			DefaultTableModel Tabla_Model = (DefaultTableModel) Tabla_Clientes.getModel();				 
    				Tabla_Model.setValueAt(lbl_clientes_codigo.getText(), fila, 0);
            		Tabla_Model.setValueAt(txt_clientes_dpi.getText(), fila, 1);
            		Tabla_Model.setValueAt(txt_clientes_nombre.getText(), fila, 2);
            		Tabla_Model.setValueAt(txt_clientes_apellidos.getText(), fila, 3);
            		Tabla_Model.setValueAt(txt_clientes_telefono.getText(), fila, 4);
            		Tabla_Model.setValueAt(txt_clientes_celular.getText(), fila, 5);
    			    Clientes.setVisible(false);
    			    ListaClientes.GuardarLista();
        		}else{
        			JOptionPane.showMessageDialog(null,"Se deben de llenar todas los requisitos!");
        		}
			} 
        });
        
        Clientes.getContentPane().add(AgregarClientes);
	}
    
    public void Archivo_Producto(){//*****************************************************************************************************************************
		try {
			if(Usuarios.exists() == true){//Si el Archivo no exite
				FileReader Archivo = new FileReader(Productos);
				 BufferedReader lector = new BufferedReader(Archivo);
				 String txt_leido;
				 while((txt_leido = lector.readLine()) != null){
					 StringTokenizer Token = new StringTokenizer(txt_leido,";");
					 String No_Codigo = Token.nextToken();
					 String Nombre = Token.nextToken();
					 String Cantidad = Token.nextToken();
					 String PreciosinIva = Token.nextToken();				 
					 
					 DefaultTableModel Tabla_LogModel = (DefaultTableModel) Tabla_Producto.getModel();				 
					 ListaProductos.add(Long.parseLong(No_Codigo), Nombre, Long.parseLong(Cantidad),Float.parseFloat(PreciosinIva));
				     Object nuevaFila[]= {No_Codigo,Nombre,Cantidad,PreciosinIva};
				     Tabla_LogModel.addRow(nuevaFila);
				 }
				 Archivo.close();
			}	 
	     } catch (IOException evt) {
	    	
	     }
	}
    
    public void InterfazProducto(){//-----------------------------------------------Producto---------------------------------------------------------------	
    	lbl_producto_ordenar = new JLabel();
    	ordenamiento_producto = new JComboBox<String>();
    	btn_producto_nuevo = new JButton();
    	btn_producto_editar = new JButton(); 
    	btn_producto_eliminar = new JButton();
    	btn_producto_cargar = new JButton();
    	
    	btn_producto_cargar.setBounds(25,5,140,30);
    	btn_producto_cargar.setText("Cargar Archivo...");
    	btn_producto_cargar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		JFileChooser fileChooser = new JFileChooser();
        		int seleccion = fileChooser.showOpenDialog(null);
        		if (seleccion == JFileChooser.APPROVE_OPTION){
        		   File fichero = fileChooser.getSelectedFile();
        		   try {
        			    FileReader File_Reader = new FileReader(fichero);
						BufferedReader lector = new BufferedReader(File_Reader);
	       				 String txt_leido;
	       				 while((txt_leido = lector.readLine()) != null){
	       					 StringTokenizer Token = new StringTokenizer(txt_leido,",");
	       					 String No_Codigo = Token.nextToken();
	       					 String Nombre = Token.nextToken();
	       					 String Marca = Token.nextToken();
	       					 String Proveedor = Token.nextToken();
	       					 String Cantidad = Token.nextToken();
	       					 String PreciosinIva = Token.nextToken();				 
	       					 
	       					 DefaultTableModel Tabla_LogModel = (DefaultTableModel) Tabla_Producto.getModel();				 
	       				     Object nuevaFila[]= {No_Codigo,Nombre,Cantidad,PreciosinIva};
	       				     Tabla_LogModel.addRow(nuevaFila);	
	       					 ListaProductos.add(Long.parseLong(No_Codigo), Nombre, Long.parseLong(Cantidad),Float.parseFloat(PreciosinIva));
	       				 } 
	       				 File_Reader.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						
					}
        		}   
        		ListaProductos.GuardarLista();
			}
        	
        });
    	
    	JLabel lbl_producto_ordenar = new JLabel("Ordenar Por:");
    	lbl_producto_ordenar.setBounds(175,5,100,30);
    	lbl_producto_ordenar.setFont(new Font("Helvetica", Font.BOLD, 14));
        
    	ordenamiento_producto.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "Por Nombre Asc.", "Por Nombre Des.", "Por Codigo", "Por Cantidad"}));   
        ordenamiento_producto.setBounds(275,5,150,30);
        ordenamiento_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	String Orden = (String) ordenamiento_usuarios.getSelectedItem();
            	switch (Orden){
            		case "Por Nombre Asc.":{
            			
            	        break;	
            		}
            		case "Por Nombre Des.":{
            			break;	
            		}
            		case "Por Codigo":{
            			
            	        break;
            		}
            		case "Por Cantidad":{
            			break;	
            		}
            	}
            }
        });    
        
    	btn_producto_nuevo.setBounds(435,5,80,30);
    	btn_producto_nuevo.setText("Nuevo");
    	btn_producto_nuevo.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		Productos();
        		ListaProductos.GuardarLista();
			}
        	
        });
    	
    	btn_producto_editar.setBounds(525,5,80,30);
    	btn_producto_editar.setText("Editar");
    	btn_producto_editar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		int numFilaSeleccionada = Tabla_Producto.getSelectedRow();
        		ListaProductos.Modificar(numFilaSeleccionada);
        		Productos(ListaProductos.getCodigo(),ListaProductos.getNombre(),ListaProductos.getCantidad(),ListaProductos.getPrecio(),numFilaSeleccionada);
        		ListaProductos.GuardarLista();
        	}

        });
    	
    	btn_producto_eliminar.setBounds(615,5,80,30);
    	btn_producto_eliminar.setText("Eliminar");
    	btn_producto_eliminar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		int aprobar = ListaProductos.tamañoUsuarios();
        		int numFilaSeleccionada = Tabla_Producto.getSelectedRow();
        		ListaProductos.Eliminar(numFilaSeleccionada);
        		if(ListaProductos.Empty() == true){
        			DefaultTableModel Tabla_LogModel = (DefaultTableModel) Tabla_Producto.getModel();
        	        Tabla_LogModel.removeRow(0);
        		}else{
        			if(aprobar > ListaProductos.tamañoUsuarios()){
            			DefaultTableModel Tabla_LogModel = (DefaultTableModel) Tabla_Producto.getModel();
            	        Tabla_LogModel.removeRow(numFilaSeleccionada);
            		}
            		
        		}
        		ListaProductos.GuardarLista();	
        	}
        
        });
    	
    	//Tabla de Contendio*****************************************************************
    	Tabla_Producto = new JTable();
		Scrooll_tabla_Producto = new JScrollPane();
		Scrooll_tabla_Producto.setBounds(24, 40, 670, 300);
		Tabla_Producto.setModel(new DefaultTableModel(
	            new Object [][] {
	            },
	            new String [] {
	                "Código", "Nombre", "Cantidad", "Precio sin IVA"
	            }
	    ));
		Archivo_Producto();
		Tabla_Producto.getTableHeader().setReorderingAllowed(false);
		Tabla_Producto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		Tabla_Producto.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Scrooll_tabla_Producto.setViewportView(Tabla_Producto);
		
		int[] AnchoColumnaEmpleados = {50, 400, 70, 100};
		TableColumnModel columnModel = Tabla_Producto.getColumnModel();
		for(int i = 0; i < Tabla_Producto.getColumnCount(); i++){
			columnModel.getColumn(i).setMaxWidth(AnchoColumnaEmpleados[i]);
			columnModel.getColumn(i).setMinWidth(AnchoColumnaEmpleados[i]);
			columnModel.getColumn(i).setPreferredWidth(AnchoColumnaEmpleados[i]);
		}
		//Fin de la Tabla******************************************************************
		
		Pnl_Producto.setLayout(null);
		Pnl_Producto.add(btn_producto_nuevo);
		Pnl_Producto.add(btn_producto_editar);
		Pnl_Producto.add(btn_producto_eliminar);
		Pnl_Producto.add(Scrooll_tabla_Producto);
		Pnl_Producto.add(ordenamiento_producto);
		Pnl_Producto.add(btn_producto_cargar);
		Pnl_Producto.add(lbl_producto_ordenar);
	}
    
    public void Productos(){//------------------------------Frame para agregar Productos---------------------------------------------------------	
		final JFrame Productos = new JFrame();
		Productos.setSize(406, 400);
		Productos.setResizable(false);//No permite cambiar el tamaño de la pantalla
		Productos.setLocationRelativeTo(null);//Lo coloca en el centro de la pantalla
		Productos.setDefaultCloseOperation(HIDE_ON_CLOSE);//Poder cerrar la aplicacion
		Productos.setVisible(true);
		Panel_201212925 AgregarProducto= new Panel_201212925(new ImageIcon(this.getClass().getResource("/Imagenes/Fondo_Producto.png")).getImage());
		final JTextField txt_producto_codigo = new JTextField();
		final JTextField txt_producto_nombre = new JTextField();
		final JTextField txt_producto_cantidad = new JTextField();
		final JTextField txt_prodcto_precio = new JTextField();
		
        JButton Aceptar = new JButton();
        JButton Limpiar = new JButton();
        JButton Salir = new JButton();

        txt_producto_codigo.setText("");
        txt_producto_nombre.setText("");
        txt_producto_cantidad.setText("");
        txt_prodcto_precio.setText(""); 
        
        txt_producto_codigo.setBounds(120, 250, 150, 30);
        AgregarProducto.add(txt_producto_codigo);
        
        txt_producto_nombre.setBounds(190, 60, 180, 30);
        AgregarProducto.add(txt_producto_nombre);
        
        AgregarProducto.add( txt_producto_cantidad);
        txt_producto_cantidad.setBounds(190, 110, 180, 30);

        AgregarProducto.add(txt_prodcto_precio);
        txt_prodcto_precio.setBounds(190, 160, 180, 30); 

        Limpiar.setText("Reiniciar");
        AgregarProducto.add(Limpiar);
        Limpiar.setBounds(150, 310, 90, 40);
        Limpiar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		txt_producto_codigo.setText("");
        		txt_producto_nombre.setText(""); 
        		txt_producto_cantidad.setText(""); 
        		txt_prodcto_precio.setText(""); 
			}
        
        });

        Salir.setText("Salir");
        AgregarProducto.add(Salir);
        Salir.setBounds(250, 310, 90, 40);
        Salir.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		Productos.setVisible(false);
			}
        
        }); 
        
        Aceptar.setText("Registrar");
        AgregarProducto.add(Aceptar);  
        Aceptar.setBounds(50, 310, 90, 40);
        Aceptar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
	        	if( (!(txt_producto_codigo.getText().equals(""))) && (!(txt_producto_nombre.getText().equals(""))) && (!(txt_producto_cantidad.getText().equals(""))) && (!(txt_prodcto_precio.getText().equals(""))) ){
	        		DefaultTableModel Tabla_LogModel = (DefaultTableModel) Tabla_Producto.getModel();				 
	         		ListaProductos.add(Long.parseLong(txt_producto_codigo.getText()), txt_producto_nombre.getText(), Long.parseLong(txt_producto_cantidad.getText()), Float.parseFloat(txt_prodcto_precio.getText()));
	         		Object nuevaFila[]= {txt_producto_codigo.getText(), txt_producto_nombre.getText(),txt_producto_cantidad.getText(), txt_prodcto_precio.getText()};
	         		Tabla_LogModel.addRow(nuevaFila);
	         		Productos.setVisible(false);
	         		ListaProductos.GuardarLista();
	        	}else{
	        		JOptionPane.showMessageDialog(null,"Se deben de llenar todas los requisitos!");
	        	}
     		} 
        });   
        
        Productos.getContentPane().add(AgregarProducto);
	}
	
    public void Productos(long Codigo, String Nombre, long cantidad, float sin_Iva, final int fila){//------------------------------Frame para agregar Empleados---------------------------------------------------------	
    	final JFrame Productos = new JFrame();
		Productos.setSize(406, 400);
		Productos.setResizable(false);//No permite cambiar el tamaño de la pantalla
		Productos.setLocationRelativeTo(null);//Lo coloca en el centro de la pantalla
		Productos.setDefaultCloseOperation(HIDE_ON_CLOSE);//Poder cerrar la aplicacion
		Productos.setVisible(true);
		Panel_201212925 AgregarProducto= new Panel_201212925(new ImageIcon(this.getClass().getResource("/Imagenes/Fondo_Producto.png")).getImage());
		final JTextField txt_producto_codigo = new JTextField();
		final JTextField txt_producto_nombre = new JTextField();
		final JTextField txt_producto_cantidad = new JTextField();
		final JTextField txt_prodcto_precio = new JTextField();
		
        JButton Btn_Guardar = new JButton();
        JButton Limpiar = new JButton();
        JButton Salir = new JButton();

        txt_producto_codigo.setText(String.valueOf(Codigo));
        txt_producto_nombre.setText(Nombre);
        txt_producto_cantidad.setText(String.valueOf(cantidad));
        txt_prodcto_precio.setText(String.valueOf(sin_Iva));  
       	 	
        txt_producto_codigo.setBounds(120, 250, 150, 30);
        AgregarProducto.add(txt_producto_codigo);
        
        txt_producto_nombre.setBounds(190, 60, 180, 30);
        AgregarProducto.add(txt_producto_nombre);
        
        AgregarProducto.add( txt_producto_cantidad);
        txt_producto_cantidad.setBounds(190, 110, 180, 30);

        AgregarProducto.add(txt_prodcto_precio);
        txt_prodcto_precio.setBounds(190, 160, 180, 30);  
        
        Btn_Guardar.setText("Guardar");
        AgregarProducto.add(Btn_Guardar);
        Btn_Guardar.setBounds(50, 310, 90, 40);
        Btn_Guardar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        	if( (!(txt_producto_codigo.getText().equals(""))) && (!(txt_producto_nombre.getText().equals(""))) && (!(txt_producto_cantidad.getText().equals(""))) && (!(txt_prodcto_precio.getText().equals(""))) ){
        			ListaProductos.Modificar(fila);
                	ListaProductos.setVariable(Long.parseLong(txt_producto_codigo.getText()), txt_producto_nombre.getText(), Long.parseLong(txt_producto_cantidad.getText()), Float.parseFloat(txt_prodcto_precio.getText()));
            		DefaultTableModel Tabla_Model = (DefaultTableModel) Tabla_Producto.getModel();				 
    				Tabla_Model.setValueAt(txt_producto_codigo.getText(), fila, 0);
            		Tabla_Model.setValueAt(txt_producto_nombre.getText(), fila, 1);
            		Tabla_Model.setValueAt(txt_producto_cantidad.getText(), fila, 2);
            		Tabla_Model.setValueAt(txt_prodcto_precio.getText(), fila, 3);
    			    Productos.setVisible(false);
    			    ListaProductos.GuardarLista();
        		}else{
        			JOptionPane.showMessageDialog(null,"Se deben de llenar todas los requisitos!");
        		}
			} 
        });
        
        Limpiar.setText("Reiniciar");
        AgregarProducto.add(Limpiar);
        Limpiar.setBounds(150, 310, 90, 40);
        Limpiar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		txt_producto_codigo.setText("");
        		txt_producto_nombre.setText(""); 
        		txt_producto_cantidad.setText(""); 
        		txt_prodcto_precio.setText(""); 
			}
        
        });

        Salir.setText("Salir");
        AgregarProducto.add(Salir);
        Salir.setBounds(250, 310, 90, 40);
        Salir.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		Productos.setVisible(false);
			}
        
        }); 
        
        Productos.getContentPane().add(AgregarProducto);
	}
}
	
	