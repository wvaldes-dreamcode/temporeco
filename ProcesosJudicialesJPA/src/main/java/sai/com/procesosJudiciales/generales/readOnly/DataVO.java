package sai.com.procesosJudiciales.generales.readOnly;

import java.math.BigDecimal;

public class DataVO {

	private BigDecimal secuencia;
	private String descripcion;
	private String abreviacion;

	public DataVO() {
	}

	public DataVO(BigDecimal secuencia, String descripcion) {
		this.secuencia = secuencia;
		this.descripcion = descripcion;
	}

	public DataVO(BigDecimal secuencia, String descripcion,
			String abreviacion) {
		this.secuencia = secuencia;
		this.descripcion = descripcion;
		this.abreviacion = abreviacion;
	}
	
	public BigDecimal getsecuencia() {
		return secuencia;
	}
	public void setsecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAbreviacion() {
		return abreviacion;
	}
	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}			
}
