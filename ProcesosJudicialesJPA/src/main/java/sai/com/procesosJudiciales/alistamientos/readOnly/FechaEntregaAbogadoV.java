package sai.com.procesosJudiciales.alistamientos.readOnly;

import static org.eclipse.persistence.annotations.CacheType.NONE;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.NamedStoredProcedureQueries;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;
import org.eclipse.persistence.annotations.StoredProcedureParameter;


/**
 * The persistent class for the V_F_FECHA_ENTREGA_ABOGADO database table.
 * 
 */
@Entity
@Table(name="V_F_FECHA_ENTREGA_ABOGADO")
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(name = "actualizarFechaEntregaA", procedureName = "Pkg_Alistamiento.prc_ActlzaFchaEntrgaAbgdo", returnsResultSet = false, parameters = 
{
	@StoredProcedureParameter(queryParameter = "p_NoAlistamiento", direction = Direction.IN, type = BigDecimal.class),
	@StoredProcedureParameter(queryParameter = "p_FechaEntrega", direction = Direction.IN, type = Date.class),
	@StoredProcedureParameter(queryParameter = "p_CodError", direction = Direction.OUT, type = BigDecimal.class),
	@StoredProcedureParameter(queryParameter = "p_DescError", direction = Direction.OUT, type = String.class) 
})
})
@org.eclipse.persistence.annotations.Cache(type = NONE)
public class FechaEntregaAbogadoV implements Serializable {
	private static final long serialVersionUID = 1L;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_ENTREGA")
	private Date fechaEntrega;

    @Id
	@Column(name="NUMERO_ALISTAMIENTO", precision=15)
	private BigDecimal numeroAlistamiento;

    public FechaEntregaAbogadoV() {
    }

	public Date getFechaEntrega() {
		return this.fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public BigDecimal getNumeroAlistamiento() {
		return this.numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}

}