package COMPONENTES;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import com.placeholder.PlaceHolder;

public class Ctext extends JTextField{
	
	
	//CONSTRUCTOR
	public Ctext(String mensaje) {
		PlaceHolder placeholder = new PlaceHolder(this, mensaje);/*MENSAJE TRASLUCIDO*/
		this.setFont(new Font("Arial", 1, 15));
	}
}
