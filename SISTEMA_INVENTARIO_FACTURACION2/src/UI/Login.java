package UI;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Conexion.BD;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import COMPONENTES.*;
import mdlaf.*;
import SEGURIDAD.BCrypt;

public class Login extends JFrame implements ActionListener{
	
	//SINGLETON
	private static Login lg = new Login();
	
	//ELEMENTOS DE LA VENTANA
	private JPanel panel = new JPanel();
	private JLabel t1,tinfo;
	private JButton iniciar;
	private JPasswordField pass;
	private Wallper Wallpaper, Wallpaper2, icono, icono1, icono2;
	private Ctext Cedula;
	
	private BD bd = BD.obtenerInstancia(); //INSTANCIA BD
	
	private Login() {
		
		super("INICIAR DE SESION");
		this.setSize(1200,700);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("Imagenes/Logo_N_I_B.png").getImage());
		
		try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
		
		IniciarComponentes();
		this.setContentPane(panel);
		this.setVisible(true);
	}
	
	//INICIAR COMPONENTES
	private void IniciarComponentes() {
		
		this.panel.setLayout(null);
		
		//CAMPOS DE TEXTO
		this.Cedula = new Ctext("Ingrese su Cedula");
		this.Cedula.setBounds(860, 260, 280, 80);
		
		this.pass = new JPasswordField();
		this.pass.setBounds(860, 340, 280, 80);
		
		
		this.panel.add(Cedula); this.panel.add(pass);
		
		//ETIQUETAS
		this.t1 = new JLabel("INICIAR SESIÓN");
		
		this.t1.setBounds(920, 230, 150, 30);
		this.t1.setFont(new Font("SansSerif", 1, 15));
		
		this.panel.add(t1);
		
		this.tinfo = new JLabel();
		
		this.tinfo.setBounds(845, 450, 250, 30);
		this.tinfo.setForeground(Color.red);
		this.tinfo.setFont(new Font("SansSerif", 1, 15));
		
		this.panel.add(tinfo);
		
		//BOTONES
		this.iniciar = new JButton("INICIAR");
		this.iniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.iniciar.setBounds(840, 480, 300, 30);
		this.iniciar.setFont(new Font("SansSerif", 1, 15));
		this.iniciar.setForeground(Color.white);
		this.iniciar.setBackground(new Color(48, 180, 255));
		
		
		this.iniciar.addActionListener(this);
		
		this.panel.add(iniciar);
		
		//FONDOS
		
		//ICONOS
		this.icono = new Wallper(880, 20, 200, 200);
		this.icono.setImagen("Imagenes/user.png");
		
		this.panel.add(icono);
		
		this.icono1 = new Wallper(810, 280, 40, 40);
		this.icono1.setImagen("Imagenes/cedula.png");
		
		this.panel.add(icono1);
		
		this.icono2 = new Wallper(810, 370, 40, 30);
		this.icono2.setImagen("Imagenes/clave.png");
		
		this.panel.add(icono2);
		
		//ROJO
		this.Wallpaper = new Wallper(0, 0, 800,700);
		this.Wallpaper.setImagen("Imagenes/fondo_r.jpg");
		
		this.panel.add(Wallpaper);
		
		//BALNCO
		this.Wallpaper2 = new Wallper(800, 0, 400, 700);
		this.Wallpaper2.setImagen("Imagenes/fondo_b.jpg");
		
		this.panel.add(Wallpaper2);
		
		this.panel.repaint();
		this.repaint();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.iniciar) {
			
			this.tinfo.setText(null);
			String data[] = bd.Consulta_Login(Integer.parseInt(Cedula.getText()), pass.getText());
			
			if(data != null) {
				System.out.println("Incio de sesion correcto");
				
				this.setTitle("SISTEMA"); // CAMBIA TITULO A SISTEMA
				this.setResizable(true); // EL USUARIO PODRÁ ALTERAR EL TAMAÑO DE LA VENTANA
				
				Principal n = new Principal(data);
				this.setContentPane(n);
				
			}else {
				this.tinfo.setText("Cedula o contraseña incorrectas");
			}
			
		}
		
	}
	
	// OBTENER INSTANCIA
	public static Login getInstancia() {
		return lg;
	}
	
	// COLOCAR PANEL DE LOGIN
	public void setLogin() {
		this.setSize(1200, 700);
		this.setResizable(false);
		this.Cedula.setText(null);
		this.pass.setText(null);
		
		this.setContentPane(this.panel);
	}
	
}
