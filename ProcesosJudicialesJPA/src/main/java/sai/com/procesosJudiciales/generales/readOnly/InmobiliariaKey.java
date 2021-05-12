package sai.com.procesosJudiciales.generales.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;

public class InmobiliariaKey implements Serializable {

	
	public String tipoidInmo;
	public BigDecimal numeroInmo;

	public InmobiliariaKey() {
		
	}

	public InmobiliariaKey(String tipoidInmo, BigDecimal numeroInmo) {
		this.numeroInmo = numeroInmo;
		this.tipoidInmo = tipoidInmo;
	}


	public boolean equals(Object otherOb) {
		if (this == otherOb) {
			return true;
		}

		if (!(otherOb instanceof InmobiliariaKey)) {
			return false;
		}

		InmobiliariaKey other = (InmobiliariaKey) otherOb;
		return ((numeroInmo==null?other.numeroInmo==null:numeroInmo.equals
				(other.numeroInmo)) && (tipoidInmo.compareTo(other.tipoidInmo)==0 ));
	}
	public int hashCode() {
		return ((numeroInmo==null?0:numeroInmo.hashCode()) ^ (tipoidInmo.hashCode()));
	}
	
}
