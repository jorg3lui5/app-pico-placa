package pico.placa.dto;


public class VerificaCirculacionResponseDTO {

	private String mensaje;
    private boolean permiteCircular;
    private AutoResponseDTO autoResponseDTO;
    
	public VerificaCirculacionResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public AutoResponseDTO getAutoResponseDTO() {
		return autoResponseDTO;
	}

	public void setAutoResponseDTO(AutoResponseDTO autoResponseDTO) {
		this.autoResponseDTO = autoResponseDTO;
	}

    public boolean isPermiteCircular() {
		return permiteCircular;
	}

	public void setPermiteCircular(boolean permiteCircular) {
		this.permiteCircular = permiteCircular;
	}
    
}
