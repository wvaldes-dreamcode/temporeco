package sai.com.procesosJudiciales.alistamientos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Types;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.NamedStoredProcedureQueries;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;
import org.eclipse.persistence.annotations.StoredProcedureParameter;

import sai.com.procesosJudiciales.procesos.readOnly.Abogado;


/**
 * The persistent class for the REGISTROS_DOCUMENTO database table.
 * 
 */
@Entity
@Table(name="REGISTROS_DOCUMENTO")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "PrepararGeneracion", procedureName = "PKG_PLANTILLAS_DOCUMENTOS.PRC_CUALES_DOCUMENTOS", returnsResultSet = false, parameters = 
		{
				@StoredProcedureParameter(queryParameter = "V_ALISTAMIENTO", direction = Direction.IN, type = BigDecimal.class),
				@StoredProcedureParameter(queryParameter = "V_TIPO_DOCUMTOS", direction = Direction.IN, type = BigDecimal.class),				
				@StoredProcedureParameter(queryParameter = "P_DEVUELVE_DATOS", direction = Direction.OUT, type = String.class, jdbcType = Types.CLOB),
				@StoredProcedureParameter(queryParameter = "P_COD_ERROR", direction = Direction.OUT, type = String.class),
				@StoredProcedureParameter(queryParameter = "P_DESC_ERROR", direction = Direction.OUT, type = String.class) 
		}
	),
	@NamedStoredProcedureQuery(name = "PrepararGeneracionMail", procedureName = "PKG_PLANTILLAS_DOCUMENTOS.PRC_DOCUMENTOS_MAIL", returnsResultSet = false, parameters = 
		{
				@StoredProcedureParameter(queryParameter = "V_ALISTAMIENTO", direction = Direction.IN, type = BigDecimal.class),
				@StoredProcedureParameter(queryParameter = "V_TIPO_DOCUMTOS", direction = Direction.IN, type = BigDecimal.class),				
				@StoredProcedureParameter(queryParameter = "P_DEVUELVE_DATOS", direction = Direction.OUT, type = String.class, jdbcType = Types.CLOB),
				@StoredProcedureParameter(queryParameter = "P_DATOS_ENVIO_MAIL", direction = Direction.OUT, type = String.class),
				@StoredProcedureParameter(queryParameter = "P_COD_ERROR", direction = Direction.OUT, type = String.class),
				@StoredProcedureParameter(queryParameter = "P_DESC_ERROR", direction = Direction.OUT, type = String.class) 
		}
	)
})
public class RegistrosDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECUENCIA_REGISTRO_GENERATOR", sequenceName="SECUENCIA_REG_DOCUMTOS", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECUENCIA_REGISTRO_GENERATOR")
	@Column(name="SECUENCIA_REGISTRO")
	private BigDecimal secuenciaRegistro;

	/*@Column(name="ABOGADO_INICIAL")
	private BigDecimal abogadoInicial;*/
	
	@JoinColumn(name = "ABOGADO_ACTUAL", referencedColumnName = "SEC_ABOGADO")
	private Abogado abogadoActual;
	
	@JoinColumn(name = "ABOGADO_ANTERIOR", referencedColumnName = "SEC_ABOGADO")
	private Abogado abogadoAnterior;
	
	@Column(name="AREA_GENERACION")
	private String areaGeneracion;
	
	@JoinColumn(name="CENTRO_CONCILIACION", referencedColumnName="SECUENCIA_CENTRO")
	private CentrosConciliacion centroConciliacion;

	@Column(name="COMPLEMENTO_DIRECCION")
	private String complementoDireccion;

	@Column(name="FECHA_FIN_PAGOS")
	private String fechaFinPagos;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_GENERACION")
	private Date fechaGeneracion;

	@Column(name="FECHA_INI_PAGOS")
	private String fechaIniPagos;

	@Column(name="GENERA_CARTA")
	private String generaCarta;

	@Column(name="GENERA_CERTI_PAGOS")
	private String generaCertiPagos;

	@Column(name="GENERA_PODERES")
	private String generaPoderes;

	@Column(name="ID_ABOGADO_SOCIO")
	private BigDecimal abogadoAsociado;

	@Column(name="T_DOC_ABOGADO_SOCIO")
	private String tAbogadoSocio;
	
	@Column(name="TIPO_GENERACION")
	private String tipoGeneracion;
	
	@Transient
	private String compania;
	
	@Transient
	private String sucursal;
	
	@Column(name="NUMERO_ALISTAMIENTO")
	private BigDecimal numeroAlistamiento;

	@Column(name="USUARIO_GENERA")
	private String usuarioGenera;

    public RegistrosDocumento() {
    }

	public BigDecimal getSecuenciaRegistro() {
		return this.secuenciaRegistro;
	}

	public void setSecuenciaRegistro(BigDecimal secuenciaRegistro) {
		this.secuenciaRegistro = secuenciaRegistro;
	}	

	public String getAreaGeneracion() {
		return this.areaGeneracion;
	}

	public void setAreaGeneracion(String areaGeneracion) {
		this.areaGeneracion = areaGeneracion;
	}

	public CentrosConciliacion getCentroConciliacion() {
		return centroConciliacion;
	}

	public void setCentroConciliacion(CentrosConciliacion centroConciliacion) {
		this.centroConciliacion = centroConciliacion;
	}

	public String getComplementoDireccion() {
		return this.complementoDireccion;
	}

	public void setComplementoDireccion(String complementoDireccion) {
		this.complementoDireccion = complementoDireccion;
	}

	public String getFechaFinPagos() {
		return this.fechaFinPagos;
	}

	public void setFechaFinPagos(String fechaFinPagos) {
		this.fechaFinPagos = fechaFinPagos;
	}

	public Date getFechaGeneracion() {
		return this.fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public String getFechaIniPagos() {
		return this.fechaIniPagos;
	}

	public void setFechaIniPagos(String fechaIniPagos) {
		this.fechaIniPagos = fechaIniPagos;
	}

	public String getGeneraCarta() {
		return this.generaCarta;
	}

	public void setGeneraCarta(String generaCarta) {
		this.generaCarta = generaCarta;
	}

	public String getGeneraCertiPagos() {
		return this.generaCertiPagos;
	}

	public void setGeneraCertiPagos(String generaCertiPagos) {
		this.generaCertiPagos = generaCertiPagos;
	}

	public String getGeneraPoderes() {
		return this.generaPoderes;
	}

	public void setGeneraPoderes(String generaPoderes) {
		this.generaPoderes = generaPoderes;
	}

	public BigDecimal getNumeroAlistamiento() {
		return this.numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}

	public String getUsuarioGenera() {
		return this.usuarioGenera;
	}

	public void setUsuarioGenera(String usuarioGenera) {
		this.usuarioGenera = usuarioGenera;
	}

	public Abogado getAbogadoActual() {
		return abogadoActual;
	}

	public void setAbogadoActual(Abogado abogadoActual) {
		this.abogadoActual = abogadoActual;
	}

	public Abogado getAbogadoAnterior() {
		return abogadoAnterior;
	}

	public void setAbogadoAnterior(Abogado abogadoAnterior) {
		this.abogadoAnterior = abogadoAnterior;
	}

	public String getTipoGeneracion() {
		return tipoGeneracion;
	}

	public void setTipoGeneracion(String tipoGeneracion) {
		this.tipoGeneracion = tipoGeneracion;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public BigDecimal getAbogadoAsociado() {
		return abogadoAsociado;
	}

	public void setAbogadoAsociado(BigDecimal abogadoAsociado) {
		this.abogadoAsociado = abogadoAsociado;
	}

	public String gettAbogadoSocio() {
		return tAbogadoSocio;
	}

	public void settAbogadoSocio(String tAbogadoSocio) {
		this.tAbogadoSocio = tAbogadoSocio;
	}

}