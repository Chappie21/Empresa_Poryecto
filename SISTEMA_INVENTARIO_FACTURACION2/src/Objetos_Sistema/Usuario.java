package Objetos_Sistema;

public class Usuario {
	
	//ATRIBUTOS
	private int id;
	private int Cedula;
	private String Nombres;
	private String Apellidos;
	private String Departamento;
	private String Descripcion;
	private String Clave;
	
	// CONSTRUCTOR CON CLAVE
	public Usuario(int Cedula, String Nombres, String Apellidos, String Departamento, String Descripcion, String Clave) {
			
			// DATOS INGRESADOS DESDE CONSTRUCTOR
			this.Cedula = Cedula; 
			this.Nombres = Nombres;
			this.Apellidos = Apellidos;
			this.Departamento = Departamento;
			this.Descripcion = Descripcion;
			this.setClave(Clave);
			
		}
	
	// CONSTRUCTOR SIN CLAVE
	public Usuario(int id, int Cedula, String Nombres, String Apellidos, String Departamento, String Descripcion) {
		
		// DATOS INGRESADOS DESDE CONSTRUCTOR
		this.id = id;
		this.Cedula = Cedula; 
		this.Nombres = Nombres;
		this.Apellidos = Apellidos;
		this.Departamento = Departamento;
		this.Descripcion = Descripcion;
		
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

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}
	
}
