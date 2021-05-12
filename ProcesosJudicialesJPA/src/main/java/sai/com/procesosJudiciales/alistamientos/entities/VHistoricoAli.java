package sai.com.procesosJudiciales.alistamientos.entities;

import static org.eclipse.persistence.annotations.CacheType.NONE;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the V_HISTORICO_ALIS database table.
 * 
 */
@Entity
@Table(name="V_HISTORICO_ALIS")
@org.eclipse.persistence.annotations.Cache(type = NONE)
public class VHistoricoAli implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=4000)
	private String abogado;

	@Column(nullable=false, length=120)
	private String alistamiento;

	@Column(nullable=false, length=120)
	private String estado;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date fecha;

	@Column(name="NUMERO_ALISTAMIENTO", nullable=false, precision=15)
	private BigDecimal numeroAlistamiento;

	@Id
	@Column(name="SECUENCIA_HIS_ALISTAMIENTO", nullable=false, precision=15)
	private BigDecimal secuenciaHisAlistamiento;

	@Column(name="USUARIO_ACCION", length=30)
	private String usuarioAccion;
	
	@Column(name="NOMBRE_USUARIO", length=200)
	private String nombreUsuario;
	
	//@Transient
    //private FuncionariosAreaV usuario;
	
	@OneToMany()
	@JoinColumn(name="SECUENCIA_HIS_ALISTAMIENTO")
	private List<CausalEstadoAlistamiento> Causales;   

    public VHistoricoAli() {
    }

    //@PostLoad
    //@PostPersist
    /*public void cargarUsuarios(){
    	
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProcesosJudicialesJPA");
    	
    	EntityManager em = emf.createEntityManager();
    	
    	try {
    		System.out.println("this.usuarioAccion: " + this.usuarioAccion);    		
    		Query queryUA = em.createNamedQuery("funcionarioByDocumento");
    		queryUA.setParameter("numId", new BigDecimal(this.usuarioAccion));    		    		    		
    		setUsuario((FuncionariosAreaV) queryUA.getSingleResult());
			
		}catch (NullPointerException e) {
			System.out.println("hay un error en cargar usuarios: " + e); 
		} 
    	catch (Exception e) {
			
			System.out.println("se presento un error al cargar el usuario: " + e);
			
		}finally{			
			em.close();
			emf.close();			
		}
    }*/
    
	public String getAbogado() {
		return this.abogado;
	}

	public void setAbogado(String abogado) {
		this.abogado = abogado;
	}

	public String getAlistamiento() {
		return this.alistamiento;
	}

	public void setAlistamiento(String alistamiento) {
		this.alistamiento = alistamiento;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getNumeroAlistamiento() {
		return this.numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}

	public BigDecimal getSecuenciaHisAlistamiento() {
		return this.secuenciaHisAlistamiento;
	}

	public void setSecuenciaHisAlistamiento(BigDecimal secuenciaHisAlistamiento) {
		this.secuenciaHisAlistamiento = secuenciaHisAlistamiento;
	}

	public String getUsuarioAccion() {
		return this.usuarioAccion;
	}

	public void setUsuarioAccion(String usuarioAccion) {
		this.usuarioAccion = usuarioAccion;
	}
	
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	/*public FuncionariosAreaV getUsuario() {
		return usuario;
	}

	public void setUsuario(FuncionariosAreaV usuario) {
		this.usuario = usuario;
	}*/

	public List<CausalEstadoAlistamiento> getCausales() {
		return Causales;
	}

	public void setCausales(List<CausalEstadoAlistamiento> causales) {
		Causales = causales;
	}

}