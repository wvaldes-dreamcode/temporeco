package sai.com.procesosJudiciales.generales.readOnly;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the V_TIPOS_DOCUMENTO database table.
 * 
 */
@Entity
@Table(name="V_TIPOS_DOCUMENTO")
public class TiposDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false, length=3)
	private String codigo;

	@Column(nullable=false, length=60)
	private String descripcion;


	@Column(name="TIPO_TERCERO", nullable=false, length=1)
	private String tipoTercero;

	

    public TiposDocumento() {
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

	

	public String getTipoTercero() {
		return this.tipoTercero;
	}

	public void setTipoTercero(String tipoTercero) {
		this.tipoTercero = tipoTercero;
	}	

}