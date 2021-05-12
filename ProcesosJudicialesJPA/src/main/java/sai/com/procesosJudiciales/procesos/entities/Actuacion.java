package sai.com.procesosJudiciales.procesos.entities;

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
 * The persistent class for the ACTUACIONES database table.
 * 
 */
@Entity
@Table(name="ACTUACIONES")
public class Actuacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SECUENCIA_ACTUACION", unique=true, nullable=false, precision=15)
	private BigDecimal secuenciaActuacion;

	@Column(name="CODIGO_AUDITORIA", precision=22)
	private BigDecimal codigoAuditoria;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="MARCA_ACTIVIDAD", length=3)
	private String marcaActividad;

	@Column(name="NOMBRE_ACTUACION", nullable=false, length=200)
	private String nombreActuacion;

	@Column(name="TIPO_ACTUACION", nullable=false, length=120)
	private String tipoActuacion;

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=30)
	private String usuarioModificacion;

	//bi-directional many-to-one association to AtuacionesProceso
	/*@OneToMany(mappedBy="actuacione")
	private List<AtuacionesProceso> VFAtuacionesProcesos;*/

    public Actuacion() {
    }

	public BigDecimal getSecuenciaActuacion() {
		return this.secuenciaActuacion;
	}

	public void setSecuenciaActuacion(BigDecimal secuenciaActuacion) {
		this.secuenciaActuacion = secuenciaActuacion;
	}

	public BigDecimal getCodigoAuditoria() {
		return this.codigoAuditoria;
	}

	public void setCodigoAuditoria(BigDecimal codigoAuditoria) {
		this.codigoAuditoria = codigoAuditoria;
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

	public String getMarcaActividad() {
		return this.marcaActividad;
	}

	public void setMarcaActividad(String marcaActividad) {
		this.marcaActividad = marcaActividad;
	}

	public String getNombreActuacion() {
		return this.nombreActuacion;
	}

	public void setNombreActuacion(String nombreActuacion) {
		this.nombreActuacion = nombreActuacion;
	}

	public String getTipoActuacion() {
		return this.tipoActuacion;
	}

	public void setTipoActuacion(String tipoActuacion) {
		this.tipoActuacion = tipoActuacion;
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

	/*public List<AtuacionesProceso> getVFAtuacionesProcesos() {
		return this.VFAtuacionesProcesos;
	}

	public void setVFAtuacionesProcesos(List<AtuacionesProceso> VFAtuacionesProcesos) {
		this.VFAtuacionesProcesos = VFAtuacionesProcesos;
	}*/
	
}