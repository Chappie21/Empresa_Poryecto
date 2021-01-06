package COMPONENTES;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Plantilla_Panel extends JPanel {
	
	// ATRIBUTOS DEL PANEL PLANTILLA
	private JLabel Espacio[] = new JLabel[7];
	protected JPanel Panel_Norte;
	protected JPanel PanelContent;
	protected JTitle PanelTitulo;
	
	public Plantilla_Panel() {
		
		// BACKGROUND COLOR Y LAYOUT PRINCIPAL
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		// PANELES
		this.Panel_Norte = new JPanel();
		this.Panel_Norte.setBackground(Color.WHITE);
		this.add(Panel_Norte, BorderLayout.NORTH);
		this.Panel_Norte.setLayout(new BorderLayout(0, 0));
		
		this.PanelContent = new JPanel();
		this.PanelContent.setBackground(Color.WHITE);
		this.add(PanelContent, BorderLayout.CENTER);
		this.PanelContent.setLayout(null);
		
		// ETIQUETAS ESPACIO
		this.Espacio[0] = new JLabel("    ");
		this.Panel_Norte.add(Espacio[0], BorderLayout.NORTH);
		
		this.Espacio[1] = new JLabel("    ");
		this.Panel_Norte.add(Espacio[1], BorderLayout.SOUTH);
		
		this.Espacio[2] = new JLabel("    ");
		this.Panel_Norte.add(Espacio[2], BorderLayout.WEST);
		
		this.Espacio[3] = new JLabel("    ");
		this.Panel_Norte.add(Espacio[3], BorderLayout.EAST);
		
		this.Espacio[4] = new JLabel("        ");
		this.add(Espacio[4], BorderLayout.SOUTH);
		
		this.Espacio[5] = new JLabel("      ");
		this.add(Espacio[5], BorderLayout.WEST);
		
		this.Espacio[6] = new JLabel("      ");
		this.add(Espacio[6], BorderLayout.EAST);
		
		// PANEL TITULO
		this.PanelTitulo = new JTitle();
		this.PanelTitulo.setBackgroundColor(new Color(255, 255, 255));
		this.PanelTitulo.setTextColor(new Color(130, 0, 0));
		this.Panel_Norte.add(PanelTitulo, BorderLayout.CENTER);
	}
}
