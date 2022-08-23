package pico.placa.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VerificaCirculacionRequestDTO {
    private String placa;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private Date fechaHora;
    
	public VerificaCirculacionRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
    
    
}
