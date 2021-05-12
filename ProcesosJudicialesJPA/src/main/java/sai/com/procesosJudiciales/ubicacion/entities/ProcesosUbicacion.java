package sai.com.procesosJudiciales.ubicacion.entities;

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
 * The persistent class for the PROCESOS_UBICACION database table.
 * 
 */
@Entity
@Table(name="PROCESOS_UBICACION")
public class ProcesosUbicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMERO_PROCESO_CARPETA")
	private BigDecimal numeroProcesoCarpeta;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name="NUMERO_PROCESO")
	private BigDecimal numeroProceso;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	//uni-directional many-to-one association to CarpetaUbicacion
    @ManyToOne
	@JoinColumn(name="NUMERO_CARPETA")
	private CarpetaUbicacion carpetaUbicacion;

    public ProcesosUbicacion() {
    }

	public BigDecimal getNumeroProcesoCarpeta() {
		return this.numeroProcesoCarpeta;
	}

	public void setNumeroProcesoCarpeta(BigDecimal numeroProcesoCarpeta) {
		this.numeroProcesoCarpeta = numeroProcesoCarpeta;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public BigDecimal getNumeroProceso() {
		return this.numeroProceso;
	}

	public void setNumeroProceso(BigDecimal numeroProceso) {
		this.numeroProceso = numeroProceso;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public CarpetaUbicacion getCarpetaUbicacion() {
		return this.carpetaUbicacion;
	}

	public void setCarpetaUbicacion(CarpetaUbicacion carpetaUbicacion) {
		this.carpetaUbicacion = carpetaUbicacion;
	}
	
}