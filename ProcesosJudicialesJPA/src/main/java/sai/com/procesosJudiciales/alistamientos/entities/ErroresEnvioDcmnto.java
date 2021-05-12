package sai.com.procesosJudiciales.alistamientos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the ERRORES_ENVIO_DCMNTOS database table.
 * 
 */

@Entity
@Table(name="ERRORES_ENVIO_DCMNTOS")
@NamedQuery(name="erroresEnvioByAlistamiento", query="select o from ErroresEnvioDcmnto o where o.numeroAlistamiento = :p_NoAlistamiento")
public class ErroresEnvioDcmnto implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "CODIGO_DOCUMENTO")
	private Documento codigoDocumento;

	@Column(name="DATO_ERRADO")
	private String datoErrado;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name="NUMERO_ALISTAMIENTO")
	private BigDecimal numeroAlistamiento;

	@Id
	@Column(name="SECUENCIA_ERROR_ENVIO")
	private BigDecimal secuenciaErrorEnvio;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

    public ErroresEnvioDcmnto() {
    }

    public Documento getCodigoDocumento() {
		return codigoDocumento;
	}
    
    public void setCodigoDocumento(Documento codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}
    
	public String getDatoErrado() {
		return this.datoErrado;
	}

	public void setDatoErrado(String datoErrado) {
		this.datoErrado = datoErrado;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public BigDecimal getNumeroAlistamiento() {
		return this.numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}

	public BigDecimal getSecuenciaErrorEnvio() {
		return this.secuenciaErrorEnvio;
	}

	public void setSecuenciaErrorEnvio(BigDecimal secuenciaErrorEnvio) {
		this.secuenciaErrorEnvio = secuenciaErrorEnvio;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

}