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
 * The persistent class for the PERIODO_DOCUMENTO_JUDICIAL database table.
 * 
 */
@Entity
@Table(name="PERIODO_DOCUMENTO_JUDICIAL")
public class PeriodoDocumentoJudicial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERIODO_DOCUMENTO_JUDICIAL_SECUENCIAPERIODO_GENERATOR", sequenceName="SEQ_PERIODOS", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERIODO_DOCUMENTO_JUDICIAL_SECUENCIAPERIODO_GENERATOR")
	@Column(name="SECUENCIA_PERIODO", unique=true, nullable=false, precision=15)
	private BigDecimal secuenciaPeriodo;

	@Column(nullable=false, precision=4)
	private BigDecimal ano;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(nullable=false, precision=2)
	private BigDecimal mes;

	@ManyToOne  
	@JoinColumn(name="SECUENCIA_MOVIMIENTO_JUDICIAL" )
	private MovimientoDocumentoJudicial movimientoDocumento;	

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=30)
	private String usuarioModificacion;

    public PeriodoDocumentoJudicial() {
    }

	public BigDecimal getSecuenciaPeriodo() {
		return this.secuenciaPeriodo;
	}

	public void setSecuenciaPeriodo(BigDecimal secuenciaPeriodo) {
		this.secuenciaPeriodo = secuenciaPeriodo;
	}

	public BigDecimal getAno() {
		return this.ano;
	}

	public void setAno(BigDecimal ano) {
		this.ano = ano;
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

	public BigDecimal getMes() {
		return this.mes;
	}

	public void setMes(BigDecimal mes) {
		this.mes = mes;
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

}