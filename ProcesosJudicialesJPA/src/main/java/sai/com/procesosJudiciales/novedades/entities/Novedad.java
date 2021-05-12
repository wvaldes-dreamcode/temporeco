package sai.com.procesosJudiciales.novedades.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the NOVEDADES_OBLIGACIONES database table.
 * 
 */
@Entity
@Table(name="NOVEDADES_OBLIGACIONES")
public class Novedad implements Serializable, Comparable<Novedad> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SECUENCIA_NOVEDAD", unique=true, nullable=false, precision=15)
	private BigDecimal secuenciaNovedad;

	@Column(name="ENVIAR_CORREO", nullable=false, length=1)
	private String enviarCorreo;

	@Column(name="ESTADO_NOVEDAD", nullable=false, length=1)
	private String estadoNovedad;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

	@Column(name="MARCA_PROCESO", nullable=false, length=1)
	private String marcaProceso;

	@Column(name="NOMBRE_NOVEDAD", nullable=false, length=120)
	private String nombreNovedad;

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	//uni-directional one-to-one association to Consecuencia
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SECUENCIA_NOVEDAD", referencedColumnName="SECUENCIA_NOVEDAD", nullable=false, insertable=false, updatable=false)
	private Consecuencia detalleConsecuenciasNovedad;

    public Novedad() {
    }

	public BigDecimal getSecuenciaNovedad() {
		return this.secuenciaNovedad;
	}

	public void setSecuenciaNovedad(BigDecimal secuenciaNovedad) {
		this.secuenciaNovedad = secuenciaNovedad;
	}

	public String getEnviarCorreo() {
		return this.enviarCorreo;
	}

	public void setEnviarCorreo(String enviarCorreo) {
		this.enviarCorreo = enviarCorreo;
	}

	public String getEstadoNovedad() {
		return this.estadoNovedad;
	}

	public void setEstadoNovedad(String estadoNovedad) {
		this.estadoNovedad = estadoNovedad;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getMarcaProceso() {
		return this.marcaProceso;
	}

	public void setMarcaProceso(String marcaProceso) {
		this.marcaProceso = marcaProceso;
	}

	public String getNombreNovedad() {
		return this.nombreNovedad;
	}

	public void setNombreNovedad(String nombreNovedad) {
		this.nombreNovedad = nombreNovedad;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Consecuencia getDetalleConsecuenciasNovedad() {
		return this.detalleConsecuenciasNovedad;
	}

	public void setDetalleConsecuenciasNovedad(Consecuencia detalleConsecuenciasNovedad) {
		this.detalleConsecuenciasNovedad = detalleConsecuenciasNovedad;
	}

	

	@Override
	public int compareTo(Novedad o) {
						
		return this.nombreNovedad.compareTo(o.nombreNovedad);
	}
	
	
}