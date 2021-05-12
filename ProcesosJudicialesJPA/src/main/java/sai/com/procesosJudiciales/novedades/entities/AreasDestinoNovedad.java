package sai.com.procesosJudiciales.novedades.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the AREAS_DESTINO_NOVEDAD database table.
 * 
 */
@Entity
@Table(name="AREAS_DESTINO_NOVEDAD")
public class AreasDestinoNovedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SECUENCIA_AREA_DESTINO")
	private BigDecimal secuenciaAreaDestino;

	@Column(name="CDGO_AREA_DESTINO")
	private String cdgoAreaDestino;

	@Column(name="CDGO_CIA_DESTINO")
	private String cdgoCiaDestino;

	@Column(name="CDGO_USR_RESPONSABLE")
	private String cdgoUsrResponsable;

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

	//bi-directional many-to-one association to NovedadesObligacione
   /* @ManyToOne
	@JoinColumn(name="CODIGO_NOVEDAD")
	private NovedadesObligacione novedadesObligacione;*/

    public AreasDestinoNovedad() {
    }

	public BigDecimal getSecuenciaAreaDestino() {
		return this.secuenciaAreaDestino;
	}

	public void setSecuenciaAreaDestino(BigDecimal secuenciaAreaDestino) {
		this.secuenciaAreaDestino = secuenciaAreaDestino;
	}

	public String getCdgoAreaDestino() {
		return this.cdgoAreaDestino;
	}

	public void setCdgoAreaDestino(String cdgoAreaDestino) {
		this.cdgoAreaDestino = cdgoAreaDestino;
	}

	public String getCdgoCiaDestino() {
		return this.cdgoCiaDestino;
	}

	public void setCdgoCiaDestino(String cdgoCiaDestino) {
		this.cdgoCiaDestino = cdgoCiaDestino;
	}

	public String getCdgoUsrResponsable() {
		return this.cdgoUsrResponsable;
	}

	public void setCdgoUsrResponsable(String cdgoUsrResponsable) {
		this.cdgoUsrResponsable = cdgoUsrResponsable;
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

/*	public NovedadesObligacione getNovedadesObligacione() {
		return this.novedadesObligacione;
	}

	public void setNovedadesObligacione(NovedadesObligacione novedadesObligacione) {
		this.novedadesObligacione = novedadesObligacione;
	}
	*/
}