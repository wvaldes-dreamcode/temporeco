package sai.com.procesosJudiciales.titulos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the CONCEPTO_DOCUMENTO_JUDICIAL database table.
 * 
 */
@Entity
@Table(name="CONCEPTO_DOCUMENTO_JUDICIAL")
public class ConceptoDocumentoJudicial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONCEPTO_DOCUMENTO_JUDICIAL_SECUENCIACONCEPTODOCUMENTO_GENERATOR", sequenceName="SEQ_CNCPTO_DCMNTO_JDIAL", allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONCEPTO_DOCUMENTO_JUDICIAL_SECUENCIACONCEPTODOCUMENTO_GENERATOR")
	@Column(name="SECUENCIA_CONCEPTO_DOCUMENTO", unique=true, nullable=false, precision=15)
	private BigDecimal secuenciaConceptoDocumento;

	@Column(nullable=false, length=20)
	private String descripcion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=30)
	private String usuarioModificacion;

	@Column(name="ESTADO")	
	private String estado;
	
	public ConceptoDocumentoJudicial() {
    }

	public BigDecimal getSecuenciaConceptoDocumento() {
		return this.secuenciaConceptoDocumento;
	}

	public void setSecuenciaConceptoDocumento(BigDecimal secuenciaConceptoDocumento) {
		this.secuenciaConceptoDocumento = secuenciaConceptoDocumento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}