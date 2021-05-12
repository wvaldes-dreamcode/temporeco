package sai.com.procesosJudiciales.tareas.entitites;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the TAREAS database table.
 * 
 */
@Entity
@Table(name="TAREAS")
public class Tarea implements Serializable,Comparable<Tarea> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODIGO_TAREA", unique=true, nullable=false, precision=20)
	private BigDecimal codigoTarea;

	@Column(name="DESCRIPCION_TAREA", nullable=false, length=120)
	private String descripcionTarea;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="GENERA_ALERTA", nullable=false, length=10)
	private String generaAlerta;

	@Column(name="GENERA_ESCALAMIENTO", nullable=false, length=10)
	private String generaEscalamiento;

	@Column(name="TIEMPO_ALERTA", precision=10)
	private BigDecimal tiempoAlerta;

	@Column(name="TIEMPO_ESCALAMIENTO", precision=20)
	private BigDecimal tiempoEscalamiento;

	@Column(name="TIPO_ALERTA", length=120)
	private String tipoAlerta;

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=30)
	private String usuarioModificacion;

    public Tarea() {
    }

	public BigDecimal getCodigoTarea() {
		return this.codigoTarea;
	}

	public void setCodigoTarea(BigDecimal codigoTarea) {
		this.codigoTarea = codigoTarea;
	}

	public String getDescripcionTarea() {
		return this.descripcionTarea;
	}

	public void setDescripcionTarea(String descripcionTarea) {
		this.descripcionTarea = descripcionTarea;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getGeneraAlerta() {
		return this.generaAlerta;
	}

	public void setGeneraAlerta(String generaAlerta) {
		this.generaAlerta = generaAlerta;
	}

	public String getGeneraEscalamiento() {
		return this.generaEscalamiento;
	}

	public void setGeneraEscalamiento(String generaEscalamiento) {
		this.generaEscalamiento = generaEscalamiento;
	}

	public BigDecimal getTiempoAlerta() {
		return this.tiempoAlerta;
	}

	public void setTiempoAlerta(BigDecimal tiempoAlerta) {
		this.tiempoAlerta = tiempoAlerta;
	}

	public BigDecimal getTiempoEscalamiento() {
		return this.tiempoEscalamiento;
	}

	public void setTiempoEscalamiento(BigDecimal tiempoEscalamiento) {
		this.tiempoEscalamiento = tiempoEscalamiento;
	}

	public String getTipoAlerta() {
		return this.tipoAlerta;
	}

	public void setTipoAlerta(String tipoAlerta) {
		this.tipoAlerta = tipoAlerta;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
	
	@Override
	public int compareTo(Tarea o) {
				
		return this.descripcionTarea.compareTo(o.descripcionTarea);
	}

}