package sai.com.procesosJudiciales.procesos.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the V_F_ABOGADOS_SOCIOS database table.
 * 
 */
@Entity
@Table(name="V_F_ABOGADOS_SOCIOS")
@NamedQueries(
		@NamedQuery(name = "abogadosSocios", query = "select a from VFAbogadosSocio a where a.idJuridico =:idJur")
)		
public class VFAbogadosSocio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ABOGADO_SOCIO")
	private BigDecimal idAbogadoSocio;

	@Column(name="ID_JURIDICO")
	private BigDecimal idJuridico;

	@Column(name="MCA_REPRESENTANTE")
	private String mcaRepresentante;

	@Column(name="NOMBRE_ABOGADO")
	private String nombreAbogado;

	@Column(name="NUM_TARJETA_PROF")
	private String numTarjetaProf;

	@Column(name="TDOC_ABOGADO_SOCIO")
	private String tdocAbogadoSocio;

	@Column(name="TDOC_JURIDICO")
	private String tdocJuridico;

    public VFAbogadosSocio() {
    }

	public BigDecimal getIdAbogadoSocio() {
		return this.idAbogadoSocio;
	}

	public void setIdAbogadoSocio(BigDecimal idAbogadoSocio) {
		this.idAbogadoSocio = idAbogadoSocio;
	}

	public BigDecimal getIdJuridico() {
		return this.idJuridico;
	}

	public void setIdJuridico(BigDecimal idJuridico) {
		this.idJuridico = idJuridico;
	}

	public String getMcaRepresentante() {
		return this.mcaRepresentante;
	}

	public void setMcaRepresentante(String mcaRepresentante) {
		this.mcaRepresentante = mcaRepresentante;
	}

	public String getNombreAbogado() {
		return this.nombreAbogado;
	}

	public void setNombreAbogado(String nombreAbogado) {
		this.nombreAbogado = nombreAbogado;
	}

	public String getNumTarjetaProf() {
		return this.numTarjetaProf;
	}

	public void setNumTarjetaProf(String numTarjetaProf) {
		this.numTarjetaProf = numTarjetaProf;
	}

	public String getTdocAbogadoSocio() {
		return this.tdocAbogadoSocio;
	}

	public void setTdocAbogadoSocio(String tdocAbogadoSocio) {
		this.tdocAbogadoSocio = tdocAbogadoSocio;
	}

	public String getTdocJuridico() {
		return this.tdocJuridico;
	}

	public void setTdocJuridico(String tdocJuridico) {
		this.tdocJuridico = tdocJuridico;
	}

}