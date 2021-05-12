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

import sai.com.procesosJudiciales.generales.entities.Juzgado;


/**
 * The persistent class for the V_F_INSTANCIAS_PROCESO database table.
 * 
 */
@Entity
@Table(name="V_F_INSTANCIAS_PROCESO")
public class InstanciasProceso implements Serializable {
	private static final long serialVersionUID = 1L;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_FIN_INSTANCIA")
	private Date fechaFinInstancia;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_INICIO_INSTANCIA", nullable=false)
	private Date fechaInicioInstancia;
                   
	@Column(name="NOMBRE_INSTANCIA", nullable=false, length=200)
	private String nombreInstancia;

	@Column(name="NUMERO_RADICACION", length=50)
	private String numeroRadicacion;

	/*@Column(precision=22)
	private BigDecimal orden;*/

	//bi-directional many-to-one association to Proceso
    @ManyToOne
	@JoinColumn(name="NUMERO_PROCESO", referencedColumnName="NUMERO_PROCESO", nullable=false)
	private Proceso VFProceso;

	//bi-directional many-to-one association to Juzgado
    @ManyToOne
	@JoinColumn(name="SECUENCIA_DESPACHO", nullable=false)
	private Juzgado despacho;

	/*//bi-directional many-to-one association to Instancia
    @ManyToOne
	@JoinColumn(name="SECUENCIA_INSTANCIA",nullable=false)
	private Instancia instancia;

	public Instancia getInstancia() {
		return instancia;
	}

	public void setInstancia(Instancia instancia) {
		this.instancia = instancia;
	}*/

	//bi-directional many-to-one association to EtapasProceso
	@OneToMany(mappedBy="VFInstanciasProceso", fetch=FetchType.LAZY)
	private List<EtapasProceso> VFEtapasProcesos;
	
	@Id
	@Column(name="SECUENCIA_INS_PROCESO", precision=22)
	private BigDecimal secuenciaInsProceso;;


    public BigDecimal getSecuenciaInsProceso() {
		return secuenciaInsProceso;
	}

	public void setSecuenciaInsProceso(BigDecimal secuenciaInsProceso) {
		this.secuenciaInsProceso = secuenciaInsProceso;
	}

	public InstanciasProceso() {
    }

	public Date getFechaFinInstancia() {
		return this.fechaFinInstancia;
	}

	public void setFechaFinInstancia(Date fechaFinInstancia) {
		this.fechaFinInstancia = fechaFinInstancia;
	}

	public Date getFechaInicioInstancia() {
		return this.fechaInicioInstancia;
	}

	public void setFechaInicioInstancia(Date fechaInicioInstancia) {
		this.fechaInicioInstancia = fechaInicioInstancia;
	}

	public String getNombreInstancia() {
		return this.nombreInstancia;
	}

	public void setNombreInstancia(String nombreInstancia) {
		this.nombreInstancia = nombreInstancia;
	}

	public String getNumeroRadicacion() {
		return this.numeroRadicacion;
	}

	public void setNumeroRadicacion(String numeroRadicacion) {
		this.numeroRadicacion = numeroRadicacion;
	}

	/*public BigDecimal getOrden() {
		return this.orden;
	}

	public void setOrden(BigDecimal orden) {
		this.orden = orden;
	}*/

	public Proceso getVFProceso() {
		return this.VFProceso;
	}

	public void setVFProceso(Proceso VFProceso) {
		this.VFProceso = VFProceso;
	}
	
	public Juzgado getDespacho() {
		return this.despacho;
	}

	public void setDespacho(Juzgado despacho) {
		this.despacho = despacho;
	}
	
	
	
	public List<EtapasProceso> getVFEtapasProcesos() {
		return this.VFEtapasProcesos;
	}

	public void setVFEtapasProcesos(List<EtapasProceso> VFEtapasProcesos) {
		this.VFEtapasProcesos = VFEtapasProcesos;
	}
	
}