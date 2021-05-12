package sai.com.procesosJudiciales.generales.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "DOMINIOS")
@NamedQueries({
    @NamedQuery(name = "DominiosEntity.findAll", query = "SELECT d FROM DominiosEntity d")})
public class DominiosEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DominiosEntityPK dominiosEntityPK;
    @Column(name = "RV_HIGH_VALUE")
    private String rvHighValue;
    @Column(name = "RV_ABBREVIATION")
    private String rvAbbreviation;
    @Column(name = "RV_MEANING")
    private String rvMeaning;
    @Column(name = "RV_TYPE")
    private String rvType;
    @Column(name = "RV_CREATE_BY")
    private String rvCreateBy;

    public DominiosEntity() {
    }

    public DominiosEntity(DominiosEntityPK dominiosEntityPK) {
        this.dominiosEntityPK = dominiosEntityPK;
    }

    public DominiosEntity(String rvDomain, String rvLowValue) {
        this.dominiosEntityPK = new DominiosEntityPK(rvDomain, rvLowValue);
    }

    public DominiosEntityPK getDominiosEntityPK() {
        return dominiosEntityPK;
    }

    public void setDominiosEntityPK(DominiosEntityPK dominiosEntityPK) {
        this.dominiosEntityPK = dominiosEntityPK;
    }

    public String getRvHighValue() {
        return rvHighValue;
    }

    public void setRvHighValue(String rvHighValue) {
        this.rvHighValue = rvHighValue;
    }

    public String getRvAbbreviation() {
        return rvAbbreviation;
    }

    public void setRvAbbreviation(String rvAbbreviation) {
        this.rvAbbreviation = rvAbbreviation;
    }

    public String getRvMeaning() {
        return rvMeaning;
    }

    public void setRvMeaning(String rvMeaning) {
        this.rvMeaning = rvMeaning;
    }

    public String getRvType() {
        return rvType;
    }

    public void setRvType(String rvType) {
        this.rvType = rvType;
    }

    public String getRvCreateBy() {
        return rvCreateBy;
    }

    public void setRvCreateBy(String rvCreateBy) {
        this.rvCreateBy = rvCreateBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dominiosEntityPK != null ? dominiosEntityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DominiosEntity)) {
            return false;
        }
        DominiosEntity other = (DominiosEntity) object;
        if ((this.dominiosEntityPK == null && other.dominiosEntityPK != null) || (this.dominiosEntityPK != null && !this.dominiosEntityPK.equals(other.dominiosEntityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DominiosEntity[ dominiosEntityPK=" + dominiosEntityPK + " ]";
    }
    
}
