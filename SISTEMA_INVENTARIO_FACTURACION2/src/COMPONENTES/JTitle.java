package COMPONENTES;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class JTitle extends JPanel {
	
	private JLabel Espacio1, Espacio2, Espacio3, Espacio4; // ESPACIO DE RELLENO
	private JPanel Central; // PANEL CONTENEDOR CENTRAL
	private JLabel Titulo; // EQTIQUETA DE TITULO A ESCRIBIR
	private JLabel Icono; // IMAGEN A COLOCAR
	
	public JTitle() {
		
		setBorder(new MatteBorder(0, 0, 7, 0, (Color) new Color(113, 106, 234)));
		setLayout(new BorderLayout(0, 0));
		
		this.Central = new JPanel();
		this.add(Central, BorderLayout.CENTER);
		this.Central.setLayout(new BorderLayout(0, 0));
		
		this.Icono = new JLabel("");
		this.Central.add(Icono, BorderLayout.WEST);
		
		this.Titulo = new JLabel("New Title");
		this.Titulo.setForeground(new Color(113, 106, 234));
		this.Titulo.setFont(new Font("SansSerif", Font.BOLD, 32));
		this.Central.add(Titulo, BorderLayout.CENTER);
		
		this.Espacio1 = new JLabel("      ");
		this.add(Espacio1, BorderLayout.NORTH);
		
		this.Espacio2 = new JLabel("     ");
		this.add(Espacio2, BorderLayout.SOUTH);
		
		this.Espacio3 = new JLabel("     ");
		this.add(Espacio3, BorderLayout.WEST);
		
		this.Espacio4 = new JLabel("    ");
		this.add(Espacio4, BorderLayout.EAST);
		
	}
	
	// ESTABLECER COLOR DEL COMPONENTE COMPLETO
	public void setBackgroundColor(Color fondo) {
		
		this.setBackground(fondo);
		this.Espacio1.setBackground(fondo);
		this.Espacio2.setBackground(fondo);
		this.Espacio3.setBackground(fondo);
		this.Espacio4.setBackground(fondo);
		this.Icono.setBackground(fondo);
		this.Titulo.setBackground(fondo);
		this.Central.setBackground(fondo);
		
	}
	
	//ESTABLECER TITULO
	public void setTitle(String titulo) {
		
		this.Titulo.setText(titulo);
		
	}
	
	//ESTABLECER COLOR DE LETRA
	public void setTextColor(Color color) {
		
		this.Titulo.setForeground(color);
		
	}
	
	//ESTABLECER ICONO DE IMAGEN
	public void setIconImage(ImageIcon imagen) {
		
		this.Icono.setIcon(imagen);
		
	}
}
