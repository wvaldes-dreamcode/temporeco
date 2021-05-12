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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import sai.com.procesosJudiciales.procesos.readOnly.DeudoresV;


/**
 * The persistent class for the PAGOS_DEUDORES database table.
 * 
 */
@Entity
@Table(name="PAGOS_DEUDORES")
public class PagosDeudore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PAGOS_DEUDORES_SECUENCIAPAGOSDEUDORES_GENERATOR", sequenceName="SEQ_PAGOS_DEUDORES", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAGOS_DEUDORES_SECUENCIAPAGOSDEUDORES_GENERATOR")
	@Column(name="SECUENCIA_PAGOS_DEUDORES", unique=true, nullable=false, precision=15)
	private BigDecimal secuenciaPagosDeudores;

	@Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

	@Column(length=2000)
	private String justificacion;

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="NUMERO_ID", referencedColumnName="NUMERO_ID_DEUDOR", nullable=false),
		@JoinColumn(name="TIPO_ID", referencedColumnName="TIPO_ID_DEUDOR", nullable=false)
	})
	private DeudoresV deudor;


	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(precision=15, scale=2)
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name="NUMERO_CARPETA")
	private CarpetaUbicacion carpeta;

	public PagosDeudore() {
	}

	public DeudoresV getDeudor() {
		return deudor;
	}

	public void setDeudor(DeudoresV deudor) {
		this.deudor = deudor;
	}

	public BigDecimal getSecuenciaPagosDeudores() {
		return this.secuenciaPagosDeudores;
	}

	public void setSecuenciaPagosDeudores(BigDecimal secuenciaPagosDeudores) {
		this.secuenciaPagosDeudores = secuenciaPagosDeudores;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getJustificacion() {
		return this.justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
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

	public CarpetaUbicacion getCarpeta() {
		return carpeta;
	}

	public void setCarpeta(CarpetaUbicacion carpeta) {
		this.carpeta = carpeta;
	}
}