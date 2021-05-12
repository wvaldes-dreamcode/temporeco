package sai.com.procesosJudiciales.generales.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the VM_DIVISIONES_POLITICAS database table.
 * 
 */
@Entity
@Table(name="VM_DIVISIONES_POLITICAS")
@NamedQuery(name="Ciudades", query="select c from Ciudades c where c.codPais = 1 order by c.nomCiu")
public class Ciudades implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Column(name="COD_CIU", nullable=false, precision=10)
	private BigDecimal codCiu;

	@Column(name="COD_DPTO", nullable=false, precision=10)
	private BigDecimal codDpto;

	@Column(name="COD_PAIS", nullable=false, precision=10)
	private BigDecimal codPais;
	
	@Id
	@Column(name="CODAZZI_CIU", precision=13)
	private BigDecimal codazziCiu;

	@Column(name="CODAZZI_DPTO", precision=13)
	private BigDecimal codazziDpto;

	@Column(name="CODAZZI_PAIS", precision=13)
	private BigDecimal codazziPais;

	@Column(name="CODIGO_CIU", nullable=false, precision=10)
	private BigDecimal codigoCiu;

	@Column(name="NIV_CIU", nullable=false, length=3)
	private String nivCiu;

	@Column(name="NIV_DPTO", nullable=false, length=3)
	private String nivDpto;

	@Column(name="NIV_PAIS", nullable=false, length=3)
	private String nivPais;

	@Column(name="NOM_CIU", nullable=false, length=60)
	private String nomCiu;

	@Column(name="NOM_DPTO", nullable=false, length=60)
	private String nomDpto;

	@Column(name="NOM_PAIS", nullable=false, length=60)
	private String nomPais;

    public Ciudades() {
    }

	public BigDecimal getCodCiu() {
		return this.codCiu;
	}

	public void setCodCiu(BigDecimal codCiu) {
		this.codCiu = codCiu;
	}

	public BigDecimal getCodDpto() {
		return this.codDpto;
	}

	public void setCodDpto(BigDecimal codDpto) {
		this.codDpto = codDpto;
	}

	public BigDecimal getCodPais() {
		return this.codPais;
	}

	public void setCodPais(BigDecimal codPais) {
		this.codPais = codPais;
	}

	public BigDecimal getCodazziCiu() {
		return this.codazziCiu;
	}

	public void setCodazziCiu(BigDecimal codazziCiu) {
		this.codazziCiu = codazziCiu;
	}

	public BigDecimal getCodazziDpto() {
		return this.codazziDpto;
	}

	public void setCodazziDpto(BigDecimal codazziDpto) {
		this.codazziDpto = codazziDpto;
	}

	public BigDecimal getCodazziPais() {
		return this.codazziPais;
	}

	public void setCodazziPais(BigDecimal codazziPais) {
		this.codazziPais = codazziPais;
	}

	public BigDecimal getCodigoCiu() {
		return this.codigoCiu;
	}

	public void setCodigoCiu(BigDecimal codigoCiu) {
		this.codigoCiu = codigoCiu;
	}

	public String getNivCiu() {
		return this.nivCiu;
	}

	public void setNivCiu(String nivCiu) {
		this.nivCiu = nivCiu;
	}

	public String getNivDpto() {
		return this.nivDpto;
	}

	public void setNivDpto(String nivDpto) {
		this.nivDpto = nivDpto;
	}

	public String getNivPais() {
		return this.nivPais;
	}

	public void setNivPais(String nivPais) {
		this.nivPais = nivPais;
	}

	public String getNomCiu() {
		return this.nomCiu;
	}

	public void setNomCiu(String nomCiu) {
		this.nomCiu = nomCiu;
	}

	public String getNomDpto() {
		return this.nomDpto;
	}

	public void setNomDpto(String nomDpto) {
		this.nomDpto = nomDpto;
	}

	public String getNomPais() {
		return this.nomPais;
	}

	public void setNomPais(String nomPais) {
		this.nomPais = nomPais;
	}

}