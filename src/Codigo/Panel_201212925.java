package Codigo;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/****************
*** @StormTK  ***
*****************/

public class Panel_201212925 extends JPanel{
	
	private Image Fondo;//Imagen para agregar de Fondo
	
	public Panel_201212925(Image ImagneFondo){
		this.Fondo = ImagneFondo; //Usar la imagen recibida
		Componentes();	
	}

	@Override
		public void paintComponent (Graphics g){
		g.drawImage(Fondo,0,0, null); 
	}
		
	public void Componentes(){
		this.setSize(Fondo.getWidth(null),Fondo.getHeight(null));//Que el JPanel tenga las Dimensiones de la imagen
		this.setLayout(null);//Que el JPanel Utilice Cordenadas
	}
}
