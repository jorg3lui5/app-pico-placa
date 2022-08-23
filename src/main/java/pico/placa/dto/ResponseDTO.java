package pico.placa.dto;

public class ResponseDTO {

    private String estado;
    private String mensaje;
    private Object objeto;
    
    
	public ResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ResponseDTO(String estado, Object objeto) {
		super();
		this.estado = estado;
		this.objeto = objeto;
	}


	public ResponseDTO(String estado, String mensaje) {
		super();
		this.estado = estado;
		this.mensaje = mensaje;
	}


	public ResponseDTO(String estado, String mensaje, Object objeto) {
		super();
		this.estado = estado;
		this.mensaje = mensaje;
		this.objeto = objeto;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public Object getObjeto() {
		return objeto;
	}


	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
	
	

    
}
