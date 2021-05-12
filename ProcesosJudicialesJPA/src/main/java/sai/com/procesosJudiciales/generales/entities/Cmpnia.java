package sai.com.procesosJudiciales.generales.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the CMPNIAS database table.
 * 
 */
@Entity
@Table(name="CMPNIAS")
public class Cmpnia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CIA_CDGO")
	private String ciaCdgo;

	@Column(name="CIA_ESTDO")
	private String ciaEstdo;

    @Temporal( TemporalType.DATE)
	@Column(name="CIA_FCHA_ACTLZCION")
	private Date ciaFchaActlzcion;

	@Column(name="CIA_NMBRE")
	private String ciaNmbre;

	@Column(name="CIA_NMRO_IDNTFCCION")
	private BigDecimal ciaNmroIdntfccion;

	@Column(name="CIA_TPO_IDNTFCCION")
	private String ciaTpoIdntfccion;

	@Column(name="CIA_USRIO")
	private String ciaUsrio;

    public Cmpnia() {
    }

	public String getCiaCdgo() {
		return this.ciaCdgo;
	}

	public void setCiaCdgo(String ciaCdgo) {
		this.ciaCdgo = ciaCdgo;
	}

	public String getCiaEstdo() {
		return this.ciaEstdo;
	}

	public void setCiaEstdo(String ciaEstdo) {
		this.ciaEstdo = ciaEstdo;
	}

	public Date getCiaFchaActlzcion() {
		return this.ciaFchaActlzcion;
	}

	public void setCiaFchaActlzcion(Date ciaFchaActlzcion) {
		this.ciaFchaActlzcion = ciaFchaActlzcion;
	}

	public String getCiaNmbre() {
		return this.ciaNmbre;
	}

	public void setCiaNmbre(String ciaNmbre) {
		this.ciaNmbre = ciaNmbre;
	}

	public BigDecimal getCiaNmroIdntfccion() {
		return this.ciaNmroIdntfccion;
	}

	public void setCiaNmroIdntfccion(BigDecimal ciaNmroIdntfccion) {
		this.ciaNmroIdntfccion = ciaNmroIdntfccion;
	}

	public String getCiaTpoIdntfccion() {
		return this.ciaTpoIdntfccion;
	}

	public void setCiaTpoIdntfccion(String ciaTpoIdntfccion) {
		this.ciaTpoIdntfccion = ciaTpoIdntfccion;
	}

	public String getCiaUsrio() {
		return this.ciaUsrio;
	}

	public void setCiaUsrio(String ciaUsrio) {
		this.ciaUsrio = ciaUsrio;
	}

}