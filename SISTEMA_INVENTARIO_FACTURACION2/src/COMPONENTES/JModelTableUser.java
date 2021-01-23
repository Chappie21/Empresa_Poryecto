package COMPONENTES;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import Objetos_Sistema.Usuario;

public class JModelTableUser extends AbstractTableModel{
	
	// UTILIDADES
	private static final int ID = 0;
	private static final int CEDULA = 1;
	private static final int NOMBRES = 2;
	private static final int APELLIDOS = 3;
	private static final int DEPARTAMENTO = 4;
	private static final int DESCRIPCION = 5;
	private static final int Boton1 = 6;
	private static final int Boton2 = 7; 
	
	// DATOS A UTILIZAR
	private final Class[] tipodatos;
	private final String[] columna;
	private ArrayList<Usuario> ListaDatos;
	
	public JModelTableUser(ArrayList<Usuario> lista) {
		
		this.tipodatos = new Class[] {Integer.class, Integer.class, String.class, String.class, String.class, String.class, Object.class, Object.class};
		this.columna = new String[] {"ID", "CEDULA", "NOMBRES", "APELLIDOS", "DEPARTAMENTO", "DESCRIPCION", " ", " "};
		this.ListaDatos = lista;
		
	}
	
	// OBTENER ÑA CANTIDAD DE COLIUMNAS A AÑADIR
	@Override
	public int getColumnCount() {
		return this.columna.length;
	}
	
	// OBETNER LA CANTIDAD DE FILAS A AÑADIR
	@Override
	public int getRowCount() {
		return this.ListaDatos.size();
	}
	
	// INDICAR EL COMBRE DE CADA COLUMNA (ENCABEZADO IDENTIDICADOR)
	public String getColumnName(int ColumnIndex) {
		return this.columna[ColumnIndex];
	}
	
	// INDICAR TIPO DE DATO DE CADA COLUMNA
	public Class<?> getColumnClass(int ColumnIndex){
		return this.tipodatos[ColumnIndex];
	}
	
	// OBTENEMOS UN USUARIO DE LA TABLA
	public Usuario getRow(int Fila) {
		return this.ListaDatos.get(Fila);
	}
	
	
	@Override
	public Object getValueAt(int fila, int columna) {
		
		switch(columna) {
		
			case ID: return this.ListaDatos.get(fila).getId();
			case CEDULA: return this.ListaDatos.get(fila).getCedula();
			case NOMBRES: return this.ListaDatos.get(fila).getNombres();
			case APELLIDOS: return this.ListaDatos.get(fila).getApellidos();
			case DEPARTAMENTO: return this.ListaDatos.get(fila).getDepartamento();
			case DESCRIPCION: return this.ListaDatos.get(fila).getDescripcion();
			case Boton1: return "EDITAR";
			case Boton2: return "BORRAR";
			
		}
		
		return null;
	}
	
}
