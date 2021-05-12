package sai.com.procesosJudiciales.alistamientos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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

import sai.com.procesosJudiciales.novedades.readOnly.DatosAsociado;


/**
 * The persistent class for the DATOS_CAU_DEV_ALI database table.
 * 
 */
@Entity
@Table(name="DATOS_CAU_DEV_ALI")
public class DatosCausalEstadoAlistamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DATOS_CAU_DEV_ALI_SECUENCIA_GENERATOR", sequenceName="SECUENCIA_DATOS_CAU_DEV_ALI", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DATOS_CAU_DEV_ALI_SECUENCIA_GENERATOR")
	@Column(name="SECUENCIA_DATOS_CAU_DEV_ALI", unique=true, nullable=false, precision=15)
	private BigDecimal secuencia;

	@Column(name="CONTENIDO_DATO", length=100)
	private String contenidoDato;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	/*@Column(name="SECUENCIA_CAUSAL_DEV_ALIT", nullable=false, precision=15)
	private BigDecimal secuenciaCausalDevAlit;*/
    @JoinColumn(name="SECUENCIA_CAUSAL_DEV_ALIT", referencedColumnName ="SECUENCIA_CAUSAL_DEV_ALIT")
	private CausalEstadoAlistamiento causalEstado;

	/*@Column(name="SECUENCIA_DATO_ASOCIADO", nullable=false, precision=15)
	private BigDecimal secuenciaDatoAsociado;*/
	
	@JoinColumn(name="SECUENCIA_DATO_ASOCIADO", referencedColumnName ="SECUENCIA_DATO_ASOCIADO")
	private DatosAsociado datoAsociado;

	@Column(name="USUARIO_CREACION", length=30)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=30)
	private String usuarioModificacion;

    public DatosCausalEstadoAlistamiento() {
    }

	public BigDecimal getSecuencia() {
		return this.secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	public String getContenidoDato() {
		return this.contenidoDato;
	}

	public void setContenidoDato(String contenidoDato) {
		this.contenidoDato = contenidoDato;
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

	public CausalEstadoAlistamiento getCausalEstado() {
		return causalEstado;
	}

	public void setCausalEstado(CausalEstadoAlistamiento causalEstado) {
		this.causalEstado = causalEstado;
	}

	public DatosAsociado getDatoAsociado() {
		return datoAsociado;
	}

	public void setDatoAsociado(DatosAsociado datoAsociado) {
		this.datoAsociado = datoAsociado;
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

}