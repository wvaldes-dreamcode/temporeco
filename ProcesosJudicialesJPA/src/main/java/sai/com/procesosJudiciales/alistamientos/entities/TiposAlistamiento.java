package sai.com.procesosJudiciales.alistamientos.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.NamedStoredProcedureQueries;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;
import org.eclipse.persistence.annotations.StoredProcedureParameter;


/**
 * The persistent class for the TIPOS_ALISTAMIENTO database table.
 * 
 */
@Entity
@Table(name="TIPOS_ALISTAMIENTO")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "trasladarAlistamiento", procedureName = "Pkg_Alistamiento.Prc_TrasladoAlstmnto", returnsResultSet = false, parameters = 
		{
			@StoredProcedureParameter(queryParameter = "p_NoAlistamiento", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "p_TipoAlstmnto", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "p_CausalTraslado", direction = Direction.IN, type = String.class),
			@StoredProcedureParameter(queryParameter = "p_Usuario", direction = Direction.IN, type = String.class),
			@StoredProcedureParameter(queryParameter = "p_CodError", direction = Direction.OUT, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "p_DescError", direction = Direction.OUT, type = String.class) 
		}
	),
	@NamedStoredProcedureQuery(name = "actualizaDocumentos", procedureName = "Pkg_Alistamiento.prc_CambiaDocmAlstmnto", returnsResultSet = false, parameters = 
		{
			@StoredProcedureParameter(queryParameter = "p_NoAlstmnto", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "p_Usuario", direction = Direction.IN, type = String.class),
			@StoredProcedureParameter(queryParameter = "p_CodError", direction = Direction.OUT, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "p_DescError", direction = Direction.OUT, type = String.class)
			
		}
	)
})//
public class TiposAlistamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODIGO_ALISTAMIENTO", unique=true, nullable=false, precision=15)
	private BigDecimal codigoAlistamiento;

	@Column(length=2)
	private String abreviacion;

	@Column(name="CLASIFICACION_ALISTAMIENTO", nullable=false, length=60)
	private String clasificacionAlistamiento;

	@Column(name="ESTADO_INMUEBLE", length=1)
	private String estadoInmueble;


	@Column(name="NOMBRE_ALISTAMIENTO", nullable=false, length=120)
	private String nombreAlistamiento;


	@Column(name="ESTADO_PARAMETRICA", nullable=false, length=1)
	private String estado;


	@Column(length=1)
	private String subrogado;

	public TiposAlistamiento() {
	}

	public BigDecimal getCodigoAlistamiento() {
		return this.codigoAlistamiento;
	}

	public void setCodigoAlistamiento(BigDecimal codigoAlistamiento) {
		this.codigoAlistamiento = codigoAlistamiento;
	}

	public String getAbreviacion() {
		return this.abreviacion;
	}

	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}

	public String getClasificacionAlistamiento() {
		return this.clasificacionAlistamiento;
	}

	public void setClasificacionAlistamiento(String clasificacionAlistamiento) {
		this.clasificacionAlistamiento = clasificacionAlistamiento;
	}

	public String getEstadoInmueble() {
		return this.estadoInmueble;
	}

	public void setEstadoInmueble(String estadoInmueble) {
		this.estadoInmueble = estadoInmueble;
	}

	public String getNombreAlistamiento() {
		return this.nombreAlistamiento;
	}

	public void setNombreAlistamiento(String nombreAlistamiento) {
		this.nombreAlistamiento = nombreAlistamiento;
	}

	public String getSubrogado() {
		return this.subrogado;
	}

	public void setSubrogado(String subrogado) {
		this.subrogado = subrogado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}