package sai.com.procesosJudiciales.rest.servicios;

import java.math.BigDecimal;
import java.util.List;

import sai.com.procesosJudiciales.alistamientos.readOnly.AlistamientosObligacionV;
import sai.com.procesosJudiciales.generales.ConsultaGeneralDTO;

public class ConsultaGeneralServices {

	private ConsultaGeneralDTO consultaGeneralDTO;

	public ConsultaGeneralServices() {
		consultaGeneralDTO = new ConsultaGeneralDTO();
	}

	public List<AlistamientosObligacionV> getListaAlistamientos(int startIndex, int numItems) {

		List<AlistamientosObligacionV> lista = null;
		AlistamientosObligacionV alistamientoF = new AlistamientosObligacionV();
		alistamientoF.setNumeroObligacion(new BigDecimal(2451932));
		consultaGeneralDTO.setAlistamientoF(alistamientoF);
		lista = consultaGeneralDTO.getListaAlistamientos(0, 0);
		return lista;
	}
}
