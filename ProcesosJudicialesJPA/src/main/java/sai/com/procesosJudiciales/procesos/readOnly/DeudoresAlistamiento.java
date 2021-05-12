package sai.com.procesosJudiciales.procesos.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


/**
 * The persistent class for the V_F_DEUDORES database table.
 * 
 */
@IdClass(DeudorKey.class)
@Entity
@Table(name="V_F_DEUDORES_ALISTAMIENTO")
public class DeudoresAlistamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="DEUDOR_PRINCIPAL", length=4000)
	private String deudorPrincipal;

	@Id
	@Column(name="NUMERO_ID_DEUDOR", nullable=false, precision=15)
	private BigDecimal numeroIdDeudor;

	@Id
	@Column(name="TIPO_ID_DEUDOR", nullable=false, length=3)
	private String tipoIdDeudor;
	
	@Column(name="NUMERO_ALISTAMIENTO", precision=15)
	private BigDecimal numeroAlistamiento;

	@Column(name="DEMANDADO", length=2)
	private String demandado;
	
	@Column(name="TIPO_DEUDOR", precision=15)
	private BigDecimal tipoDeudor;

    public DeudoresAlistamiento() {
    }

	public String getDeudorPrincipal() {
		return this.deudorPrincipal;
	}

	public void setDeudorPrincipal(String deudorPrincipal) {
		this.deudorPrincipal = deudorPrincipal;
	}

	public BigDecimal getNumeroIdDeudor() {
		return this.numeroIdDeudor;
	}

	public void setNumeroIdDeudor(BigDecimal numeroIdDeudor) {
		this.numeroIdDeudor = numeroIdDeudor;
	}

	public String getTipoIdDeudor() {
		return this.tipoIdDeudor;
	}

	public void setTipoIdDeudor(String tipoIdDeudor) {
		this.tipoIdDeudor = tipoIdDeudor;
	}

	public BigDecimal getNumeroAlistamiento() {
		return numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}

	public String getDemandado() {
		return demandado;
	}

	public void setDemandado(String demandado) {
		this.demandado = demandado;
	}

	public BigDecimal getTipoDeudor() {
		return tipoDeudor;
	}

	public void setTipoDeudor(BigDecimal tipoDeudor) {
		this.tipoDeudor = tipoDeudor;
	}
	
	

}
