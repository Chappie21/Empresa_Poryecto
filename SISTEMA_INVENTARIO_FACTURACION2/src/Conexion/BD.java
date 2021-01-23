package Conexion;

import java.sql.*;
import java.util.ArrayList;

import Objetos_Sistema.Usuario;
import SEGURIDAD.BCrypt;


public class BD {
	
	//SINGLETON
	private static BD bd = new BD();
	
	//POOL
	private Pool ManagerPool = Pool.getInstancia();
	
	//ATRIBUTOS DE CONEXION CON BASE DE DATOS
	private Connection con;
	private Statement st;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	private BD() {}
	
	public String[] Consulta_Login(int Cedula, String Clave) {
		
		try {
			
			this.con = this.ManagerPool.getConnection();
		
			this.st = this.con.createStatement();
			this.rs = this.st.executeQuery("SELECT nombres, apellidos, departamento, clave FROM Usuarios WHERE Cedula ="+Cedula);
			
			if(rs.next()) {
				if(BCrypt.checkpw(Clave, rs.getString("Clave"))) {

					String data[] = {rs.getString("Nombres"), rs.getString("Apellidos"), rs.getString("Departamento")};
					System.out.println("Inicio la sesion");
					return data;
					
				}else {
					return null;
				}
			}else {
				return null;
			}
				
		} catch (SQLException e) {
			System.out.println("ERROR EN CONSULTA: "+e.getMessage());
			return null;	
		}finally {
			
			try {
				this.con.close();
				this.st.close();
				this.rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
	}
	
	private Boolean Existente(int Cedula, Connection con) {
		
		try {
			
			this.pstm = con.prepareStatement("select*from usuarios where cedula=?");
			this.pstm.setInt(1, Cedula);
			this.rs = this.pstm.executeQuery();
			
			// EN CASO DE ENCONTRARLO RETORNARÁ TRUE
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				this.pstm.close();
				this.rs.close();
			}catch(SQLException f) {
				
			}
		}
		
		return false;
	}
	
	public boolean Agregar_Usuario(Usuario user) {
		
		try {
			
			this.con = this.ManagerPool.getConnection();

			if(!Existente((int) user.getCedula(), con)) {
				
				this.pstm = this.con.prepareStatement("insert into usuarios (Cedula, Nombres, Apellidos, Departamento, Descripcion, Clave) values(?,?,?,?,?,?)");
				this.pstm.setInt(1, user.getCedula());
				this.pstm.setString(2, user.getNombres());
				this.pstm.setString(3, user.getApellidos());
				this.pstm.setString(4, user.getDepartamento());
				this.pstm.setString(5, user.getDescripcion());
				this.pstm.setString(6, user.getClave());
				
				this.pstm.executeUpdate(); // EJECUTAR QUERY
				
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				this.pstm.close();
				this.rs.close();
				this.con.close();
			}catch(SQLException f) {
				
			}
		}
		
		return false;
	}
	
	
	public ArrayList<Usuario> Usuarios(){
		
		ArrayList<Usuario> lista = new ArrayList<>(); 
		
		try {
			
			this.con = this.ManagerPool.getConnection();
			this.st = this.con.createStatement();
			this.rs = this.st.executeQuery("select id_user, cedula, nombres, apellidos, departamento, descripcion from usuarios");
			
			while(rs.next()) {
				lista.add(new Usuario(rs.getInt("id_user"), rs.getInt("cedula"), rs.getString("nombres"),
						rs.getString("apellidos"), rs.getString("departamento"), rs.getString("descripcion")));
			}
			
			return lista;
			
		}catch(SQLException e) {
			
			System.out.println("Error al obtener lista de usuarios: "+e.getMessage());

		}finally {
			
			try {
				this.con.close();
				this.st.close();
				this.rs.close();
			}catch(SQLException f) {
				
			}
			
		}
		
		return null;
	}
	
	
	public boolean EliminarUsuario(Usuario user) {
		
		try {
			
			this.con = ManagerPool.getConnection();
			this.pstm = this.con.prepareStatement("DELETE FROM Usuarios WHERE id_user = ?");
			
			this.pstm.setInt(1, user.getId());
			
			this.pstm.execute();
			
			return true; // RETORNA TRUE EN CASO DE ELIMINAR EL USUARIO CON EXITO
			
		}catch(SQLException e) {
			System.out.println("ERROR AL ELIMINAR USUARIO: "+e.getMessage());
		}finally {
			
			try {
				this.pstm.close();
				this.rs.close();
				this.con.close();
			}catch(SQLException f) {
				
			}
		}
		
		return false; // EN CASO DE FALLO RETORNA FALSE
		
	}
	
	
	public boolean ActualizarUsuario(Usuario user) {
		
		String query = "UPDATE Usuarios SET Cedula = ?, Nombres = ?, Apellidos = ?, Departamento = ?, Descripcion = ? WHERE id_user = ?;";
		
		try {
			
			this.con = this.ManagerPool.getConnection();
			
			if(user.getClave() != null) {
				query = "UPDATE Usuarios SET Cedula = ?, Nombres = ?, Apellidos = ?, Departamento = ?, Descripcion = ?, Clave = ? WHERE id_user = ?;";
			}
			
			this.pstm = this.con.prepareStatement(query);
			
			this.pstm.setInt(1, user.getCedula());
			this.pstm.setString(2, user.getNombres());
			this.pstm.setString(3, user.getApellidos());
			this.pstm.setString(4, user.getDepartamento());
			this.pstm.setString(5, user.getDescripcion());
			
			if(user.getClave() != null) {
				this.pstm.setString(6, user.getClave());
				this.pstm.setInt(7, user.getId());
			}else {
				this.pstm.setInt(6, user.getId());
			}
			
			this.pstm.executeUpdate();
			
			return true;
			
		}catch(SQLException e) {
			System.out.println("Error al actualizar usuario: "+e.getMessage());
		}finally {
			try {
				this.pstm.close();
				this.con.close();
			}catch(SQLException f) {
				
			}
		}
		
		
		return false;
	}
	
	
	
	public static BD obtenerInstancia() {
		return bd;
	}
}
