package sai.com.procesosJudiciales.alistamientos.entities;

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
 * The persistent class for the DOCUMENTOS database table.
 * 
 */
@Entity
@Table(name="DOCUMENTOS")
public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODIGO_DOCUMENTO")
	private BigDecimal codigoDocumento;

	@Column(name="CLASE_DOCUMENTO")
	private String claseDocumento;	

	@Column(name="CODIGO_TAREA")
	private BigDecimal codigoTarea;

	@Column(name="ESTADO_PARAMETRICA")
	private String estadoParametrica;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="MARCA_ALISTAMIENTO")
	private String marcaAlistamiento;

	@Column(name="MARCA_AMPARO")
	private String marcaAmparo;

	@Column(name="NOMBRE_DOCUMENTO")
	private String nombreDocumento;

	private String obligatorio;

	@Column(name="TIPO_DOCUMENTO")
	private String tipoDocumento;

	@Column(name="TIPO_SOLICITUD")
	private String tipoSolicitud;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION")
	private String usuarioModificacion;

    public Documento() {
    }

	public BigDecimal getCodigoDocumento() {
		return this.codigoDocumento;
	}

	public void setCodigoDocumento(BigDecimal codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}

	public String getClaseDocumento() {
		return this.claseDocumento;
	}

	public void setClaseDocumento(String claseDocumento) {
		this.claseDocumento = claseDocumento;
	}

	public BigDecimal getCodigoTarea() {
		return this.codigoTarea;
	}

	public void setCodigoTarea(BigDecimal codigoTarea) {
		this.codigoTarea = codigoTarea;
	}

	public String getEstadoParametrica() {
		return this.estadoParametrica;
	}

	public void setEstadoParametrica(String estadoParametrica) {
		this.estadoParametrica = estadoParametrica;
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

	public String getMarcaAlistamiento() {
		return this.marcaAlistamiento;
	}

	public void setMarcaAlistamiento(String marcaAlistamiento) {
		this.marcaAlistamiento = marcaAlistamiento;
	}

	public String getMarcaAmparo() {
		return this.marcaAmparo;
	}

	public void setMarcaAmparo(String marcaAmparo) {
		this.marcaAmparo = marcaAmparo;
	}

	public String getNombreDocumento() {
		return this.nombreDocumento;
	}

	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}

	public String getObligatorio() {
		return this.obligatorio;
	}

	public void setObligatorio(String obligatorio) {
		this.obligatorio = obligatorio;
	}

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getTipoSolicitud() {
		return this.tipoSolicitud;
	}

	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
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