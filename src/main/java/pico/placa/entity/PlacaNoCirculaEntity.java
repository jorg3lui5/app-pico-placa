package pico.placa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "placa_horario_no_circula")
public class PlacaNoCirculaEntity implements Serializable {
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "ultimo_digito_placa", nullable = false)
    private int ultimoDigitoPlaca;    
    @ManyToOne(targetEntity = HorarioNoCirculaEntity.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "id_horario_no_circula", referencedColumnName = "id")}, foreignKey = @ForeignKey(name = "placa_horario_no_circula_fk"))
    private HorarioNoCirculaEntity horarioNoCirculaEntity;
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
    
	public PlacaNoCirculaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getUltimoDigitoPlaca() {
		return ultimoDigitoPlaca;
	}

	public void setUltimoDigitoPlaca(int ultimoDigitoPlaca) {
		this.ultimoDigitoPlaca = ultimoDigitoPlaca;
	}

	public HorarioNoCirculaEntity getHorarioNoCirculaEntity() {
		return horarioNoCirculaEntity;
	}

	public void setHorarioNoCirculaEntity(HorarioNoCirculaEntity horarioNoCirculaEntity) {
		this.horarioNoCirculaEntity = horarioNoCirculaEntity;
	}

	public boolean isVigencia() {
		return vigencia;
	}

	public void setVigencia(boolean vigencia) {
		this.vigencia = vigencia;
	}

    
}
