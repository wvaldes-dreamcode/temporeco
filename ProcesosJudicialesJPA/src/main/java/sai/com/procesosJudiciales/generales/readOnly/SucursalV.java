package sai.com.procesosJudiciales.generales.readOnly;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the V_F_SUCURSALES database table.
 * 
 */
@Entity
@Table(name="V_F_SUCURSALES")
public class SucursalV implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="COD_CIA", nullable=false, length=2)
	private String codCia;

	@Id
	@Column(nullable=false, length=5)
	private String codigo;

	@Column(nullable=false, length=30)
	private String nombre;

    public SucursalV() {
    }

	public String getCodCia() {
		return this.codCia;
	}

	public void setCodCia(String codCia) {
		this.codCia = codCia;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}