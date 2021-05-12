package sai.com.procesosJudiciales.generales.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * The persistent class for the V_F_INMOBILIARIAS database table.
 * 
 */

@IdClass(InmobiliariaKey.class)
@Entity
@Table(name="V_F_INMOBILIARIAS")
public class InmobiliariasV implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=4000)
	private String inmobiliaria;

	@Id
	@Column(name="NUMERO_INMO", nullable=false, precision=12)
	private BigDecimal numeroInmo;

	@Id
	@Column(name="TIPOID_INMO", nullable=false, length=2)
	private String tipoidInmo;

    public InmobiliariasV() {
    }

	public String getInmobiliaria() {
		return this.inmobiliaria;
	}

	public void setInmobiliaria(String inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
	}

	public BigDecimal getNumeroInmo() {
		return this.numeroInmo;
	}

	public void setNumeroInmo(BigDecimal numeroInmo) {
		this.numeroInmo = numeroInmo;
	}

	public String getTipoidInmo() {
		return this.tipoidInmo;
	}

	public void setTipoidInmo(String tipoidInmo) {
		this.tipoidInmo = tipoidInmo;
	}

}