package sai.com.procesosJudiciales.titulos.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "RESPONSABLE_DOCUMENTO_JUDICIAL")
@NamedQueries({
    @NamedQuery(name = "ResponsableDocumentoJudicial.findAll", query = "SELECT r FROM ResponsableDocumentoJudicial r")})
public class ResponsableDocumentoJudicial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SECUENCIA_RESPONSABLE_DOC")
    private Long secuenciaResponsableDoc;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "ABREVIACION")
    private String abreviacion;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;
    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;
    @Column(name = "FECHA_MODIFICACION")
    private String fechaModificacion;
    
    @OneToMany(mappedBy = "responsableDocumentoJudicial")
    private Collection<EstadosResponsables> estadosResponsablesCollection;

    public ResponsableDocumentoJudicial() {
    }

    public ResponsableDocumentoJudicial(Long secuenciaResponsableDoc) {
        this.secuenciaResponsableDoc = secuenciaResponsableDoc;
    }

    public ResponsableDocumentoJudicial(Long secuenciaResponsableDoc, String descripcion, String abreviacion, Date fechaCreacion, String usuarioCreacion) {
        this.secuenciaResponsableDoc = secuenciaResponsableDoc;
        this.descripcion = descripcion;
        this.abreviacion = abreviacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
    }

    public Long getSecuenciaResponsableDoc() {
        return secuenciaResponsableDoc;
    }

    public void setSecuenciaResponsableDoc(Long secuenciaResponsableDoc) {
        this.secuenciaResponsableDoc = secuenciaResponsableDoc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Collection<EstadosResponsables> getEstadosResponsablesCollection() {
        return estadosResponsablesCollection;
    }

    public void setEstadosResponsablesCollection(Collection<EstadosResponsables> estadosResponsablesCollection) {
        this.estadosResponsablesCollection = estadosResponsablesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuenciaResponsableDoc != null ? secuenciaResponsableDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResponsableDocumentoJudicial)) {
            return false;
        }
        ResponsableDocumentoJudicial other = (ResponsableDocumentoJudicial) object;
        if ((this.secuenciaResponsableDoc == null && other.secuenciaResponsableDoc != null) || (this.secuenciaResponsableDoc != null && !this.secuenciaResponsableDoc.equals(other.secuenciaResponsableDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ResponsableDocumentoJudicial[ secuenciaResponsableDoc=" + secuenciaResponsableDoc + " ]";
    }
    
}
