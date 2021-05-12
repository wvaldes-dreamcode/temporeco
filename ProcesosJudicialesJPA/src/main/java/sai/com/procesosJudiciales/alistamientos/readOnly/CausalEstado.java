package sai.com.procesosJudiciales.alistamientos.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the V_F_CAUSALES_ESTADO_ALIS database table.
 * 
 */
@Entity
@Table(name="V_F_CAUSALES_ESTADO_ALIS")
public class CausalEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ENVIAR_CORREO")
	private String enviarCorreo;

	@Column(name="MARCA_PROCESO")
	private String marcaProceso;

	@Column(name="NOMBRE_NOVEDAD")
	private String nombre;

	@Id
	@Column(name="SECUENCIA_NOVEDAD")
	private BigDecimal secuencia;

	@Column(name="TIPO_CONSECUENCIA")
	private String tipoConsecuencia;
	
	@Column(name="CDGO_CIA_ORIGEN")
	private String compania;
	
	@Column(name="CDGO_AREA_ORIGEN")
	private String area;
	
	@Column(name="FUC_TIPO_IDENTIFICACION")
	private String tipoId;
	
	@Column(name="FUC_IDENTIFICACION")
	private BigDecimal identificacion;
	
	@Column(name="CODIGO_CARGO_ORIGEN")
	private String cargo;
	

    public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTipoId() {
		return tipoId;
	}

	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}

	public BigDecimal getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(BigDecimal identificacion) {
		this.identificacion = identificacion;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public CausalEstado() {
    }

	public String getEnviarCorreo() {
		return this.enviarCorreo;
	}

	public void setEnviarCorreo(String enviarCorreo) {
		this.enviarCorreo = enviarCorreo;
	}

	public String getMarcaProceso() {
		return this.marcaProceso;
	}

	public void setMarcaProceso(String marcaProceso) {
		this.marcaProceso = marcaProceso;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getSecuencia() {
		return this.secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	public String getTipoConsecuencia() {
		return this.tipoConsecuencia;
	}

	public void setTipoConsecuencia(String tipoConsecuencia) {
		this.tipoConsecuencia = tipoConsecuencia;
	}

}