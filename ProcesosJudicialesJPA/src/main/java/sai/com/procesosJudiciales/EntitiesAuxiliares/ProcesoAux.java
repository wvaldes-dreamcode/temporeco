package sai.com.procesosJudiciales.EntitiesAuxiliares;

import java.math.BigDecimal;

import sai.com.procesosJudiciales.generales.entities.Juzgado;
import sai.com.procesosJudiciales.procesos.readOnly.Abogado;
import sai.com.procesosJudiciales.procesos.readOnly.DemandantesProceso;
import sai.com.procesosJudiciales.procesos.readOnly.EstadoProceso;
import sai.com.procesosJudiciales.procesos.readOnly.Proceso;
import sai.com.procesosJudiciales.procesos.readOnly.TiposProceso;

public class ProcesoAux {
	
	
	private Abogado abogado;
	
	//private EstadoCesion cesion;
	
	private String coordinador;
	
	private String demandado;
	
	private DemandantesProceso demandante;
	
	private Juzgado despacho;
	
	private EstadoProceso estado;
	
	//private String instancia;
	
	//private String jerarquiaPrimera;
	
	private BigDecimal numeroIdDeudor;
	
	private BigDecimal numeroObligacion;
	
	private BigDecimal numeroProceso;
	
	private String numeroRadicado;
	
	//private BigDecimal paramPretensiones;//??
	
	private BigDecimal seqCoordinador;
	
	//private String pretensiones;
	
	private BigDecimal secuenciaEntidad;

	//private BigDecimal seqInstancia;
	
	private BigDecimal seqSubtipoProceso;
	
	private String subtipoProceso;
	
	private String sucursalObligacion;
	
	private String tipoIdDeudor;
	
	private TiposProceso tiposProceso;
	
	//private String traslado;
	
	private BigDecimal valorPretensiones;
		
	private String marcaAuditado;
	
	private String tipoMarca;
	
	private String diferencia;
	
	private String justificacion;
	
	private BigDecimal numeroAlistamiento;	
	
	private BigDecimal secuenciaDeuda;
	
	
	public BigDecimal getNumeroAlistamiento() {
		return numeroAlistamiento;
	}

	public BigDecimal getSecuenciaDeuda() {
		return secuenciaDeuda;
	}

	public void setSecuenciaDeuda(BigDecimal secuenciaDeuda) {
		this.secuenciaDeuda = secuenciaDeuda;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}
	
	public ProcesoAux(Proceso proceso){
		
		
		/*try {
			
			EntityManager em = EntityManagerImp.getManager();
			
			em.refresh(proceso);
			
			em.close();
			
		} catch (Exception e) {
			System.out.println("error en el constructor ProcesoAux: " + e);
		}*/
		
		
		
		this.abogado = proceso.getAbogado();
		this.coordinador = proceso.getCoordinador();
		this.demandado = proceso.getDemandado();
		this.demandante = proceso.getDemandante();
		this.despacho = proceso.getDespacho();
		this.estado = proceso.getEstado();
		this.numeroIdDeudor = proceso.getNumeroIdDeudor();
		this.numeroObligacion = proceso.getNumeroObligacion();
		this.numeroProceso = proceso.getNumeroProceso();
		this.numeroRadicado = proceso.getNumeroRadicado();
		this.secuenciaEntidad = proceso.getSecuenciaEntidad();
		this.seqCoordinador = proceso.getSeqCoordinador();
		this.seqSubtipoProceso = proceso.getSeqSubtipoProceso();
		this.subtipoProceso = proceso.getSubtipoProceso();
		this.sucursalObligacion = proceso.getSucursalObligacion();
		this.tipoIdDeudor = proceso.getTipoIdDeudor();
		this.tiposProceso = proceso.getTiposProceso();
		this.valorPretensiones = proceso.getValorPretensiones();
		this.marcaAuditado = proceso.getMarcaAuditado();
		this.tipoMarca = proceso.getTipoMarca();
		this.diferencia = proceso.getDiferencia();
		this.justificacion = proceso.getJustificacion();	
		this.numeroAlistamiento = proceso.getNumeroAlistamiento();
		this.secuenciaDeuda = proceso.getSecuenciaDeuda();
	}
	
	
	
	
	/*public ProcesoAux(Abogado abogado, String coordinador, String demandado,
			DemandantesProceso demandante, Juzgado despacho,
			EstadoProceso estado, BigDecimal numeroIdDeudor,
			BigDecimal numeroObligacion, BigDecimal numeroProceso,
			String numeroRadicado, BigDecimal seqCoordinador,
			BigDecimal secuenciaEntidad, BigDecimal seqSubtipoProceso,
			String subtipoProceso, String sucursalObligacion,
			String tipoIdDeudor, TiposProceso tiposProceso,
			BigDecimal valorPretensiones, String marcaAuditado,
			String tipoMarca, String diferencia, String justificacion) {
		super();
		this.abogado = abogado;
		this.coordinador = coordinador;
		this.demandado = demandado;
		this.demandante = demandante;
		this.despacho = despacho;
		this.estado = estado;
		this.numeroIdDeudor = numeroIdDeudor;
		this.numeroObligacion = numeroObligacion;
		this.numeroProceso = numeroProceso;
		this.numeroRadicado = numeroRadicado;
		this.seqCoordinador = seqCoordinador;
		this.secuenciaEntidad = secuenciaEntidad;
		this.seqSubtipoProceso = seqSubtipoProceso;
		this.subtipoProceso = subtipoProceso;
		this.sucursalObligacion = sucursalObligacion;
		this.tipoIdDeudor = tipoIdDeudor;
		this.tiposProceso = tiposProceso;
		this.valorPretensiones = valorPretensiones;
		this.marcaAuditado = marcaAuditado;
		this.tipoMarca = tipoMarca;
		this.diferencia = diferencia;
		this.justificacion = justificacion;
	}*/




	public ProcesoAux() {
		super();
	}




	public Abogado getAbogado() {
		return abogado;
	}

	public void setAbogado(Abogado abogado) {
		this.abogado = abogado;
	}

	public String getCoordinador() {
		return coordinador;
	}

	public void setCoordinador(String coordinador) {
		this.coordinador = coordinador;
	}

	public String getDemandado() {
		return demandado;
	}

	public void setDemandado(String demandado) {
		this.demandado = demandado;
	}

	public DemandantesProceso getDemandante() {
		return demandante;
	}

	public void setDemandante(DemandantesProceso demandante) {
		this.demandante = demandante;
	}

	public Juzgado getDespacho() {
		return despacho;
	}

	public void setDespacho(Juzgado despacho) {
		this.despacho = despacho;
	}

	public EstadoProceso getEstado() {
		return estado;
	}

	public void setEstado(EstadoProceso estado) {
		this.estado = estado;
	}

	public BigDecimal getNumeroIdDeudor() {
		return numeroIdDeudor;
	}

	public void setNumeroIdDeudor(BigDecimal numeroIdDeudor) {
		this.numeroIdDeudor = numeroIdDeudor;
	}

	public BigDecimal getNumeroObligacion() {
		return numeroObligacion;
	}

	public void setNumeroObligacion(BigDecimal numeroObligacion) {
		this.numeroObligacion = numeroObligacion;
	}

	public BigDecimal getNumeroProceso() {
		return numeroProceso;
	}

	public void setNumeroProceso(BigDecimal numeroProceso) {
		this.numeroProceso = numeroProceso;
	}

	public String getNumeroRadicado() {
		return numeroRadicado;
	}

	public void setNumeroRadicado(String numeroRadicado) {
		this.numeroRadicado = numeroRadicado;
	}

	public BigDecimal getSeqCoordinador() {
		return seqCoordinador;
	}

	public void setSeqCoordinador(BigDecimal seqCoordinador) {
		this.seqCoordinador = seqCoordinador;
	}

	public BigDecimal getSecuenciaEntidad() {
		return secuenciaEntidad;
	}

	public void setSecuenciaEntidad(BigDecimal secuenciaEntidad) {
		this.secuenciaEntidad = secuenciaEntidad;
	}

	public BigDecimal getSeqSubtipoProceso() {
		return seqSubtipoProceso;
	}

	public void setSeqSubtipoProceso(BigDecimal seqSubtipoProceso) {
		this.seqSubtipoProceso = seqSubtipoProceso;
	}

	public String getSubtipoProceso() {
		return subtipoProceso;
	}

	public void setSubtipoProceso(String subtipoProceso) {
		this.subtipoProceso = subtipoProceso;
	}

	public String getSucursalObligacion() {
		return sucursalObligacion;
	}

	public void setSucursalObligacion(String sucursalObligacion) {
		this.sucursalObligacion = sucursalObligacion;
	}

	public String getTipoIdDeudor() {
		return tipoIdDeudor;
	}

	public void setTipoIdDeudor(String tipoIdDeudor) {
		this.tipoIdDeudor = tipoIdDeudor;
	}

	public TiposProceso getTiposProceso() {
		return tiposProceso;
	}

	public void setTiposProceso(TiposProceso tiposProceso) {
		this.tiposProceso = tiposProceso;
	}

	public BigDecimal getValorPretensiones() {
		return valorPretensiones;
	}

	public void setValorPretensiones(BigDecimal valorPretensiones) {
		this.valorPretensiones = valorPretensiones;
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

	
	
}
