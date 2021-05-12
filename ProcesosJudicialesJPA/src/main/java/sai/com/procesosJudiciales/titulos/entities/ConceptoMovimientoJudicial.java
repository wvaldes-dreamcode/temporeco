package sai.com.procesosJudiciales.titulos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the MOVIMIENTO_CONCEPTO_JUDICIAL database table.
 * 
 */
@Entity
@Table(name="MOVIMIENTO_CONCEPTO_JUDICIAL")
public class ConceptoMovimientoJudicial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOVIMIENTO_CONCEPTO_JUDICIAL_SECUENCIAMOVIMIENTOCONCEPTO_GENERATOR", sequenceName="SEQ_MVMNTO_CNCPTO_JDCIAL", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOVIMIENTO_CONCEPTO_JUDICIAL_SECUENCIAMOVIMIENTOCONCEPTO_GENERATOR")
	@Column(name="SECUENCIA_MOVIMIENTO_CONCEPTO", unique=true, nullable=false, precision=15)
	private BigDecimal secuenciaMovimientoConcepto;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;
	
	@ManyToOne
	@JoinColumn(name="SECUENCIA_CONCEPTO_DOCUMENTO")
	private ConceptoDocumentoJudicial concepto;
	
	
	
	@ManyToOne
	@JoinColumn(name="SECUENCIA_MOVIMIENTO_JUDICIAL")
	private MovimientoDocumentoJudicial movimientoDocumento;	
	

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=30)
	private String usuarioModificacion;

	@Column(name="VALOR_POR_CNCPTO", nullable=false, precision=18, scale=2)
	private BigDecimal valorPorCncpto;

    public ConceptoMovimientoJudicial() {
    }

	public BigDecimal getSecuenciaMovimientoConcepto() {
		return this.secuenciaMovimientoConcepto;
	}

	public void setSecuenciaMovimientoConcepto(BigDecimal secuenciaMovimientoConcepto) {
		this.secuenciaMovimientoConcepto = secuenciaMovimientoConcepto;
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
	
	public ConceptoDocumentoJudicial getConcepto() {
		return concepto;
	}

	public void setConcepto(ConceptoDocumentoJudicial concepto) {
		this.concepto = concepto;
	}

	public MovimientoDocumentoJudicial getMovimientoDocumento() {
		return movimientoDocumento;
	}

	public void setMovimientoDocumento(
			MovimientoDocumentoJudicial movimientoDocumento) {
		this.movimientoDocumento = movimientoDocumento;
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

	public BigDecimal getValorPorCncpto() {
		return this.valorPorCncpto;
	}

	public void setValorPorCncpto(BigDecimal valorPorCncpto) {
		this.valorPorCncpto = valorPorCncpto;
	}

}