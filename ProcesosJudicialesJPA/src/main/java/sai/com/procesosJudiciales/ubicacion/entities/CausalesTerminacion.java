package sai.com.procesosJudiciales.ubicacion.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the CAUSALES_TERMINACION database table.
 * 
 */
@Entity
@Table(name="CAUSALES_TERMINACION")
public class CausalesTerminacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CAUSALES_NUMEROCAUSALES_GENERATOR", sequenceName="SEQ_CAUSALES_TERMINACION", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAUSALES_NUMEROCAUSALES_GENERATOR")
	@Column(name="NUMERO_CAUSAL_TERMINACION")
	private BigDecimal numeroCausalTerminacion;

	private String descripcion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;
	
	private String abreviatura;

	@Column(name="ESTADO_CAUSAL_TERMINACION")
	private String estadoCausalTerminacion;

    public CausalesTerminacion() {
    }

	public BigDecimal getNumeroCausalTerminacion() {
		return this.numeroCausalTerminacion;
	}

	public void setNumeroCausalTerminacion(BigDecimal numeroCausalTerminacion) {
		this.numeroCausalTerminacion = numeroCausalTerminacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getEstadoCausalTerminacion() {
		return estadoCausalTerminacion;
	}

	public void setEstadoCausalTerminacion(String estadoCausalTerminacion) {
		this.estadoCausalTerminacion = estadoCausalTerminacion;
	}

}