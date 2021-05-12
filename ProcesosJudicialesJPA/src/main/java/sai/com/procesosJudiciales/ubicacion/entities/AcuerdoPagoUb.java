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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import sai.com.procesosJudiciales.ubicacion.readOnly.EstadosAcuerdoPago;


/**
 * The persistent class for the ACUERDO_PAGO_UB database table.
 * 
 */
@Entity
@Table(name="ACUERDO_PAGO_UB")
public class AcuerdoPagoUb implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@SequenceGenerator(name="ACUERDO_PAGO_NUMEROPRESTAMO_GENERATOR", sequenceName="SEQ_ACUERDO_PAGO_UB", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACUERDO_PAGO_NUMEROPRESTAMO_GENERATOR")
	@Column(name="NUMERO_ACUERDO_PAGO")
	private BigDecimal numeroAcuerdoPago;
	
	@ManyToOne
	@JoinColumn(name="ESTADO")
	private EstadosAcuerdoPago estado;
	
    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_PAGO")
	private Date fechaPago;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	private BigDecimal valor;

	//bi-directional many-to-one association to CarpetaUbicacion
    @ManyToOne
	@JoinColumn(name="NUMERO_CARPETA")
	private CarpetaUbicacion carpetaUbicacion;

    public AcuerdoPagoUb() {
    }

	public BigDecimal getNumeroAcuerdoPago() {
		return this.numeroAcuerdoPago;
	}

	public void setNumeroAcuerdoPago(BigDecimal numeroAcuerdoPago) {
		this.numeroAcuerdoPago = numeroAcuerdoPago;
	}

	

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public CarpetaUbicacion getCarpetaUbicacion() {
		return this.carpetaUbicacion;
	}

	public void setCarpetaUbicacion(CarpetaUbicacion carpetaUbicacion) {
		this.carpetaUbicacion = carpetaUbicacion;
	}

	public EstadosAcuerdoPago getEstado() {
		return estado;
	}

	public void setEstado(EstadosAcuerdoPago estado) {
		this.estado = estado;
	}
	
}