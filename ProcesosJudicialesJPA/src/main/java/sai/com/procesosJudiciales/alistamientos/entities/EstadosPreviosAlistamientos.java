package sai.com.procesosJudiciales.alistamientos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

/**
 *
 * @author 79885378
 */

@Entity
@Table(name = "ESTADOS_PREVIOS_ALISTAMIENTOS")
@NamedQueries({
    @NamedQuery(name = "EstadosPreviosAlistamientos.findAll", query = "SELECT e FROM EstadosPreviosAlistamientos e")})
public class EstadosPreviosAlistamientos implements Serializable {
    private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="ESTADOS_PREVIOS_ALISTAMIENTOS_SECUENCIA_GENERATOR", sequenceName="SEQ_EST_ALI_EST_ALI_PRV", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADOS_PREVIOS_ALISTAMIENTOS_SECUENCIA_GENERATOR")
	@Column(unique=true, nullable=false, precision=15)
    private Long secuencia;

    @JoinColumn(name="CODIGO_ESTADO_ALISTAMIENTO", nullable=false)
    @ManyToOne(fetch=FetchType.LAZY)
    private EstadosAlistamiento estadoAlistamiento;

    @JoinColumn(name="CODIGO_ESTADO_ALISTMTO_PRV", nullable=false)
    @ManyToOne(fetch=FetchType.LAZY)
    private EstadosAlistamiento estadoAlistamientoPrevio;    
    
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

    public EstadosPreviosAlistamientos() {
    }

    public EstadosPreviosAlistamientos(Long secuencia) {
        this.secuencia = secuencia;
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
    
    public EstadosAlistamiento getEstadoAlistamiento() {
		return estadoAlistamiento;
	}

	public void setEstadoAlistamiento(EstadosAlistamiento estadoAlistamiento) {
		this.estadoAlistamiento = estadoAlistamiento;
	}

	public EstadosAlistamiento getEstadoAlistamientoPrevio() {
		return estadoAlistamientoPrevio;
	}

	public void setEstadoAlistamientoPrevio(
			EstadosAlistamiento estadoAlistamientoPrevio) {
		this.estadoAlistamientoPrevio = estadoAlistamientoPrevio;
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
        if (!(object instanceof EstadosPreviosAlistamientos)) {
            return false;
        }
        EstadosPreviosAlistamientos other = (EstadosPreviosAlistamientos) object;
        if ((this.secuencia == null && other.secuencia != null) || (this.secuencia != null && !this.secuencia.equals(other.secuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.EstadosPreviosAlistamientos[ secuencia=" + secuencia + " ]";
    }
    
}
