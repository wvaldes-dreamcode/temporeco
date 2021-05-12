package sai.com.procesosJudiciales.ubicacion.readOnly;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the V_F_LISTA_TRANSACCIONES database table.
 * 
 */
@Entity
@Table(name="V_F_LISTA_TRANSACCIONES")
public class TipoTransaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false, length=240)
	private String codigo;

	@Column(length=240)
	private String descripcion;

    public TipoTransaccion() {
    }

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String toString(){
		
		return descripcion;
		
	}

}