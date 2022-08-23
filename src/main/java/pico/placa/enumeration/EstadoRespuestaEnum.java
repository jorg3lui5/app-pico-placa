package pico.placa.enumeration;

public enum EstadoRespuestaEnum {
	OK("OK","ESTADO SATISFACTORIO"),
	ERROR("ERROR","ERROR EN EJECUCION");
	
	private String codigo;
	private String descripcion;
	
	
	private EstadoRespuestaEnum(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
