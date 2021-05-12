package sai.com.procesosJudiciales.alistamientos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the V_HISTORIAL_ASIGNACION database table.
 * 
 */
@Entity
@Table(name="V_HISTORIAL_ASIGNACION")
@NamedQuery(name="vHistorialAsignacion", query="select o from VHistorialAsignacion o where o.numeroAlistamiento = :p_NoAlistamiento")
public class VHistorialAsignacion implements Serializable {
	private static final long serialVersionUID = 1L;

	private String abogado;

	private String estadoAsignacion;

    @Temporal( TemporalType.DATE)
	private Date fechaAsignacionAbogado;

    @Temporal( TemporalType.DATE)
	private Date fechaEntregaAbogado;

	private BigDecimal numeroAlistamiento;

	@Id
	private BigDecimal secuenciaAsignacion;

    public VHistorialAsignacion() {
    }

	public String getAbogado() {
		return this.abogado;
	}

	public void setAbogado(String abogado) {
		this.abogado = abogado;
	}

	public String getEstadoAsignacion() {
		return this.estadoAsignacion;
	}

	public void setEstadoAsignacion(String estadoAsignacion) {
		this.estadoAsignacion = estadoAsignacion;
	}

	public Date getFechaAsignacionAbogado() {
		return this.fechaAsignacionAbogado;
	}

	public void setFechaAsignacionAbogado(Date fechaAsignacionAbogado) {
		this.fechaAsignacionAbogado = fechaAsignacionAbogado;
	}

	public Date getFechaEntregaAbogado() {
		return this.fechaEntregaAbogado;
	}

	public void setFechaEntregaAbogado(Date fechaEntregaAbogado) {
		this.fechaEntregaAbogado = fechaEntregaAbogado;
	}

	public BigDecimal getNumeroAlistamiento() {
		return this.numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}

	public BigDecimal getSecuenciaAsignacion() {
		return this.secuenciaAsignacion;
	}

	public void setSecuenciaAsignacion(BigDecimal secuenciaAsignacion) {
		this.secuenciaAsignacion = secuenciaAsignacion;
	}

}