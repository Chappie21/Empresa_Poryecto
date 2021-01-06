package COMPONENTES;

import java.awt.Font;

import javax.swing.JPasswordField;
import com.placeholder.PlaceHolder;

public class Password extends JPasswordField{
	
	//CONSTRUCTOR
	public Password(String mensaje) {
		PlaceHolder placeholder = new PlaceHolder(this, mensaje);/*MENSAJE TRASLUCIDO*/
		this.setFont(new Font("Arial", 1, 15));
	}
}
