package sai.com.procesosJudiciales.titulos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/* **********************************************************************************
 *	Modificacion:	RRCE
 *	Autor:			German Fernandez
 *  Fecha:			13/06/2013
 *  Descripcion		creacion de entity
 ********************************************************************************** */	

@Entity
@Table(name = "ESTADOS_RESPONSABLES")
@NamedQueries({
    @NamedQuery(name = "EstadosResponsables.findAll", query = "SELECT e FROM EstadosResponsables e")})
public class EstadosResponsables implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
	@SequenceGenerator(name="ESTADOS_RESPONSABLESSECUENCIA_GENERATOR", sequenceName="SEQ_ESTADOS_RESPONSABLES", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADOS_RESPONSABLESSECUENCIA_GENERATOR")
    @Column(name = "SECUENCIA")
    private Long secuencia;
    @Basic(optional = false)
    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
        
    @JoinColumn(name = "SECUENCIA_RESPONSABLE_DOC", referencedColumnName = "SECUENCIA_RESPONSABLE_DOC")
    @ManyToOne(optional = false)
    private ResponsableDocumento responsableDocumentoJudicial;
    
    @JoinColumn(name = "SECUENCIA_ESTADO_DOCUMENTO", referencedColumnName = "SECUENCIA_ESTADO_DOCUMENTO")
    @ManyToOne(optional = false)
    private EstadoDocumentoJudicial estadoDocumentoJudicial;
        
    public EstadosResponsables() {
    }

    public EstadosResponsables(Long secuencia) {
        this.secuencia = secuencia;
    }

    public EstadosResponsables(Long secuencia, String usuarioCreacion, Date fechaCreacion) {
        this.secuencia = secuencia;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Long secuencia) {
        this.secuencia = secuencia;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public ResponsableDocumento getResponsableDocumentoJudicial() {
        return responsableDocumentoJudicial;
    }

    public void setResponsableDocumento(ResponsableDocumento responsableDocumentoJudicial) {
        this.responsableDocumentoJudicial = responsableDocumentoJudicial;
    }

    public EstadoDocumentoJudicial getEstadoDocumentoJudicial() {
        return estadoDocumentoJudicial;
    }

    public void setEstadoDocumentoJudicial(EstadoDocumentoJudicial estadoDocumentoJudicial) {
        this.estadoDocumentoJudicial = estadoDocumentoJudicial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuencia != null ? secuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosResponsables)) {
            return false;
        }
        EstadosResponsables other = (EstadosResponsables) object;
        if ((this.secuencia == null && other.secuencia != null) || (this.secuencia != null && !this.secuencia.equals(other.secuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.EstadosResponsables[ secuencia=" + secuencia + " ]";
    }
    
}
