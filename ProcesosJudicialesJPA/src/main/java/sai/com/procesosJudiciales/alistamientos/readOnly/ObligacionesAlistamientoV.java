package sai.com.procesosJudiciales.alistamientos.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.ExistenceChecking;
import org.eclipse.persistence.annotations.ExistenceType;


/**
 * The persistent class for the V_F_OBLIGACIONES_ALISTAMIENTO database table.
 * 
 */
@Entity
@Table(name="V_F_OBLIGACIONES_ALISTAMIENTO")
@ExistenceChecking(ExistenceType.ASSUME_NON_EXISTENCE)
@org.eclipse.persistence.annotations.Cache(type = CacheType.NONE)
public class ObligacionesAlistamientoV implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="APR_CDGO_AMPRO", nullable=false, length=2)
	private String aprCdgoAmpro;

	@Column(name="APR_DSCRPCION", nullable=false, length=50)
	private String aprDscrpcion;

	@Column(name="APR_RAM_CDGO", nullable=false, length=2)
	private String aprRamCdgo;

	@Column(name="CODIGO_CLASE", nullable=false, precision=15)
	private BigDecimal codigoClase;

	@Column(name="CODIGO_SUCURSAL", length=5)
	private String codigoSucursal;

	@Column(name="DESCRIPCION_CLASE", nullable=false, length=120)
	private String descripcionClase;

	@Column(length=4000)
	private String direccion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_INICIO_SINIESTRO", nullable=false)
	private Date fechaInicioSiniestro;

	@Column(length=4000)
	private String garantia;

	@Id
	@Column(name="NUMERO_ALISTAMIENTO", nullable=false, precision=15)
	private BigDecimal numeroAlistamiento;

	@Column(name="NUMERO_ID_AGENTE", precision=15)
	private BigDecimal numeroIdAgente;

	@Column(name="NUMERO_ID_DEUDOR", nullable=false, precision=15)
	private BigDecimal numeroIdDeudor;

	@Column(name="NUMERO_OBLIGACION", nullable=false, precision=22)
	private BigDecimal numeroObligacion;

	@Column(name="NUMERO_POLIZA", precision=22)
	private BigDecimal numeroPoliza;

	@Column(name="SECUENCIA_DEUDA", nullable=false, precision=15)
	private BigDecimal secuenciaDeuda;

	@Column(name="TIPO_ID_AGENTE", length=3)
	private String tipoIdAgente;

	@Column(name="TIPO_ID_DEUDOR", nullable=false, length=3)
	private String tipoIdDeudor;

	@Column(name="VALOR_REAL_DEUDA", precision=22)
	private BigDecimal valorRealDeuda;

    public ObligacionesAlistamientoV() {
    }

	public String getAprCdgoAmpro() {
		return this.aprCdgoAmpro;
	}

	public void setAprCdgoAmpro(String aprCdgoAmpro) {
		this.aprCdgoAmpro = aprCdgoAmpro;
	}

	public String getAprDscrpcion() {
		return this.aprDscrpcion;
	}

	public void setAprDscrpcion(String aprDscrpcion) {
		this.aprDscrpcion = aprDscrpcion;
	}

	public String getAprRamCdgo() {
		return this.aprRamCdgo;
	}

	public void setAprRamCdgo(String aprRamCdgo) {
		this.aprRamCdgo = aprRamCdgo;
	}

	public BigDecimal getCodigoClase() {
		return this.codigoClase;
	}

	public void setCodigoClase(BigDecimal codigoClase) {
		this.codigoClase = codigoClase;
	}

	public String getCodigoSucursal() {
		return this.codigoSucursal;
	}

	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}

	public String getDescripcionClase() {
		return this.descripcionClase;
	}

	public void setDescripcionClase(String descripcionClase) {
		this.descripcionClase = descripcionClase;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaInicioSiniestro() {
		return this.fechaInicioSiniestro;
	}

	public void setFechaInicioSiniestro(Date fechaInicioSiniestro) {
		this.fechaInicioSiniestro = fechaInicioSiniestro;
	}

	public String getGarantia() {
		return this.garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public BigDecimal getNumeroAlistamiento() {
		return this.numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}

	public BigDecimal getNumeroIdAgente() {
		return this.numeroIdAgente;
	}

	public void setNumeroIdAgente(BigDecimal numeroIdAgente) {
		this.numeroIdAgente = numeroIdAgente;
	}

	public BigDecimal getNumeroIdDeudor() {
		return this.numeroIdDeudor;
	}

	public void setNumeroIdDeudor(BigDecimal numeroIdDeudor) {
		this.numeroIdDeudor = numeroIdDeudor;
	}

	public BigDecimal getNumeroObligacion() {
		return this.numeroObligacion;
	}

	public void setNumeroObligacion(BigDecimal numeroObligacion) {
		this.numeroObligacion = numeroObligacion;
	}

	public BigDecimal getNumeroPoliza() {
		return this.numeroPoliza;
	}

	public void setNumeroPoliza(BigDecimal numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public BigDecimal getSecuenciaDeuda() {
		return this.secuenciaDeuda;
	}

	public void setSecuenciaDeuda(BigDecimal secuenciaDeuda) {
		this.secuenciaDeuda = secuenciaDeuda;
	}

	public String getTipoIdAgente() {
		return this.tipoIdAgente;
	}

	public void setTipoIdAgente(String tipoIdAgente) {
		this.tipoIdAgente = tipoIdAgente;
	}

	public String getTipoIdDeudor() {
		return this.tipoIdDeudor;
	}

	public void setTipoIdDeudor(String tipoIdDeudor) {
		this.tipoIdDeudor = tipoIdDeudor;
	}

	public BigDecimal getValorRealDeuda() {
		return this.valorRealDeuda;
	}

	public void setValorRealDeuda(BigDecimal valorRealDeuda) {
		this.valorRealDeuda = valorRealDeuda;
	}

}