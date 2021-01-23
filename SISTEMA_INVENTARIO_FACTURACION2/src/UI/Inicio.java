package UI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

import COMPONENTES.Plantilla_Panel;
import Eventos.Mouse_Boton;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JTextField;

public class Inicio extends Plantilla_Panel implements ActionListener{
	
	private Login lg = Login.getInstancia(); // INSTANCIA CON EL LOGIN O JFRAME
	
	//	COMPONENTES DEL PANEL
	private JButton Crear_U, Modificar_U, Exit;
	private JPanel Panel_Boton_Crear_U, Panel_Boton_Modificar_U;
	private JLabel T_Boton_Crear_U, T_Boton_Modificar_U;
	private JScrollPane scrollReferences;
	
	public Inicio(String Departamento, JScrollPane scroll) {
		
		super(); // CONSTRUCTOR DE LA CLASE PADRE
		this.scrollReferences = scroll; // REFENRECIA DE SCROLLPANE
		
		// PANEL TITULO
		super.PanelTitulo.setTitle("  Menú de Inicio");
		super.PanelTitulo.setIconImage(new ImageIcon("Imagenes/inicio_T.png")); // ICONO DEL TITULO
		
		super.PanelContent.setLayout(new GridLayout(2, 4, 0, 0)); // ESTABLECER LAYOUT DEL PANELCONTENT
		
		// CONSTRUCCION DE FUNCIONES SEGÚN DEPARTAEMNTO
		switch(Departamento) {
			
			// DEPARTAMENTO DE INFORMATICA
			case "Informatica":
				
				// PANEL
				this.Panel_Boton_Crear_U = new JPanel();
				this.Panel_Boton_Crear_U.setBackground(new Color(255, 255, 255));
				super.PanelContent.add(Panel_Boton_Crear_U);
				this.Panel_Boton_Crear_U.setLayout(new BorderLayout(0, 0));
				
				// BOTON
				this.Crear_U = new JButton("");
				this.Crear_U.setBackground(new Color(255, 255, 255));
				this.Crear_U.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				this.Crear_U.setIcon(new ImageIcon("Imagenes/add_User_R_N.png"));
				this.Crear_U.addMouseListener(new Mouse_Boton(Panel_Boton_Crear_U, new Color(255,255,255), new Color(192,192,192)));
				this.Crear_U.addActionListener(this);
				this.Crear_U.setContentAreaFilled(false);
				this.Panel_Boton_Crear_U.add(Crear_U, BorderLayout.CENTER);
				
				// ETIQUETA TITULO
				this.T_Boton_Crear_U = new JLabel("CREAR USUARIO");
				this.T_Boton_Crear_U.setHorizontalAlignment(SwingConstants.CENTER);
				this.T_Boton_Crear_U.setForeground(new Color(113, 106, 234));
				this.T_Boton_Crear_U.setFont(new Font("Arial", Font.BOLD, 19));
				this.T_Boton_Crear_U.setBackground(new Color(255, 255, 255));
				this.T_Boton_Crear_U.setOpaque(false);
				Panel_Boton_Crear_U.add(T_Boton_Crear_U, BorderLayout.SOUTH);
				
				
				// PANEL
				this.Panel_Boton_Modificar_U = new JPanel();
				this.Panel_Boton_Modificar_U.setBackground(new Color(255, 255, 255));
				super.PanelContent.add(Panel_Boton_Modificar_U);
				this.Panel_Boton_Modificar_U.setLayout(new BorderLayout(0, 0));
				
				// BOTON
				this.Modificar_U = new JButton("");
				this.Modificar_U.setBackground(new Color(255, 255, 255));
				this.Modificar_U.setIcon(new ImageIcon("Imagenes/edit_User_R_N.png"));
				this.Modificar_U.addMouseListener(new Mouse_Boton(Panel_Boton_Modificar_U, new Color(255,255,255), new Color(192,192,192)));
				this.Modificar_U.addActionListener(this);
				this.Modificar_U.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				this.Modificar_U.setContentAreaFilled(false);
				this.Panel_Boton_Modificar_U.add(Modificar_U, BorderLayout.CENTER);
				
				// ETIQUETA TITULO
				this.T_Boton_Modificar_U = new JLabel("MODIFICAR USUARIOS");
				this.T_Boton_Modificar_U.setHorizontalAlignment(SwingConstants.CENTER);
				this.T_Boton_Modificar_U.setForeground(new Color(113, 106, 234));
				this.T_Boton_Modificar_U.setFont(new Font("Arial", Font.BOLD, 19));
				this.T_Boton_Modificar_U.setBackground(new Color(255, 255, 255));
				this.T_Boton_Modificar_U.setOpaque(false);
				Panel_Boton_Modificar_U.add(T_Boton_Modificar_U, BorderLayout.SOUTH);
				
			break;
		}
		
		JPanel Panel_Boton_Conf = new JPanel();
		Panel_Boton_Conf.setBackground(new Color(255, 255, 255));
		super.PanelContent.add(Panel_Boton_Conf);
		Panel_Boton_Conf.setLayout(new BorderLayout(0, 0));
		
		JButton Conft = new JButton("");
		Conft.setOpaque(false);
		Conft.setBackground(new Color(255, 255, 255));
		Conft.setContentAreaFilled(false);
		Conft.setIcon(new ImageIcon("Imagenes/conft_R_N.png"));
		Conft.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Conft.addMouseListener(new Mouse_Boton(Panel_Boton_Conf, new Color(255,255,255), new Color(192,192,192)));
		Panel_Boton_Conf.add(Conft, BorderLayout.CENTER);
		
		JLabel T_Boton_Conf = new JLabel("CONFIGURACION");
		T_Boton_Conf.setHorizontalAlignment(SwingConstants.CENTER);
		T_Boton_Conf.setForeground(new Color(113, 106, 234));
		T_Boton_Conf.setFont(new Font("Arial", Font.BOLD, 19));
		T_Boton_Conf.setBackground(new Color(255, 255, 255));
		T_Boton_Conf.setOpaque(false);
		Panel_Boton_Conf.add(T_Boton_Conf, BorderLayout.SOUTH);
		
		JPanel Panel_Boton_Exit = new JPanel();
		Panel_Boton_Exit.setBackground(new Color(255, 255, 255));
		super.PanelContent.add(Panel_Boton_Exit);
		Panel_Boton_Exit.setLayout(new BorderLayout(0, 0));
		
		this.Exit = new JButton("");
		this.Exit.setOpaque(false);
		this.Exit.setBackground(new Color(255, 255, 255));
		this.Exit.setContentAreaFilled(false);
		this.Exit.setIcon(new ImageIcon("Imagenes/exit_R_N.png"));
		this.Exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.Exit.addMouseListener(new Mouse_Boton(Panel_Boton_Exit, new Color(255,255,255), new Color(192,192,192)));
		this.Exit.addActionListener(this);
		Panel_Boton_Exit.add(Exit, BorderLayout.CENTER);
		
		JLabel T_Boton_Exit = new JLabel("CERRAR SESION");
		T_Boton_Exit.setOpaque(true);
		T_Boton_Exit.setBackground(new Color(255, 255, 255));
		T_Boton_Exit.setHorizontalAlignment(SwingConstants.CENTER);
		T_Boton_Exit.setForeground(new Color(113, 106, 234));
		T_Boton_Exit.setFont(new Font("Arial", Font.BOLD, 19));
		T_Boton_Exit.setOpaque(false);
		Panel_Boton_Exit.add(T_Boton_Exit, BorderLayout.SOUTH);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		//	VOLVER AL LOGIN
		if(e.getSource() == Exit) {
			lg.setLogin();
		}
		
		// CREAR USUARIO
		if(e.getSource() == Crear_U) {
			Crear_Usuario c = new Crear_Usuario();
			this.scrollReferences.setViewportView(c);
		}
		
		if(e.getSource() == Modificar_U) {
			Vista_Usuarios c = new Vista_Usuarios();
			this.scrollReferences.setViewportView(c);
		}
		
	}
}
