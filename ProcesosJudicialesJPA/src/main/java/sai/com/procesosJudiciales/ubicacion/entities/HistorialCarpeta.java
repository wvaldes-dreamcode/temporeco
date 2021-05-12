package sai.com.procesosJudiciales.ubicacion.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import sai.com.procesosJudiciales.generales.readOnly.FuncionariosAreaV;


/**
 * The persistent class for the HISTORIAL_CARPETA database table.
 * 
 */
@Entity
@Table(name="HISTORICO_CARPETA")
public class HistorialCarpeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMERO_HISTORIAL_CARPETA")
	private BigDecimal numeroHistorialCarpeta;

	private String estado;

    @Temporal(TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	@ManyToOne
	@JoinColumn(name="NUMERO_CAUSAL_TERMINACION")
	private CausalesTerminacion causal;


	@ManyToOne
	@JoinColumn(name="NUMERO_UBICACION")
	private Ubicacion ubicacion;

	 
	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	//uni-directional many-to-one association to CarpetaUbicacion
    @ManyToOne
	@JoinColumn(name="NUMERO_CARPETA")
	private CarpetaUbicacion carpetaUbicacion;
    
    @Column(name="EN_ARCHIVO")
	private String enArchivo;  
    
    
    @ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_RESPONSABLE", referencedColumnName="DOCUMENTO_ID"),
		@JoinColumn(name="TIPO_ID_RESPONSABLE", referencedColumnName="TIPO_ID")
	})
	private FuncionariosAreaV funcionario;
    
    @Transient
    private String descripcion;
    
    public String getDescripcion() {
    	    	
    	if(carpetaUbicacion.getUbicacion().getNumeroUbicacion().equals(new BigDecimal("5"))){
    		descripcion = causal.getDescripcion();
    	}
    	if(carpetaUbicacion.getUbicacion().getNumeroUbicacion().equals(new BigDecimal("6"))){
	    	if(carpetaUbicacion.getCausalterminadoPago().equals("01") || carpetaUbicacion.getCausalterminadoPago().equals("02")){
		    	if(causal.getNumeroCausalTerminacion().equals(new BigDecimal("1"))){
		    		descripcion = "SANEADO";
		    	}
		    	if(causal.getNumeroCausalTerminacion().equals(new BigDecimal("2"))){
		    		descripcion = "TERMINADO";
		    	}
	    	}     	    	
    	}
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public CausalesTerminacion getCausal() {
		return causal;
	}

	public void setCausal(CausalesTerminacion causal) {
		this.causal = causal;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
    
    
    public FuncionariosAreaV getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionariosAreaV funcionario) {
		this.funcionario = funcionario;
	}

	public HistorialCarpeta() {
    }

	public BigDecimal getNumeroHistorialCarpeta() {
		return this.numeroHistorialCarpeta;
	}

	public void setNumeroHistorialCarpeta(BigDecimal numeroHistorialCarpeta) {
		this.numeroHistorialCarpeta = numeroHistorialCarpeta;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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

	public String getEnArchivo() {
		return enArchivo;
	}

	public void setEnArchivo(String enArchivo) {
		this.enArchivo = enArchivo;
	}
	
	
	
}