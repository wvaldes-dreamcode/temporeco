package sai.com.procesosJudiciales.titulos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 79885378
 */
@Entity
@Table(name = "HISTORICO_MOV_DOC_JUDICIAL")
@NamedQueries({
    @NamedQuery(name = "HistoricoMovDocJudicial.findAll", query = "SELECT h FROM HistoricoMovDocJudicial h")})
public class HistoricoMovDocJudicial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SECUENCIA_HISTORICO")
    private Long secuenciaHistorico;
    @Column(name = "SECUENCIA_MOVIMIENTO_JUDICIAL")
    private Long secuenciaMovimientoJudicial;
    @Column(name = "SECUENCIA_DOCUMENTO_JUDICIAL")
    private Long secuenciaDocumentoJudicial;
    //SECUENCIA_ESTADO_DOCUMENTO
    //private Long secuenciaEstadoDocumento;
    @Column(name = "FECHA_ESTADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEstado;
    @Column(name = "ESTADO_DOCUMENTO")
    private String estadoDocumento;
    @Column(name = "NUMERO_ALISTAMIENTO")
    private String numeroAlistamiento;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;
    @Column(name = "NUMERO_OBLIGACION")
    private Long numeroObligacion;
    @Column(name = "RESPONSABLE_DESCRIPCION")
    private String responsableDescripcion;
    @Column(name = "CAUSAL")
    private String causal;

    @JoinColumn(name = "SECUENCIA_ESTADO_DOCUMENTO", referencedColumnName = "SECUENCIA_ESTADO_DOCUMENTO")
    @ManyToOne(optional = false)
    private EstadoDocumentoJudicial estadoDocumentoJudicial;    
    
    public HistoricoMovDocJudicial() {
    }    
    
    
    public EstadoDocumentoJudicial getEstadoDocumentoJudicial() {
		return estadoDocumentoJudicial;
	}


	public void setEstadoDocumentoJudicial(
			EstadoDocumentoJudicial estadoDocumentoJudicial) {
		this.estadoDocumentoJudicial = estadoDocumentoJudicial;
	}


	public HistoricoMovDocJudicial(Long secuenciaHistorico) {
        this.secuenciaHistorico = secuenciaHistorico;
    }

    public Long getSecuenciaHistorico() {
        return secuenciaHistorico;
    }

    public void setSecuenciaHistorico(Long secuenciaHistorico) {
        this.secuenciaHistorico = secuenciaHistorico;
    }

    public Long getSecuenciaMovimientoJudicial() {
        return secuenciaMovimientoJudicial;
    }

    public void setSecuenciaMovimientoJudicial(Long secuenciaMovimientoJudicial) {
        this.secuenciaMovimientoJudicial = secuenciaMovimientoJudicial;
    }

    public Long getSecuenciaDocumentoJudicial() {
        return secuenciaDocumentoJudicial;
    }

    public void setSecuenciaDocumentoJudicial(Long secuenciaDocumentoJudicial) {
        this.secuenciaDocumentoJudicial = secuenciaDocumentoJudicial;
    }

    /*public Long getSecuenciaEstadoDocumento() {
        return secuenciaEstadoDocumento;
    }

    public void setSecuenciaEstadoDocumento(Long secuenciaEstadoDocumento) {
        this.secuenciaEstadoDocumento = secuenciaEstadoDocumento;
    }*/

    public Date getFechaEstado() {
        return fechaEstado;
    }

    public void setFechaEstado(Date fechaEstado) {
        this.fechaEstado = fechaEstado;
    }

    public String getEstadoDocumento() {
        return estadoDocumento;
    }

    public void setEstadoDocumento(String estadoDocumento) {
        this.estadoDocumento = estadoDocumento;
    }

    public String getNumeroAlistamiento() {
        return numeroAlistamiento;
    }

    public void setNumeroAlistamiento(String numeroAlistamiento) {
        this.numeroAlistamiento = numeroAlistamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Long getNumeroObligacion() {
        return numeroObligacion;
    }

    public void setNumeroObligacion(Long numeroObligacion) {
        this.numeroObligacion = numeroObligacion;
    }
    
    public String getResponsableDescripcion() {
		return responsableDescripcion;
	}

	public void setResponsableDescripcion(String responsableDescripcion) {
		this.responsableDescripcion = responsableDescripcion;
	}

	public String getCausal() {
		return causal;
	}

	public void setCausal(String causal) {
		this.causal = causal;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (secuenciaHistorico != null ? secuenciaHistorico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoMovDocJudicial)) {
            return false;
        }
        HistoricoMovDocJudicial other = (HistoricoMovDocJudicial) object;
        if ((this.secuenciaHistorico == null && other.secuenciaHistorico != null) || (this.secuenciaHistorico != null && !this.secuenciaHistorico.equals(other.secuenciaHistorico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.HistoricoMovDocJudicial[ secuenciaHistorico=" + secuenciaHistorico + " ]";
    }
    
}
