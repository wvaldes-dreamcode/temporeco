package sai.com.procesosJudiciales.procesos.readOnly;

import java.math.BigDecimal;



public class ProcesoKey {

	
	public BigDecimal numeroAlistamiento;
	public BigDecimal numeroProceso;
	public BigDecimal seqCoordinador;
	public ProcesoKey() {
		
	}

	public ProcesoKey(BigDecimal numeroAlistamiento, BigDecimal numeroProceso,
			BigDecimal seqCoordinador) {
		super();
		this.numeroAlistamiento = numeroAlistamiento;
		this.numeroProceso = numeroProceso;
		this.seqCoordinador = seqCoordinador;
	}




	public boolean equals(Object otherOb) {
		if (this == otherOb) {
			return true;
		}

		if (!(otherOb instanceof ProcesoKey)) {
			return false;
		}

		ProcesoKey other = (ProcesoKey) otherOb;
		return ((numeroProceso==null?other.numeroProceso==null:numeroProceso.equals
				(other.numeroProceso)) && (numeroAlistamiento==null?other.numeroAlistamiento==null:numeroAlistamiento.equals
						(other.numeroAlistamiento)) && (seqCoordinador==null?other.seqCoordinador==null:seqCoordinador.equals
								(other.seqCoordinador)));
	}
	public int hashCode() {
		return ((numeroProceso==null?0:numeroProceso.hashCode()) ^ (numeroAlistamiento==null?0:numeroAlistamiento.hashCode()) ^ (seqCoordinador==null?0:seqCoordinador.hashCode()));
	}	
	
}
