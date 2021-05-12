package sai.com.procesosJudiciales.procesos.readOnly;

import static org.eclipse.persistence.annotations.CacheType.NONE;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the V_F_PROCESOS_ALISTAMIENTO database table.
 * 
 */
@Entity
@Table(name="V_F_PROCESOS_ALISTAMIENTO")
@org.eclipse.persistence.annotations.Cache(type = NONE)
public class ProcesosAlistamientoV implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=4000)
	private String abogado;

	@Column(name="ESTADO_PRO", length=4000)
	private String estadoPro;

	@Column(name="ESTADO_PROCESO", nullable=false, length=120)
	private String estadoProceso;

	@Column(name="NOMBRE_TIPO_PROCESO", nullable=false, length=100)
	private String nombreTipoProceso;

	@Column(name="NUMERO_ALISTAMIENTO", nullable=false, precision=15)
	private BigDecimal numeroAlistamiento;

	@Column(name="NUMERO_ID", nullable=false, precision=16)
	private BigDecimal numeroId;

	@Column(name="NUMERO_OBLIGACION", nullable=false, precision=22)
	private BigDecimal numeroObligacion;
		
	@Id
	@Column(name="NUMERO_PROCESO", nullable=false, precision=15)
	private BigDecimal numeroProceso;

	@Column(name="SECUENCIA_DEUDA", nullable=false, precision=15)
	private BigDecimal secuenciaDeuda;
	
	@Column(name="SECUENCIA_TIPO_PROCESO", nullable=false, precision=15)
	private BigDecimal secuenciaTipoProceso;

	@Column(name="TIPO_ID", nullable=false, length=3)
	private String tipoId;

    public ProcesosAlistamientoV() {
    }

	public String getAbogado() {
		return this.abogado;
	}

	public void setAbogado(String abogado) {
		this.abogado = abogado;
	}

	public String getEstadoPro() {
		return this.estadoPro;
	}

	public void setEstadoPro(String estadoPro) {
		this.estadoPro = estadoPro;
	}

	public String getEstadoProceso() {
		return this.estadoProceso;
	}

	public void setEstadoProceso(String estadoProceso) {
		this.estadoProceso = estadoProceso;
	}

	public String getNombreTipoProceso() {
		return this.nombreTipoProceso;
	}

	public void setNombreTipoProceso(String nombreTipoProceso) {
		this.nombreTipoProceso = nombreTipoProceso;
	}

	public BigDecimal getNumeroAlistamiento() {
		return this.numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}

	public BigDecimal getNumeroId() {
		return this.numeroId;
	}

	public void setNumeroId(BigDecimal numeroId) {
		this.numeroId = numeroId;
	}

	public BigDecimal getNumeroObligacion() {
		return this.numeroObligacion;
	}

	public void setNumeroObligacion(BigDecimal numeroObligacion) {
		this.numeroObligacion = numeroObligacion;
	}

	public BigDecimal getNumeroProceso() {
		return this.numeroProceso;
	}

	public void setNumeroProceso(BigDecimal numeroProceso) {
		this.numeroProceso = numeroProceso;
	}

	public BigDecimal getSecuenciaDeuda() {
		return this.secuenciaDeuda;
	}

	public void setSecuenciaDeuda(BigDecimal secuenciaDeuda) {
		this.secuenciaDeuda = secuenciaDeuda;
	}

	public BigDecimal getSecuenciaTipoProceso() {
		return this.secuenciaTipoProceso;
	}

	public void setSecuenciaTipoProceso(BigDecimal secuenciaTipoProceso) {
		this.secuenciaTipoProceso = secuenciaTipoProceso;
	}

	public String getTipoId() {
		return this.tipoId;
	}

	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}

}