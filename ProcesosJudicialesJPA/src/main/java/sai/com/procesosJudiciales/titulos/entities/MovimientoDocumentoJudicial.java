package sai.com.procesosJudiciales.titulos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.PrivateOwned;

import sai.com.procesosJudiciales.generales.entities.Juzgado;


/**
 * The persistent class for the MOVIMIENTO_DOCUMENTO_JUDICIAL database table.
 * 
 */
@Entity
@Table(name="MOVIMIENTO_DOCUMENTO_JUDICIAL")
public class MovimientoDocumentoJudicial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOVIMIENTO_DOCUMENTO_JUDICIAL_SECUENCIAMOVIMIENTOJUDICIAL_GENERATOR", sequenceName="SEQ_MVMNTO_DCMNTO_JDCIAL", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOVIMIENTO_DOCUMENTO_JUDICIAL_SECUENCIAMOVIMIENTOJUDICIAL_GENERATOR")
	@Column(name="SECUENCIA_MOVIMIENTO_JUDICIAL", unique=true, nullable=false, precision=15)
	private BigDecimal secuenciaMovimientoJudicial;
	
	@ManyToOne
	@JoinColumn(name="SECUENCIA_ESTADO_DOCUMENTO")
	private EstadoDocumentoJudicial estadoDocumento;
	
    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_EMISION", nullable=false)
	private Date fechaEmision;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_ESTADO", nullable=false)
	private Date fechaEstado;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_PLAZO_REINTEGRO")
	private Date fechaPlazoReintegro;

	@Column(name="NUMERO_ALISTAMIENTO", length=240)
	private String numeroAlistamiento;

	@Column(name="NUMERO_DOCUMENTO", nullable=false, length=20)
	private String numeroDocumento;

	
	@Column(name="NUMERO_PROCESO", length=240)
	private String numeroProceso;
	
	@Column(name="OBSERVACIONES")
	private String observaciones;

	@Column(name="TIPO_PROCESO")
	private String tipoProceso;
	
    @Column(name = "RESPONSABLE_DESCRIPCION")
    private String responsableDescripcion;
	
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}	
	
	@ManyToOne
	@JoinColumn(name="SECUENCIA_DESPACHO")
	private Juzgado despacho;

	@Column(name="SECUENCIA_DEUDA", precision=15)
	private BigDecimal secuenciaDeuda;
	
	@Column(name="NUMERO_OBLIGACION", nullable=false)
	private BigDecimal numeroObligacion;
		
	public BigDecimal getNumeroObligacion() {
		return numeroObligacion;
	}

	public void setNumeroObligacion(BigDecimal numeroObligacion) {
		this.numeroObligacion = numeroObligacion;
	}

	@ManyToOne
	@JoinColumn(name="SECUENCIA_DOCUMENTO_JUDICIAL")
	private DocumentoJudicial documentoJudicial;
	
	//bi-directional many-to-one association to AcuerdoPagoUb
	@OneToMany(mappedBy="movimientoDocumento", cascade = CascadeType.ALL)
	@PrivateOwned
	private List<ConceptoMovimientoJudicial> conceptos ;
	
	//bi-directional many-to-one association to AcuerdoPagoUb
	@OneToMany(mappedBy="movimientoDocumento", cascade= CascadeType.ALL)
	@PrivateOwned
	private List<PeriodoDocumentoJudicial> periodos ;

	@Column(name="ESTADO_DOCUMENTO", nullable=false, precision=3)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="SECUENCIA_RESPONSABLE_DOC")
	private ResponsableDocumento responsableDoc;

	@Column(name="TIPO_IDENTIFICACION_RESP", length=3)
	private String tipoIdentificacionResp;
	
	@Column(name="NUMERO_IDENTIFICACION_RESP", precision=22)
	private BigDecimal numeroIdentificacionResp;
	
	@ManyToOne
	@JoinColumn(name="SECUENCIA_CAUSAL")
	private CausalDevolucion causal;

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(name="VALOR_TOTAL", nullable=false, precision=15)
	private BigDecimal valorTotal;
	 
	
	public MovimientoDocumentoJudicial() {
    }

	public List<ConceptoMovimientoJudicial> getConceptos() {
		return conceptos;
	}
	
	public void setConceptos(List<ConceptoMovimientoJudicial> conceptos) {
		this.conceptos = conceptos;
	}

	public BigDecimal getSecuenciaMovimientoJudicial() {
		return this.secuenciaMovimientoJudicial;
	}

	public void setSecuenciaMovimientoJudicial(BigDecimal secuenciaMovimientoJudicial) {
		this.secuenciaMovimientoJudicial = secuenciaMovimientoJudicial;
	}

		
	public List<PeriodoDocumentoJudicial> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<PeriodoDocumentoJudicial> periodos) {
		this.periodos = periodos;
	}

	public EstadoDocumentoJudicial getEstadoDocumento() {
		return estadoDocumento;
	}

	public void setEstadoDocumento(EstadoDocumentoJudicial estadoDocumento) {
		this.estadoDocumento = estadoDocumento;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEmision() {
		return this.fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaEstado() {
		return this.fechaEstado;
	}

	public void setFechaEstado(Date fechaEstado) {
		this.fechaEstado = fechaEstado;
	}

	public Date getFechaPlazoReintegro() {
		return this.fechaPlazoReintegro;
	}

	public void setFechaPlazoReintegro(Date fechaPlazoReintegro) {
		this.fechaPlazoReintegro = fechaPlazoReintegro;
	}

	public String getNumeroAlistamiento() {
		return this.numeroAlistamiento;
	}

	public void setNumeroAlistamiento(String numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public BigDecimal getNumeroIdentificacionResp() {
		return this.numeroIdentificacionResp;
	}

	public void setNumeroIdentificacionResp(BigDecimal numeroIdentificacionResp) {
		this.numeroIdentificacionResp = numeroIdentificacionResp;
	}

	public String getNumeroProceso() {
		return this.numeroProceso;
	}

	public void setNumeroProceso(String numeroProceso) {
		this.numeroProceso = numeroProceso;
	}
	
	public Juzgado getDespacho() {
		return despacho;
	}

	public void setDespacho(Juzgado despacho) {
		this.despacho = despacho;
	}

	public BigDecimal getSecuenciaDeuda() {
		return this.secuenciaDeuda;
	}

	public void setSecuenciaDeuda(BigDecimal secuenciaDeuda) {
		this.secuenciaDeuda = secuenciaDeuda;
	}
	
	public DocumentoJudicial getDocumentoJudicial() {
		return documentoJudicial;
	}

	public void setDocumentoJudicial(DocumentoJudicial documentoJudicial) {
		this.documentoJudicial = documentoJudicial;
	}

	
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ResponsableDocumento getResponsableDoc() {
		return responsableDoc;
	}

	public void setResponsableDoc(ResponsableDocumento responsableDoc) {
		this.responsableDoc = responsableDoc;
	}

	public String getTipoIdentificacionResp() {
		return this.tipoIdentificacionResp;
	}

	public void setTipoIdentificacionResp(String tipoIdentificacionResp) {
		this.tipoIdentificacionResp = tipoIdentificacionResp;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getTipoProceso() {
		return tipoProceso;
	}

	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
	}

	public String getResponsableDescripcion() {
		return responsableDescripcion;
	}

	public void setResponsableDescripcion(String responsableDescripcion) {
		this.responsableDescripcion = responsableDescripcion;
	}

	public CausalDevolucion getCausal() {
		return causal;
	}

	public void setCausal(CausalDevolucion causal) {
		this.causal = causal;
	}
}