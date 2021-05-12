package sai.com.procesosJudiciales.procesos.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the V_F_CIUDADES_ABOGADO database table.
 * 
 */
@Entity
@Table(name="V_F_CIUDADES_ABOGADO")
@NamedQuery(name = "CiudadesByAbogado", query = "select ca from CiudadesAbogado ca where ca.sucCiaCdgo = :sucCod and  ca.secuenciaAbogado = :abo order by ca.ciudad")
public class CiudadesAbogado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=123)
	private String ciudad;

	@Column(name="SECUENCIA_ABOGADO", nullable=false, precision=15)
	private BigDecimal secuenciaAbogado;

	@Column(name="SUC_CIA_CDGO", nullable=false, length=2)
	private String sucCiaCdgo;

	
	
	@Id
	@Column(name="CODIGO", nullable=false, precision=15)
	private BigDecimal codigo;

    public BigDecimal getCodigo() {
		return codigo;
	}

	public void setCodigo(BigDecimal codigo) {
		this.codigo = codigo;
	}

	public CiudadesAbogado() {
    }

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public BigDecimal getSecuenciaAbogado() {
		return this.secuenciaAbogado;
	}

	public void setSecuenciaAbogado(BigDecimal secuenciaAbogado) {
		this.secuenciaAbogado = secuenciaAbogado;
	}

	public String getSucCiaCdgo() {
		return this.sucCiaCdgo;
	}

	public void setSucCiaCdgo(String sucCiaCdgo) {
		this.sucCiaCdgo = sucCiaCdgo;
	}

	
	
}