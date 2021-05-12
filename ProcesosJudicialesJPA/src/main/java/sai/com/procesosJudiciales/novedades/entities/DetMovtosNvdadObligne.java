package sai.com.procesosJudiciales.novedades.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the DET_MOVTOS_NVDAD_OBLIGNES database table.
 * 
 */
@Entity
@Table(name="DET_MOVTOS_NVDAD_OBLIGNES")
public class DetMovtosNvdadObligne implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetMovtosNvdadOblignePK id;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="NUMERO_OBLIGACION")
	private BigDecimal numeroObligacion;

	@Column(name="SECUENCIA_DEUDA")
	private BigDecimal secuenciaDeuda;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION")
	private String usuarioModificacion;

	//uni-directional many-to-one association to MovimientosNovedade
   /* @ManyToOne
	@JoinColumn(name="SECUENCIA_MOVIMIENTO_NOVEDAD")
	private MovimientosNovedade movimientosNovedade;*/

    public DetMovtosNvdadObligne() {
    }

	public DetMovtosNvdadOblignePK getId() {
		return this.id;
	}

	public void setId(DetMovtosNvdadOblignePK id) {
		this.id = id;
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

	/*public MovimientosNovedade getMovimientosNovedade() {
		return this.movimientosNovedade;
	}

	public void setMovimientosNovedade(MovimientosNovedade movimientosNovedade) {
		this.movimientosNovedade = movimientosNovedade;
	}*/
	
}