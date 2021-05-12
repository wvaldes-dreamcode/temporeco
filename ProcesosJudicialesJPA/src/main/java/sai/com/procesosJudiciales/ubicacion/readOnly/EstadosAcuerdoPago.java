package sai.com.procesosJudiciales.ubicacion.readOnly;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the V_F_ESTADOS_ACUERDO_PAGO database table.
 * 
 */
@Entity
@Table(name="V_F_ESTADOS_ACUERDO_PAGO")
public class EstadosAcuerdoPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false, length=240)
	private String codigo;

	@Column(length=240)
	private String descripcion;

    public EstadosAcuerdoPago() {
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

}