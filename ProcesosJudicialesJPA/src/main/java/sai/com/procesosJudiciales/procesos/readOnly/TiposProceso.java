package sai.com.procesosJudiciales.procesos.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the TIPOS_PROCESO database table.
 * 
 */
@Entity
@Table(name="V_F_TPROCESOS")
@NamedQuery(name = "tipoProcesosActivos", query = "select tp from TiposProceso tp where tp.estadoTipoProceso = \'A\'")
public class TiposProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SEC_TP", unique=true, nullable=false, precision=15)
	private BigDecimal secuenciaTipoProceso;

	@Column(length=2)
	private String abreviacion;

	@Column(name="CODIGO_PROCESO", precision=22)
	private BigDecimal codigoProceso;

	@Column(name="DESC_TIPO_PROCESO", length=500)
	private String descTipoProceso;

	@Column(name="ESTADO_TIPO_PROCESO", nullable=false, length=120)
	private String estadoTipoProceso;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="MANEJA_PRETENSIONES", length=2)
	private String manejaPretensiones;

	@Column(name="NOMBRE_TIPO_PROCESO", nullable=false, length=100)
	private String nombreTipoProceso;

	@Column(name="TIPO_TRAMITE", nullable=false, length=120)
	private String tipoTramite;

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=30)
	private String usuarioModificacion;

	@Column(name="VALOR_PRETENSIONES", precision=22)
	private BigDecimal valorPretensiones;
	   

	public TiposProceso() {
    }

	public BigDecimal getSecuenciaTipoProceso() {
		return this.secuenciaTipoProceso;
	}

	public void setSecuenciaTipoProceso(BigDecimal secuenciaTipoProceso) {
		this.secuenciaTipoProceso = secuenciaTipoProceso;
	}

	public String getAbreviacion() {
		return this.abreviacion;
	}

	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}

	public BigDecimal getCodigoProceso() {
		return this.codigoProceso;
	}

	public void setCodigoProceso(BigDecimal codigoProceso) {
		this.codigoProceso = codigoProceso;
	}

	public String getDescTipoProceso() {
		return this.descTipoProceso;
	}

	public void setDescTipoProceso(String descTipoProceso) {
		this.descTipoProceso = descTipoProceso;
	}

	public String getEstadoTipoProceso() {
		return this.estadoTipoProceso;
	}

	public void setEstadoTipoProceso(String estadoTipoProceso) {
		this.estadoTipoProceso = estadoTipoProceso;
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

	public String getManejaPretensiones() {
		return this.manejaPretensiones;
	}

	public void setManejaPretensiones(String manejaPretensiones) {
		this.manejaPretensiones = manejaPretensiones;
	}

	public String getNombreTipoProceso() {
		return this.nombreTipoProceso;
	}

	public void setNombreTipoProceso(String nombreTipoProceso) {
		this.nombreTipoProceso = nombreTipoProceso;
	}

	public String getTipoTramite() {
		return this.tipoTramite;
	}

	public void setTipoTramite(String tipoTramite) {
		this.tipoTramite = tipoTramite;
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

	public BigDecimal getValorPretensiones() {
		return this.valorPretensiones;
	}

	public void setValorPretensiones(BigDecimal valorPretensiones) {
		this.valorPretensiones = valorPretensiones;
	}
	
}