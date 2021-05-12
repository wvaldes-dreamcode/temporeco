package sai.com.procesosJudiciales.alistamientos.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the ORIGEN_DESOCUPACION database table.
 * 
 */
@Entity
@Table(name="ORIGEN_DESOCUPACION")
public class TipoOrigenDesocupacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=2)
	private String abreviatura;

	@Column(nullable=false, length=120)
	private String descripcion;

	@Id
	@Column(name="SECUENCIA_ORIGEN", nullable=false, precision=15)
	private BigDecimal secuenciaOrigen;

    public TipoOrigenDesocupacion() {
    }

	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getSecuenciaOrigen() {
		return this.secuenciaOrigen;
	}

	public void setSecuenciaOrigen(BigDecimal secuenciaOrigen) {
		this.secuenciaOrigen = secuenciaOrigen;
	}

}