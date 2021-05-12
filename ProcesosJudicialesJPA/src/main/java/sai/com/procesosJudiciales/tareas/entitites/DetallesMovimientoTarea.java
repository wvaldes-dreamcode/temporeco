package sai.com.procesosJudiciales.tareas.entitites;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import sai.com.procesosJudiciales.generales.readOnly.FuncionariosAreaV;
import sai.com.procesosJudiciales.tareas.readOnly.TipoMovimientoTarea;


/**
 * The persistent class for the DETALLES_MOVIMIENTO_TAREAS database table.
 * 
 */
@Entity
@Table(name="DETALLES_MOVIMIENTO_TAREAS")
@Cacheable(false)
public class DetallesMovimientoTarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="detallesMovimiento_GENERATOR", sequenceName="SEQ_DET_MVTO_TAREA", allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="detallesMovimiento_GENERATOR")
	@Column(name="SECUENCIA_DETALLE_MOVIMIENTO", unique=true, nullable=false, precision=15)
	private long secuenciaDetalleMovimiento;

	@Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MOVIMIENTO", nullable=false)
	private Date fechaMovimiento;

	@Column(length=120)
	private String justificacion;

	@Column(name="NUEVO_USUARIO_RES", length=30)
	private String nuevoUsuarioRes;

	@Column(name="TIEMPO_MOVIMIENTO", nullable=false, precision=22)
	private BigDecimal tiempoMovimiento;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TIPO_MOVIMIENTO")
	private TipoMovimientoTarea tipoMovimiento;

	@Column(name="USUARIO_ANTERIOR", length=30)
	private String usuarioAnterior;

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=30)
	private String usuarioModificacion;

	//bi-directional many-to-one association to MovimientosTarea
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SECUENCIA_MOVIMIENTO_TAREA")
	private MovimientosTarea movimientosTarea;

	@Transient
    private FuncionariosAreaV usuarioResponsableAnterior;
	
	@Transient
    private FuncionariosAreaV usuarioResponsable;
        
    @PostLoad
    @PostPersist
    public void cargarUsuarios(){
    	
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProcesosJudicialesJPA");
    	
    	EntityManager em = emf.createEntityManager();
    	
    	try {
    		
    		if(this.usuarioAnterior != null){
    			
    			Query queryUA = em.createNamedQuery("funcionarioByDocumento");
    			queryUA.setParameter("numId", new BigDecimal(this.usuarioAnterior));
    			usuarioResponsableAnterior = (FuncionariosAreaV) queryUA.getSingleResult();
    		}
    		
    		if(this.nuevoUsuarioRes != null){
    			
    			Query queryUR = em.createNamedQuery("funcionarioByDocumento");
        		queryUR.setParameter("numId", new BigDecimal(this.nuevoUsuarioRes));        		
        		usuarioResponsable = (FuncionariosAreaV) queryUR.getSingleResult();
    		}
			
		} catch (Exception e) {
			
			System.out.println("se presento un error al cargar los usuarioes en detalles movimiento: " + e);
			
		}finally{			
			em.close();
			emf.close();			
		}
    }
   	
    public FuncionariosAreaV getusuarioResponsableAnterior() {
		return usuarioResponsableAnterior;
	}
    
	public void setusuarioResponsableAnterior(FuncionariosAreaV usuarioResponsableAnterior) {
		this.usuarioResponsableAnterior = usuarioResponsableAnterior;
	}
	
	public FuncionariosAreaV getUsuarioResponsable() {
		return usuarioResponsable;
	}
	
	public void setUsuarioResponsable(FuncionariosAreaV usuarioResponsable) {
		this.usuarioResponsable = usuarioResponsable;
	}
	
	
	
    public DetallesMovimientoTarea() {
    }

    public long getSecuenciaDetalleMovimiento() {
		return secuenciaDetalleMovimiento;
	}

	public void setSecuenciaDetalleMovimiento(long secuenciaDetalleMovimiento) {
		this.secuenciaDetalleMovimiento = secuenciaDetalleMovimiento;
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

	public Date getFechaMovimiento() {
		return this.fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public String getJustificacion() {
		return this.justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	public String getNuevoUsuarioRes() {
		return this.nuevoUsuarioRes;
	}

	public void setNuevoUsuarioRes(String nuevoUsuarioRes) {
		this.nuevoUsuarioRes = nuevoUsuarioRes;
	}

	public BigDecimal getTiempoMovimiento() {
		return this.tiempoMovimiento;
	}

	public void setTiempoMovimiento(BigDecimal tiempoMovimiento) {
		this.tiempoMovimiento = tiempoMovimiento;
	}

	public TipoMovimientoTarea getTipoMovimiento() {
		return this.tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimientoTarea tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getUsuarioAnterior() {
		return this.usuarioAnterior;
	}

	public void setUsuarioAnterior(String usuarioAnterior) {
		this.usuarioAnterior = usuarioAnterior;
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

	public MovimientosTarea getMovimientosTarea() {
		return this.movimientosTarea;
	}

	public void setMovimientosTarea(MovimientosTarea movimientosTarea) {
		this.movimientosTarea = movimientosTarea;
	}
	
}