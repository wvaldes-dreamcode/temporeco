package sai.com.procesosJudiciales.ubicacion.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import sai.com.procesosJudiciales.generales.entities.AreaCmpnia;


/**
 * The persistent class for the UBICACION database table.
 * 
 */
@Entity
//@Table(name="UBICACION_JURIDICO")
public class Ubicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UBICACION_NUMEROUBICACION_GENERATOR", sequenceName="SEQ_UBICACION", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UBICACION_NUMEROUBICACION_GENERATOR")
	@Column(name="NUMERO_UBICACION")
	private BigDecimal numeroUbicacion;

	/*@Column(name="ACO_CDGO_AREA")
	private String acoCdgoArea;

	@Column(name="ACO_CDGO_CIA")
	private String acoCdgoCia;*/
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ACO_CDGO_AREA", referencedColumnName="ACO_CDGO_AREA"),
		@JoinColumn(name="ACO_CDGO_CIA", referencedColumnName="ACO_CDGO_CIA")
	})
	private AreaCmpnia area;
	
	private String descripcion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;
	
	@Column(name="EST_CUENTA")
	private String estadoCuenta;
	
	@Column(name="ABREVIATURA")
	private String abreviatura;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="USUARIO_MODIFICACION")
	private String usuarioModificacion;

	@Column(name="ESTADO_UBICACION")
	private String estadoUbicacion;

	
	/** funciones de getter y setter **/
    public String getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(String estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public Ubicacion() {
    }

	public BigDecimal getNumeroUbicacion() {
		return this.numeroUbicacion;
	}

	public void setNumeroUbicacion(BigDecimal numeroUbicacion) {
		this.numeroUbicacion = numeroUbicacion;
	}

	public AreaCmpnia getArea() {
		return area;
	}

	public void setArea(AreaCmpnia area) {
		this.area = area;
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

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public String getEstadoUbicacion() {
		return this.estadoUbicacion;
	}

	public void setEstadoUbicacion(String estadoUbicacion) {
		this.estadoUbicacion = estadoUbicacion;
	}


}