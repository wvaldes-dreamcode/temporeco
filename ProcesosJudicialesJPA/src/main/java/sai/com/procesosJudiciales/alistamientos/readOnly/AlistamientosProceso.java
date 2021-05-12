package sai.com.procesosJudiciales.alistamientos.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the V_F_ALISTAMIENTTOS_PROCESO database table.
 * 
 */
@Entity
@Table(name="V_F_ALISTAMIENTOS_PROCESO")
public class AlistamientosProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODIGO_ALISTAMIENTO", nullable=false, precision=15)
	private BigDecimal codigoAlistamiento;

	@Column(name="CODIGO_ESTADO_ALISTAMIENTO", nullable=false, precision=15)
	private BigDecimal codigoEstadoAlistamiento;

	@Column(name="NOMBRE_ALISTAMIENTO", nullable=false, length=120)
	private String nombreAlistamiento;

	@Column(name="NOMBRE_ESTADO_ALISTAMIENTO", length=120)
	private String nombreEstadoAlistamiento;

	@Column(name="NUMERO_ALISTAMIENTO", nullable=false, precision=15)
	private BigDecimal numeroAlistamiento;

	@Column(name="NUMERO_PROCESO", nullable=false, precision=15)
	private BigDecimal numeroProceso;

    public AlistamientosProceso() {
    }

	public BigDecimal getCodigoAlistamiento() {
		return this.codigoAlistamiento;
	}

	public void setCodigoAlistamiento(BigDecimal codigoAlistamiento) {
		this.codigoAlistamiento = codigoAlistamiento;
	}

	public BigDecimal getCodigoEstadoAlistamiento() {
		return this.codigoEstadoAlistamiento;
	}

	public void setCodigoEstadoAlistamiento(BigDecimal codigoEstadoAlistamiento) {
		this.codigoEstadoAlistamiento = codigoEstadoAlistamiento;
	}

	public String getNombreAlistamiento() {
		return this.nombreAlistamiento;
	}

	public void setNombreAlistamiento(String nombreAlistamiento) {
		this.nombreAlistamiento = nombreAlistamiento;
	}

	public String getNombreEstadoAlistamiento() {
		return this.nombreEstadoAlistamiento;
	}

	public void setNombreEstadoAlistamiento(String nombreEstadoAlistamiento) {
		this.nombreEstadoAlistamiento = nombreEstadoAlistamiento;
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

}