package sai.com.procesosJudiciales.alistamientos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.NamedStoredProcedureQueries;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;
import org.eclipse.persistence.annotations.StoredProcedureParameter;


/**
 * The persistent class for the ESTADOS_ALISTAMIENTO database table.
 * 
 */
@Entity
@Table(name="ESTADOS_ALISTAMIENTO")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "cambiarEstado", procedureName = "Pkg_Alistamiento.prc_cmbia_estdo_alstmsto", returnsResultSet = false, parameters = 
		{
			@StoredProcedureParameter(queryParameter = "PNUMERO_ALISTAMIENTO", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "PESTADO_NUEVO", direction = Direction.IN, type = BigDecimal.class),				
			@StoredProcedureParameter(queryParameter = "PUSUARIO", direction = Direction.IN, type = String.class),
			@StoredProcedureParameter(queryParameter = "PCODIGO_ERROR", direction = Direction.OUT, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "PMENSAJE", direction = Direction.OUT, type = String.class) 
		}),
		@NamedStoredProcedureQuery(name = "reactivarAlistamiento", procedureName = "Pkg_Alistamiento.prc_ReactivaAlstmnto", returnsResultSet = false, parameters = 
		{
				@StoredProcedureParameter(queryParameter = "p_NoAlistamiento", direction = Direction.IN, type = BigDecimal.class),				
				@StoredProcedureParameter(queryParameter = "p_Justificacion", direction = Direction.IN, type = String.class),
				@StoredProcedureParameter(queryParameter = "p_Usuario", direction = Direction.IN, type = String.class),
				@StoredProcedureParameter(queryParameter = "p_CodError", direction = Direction.OUT, type = BigDecimal.class),
				@StoredProcedureParameter(queryParameter = "p_DescError", direction = Direction.OUT, type = String.class) 
		}),
		@NamedStoredProcedureQuery(name = "cambioEstadoAutomatico", procedureName = "Pkg_Alistamiento.Prc_CambioEstadoAutmatico", returnsResultSet = false, parameters = 
		{
						@StoredProcedureParameter(queryParameter = "p_NoAlstmnto", direction = Direction.IN, type = BigDecimal.class),				
						@StoredProcedureParameter(queryParameter = "p_Usuario", direction = Direction.IN, type = String.class),						
						@StoredProcedureParameter(queryParameter = "p_CodError", direction = Direction.OUT, type = BigDecimal.class),
						@StoredProcedureParameter(queryParameter = "p_DescError", direction = Direction.OUT, type = String.class) 
		}),
		@NamedStoredProcedureQuery(name = "actualizacionFechaEntregaAbogado", procedureName = "Pkg_Alistamiento.prc_ActlzaFchaEntrgaAbgdo", returnsResultSet = false, parameters = 
		{
						@StoredProcedureParameter(queryParameter = "p_NoAlistamiento", direction = Direction.IN, type = BigDecimal.class),				
						@StoredProcedureParameter(queryParameter = "p_FechaEntrega", direction = Direction.IN, type = Date.class),						
						@StoredProcedureParameter(queryParameter = "p_CodError", direction = Direction.OUT, type = BigDecimal.class),
						@StoredProcedureParameter(queryParameter = "p_DescError", direction = Direction.OUT, type = String.class) 
		})
})
public class EstadosAlistamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODIGO_ESTADO_ALISTAMIENTO", unique=true, nullable=false, precision=15)
	private BigDecimal codigoEstadoAlistamiento;

	@Column(name="CODIGO_COMPANIA", length=2)
	private String codigoCompania;

	@Column(name="CODIGO_UBICACION_DEUDA", length=3)
	private String codigoUbicacionDeuda;

	@Column(name="NOMBRE_ESTADO_ALISTAMIENTO", nullable=false, length=120)
	private String nombreEstadoAlistamiento;

	@Column(name="ORIGEN_ESTADO", nullable=false, length=3)
	private String origenEstado;

	@Column(name="ABREVIACION", nullable=false, length=120)
	private String abreviatura;	

	@Column(name="AREA", length=1)
	private String area;

	@Column(name="VISIBILIDAD", length=1)
	private String visibilidad;
	
	@Column(name="ESTADO_PARAMETRICA", length=1)
	private String estado;

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public EstadosAlistamiento() {
	}

	public BigDecimal getCodigoEstadoAlistamiento() {
		return this.codigoEstadoAlistamiento;
	}

	public void setCodigoEstadoAlistamiento(BigDecimal codigoEstadoAlistamiento) {
		this.codigoEstadoAlistamiento = codigoEstadoAlistamiento;
	}

	public String getCodigoCompania() {
		return this.codigoCompania;
	}

	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getCodigoUbicacionDeuda() {
		return this.codigoUbicacionDeuda;
	}

	public void setCodigoUbicacionDeuda(String codigoUbicacionDeuda) {
		this.codigoUbicacionDeuda = codigoUbicacionDeuda;
	}

	public String getNombreEstadoAlistamiento() {
		return this.nombreEstadoAlistamiento;
	}

	public void setNombreEstadoAlistamiento(String nombreEstadoAlistamiento) {
		this.nombreEstadoAlistamiento = nombreEstadoAlistamiento;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getOrigenEstado() {
		return origenEstado;
	}

	public void setOrigenEstado(String origenEstado) {
		this.origenEstado = origenEstado;
	}

	public String getVisibilidad() {
		return visibilidad;
	}

	public void setVisibilidad(String visibilidad) {
		this.visibilidad = visibilidad;
	}



}