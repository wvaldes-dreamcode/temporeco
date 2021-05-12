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
 * The persistent class for the RESPONSABLE_DOCUMENTO_JUDICIAL database table.
 * 
 */
@Entity
@Table(name="RESPONSABLE_DOCUMENTO_JUDICIAL")
public class ResponsableDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESPONSABLE_DOCUMENTO_JUDICIAL_SECUENCIARESPONSABLE_GENERATOR", sequenceName="SEQ_RSPNSBLE_DCMNTO_JDCIAL", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESPONSABLE_DOCUMENTO_JUDICIAL_SECUENCIARESPONSABLE_GENERATOR")
	@Column(name="SECUENCIA_RESPONSABLE_DOC", unique=true, nullable=false, precision=15)
	private BigDecimal secuenciaResponsable;

	@Column(name="ABREVIACION", nullable=false, length=10)
	private String abreviatura;

	@Column(nullable=false, length=20)
	private String descripcion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

	@Column(name="FECHA_MODIFICACION", length=240)
	private String fechaModificacion;

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=30)
	private String usuarioModificacion;

	@Column(name="ESTADO")
	private String estado;	
	
    public ResponsableDocumento() {
    }

	public BigDecimal getSecuenciaResponsable() {
		return this.secuenciaResponsable;
	}

	public void setSecuenciaResponsable(BigDecimal secuenciaResponsable) {
		this.secuenciaResponsable = secuenciaResponsable;
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

	public String getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
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