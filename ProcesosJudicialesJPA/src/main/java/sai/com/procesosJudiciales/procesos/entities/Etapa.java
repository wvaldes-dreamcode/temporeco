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
 * The persistent class for the ETAPAS database table.
 * 
 */
@Entity
@Table(name="ETAPAS")
public class Etapa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SECUENCIA_ETAPA", unique=true, nullable=false, precision=15)
	private BigDecimal secuenciaEtapa;

	@Column(name="CODIGO_ETAPA", precision=22)
	private BigDecimal codigoEtapa;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="MARCA_NOTIFICACION", length=2)
	private String marcaNotificacion;

	@Column(name="NOMBRE_ETAPA", nullable=false, length=200)
	private String nombreEtapa;

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=30)
	private String usuarioModificacion;

	//bi-directional many-to-one association to EtapasProceso
	/*@OneToMany(mappedBy="etapa")
	private List<EtapasProceso> VFEtapasProcesos;*/

    public Etapa() {
    }

	public BigDecimal getSecuenciaEtapa() {
		return this.secuenciaEtapa;
	}

	public void setSecuenciaEtapa(BigDecimal secuenciaEtapa) {
		this.secuenciaEtapa = secuenciaEtapa;
	}

	public BigDecimal getCodigoEtapa() {
		return this.codigoEtapa;
	}

	public void setCodigoEtapa(BigDecimal codigoEtapa) {
		this.codigoEtapa = codigoEtapa;
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

	public String getMarcaNotificacion() {
		return this.marcaNotificacion;
	}

	public void setMarcaNotificacion(String marcaNotificacion) {
		this.marcaNotificacion = marcaNotificacion;
	}

	public String getNombreEtapa() {
		return this.nombreEtapa;
	}

	public void setNombreEtapa(String nombreEtapa) {
		this.nombreEtapa = nombreEtapa;
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
/*
	public List<EtapasProceso> getVFEtapasProcesos() {
		return this.VFEtapasProcesos;
	}

	public void setVFEtapasProcesos(List<EtapasProceso> VFEtapasProcesos) {
		this.VFEtapasProcesos = VFEtapasProcesos;
	}
	*/
}