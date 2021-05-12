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

import sai.com.procesosJudiciales.generales.entities.Juzgado;


/**
 * The persistent class for the INSTANCIAS_AUDITADAS database table.
 * 
 */
@Entity
@Table(name="V_F_INSTANCIAS_AUDITADAS")
public class InstanciasAuditada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SEQ_INST_AUD")
	private long seqInstAud;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_FIN_INSTANCIA")
	private Date fechaFinInstancia;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_INICIO_INSTANCIA")
	private Date fechaInicioInstancia;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="NUMERO_PROCESO")
	private BigDecimal numeroProceso;

	@Column(name="NUMERO_RADICACION")
	private String numeroRadicacion;
	
	@ManyToOne
	@JoinColumn(name="SECUENCIA_DESPACHO")
	private Juzgado despacho;

	public Juzgado getDespacho() {
		return despacho;
	}

	public void setDespacho(Juzgado despacho) {
		this.despacho = despacho;
	}

	@Column(name="SECUENCIA_INS_PROCESO")
	private BigDecimal secuenciaInsProceso;
	
	
	@Column(name="SECUENCIA_INSTANCIA")
	private BigDecimal instanciaProceso;
	
	@Column(name="NOMBRE_INSTANCIA")
	private String nombreInstancia;
	
	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	

	@Column(name="USUARIO_MODIFICACION")
	private String usuarioModificacion;

	//bi-directional many-to-one association to EtapasAuditada
	@OneToMany(mappedBy="instanciasAuditada")
	private Set<EtapasAuditada> etapasAuditadas;

	//bi-directional many-to-one association to ProcesosAuditado
    @ManyToOne
	@JoinColumn(name="SEQ_PRCSOS_ADTDOS")
	private ProcesosAuditado procesosAuditado;

    public InstanciasAuditada() {
    }

	public long getSeqInstAud() {
		return this.seqInstAud;
	}

	public void setSeqInstAud(long seqInstAud) {
		this.seqInstAud = seqInstAud;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaFinInstancia() {
		return this.fechaFinInstancia;
	}

	public void setFechaFinInstancia(Date fechaFinInstancia) {
		this.fechaFinInstancia = fechaFinInstancia;
	}

	public Date getFechaInicioInstancia() {
		return this.fechaInicioInstancia;
	}

	public void setFechaInicioInstancia(Date fechaInicioInstancia) {
		this.fechaInicioInstancia = fechaInicioInstancia;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public BigDecimal getNumeroProceso() {
		return this.numeroProceso;
	}

	public void setNumeroProceso(BigDecimal numeroProceso) {
		this.numeroProceso = numeroProceso;
	}

	public String getNumeroRadicacion() {
		return this.numeroRadicacion;
	}

	public void setNumeroRadicacion(String numeroRadicacion) {
		this.numeroRadicacion = numeroRadicacion;
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

	public Set<EtapasAuditada> getEtapasAuditadas() {
		return this.etapasAuditadas;
	}

	public void setEtapasAuditadas(Set<EtapasAuditada> etapasAuditadas) {
		this.etapasAuditadas = etapasAuditadas;
	}
	
	public ProcesosAuditado getProcesosAuditado() {
		return this.procesosAuditado;
	}

	public void setProcesosAuditado(ProcesosAuditado procesosAuditado) {
		this.procesosAuditado = procesosAuditado;
	}

	public BigDecimal getInstanciaProceso() {
		return instanciaProceso;
	}

	public void setInstanciaProceso(BigDecimal instanciaProceso) {
		this.instanciaProceso = instanciaProceso;
	}

	public String getNombreInstancia() {
		return nombreInstancia;
	}

	public void setNombreInstancia(String nombreInstancia) {
		this.nombreInstancia = nombreInstancia;
	}
	
}