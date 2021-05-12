package sai.com.procesosJudiciales.alistamientos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the MOVIMIENTO_ORIGEN_DESOCUPACION database table.
 * 
 */
@Entity
@Table(name="MOVIMIENTO_ORIGEN_DESOCUPACION")
public class OrigenDesocupacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOVIMIENTO_ORIGEN_DESOCUPACION_SECUENCIA_GENERATOR", sequenceName="SEQ_MOV_ORI_DES", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOVIMIENTO_ORIGEN_DESOCUPACION_SECUENCIA_GENERATOR")
	@Column(unique=true, nullable=false, precision=15)
	private BigDecimal secuencia;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="NUMERO_ALISTAMIENTO", nullable=false, precision=15)
	private BigDecimal numeroAlistamiento;
	
	@JoinColumn(name = "SECUENCIA_ORIGEN", referencedColumnName ="SECUENCIA_ORIGEN")
	private TipoOrigenDesocupacion origenDesocupacion;

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=30)
	private String usuarioModificacion;

    public OrigenDesocupacion() {
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

	public BigDecimal getNumeroAlistamiento() {
		return this.numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}
	
	public TipoOrigenDesocupacion getOrigenDesocupacion() {
		return origenDesocupacion;
	}

	public void setOrigenDesocupacion(TipoOrigenDesocupacion origenDesocupacion) {
		this.origenDesocupacion = origenDesocupacion;
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

