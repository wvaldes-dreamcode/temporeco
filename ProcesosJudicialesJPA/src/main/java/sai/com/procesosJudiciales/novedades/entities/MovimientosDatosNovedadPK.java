package sai.com.procesosJudiciales.novedades.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the MOVIMIENTOS_DATOS_NOVEDAD database table.
 * 
 */
@Embeddable
public class MovimientosDatosNovedadPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SECUENCIA_DATO_ASOCIADO")
	private BigDecimal secuenciaDatoAsociado;	

	@Column(name="SECUENCIA_DATO_BASICO")
	private BigDecimal secuenciaDatoBasico;

	@Column(name="SECUENCIA_MOVIMIENTO_NOVEDAD")
	private BigDecimal secuenciaMovimientoNovedad;
	
	
	public MovimientosDatosNovedadPK() {
    }

	public BigDecimal getSecuenciaMovimientoNovedad() {
		return secuenciaMovimientoNovedad;
	}
	
	public void setSecuenciaMovimientoNovedad(BigDecimal secuenciaMovimientoNovedad) {
		this.secuenciaMovimientoNovedad = secuenciaMovimientoNovedad;
	}
	
	public BigDecimal getSecuenciaDatoAsociado() {
		return this.secuenciaDatoAsociado;
	}
	
	public void setSecuenciaDatoAsociado(BigDecimal secuenciaDatoAsociado) {
		this.secuenciaDatoAsociado = secuenciaDatoAsociado;
	}
	
	public BigDecimal getSecuenciaDatoBasico() {
		return this.secuenciaDatoBasico;
	}
	
	public void setSecuenciaDatoBasico(BigDecimal secuenciaDatoBasico) {
		this.secuenciaDatoBasico = secuenciaDatoBasico;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MovimientosDatosNovedadPK)) {
			return false;
		}
		MovimientosDatosNovedadPK castOther = (MovimientosDatosNovedadPK)other;
		return 
			(this.secuenciaDatoAsociado == castOther.secuenciaDatoAsociado)			
			&& (this.secuenciaDatoBasico == castOther.secuenciaDatoBasico)
			&& (this.secuenciaMovimientoNovedad == castOther.secuenciaMovimientoNovedad);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.secuenciaDatoAsociado.longValue() ^ (this.secuenciaDatoAsociado.longValue() >>> 32)));		
		hash = hash * prime + ((int) (this.secuenciaDatoBasico.longValue() ^ (this.secuenciaDatoBasico.longValue() >>> 32)));
		hash = hash * prime + ((int) (this.secuenciaMovimientoNovedad.longValue() ^ (this.secuenciaMovimientoNovedad.longValue() >>> 32)));
		
		return hash;
    }
}