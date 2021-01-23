package Eventos;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPasswordField;

import COMPONENTES.JLabelColor;

public class ClaveEvent extends KeyAdapter{
	
	// ELEMENTOS A CONTROLAR
	private JPasswordField clave;
	private JLabelColor label;
	private boolean ClaveAceptada = false;
	
	public ClaveEvent(JPasswordField clave, JLabelColor label) {
		
		this.clave = clave;
		this.label = label;
		
	}
	
	
	public boolean ConfirmarClave() {
		return this.ClaveAceptada;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
		String caracteres = this.clave.getText();
		
		if(caracteres.length() <6) {
			
			this.label.setTextColor("Clave muy insegura","Red");
			this.ClaveAceptada = false;
			
		}else if(caracteres.length() >= 6 && caracteres.length() <10) {
			
			this.label.setTextColor("Clave medianamente segura","Yellow");
			this.ClaveAceptada = false;

		}else if(caracteres.length() >=10) {
			
			this.label.setTextColor("Clave Segura","Green");
			this.ClaveAceptada = true;
			
		}
		
	}
}
