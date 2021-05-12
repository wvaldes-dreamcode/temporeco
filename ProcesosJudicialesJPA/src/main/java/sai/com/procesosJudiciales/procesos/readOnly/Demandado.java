package sai.com.procesosJudiciales.procesos.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the V_F_DWEMANDADOS database table.
 * 
 */
@Entity
@Table(name="V_F_DWEMANDADOS")
public class Demandado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CODIGO_CLASE", nullable=false, precision=15)
	private BigDecimal codigoClase;

	@Column(length=4000)
	private String demandado;

	@Column(name="ESTADO_DEMANDADO", nullable=false, length=2)
	private String estadoDemandado;

	@Column(name="NOM_ESTADO_DEMANDADO", length=4000)
	private String nomEstadoDemandado;

	@Column(name="NUMERO_ID_DEUDOR", nullable=false, precision=15)
	private BigDecimal numeroIdDeudor;

	@Id
	@Column(name="SECUENCIA_DEMANDADO", nullable=false, precision=15)
	private BigDecimal secuenciaDemandado;

	@Column(name="SECUENCIA_DEUDA", nullable=false, precision=15)
	private BigDecimal secuenciaDeuda;

	@Column(name="TIPO_DEUDOR", nullable=false, precision=15)
	private BigDecimal tipoDeudor;

	@Column(name="TIPO_ID_DEUDOR", nullable=false, length=3)
	private String tipoIdDeudor;

	//bi-directional many-to-one association to Proceso
    @ManyToOne
	@JoinColumn(name="NUMERO_PROCESO", referencedColumnName="NUMERO_PROCESO", nullable=false)
	private Proceso proceso;

    public Demandado() {
    }

	public BigDecimal getCodigoClase() {
		return this.codigoClase;
	}

	public void setCodigoClase(BigDecimal codigoClase) {
		this.codigoClase = codigoClase;
	}

	public String getDemandado() {
		return this.demandado;
	}

	public void setDemandado(String demandado) {
		this.demandado = demandado;
	}

	public String getEstadoDemandado() {
		return this.estadoDemandado;
	}

	public void setEstadoDemandado(String estadoDemandado) {
		this.estadoDemandado = estadoDemandado;
	}

	public String getNomEstadoDemandado() {
		return this.nomEstadoDemandado;
	}

	public void setNomEstadoDemandado(String nomEstadoDemandado) {
		this.nomEstadoDemandado = nomEstadoDemandado;
	}

	public BigDecimal getNumeroIdDeudor() {
		return this.numeroIdDeudor;
	}

	public void setNumeroIdDeudor(BigDecimal numeroIdDeudor) {
		this.numeroIdDeudor = numeroIdDeudor;
	}

	public BigDecimal getSecuenciaDemandado() {
		return this.secuenciaDemandado;
	}

	public void setSecuenciaDemandado(BigDecimal secuenciaDemandado) {
		this.secuenciaDemandado = secuenciaDemandado;
	}

	public BigDecimal getSecuenciaDeuda() {
		return this.secuenciaDeuda;
	}

	public void setSecuenciaDeuda(BigDecimal secuenciaDeuda) {
		this.secuenciaDeuda = secuenciaDeuda;
	}

	public BigDecimal getTipoDeudor() {
		return this.tipoDeudor;
	}

	public void setTipoDeudor(BigDecimal tipoDeudor) {
		this.tipoDeudor = tipoDeudor;
	}

	public String getTipoIdDeudor() {
		return this.tipoIdDeudor;
	}

	public void setTipoIdDeudor(String tipoIdDeudor) {
		this.tipoIdDeudor = tipoIdDeudor;
	}

	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}
	
}