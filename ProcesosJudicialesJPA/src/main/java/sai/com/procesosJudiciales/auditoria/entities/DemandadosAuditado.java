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
 * The persistent class for the DEMANDADOS_AUDITADOS database table.
 * 
 */
@Entity
@Table(name="DEMANDADOS_AUDITADOS")
public class DemandadosAuditado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SEQ_DMNDDOS_AUDTDOS")
	private long seqDmnddosAudtdos;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="NUMERO_ID_DEMANDADOS")
	private BigDecimal numeroIdDemandados;

	@Column(name="PRIMER_APELLIDO")
	private String primerApellido;

	@Column(name="PRIMER_NOMBRE")
	private String primerNombre;

	@Column(name="SECUENCIA_DEMANDADO")
	private BigDecimal secuenciaDemandado;

	@Column(name="SEGUNDO_APELLIDO")
	private String segundoApellido;

	@Column(name="SEGUNDO_NOMBRE")
	private String segundoNombre;

	@Column(name="TIPO_DEMANDADO")
	private String tipoDemandado;

	@Column(name="TIPO_ID_DEMANDADOS")
	private String tipoIdDemandados;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION")
	private String usuarioModificacion;

	//bi-directional many-to-one association to ProcesosAuditado
    @ManyToOne
	@JoinColumn(name="SEQ_PRCSOS_ADTDOS")
	private ProcesosAuditado procesosAuditado;

    public DemandadosAuditado() {
    }

	public long getSeqDmnddosAudtdos() {
		return this.seqDmnddosAudtdos;
	}

	public void setSeqDmnddosAudtdos(long seqDmnddosAudtdos) {
		this.seqDmnddosAudtdos = seqDmnddosAudtdos;
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

	public BigDecimal getNumeroIdDemandados() {
		return this.numeroIdDemandados;
	}

	public void setNumeroIdDemandados(BigDecimal numeroIdDemandados) {
		this.numeroIdDemandados = numeroIdDemandados;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public BigDecimal getSecuenciaDemandado() {
		return this.secuenciaDemandado;
	}

	public void setSecuenciaDemandado(BigDecimal secuenciaDemandado) {
		this.secuenciaDemandado = secuenciaDemandado;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getTipoDemandado() {
		return this.tipoDemandado;
	}

	public void setTipoDemandado(String tipoDemandado) {
		this.tipoDemandado = tipoDemandado;
	}

	public String getTipoIdDemandados() {
		return this.tipoIdDemandados;
	}

	public void setTipoIdDemandados(String tipoIdDemandados) {
		this.tipoIdDemandados = tipoIdDemandados;
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

	public ProcesosAuditado getProcesosAuditado() {
		return this.procesosAuditado;
	}

	public void setProcesosAuditado(ProcesosAuditado procesosAuditado) {
		this.procesosAuditado = procesosAuditado;
	}
	
}