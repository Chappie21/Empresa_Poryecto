package UI;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import COMPONENTES.EncabezadoTabla;
import COMPONENTES.GestionCeldas;
import COMPONENTES.JLabelColor;
import COMPONENTES.JModelTableUser;
import COMPONENTES.Plantilla_Panel;
import Conexion.BD;
import Objetos_Sistema.Usuario;
import UTILIDADES.Using;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;


public class Vista_Usuarios extends Plantilla_Panel implements MouseListener, KeyListener{
	
	private BD bd = BD.obtenerInstancia();
	
	// COMPONENTES DE LA VENTANA
	private JTable table;
	private JTextField Busqueda;
	private JComboBox Filtrado;
	private JLabelColor Informacion;
	
	// LISTA DINAMICA
	private ArrayList<Usuario> Lista;
	private ArrayList<Usuario> ListaB = null;
	
	public Vista_Usuarios() {
		
		super();
		super.PanelTitulo.setTitle("  Modificar lista de usuarios");
		super.PanelTitulo.setIconImage(new ImageIcon("Imagenes/edit_User_R_T.png"));
		
		PanelContent.setLayout(new BorderLayout(0, 0));
		
		// JTABLE
		table = new JTable();
		this.Lista = bd.Usuarios();// OBTENER LISTA DE USUARIOS
		this.BuildTable(Lista);
		JTableHeader cabeza = table.getTableHeader();
		cabeza.setDefaultRenderer(new EncabezadoTabla());
		table.setTableHeader(cabeza);
		this.table.addMouseListener(this);
		
		// SCROLLPANE
		JScrollPane scrollPane = new JScrollPane(table);
		PanelContent.add(scrollPane, BorderLayout.CENTER);
		
		JPanel Barra = new JPanel();
		Barra.setBackground(Color.WHITE);
		PanelContent.add(Barra, BorderLayout.SOUTH);
		Barra.setLayout(new BorderLayout(0, 0));
		
		JLabel Espacio = new JLabel("      ");
		Barra.add(Espacio, BorderLayout.NORTH);
		
		JPanel Content_Barra = new JPanel();
		Barra.add(Content_Barra, BorderLayout.CENTER);
		Content_Barra.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.Busqueda = new JTextField();
		this.Busqueda.addKeyListener(this);
		Content_Barra.add(Busqueda);
		this.Busqueda.setColumns(10);
		
		this.Filtrado = new JComboBox();
		Content_Barra.add(Filtrado);
		
		this.Informacion = new JLabelColor("Puede realizar acciones de busqueda");
		Content_Barra.add(Informacion);
		
	}
	
	private void BuildTable(ArrayList<Usuario> Lista) {
		
		JModelTableUser modelo = new JModelTableUser(Lista);// GENERAR MODELO DE TABLA
		this.table.setModel(modelo); // ESTABLECER MODELO DE DATOS DE LA TABLA
		
		// GESTION DE CELDAS
		this.table.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("numerico"));
		this.table.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("numerico"));
		this.table.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
		this.table.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("texto"));
		this.table.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("texto"));
		this.table.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("texto"));
		this.table.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("boton"));
		this.table.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("boton"));
		
		// PREFERENCIAS DE TAMAÑO EN COLUMNAS
		this.table.getColumnModel().getColumn(0).setPreferredWidth(10);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(50);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(80);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(80);
		this.table.getColumnModel().getColumn(4).setPreferredWidth(96);
		this.table.getColumnModel().getColumn(5).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(6).setPreferredWidth(20);
		this.table.getColumnModel().getColumn(7).setPreferredWidth(20);
		
		// TAMAÑO DE LAS FILAS
		this.table.setRowHeight(25);
		
		
		// VISUALIZAR DIBUJADO DE LAS CELDAS
		this.table.setShowGrid(false);
		
	}
	
	private void Borrar(int fila) {
		
		boolean operacion;
		
		if(this.ListaB != null) {
			
			operacion = bd.EliminarUsuario(ListaB.get(fila));
			
		}else {
			
			operacion = bd.EliminarUsuario(Lista.get(fila));
			
		}
		
		
		if(operacion) {
			
			this.Informacion.setTextColor("Usuario Eliminado", "Green");
			this.Lista = bd.Usuarios();// OBTENER LISTA DE USUARIOS
			BuildTable(Lista); // VULVE A CONTRUIRSE LA TABLA;
			
		}else {
			
			this.Informacion.setTextColor("Error al Eliminar Usuario", "Red");
		}	
		
	}
	
	private void Editar(int fila) {
		
		Editar_Usuario l = new Editar_Usuario(Lista.get(fila));
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		/*
		 * PARA EL EVENTO PRIMERO SE CAPTURA LA FILA SELECCIONADA,
		 * POSTERIOR A ESTO CAPTURAMOS LA COLUMNA SELECCIONADA Y EN BASE A ESTO
		 * PODEMOS DETERMINAR SI SE HA PRECIONADO UN BOTON O NO
		 */
		
		int filaSelected = this.table.getSelectedRow();
		int ColumnaSelectd = this.table.getSelectedColumn();
		
		if(ColumnaSelectd == 6) {
			
			Editar(filaSelected);
			
		}else if(ColumnaSelectd == 7){
			
			Borrar(filaSelected);
			
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	// EVENTO DE BUSQUEDA AL ESCRIBIR
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		String filtrado = Busqueda.getText();
		
		this.ListaB = new ArrayList<>();
		
		if(!filtrado.isEmpty()) {
			if(Using.isNumeric(filtrado)) {
				
				int numeroB = Integer.parseInt(filtrado); // CONVERTIMOS EL PARAMETRO DE BUSQUEDA EN NUMERICO
				
				for(Usuario user: this.Lista) {
					
					if(numeroB == user.getId()) {
						
						ListaB.add(user);
						
					}else if(numeroB == user.getCedula()) {
						ListaB.add(user);
					}
					
				}
				
				if(!this.ListaB.isEmpty()) {
					BuildTable(this.ListaB);
				}else {
					this.Informacion.setTextColor("El Parametro "+filtrado+" No ha sido encontrado", "Red");
				}
				
				
				
			}else {
				
			}
		}else {
			BuildTable(this.Lista);
			this.ListaB = null;
		}
		
	}
	
}
