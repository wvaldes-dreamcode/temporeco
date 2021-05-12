package sai.com.procesosJudiciales.titulos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * The persistent class for the ESTADOS_PREVIOS_DOCUMENTOS database table.
 * 
 */
@Entity
@Table(name="ESTADOS_PREVIOS_DOCUMENTOS")
public class EstadoPrevioDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESTADOS_PREVIOS_DOCUMENTOS_SECUENCIA_GENERATOR", sequenceName="SEQ_ESTADO_PREVIO", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADOS_PREVIOS_DOCUMENTOS_SECUENCIA_GENERATOR")
	@Column(unique=true, nullable=false, precision=15)
	private BigDecimal secuencia;

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

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SECUENCIA_ESTADO_DOCUMENTO", nullable=false)	
	private EstadoDocumentoJudicial estadoDocumento;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SECUENCIA_ESTADO_DCMNTO_PRV", nullable=false)
	private EstadoDocumentoJudicial estadoPrevio;
    
	@Column(name="SECUENCIA_ESTADO_DCMNTO_PRV", length=30, insertable=false, updatable=false)
    private BigDecimal estadoPrevioNmbr;



    public EstadoPrevioDocumento() {
    }

	public BigDecimal getSecuencia() {
		return this.secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
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
    
	public EstadoDocumentoJudicial getEstadoPrevio() {
		return this.estadoPrevio;
	}

	public void setEstadoPrevio(EstadoDocumentoJudicial estadoPrevio) {
		this.estadoPrevio = estadoPrevio;
	}
	
	public BigDecimal getEstadoPrevioNmbr() {
		return this.estadoPrevioNmbr;
	}
		 
	public void setEstadoPrevioNmbr(BigDecimal estadoPrevioNmbr) {
		this.estadoPrevioNmbr = estadoPrevioNmbr;
	}
	
	public EstadoDocumentoJudicial getEstadoDocumento() {
		return this.estadoDocumento;
	}

	public void setEstadoDocumento(EstadoDocumentoJudicial estadoDocumento) {
		this.estadoDocumento = estadoDocumento;
	}
	
}