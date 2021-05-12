package sai.com.procesosJudiciales.procesos.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the V_F_ESTADO database table.
 * 
 */
@Entity
@Table(name="ESTADOS_PROCESO")
@NamedQuery (name="estadosProceso", query="select e from EstadoProceso e" )
public class EstadoProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ABREVIACION_ESTADO", nullable=false, length=100)
	private String dominio;

	@Column(name="DESCRIPCION_ESTADO", length=240)
	private String estado;
	
	@Id
	@Column(name="SECUENCIA_ESTADO", length=12)
	private BigDecimal codigo;
	

    public BigDecimal getCodigo() {
		return codigo;
	}

	public void setCodigo(BigDecimal codigo) {
		this.codigo = codigo;
	}

	public EstadoProceso() {
    }

	public String getDominio() {
		return this.dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
}