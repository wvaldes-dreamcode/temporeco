package sai.com.procesosJudiciales.procesos.readOnly;

import static org.eclipse.persistence.annotations.ExistenceType.ASSUME_NON_EXISTENCE;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.ExistenceChecking;
import org.eclipse.persistence.annotations.NamedStoredProcedureQueries;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;
import org.eclipse.persistence.annotations.StoredProcedureParameter;

import sai.com.procesosJudiciales.generales.entities.Juzgado;

/**
 * The persistent class for the V_F_PROCESOS database table.
 * 
 */
@Entity
@Table(name = "V_F_PROCESOS")
@NamedStoredProcedureQueries({

	@NamedStoredProcedureQuery(name = "InformacionProceso", procedureName = "PKG_PROCESOS.PRC_MOVIMIENTOS_PROCESOS", returnsResultSet = false, parameters = {
			@StoredProcedureParameter(queryParameter = "P_NUMERO_PROCESO", direction = Direction.IN, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_INSTANCIA", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_ETAPA", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_ACTUACION", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_FECHA_DESDE", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_FECHA_HASTA", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_TIEMPO_TRANSCURRIDO", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_TIEMPO_CONTEMPLADO", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_TAREAS_PENDIENTES", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_NOVEDADES", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_RIESGO_ALTO", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_NOM_INSTANCIA", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_NOM_ETAPA", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_NOM_ACTUACION", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_FECHA_ACTUACION", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_INSTANCIA_VOL", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_ETAPA_VOL", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_ACTUACION_VOL", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_FECHA_ACTUACION_VOL", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_NOM_INSTANCIA_VOL", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_NOM_ETAPA_VOL", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_NOM_ACTUACION_VOL", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_RIESGO_VOL", direction = Direction.OUT, type = String.class) }),

			@NamedStoredProcedureQuery(name = "ModificarProceso", procedureName = "PKG_PROCESOS.PRC_MODIFICACION_PROCESOS", returnsResultSet = false, parameters = 
		{
					@StoredProcedureParameter(queryParameter = "P_NUMERO_PROCESO", direction = Direction.IN, type = String.class),
					@StoredProcedureParameter(queryParameter = "P_ESTADO", direction = Direction.IN, type = String.class),
					@StoredProcedureParameter(queryParameter = "P_RADICADO", direction = Direction.IN, type = String.class),
					@StoredProcedureParameter(queryParameter = "P_VALOR_PRETENSIONES", direction = Direction.IN, type = String.class),
					@StoredProcedureParameter(queryParameter = "P_CESION", direction = Direction.IN, type = String.class),
					@StoredProcedureParameter(queryParameter = "P_SECUENCIA_DESPACHO", direction = Direction.IN, type = String.class),
					@StoredProcedureParameter(queryParameter = "P_SECUENCIA_INSTANCIA", direction = Direction.IN, type = String.class),
					@StoredProcedureParameter(queryParameter = "P_TIPO_ID_DEMANDANTE", direction = Direction.IN, type = String.class),
					@StoredProcedureParameter(queryParameter = "P_NUM_ID_DEMANDANTE", direction = Direction.IN, type = String.class),
					@StoredProcedureParameter(queryParameter = "P_USUARIO_MODIFICA", direction = Direction.IN, type = String.class),
					@StoredProcedureParameter(queryParameter = "P_CAMBIO", direction = Direction.OUT, type = String.class)
		}),
		@NamedStoredProcedureQuery(name = "CandidatosAuditar", procedureName = "Pkg_Auditoria_Procesos.PRC_ACTLZA_PRCSO_CANDIDATO_UNO", returnsResultSet = false, parameters = 
	{
				@StoredProcedureParameter(queryParameter = "P_MENSAJE", direction = Direction.OUT, type = String.class),
				@StoredProcedureParameter(queryParameter = "P_CONTADOR", direction = Direction.OUT, type = Integer.class) 
	}),
	@NamedStoredProcedureQuery(name = "CandidatosRetiro", procedureName = "Pkg_Auditoria_Procesos.PRC_ACTLZA_PRCSO_CNDDTO_RTRO", returnsResultSet = false, parameters = 
{
			@StoredProcedureParameter(queryParameter = "P_MENSAJE", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_CONTADOR", direction = Direction.OUT, type = Integer.class) 
}),		
@NamedStoredProcedureQuery(name = "ModificarMarcaAuditado", procedureName = "Pkg_Auditoria_Procesos.PRC_MOD_MARCA_AUDITADO_PRC", returnsResultSet = false, parameters = 
{
		@StoredProcedureParameter(queryParameter = "P_NUM_PRC", direction = Direction.IN, type = BigDecimal.class),
		@StoredProcedureParameter(queryParameter = "P_MARCA", direction = Direction.IN, type = String.class),
		@StoredProcedureParameter(queryParameter = "P_MENSAJE", direction = Direction.OUT, type = String.class) 
})		

})
@NamedQueries({
	@NamedQuery(name = "ProcesosAuditados", query = "select p from Proceso p where p.marcaAuditado = 'S'"),
	@NamedQuery(name = "ProcesosCandidatosAuditar", query = "select p from Proceso p where p.candidato = 'S'") })
@ExistenceChecking(ASSUME_NON_EXISTENCE)
public class Proceso implements Serializable {
	private static final long serialVersionUID = 1L;

	// bi-directional many-to-one association to Abogado
	@ManyToOne
	@JoinColumn(name = "SEQ_ABOGADO", referencedColumnName = "SEC_ABOGADO", nullable = false)
	private Abogado abogado;

	@ManyToOne
	@JoinColumn(name = "CESION", referencedColumnName = "CODIGO", nullable = false)
	private EstadoCesion cesion;

	@Column(length = 4000)
	private String coordinador;

	@Column(length = 4000)
	private String demandado;

	// bi-directional many-to-one association to Dwemandado
	@OneToMany(mappedBy = "proceso", fetch = FetchType.LAZY)
	private List<Demandado> demandados;

	// bi-directional many-to-one association to DemandantesProceso
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "NUM_ID_DEMANDANTE", referencedColumnName = "NUM_ID_DEMANDANTE", nullable = false),
		@JoinColumn(name = "TIPO_ID_DEMANDANTE", referencedColumnName = "TIPO_ID_DEMANDANTE") })
	private DemandantesProceso demandante;

	// bi-directional many-to-one association to Juzgado
	@ManyToOne
	@JoinColumn(name = "SECUENCIA_DESPACHO", nullable = false)
	private Juzgado despacho;

	// bi-directional many-to-one association to EstadoProceso
	@ManyToOne
	@JoinColumn(name = "ESTADO_PROCESO", referencedColumnName = "SECUENCIA_ESTADO", nullable = false)
	private EstadoProceso estado;

	@Column(nullable = false, length = 200)
	private String instancia;

	// bi-directional many-to-one association to InstanciasProceso
	@OneToMany(mappedBy = "VFProceso", fetch = FetchType.LAZY)
	private List<InstanciasProceso> instancias;

	/*@Column(name = "JERARQUIA_PRIMERA", length = 4000)
	private String jerarquiaPrimera;*/

	@Column(name = "NUMERO_ID_DEUDOR", nullable = false, precision = 15)
	private BigDecimal numeroIdDeudor;

	@Column(name = "NUMERO_OBLIGACION", precision = 20)
	private BigDecimal numeroObligacion;

	@Column(name = "NUMERO_ALISTAMIENTO", precision = 20)
	private BigDecimal numeroAlistamiento;

	@Id
	@Column(name = "NUMERO_PROCESO", precision = 22)
	private BigDecimal numeroProceso;

	@Column(name = "NUMERO_RADICADO", length = 50)
	private String numeroRadicado;

	@Column(name = "PARAM_PRETENSIONES", precision = 22)
	private BigDecimal paramPretensiones;

	@Column(name = "SEQ_COORDINADOR", precision = 22)
	private BigDecimal seqCoordinador;

	@Column(length = 2)
	private String pretensiones;

	@Column(name = "SECUENCIA_ENTIDAD", precision = 20)
	private BigDecimal secuenciaEntidad;
	// SECUENCIA_ENTIDAD

	@Column(name = "SEQ_INSTANCIA", nullable = false, precision = 15)
	private BigDecimal seqInstancia;

	@Column(name = "SEQ_SUBTIPO_PROCESO", nullable = false, precision = 15)
	private BigDecimal seqSubtipoProceso;

	@Column(name = "SUBTIPO_PROCESO", nullable = false, length = 100)
	private String subtipoProceso;

	@Column(name = "SUCURSAL_OBLIGACION", length = 4000)
	private String sucursalObligacion;

	@Column(name = "TIPO_ID_DEUDOR", nullable = false, length = 3)
	private String tipoIdDeudor;

	// bi-directional many-to-one association to TiposProceso
	@ManyToOne
	@JoinColumn(name = "SEQ_TIPO_PROCESO", nullable = false)
	private TiposProceso tiposProceso;

	/*@Column(length = 4000)
	private String traslado;*/

	@Column(name = "VALOR_PRETENSIONES", nullable = false, precision = 20, scale = 5)
	private BigDecimal valorPretensiones;

	@Column(name = "MARCA_AUDITADO", nullable = true, length = 1)
	private String marcaAuditado;

	@Column(name = "TIPO_MARCA", nullable = true, length = 1)
	private String tipoMarca;

	@Column(name = "DIFERENCIA", nullable = true, length = 1)
	private String diferencia;

	@Column(name = "JUSTIFICACION", nullable = true, length = 1)
	private String justificacion;

	@Column(name = "CANDIDATO", nullable = true, length = 1)
	private String candidato;

	@Column(name="SECUENCIA_DEUDA", nullable=false, precision=15)
	private BigDecimal secuenciaDeuda;


	public BigDecimal getSecuenciaDeuda() {
		return secuenciaDeuda;
	}

	public void setSecuenciaDeuda(BigDecimal secuenciaDeuda) {
		this.secuenciaDeuda = secuenciaDeuda;
	}

	public String getCandidato() {
		return candidato;
	}

	public void setCandidato(String candidato) {
		this.candidato = candidato;
	}

	public BigDecimal getSeqCoordinador() {
		return seqCoordinador;
	}

	public void setSeqCoordinador(BigDecimal seqCoordinador) {
		this.seqCoordinador = seqCoordinador;
	}

	public String getMarcaAuditado() {
		return marcaAuditado;
	}

	public void setMarcaAuditado(String marcaAuditado) {
		this.marcaAuditado = marcaAuditado;
	}

	public String getTipoMarca() {
		return tipoMarca;
	}

	public void setTipoMarca(String tipoMarca) {
		this.tipoMarca = tipoMarca;
	}

	public String getDiferencia() {
		return diferencia;
	}

	public void setDiferencia(String diferencia) {
		this.diferencia = diferencia;
	}

	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Proceso() {
	}

	public Abogado getAbogado() {
		return this.abogado;
	}

	public EstadoCesion getCesion() {
		return this.cesion;
	}

	public String getCoordinador() {
		return this.coordinador;
	}

	public String getDemandado() {
		return this.demandado;
	}

	public List<Demandado> getDemandados() {
		return this.demandados;
	}

	public DemandantesProceso getDemandante() {
		return this.demandante;
	}

	public Juzgado getDespacho() {
		return this.despacho;
	}

	public EstadoProceso getEstado() {
		return this.estado;
	}

	public String getInstancia() {
		return this.instancia;
	}

	public List<InstanciasProceso> getInstancias() {
		return this.instancias;
	}

	/*public String getJerarquiaPrimera() {
		return this.jerarquiaPrimera;
	}*/

	public BigDecimal getNumeroIdDeudor() {
		return this.numeroIdDeudor;
	}

	public BigDecimal getNumeroObligacion() {
		return numeroObligacion;
	}

	public BigDecimal getNumeroProceso() {
		return numeroProceso;
	}

	public BigDecimal getNumeroAlistamiento() {
		return numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}

	public String getNumeroRadicado() {
		return this.numeroRadicado;
	}

	public BigDecimal getParamPretensiones() {
		return this.paramPretensiones;
	}

	public String getPretensiones() {
		return this.pretensiones;
	}

	public BigDecimal getSecuenciaEntidad() {
		return secuenciaEntidad;
	}

	public BigDecimal getSeqInstancia() {
		return this.seqInstancia;
	}

	public BigDecimal getSeqSubtipoProceso() {
		return this.seqSubtipoProceso;
	}

	public String getSubtipoProceso() {
		return this.subtipoProceso;
	}

	public String getSucursalObligacion() {
		return this.sucursalObligacion;
	}

	public String getTipoIdDeudor() {
		return this.tipoIdDeudor;
	}

	public TiposProceso getTiposProceso() {
		return this.tiposProceso;
	}

	/*public String getTraslado() {
		return this.traslado;
	}*/

	public BigDecimal getValorPretensiones() {
		return this.valorPretensiones;
	}

	public void setAbogado(Abogado abogado) {
		this.abogado = abogado;
	}

	public void setCesion(EstadoCesion cesion) {
		this.cesion = cesion;
	}

	public void setCoordinador(String coordinador) {
		this.coordinador = coordinador;
	}

	public void setDemandado(String demandado) {
		this.demandado = demandado;
	}

	public void setDemandados(List<Demandado> demandados) {
		this.demandados = demandados;
	}

	public void setDemandante(DemandantesProceso demandante) {
		this.demandante = demandante;
	}

	public void setDespacho(Juzgado despacho) {
		this.despacho = despacho;
	}

	public void setEstado(EstadoProceso estado) {
		this.estado = estado;
	}

	public void setInstancia(String instancia) {
		this.instancia = instancia;
	}

	public void setInstancias(List<InstanciasProceso> instancias) {
		this.instancias = instancias;
	}

	/*public void setJerarquiaPrimera(String jerarquiaPrimera) {
		this.jerarquiaPrimera = jerarquiaPrimera;
	}*/

	public void setNumeroIdDeudor(BigDecimal numeroIdDeudor) {
		this.numeroIdDeudor = numeroIdDeudor;
	}

	public void setNumeroObligacion(BigDecimal numeroObligacion) {
		this.numeroObligacion = numeroObligacion;
	}

	public void setNumeroProceso(BigDecimal numeroProceso) {
		this.numeroProceso = numeroProceso;
	}

	public void setNumeroRadicado(String numeroRadicado) {
		this.numeroRadicado = numeroRadicado;
	}

	public void setParamPretensiones(BigDecimal paramPretensiones) {
		this.paramPretensiones = paramPretensiones;
	}

	public void setPretensiones(String pretensiones) {
		this.pretensiones = pretensiones;
	}

	public void setSecuenciaEntidad(BigDecimal secuenciaEntidad) {
		this.secuenciaEntidad = secuenciaEntidad;
	}

	public void setSeqInstancia(BigDecimal seqInstancia) {
		this.seqInstancia = seqInstancia;
	}

	public void setSeqSubtipoProceso(BigDecimal seqSubtipoProceso) {
		this.seqSubtipoProceso = seqSubtipoProceso;
	}

	public void setSubtipoProceso(String subtipoProceso) {
		this.subtipoProceso = subtipoProceso;
	}

	public void setSucursalObligacion(String sucursalObligacion) {
		this.sucursalObligacion = sucursalObligacion;
	}

	public void setTipoIdDeudor(String tipoIdDeudor) {
		this.tipoIdDeudor = tipoIdDeudor;
	}

	public void setTiposProceso(TiposProceso tiposProceso) {
		this.tiposProceso = tiposProceso;
	}

	/*public void setTraslado(String traslado) {
		this.traslado = traslado;
	}*/

	public void setValorPretensiones(BigDecimal valorPretensiones) {
		this.valorPretensiones = valorPretensiones;
	}

}