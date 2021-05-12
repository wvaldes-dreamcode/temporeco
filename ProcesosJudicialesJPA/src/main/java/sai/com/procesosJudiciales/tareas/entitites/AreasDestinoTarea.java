package sai.com.procesosJudiciales.tareas.entitites;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the AREAS_DESTINO_TAREA database table.
 * 
 */
@Entity
@Table(name="AREAS_DESTINO_TAREA")
public class AreasDestinoTarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SECUENCIA_AREA_DESTINO", unique=true, nullable=false, precision=22)
	private BigDecimal secuenciaAreaDestino;

	@Column(name="CDGO_AREA_DESTINO", nullable=false, length=2)
	private String cdgoAreaDestino;

	@Column(name="CDGO_CIA_DESTINO", nullable=false, length=2)
	private String cdgoCiaDestino;

	@Column(name="CDGO_USR_RESPONSABLE", length=30)
	private String cdgoUsrResponsable;

	@Column(name="CODIGO_CARGO", nullable=false, precision=22)
	private BigDecimal codigoCargo;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=30)
	private String usuarioModificacion;

	//uni-directional many-to-one association to Tarea
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CODIGO_TAREA", nullable=false)
	private Tarea tarea;

    public AreasDestinoTarea() {
    }

	public BigDecimal getSecuenciaAreaDestino() {
		return this.secuenciaAreaDestino;
	}

	public void setSecuenciaAreaDestino(BigDecimal secuenciaAreaDestino) {
		this.secuenciaAreaDestino = secuenciaAreaDestino;
	}

	public String getCdgoAreaDestino() {
		return this.cdgoAreaDestino;
	}

	public void setCdgoAreaDestino(String cdgoAreaDestino) {
		this.cdgoAreaDestino = cdgoAreaDestino;
	}

	public String getCdgoCiaDestino() {
		return this.cdgoCiaDestino;
	}

	public void setCdgoCiaDestino(String cdgoCiaDestino) {
		this.cdgoCiaDestino = cdgoCiaDestino;
	}

	public String getCdgoUsrResponsable() {
		return this.cdgoUsrResponsable;
	}

	public void setCdgoUsrResponsable(String cdgoUsrResponsable) {
		this.cdgoUsrResponsable = cdgoUsrResponsable;
	}

	public BigDecimal getCodigoCargo() {
		return this.codigoCargo;
	}

	public void setCodigoCargo(BigDecimal codigoCargo) {
		this.codigoCargo = codigoCargo;
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

	public Tarea getTarea() {
		return this.tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}
	
}