package sai.com.procesosJudiciales.ubicacion.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "UBICACIONES_PREVIAS_ALIST")

public class UbicacionesPrevias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
	@SequenceGenerator(name="UBICACIONES_PREVIAS_ALIST_SECUENCIA_GENERATOR", sequenceName="SEQ_EST_ALI_EST_ALI_PRV", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UBICACIONES_PREVIAS_ALIST_SECUENCIA_GENERATOR")
    @Column(name = "SECUENCIA")
    private BigDecimal secuencia;
    
    @JoinColumn(name="NUMERO_UBICACION", nullable=false)
    @ManyToOne(optional=false)
    private Ubicacion ubicacion;

    @JoinColumn(name="NUMERO_UBICACION_PRV", nullable=false)
    @ManyToOne(optional=false)
    private Ubicacion ubicacionPrevia;    
    
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

    public UbicacionesPrevias() {
    }

    public BigDecimal getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(BigDecimal secuencia) {
        this.secuencia = secuencia;
    }    

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Ubicacion getUbicacionPrevia() {
		return ubicacionPrevia;
	}

	public void setUbicacionPrevia(Ubicacion ubicacionPrevia) {
		this.ubicacionPrevia = ubicacionPrevia;
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
}
