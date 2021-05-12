package sai.com.procesosJudiciales.procesos.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;

public final class DemandanteKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String tipoIdDemandante;
	public BigDecimal numIdDemandante;

	public DemandanteKey() {}

	public DemandanteKey(String tipoIdDemandante, BigDecimal numIdDemandante) {
		this.numIdDemandante = numIdDemandante;
		this.tipoIdDemandante = tipoIdDemandante;
	}


	public boolean equals(Object otherOb) {
		if (this == otherOb) {
			return true;
		}

		if (!(otherOb instanceof DemandanteKey)) {
			return false;
		}

		DemandanteKey other = (DemandanteKey) otherOb;
		return ((numIdDemandante==null?other.numIdDemandante==null:numIdDemandante.equals
				(other.numIdDemandante)) && (tipoIdDemandante.compareTo(other.tipoIdDemandante)==0 ));
	}
	public int hashCode() {
		return ((numIdDemandante==null?0:numIdDemandante.hashCode()) ^ (tipoIdDemandante.hashCode()));
	}
}