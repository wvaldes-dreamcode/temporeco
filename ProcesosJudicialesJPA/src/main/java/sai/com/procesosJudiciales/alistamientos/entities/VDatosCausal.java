package sai.com.procesosJudiciales.alistamientos.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the V_DATOS_CAUSAL database table.
 * 
 */
@Entity
@Table(name="V_DATOS_CAUSAL")
public class VDatosCausal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CONTENIDO_DATO", length=100)
	private String contenidoDato;

	@Column(name="DESC_DATO_VARIABLE", nullable=false, length=80)
	private String descDatoVariable;

	@Column(name="SECUENCIA_CAUSAL_DEV_ALIT", nullable=false, precision=15)
	private BigDecimal secuenciaCausalDevAlit;

	@Id
	@Column(name="SECUENCIA_DATOS_CAU_DEV_ALI", nullable=false, precision=15)
	private BigDecimal secuenciaDatosCauDevAli;

    public VDatosCausal() {
    }

	public String getContenidoDato() {
		return this.contenidoDato;
	}

	public void setContenidoDato(String contenidoDato) {
		this.contenidoDato = contenidoDato;
	}

	public String getDescDatoVariable() {
		return this.descDatoVariable;
	}

	public void setDescDatoVariable(String descDatoVariable) {
		this.descDatoVariable = descDatoVariable;
	}

	public BigDecimal getSecuenciaCausalDevAlit() {
		return this.secuenciaCausalDevAlit;
	}

	public void setSecuenciaCausalDevAlit(BigDecimal secuenciaCausalDevAlit) {
		this.secuenciaCausalDevAlit = secuenciaCausalDevAlit;
	}

	public BigDecimal getSecuenciaDatosCauDevAli() {
		return this.secuenciaDatosCauDevAli;
	}

	public void setSecuenciaDatosCauDevAli(BigDecimal secuenciaDatosCauDevAli) {
		this.secuenciaDatosCauDevAli = secuenciaDatosCauDevAli;
	}

}