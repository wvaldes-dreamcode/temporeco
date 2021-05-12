package sai.com.procesosJudiciales.procesos.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the V_DEMANDANTES_PROCESOS database table.
 * 
 */

@IdClass(DemandanteKey.class)
@Entity
@Table(name="V_DEMANDANTES_PROCESOS")
@NamedQueries({@NamedQuery(name = "DemandantesProcesos", query = "select dp from DemandantesProceso dp"),
			   @NamedQuery(name = "demandanteById", query = "select d from DemandantesProceso d where d.numIdDemandante = :id")})
public class DemandantesProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="IDENTIFICACION", length=4000)
	private String identificacion;
	
	
	@Column(name="NOMBRE_DEMANDANTE", length=4000)
	private String nombreDemandante;

	@Id
	@Column(name="NUM_ID_DEMANDANTE", nullable=false, precision=16)
	private BigDecimal numIdDemandante;

	

	@Id
	@Column(name="TIPO_ID_DEMANDANTE", length=10)
	private String tipoIdDemandante;

	public DemandantesProceso() {
    }
		
	public String getIdentificacion() {
		return identificacion;
	}

    public String getNombreDemandante() {
		return this.nombreDemandante;
	}

	public BigDecimal getNumIdDemandante() {
		return this.numIdDemandante;
	}	

	public String getTipoIdDemandante() {
		return tipoIdDemandante;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public void setNombreDemandante(String nombreDemandante) {
		this.nombreDemandante = nombreDemandante;
	}

	public void setNumIdDemandante(BigDecimal numIdDemandante) {
		this.numIdDemandante = numIdDemandante;
	}	

	public void setTipoIdDemandante(String tipoIdDemandante) {
		this.tipoIdDemandante = tipoIdDemandante;
	}
	
}