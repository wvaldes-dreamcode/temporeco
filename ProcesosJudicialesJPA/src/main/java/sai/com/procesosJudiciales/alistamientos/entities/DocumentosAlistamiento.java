package sai.com.procesosJudiciales.alistamientos.entities;

import static org.eclipse.persistence.annotations.CacheType.NONE;
import static org.eclipse.persistence.annotations.ExistenceType.ASSUME_NON_EXISTENCE;

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
import javax.persistence.Transient;

import org.eclipse.persistence.annotations.ExistenceChecking;


/**
 * The persistent class for the DOCUMENTOS_ALISTAMIENTO database table.
 * 
 */
@Entity
@Table(name="DOCUMENTOS_ALISTAMIENTO")
@org.eclipse.persistence.annotations.Cache(type = NONE)
@ExistenceChecking(ASSUME_NON_EXISTENCE)
public class DocumentosAlistamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SECUENCIA_DOCUMENTO")
	private BigDecimal secuenciaDocumento;

	private String devolucion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_DEVOLUCION")
	private Date fechaDevolucion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_RECIBE_CARTERA")
	private Date fechaRecibeCartera;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_RECIBE_JURIDICO")
	private Date fechaRecibeJuridico;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_SOLICITA_CARTERA")
	private Date fechaSolicitaCartera;

	@Column(name="NUMERO_ALISTAMIENTO")
	private BigDecimal numeroAlistamiento;

	private String observaciones;

	@Column(name="RECIBE_CARTERA")
	private String recibeCartera;

	@Column(name="RECIBE_JURIDICO")
	private String recibeJuridico;

	@Column(name="SOLICITA_CARTERA")
	private String solicitaCartera;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION")
	private String usuarioModificacion;

	@Column(name="USUARIO_RESPONSABLE")
	private String usuarioResponsable;

	//uni-directional many-to-one association to Documento
    @ManyToOne
	@JoinColumn(name="CODIGO_DOCUMENTO")
	private Documento documento;

    @Transient
    private String obligatoriosTipo;
    
    public DocumentosAlistamiento() {
    }

	public BigDecimal getSecuenciaDocumento() {
		return this.secuenciaDocumento;
	}

	public void setSecuenciaDocumento(BigDecimal secuenciaDocumento) {
		this.secuenciaDocumento = secuenciaDocumento;
	}

	public String getDevolucion() {
		return this.devolucion;
	}

	public void setDevolucion(String devolucion) {
		this.devolucion = devolucion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaDevolucion() {
		return this.fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaRecibeCartera() {
		return this.fechaRecibeCartera;
	}

	public void setFechaRecibeCartera(Date fechaRecibeCartera) {
		this.fechaRecibeCartera = fechaRecibeCartera;
	}

	public Date getFechaRecibeJuridico() {
		return this.fechaRecibeJuridico;
	}

	public void setFechaRecibeJuridico(Date fechaRecibeJuridico) {
		this.fechaRecibeJuridico = fechaRecibeJuridico;
	}

	public Date getFechaSolicitaCartera() {
		return this.fechaSolicitaCartera;
	}

	public void setFechaSolicitaCartera(Date fechaSolicitaCartera) {
		this.fechaSolicitaCartera = fechaSolicitaCartera;
	}

	public BigDecimal getNumeroAlistamiento() {
		return this.numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getRecibeCartera() {
		return this.recibeCartera;
	}

	public void setRecibeCartera(String recibeCartera) {
		this.recibeCartera = recibeCartera;
	}

	public String getRecibeJuridico() {
		return this.recibeJuridico;
	}

	public void setRecibeJuridico(String recibeJuridico) {
		this.recibeJuridico = recibeJuridico;
	}

	public String getSolicitaCartera() {
		return this.solicitaCartera;
	}

	public void setSolicitaCartera(String solicitaCartera) {
		this.solicitaCartera = solicitaCartera;
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

	public String getUsuarioResponsable() {
		return this.usuarioResponsable;
	}

	public void setUsuarioResponsable(String usuarioResponsable) {
		this.usuarioResponsable = usuarioResponsable;
	}

	public Documento getDocumento() {
		return this.documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	
	public void setObligatoriosTipo(String obligatoriosTipo){
		this.obligatoriosTipo = obligatoriosTipo;		
	}
	
	public String getObligatoriosTipo(){
		return this.obligatoriosTipo;
	}
	
}