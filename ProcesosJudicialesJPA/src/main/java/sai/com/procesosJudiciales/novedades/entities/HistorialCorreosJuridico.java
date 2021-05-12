package sai.com.procesosJudiciales.novedades.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the HISTORIAL_CORREOS_JURIDICO database table.
 * 
 */
@Entity
//@Table(name="HISTORIAL_CORREOS_JURIDICO")
@Table(name="HISTORIAL_PARA_CORREO")
public class HistorialCorreosJuridico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Id
	@Column(name="TIPO")
	private String tipo;
	  
	@Id
	@Column(name="NUMERO")
	private BigDecimal numero;

	@Column(name="COMPANIA")
	private String compania;

	@Column(name="AREA")
	private String area;

	@Column(name="CARGO")
	private String cargo;

	@Column(name="CORREO")
	private String correo;

	@Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;
	
    @ManyToOne
	@JoinColumn(name="SECUENCIA_MOVIMIENTO_NOVEDAD", referencedColumnName="SECUENCIA_MOVIMIENTO_NOVEDAD")
	private MovimientosNovedade movimientoNovedad;

    public HistorialCorreosJuridico() {
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

	public MovimientosNovedade getMovimientoNovedad() {
		return movimientoNovedad;
	}

	public void setMovimientoNovedad(MovimientosNovedade movimientoNovedad) {
		this.movimientoNovedad = movimientoNovedad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getNumero() {
		return numero;
	}

	public void setNumero(BigDecimal numero) {
		this.numero = numero;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}