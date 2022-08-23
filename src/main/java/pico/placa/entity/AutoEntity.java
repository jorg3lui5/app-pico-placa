package pico.placa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "auto")
public class AutoEntity implements Serializable {
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "placa", nullable = false, length = 7, unique = true)
    private String placa;
    @Column(name = "color", nullable = false, length = 20)
    private String color;
    @Column(name = "modelo", nullable = false, length = 40)
    private String modelo;
    @Column(name = "chasis", nullable = false, length = 20)
    private String chasis;
    @Column(name = "otra_informacion", nullable = true, length = 100)
    private String otraInformacion;
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
    
    
    
	public AutoEntity() {
		super();
	}
	
	
	public AutoEntity(long id, String placa, String color, String modelo, String chasis, String otraInformacion,
			LocalDateTime fechaCreacion, String usuarioCreacion, LocalDateTime fechaModificacion,
			String usuarioModificacion, boolean vigencia) {
		super();
		this.id = id;
		this.placa = placa;
		this.color = color;
		this.modelo = modelo;
		this.chasis = chasis;
		this.otraInformacion = otraInformacion;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
		this.vigencia = vigencia;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getChasis() {
		return chasis;
	}
	public void setChasis(String chasis) {
		this.chasis = chasis;
	}
	public String getOtraInformacion() {
		return otraInformacion;
	}
	public void setOtraInformacion(String otraInformacion) {
		this.otraInformacion = otraInformacion;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
	public boolean isVigencia() {
		return vigencia;
	}
	public void setVigencia(boolean vigencia) {
		this.vigencia = vigencia;
	}

    
    
}
