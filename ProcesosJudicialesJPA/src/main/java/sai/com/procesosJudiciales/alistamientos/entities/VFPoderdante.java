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
 * The persistent class for the V_F_PODERDANTE database table.
 * 
 */
@Entity
@Table(name="V_F_PODERDANTE")
public class VFPoderdante implements Serializable {
	private static final long serialVersionUID = 1L;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(length=4000)
	private String nombre;

	@Column(name="NOMBRE_TIPO_PROCESO", nullable=false, length=100)
	private String nombreTipoProceso;

	@Id
	@Column(name="NUMERO_ALISTAMIENTO", nullable=false, precision=15)
	private BigDecimal numeroAlistamiento;

	@Column(name="NUMERO_ID_PODERDANTE", nullable=false, precision=15)
	private BigDecimal numeroIdPoderdante;

	@Column(name="SECUENCIA_TIPO_PROCESO", nullable=false, precision=15)
	private BigDecimal secuenciaTipoProceso;

	@Column(name="TIPO_ID_PODERDANTE", nullable=false, length=3)
	private String tipoIdPoderdante;

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=30)
	private String usuarioModificacion;

    public VFPoderdante() {
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreTipoProceso() {
		return this.nombreTipoProceso;
	}

	public void setNombreTipoProceso(String nombreTipoProceso) {
		this.nombreTipoProceso = nombreTipoProceso;
	}

	public BigDecimal getNumeroAlistamiento() {
		return this.numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}

	public BigDecimal getNumeroIdPoderdante() {
		return this.numeroIdPoderdante;
	}

	public void setNumeroIdPoderdante(BigDecimal numeroIdPoderdante) {
		this.numeroIdPoderdante = numeroIdPoderdante;
	}

	public BigDecimal getSecuenciaTipoProceso() {
		return this.secuenciaTipoProceso;
	}

	public void setSecuenciaTipoProceso(BigDecimal secuenciaTipoProceso) {
		this.secuenciaTipoProceso = secuenciaTipoProceso;
	}

	public String getTipoIdPoderdante() {
		return this.tipoIdPoderdante;
	}

	public void setTipoIdPoderdante(String tipoIdPoderdante) {
		this.tipoIdPoderdante = tipoIdPoderdante;
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