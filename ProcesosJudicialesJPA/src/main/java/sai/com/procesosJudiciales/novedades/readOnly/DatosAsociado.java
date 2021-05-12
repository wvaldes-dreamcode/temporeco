package sai.com.procesosJudiciales.novedades.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the V_DATOS_ASOCIADOS database table.
 * 
 */
@Entity
@Table(name="V_DATOS_ASOCIADOS")
public class DatosAsociado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CODIGO_SUBTEMA_DATO", nullable=false, length=20)
	private String codigoSubtemaDato;

	@Column(name="DESC_DATO_BASICO", nullable=false, length=20)
	private String descDatoBasico;

	@Column(name="DESC_DATO_VARIABLE", nullable=false, length=80)
	private String descDatoVariable;

	@Column(name="LONGITUD_DATO_VARIABLE", precision=5)
	private BigDecimal longitudDatoVariable;

	@Id
	@Column(name="SECUENCIA_DATO_ASOCIADO", nullable=false, precision=15)
	private BigDecimal secuenciaDatoAsociado;

	@Column(name="SECUENCIA_DATO_BASICO", nullable=false, precision=15)
	private BigDecimal secuenciaDatoBasico;

	@Column(name="SECUENCIA_DATO_VARIABLE", nullable=false, precision=15)
	private BigDecimal secuenciaDatoVariable;

	@Column(name="TEMA_DATO_ASOCIADO", nullable=false, length=120)
	private String temaDatoAsociado;

	@Column(name="TIPO_DATO_BASICO", nullable=false, length=20)
	private String tipoDatoBasico;

	@Column(name="ESTADO_DATO_ASOCIADO", length=1)
	private String estadoDatoAsociado;
	
	
	@Column(name="ESTADO_DATO_VARIABLE", length=1)
	private String estadoDatoVariable;

	
	public String getEstadoDatoVariable() {
		return estadoDatoVariable;
	}

	public void setEstadoDatoVariable(String estadoDatoVariable) {
		this.estadoDatoVariable = estadoDatoVariable;
	}

	public String getEstadoDatoAsociado() {
		return estadoDatoAsociado;
	}

	public void setEstadoDatoAsociado(String estadoDatoAsociado) {
		this.estadoDatoAsociado = estadoDatoAsociado;
	}

	public DatosAsociado() {
    }

	public String getCodigoSubtemaDato() {
		return this.codigoSubtemaDato;
	}

	public void setCodigoSubtemaDato(String codigoSubtemaDato) {
		this.codigoSubtemaDato = codigoSubtemaDato;
	}

	public String getDescDatoBasico() {
		return this.descDatoBasico;
	}

	public void setDescDatoBasico(String descDatoBasico) {
		this.descDatoBasico = descDatoBasico;
	}

	public String getDescDatoVariable() {
		return this.descDatoVariable;
	}

	public void setDescDatoVariable(String descDatoVariable) {
		this.descDatoVariable = descDatoVariable;
	}

	public BigDecimal getLongitudDatoVariable() {
		return this.longitudDatoVariable;
	}

	public void setLongitudDatoVariable(BigDecimal longitudDatoVariable) {
		this.longitudDatoVariable = longitudDatoVariable;
	}

	public BigDecimal getSecuenciaDatoAsociado() {
		return this.secuenciaDatoAsociado;
	}

	public void setSecuenciaDatoAsociado(BigDecimal secuenciaDatoAsociado) {
		this.secuenciaDatoAsociado = secuenciaDatoAsociado;
	}

	public BigDecimal getSecuenciaDatoBasico() {
		return this.secuenciaDatoBasico;
	}

	public void setSecuenciaDatoBasico(BigDecimal secuenciaDatoBasico) {
		this.secuenciaDatoBasico = secuenciaDatoBasico;
	}

	public BigDecimal getSecuenciaDatoVariable() {
		return this.secuenciaDatoVariable;
	}

	public void setSecuenciaDatoVariable(BigDecimal secuenciaDatoVariable) {
		this.secuenciaDatoVariable = secuenciaDatoVariable;
	}

	public String getTemaDatoAsociado() {
		return this.temaDatoAsociado;
	}

	public void setTemaDatoAsociado(String temaDatoAsociado) {
		this.temaDatoAsociado = temaDatoAsociado;
	}

	public String getTipoDatoBasico() {
		return this.tipoDatoBasico;
	}

	public void setTipoDatoBasico(String tipoDatoBasico) {
		this.tipoDatoBasico = tipoDatoBasico;
	}

}