package COMPONENTES;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Wallper extends JLabel{
	
	//ATRIBUTOS
	private ImageIcon imagen;
	private Icon porta;
	
	public Wallper(int i, int j, int x, int y) {
		
		this.setBounds(i, j, x, y);
		
	}
	
	public Wallper() {
		
	}
	
	public void setImagen(String url) {
		//COLOCAR IMAGEN DE FONDO
		this.imagen = new ImageIcon(url);
		this.porta = new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(),this.getHeight(),
				Image.SCALE_DEFAULT));
				
		this.setIcon(porta);
	}
}
