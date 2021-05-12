package sai.com.procesosJudiciales.auditoria.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the PROCESOS_AUDITADOS database table.
 * 
 */
@Entity
@Table(name="PROCESOS_AUDITADOS")
public class ProcesosAuditado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SEQ_PRCSOS_ADTDOS")
	private long seqPrcsosAdtdos;

	@Column(name="CODIGO_CIUDAD")
	private String codigoCiudad;

	@Column(name="CODIGO_JUZGADO")
	private String codigoJuzgado;

	@Column(name="CODIGO_SUBTIPO_PROCESO")
	private BigDecimal codigoSubtipoProceso;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_INICIO_PROCESO")
	private Date fechaInicioProceso;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="MARCA_PROCESO")
	private String marcaProceso;

	@Column(name="NOMBRE_CIUDAD")
	private String nombreCiudad;

	@Column(name="NOMBRE_JUZGADO")
	private String nombreJuzgado;

	@Column(name="NOMBRE_SUBTIPO_PROCESO")
	private String nombreSubtipoProceso;

	@Column(name="NOMBRE_TIPO_PROCESO")
	private String nombreTipoProceso;

	@Column(name="NUMERO_ID_ABOGADO")
	private BigDecimal numeroIdAbogado;

	@Column(name="NUMERO_ID_COORDINADOR")
	private BigDecimal numeroIdCoordinador;

	@Column(name="NUMERO_ID_DEMANDANTE")
	private BigDecimal numeroIdDemandante;

	@Column(name="NUMERO_PROCESO")
	private BigDecimal numeroProceso;

	@Column(name="NUMERO_RADICADO")
	private String numeroRadicado;

	@Column(name="TIPO_ID_ABOGADO")
	private String tipoIdAbogado;

	@Column(name="TIPO_ID_COORDINADOR")
	private String tipoIdCoordinador;

	@Column(name="TIPO_ID_DEMANDANTE")
	private String tipoIdDemandante;

	@Column(name="TIPO_JUZGADO")
	private String tipoJuzgado;

	@Column(name="TIPO_PROCESO")
	private BigDecimal tipoProceso;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION")
	private String usuarioModificacion;

	//bi-directional many-to-one association to DemandadosAuditado
	@OneToMany(mappedBy="procesosAuditado")
	private Set<DemandadosAuditado> demandadosAuditados;

	//bi-directional many-to-one association to InstanciasAuditada
	@OneToMany(mappedBy="procesosAuditado")
	private Set<InstanciasAuditada> instanciasAuditadas;

    public ProcesosAuditado() {
    }

	public long getSeqPrcsosAdtdos() {
		return this.seqPrcsosAdtdos;
	}

	public void setSeqPrcsosAdtdos(long seqPrcsosAdtdos) {
		this.seqPrcsosAdtdos = seqPrcsosAdtdos;
	}

	public String getCodigoCiudad() {
		return this.codigoCiudad;
	}

	public void setCodigoCiudad(String codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
	}

	public String getCodigoJuzgado() {
		return this.codigoJuzgado;
	}

	public void setCodigoJuzgado(String codigoJuzgado) {
		this.codigoJuzgado = codigoJuzgado;
	}

	public BigDecimal getCodigoSubtipoProceso() {
		return this.codigoSubtipoProceso;
	}

	public void setCodigoSubtipoProceso(BigDecimal codigoSubtipoProceso) {
		this.codigoSubtipoProceso = codigoSubtipoProceso;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaInicioProceso() {
		return this.fechaInicioProceso;
	}

	public void setFechaInicioProceso(Date fechaInicioProceso) {
		this.fechaInicioProceso = fechaInicioProceso;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getMarcaProceso() {
		return this.marcaProceso;
	}

	public void setMarcaProceso(String marcaProceso) {
		this.marcaProceso = marcaProceso;
	}

	public String getNombreCiudad() {
		return this.nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public String getNombreJuzgado() {
		return this.nombreJuzgado;
	}

	public void setNombreJuzgado(String nombreJuzgado) {
		this.nombreJuzgado = nombreJuzgado;
	}

	public String getNombreSubtipoProceso() {
		return this.nombreSubtipoProceso;
	}

	public void setNombreSubtipoProceso(String nombreSubtipoProceso) {
		this.nombreSubtipoProceso = nombreSubtipoProceso;
	}

	public String getNombreTipoProceso() {
		return this.nombreTipoProceso;
	}

	public void setNombreTipoProceso(String nombreTipoProceso) {
		this.nombreTipoProceso = nombreTipoProceso;
	}

	public BigDecimal getNumeroIdAbogado() {
		return this.numeroIdAbogado;
	}

	public void setNumeroIdAbogado(BigDecimal numeroIdAbogado) {
		this.numeroIdAbogado = numeroIdAbogado;
	}

	public BigDecimal getNumeroIdCoordinador() {
		return this.numeroIdCoordinador;
	}

	public void setNumeroIdCoordinador(BigDecimal numeroIdCoordinador) {
		this.numeroIdCoordinador = numeroIdCoordinador;
	}

	public BigDecimal getNumeroIdDemandante() {
		return this.numeroIdDemandante;
	}

	public void setNumeroIdDemandante(BigDecimal numeroIdDemandante) {
		this.numeroIdDemandante = numeroIdDemandante;
	}

	public BigDecimal getNumeroProceso() {
		return this.numeroProceso;
	}

	public void setNumeroProceso(BigDecimal numeroProceso) {
		this.numeroProceso = numeroProceso;
	}

	public String getNumeroRadicado() {
		return this.numeroRadicado;
	}

	public void setNumeroRadicado(String numeroRadicado) {
		this.numeroRadicado = numeroRadicado;
	}

	public String getTipoIdAbogado() {
		return this.tipoIdAbogado;
	}

	public void setTipoIdAbogado(String tipoIdAbogado) {
		this.tipoIdAbogado = tipoIdAbogado;
	}

	public String getTipoIdCoordinador() {
		return this.tipoIdCoordinador;
	}

	public void setTipoIdCoordinador(String tipoIdCoordinador) {
		this.tipoIdCoordinador = tipoIdCoordinador;
	}

	public String getTipoIdDemandante() {
		return this.tipoIdDemandante;
	}

	public void setTipoIdDemandante(String tipoIdDemandante) {
		this.tipoIdDemandante = tipoIdDemandante;
	}

	public String getTipoJuzgado() {
		return this.tipoJuzgado;
	}

	public void setTipoJuzgado(String tipoJuzgado) {
		this.tipoJuzgado = tipoJuzgado;
	}

	public BigDecimal getTipoProceso() {
		return this.tipoProceso;
	}

	public void setTipoProceso(BigDecimal tipoProceso) {
		this.tipoProceso = tipoProceso;
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

	public Set<DemandadosAuditado> getDemandadosAuditados() {
		return this.demandadosAuditados;
	}

	public void setDemandadosAuditados(Set<DemandadosAuditado> demandadosAuditados) {
		this.demandadosAuditados = demandadosAuditados;
	}
	
	public Set<InstanciasAuditada> getInstanciasAuditadas() {
		return this.instanciasAuditadas;
	}

	public void setInstanciasAuditadas(Set<InstanciasAuditada> instanciasAuditadas) {
		this.instanciasAuditadas = instanciasAuditadas;
	}
	
}