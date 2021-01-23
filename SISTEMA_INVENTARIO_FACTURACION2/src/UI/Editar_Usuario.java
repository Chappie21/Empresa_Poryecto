package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import COMPONENTES.Ctext;
import COMPONENTES.JLabelColor;
import Conexion.BD;
import Eventos.ClaveEvent;
import Objetos_Sistema.Usuario;
import SEGURIDAD.BCrypt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class Editar_Usuario extends JFrame implements ActionListener {
	
	private BD bd = BD.obtenerInstancia();
	
	// ATRIBUTOS
	private JPanel Panel_Principal;
	private Ctext Nombres;
	private Ctext Apellidos;
	private Ctext Cedula;
	private JTextArea Descripcion;
	private JPasswordField Clave;
	private JScrollPane scrollPane;
	private JButton cancelar, guardar;
	private JComboBox Departamento;
	private Usuario user;
	private JLabelColor Info;
	private ClaveEvent confirmarClave;

	public Editar_Usuario(Usuario user) {
		
		super("Editar Usuario");
		this.setIconImage(new ImageIcon("Imagenes/edit_User_R_T.png").getImage());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(450, 300);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.user = user; // TOMAMOS LOS DATOS DEL USUARIO 
		
		this.Panel_Principal = new JPanel();
		Panel_Principal.setBackground(Color.WHITE);
		this.Panel_Principal.setBorder(new LineBorder(new Color(0, 51, 153), 4));
		this.setContentPane(Panel_Principal);
		Panel_Principal.setLayout(null);
		
		Nombres = new Ctext("Ingrese Nombres");
		Nombres.setText(user.getNombres());
		Nombres.setBounds(17, 14, 190, 22);
		Panel_Principal.add(Nombres);
		Nombres.setColumns(10);
		
		Apellidos = new Ctext("Ingrese Apellidos");
		Apellidos.setText(user.getApellidos());
		Apellidos.setColumns(10);
		Apellidos.setBounds(227, 14, 190, 22);
		Panel_Principal.add(Apellidos);
		
		Cedula = new Ctext("Ingrese Cedula");
		Cedula.setText(String.valueOf(user.getCedula()));
		Cedula.setColumns(10);
		Cedula.setBounds(17, 50, 190, 22);
		Panel_Principal.add(Cedula);
		
		this.Departamento = new JComboBox();
		Departamento.setModel(new DefaultComboBoxModel(new String[] {"Materia Prima", "Procesos", "Control de Calidad", "Almacenamiento", "Gerencia", "Informatica"}));
		Departamento.setSelectedItem(user.getDepartamento());
		Departamento.setFont(new Font("Arial", Font.BOLD, 14));
		this.Departamento.setBounds(227, 48, 190, 21);
		Panel_Principal.add(Departamento);
		
		this.Info = new JLabelColor("Nueva contrase\u00F1a 10 a 15 caracteres");
		this.Info.setText("Reemplace los datos a editar");
		this.Info.setFont(new Font("Arial", Font.BOLD, 13));
		this.Info.setBounds(17, 177, 400, 22);
		Panel_Principal.add(Info);
		
		JLabelColor Confirmacion_Clave = new JLabelColor("Nueva contraseña 10 a 15 caracteres");
		Confirmacion_Clave.setFont(new Font("Arial", Font.BOLD, 10));
		Confirmacion_Clave.setBounds(227, 81, 190, 27);
		Panel_Principal.add(Confirmacion_Clave);
		
		this.Clave = new JPasswordField();
		this.Clave.setBounds(17, 88, 190, 22);
		this.confirmarClave = new ClaveEvent(Clave, Confirmacion_Clave);
		this.Clave.addKeyListener(confirmarClave);
		Panel_Principal.add(Clave);
		this.Clave .setColumns(10);
		
		this.Descripcion = new JTextArea(user.getDescripcion());
		Descripcion.setFont(new Font("Arial", Font.BOLD, 13));
		Descripcion.setForeground(new Color(0, 0, 0));
		Descripcion.setBorder(new LineBorder(new Color(105, 105, 105), 2, true));
		Descripcion.setBackground(new Color(211, 211, 211));
		
		scrollPane = new JScrollPane(Descripcion);
		scrollPane.setBounds(17, 122, 400, 43);
		Panel_Principal.add(scrollPane);
		
		this.cancelar = new JButton("CANCELAR");
		cancelar.setForeground(new Color(255, 255, 255));
		cancelar.setFont(new Font("Arial", Font.BOLD, 14));
		cancelar.setBackground(new Color(0, 191, 255));
		cancelar.setBounds(17, 211, 190, 38);
		this.cancelar.addActionListener(this);
		this.cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Panel_Principal.add(cancelar);
		
		this.guardar = new JButton("GUARDAR");
		this.guardar.setForeground(new Color(255, 255, 255));
		this.guardar.setFont(new Font("Arial", Font.BOLD, 14));
		this.guardar.setBackground(new Color(0, 191, 255));
		this.guardar.setBounds(219, 211, 198, 38);
		this.guardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.guardar.addActionListener(this);
		Panel_Principal.add(guardar);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == cancelar) {
		
			this.dispose();
			
		}
		
		if(e.getSource() == guardar) {
			
			// COMPRUEBA QUE TODOS LOS CAMPOS HAYAN SIDO RELLENADOS O DETERMINADOS
			if(!Nombres.getText().equalsIgnoreCase("Ingrese Nombres") && !Apellidos.getText().equalsIgnoreCase("Ingrese Apellidos")
				&& !Cedula.getText().equalsIgnoreCase("Ingrese Cedula") && !((String) Departamento.getSelectedItem()).equalsIgnoreCase("Departamento")) {
							
					if(!Clave.getText().isEmpty()) {
						
						// CONFIRMA QUE LA CKAVE SE ACEPTABLE
						if(confirmarClave.ConfirmarClave()) {
									
							String hashed = BCrypt.hashpw(Clave.getText(), BCrypt.gensalt());
							this.user.setClave(hashed);
									
						}else {
					
							this.Info.setTextColor(" Por favor, mejore la contraseña ","Red");
									
						}
					}
					
					this.user.setNombres(Nombres.getText());
					this.user.setApellidos(Apellidos.getText());
					this.user.setCedula(Integer.parseInt(Cedula.getText()));
					this.user.setDepartamento((String) Departamento.getSelectedItem());
					this.user.setDescripcion(Descripcion.getText());
					
					
					boolean operacion = bd.ActualizarUsuario(user);
					
					if(operacion) {
						this.dispose();
					}else {
						this.Info.setTextColor("Error al actualizar informacion", "Red");
					}
							
			}else {
							
				// MUESTRA MENSAJE DE ERROR EN CASO DE NO HABER COMPLEATADO LOS CAMPOS OBLIGATORIOS 
				this.Info.setTextColor("  Rellene todos los campos obligatorios","Red");
							
			}
			
			
		}
		
	}
}
