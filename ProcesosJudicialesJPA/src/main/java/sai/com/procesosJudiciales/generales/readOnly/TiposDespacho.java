package sai.com.procesosJudiciales.generales.readOnly;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the V_F_TIPOS_DESPACHO database table.
 * 
 */
@Entity
@Table(name="V_F_TIPOS_DESPACHO")
@NamedQuery(name = "TiposDespacho", query = "select tp from TiposDespacho tp order by tp.nombre")
public class TiposDespacho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="NOMBRE", length=240)
	private String nombre;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Id
	@Column(name="CODIGO", length=12)
	private String codigo;

	

    public TiposDespacho() {
    }

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}