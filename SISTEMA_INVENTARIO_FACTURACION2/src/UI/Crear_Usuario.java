package UI;

import javax.swing.JPanel;
import COMPONENTES.Plantilla_Panel;
import Conexion.BD;
import Eventos.ClaveEvent;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.DefaultComboBoxModel;
import COMPONENTES.Ctext;
import COMPONENTES.JLabelColor;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import Objetos_Sistema.Usuario;
import SEGURIDAD.BCrypt;

public class Crear_Usuario extends Plantilla_Panel implements ActionListener{
	
	private BD bd = BD.obtenerInstancia(); // INSTANCIA CON LA CLASE BD
	
	private Ctext Nombres, Apellidos, Cedula;	
	private JPasswordField Clave;
	private JTextArea Descripcion;
	private JLabelColor Confirmacion, Information_O;
	private JButton Guardar;
	private JScrollPane scrollPane;
	private JComboBox Departamento;
	private ClaveEvent confirmarClave;
	
	public Crear_Usuario() {

		super();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{273, 279, 126, 0};
		gridBagLayout.rowHeights = new int[]{39, 39, 39, 33, 100, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		PanelContent.setLayout(gridBagLayout);
		
		this.Nombres = new Ctext("Ingrese Nombres");
		GridBagConstraints gbc_Nombres = new GridBagConstraints();
		gbc_Nombres.fill = GridBagConstraints.BOTH;
		gbc_Nombres.insets = new Insets(0, 0, 5, 5);
		gbc_Nombres.gridx = 0;
		gbc_Nombres.gridy = 0;
		PanelContent.add(Nombres, gbc_Nombres);
		this.Nombres.setColumns(10);
		
		this.Apellidos = new Ctext("Ingrese Apellidos");
		this.Apellidos.setColumns(10);
		GridBagConstraints gbc_Apellidos = new GridBagConstraints();
		gbc_Apellidos.weightx = 1.0;
		gbc_Apellidos.fill = GridBagConstraints.BOTH;
		gbc_Apellidos.insets = new Insets(0, 0, 5, 5);
		gbc_Apellidos.gridx = 1;
		gbc_Apellidos.gridy = 0;
		super.PanelContent.add(Apellidos, gbc_Apellidos);
		
		this.Cedula = new Ctext("Ingrese Cedula");
		this.Cedula.setColumns(10);
		GridBagConstraints gbc_Cedula = new GridBagConstraints();
		gbc_Cedula.weightx = 1.0;
		gbc_Cedula.fill = GridBagConstraints.BOTH;
		gbc_Cedula.insets = new Insets(0, 0, 5, 5);
		gbc_Cedula.gridx = 0;
		gbc_Cedula.gridy = 1;
		super.PanelContent.add(Cedula, gbc_Cedula);
		
		this.Departamento = new JComboBox(new DefaultComboBoxModel(new String[] {"Departamento", "Materia Prima", "Procesos", "Control de Calidad", "Almacenamiento", "Gerencia", "Informatica"}));
		GridBagConstraints gbc_Departamento = new GridBagConstraints();
		gbc_Departamento.weightx = 1.0;
		gbc_Departamento.fill = GridBagConstraints.BOTH;
		gbc_Departamento.insets = new Insets(0, 0, 5, 5);
		gbc_Departamento.gridx = 1;
		gbc_Departamento.gridy = 1;
		super.PanelContent.add(Departamento, gbc_Departamento);
		
		this.Confirmacion = new JLabelColor("de 10 a 15 caracteres");
		this.Confirmacion.setHorizontalAlignment(SwingConstants.CENTER);
		this.Confirmacion.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_Confirmacion = new GridBagConstraints();
		gbc_Confirmacion.fill = GridBagConstraints.BOTH;
		gbc_Confirmacion.insets = new Insets(0, 0, 5, 5);
		gbc_Confirmacion.gridx = 1;
		gbc_Confirmacion.gridy = 2;
		super.PanelContent.add(Confirmacion, gbc_Confirmacion);
		
		
		this.Clave = new JPasswordField();
		this.Clave.setFont(new Font("Arial", Font.BOLD, 15));
		this.confirmarClave = new ClaveEvent(Clave, Confirmacion);
		this.Clave.addKeyListener(confirmarClave);
		GridBagConstraints gbc_Clave = new GridBagConstraints();
		gbc_Clave.weightx = 1.0;
		gbc_Clave.fill = GridBagConstraints.BOTH;
		gbc_Clave.insets = new Insets(0, 0, 5, 5);
		gbc_Clave.gridx = 0;
		gbc_Clave.gridy = 2;
		super.PanelContent.add(Clave, gbc_Clave);
		
		this.Descripcion = new JTextArea();
		Descripcion.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		
		this.scrollPane = new JScrollPane(Descripcion);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weightx = 1.0;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		PanelContent.add(scrollPane, gbc_scrollPane);
		
		this.Information_O = new JLabelColor("  Rellene Todos los datos");
		Information_O.setFont(new Font("Arial", Font.BOLD, 19));
		GridBagConstraints gbc_Information_O = new GridBagConstraints();
		gbc_Information_O.fill = GridBagConstraints.BOTH;
		gbc_Information_O.insets = new Insets(0, 0, 5, 5);
		gbc_Information_O.gridx = 0;
		gbc_Information_O.gridy = 7;
		PanelContent.add(Information_O, gbc_Information_O);
		
		this.Guardar = new JButton("CREAR");
		this.Guardar.setFont(new Font("Arial", Font.BOLD, 13));
		this.Guardar.setForeground(new Color(255, 255, 255));
		this.Guardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.Guardar.setIcon(new ImageIcon("Imagenes/add_create_N.png"));
		this.Guardar.setBackground(new Color(0, 191, 255));
		this.Guardar.addActionListener(this);
		GridBagConstraints gbc_Guardar = new GridBagConstraints();
		gbc_Guardar.weightx = 1.0;
		gbc_Guardar.fill = GridBagConstraints.BOTH;
		gbc_Guardar.gridx = 2;
		gbc_Guardar.gridy = 4;
		super.PanelContent.add(Guardar, gbc_Guardar);
		
		super.PanelTitulo.setTitle("  Crear nuevo usuario");
		super.PanelTitulo.setIconImage(new ImageIcon("Imagenes/add_User_R_T.png"));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == Guardar) {
			
			
			// COMPRUEBA QUE TODOS LOS CAMPOS HAYAN SIDO RELLENADOS O DETERMINADOS
			if(!Nombres.getText().equalsIgnoreCase("Ingrese Nombres") && !Apellidos.getText().equalsIgnoreCase("Ingrese Apellidos")
				&& !Cedula.getText().equalsIgnoreCase("Ingrese Cedula") && !Clave.getText().isEmpty() && 
				!((String) Departamento.getSelectedItem()).equalsIgnoreCase("Departamento")) {
				
				// CONFIRMA QUE LA CLAVE SEA MAYOR 
				if(confirmarClave.ConfirmarClave()) {
					
					
					String hashed = BCrypt.hashpw(Clave.getText(), BCrypt.gensalt()); // OBTENER CONTRASEÑA ENCRIPTADA
					
					// SE GENERA UN NUEVO OBJETO DEL TIPO USUARIO
					Usuario nuevo_usuario = new Usuario(Integer.parseInt(Cedula.getText()), Nombres.getText(), Apellidos.getText(),
							(String) Departamento.getSelectedItem(), Descripcion.getText(), hashed);
					
					boolean confir = bd.Agregar_Usuario(nuevo_usuario); /*SE REALZA LA INSERCION DDE UN NUEVO REGISTRO Y OBTENEMOS
					 													  UN DATO BOOLEANO QUE CONFIRMA SI HA POSIDO CREARSE O NO*/
					
					// CONFIRMAR QUE EL INGRESO DEL NUEVO REGISTRO SE HAYA REALIZADO DE FORMA CORRECTA
					if(confir) {
						
						this.Information_O.setTextColor(" Usuario creado con exito ","Green");// MENSAJE DE CREACION EXITOSA
				
					}else {

						this.Information_O.setTextColor(" Usuario Ya existente ","Red"); // MENSAJE DE ERROR EN CASO DE QUE EL SUSUARIO YA EXISTA

					}
					
				}else {
					
					this.Information_O.setTextColor(" Por favor, mejore la contraseña ","Red");
					
				}
				
				
			}else {
				
				// MUESTRA MENSAJE DE ERROR EN CASO DE NO HABER COMPLEATADO LOS CAMPOS OBLIGATORIOS 
				this.Information_O.setTextColor("  Rellene todos los campos obligatorios","Red");
				
			}
			
			
		}
		
	}
}