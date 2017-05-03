package Codigo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/****************
*** @StormTK  ***
*****************/

public class Login_Interfaz_201212925 extends JFrame{
	
	private File Usuarios = new File("Empleado.csv");
	private JTextField txt_usuario;
	private JPasswordField pass_contraseña; 
	RandomAccessFile LectorArchivo;
	JButton btn_aceptar;
	Panel_201212925 Panel_Login;
	
	public Login_Interfaz_201212925(){
		Componentes();//Busca el metodo Componentes
	}
	
	public void Componentes(){
		setIconImage(new ImageIcon(this.getClass().getResource("/Imagenes/Icon_candado.png")).getImage());//Icono de la Aplicacion
		setTitle("Ferreteria \"El Tornillo Loco\" S.A.");//Titulo de la Aplicación
		setSize(405,328);//El tamaño es de 400x300
		setResizable(false);//No permite cambiar el tamaño de la pantalla
		setLocationRelativeTo(null);//Lo coloca en el centro de la pantalla
		setDefaultCloseOperation(EXIT_ON_CLOSE);//Poder cerrar la aplicacion
		setLayout(null);//Se podra usar coordenadas
		
		btn_aceptar = new JButton();
		txt_usuario = new JTextField();
		pass_contraseña = new JPasswordField();
		Panel_Login = new Panel_201212925(new ImageIcon(this.getClass().getResource("/Imagenes/Fondo_Login.png")).getImage());
		
		txt_usuario.setBounds(120,130,250,35);
		pass_contraseña.setBounds(120,180,250,35);
		
		//Boton Acceder
		btn_aceptar.setText("Acceder");
		btn_aceptar.setBounds(150,240,100,40);
		btn_aceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(Usuarios.exists() == false){//Si el Archivo no exite crear el Archivo Usuarios
					Archivo_Admin();
					Lectura_Archivo();
				}else{
					Lectura_Archivo();
				}			
			}	
		});
		
		//Agregar todo el Contenido
		Panel_Login.add(txt_usuario);
		Panel_Login.add(pass_contraseña);
		Panel_Login.add(btn_aceptar);
		getContentPane().add(Panel_Login);
	}
	
	public void Archivo_Admin(){
		FileWriter Archivo;
		PrintWriter Escritor;
		try {
			Archivo = new FileWriter(Usuarios);
			Escritor = new PrintWriter(Archivo);
			Escritor.print("1;Administrador;21;79386170;Col. Las Margaritas, Chimaltenango;1/1/2012;Admin;201212925;Administrador");
			Archivo.close();
		} catch (IOException e) {
			
		}
	}
	
	public void Lectura_Archivo(){
		boolean usuarioexiste = false;
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
				 
				 if(Nombre_Usuario.equals(txt_usuario.getText())){
					 String password = new String(pass_contraseña.getPassword());
					 if(Pass_Usuario.equals(password)){
						 Interfaz_Usuario_201212925 iniciar = new Interfaz_Usuario_201212925(Tipo_Usuario,Nombre_Empleado,No_Usuario);
						 iniciar.setVisible(true);
						 usuarioexiste = true;
						 setVisible(false);
					 }else{
						 JOptionPane.showMessageDialog(null,"Contraseña Incorrecta");
						 usuarioexiste = true;
					 }
				 }
			 }
			 if(usuarioexiste == false){
				 JOptionPane.showMessageDialog(null,"Este Usuario no existe");
			 }
			 Archivo.close();
	     } catch (IOException evt) {
	    	
	     }
	}
	
}
