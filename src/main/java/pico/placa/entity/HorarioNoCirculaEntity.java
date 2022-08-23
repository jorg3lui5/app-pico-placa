package pico.placa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "horario_no_circula")
public class HorarioNoCirculaEntity implements Serializable {
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "dia", nullable = false)
    private int dia;
    @Column(name = "hora_inicio", nullable = false, length = 5)
    private String horaInicio;
    @Column(name = "hora_fin", nullable = false, length = 5)
    private String horaFin;
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;
    @Column(name = "usuario_creacion", length = 20, nullable = false)
    private String usuarioCreacion;
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;
    @Column(name = "usuario_modificacion", length = 20)
    private String usuarioModificacion;
    @Column(name = "vigencia", nullable = false)
    private boolean vigencia;
    
    
	public HorarioNoCirculaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public boolean isVigencia() {
		return vigencia;
	}
	public void setVigencia(boolean vigencia) {
		this.vigencia = vigencia;
	}

    
    
}
