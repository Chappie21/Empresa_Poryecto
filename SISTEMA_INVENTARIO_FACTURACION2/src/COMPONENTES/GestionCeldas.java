package COMPONENTES;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class GestionCeldas extends DefaultTableCellRenderer{
	
	// TIPO DE DATO
	private String tipo = "texto";
	
	// TIPOS DE LETRAS
	private Font letra = new Font("Arial", Font.PLAIN, 12);
	private Font digito = new Font("Arial", Font.BOLD, 14);
	
	/// ICONOS A UTILIZAR
	private ImageIcon editar = new ImageIcon("Imagenes/pecil_T.png");
	private ImageIcon borrar = new ImageIcon("Imagenes/borrar_T.png");

	
	public GestionCeldas(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
		
		Color fondo = null;
		Color Seleccionado = new Color(175, 255, 238);
		Color noSeleccionado = new Color(255,255,255);
		
		/*
		 * COMPROBAMOS SI LA SELFA ES SELECCIONADA, EN EL CASO DE SER CIERO ESTÁ SE PINTARÁ DE
		 * CELESTE, DE NO SER ASÍ SE PINTARÁ DE BLANCO
		 */
		if(selected) {
			this.setBackground(Seleccionado);
		}else {
			this.setBackground(noSeleccionado);
		}
		
		/*
		 * SE DEFINE EL TIPO DE DATO QUE CONTENDRA LA CELDA, ESTO ES ESTABLECIDO POR UN STRING
		 * EL CUAL PUEDE ALVERGAR TEXTO, NUMERICO, O FUNCIONALIDAD ESTALECIDAD
		 */
		switch(tipo) {
		
			// EN CASO DE SE TEXTO
			case "texto":
				
				// EN CASO DE QUE LA CELDA ESPECIFICA SEA SELECCIONADA
				if(focused) {
					fondo = Seleccionado;
				}else {
					fondo = noSeleccionado;
				}
				
				this.setBackground(fondo);
				this.setHorizontalAlignment(JLabel.LEFT);
				this.setText((String) value);
				this.setFont(letra);
				
				return this;
				
			case "numerico":
				
				// EN CASO DE QUE LA CELDA ESPECIFICA SEA SELECCIONADA
				if(focused) {
					fondo = Seleccionado;
				}else {
					fondo = noSeleccionado;
				}
				
				this.setBackground(fondo);
				this.setHorizontalAlignment(JLabel.CENTER);
				this.setFont(digito);
				this.setText(""+value);
				this.setForeground(new Color(0, 51, 153));
				
				return this;
				
				
			case "boton":
				
				if(String.valueOf(value).equals("EDITAR")) {
					
					this.setIcon(editar);
					this.setToolTipText("Editar Usuario");
		
				}else if(String.valueOf(value).equals("BORRAR")){
					
					this.setIcon(borrar);
					this.setToolTipText("Borrar Usuario");
				}
				
				this.setHorizontalAlignment(Label.LEFT);
				this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
				return this;
				
		}
		
		return this;
	}
	
}	
