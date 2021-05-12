package sai.com.procesosJudiciales.titulos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.eclipse.persistence.annotations.PrivateOwned;

@Entity
@Table(name="ESTADO_DOCUMENTO_JUDICIAL")
public class EstadoDocumentoJudicial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESTADO_DOCUMENTO_JUDICIAL_SECUENCIAESTADODOCUMENTO_GENERATOR", sequenceName="SEQ_ESTDO_DCMNTO_JDCIAL", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADO_DOCUMENTO_JUDICIAL_SECUENCIAESTADODOCUMENTO_GENERATOR")
	@Column(name="SECUENCIA_ESTADO_DOCUMENTO", unique=true, nullable=false, precision=15)
	private BigDecimal secuenciaEstadoDocumento;

	@Column(length=2)
	private String abreviacion;

	@Column(nullable=false, length=100)
	private String descripcion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="USUARIO_CREACION", nullable=false, length=30)
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION", length=30)
	private String usuarioModificacion;
	
	@Column(name="INDICADOR_INICIAL")
	private Long indicadorInicial;
	
	@Column(name="INDICADOR_CAUSAL")
	private Long indicadorCausal;

	@Column(name="ESTADO")
	private String estado;
	/* **********************************************************************************
	*  Modificacion:	RRCE
	*  Autor:			German Fernandez
	*  Fecha:			13/06/2013
	*  Descripcion		creacion de propiedad
	********************************************************************************** */		
    @OneToMany(mappedBy = "estadoDocumentoJudicial")
    @PrivateOwned
    private List<EstadosResponsables> estadosResponsablesList;	

    @OneToMany(mappedBy = "estadoDocumentoJudicial")
    private List<HistoricoMovDocJudicial> historicoMovDocJudicial;     
    
    @Transient
    private Boolean indicadorBoolean;

    @Transient
    private Boolean indicadorCausalBoolean;    
    
	public List<EstadosResponsables> getEstadosResponsablesList() {
		return estadosResponsablesList;
	}

	public void setEstadosResponsablesList(
			List<EstadosResponsables> estadosResponsablesList) {
		this.estadosResponsablesList = estadosResponsablesList;
	}    
	
   public List<HistoricoMovDocJudicial> getHistoricoMovDocJudicial() {
		return historicoMovDocJudicial;
	}

	public void setHistoricoMovDocJudicial(
			List<HistoricoMovDocJudicial> historicoMovDocJudicial) {
		this.historicoMovDocJudicial = historicoMovDocJudicial;
	}
	
    // ************************************************************
	
	public EstadoDocumentoJudicial() {
    }
    
	public BigDecimal getSecuenciaEstadoDocumento() {
		return this.secuenciaEstadoDocumento;
	}

	public void setSecuenciaEstadoDocumento(BigDecimal secuenciaEstadoDocumento) {
		this.secuenciaEstadoDocumento = secuenciaEstadoDocumento;
	}

	public String getAbreviacion() {
		return this.abreviacion;
	}

	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Long getIndicadorInicial() {
		return indicadorInicial;
	}

	public void setIndicadorInicial(Long indicadorInicial) {
		this.indicadorInicial = indicadorInicial;
	}
	
	public Long getIndicadorCausal() {
		return indicadorCausal;
	}

	public void setIndicadorCausal(Long indicadorCausal) {
		this.indicadorCausal = indicadorCausal;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Boolean getIndicadorBoolean() {
		
		if(indicadorInicial == 1){
			indicadorBoolean = true;
		} else {
			indicadorBoolean = false;
		}
		
		return indicadorBoolean;
	}

	public void setIndicadorBoolean(Boolean indicadorBoolean) {
		
		if(indicadorBoolean == true){
			indicadorInicial = new Long("1");
		} else {
			indicadorInicial = new Long("0");
		}
		
		this.indicadorBoolean = indicadorBoolean;
	}
	
	public Boolean getIndicadorCausalBoolean() {
		
		if(indicadorCausal == 1){
			indicadorCausalBoolean = true;
		} else {
			indicadorCausalBoolean = false;
		}
		
		return indicadorCausalBoolean;
	}

	public void setIndicadorCausalBoolean(Boolean indicadorCausalBoolean) {
		
		if(indicadorCausalBoolean == true){
			indicadorCausal = new Long("1");
		}else{
			indicadorCausal = new Long("0");
		}
	}
	
}