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
 * The persistent class for the AREAS_ORIGEN_TAREA database table.
 * 
 */
@Entity
@Table(name="AREAS_ORIGEN_TAREA")
public class AreasOrigenTarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SECUENCIA_AREA_ORIGEN", unique=true, nullable=false, precision=22)
	private BigDecimal secuenciaAreaOrigen;

	@Column(name="CDGO_AREA_ORIGEN", nullable=false, length=2)
	private String cdgoAreaOrigen;

	@Column(name="CDGO_CIA_ORIGEN", nullable=false, length=2)
	private String cdgoCiaOrigen;

	@Column(name="CDGO_USR_SOLICITANTE", length=30)
	private String cdgoUsrSolicitante;

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

    public AreasOrigenTarea() {
    }

	public BigDecimal getSecuenciaAreaOrigen() {
		return this.secuenciaAreaOrigen;
	}

	public void setSecuenciaAreaOrigen(BigDecimal secuenciaAreaOrigen) {
		this.secuenciaAreaOrigen = secuenciaAreaOrigen;
	}

	public String getCdgoAreaOrigen() {
		return this.cdgoAreaOrigen;
	}

	public void setCdgoAreaOrigen(String cdgoAreaOrigen) {
		this.cdgoAreaOrigen = cdgoAreaOrigen;
	}

	public String getCdgoCiaOrigen() {
		return this.cdgoCiaOrigen;
	}

	public void setCdgoCiaOrigen(String cdgoCiaOrigen) {
		this.cdgoCiaOrigen = cdgoCiaOrigen;
	}

	public String getCdgoUsrSolicitante() {
		return this.cdgoUsrSolicitante;
	}

	public void setCdgoUsrSolicitante(String cdgoUsrSolicitante) {
		this.cdgoUsrSolicitante = cdgoUsrSolicitante;
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