package sai.com.procesosJudiciales.alistamientos.readOnly;

import static org.eclipse.persistence.annotations.CacheType.NONE;
import static org.eclipse.persistence.annotations.ExistenceType.ASSUME_NON_EXISTENCE;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.ExistenceChecking;
import org.eclipse.persistence.annotations.NamedStoredProcedureQueries;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;
import org.eclipse.persistence.annotations.StoredProcedureParameter;

import sai.com.procesosJudiciales.alistamientos.entities.OrigenDesocupacion;
import sai.com.procesosJudiciales.procesos.readOnly.DeudoresV;


/**
 * The persistent class for the V_F_ALISTAMIENTOS_OBLIGACION database table.
 * 
 */
@Entity
@Table(name="V_F_ALISTAMIENTOS_OBLIGACION")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "AsignarAbogado", procedureName = "PKG_REPARTO_AUTOMATICO.PRC_ASIGNA_ABOGADO", returnsResultSet = false, parameters = 
		{
				@StoredProcedureParameter(queryParameter = "P_ALISTAMIENTO", direction = Direction.IN, type = BigDecimal.class),
				@StoredProcedureParameter(queryParameter = "P_SEQ_ABO_ANT", direction = Direction.IN, type = BigDecimal.class),				
				@StoredProcedureParameter(queryParameter = "P_SEQ_ABO_NEW", direction = Direction.IN, type = BigDecimal.class),				
				@StoredProcedureParameter(queryParameter = "P_SUCURSAL", direction = Direction.IN, type = String.class),
				@StoredProcedureParameter(queryParameter = "P_COMPANIA", direction = Direction.IN, type = String.class),
				@StoredProcedureParameter(queryParameter = "P_TDOC_SOCIO", direction = Direction.IN, type = String.class),
				@StoredProcedureParameter(queryParameter = "P_NUMID_SOCIO", direction = Direction.IN, type = String.class),
				@StoredProcedureParameter(queryParameter = "P_MARCA_ACCION", direction = Direction.IN, type = String.class),
				@StoredProcedureParameter(queryParameter = "P_USUARIO_ACCION", direction = Direction.IN, type = String.class),				
				@StoredProcedureParameter(queryParameter = "P_COD_ERROR", direction = Direction.OUT, type = String.class),
				@StoredProcedureParameter(queryParameter = "P_DESC_ERROR", direction = Direction.OUT, type = String.class) 
		}
	)	
})
@org.eclipse.persistence.annotations.Cache(type = NONE)
@ExistenceChecking(ASSUME_NON_EXISTENCE)
public class AlistamientosObligacionV implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CODIGO_ALISTAMIENTO", nullable=false, precision=15)
	private BigDecimal codigoAlistamiento;

	@Column(name="CODIGO_ESTADO_ALISTAMIENTO", nullable=false, precision=15)
	private BigDecimal codigoEstadoAlistamiento;

	@Column(name="NOMBRE_ALISTAMIENTO", nullable=false, length=120)
	private String nombreAlistamiento;

	@Column(name="NOMBRE_ESTADO_ALISTAMIENTO", length=120)
	private String nombreEstadoAlistamiento;

	@Id
	@Column(name="NUMERO_ALISTAMIENTO", nullable=false, precision=15)
	private BigDecimal numeroAlistamiento;

	@Column(name="NUMERO_OBLIGACION", nullable=false, precision=22)
	private BigDecimal numeroObligacion;

	@Column(name="SECUENCIA_DEUDA", nullable=false, precision=15)
	private BigDecimal secuenciaDeuda;
	
    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_SINIESTRO", nullable=false)
	private Date fechaSiniestro;
	
    @Column(name="OBSERVACIONES")
	private String observaciones;    
	
	@Column(name="ABRV_ESTADO_ALISTAMIENTO")
	private String abreviaturaEstado;	
	
	@Column(name="VALOR_REAL_DEUDA", precision=22)
	private BigDecimal valorRealDeuda;

	@Column(name="SUCURSAL", length=120)
	private String sucursal;
	
	@Column(name="SUCURSAL_TXT")
	private String sucursalTxt;
	
	@Column(name="AMPARO")
	private String amparo;
	
	@Column(name="ESTADO_SINIESTRO")
	private String estadoSiniestro;
	
	@Column(name="ESTADO_PAGO")
	private String estadoPago;
	
	@Column(name="INMOBILIARIA")
	private String inmobiliaria;
	
	@Column(name="PODERDANTE")
	private String poderdante;
	
	@Column(name="DIRECCION")
	private String direccion;
	
	//causal_de_cambio
	@Column(name="CAUSAL_DE_CAMBIO")
	private String causalCambio;
	
	@Column(name="AREA_ESTADO")
	private String areaEstado;
	
	@Column(name="VISIBILIDAD")
	private String visibilidad;
	
	@Column(name="NUMERO_POLIZA")
	private BigDecimal numeroPoliza;
	
	@Column(name="ULTIMA_MORA")
	private String ultimaMora;		
	
	@Column(name="VALOR_CANON")
	private BigDecimal valorCanon;
	
	@Column(name="COD_AMPARO")
	private String codAmparo;
	
	@Column(name="TIPO_POLIZA")
	private String tipoPoliza;

	@Column(name="RETIRO_POLIZA")
	private String retiroPoliza;

	@Column(name="COD_ESTADO_SINIESTRO")
	private String codEstadoSiniestro;

	@Column(name="AREA_ALISTAMIENTO")
	private String areaAlistamiento;
		
	@Transient
	private String usuario;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "NUMERO_ALISTAMIENTO")
	private List<OrigenDesocupacion> origenes;

	//uni-directional many-to-one association to DeudoresV
    @ManyToOne
	@JoinColumns({
		@JoinColumn(name="NUMERO_ID_DEUDOR", referencedColumnName="NUMERO_ID_DEUDOR", nullable=false),
		@JoinColumn(name="TIPO_ID_DEUDOR", referencedColumnName="TIPO_ID_DEUDOR", nullable=false)
		})
	private DeudoresV deudor;
    
    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_DESOCUPACION")
	private Date fechaDesocupacion;    
       
    public Date getFechaDesocupacion() {    	    	
		return fechaDesocupacion;
	}

	public void setFechaDesocupacion(Date fechaDesocupacion) {
		this.fechaDesocupacion = fechaDesocupacion;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}    
    
    public DeudoresV getDeudor() {
		return deudor;
	}
    
	public void setDeudor(DeudoresV deudor) {
		this.deudor = deudor;
	}
	
	public BigDecimal getValorRealDeuda() {
		return valorRealDeuda;
	}

	public void setValorRealDeuda(BigDecimal valorRealDeuda) {
		this.valorRealDeuda = valorRealDeuda;
	}

	public AlistamientosObligacionV() {
    }

	public BigDecimal getCodigoAlistamiento() {
		return this.codigoAlistamiento;
	}

	public void setCodigoAlistamiento(BigDecimal codigoAlistamiento) {
		this.codigoAlistamiento = codigoAlistamiento;
	}

	public BigDecimal getCodigoEstadoAlistamiento() {
		return this.codigoEstadoAlistamiento;
	}

	public void setCodigoEstadoAlistamiento(BigDecimal codigoEstadoAlistamiento) {
		this.codigoEstadoAlistamiento = codigoEstadoAlistamiento;
	}

	public String getNombreAlistamiento() {
		return this.nombreAlistamiento;
	}

	public void setNombreAlistamiento(String nombreAlistamiento) {
		this.nombreAlistamiento = nombreAlistamiento;
	}

	public String getNombreEstadoAlistamiento() {
		return this.nombreEstadoAlistamiento;
	}

	public void setNombreEstadoAlistamiento(String nombreEstadoAlistamiento) {
		this.nombreEstadoAlistamiento = nombreEstadoAlistamiento;
	}

	public BigDecimal getNumeroAlistamiento() {
		return this.numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}

	public BigDecimal getNumeroObligacion() {
		return this.numeroObligacion;
	}

	public void setNumeroObligacion(BigDecimal numeroObligacion) {
		this.numeroObligacion = numeroObligacion;
	}

	public BigDecimal getSecuenciaDeuda() {
		return this.secuenciaDeuda;
	}

	public void setSecuenciaDeuda(BigDecimal secuenciaDeuda) {
		this.secuenciaDeuda = secuenciaDeuda;
	}

	public String getAmparo() {
		return amparo;
	}

	public void setAmparo(String amparo) {
		this.amparo = amparo;
	}

	public String getEstadoSiniestro() {
		return estadoSiniestro;
	}

	public void setEstadoSiniestro(String estadoSiniestro) {
		this.estadoSiniestro = estadoSiniestro;
	}

	public String getInmobiliaria() {
		return inmobiliaria;
	}

	public void setInmobiliaria(String inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCausalCambio() {
		return causalCambio;
	}

	public void setCausalCambio(String causalCambio) {
		this.causalCambio = causalCambio;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getAbreviaturaEstado() {
		return abreviaturaEstado;
	}

	public void setAbreviaturaEstado(String abreviaturaEstado) {
		this.abreviaturaEstado = abreviaturaEstado;
	}

	public String getAreaEstado() {
		return areaEstado;
	}

	public void setAreaEstado(String areaEstado) {
		this.areaEstado = areaEstado;
	}

	public List<OrigenDesocupacion> getOrigenes() {
		return origenes;
	}

	public void setOrigenes(List<OrigenDesocupacion> origenes) {
		this.origenes = origenes;
	}	
	
	public Date getFechaSiniestro() {
		return fechaSiniestro;
	}

	public void setFechaSiniestro(Date fechaSiniestro) {
		this.fechaSiniestro = fechaSiniestro;
	}

	public String getVisibilidad() {
		return visibilidad;
	}

	public void setVisibilidad(String visibilidad) {
		this.visibilidad = visibilidad;
	}

	public String getEstadoPago() {
		return estadoPago;
	}

	public void setEstadoPago(String estadoPago) {
		this.estadoPago = estadoPago;
	}

	public String getPoderdante() {
		return poderdante;
	}

	public void setPoderdante(String poderdante) {
		this.poderdante = poderdante;
	}

	public BigDecimal getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(BigDecimal numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}
	
	public String getUltimaMora() {
		return ultimaMora;
	}

	public void setUltimaMora(String ultimaMora) {
		this.ultimaMora = ultimaMora;
	}

	public String getSucursalTxt() {
		return sucursalTxt;
	}

	public void setSucursalTxt(String sucursalTxt) {
		this.sucursalTxt = sucursalTxt;
	}

	public BigDecimal getValorCanon() {
		return valorCanon;
	}

	public void setValorCanon(BigDecimal valorCanon) {
		this.valorCanon = valorCanon;
	}

	public String getCodAmparo() {
		return codAmparo;
	}

	public void setCodAmparo(String codAmparo) {
		this.codAmparo = codAmparo;
	}

	public String getTipoPoliza() {
		return tipoPoliza;
	}

	public void setTipoPoliza(String tipoPoliza) {
		this.tipoPoliza = tipoPoliza;
	}

	public String getRetiroPoliza() {
		return retiroPoliza;
	}

	public void setRetiroPoliza(String retiroPoliza) {
		this.retiroPoliza = retiroPoliza;
	}

	public String getCodEstadoSiniestro() {
		return codEstadoSiniestro;
	}

	public void setCodEstadoSiniestro(String codEstadoSiniestro) {
		this.codEstadoSiniestro = codEstadoSiniestro;
	}

	public String getAreaAlistamiento() {
		return areaAlistamiento;
	}

	public void setAreaAlistamiento(String areaAlistamiento) {
		this.areaAlistamiento = areaAlistamiento;
	}

	
		
}