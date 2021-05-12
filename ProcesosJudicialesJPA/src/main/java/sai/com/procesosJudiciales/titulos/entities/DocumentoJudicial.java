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
 * The persistent class for the DOCUMENTO_JUDICIAL database table.
 * 
 */
@Entity
@Table(name="DOCUMENTO_JUDICIAL")
public class DocumentoJudicial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DOCUMENTO_JUDICIAL_SECUENCIADOCUMENTOJUDICIAL_GENERATOR", sequenceName="SEQ_DOC_JDCIAL", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCUMENTO_JUDICIAL_SECUENCIADOCUMENTOJUDICIAL_GENERATOR")
	@Column(name="SECUENCIA_DOCUMENTO_JUDICIAL", unique=true, nullable=false, precision=15)
	private BigDecimal secuenciaDocumentoJudicial;

	@Column(nullable=false, length=2)
	private String abreviatura;

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

	
    public DocumentoJudicial() {
    }

	public BigDecimal getSecuenciaDocumentoJudicial() {
		return this.secuenciaDocumentoJudicial;
	}

	public void setSecuenciaDocumentoJudicial(BigDecimal secuenciaDocumentoJudicial) {
		this.secuenciaDocumentoJudicial = secuenciaDocumentoJudicial;
	}

	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
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