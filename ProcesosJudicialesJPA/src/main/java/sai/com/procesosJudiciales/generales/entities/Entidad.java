package sai.com.procesosJudiciales.generales.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the ENTIDADES database table.
 * 
 */
@Entity
@Table(name="ENTIDADES")
@NamedQuery(name = "Entidades", query = "select e from Entidad e order by e.descEntidad")
public class Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SECUENCIA_ENTIDAD", unique=true, nullable=false, precision=15)
	private BigDecimal secuenciaEntidad;

	@Column(name="DESC_ENTIDAD", nullable=false, length=200)
	private String descEntidad;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="NUMERO_ID_ENTIDAD", nullable=false, precision=22)
	private BigDecimal numeroIdEntidad;

	@Column(name="TIPO_ID_ENTIDAD", nullable=false, length=3)
	private String tipoIdEntidad;

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=30)
	private String usuarioModificacion;

    public Entidad() {
    }

	public BigDecimal getSecuenciaEntidad() {
		return this.secuenciaEntidad;
	}

	public void setSecuenciaEntidad(BigDecimal secuenciaEntidad) {
		this.secuenciaEntidad = secuenciaEntidad;
	}

	public String getDescEntidad() {
		return this.descEntidad;
	}

	public void setDescEntidad(String descEntidad) {
		this.descEntidad = descEntidad;
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

	public BigDecimal getNumeroIdEntidad() {
		return this.numeroIdEntidad;
	}

	public void setNumeroIdEntidad(BigDecimal numeroIdEntidad) {
		this.numeroIdEntidad = numeroIdEntidad;
	}

	public String getTipoIdEntidad() {
		return this.tipoIdEntidad;
	}

	public void setTipoIdEntidad(String tipoIdEntidad) {
		this.tipoIdEntidad = tipoIdEntidad;
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