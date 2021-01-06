package Conexion;

import java.sql.Connection;
import java.sql.SQLException;

import org.postgresql.jdbc3.Jdbc3PoolingDataSource;



public class Pool {
	
	//MODELO SINGLETON
	public static Pool elpool = new Pool();
	
	//ATRIBUTOS DEL POOL
	private Jdbc3PoolingDataSource DataS;
	
	private Pool() {
			
		this.DataS = new Jdbc3PoolingDataSource();
		
		this.DataS.setDataSourceName("Pool");
		this.DataS.setURL("jdbc:postgresql://192.168.10.114:5432/EMPRESA");
		this.DataS.setUser("postgres");
		this.DataS.setPassword("chappie2k18");
		this.DataS.setMaxConnections(20);
		
		
	}
	
	public Connection getConnection() {
		
		Connection cn = null;
		
		try {
			
			cn = DataS.getConnection();
			System.out.println("Se establecio una conexion");
			
		}catch(SQLException e) {
			System.out.println("No se pudo obtener conexion");
		}
		
		return cn;
	}
	
	
	//RETONAR INSTANCIA UNICA
	public static Pool getInstancia() {
		return elpool;
	}
	
}
