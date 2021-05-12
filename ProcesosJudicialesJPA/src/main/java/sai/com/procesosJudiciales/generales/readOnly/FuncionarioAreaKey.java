package sai.com.procesosJudiciales.generales.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;

public class FuncionarioAreaKey implements Serializable {

	
	public String tipoId;
	public BigDecimal documentoId;

	public FuncionarioAreaKey() {
		
	}

	public FuncionarioAreaKey(String tipoId, BigDecimal documentoId) {
		this.documentoId = documentoId;
		this.tipoId = tipoId;
	}


	public boolean equals(Object otherOb) {
		if (this == otherOb) {
			return true;
		}

		if (!(otherOb instanceof FuncionarioAreaKey)) {
			return false;
		}

		FuncionarioAreaKey other = (FuncionarioAreaKey) otherOb;
		return ((documentoId==null?other.documentoId==null:documentoId.equals
				(other.documentoId)) && (tipoId.compareTo(other.tipoId)==0 ));
	}
	public int hashCode() {
		return ((documentoId==null?0:documentoId.hashCode()) ^ (tipoId.hashCode()));
	}	
	
}
