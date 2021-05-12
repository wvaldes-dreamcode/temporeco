package sai.com.procesosJudiciales.generales.readOnly;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the V_FUNCIONARIOS_AREA database table.
 * 
 */
@IdClass(FuncionarioAreaKey.class)
@Entity
@Table(name="V_FUNCIONARIOS_AREA")
@NamedQuery(name = "funcionarioByDocumento", query = "select f from FuncionariosAreaV f where f.documentoId = :numId")
public class FuncionariosAreaV implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="COMPANIA")
	private String compania;

	@Column(name="NOMBRE_COMPANIA")
	private String nombreCompania;

	@Column(name="AREA")
	private String area;

	@Column(name="NOMBRE_AREA")
	private String nombreArea;

	@Column(name="CARGO")
	private String cargo;

	@Column(name="DESCRIPCION_CARGO")
	private String descripcionCargo;

	@Column(name="SUCURSAL")
	private String sucursal;

	@Column(name="NOMBRE_SUCURSAL")
	private String nombreSucursal;

	@Id
	@Column(name="DOCUMENTO_ID")
	private BigDecimal documentoId;

	@Id
	@Column(name="TIPO_ID") //, insertable=false
	private String tipoId;

	@Column(name="NOMBRE_FUNCIONARIO")
	private String nombreFuncionario;

	@Column(name="JERARQUIA_CARGO")
	private BigDecimal jerarquiaCargo;
	
	@Column(name="PERFIL_USUARIO")
	private String perfil;

	@Column(name="MARCA_ACCESO_TOTAL")
	private String marcaAccesoTotal;
	
	@Column(name="AREA_NOMINA")
	private String areaNomina;	

	@Column(name="ESTADO_FUNCIONARIO")
	private String estadoFuncionario;
	
	
    public String getAreaNomina() {
		return areaNomina;
	}

	public void setAreaNomina(String areaNomina) {
		this.areaNomina = areaNomina;
	}

	public FuncionariosAreaV() {
    }

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getCompania() {
		return this.compania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}
	
	public String getNombreCompania() {
		return this.nombreCompania;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getArea() {
		return this.area;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}
	
	public String getNombreArea() {
		return this.nombreArea;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescripcionCargo() {
		return this.descripcionCargo;
	}

	public void setDescripcionCargo(String descripcionCargo) {
		this.descripcionCargo = descripcionCargo;
	}

	public String getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getNombreSucursal() {
		return this.nombreSucursal;
	}

	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	public BigDecimal getDocumentoId() {
		return this.documentoId;
	}

	public void setDocumentoId(BigDecimal documentoId) {
		this.documentoId = documentoId;
	}

	public String getTipoId() {
		return this.tipoId;
	}

	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}

	public String getNombreFuncionario() {
		return this.nombreFuncionario;
	}

	public void setNombreFuncionario(String nombreFuncionario) {
		this.nombreFuncionario = nombreFuncionario;
	}

	public BigDecimal getJerarquiaCargo() {
		return jerarquiaCargo;
	}

	public void setJerarquiaCargo(BigDecimal jerarquiaCargo) {
		this.jerarquiaCargo = jerarquiaCargo;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}	

	public String getMarcaAccesoTotal() {
		return marcaAccesoTotal;
	}

	public void setMarcaAccesoTotal(String marcaAccesoTotal) {
		this.marcaAccesoTotal = marcaAccesoTotal;
	}	

	public String getEstadoFuncionario() {
		return estadoFuncionario;
	}

	public void setEstadoFuncionario(String estadoFuncionario) {
		this.estadoFuncionario = estadoFuncionario;
	}


	
}