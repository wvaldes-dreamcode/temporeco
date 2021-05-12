package sai.com.procesosJudiciales.ubicacion.entities;

import static org.eclipse.persistence.annotations.CacheType.NONE;
import static org.eclipse.persistence.annotations.ExistenceType.ASSUME_NON_EXISTENCE;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.ExistenceChecking;

import sai.com.procesosJudiciales.generales.readOnly.FuncionariosAreaV;
import sai.com.procesosJudiciales.ubicacion.readOnly.TipoTransaccion;


/**
 * The persistent class for the PRESTAMO_CARPETA database table.
 * 
 */
@Entity
@Table(name="PRESTAMO_CARPETA")
@org.eclipse.persistence.annotations.Cache(type = NONE)
@ExistenceChecking(ASSUME_NON_EXISTENCE)
public class PrestamoCarpeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRESTAMO_CARPETA_NUMEROPRESTAMO_GENERATOR", sequenceName="SEQ_PRESTAMO_CARPETA", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRESTAMO_CARPETA_NUMEROPRESTAMO_GENERATOR")
	@Column(name="NUMERO_PRESTAMO")
	private BigDecimal numeroPrestamo;
	

	@Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	@Temporal( TemporalType.DATE)
	@Column(name="FECHA_ENTREGA")
	private Date fechaEntrega;

	@Temporal( TemporalType.DATE)
	@Column(name="FECHA_PRESTAMO")
	private Date fechaPretamo;

	@ManyToOne
	@JoinColumn(name="NUMERO_CARPETA")
	private CarpetaUbicacion carpetaUbicacion;
		
	@ManyToOne
	@JoinColumn(name="TIPO_TRANSACCION")
	private TipoTransaccion tipoTransaccion;
	
	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;
	
	
	//uni-directional many-to-one association to FuncionariosAreaV
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_PRESTAMISTA", referencedColumnName="DOCUMENTO_ID"),
		@JoinColumn(name="TIPO_ID_PRESTAMISTA", referencedColumnName="TIPO_ID")
	})
	private FuncionariosAreaV funcionario;

	public PrestamoCarpeta() {
	}

	public BigDecimal getNumeroPrestamo() {
		return this.numeroPrestamo;
	}

	public void setNumeroPrestamo(BigDecimal numeroPrestamo) {
		this.numeroPrestamo = numeroPrestamo;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEntrega() {
		return this.fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Date getFechaPretamo() {
		return this.fechaPretamo;
	}

	public void setFechaPretamo(Date fechaPretamo) {
		this.fechaPretamo = fechaPretamo;
	}

	public CarpetaUbicacion getCarpetaUbicacion() {
		return carpetaUbicacion;
	}

	public void setCarpetaUbicacion(CarpetaUbicacion carpetaUbicacion) {
		this.carpetaUbicacion = carpetaUbicacion;
	}

	public TipoTransaccion getTipoTransaccion() {
		return this.tipoTransaccion;
	}

	public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public FuncionariosAreaV getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(FuncionariosAreaV funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	

}