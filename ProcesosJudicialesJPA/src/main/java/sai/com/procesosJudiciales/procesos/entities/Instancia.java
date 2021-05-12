package sai.com.procesosJudiciales.procesos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the INSTANCIAS database table.
 * 
 */
@Entity
@Table(name="INSTANCIAS")
public class Instancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SECUENCIA_INSTANCIA", unique=true, nullable=false, precision=15)
	private BigDecimal secuenciaInstancia;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="NOMBRE_INSTANCIA", nullable=false, length=200)
	private String nombreInstancia;

	@Column(precision=22)
	private BigDecimal orden;

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=30)
	private String usuarioModificacion;	

    public Instancia() {
    }

	public BigDecimal getSecuenciaInstancia() {
		return this.secuenciaInstancia;
	}

	public void setSecuenciaInstancia(BigDecimal secuenciaInstancia) {
		this.secuenciaInstancia = secuenciaInstancia;
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

	public String getNombreInstancia() {
		return this.nombreInstancia;
	}

	public void setNombreInstancia(String nombreInstancia) {
		this.nombreInstancia = nombreInstancia;
	}

	public BigDecimal getOrden() {
		return this.orden;
	}

	public void setOrden(BigDecimal orden) {
		this.orden = orden;
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
/*
	public List<InstanciasProceso> getVFInstanciasProcesos() {
		return this.VFInstanciasProcesos;
	}

	public void setVFInstanciasProcesos(List<InstanciasProceso> VFInstanciasProcesos) {
		this.VFInstanciasProcesos = VFInstanciasProcesos;
	}
	*/
}