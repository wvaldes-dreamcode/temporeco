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
 * The persistent class for the MOVIMIENTO_CAUSAL_DEVOLUCION database table.
 * 
 */
@Entity
@Table(name="MOVIMIENTO_CAUSAL_DEVOLUCION")
public class MovimientoCausalDevolucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOVIMIENTO_CAUSAL_DEVOLUCION_SECUENCIAMOVIMIENTOCAUSAL_GENERATOR", sequenceName="SEQ_MVMNT_CSAL_DV", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOVIMIENTO_CAUSAL_DEVOLUCION_SECUENCIAMOVIMIENTOCAUSAL_GENERATOR")
	@Column(name="SECUENCIA_MOVIMIENTO_CAUSAL", unique=true, nullable=false, precision=10)
	private BigDecimal secuenciaMovimientoCausal;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

	@Column(name="FECHA_MODIFICACION", length=50)
	private String fechaModificacion;
	
	@ManyToOne
	@JoinColumn(name="SECUENCIA_CAUSAL")
	private CausalDevolucion causal;

	@ManyToOne
	@JoinColumn(name="SECUENCIA_MOVIMIENTO_JUDICIAL")
	private MovimientoDocumentoJudicial movimientoDocumento;

	@Column(name="USUARIO_CREACION", nullable=false, length=20)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=40)
	private String usuarioModificacion;
    
	//-------------------------------------------------------------------------------------------
	
    public MovimientoCausalDevolucion() {
    }   
    
	public BigDecimal getSecuenciaMovimientoCausal() {
		return this.secuenciaMovimientoCausal;
	}

	public void setSecuenciaMovimientoCausal(BigDecimal secuenciaMovimientoCausal) {
		this.secuenciaMovimientoCausal = secuenciaMovimientoCausal;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public CausalDevolucion getCausal() {
		return causal;
	}

	public void setCausal(CausalDevolucion causal) {
		this.causal = causal;
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