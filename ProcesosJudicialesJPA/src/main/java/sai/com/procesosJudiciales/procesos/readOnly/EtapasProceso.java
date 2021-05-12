package sai.com.procesosJudiciales.procesos.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import sai.com.procesosJudiciales.procesos.entities.Etapa;


/**
 * The persistent class for the V_F_ETAPAS_PROCESO database table.
 * 
 */
@Entity
@Table(name="V_F_ETAPAS_PROCESO")
public class EtapasProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CALIFICAR_ETAPA", precision=4, scale=2)
	private BigDecimal calificarEtapa;

	@Column(name="DURACION_ETAPA", precision=4)
	private BigDecimal duracionEtapa;

	@Column(name="ESTADO_ETAPA", length=2)
	private String estadoEtapa;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_FIN_ETAPA")
	private Date fechaFinEtapa;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_INICIO_ETAPA", nullable=false)
	private Date fechaInicioEtapa;

	@Column(name="ORDEN_ETAPA_PROCESO", precision=3)
	private BigDecimal ordenEtapaProceso;

	@Column(name="SUM_TRANSCURRIDO", precision=22)
	private BigDecimal sumTranscurrido;
	
	@Id
	@Column(name="SECUENCIA_ETAPA_PROCESO", precision=22)
	private BigDecimal secuenciaEtapaProceso;

	public BigDecimal getSecuenciaEtapaProceso() {
		return secuenciaEtapaProceso;
	}

	public void setSecuenciaEtapaProceso(BigDecimal secuenciaEtapaProceso) {
		this.secuenciaEtapaProceso = secuenciaEtapaProceso;
	}

	//bi-directional many-to-one association to InstanciasProceso
    @ManyToOne
	@JoinColumn(name="SECUENCIA_INS_PROCESO", referencedColumnName="SECUENCIA_INS_PROCESO", nullable=false)
	private InstanciasProceso VFInstanciasProceso;

	//bi-directional many-to-one association to Etapa
    @ManyToOne
	@JoinColumn(name="SECUENCIA_ETAPA", nullable=false)
	private Etapa etapa;

	//bi-directional many-to-one association to AtuacionesProceso
	@OneToMany(mappedBy="VFEtapasProceso", fetch=FetchType.LAZY)
	private List<AtuacionesProceso> VFAtuacionesProcesos;

    public EtapasProceso() {
    }

	public BigDecimal getCalificarEtapa() {
		return this.calificarEtapa;
	}

	public void setCalificarEtapa(BigDecimal calificarEtapa) {
		this.calificarEtapa = calificarEtapa;
	}

	public BigDecimal getDuracionEtapa() {
		return this.duracionEtapa;
	}

	public void setDuracionEtapa(BigDecimal duracionEtapa) {
		this.duracionEtapa = duracionEtapa;
	}

	public String getEstadoEtapa() {
		return this.estadoEtapa;
	}

	public void setEstadoEtapa(String estadoEtapa) {
		this.estadoEtapa = estadoEtapa;
	}

	public Date getFechaFinEtapa() {
		return this.fechaFinEtapa;
	}

	public void setFechaFinEtapa(Date fechaFinEtapa) {
		this.fechaFinEtapa = fechaFinEtapa;
	}

	public Date getFechaInicioEtapa() {
		return this.fechaInicioEtapa;
	}

	public void setFechaInicioEtapa(Date fechaInicioEtapa) {
		this.fechaInicioEtapa = fechaInicioEtapa;
	}

	public BigDecimal getOrdenEtapaProceso() {
		return this.ordenEtapaProceso;
	}

	public void setOrdenEtapaProceso(BigDecimal ordenEtapaProceso) {
		this.ordenEtapaProceso = ordenEtapaProceso;
	}

	public BigDecimal getSumTranscurrido() {
		return this.sumTranscurrido;
	}

	public void setSumTranscurrido(BigDecimal sumTranscurrido) {
		this.sumTranscurrido = sumTranscurrido;
	}

	public InstanciasProceso getVFInstanciasProceso() {
		return this.VFInstanciasProceso;
	}

	public void setVFInstanciasProceso(InstanciasProceso VFInstanciasProceso) {
		this.VFInstanciasProceso = VFInstanciasProceso;
	}
	
	public Etapa getEtapa() {
		return this.etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}
	
	public List<AtuacionesProceso> getVFAtuacionesProcesos() {
		return this.VFAtuacionesProcesos;
	}

	public void setVFAtuacionesProcesos(List<AtuacionesProceso> VFAtuacionesProcesos) {
		this.VFAtuacionesProcesos = VFAtuacionesProcesos;
	}
	
}