package sai.com.procesosJudiciales.alistamientos.entities;

import java.io.Serializable;
import java.util.Date;

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

import sai.com.procesosJudiciales.ubicacion.entities.Ubicacion;

/**
 *
 * @author 79885378
 */
@Entity
@Table(name = "ESTADOS_ALISTAMIENTO_UBICACION")
@NamedQueries({
    @NamedQuery(name = "EstadosAlistamientoUbicacion.findAll", query = "SELECT e FROM EstadosAlistamientoUbicacion e")})
public class EstadosAlistamientoUbicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
	@SequenceGenerator(name="ESTADO_ALISTAMIENTO_UBICACION_SECUENCIAESTADODOCUMENTO_GENERATOR", sequenceName="SEQ_ESTDO_ALIST_UBICACION", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADO_ALISTAMIENTO_UBICACION_SECUENCIAESTADODOCUMENTO_GENERATOR")
    @Column(name = "SECUENCIA_ESTALIST_UBICACION")
    private Long secuenciaEstalistUbicacion;
    
    @JoinColumn(name = "CODIGO_ESTADO_ALISTAMIENTO", referencedColumnName = "CODIGO_ESTADO_ALISTAMIENTO")
    @ManyToOne(optional=false)
    private EstadosAlistamiento estadosAlistamiento;

    @JoinColumn(name="NUMERO_UBICACION", referencedColumnName = "NUMERO_UBICACION")
    @ManyToOne(optional=false)
    private Ubicacion ubicacion;
    
    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    public EstadosAlistamientoUbicacion() {
    }

    public EstadosAlistamientoUbicacion(Long secuenciaEstalistUbicacion) {
        this.secuenciaEstalistUbicacion = secuenciaEstalistUbicacion;
    }

    public Long getSecuenciaEstalistUbicacion() {
        return secuenciaEstalistUbicacion;
    }

    public void setSecuenciaEstalistUbicacion(Long secuenciaEstalistUbicacion) {
        this.secuenciaEstalistUbicacion = secuenciaEstalistUbicacion;
    }    

    public EstadosAlistamiento getEstadosAlistamiento() {
		return estadosAlistamiento;
	}

	public void setEstadosAlistamiento(EstadosAlistamiento estadosAlistamiento) {
		this.estadosAlistamiento = estadosAlistamiento;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuenciaEstalistUbicacion != null ? secuenciaEstalistUbicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosAlistamientoUbicacion)) {
            return false;
        }
        EstadosAlistamientoUbicacion other = (EstadosAlistamientoUbicacion) object;
        if ((this.secuenciaEstalistUbicacion == null && other.secuenciaEstalistUbicacion != null) || (this.secuenciaEstalistUbicacion != null && !this.secuenciaEstalistUbicacion.equals(other.secuenciaEstalistUbicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.EstadosAlistamientoUbicacion[ secuenciaEstalistUbicacion=" + secuenciaEstalistUbicacion + " ]";
    }
    
}
