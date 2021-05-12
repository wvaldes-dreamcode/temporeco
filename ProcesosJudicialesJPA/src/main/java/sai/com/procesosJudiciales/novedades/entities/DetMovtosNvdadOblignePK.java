package sai.com.procesosJudiciales.novedades.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the DET_MOVTOS_NVDAD_OBLIGNES database table.
 * 
 */
@Embeddable
public class DetMovtosNvdadOblignePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SECUENCIA_MOVIMIENTO_NOVEDAD")
	private long secuenciaMovimientoNovedad;

	@Column(name="SECUENCIA_MOVIMIENTO_DETALLE")
	private long secuenciaMovimientoDetalle;

    public DetMovtosNvdadOblignePK() {
    }
	public long getSecuenciaMovimientoNovedad() {
		return this.secuenciaMovimientoNovedad;
	}
	public void setSecuenciaMovimientoNovedad(long secuenciaMovimientoNovedad) {
		this.secuenciaMovimientoNovedad = secuenciaMovimientoNovedad;
	}
	public long getSecuenciaMovimientoDetalle() {
		return this.secuenciaMovimientoDetalle;
	}
	public void setSecuenciaMovimientoDetalle(long secuenciaMovimientoDetalle) {
		this.secuenciaMovimientoDetalle = secuenciaMovimientoDetalle;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetMovtosNvdadOblignePK)) {
			return false;
		}
		DetMovtosNvdadOblignePK castOther = (DetMovtosNvdadOblignePK)other;
		return 
			(this.secuenciaMovimientoNovedad == castOther.secuenciaMovimientoNovedad)
			&& (this.secuenciaMovimientoDetalle == castOther.secuenciaMovimientoDetalle);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.secuenciaMovimientoNovedad ^ (this.secuenciaMovimientoNovedad >>> 32)));
		hash = hash * prime + ((int) (this.secuenciaMovimientoDetalle ^ (this.secuenciaMovimientoDetalle >>> 32)));
		
		return hash;
    }
}