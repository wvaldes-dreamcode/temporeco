package sai.com.procesosJudiciales.generales.entities;

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

import sai.com.procesosJudiciales.generales.readOnly.Ciudades;
import sai.com.procesosJudiciales.generales.readOnly.TiposDespacho;


/**
 * The persistent class for the DESPACHOS database table.
 * 
 */
@Entity
@Table(name="DESPACHOS")
@NamedQuery(name="Juzgados", query="select j from Juzgado j order by j.nombreDespacho")
public class Juzgado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SECUENCIA_DESPACHO", unique=true, nullable=false, precision=15)
	private BigDecimal secuenciaDespacho;

	@Column(name="CODIGO_DESPACHO", nullable=false, length=20)
	private String codigoDespacho;

	@Column(name="CONTACTO_DESPACHO", length=100)
	private String contactoDespacho;

	@Column(name="DIRECCION_DESPACHO", length=100)
	private String direccionDespacho;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="JERARQUIA_DESPACHO", length=20)
	private String jerarquiaDespacho;

	@Column(name="NOMBRE_DESPACHO", nullable=false, length=150)
	private String nombreDespacho;

	@Column(name="TELEFONO_DESPACHO", length=30)
	private String telefonoDespacho;

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=30)
	private String usuarioModificacion;

	//uni-directional many-to-one association to Ciudades
    @ManyToOne
	@JoinColumn(name="CIUDAD_DESPACHO", referencedColumnName="CODAZZI_CIU", nullable=false)
	private Ciudades ciudad;
    
    @ManyToOne
	@JoinColumn(name="TIPO_DESPACHO", referencedColumnName="CODIGO")
	private TiposDespacho tipoDespacho;

    public TiposDespacho getTipoDespacho() {
		return tipoDespacho;
	}

	public void setTipoDespacho(TiposDespacho tipoDespacho) {
		this.tipoDespacho = tipoDespacho;
	}

	public Juzgado() {
    }

	public BigDecimal getSecuenciaDespacho() {
		return this.secuenciaDespacho;
	}

	public void setSecuenciaDespacho(BigDecimal secuenciaDespacho) {
		this.secuenciaDespacho = secuenciaDespacho;
	}

	public String getCodigoDespacho() {
		return this.codigoDespacho;
	}

	public void setCodigoDespacho(String codigoDespacho) {
		this.codigoDespacho = codigoDespacho;
	}

	public String getContactoDespacho() {
		return this.contactoDespacho;
	}

	public void setContactoDespacho(String contactoDespacho) {
		this.contactoDespacho = contactoDespacho;
	}

	public String getDireccionDespacho() {
		return this.direccionDespacho;
	}

	public void setDireccionDespacho(String direccionDespacho) {
		this.direccionDespacho = direccionDespacho;
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

	public String getJerarquiaDespacho() {
		return this.jerarquiaDespacho;
	}

	public void setJerarquiaDespacho(String jerarquiaDespacho) {
		this.jerarquiaDespacho = jerarquiaDespacho;
	}

	public String getNombreDespacho() {
		return this.nombreDespacho;
	}

	public void setNombreDespacho(String nombreDespacho) {
		this.nombreDespacho = nombreDespacho;
	}

	public String getTelefonoDespacho() {
		return this.telefonoDespacho;
	}

	public void setTelefonoDespacho(String telefonoDespacho) {
		this.telefonoDespacho = telefonoDespacho;
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

	public Ciudades getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudades ciudad) {
		this.ciudad = ciudad;
	}
	
}