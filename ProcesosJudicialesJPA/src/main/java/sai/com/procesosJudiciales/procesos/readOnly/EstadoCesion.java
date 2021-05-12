package sai.com.procesosJudiciales.procesos.readOnly;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the V_F_ESTADO_CESION database table.
 * 
 */
@Entity
@Table(name="V_F_ESTADO_CESION")
@NamedQuery (name="estadosCesion", query="select e from EstadoCesion e")
public class EstadoCesion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false, length=240)
	private String codigo;

	@Column(nullable=false, length=100)
	private String dominio;

	@Column(length=240)
	private String estado;

    public EstadoCesion() {
    }

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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