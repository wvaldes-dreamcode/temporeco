package sai.com.procesosJudiciales.novedades.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * The persistent class for the DETALLE_CONSECUENCIAS_NOVEDAD database table.
 * 
 */
@Entity
@Table(name="DETALLE_CONSECUENCIAS_NOVEDAD")
public class Consecuencia implements Serializable {
	private static final long serialVersionUID = 1L;

	/*@EmbeddedId
	private ConsecuenciaPK id;*/

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

	@Column(name="TIPO_CONSECUENCIA", nullable=false, length=2)
	private String tipoConsecuencia;

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;
	
	@Transient
	private String descripcion;

	@Column(name="SECUENCIA_CONSECUENCIA", unique=true, nullable=false, precision=22)
	private long secuenciaConsecuencia;
	
	@Id
	@Column(name="SECUENCIA_NOVEDAD", unique=true, nullable=false, precision=22)
	private long secuenciaNovedad;
	   
	public long getSecuenciaConsecuencia() {
		return this.secuenciaConsecuencia;
	}
	public void setSecuenciaConsecuencia(long secuenciaConsecuencia) {
		this.secuenciaConsecuencia = secuenciaConsecuencia;
	}
	public long getSecuenciaNovedad() {
		return this.secuenciaNovedad;
	}
	public void setSecuenciaNovedad(long secuenciaNovedad) {
		this.secuenciaNovedad = secuenciaNovedad;
	}
	
    public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Consecuencia() {
    }
	
	@PostLoad
	public void cargarDescripcion(){
		
		if(tipoConsecuencia.compareToIgnoreCase("S") == 0){
			
			this.descripcion = "Suspenci�n";
			
		}else if(tipoConsecuencia.compareToIgnoreCase("D") == 0){
		
			this.descripcion = "Devoluci�n";			
		
		}else if(tipoConsecuencia.compareToIgnoreCase("I") == 0){
			
			this.descripcion = "Informativa";			
		
		}else{
			
			this.descripcion = "Ninguno";
			
		}
	}

/*	public ConsecuenciaPK getId() {
		return this.id;
	}

	public void setId(ConsecuenciaPK id) {
		this.id = id;
	}*/
	
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getTipoConsecuencia() {
		return this.tipoConsecuencia;
	}

	public void setTipoConsecuencia(String tipoConsecuencia) {
		this.tipoConsecuencia = tipoConsecuencia;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

}