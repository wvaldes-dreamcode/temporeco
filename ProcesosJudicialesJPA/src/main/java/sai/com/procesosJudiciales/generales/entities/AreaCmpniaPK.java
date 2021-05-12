package sai.com.procesosJudiciales.generales.entities;

import java.io.Serializable;


/**
 * The primary key class for the AREA_CMPNIAS database table.
 * 
 */

public class AreaCmpniaPK implements Serializable {

	public String acoCdgoArea;
	public String acoCdgoCia;

	public AreaCmpniaPK() {

	}

	public AreaCmpniaPK(String acoCdgoArea, String acoCdgoCia) {
		this.acoCdgoCia = acoCdgoCia;
		this.acoCdgoArea = acoCdgoArea;
	}


	public boolean equals(Object otherOb) {
		if (this == otherOb) {
			return true;
		}

		if (!(otherOb instanceof AreaCmpniaPK)) {
			return false;
		}

		AreaCmpniaPK other = (AreaCmpniaPK) otherOb;
		return ((acoCdgoCia==null?other.acoCdgoCia==null:acoCdgoCia.equals
				(other.acoCdgoCia)) && (acoCdgoArea.compareTo(other.acoCdgoArea)==0 ));
	}
	public int hashCode() {
		return ((acoCdgoCia==null?0:acoCdgoCia.hashCode()) ^ (acoCdgoArea.hashCode()));
	}	




	//default serial version id, required for serializable classes.
	/*private static final long serialVersionUID = 1L;

	@Column(name="ACO_CDGO_AREA")
	private String acoCdgoArea;

	@Column(name="ACO_CDGO_CIA")
	private String acoCdgoCia;

    public AreaCmpniaPK() {
    }
	public String getAcoCdgoArea() {
		return this.acoCdgoArea;
	}
	public void setAcoCdgoArea(String acoCdgoArea) {
		this.acoCdgoArea = acoCdgoArea;
	}
	public String getAcoCdgoCia() {
		return this.acoCdgoCia;
	}
	public void setAcoCdgoCia(String acoCdgoCia) {
		this.acoCdgoCia = acoCdgoCia;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AreaCmpniaPK)) {
			return false;
		}
		AreaCmpniaPK castOther = (AreaCmpniaPK)other;
		return 
			this.acoCdgoArea.equals(castOther.acoCdgoArea)
			&& this.acoCdgoCia.equals(castOther.acoCdgoCia);

    }

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.acoCdgoArea.hashCode();
		hash = hash * prime + this.acoCdgoCia.hashCode();

		return hash;
    }*/
}