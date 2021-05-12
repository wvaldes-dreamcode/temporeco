package sai.com.procesosJudiciales.alistamientos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.NamedStoredProcedureQueries;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;
import org.eclipse.persistence.annotations.StoredProcedureParameter;

import sai.com.procesosJudiciales.alistamientos.readOnly.CausalEstado;


/**
 * The persistent class for the CAUSAL_DEVOLUCION_ALISTA database table.
 * 
 */
@Entity
@Table(name="CAUSAL_DEVOLUCION_ALISTA")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "enviarCorreoNovedad", procedureName = "PKG_NOVEDADES.PRC_COPIA_CAUSALES_ALISTA", returnsResultSet = false, parameters = 
		{
				@StoredProcedureParameter(queryParameter = "P_SEQ_CAUSAL", direction = Direction.IN, type = BigDecimal.class),				
				@StoredProcedureParameter(queryParameter = "P_COD_ERROR", direction = Direction.OUT, type = BigDecimal.class),
				@StoredProcedureParameter(queryParameter = "P_DESC_ERROR", direction = Direction.OUT, type = String.class) 
		}
	)
})
public class CausalEstadoAlistamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECUENCIA_CAUSAL_GENERATOR", sequenceName="SECUENCIA_CAUSAL_DEV_ALIT", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECUENCIA_CAUSAL_GENERATOR")
	@Column(name="SECUENCIA_CAUSAL_DEV_ALIT")
	private BigDecimal secuenciaCausal;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="NUMERO_ALISTAMIENTO")
	private BigDecimal numeroAlistamiento;
	
	@ManyToOne
	@JoinColumn(name="SECUENCIA_NOVEDAD", referencedColumnName="SECUENCIA_NOVEDAD", nullable=false)
	private CausalEstado causal;
	
	@ManyToOne
	@JoinColumn(name="CODIGO_ESTADO_ALISTAMIENTO")
	private EstadosAlistamiento estadoAlistamiento;	

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION")
	private String usuarioModificacion;
	
	@Column(name="ESTADO_CAUSAL")
	private String estado;
	
	@Column(name="SECUENCIA_HIS_ALISTAMIENTO")
	private BigDecimal secuenciaHisAlista;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="SECUENCIA_CAUSAL_DEV_ALIT")
	private List<DatosCausalEstadoAlistamiento> datosAsociados;     

    public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public CausalEstadoAlistamiento() {
    }

	public BigDecimal getSecuenciaCausal() {
		return this.secuenciaCausal;
	}

	public void setSecuenciaCausal(BigDecimal secuenciaCausal) {
		this.secuenciaCausal = secuenciaCausal;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public BigDecimal getNumeroAlistamiento() {
		return this.numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}


	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public CausalEstado getCausal() {
		return causal;
	}

	public void setCausal(CausalEstado causal) {
		this.causal = causal;
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

	public EstadosAlistamiento getEstadoAlistamiento() {
		return estadoAlistamiento;
	}

	public void setEstadoAlistamiento(EstadosAlistamiento estadoAlistamiento) {
		this.estadoAlistamiento = estadoAlistamiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<DatosCausalEstadoAlistamiento> getDatosAsociados() {
		return datosAsociados;
	}

	public void setDatosAsociados(List<DatosCausalEstadoAlistamiento> datosAsociados) {
		this.datosAsociados = datosAsociados;
	}

	public BigDecimal getSecuenciaHisAlista() {
		return secuenciaHisAlista;
	}

	public void setSecuenciaHisAlista(BigDecimal secuenciaHisAlista) {
		this.secuenciaHisAlista = secuenciaHisAlista;
	}	
	
}