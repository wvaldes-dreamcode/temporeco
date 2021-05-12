package sai.com.procesosJudiciales.novedades.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import sai.com.procesosJudiciales.novedades.readOnly.DatosAsociado;


/**
 * The persistent class for the MOVIMIENTOS_DATOS_NOVEDAD database table.
 * 
 */
@Entity
@Table(name="MOVIMIENTOS_DATOS_NOVEDAD")
public class MovimientosDatosNovedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MovimientosDatosNovedadPK id;

	//bi-directional many-to-one association to MovimientosNovedade
    @ManyToOne
	@JoinColumn(name="SECUENCIA_MOVIMIENTO_NOVEDAD", insertable=false, updatable=false)
	private MovimientosNovedade movimientosNovedade;
        

	@Column(name="CONTENIDO_DATO")
	private String contenidoDato;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	@Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="USUARIO_MODIFICACION")
	private String usuarioModificacion;

    @Transient
    private DatosAsociado informacionDato; 

    public MovimientosDatosNovedad() {
    }
    
    @PostLoad
    @PostPersist
    public void cargarInformacionDato(){
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProcesosJudicialesJPA");    	
    	EntityManager em = emf.createEntityManager();    	
    	try {
    		Query query = em.createQuery("select d from DatosAsociado d where d.temaDatoAsociado = 'NOV_OBLGCNES' " +
    											" and d.secuenciaDatoBasico = :datoBasico and d.secuenciaDatoAsociado = :datoAsociado" +
    											" and d.codigoSubtemaDato = :codigoSubtema " + 
    											" and d.estadoDatoVariable = 'A' and d.estadoDatoAsociado = 'A'");
    		
    		query.setParameter("datoBasico", this.id.getSecuenciaDatoBasico());
    		query.setParameter("datoAsociado",this.id.getSecuenciaDatoAsociado());
    		query.setParameter("codigoSubtema", this.getMovimientosNovedade().getNovedad().getSecuenciaNovedad().toString());    		    		
    		informacionDato = (DatosAsociado) query.getSingleResult();
			
		} catch (Exception e) {			
			System.out.println("se presento un error al cargar la informacion del dato: " + e);			
		}finally{			
			em.close();
			emf.close();			
		}    	
    }

	public MovimientosDatosNovedadPK getId() {
		return this.id;
	}

	public void setId(MovimientosDatosNovedadPK id) {
		this.id = id;
	}
	
	public String getContenidoDato() {
		return this.contenidoDato;
	}

	public void setContenidoDato(String contenidoDato) {
		this.contenidoDato = contenidoDato;
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

	public MovimientosNovedade getMovimientosNovedade() {
		return this.movimientosNovedade;
	}

	public void setMovimientosNovedade(MovimientosNovedade movimientosNovedade) {
		this.movimientosNovedade = movimientosNovedade;
	}

	public DatosAsociado getInformacionDato() {
		return informacionDato;
	}

	public void setInformacionDato(DatosAsociado informacionDato) {
		this.informacionDato = informacionDato;
	}
	
}