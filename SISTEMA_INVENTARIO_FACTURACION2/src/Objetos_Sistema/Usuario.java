package Objetos_Sistema;

public class Usuario {
	
	//ATRIBUTOS
	private int id;
	private int Cedula;
	private String Nombres;
	private String Apellidos;
	private String Departamento;
	private String Descripcion;
	
	// CONSTRUCTOR
	public Usuario(Object...datos) {
		
		// DATOS INGRESADOS DESDE CONSTRUCTOR
		this.id = (int) datos[0];
		this.Cedula = (int) datos[1];
		this.Nombres = (String) datos[2];
		this.Apellidos = (String) datos[3];
		this.Departamento = (String) datos[4];
		this.Descripcion = (String) datos[5];
		
	}
	
	// SETTERS AND GETTERS
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCedula() {
		return Cedula;
	}

	public void setCedula(int cedula) {
		Cedula = cedula;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getDepartamento() {
		return Departamento;
	}

	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
}
