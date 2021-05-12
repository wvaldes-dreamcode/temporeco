package sai.com.procesosJudiciales.procesos.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import sai.com.procesosJudiciales.generales.readOnly.InmobiliariasV;


/**
 * The persistent class for the V_F_OBLIGACIONES database table.
 * 
 */
@Entity
@Table(name="V_F_OBLIGACIONES")
public class ObligacioneV implements Serializable {
	private static final long serialVersionUID = 1L;

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

	@Column(name="NUMERO_OBLIGACION", nullable=false, precision=22)
	private BigDecimal numeroObligacion;

	@Column(name="NUMERO_POLIZA", precision=22)
	private BigDecimal numeroPoliza;

	@Id
	@Column(name="SECUENCIA_DEUDA", nullable=false, precision=15)
	private BigDecimal secuenciaDeuda;	

	@Column(name="VALOR_REAL_DEUDA", precision=22)
	private BigDecimal valorRealDeuda;

	//uni-directional many-to-one association to DeudoresV
    @ManyToOne
	@JoinColumns({
		@JoinColumn(name="NUMERO_ID_DEUDOR", referencedColumnName="NUMERO_ID_DEUDOR", nullable=false),
		@JoinColumn(name="TIPO_ID_DEUDOR", referencedColumnName="TIPO_ID_DEUDOR", nullable=false)
		})
	private DeudoresV deudor;

	//uni-directional many-to-one association to InmobiliariasV
    @ManyToOne
	@JoinColumns({
		@JoinColumn(name="TIPO_ID_AGENTE", referencedColumnName="TIPOID_INMO", nullable=false),
		@JoinColumn(name="NUMERO_ID_AGENTE", referencedColumnName="NUMERO_INMO")
		})
	private InmobiliariasV inmobiliaria;

    public ObligacioneV() {
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

	public BigDecimal getValorRealDeuda() {
		return this.valorRealDeuda;
	}

	public void setValorRealDeuda(BigDecimal valorRealDeuda) {
		this.valorRealDeuda = valorRealDeuda;
	}

	public DeudoresV getDeudor() {
		return this.deudor;
	}

	public void setDeudor(DeudoresV deudor) {
		this.deudor = deudor;
	}
	
	public InmobiliariasV getInmobiliaria() {
		return this.inmobiliaria;
	}

	public void setInmobiliaria(InmobiliariasV inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
	}	
}