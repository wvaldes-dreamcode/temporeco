package sai.com.procesosJudiciales.alistamientos.entities;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.NamedStoredProcedureQueries;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;
import org.eclipse.persistence.annotations.StoredProcedureParameter;


/**
 * The persistent class for the ALISTAMIENTOS database table.
 * 
 */
@Entity
@Table(name="ALISTAMIENTOS")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "manejaConciliacion", procedureName = "Pkg_Alistamiento.Prc_AlstmntoCnclcion", returnsResultSet = false, parameters = 
		{
				@StoredProcedureParameter(queryParameter = "p_NoAlistamiento", direction = Direction.IN, type = BigDecimal.class),
				@StoredProcedureParameter(queryParameter = "p_Conciliacion", direction = Direction.OUT, type = String.class)				
		}
	),
	@NamedStoredProcedureQuery(name = "desocuparInmueble", procedureName = "Pkg_Alistamiento.prc_DesocuparInmueble", returnsResultSet = false, parameters = 
{
	@StoredProcedureParameter(queryParameter = "p_NoAlstmnto", direction = Direction.IN, type = BigDecimal.class),
	@StoredProcedureParameter(queryParameter = "p_FechaDesocupa", direction = Direction.IN, type = Date.class),				
	@StoredProcedureParameter(queryParameter = "p_Usuario", direction = Direction.IN, type = String.class),			
	@StoredProcedureParameter(queryParameter = "p_CodError", direction = Direction.OUT, type = BigDecimal.class),
	@StoredProcedureParameter(queryParameter = "p_DescError", direction = Direction.OUT, type = String.class) 
}
)
})
public class Alistamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMERO_ALISTAMIENTO")
	private BigDecimal numeroAlistamiento;

	@Column(name="CAUSAL_DE_CAMBIO")
	private String causalDeCambio;

	@Column(name="CODIGO_ALISTAMIENTO")
	private BigDecimal codigoAlistamiento;

	@Column(name="CODIGO_ESTADO_ALISTAMIENTO")
	private BigDecimal codigoEstadoAlistamiento;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_ESTADO_ALISTAMIENTO")
	private Date fechaEstadoAlistamiento;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="NUMERO_ID_PODERDANTE")
	private BigDecimal numeroIdPoderdante;

	@Column(name="OBSERVACION_DOCUMENTOS")
	private String observacionDocumentos;

	@Column(name="TIPO_ID_PODERDANTE")
	private String tipoIdPoderdante;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION")
	private String usuarioModificacion;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "NUMERO_ALISTAMIENTO")
	private List<OrigenDesocupacion> origenes;
	
	
    public Alistamiento() {
    }

	public BigDecimal getNumeroAlistamiento() {
		return this.numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}

	public String getCausalDeCambio() {
		return this.causalDeCambio;
	}

	public void setCausalDeCambio(String causalDeCambio) {
		this.causalDeCambio = causalDeCambio;
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

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEstadoAlistamiento() {
		return this.fechaEstadoAlistamiento;
	}

	public void setFechaEstadoAlistamiento(Date fechaEstadoAlistamiento) {
		this.fechaEstadoAlistamiento = fechaEstadoAlistamiento;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public BigDecimal getNumeroIdPoderdante() {
		return this.numeroIdPoderdante;
	}

	public void setNumeroIdPoderdante(BigDecimal numeroIdPoderdante) {
		this.numeroIdPoderdante = numeroIdPoderdante;
	}

	public String getObservacionDocumentos() {
		return this.observacionDocumentos;
	}

	public void setObservacionDocumentos(String observacionDocumentos) {
		this.observacionDocumentos = observacionDocumentos;
	}

	public String getTipoIdPoderdante() {
		return this.tipoIdPoderdante;
	}

	public void setTipoIdPoderdante(String tipoIdPoderdante) {
		this.tipoIdPoderdante = tipoIdPoderdante;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public List<OrigenDesocupacion> getOrigenes() {		
		if(origenes == null){			
			origenes = new ArrayList<OrigenDesocupacion>();
		}		
		return origenes;
	}

	public void setOrigenes(List<OrigenDesocupacion> origenes) {
		this.origenes = origenes;
	}

	
	
}