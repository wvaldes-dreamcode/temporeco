package sai.com.procesosJudiciales.procesos.readOnly;

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

import sai.com.procesosJudiciales.procesos.entities.Actuacion;


/**
 * The persistent class for the V_F_ATUACIONES_PROCESO database table.
 * 
 */
@Entity
@Table(name="V_F_ATUACIONES_PROCESO")
public class AtuacionesProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="DURACION_ACTUACION", precision=4)
	private BigDecimal duracionActuacion;

	@Column(name="ESTADO_ACTUACION", length=2)
	private String estadoActuacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_FIN_ACTUACION")
	private Date fechaFinActuacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_INICIO_ACTUACION", nullable=false)
	private Date fechaInicioActuacion;

	@Column(name="NOMBRE_RIESGO", length=4000)
	private String nombreRiesgo;

	@Column(name="ORDEN_ACTUACION_ETAPA", precision=5)
	private BigDecimal ordenActuacionEtapa;

	@Id	
	@Column(name="SECUENCIA_ACT_PROCESO", nullable=false, precision=15)
	private BigDecimal secuenciaActProceso;

	@Column(name="SECUENCIA_ACTUACION_RET", precision=15)
	private BigDecimal secuenciaActuacionRet;

	@Column(name="SECUENCIA_ETAPA_RET", precision=15)
	private BigDecimal secuenciaEtapaRet;

	@Column(name="TIEMPO_CONTEMPLADO", precision=22)
	private BigDecimal tiempoContemplado;

	@Column(name="TIEMPO_CONTEMPLADO_AE", precision=10)
	private BigDecimal tiempoContempladoAe;

	//bi-directional many-to-one association to EtapasProceso
    @ManyToOne
	@JoinColumn(name="SECUENCIA_ETAPA_PROCESO", referencedColumnName="SECUENCIA_ETAPA_PROCESO", nullable=false)
	private EtapasProceso VFEtapasProceso;

	//bi-directional many-to-one association to Actuacion
    @ManyToOne
	@JoinColumn(name="SECUENCIA_ACTUACION", nullable=false)
	private Actuacion actuacione;

    public AtuacionesProceso() {
    }

	public BigDecimal getDuracionActuacion() {
		return this.duracionActuacion;
	}

	public void setDuracionActuacion(BigDecimal duracionActuacion) {
		this.duracionActuacion = duracionActuacion;
	}

	public String getEstadoActuacion() {
		return this.estadoActuacion;
	}

	public void setEstadoActuacion(String estadoActuacion) {
		this.estadoActuacion = estadoActuacion;
	}

	public Date getFechaFinActuacion() {
		return this.fechaFinActuacion;
	}

	public void setFechaFinActuacion(Date fechaFinActuacion) {
		this.fechaFinActuacion = fechaFinActuacion;
	}

	public Date getFechaInicioActuacion() {
		return this.fechaInicioActuacion;
	}

	public void setFechaInicioActuacion(Date fechaInicioActuacion) {
		this.fechaInicioActuacion = fechaInicioActuacion;
	}

	public String getNombreRiesgo() {
		return this.nombreRiesgo;
	}

	public void setNombreRiesgo(String nombreRiesgo) {
		this.nombreRiesgo = nombreRiesgo;
	}

	public BigDecimal getOrdenActuacionEtapa() {
		return this.ordenActuacionEtapa;
	}

	public void setOrdenActuacionEtapa(BigDecimal ordenActuacionEtapa) {
		this.ordenActuacionEtapa = ordenActuacionEtapa;
	}

	public BigDecimal getSecuenciaActProceso() {
		return this.secuenciaActProceso;
	}

	public void setSecuenciaActProceso(BigDecimal secuenciaActProceso) {
		this.secuenciaActProceso = secuenciaActProceso;
	}

	public BigDecimal getSecuenciaActuacionRet() {
		return this.secuenciaActuacionRet;
	}

	public void setSecuenciaActuacionRet(BigDecimal secuenciaActuacionRet) {
		this.secuenciaActuacionRet = secuenciaActuacionRet;
	}

	public BigDecimal getSecuenciaEtapaRet() {
		return this.secuenciaEtapaRet;
	}

	public void setSecuenciaEtapaRet(BigDecimal secuenciaEtapaRet) {
		this.secuenciaEtapaRet = secuenciaEtapaRet;
	}

	public BigDecimal getTiempoContemplado() {
		return this.tiempoContemplado;
	}

	public void setTiempoContemplado(BigDecimal tiempoContemplado) {
		this.tiempoContemplado = tiempoContemplado;
	}

	public BigDecimal getTiempoContempladoAe() {
		return this.tiempoContempladoAe;
	}

	public void setTiempoContempladoAe(BigDecimal tiempoContempladoAe) {
		this.tiempoContempladoAe = tiempoContempladoAe;
	}

	public EtapasProceso getVFEtapasProceso() {
		return this.VFEtapasProceso;
	}

	public void setVFEtapasProceso(EtapasProceso VFEtapasProceso) {
		this.VFEtapasProceso = VFEtapasProceso;
	}
	
	public Actuacion getActuacione() {
		return this.actuacione;
	}

	public void setActuacione(Actuacion actuacione) {
		this.actuacione = actuacione;
	}
	
}