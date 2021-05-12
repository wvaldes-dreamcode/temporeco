package sai.com.procesosJudiciales.generales.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DominiosEntityPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "RV_DOMAIN")
    private String rvDomain;
    @Basic(optional = false)
    @Column(name = "RV_LOW_VALUE")
    private String rvLowValue;

    public DominiosEntityPK() {
    }

    public DominiosEntityPK(String rvDomain, String rvLowValue) {
        this.rvDomain = rvDomain;
        this.rvLowValue = rvLowValue;
    }

    public String getRvDomain() {
        return rvDomain;
    }

    public void setRvDomain(String rvDomain) {
        this.rvDomain = rvDomain;
    }

    public String getRvLowValue() {
        return rvLowValue;
    }

    public void setRvLowValue(String rvLowValue) {
        this.rvLowValue = rvLowValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rvDomain != null ? rvDomain.hashCode() : 0);
        hash += (rvLowValue != null ? rvLowValue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DominiosEntityPK)) {
            return false;
        }
        DominiosEntityPK other = (DominiosEntityPK) object;
        if ((this.rvDomain == null && other.rvDomain != null) || (this.rvDomain != null && !this.rvDomain.equals(other.rvDomain))) {
            return false;
        }
        if ((this.rvLowValue == null && other.rvLowValue != null) || (this.rvLowValue != null && !this.rvLowValue.equals(other.rvLowValue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DominiosEntityPK[ rvDomain=" + rvDomain + ", rvLowValue=" + rvLowValue + " ]";
    }
    
}
