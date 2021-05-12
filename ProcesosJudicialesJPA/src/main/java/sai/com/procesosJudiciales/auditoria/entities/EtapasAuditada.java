package sai.com.procesosJudiciales.auditoria.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the ETAPAS_AUDITADAS database table.
 * 
 */
@Entity
@Table(name="ETAPAS_AUDITADAS")
public class EtapasAuditada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SEQ_ETPAS_AUDTDAS")
	private long seqEtpasAudtdas;

	@Column(name="CODIGO_ETAPA")
	private String codigoEtapa;

	@Column(name="ESTADO_ETAPA")
	private String estadoEtapa;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="NOMBRE_ETAPA")
	private String nombreEtapa;

	@Column(name="SECUENCIA_ETAPA_PROCESO")
	private BigDecimal secuenciaEtapaProceso;

	@Column(name="SECUENCIA_INS_PROCESO")
	private BigDecimal secuenciaInsProceso;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION")
	private String usuarioModificacion;

	//bi-directional many-to-one association to ActuacionesAuditada
	@OneToMany(mappedBy="etapasAuditada")
	private Set<ActuacionesAuditada> actuacionesAuditadas;

	//bi-directional many-to-one association to InstanciasAuditada
    @ManyToOne
	@JoinColumn(name="SEQ_INST_AUD")
	private InstanciasAuditada instanciasAuditada;

    public EtapasAuditada() {
    }

	public long getSeqEtpasAudtdas() {
		return this.seqEtpasAudtdas;
	}

	public void setSeqEtpasAudtdas(long seqEtpasAudtdas) {
		this.seqEtpasAudtdas = seqEtpasAudtdas;
	}

	public String getCodigoEtapa() {
		return this.codigoEtapa;
	}

	public void setCodigoEtapa(String codigoEtapa) {
		this.codigoEtapa = codigoEtapa;
	}

	public String getEstadoEtapa() {
		return this.estadoEtapa;
	}

	public void setEstadoEtapa(String estadoEtapa) {
		this.estadoEtapa = estadoEtapa;
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

	public String getNombreEtapa() {
		return this.nombreEtapa;
	}

	public void setNombreEtapa(String nombreEtapa) {
		this.nombreEtapa = nombreEtapa;
	}

	public BigDecimal getSecuenciaEtapaProceso() {
		return this.secuenciaEtapaProceso;
	}

	public void setSecuenciaEtapaProceso(BigDecimal secuenciaEtapaProceso) {
		this.secuenciaEtapaProceso = secuenciaEtapaProceso;
	}

	public BigDecimal getSecuenciaInsProceso() {
		return this.secuenciaInsProceso;
	}

	public void setSecuenciaInsProceso(BigDecimal secuenciaInsProceso) {
		this.secuenciaInsProceso = secuenciaInsProceso;
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

	public Set<ActuacionesAuditada> getActuacionesAuditadas() {
		return this.actuacionesAuditadas;
	}

	public void setActuacionesAuditadas(Set<ActuacionesAuditada> actuacionesAuditadas) {
		this.actuacionesAuditadas = actuacionesAuditadas;
	}
	
	public InstanciasAuditada getInstanciasAuditada() {
		return this.instanciasAuditada;
	}

	public void setInstanciasAuditada(InstanciasAuditada instanciasAuditada) {
		this.instanciasAuditada = instanciasAuditada;
	}
	
}