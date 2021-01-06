package Conexion;

import java.sql.*;


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
				if(rs.getString("Clave").equals(Clave)) {

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
			
			try {
				this.pstm.close();
				this.rs.close();
			}catch(SQLException f) {
				
			}
			
		}
		
		return false;
	}
	
	private int Nuevo_id(String table, Connection con) {
		
		int nuevo_id = 1;
		
		try {
			
			this.st = con.createStatement();
			this.rs = this.st.executeQuery("select max(id_user) from "+table);
			
			rs.next();
			
			nuevo_id = rs.getInt(1) + 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				this.st.close();
				this.rs.close();
			}catch(SQLException f) {
				
			}
		}
		
		return nuevo_id;
		
	}
	
	
	public boolean Agregar_Usuario(Object...datos) {
		
		try {
			
			this.con = this.ManagerPool.getConnection();
			
			if(!Existente((int) datos[0], con)) {
				
				int id = Nuevo_id("Usuarios", con);
				
				this.pstm = this.con.prepareStatement("insert into usuarios values(?,?,?,?,?,?,?)");
				this.pstm.setInt(1, id);
				this.pstm.setInt(2, (int) datos[0]);
				this.pstm.setString(3, (String) datos[1]);
				this.pstm.setString(4, (String) datos[2]);
				this.pstm.setString(5, (String) datos[3]);
				this.pstm.setString(6, (String) datos[4]);
				this.pstm.setString(7, (String) datos[5]);
				
				this.pstm.executeUpdate(); // EJECUTAR QUERY
				
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			try {
				this.pstm.close();
				this.rs.close();
			}catch(SQLException f) {
				
			}
			
		}
		
		return false;
	}
	
	public static BD obtenerInstancia() {
		return bd;
	}
}
