package UI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Eventos.Mouse_Boton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;

public class Principal extends JPanel implements ActionListener{

	private Login lg = Login.getInstancia(); // INSTANCIA CON EL LOGIN O JFRAME
	
	//ATRIBUTOS DE LA VENTANA
	private JPanel Barra_Panel, Botones_Panel, Panel_Icono;;
	private JLabel Icono, Nombre;
	private JButton b_Inicio, b_Conf, b_Salir, b_Inventario, b_Crear, b_Eliminar_Modificar;
	private JScrollPane scrollPane;
	private String Departamento;
	
	public Principal(String datos[]) {
		
		this.setLayout(new BorderLayout(0, 0)); // LAYOUT DEL PANEL PADRE
		
		// PANELES
		this.Barra_Panel = new JPanel();
		this.Barra_Panel.setBorder(new LineBorder(new Color(128, 0, 0), 4, true));
		this.Barra_Panel.setBackground(new Color(139, 0, 0));
		this.add(Barra_Panel, BorderLayout.WEST);
		this.Barra_Panel.setLayout(new BorderLayout(0, 0));
		
		this.Botones_Panel = new JPanel();
		this.Botones_Panel.setBackground(new Color(139, 0, 0));
		this.Barra_Panel.add(Botones_Panel, BorderLayout.CENTER);
		this.Botones_Panel.setLayout(new GridLayout(7, 1, 0, 0));
		
		this.Panel_Icono = new JPanel();
		this.Panel_Icono.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		this.Panel_Icono.setBackground(new Color(128, 0, 0));
		this.Barra_Panel.add(Panel_Icono, BorderLayout.NORTH);
		this.Panel_Icono.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		Inicio in = new Inicio(datos[2], scrollPane);
		this.scrollPane.setViewportView(in);
		this.Departamento = datos[2];
		
		// ICONO
		this.Icono = new JLabel("");
		this.Icono.setBackground(new Color(128, 0, 0));
		this.Icono.addMouseListener(new Mouse_Boton(Icono, new Color(139, 0, 0), new Color(110, 0, 0)));
		
		this.Icono.setIcon(new ImageIcon("Imagenes/icon_usuario_N.png"));
		this.Panel_Icono.add(Icono, BorderLayout.CENTER);
		
		this.Nombre = new JLabel(datos[0]+" "+datos[1]);
		this.Nombre.setForeground(new Color(255, 255, 255));
		this.Nombre.setBackground(new Color(139, 0, 0));
		this.Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		this.Nombre.setFont(new Font("Arial", Font.BOLD, 11));
		this.Panel_Icono.add(Nombre, BorderLayout.SOUTH);
		
		// BOTONES
		this.b_Inicio = new JButton("INICIO");
		b_Inicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.b_Inicio.setHorizontalAlignment(SwingConstants.LEFT);
		this.b_Inicio.setBackground(new Color(139, 0, 0));
		this.b_Inicio.setIcon(new ImageIcon("Imagenes/inicio_N.png"));
		this.b_Inicio.addMouseListener(new Mouse_Boton(b_Inicio, new Color(139, 0, 0), new Color(110, 0, 0)));
		this.b_Inicio.addActionListener(this);
		this.b_Inicio.setFont(new Font("Arial", Font.BOLD, 12));
		this.b_Inicio.setForeground(new Color(255, 255, 255));
		this.Botones_Panel.add(b_Inicio);
		
		// CASOS POR DEPARTAMENTEO
		switch(datos[2]){
			
			case "Materia Prima":
				
				this.b_Inventario = new JButton("  INVENTARIO");
				this.b_Inventario.setHorizontalAlignment(SwingConstants.LEFT);
				this.b_Inventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				this.b_Inventario.setBackground(new Color(139, 0, 0));
				this.b_Inventario.setIcon(new ImageIcon("Imagenes/materia_N.png"));
				this.b_Inventario.addMouseListener(new Mouse_Boton(b_Inventario, new Color(139, 0, 0), new Color(110, 0, 0)));
				this.b_Inventario.setFont(new Font("Arial", Font.BOLD, 12));
				this.b_Inventario.setForeground(Color.WHITE);
				this.Botones_Panel.add(b_Inventario);
				
			break;
			
			case "Produccion":
			
			break;
			
			case "Control de Acceso":
			
			break;
			
			case "Almacenamiento":
			
			break;
			
			case "Informatica":
				
				this.b_Crear = new JButton("CREAR USUARIO");
				this.b_Crear.setHorizontalAlignment(SwingConstants.LEFT);
				this.b_Crear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				this.b_Crear.setBackground(new Color(139, 0, 0));
				this.b_Crear.setIcon(new ImageIcon("Imagenes/add_User_W_N.png"));
				this.b_Crear.addMouseListener(new Mouse_Boton(b_Crear, new Color(139, 0, 0), new Color(110, 0, 0)));
				this.b_Crear.addActionListener(this);
				this.b_Crear.setFont(new Font("Arial", Font.BOLD, 12));
				this.b_Crear.setForeground(Color.WHITE);
				this.Botones_Panel.add(b_Crear);
				
				this.b_Eliminar_Modificar = new JButton("MODIFICACIONES");
				this.b_Eliminar_Modificar.setHorizontalAlignment(SwingConstants.LEFT);
				this.b_Eliminar_Modificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				this.b_Eliminar_Modificar.setBackground(new Color(139, 0, 0));
				this.b_Eliminar_Modificar.setIcon(new ImageIcon("Imagenes/edit_User_W_N.png"));
				this.b_Eliminar_Modificar.addMouseListener(new Mouse_Boton(b_Eliminar_Modificar, new Color(139, 0, 0), new Color(110, 0, 0)));
				this.b_Eliminar_Modificar.addActionListener(this);
				this.b_Eliminar_Modificar.setFont(new Font("Arial", Font.BOLD, 12));
				this.b_Eliminar_Modificar.setForeground(Color.WHITE);
				this.Botones_Panel.add(b_Eliminar_Modificar);
			
			break;
		}
		
		
		this.b_Conf = new JButton("CONFIGURACION");
		this.b_Conf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.b_Conf.setHorizontalAlignment(SwingConstants.LEFT);
		this.b_Conf.setForeground(new Color(255, 255, 255));
		this.b_Conf.setIcon(new ImageIcon("Imagenes/conft_N.png"));
		this.b_Conf.setFont(new Font("Arial", Font.BOLD, 12));
		this.b_Conf.addMouseListener(new Mouse_Boton(b_Conf, new Color(139, 0, 0), new Color(110, 0, 0)));
		this.b_Conf.setBackground(new Color(139, 0, 0));
		this.Botones_Panel.add(b_Conf);
		
		this.b_Salir = new JButton("CERRAR SESION");
		this.b_Salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.b_Salir.setHorizontalAlignment(SwingConstants.LEFT);
		this.b_Salir.setForeground(new Color(255, 255, 255));
		this.b_Salir.addActionListener(this);
		this.b_Salir.addMouseListener(new Mouse_Boton(b_Salir, new Color(139, 0, 0), new Color(110, 0, 0)));
		
		this.b_Salir.setBackground(new Color(139, 0, 0));
		this.b_Salir.setIcon(new ImageIcon("Imagenes/exit_N.png"));
		this.b_Salir.setFont(new Font("Arial", Font.BOLD, 12));
		this.Botones_Panel.add(b_Salir);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// ACCION AL PRESIONAR EL BTOTON DE SALIDA
		if(e.getSource() == b_Salir) {
			lg.setLogin();
		}
		
		if(e.getSource() == b_Inicio) {
			Inicio in = new Inicio(this.Departamento, scrollPane);
			this.scrollPane.setViewportView(in);
		}
		
		if(e.getSource() == b_Crear) {
			Crear_Usuario c = new Crear_Usuario();
			this.scrollPane.setViewportView(c);
		}
		
		if(e.getSource() == b_Eliminar_Modificar){
			
			Vista_Usuarios c = new Vista_Usuarios();
			this.scrollPane.setViewportView(c);
			
		}
		
	}
	
	// COLOCAR PANEL
	public void setPanel(JPanel panel) {
		this.scrollPane.setViewportView(panel);
	}
	
}
