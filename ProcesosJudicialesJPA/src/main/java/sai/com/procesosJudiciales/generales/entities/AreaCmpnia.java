package sai.com.procesosJudiciales.generales.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the AREA_CMPNIAS database table.
 * 
 */
@IdClass(AreaCmpniaPK.class)
@Entity
@Table(name="AREA_CMPNIAS")
public class AreaCmpnia implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ACO_CDGO_AREA")
	private String acoCdgoArea;

	@Id
	@Column(name="ACO_CDGO_CIA")
	private String acoCdgoCia;

    @Temporal( TemporalType.DATE)
	@Column(name="ACO_FCHA_ACTLZCION")
	private Date acoFchaActlzcion;

	@Column(name="ACO_NMBRE")
	private String acoNmbre;

	@Column(name="ACO_USRIO")
	private String acoUsrio;

    public AreaCmpnia() {
    }	
		
	public String getAcoCdgoArea() {
		return acoCdgoArea;
	}

	public void setAcoCdgoArea(String acoCdgoArea) {
		this.acoCdgoArea = acoCdgoArea;
	}

	public String getAcoCdgoCia() {
		return acoCdgoCia;
	}

	public void setAcoCdgoCia(String acoCdgoCia) {
		this.acoCdgoCia = acoCdgoCia;
	}

	public Date getAcoFchaActlzcion() {
		return this.acoFchaActlzcion;
	}

	public void setAcoFchaActlzcion(Date acoFchaActlzcion) {
		this.acoFchaActlzcion = acoFchaActlzcion;
	}

	public String getAcoNmbre() {
		return this.acoNmbre;
	}

	public void setAcoNmbre(String acoNmbre) {
		this.acoNmbre = acoNmbre;
	}

	public String getAcoUsrio() {
		return this.acoUsrio;
	}

	public void setAcoUsrio(String acoUsrio) {
		this.acoUsrio = acoUsrio;
	}

}