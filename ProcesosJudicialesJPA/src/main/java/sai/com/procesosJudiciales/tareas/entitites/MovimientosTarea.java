package sai.com.procesosJudiciales.tareas.entitites;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.NamedStoredProcedureQueries;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;
import org.eclipse.persistence.annotations.StoredProcedureParameter;

import sai.com.procesosJudiciales.alistamientos.entities.EstadosAlistamiento;
import sai.com.procesosJudiciales.alistamientos.entities.TiposAlistamiento;
import sai.com.procesosJudiciales.generales.readOnly.FuncionariosAreaV;
import sai.com.procesosJudiciales.procesos.readOnly.EstadoProceso;
import sai.com.procesosJudiciales.procesos.readOnly.TiposProceso;
import sai.com.procesosJudiciales.tareas.readOnly.EstadosTarea;


/**
 * The persistent class for the MOVIMIENTOS_TAREA database table.
 * 
 */
@Entity
@Table(name="MOVIMIENTOS_TAREA")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "grabarTarea", procedureName = "PKG_F_TAREAS.PRC_GRABAR_TAREA", returnsResultSet = false, parameters = 
	{
			@StoredProcedureParameter(queryParameter = "p_CodigoTarea", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "p_CodigoCia", direction = Direction.IN, type = String.class), 
			@StoredProcedureParameter(queryParameter = "p_UsrAsigna", direction = Direction.IN, type = String.class),
			@StoredProcedureParameter(queryParameter = "p_UsrRespon", direction = Direction.IN, type = String.class),
			@StoredProcedureParameter(queryParameter = "p_NroProceso", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "p_NroAlistamiento", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "p_TiempoEjec", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "p_mensaje", direction = Direction.OUT, type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "EnviarMensajeTarea", procedureName = "PKG_F_TAREAS.PRC_ENVIAR_CORREO_ASIGNACION", returnsResultSet = false, parameters = 
	{
			@StoredProcedureParameter(queryParameter = "p_CodigoTarea", direction = Direction.IN, type = BigDecimal.class),			
			@StoredProcedureParameter(queryParameter = "p_mensaje", direction = Direction.OUT, type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "EnviarMensajeReasignacion", procedureName = "PKG_F_TAREAS.PRC_ENVIAR_CORREO_REASIGNACION", returnsResultSet = false, parameters = 
	{
			@StoredProcedureParameter(queryParameter = "p_CodigoTarea", direction = Direction.IN, type = BigDecimal.class),			
			@StoredProcedureParameter(queryParameter = "p_mensaje", direction = Direction.OUT, type = String.class)
	})
})
@Cacheable(false)
public class MovimientosTarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SECUENCIA_MOVIMIENTO_TAREA", unique=true, nullable=false, precision=15)
	private BigDecimal secuenciaMovimientoTarea;

	@Column(name="ACO_CDGO_AREA", nullable=false, length=2)
	private String acoCdgoArea;

	@Column(name="CIA_CDGO", nullable=false, length=2)
	private String ciaCdgo;

	/*@Column(name="ESTADO_ALISTAMIENTO_CREACION", length=5)
	private String estadoAlistamientoCreacion;*/
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ESTADO_ALISTAMIENTO_CREACION", referencedColumnName = "ABREVIACION")
	private EstadosAlistamiento estadoAlistamientoCreacion;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ESTADO_PROCESO_CREACION")
	private EstadoProceso estadoProcesoCreacion;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ESTADO_TAREA")
	private EstadosTarea estado;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CONTESTACION")
	private Date fechaContestacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_ENVIO_CORREO")
	private Date fechaEnvioCorreo;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_ENVIO_CORREO_ALERTA")
	private Date fechaEnvioCorreoAlerta;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_ENVIO_CORREO_ESCALMTO")
	private Date fechaEnvioCorreoEscalmto;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_TAREA", nullable=false)
	private Date fechaTarea;

	@Column(name="NUMERO_ALISTAMIENTO", precision=15)
	private BigDecimal numeroAlistamiento;

	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NUMERO_ALISTAMIENTO")
	private AlistamientosObligacionV alistamiento;*/
	
	@Column(name="NUMERO_PROCESO", precision=15)
	private BigDecimal numeroProceso;
	
	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NUMERO_PROCESO")
	private Proceso proceso;*/

	@Column(name="OBSERVACION_CONTESTACION", length=120)
	private String observacionContestacion;

	@Column(name="SECUENCIA_DEUDA", nullable=false, precision=15)
	private BigDecimal secuenciaDeuda;

	@Column(name="TIEMPO_EJECUCION", nullable=false, precision=22)
	private BigDecimal tiempoEjecucion;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TIPO_ALISTAMIENTO_CREACION", referencedColumnName="ABREVIACION")
	private TiposAlistamiento tipoAlistamientoCreacion;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TIPO_PROCESO_CREACION", referencedColumnName="ABREVIACION")	
	private TiposProceso tipoProcesoCreacion;

	@Column(name="USR_CDGO_USRIO", nullable=false, length=30)
	private String usrCdgoUsrio;

	@Column(name="USR_CDGO_USRIO_RES", nullable=false, length=30)
	private String usrCdgoUsrioRes;

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=30)
	private String usuarioModificacion;

	//bi-directional many-to-one association to DetallesMovimientoTarea
	@OneToMany(mappedBy="movimientosTarea")
	private List<DetallesMovimientoTarea> detallesMovimientoTareas;

	//uni-directional many-to-one association to Tarea
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CODIGO_TAREA", nullable=false)
	private Tarea tarea;

	@Transient
    private FuncionariosAreaV usuarioAsigna;
	
	@Transient
    private FuncionariosAreaV usuarioResponsable;
        
    @PostLoad
    @PostPersist
    public void cargarUsuarios(){
    	
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProcesosJudicialesJPA");
    	
    	EntityManager em = emf.createEntityManager();
    	
    	try {
    		Query queryUA = em.createNamedQuery("funcionarioByDocumento");
    		queryUA.setParameter("numId", new BigDecimal(this.usrCdgoUsrio));
    		
    		Query queryUR = em.createNamedQuery("funcionarioByDocumento");
    		queryUR.setParameter("numId", new BigDecimal(this.usrCdgoUsrioRes));
    		
    		usuarioAsigna = (FuncionariosAreaV) queryUA.getSingleResult();
    		usuarioResponsable = (FuncionariosAreaV) queryUR.getSingleResult();
    		
			
		}catch (NullPointerException e) {
			System.out.println("hay un error en cargar usuarios: " + e); 
		} 
    	catch (Exception e) {
			
			System.out.println("se presento un error al cargar el usuario: " + e);
			
		}finally{			
			em.close();
			emf.close();			
		}
    }
   	
    public FuncionariosAreaV getUsuarioAsigna() {
		return usuarioAsigna;
	}
    
	public void setUsuarioAsigna(FuncionariosAreaV usuarioAsigna) {
		this.usuarioAsigna = usuarioAsigna;
	}
	
	public FuncionariosAreaV getUsuarioResponsable() {
		return usuarioResponsable;
	}
	
	public void setUsuarioResponsable(FuncionariosAreaV usuarioResponsable) {
		this.usuarioResponsable = usuarioResponsable;
	}

	public MovimientosTarea() {
    }

	public BigDecimal getSecuenciaMovimientoTarea() {
		return this.secuenciaMovimientoTarea;
	}

	public void setSecuenciaMovimientoTarea(BigDecimal secuenciaMovimientoTarea) {
		this.secuenciaMovimientoTarea = secuenciaMovimientoTarea;
	}

	public String getAcoCdgoArea() {
		return this.acoCdgoArea;
	}

	public void setAcoCdgoArea(String acoCdgoArea) {
		this.acoCdgoArea = acoCdgoArea;
	}

	public String getCiaCdgo() {
		return this.ciaCdgo;
	}

	public void setCiaCdgo(String ciaCdgo) {
		this.ciaCdgo = ciaCdgo;
	}

	/*public String getEstadoAlistamientoCreacion() {
		return this.estadoAlistamientoCreacion;
	}

	public void setEstadoAlistamientoCreacion(String estadoAlistamientoCreacion) {
		this.estadoAlistamientoCreacion = estadoAlistamientoCreacion;
	}*/
	
	

	/*public String getEstadoProcesoCreacion() {
		return this.estadoProcesoCreacion;
	}*/

	
	
	public EstadosAlistamiento getEstadoAlistamientoCreacion() {
		return estadoAlistamientoCreacion;
	}

	public EstadoProceso getEstadoProcesoCreacion() {
		return estadoProcesoCreacion;
	}

	public void setEstadoProcesoCreacion(EstadoProceso estadoProcesoCreacion) {
		this.estadoProcesoCreacion = estadoProcesoCreacion;
	}

	public void setEstadoAlistamientoCreacion(
			EstadosAlistamiento estadoAlistamientoCreacion) {
		this.estadoAlistamientoCreacion = estadoAlistamientoCreacion;
	}

	/*public void setEstadoProcesoCreacion(String estadoProcesoCreacion) {
		this.estadoProcesoCreacion = estadoProcesoCreacion;
	}*/

	 
	public EstadosTarea getEstado() {
		return estado;
	}

	public void setEstado(EstadosTarea estado) {
		this.estado = estado;
	}

	public Date getFechaContestacion() {
		return this.fechaContestacion;
	}

	public void setFechaContestacion(Date fechaContestacion) {
		this.fechaContestacion = fechaContestacion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEnvioCorreo() {
		return this.fechaEnvioCorreo;
	}

	public void setFechaEnvioCorreo(Date fechaEnvioCorreo) {
		this.fechaEnvioCorreo = fechaEnvioCorreo;
	}

	public Date getFechaEnvioCorreoAlerta() {
		return this.fechaEnvioCorreoAlerta;
	}

	public void setFechaEnvioCorreoAlerta(Date fechaEnvioCorreoAlerta) {
		this.fechaEnvioCorreoAlerta = fechaEnvioCorreoAlerta;
	}

	public Date getFechaEnvioCorreoEscalmto() {
		return this.fechaEnvioCorreoEscalmto;
	}

	public void setFechaEnvioCorreoEscalmto(Date fechaEnvioCorreoEscalmto) {
		this.fechaEnvioCorreoEscalmto = fechaEnvioCorreoEscalmto;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaTarea() {
		return this.fechaTarea;
	}

	public void setFechaTarea(Date fechaTarea) {
		this.fechaTarea = fechaTarea;
	}

	public BigDecimal getNumeroAlistamiento() {
		return this.numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}
	
	public BigDecimal getNumeroProceso() {
		return this.numeroProceso;
	}

	public void setNumeroProceso(BigDecimal numeroProceso) {
		this.numeroProceso = numeroProceso;
	}

	public String getObservacionContestacion() {
		return this.observacionContestacion;
	}

	/*public AlistamientosObligacionV getAlistamiento() {
		return alistamiento;
	}

	public void setAlistamiento(AlistamientosObligacionV alistamiento) {
		this.alistamiento = alistamiento;
	}

	public Proceso getProceso() {
		return proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}*/

	public void setObservacionContestacion(String observacionContestacion) {
		this.observacionContestacion = observacionContestacion;
	}

	public BigDecimal getSecuenciaDeuda() {
		return this.secuenciaDeuda;
	}

	public void setSecuenciaDeuda(BigDecimal secuenciaDeuda) {
		this.secuenciaDeuda = secuenciaDeuda;
	}

	public BigDecimal getTiempoEjecucion() {
		return this.tiempoEjecucion;
	}

	public void setTiempoEjecucion(BigDecimal tiempoEjecucion) {
		this.tiempoEjecucion = tiempoEjecucion;
	}
	
	public TiposAlistamiento getTipoAlistamientoCreacion() {
		return tipoAlistamientoCreacion;
	}

	public TiposProceso getTipoProcesoCreacion() {
		return tipoProcesoCreacion;
	}

	public void setTipoProcesoCreacion(TiposProceso tipoProcesoCreacion) {
		this.tipoProcesoCreacion = tipoProcesoCreacion;
	}

	public void setTipoAlistamientoCreacion(
			TiposAlistamiento tipoAlistamientoCreacion) {
		this.tipoAlistamientoCreacion = tipoAlistamientoCreacion;
	}

	/*public void setTipoProcesoCreacion(String tipoProcesoCreacion) {
		this.tipoProcesoCreacion = tipoProcesoCreacion;
	}*/

	public String getUsrCdgoUsrio() {
		return this.usrCdgoUsrio;
	}

	public void setUsrCdgoUsrio(String usrCdgoUsrio) {
		this.usrCdgoUsrio = usrCdgoUsrio;
	}

	public String getUsrCdgoUsrioRes() {
		return this.usrCdgoUsrioRes;
	}

	public void setUsrCdgoUsrioRes(String usrCdgoUsrioRes) {
		this.usrCdgoUsrioRes = usrCdgoUsrioRes;
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

	public List<DetallesMovimientoTarea> getDetallesMovimientoTareas() {
		return this.detallesMovimientoTareas;
	}

	public void setDetallesMovimientoTareas(List<DetallesMovimientoTarea> detallesMovimientoTareas) {
		this.detallesMovimientoTareas = detallesMovimientoTareas;
	}
	
	public Tarea getTarea() {
		return this.tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}
	
}