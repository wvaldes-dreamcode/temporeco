package sai.com.procesosJudiciales.titulos.readOnly;

import java.math.BigDecimal;

public class EstadoDocumentoOperacion {

	private BigDecimal				secuenciaEstadoDocumento;
	private String					operacion;
	private String					usuario;
	
	public BigDecimal getSecuenciaEstadoDocumento() {
		return secuenciaEstadoDocumento;
	}
	public void setSecuenciaEstadoDocumento(BigDecimal secuenciaEstadoDocumento) {
		this.secuenciaEstadoDocumento = secuenciaEstadoDocumento;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
