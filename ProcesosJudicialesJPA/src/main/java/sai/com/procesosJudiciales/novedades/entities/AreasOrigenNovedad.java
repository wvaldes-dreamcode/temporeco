package sai.com.procesosJudiciales.novedades.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * The persistent class for the AREAS_ORIGEN_NOVEDAD database table.
 * 
 */
@Entity
@Table(name="AREAS_ORIGEN_NOVEDAD")
public class AreasOrigenNovedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SECUENCIA_AREA_ORIGEN")
	private BigDecimal secuenciaAreaOrigen;

	@Column(name="CDGO_AREA_ORIGEN")
	private String cdgoAreaOrigen;

	@Column(name="CDGO_CIA_ORIGEN")
	private String cdgoCiaOrigen;

	@Column(name="COD_USR_SOLICITANTE")
	private String codUsrSolicitante;

	@Column(name="CODIGO_CARGO")
	private BigDecimal codigoCargo;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION")
	private String usuarioModificacion;

	
   @ManyToOne
	@JoinColumn(name="CODIGO_NOVEDAD")
	private Novedad novedad;

    public AreasOrigenNovedad() {
    }

	public BigDecimal getSecuenciaAreaOrigen() {
		return this.secuenciaAreaOrigen;
	}

	public void setSecuenciaAreaOrigen(BigDecimal secuenciaAreaOrigen) {
		this.secuenciaAreaOrigen = secuenciaAreaOrigen;
	}

	public String getCdgoAreaOrigen() {
		return this.cdgoAreaOrigen;
	}

	public void setCdgoAreaOrigen(String cdgoAreaOrigen) {
		this.cdgoAreaOrigen = cdgoAreaOrigen;
	}

	public String getCdgoCiaOrigen() {
		return this.cdgoCiaOrigen;
	}

	public void setCdgoCiaOrigen(String cdgoCiaOrigen) {
		this.cdgoCiaOrigen = cdgoCiaOrigen;
	}

	public String getCodUsrSolicitante() {
		return this.codUsrSolicitante;
	}

	public void setCodUsrSolicitante(String codUsrSolicitante) {
		this.codUsrSolicitante = codUsrSolicitante;
	}

	public BigDecimal getCodigoCargo() {
		return this.codigoCargo;
	}

	public void setCodigoCargo(BigDecimal codigoCargo) {
		this.codigoCargo = codigoCargo;
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

	public Novedad getNovedad() {
		return novedad;
	}

	public void setNovedad(Novedad novedad) {
		this.novedad = novedad;
	}


	
}