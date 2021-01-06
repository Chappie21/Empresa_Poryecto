package COMPONENTES;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

public class JLabelColor extends JLabel{
	
	
	public JLabelColor(String texto) {
		
		// ESTADO INICIAL EN AZUL
		this.setText(texto);
		this.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 191, 255)));
		this.setBackground(new Color(175, 238, 238));
		this.setForeground(new Color(0, 191, 255));
		
	}
	
	// COLOCAR TEXTO EN ROJO
	public void setTextColor(String text, String color) {
		
		this.setText(text);
		
		switch(color) {
			
			case "Red":
				
				this.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(255, 0, 0)));
				this.setForeground(new Color(255, 0, 0));
				this.setBackground(new Color(255, 160, 122));
				
			break;
			
			case "Yellow":
				
				this.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(255, 215, 0)));
				this.setForeground(new Color(255, 215, 0));
				this.setBackground(new Color(238, 232, 170));
				
			break;
			
			case "Green":
				
				this.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(34, 139, 34)));
				this.setForeground(new Color(34, 139, 34));
				this.setBackground(new Color(144, 238, 144));
				
			break;
			
			case "Blue":
				
				this.setText(text);
				this.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 191, 255)));
				this.setBackground(new Color(175, 238, 238));
				this.setForeground(new Color(0, 191, 255));
				
			break;
		
		}
		
		
	}
	
}
