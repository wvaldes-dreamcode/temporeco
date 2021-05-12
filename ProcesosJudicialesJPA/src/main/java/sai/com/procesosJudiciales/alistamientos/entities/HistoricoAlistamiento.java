package sai.com.procesosJudiciales.alistamientos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Persistence;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import sai.com.procesosJudiciales.generales.readOnly.FuncionariosAreaV;


/**
 * The persistent class for the HISTORICO_ALISTAMIENTO database table.
 * 
 */
@Entity
@Table(name="HISTORICO_ALISTAMIENTO")
public class HistoricoAlistamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SECUENCIA_HIS_ALISTAMIENTO")
	private BigDecimal secuenciaHisAlistamiento;

	private String accion;

	@Column(name="CAUSAL_DEL_CAMBIO")
	private String causalDelCambio;

	@JoinColumn(name="CODIGO_ALISTAMIENTO", referencedColumnName="CODIGO_ALISTAMIENTO")
	private TiposAlistamiento tipoAlistamiento;

	@JoinColumn(name="CODIGO_ESTADO_ALISTAMIENTO", referencedColumnName="CODIGO_ESTADO_ALISTAMIENTO")
	private EstadosAlistamiento estadoAlistamiento;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_ACCION")
	private Date fechaAccion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_ESTADO_ALISTAMIENTO")
	private Date fechaEstadoAlistamiento;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="NUMERO_ALISTAMIENTO")
	private BigDecimal numeroAlistamiento;

	@Column(name="NUMERO_ID_PODERDANTE")
	private BigDecimal numeroIdPoderdante;

	@Column(name="TIPO_ID_PODERDANTE")
	private String tipoIdPoderdante;

	@Column(name="USUARIO_ACCION")
	private String usuarioAccion;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION")
	private String usuarioModificacion;
	
	@Transient
    private FuncionariosAreaV usuario;
	

    public HistoricoAlistamiento() {
    }
    
    @PostLoad
    @PostPersist
    public void cargarUsuarios(){
    	
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProcesosJudicialesJPA");
    	
    	EntityManager em = emf.createEntityManager();
    	
    	try {
    		Query queryUA = em.createNamedQuery("funcionarioByDocumento");
    		queryUA.setParameter("numId", new BigDecimal(this.usuarioAccion));    		    		    		
    		usuario = (FuncionariosAreaV) queryUA.getSingleResult();
			
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

	public FuncionariosAreaV getUsuario() {
		return usuario;
	}



	public void setUsuario(FuncionariosAreaV usuario) {
		this.usuario = usuario;
	}



	public BigDecimal getSecuenciaHisAlistamiento() {
		return this.secuenciaHisAlistamiento;
	}

	public void setSecuenciaHisAlistamiento(BigDecimal secuenciaHisAlistamiento) {
		this.secuenciaHisAlistamiento = secuenciaHisAlistamiento;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getCausalDelCambio() {
		return this.causalDelCambio;
	}

	public void setCausalDelCambio(String causalDelCambio) {
		this.causalDelCambio = causalDelCambio;
	}

	public TiposAlistamiento getTipoAlistamiento() {
		return tipoAlistamiento;
	}

	public void setTipoAlistamiento(TiposAlistamiento tipoAlistamiento) {
		this.tipoAlistamiento = tipoAlistamiento;
	}

	public EstadosAlistamiento getEstadoAlistamiento() {
		return estadoAlistamiento;
	}

	public void setEstadoAlistamiento(EstadosAlistamiento estadoAlistamiento) {
		this.estadoAlistamiento = estadoAlistamiento;
	}

	public Date getFechaAccion() {
		return this.fechaAccion;
	}

	public void setFechaAccion(Date fechaAccion) {
		this.fechaAccion = fechaAccion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEstadoAlistamiento() {
		return this.fechaEstadoAlistamiento;
	}

	public void setFechaEstadoAlistamiento(Date fechaEstadoAlistamiento) {
		this.fechaEstadoAlistamiento = fechaEstadoAlistamiento;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public BigDecimal getNumeroAlistamiento() {
		return this.numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}

	public BigDecimal getNumeroIdPoderdante() {
		return this.numeroIdPoderdante;
	}

	public void setNumeroIdPoderdante(BigDecimal numeroIdPoderdante) {
		this.numeroIdPoderdante = numeroIdPoderdante;
	}

	public String getTipoIdPoderdante() {
		return this.tipoIdPoderdante;
	}

	public void setTipoIdPoderdante(String tipoIdPoderdante) {
		this.tipoIdPoderdante = tipoIdPoderdante;
	}

	public String getUsuarioAccion() {
		return this.usuarioAccion;
	}

	public void setUsuarioAccion(String usuarioAccion) {
		this.usuarioAccion = usuarioAccion;
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

}