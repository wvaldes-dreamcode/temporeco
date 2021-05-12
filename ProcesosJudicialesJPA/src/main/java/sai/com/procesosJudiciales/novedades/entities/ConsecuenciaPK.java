package sai.com.procesosJudiciales.novedades.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the DETALLE_CONSECUENCIAS_NOVEDAD database table.
 * 
 */
@Embeddable
public class ConsecuenciaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SECUENCIA_CONSECUENCIA", unique=true, nullable=false, precision=22)
	private long secuenciaConsecuencia;

	@Column(name="SECUENCIA_NOVEDAD", unique=true, nullable=false, precision=22)
	private long secuenciaNovedad;

    public ConsecuenciaPK() {
    }
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConsecuenciaPK)) {
			return false;
		}
		ConsecuenciaPK castOther = (ConsecuenciaPK)other;
		return 
			(this.secuenciaConsecuencia == castOther.secuenciaConsecuencia)
			&& (this.secuenciaNovedad == castOther.secuenciaNovedad);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.secuenciaConsecuencia ^ (this.secuenciaConsecuencia >>> 32)));
		hash = hash * prime + ((int) (this.secuenciaNovedad ^ (this.secuenciaNovedad >>> 32)));
		
		return hash;
    }
}