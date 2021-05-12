package sai.com.procesosJudiciales.procesos.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;



public class DeudorKey implements Serializable {

	
	public String tipoIdDeudor;
	public BigDecimal numeroIdDeudor;

	public DeudorKey() {
		
	}

	public DeudorKey(String tipoIdDeudor, BigDecimal numeroIdDeudor) {
		this.numeroIdDeudor = numeroIdDeudor;
		this.tipoIdDeudor = tipoIdDeudor;
	}


	public boolean equals(Object otherOb) {
		if (this == otherOb) {
			return true;
		}

		if (!(otherOb instanceof DeudorKey)) {
			return false;
		}

		DeudorKey other = (DeudorKey) otherOb;
		return ((numeroIdDeudor==null?other.numeroIdDeudor==null:numeroIdDeudor.equals
				(other.numeroIdDeudor)) && (tipoIdDeudor.compareTo(other.tipoIdDeudor)==0 ));
	}
	public int hashCode() {
		return ((numeroIdDeudor==null?0:numeroIdDeudor.hashCode()) ^ (tipoIdDeudor.hashCode()));
	}	
	
}
