package sai.com.procesosJudiciales.auditoria.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the ACTUACIONES_AUDITADAS database table.
 * 
 */
@Entity
@Table(name="ACTUACIONES_AUDITADAS")
public class ActuacionesAuditada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SEQ_ACTCNES_ADTDAS")
	private long seqActcnesAdtdas;

	@Column(name="CODIGO_ACTUACION")
	private BigDecimal codigoActuacion;

	@Column(name="ESTADO_ACTUACION")
	private String estadoActuacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_AUTO")
	private Date fechaAuto;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MOVIMIENTO_ACTUACION")
	private Date fechaMovimientoActuacion;

	@Column(name="NOMBRE_ACTUACION")
	private String nombreActuacion;

	//private Object observacion;

	private String resuelve;

	@Column(name="SECUENCIA_ACT_PROCESO")
	private BigDecimal secuenciaActProceso;

	@Column(name="SECUENCIA_ETAPA_PROCESO")
	private BigDecimal secuenciaEtapaProceso;

	@Column(name="TIPO_NOTIFICACION")
	private String tipoNotificacion;

	private String url;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION")
	private String usuarioModificacion;

	//bi-directional many-to-one association to EtapasAuditada
    @ManyToOne
	@JoinColumn(name="SEQ_ETPAS_AUDTDAS")
	private EtapasAuditada etapasAuditada;

    public ActuacionesAuditada() {
    }

	public long getSeqActcnesAdtdas() {
		return this.seqActcnesAdtdas;
	}

	public void setSeqActcnesAdtdas(long seqActcnesAdtdas) {
		this.seqActcnesAdtdas = seqActcnesAdtdas;
	}

	public BigDecimal getCodigoActuacion() {
		return this.codigoActuacion;
	}

	public void setCodigoActuacion(BigDecimal codigoActuacion) {
		this.codigoActuacion = codigoActuacion;
	}

	public String getEstadoActuacion() {
		return this.estadoActuacion;
	}

	public void setEstadoActuacion(String estadoActuacion) {
		this.estadoActuacion = estadoActuacion;
	}

	public Date getFechaAuto() {
		return this.fechaAuto;
	}

	public void setFechaAuto(Date fechaAuto) {
		this.fechaAuto = fechaAuto;
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

	public Date getFechaMovimientoActuacion() {
		return this.fechaMovimientoActuacion;
	}

	public void setFechaMovimientoActuacion(Date fechaMovimientoActuacion) {
		this.fechaMovimientoActuacion = fechaMovimientoActuacion;
	}

	public String getNombreActuacion() {
		return this.nombreActuacion;
	}

	public void setNombreActuacion(String nombreActuacion) {
		this.nombreActuacion = nombreActuacion;
	}

/*	public Object getObservacion() {
		return this.observacion;
	}

	public void setObservacion(Object observacion) {
		this.observacion = observacion;
	}*/

	public String getResuelve() {
		return this.resuelve;
	}

	public void setResuelve(String resuelve) {
		this.resuelve = resuelve;
	}

	public BigDecimal getSecuenciaActProceso() {
		return this.secuenciaActProceso;
	}

	public void setSecuenciaActProceso(BigDecimal secuenciaActProceso) {
		this.secuenciaActProceso = secuenciaActProceso;
	}

	public BigDecimal getSecuenciaEtapaProceso() {
		return this.secuenciaEtapaProceso;
	}

	public void setSecuenciaEtapaProceso(BigDecimal secuenciaEtapaProceso) {
		this.secuenciaEtapaProceso = secuenciaEtapaProceso;
	}

	public String getTipoNotificacion() {
		return this.tipoNotificacion;
	}

	public void setTipoNotificacion(String tipoNotificacion) {
		this.tipoNotificacion = tipoNotificacion;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public EtapasAuditada getEtapasAuditada() {
		return this.etapasAuditada;
	}

	public void setEtapasAuditada(EtapasAuditada etapasAuditada) {
		this.etapasAuditada = etapasAuditada;
	}
	
}