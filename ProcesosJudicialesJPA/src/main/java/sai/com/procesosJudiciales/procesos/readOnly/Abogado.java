package sai.com.procesosJudiciales.procesos.readOnly;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.NamedStoredProcedureQueries;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;
import org.eclipse.persistence.annotations.StoredProcedureParameter;


/**
 * The persistent class for the V_ABOGADOS_PROCESOS database table.
 * 
 */
@Entity
@Table(name="V_F_ABOGADOS")
@NamedQueries(
		@NamedQuery(name = "abogadoById", query = "select a from Abogado a where a.numeroIdAbogado = :numId and a.tipoIdAbogado = :tipId")
)		
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "informacionAbogado", procedureName = "CONSULTAR_DATOS_TERCEROS", returnsResultSet = false, parameters = 
		{
				@StoredProcedureParameter(queryParameter = "P_NUMERO", direction = Direction.IN, type = BigDecimal.class),
				@StoredProcedureParameter(queryParameter = "P_TIPO", direction = Direction.IN, type = String.class),
				@StoredProcedureParameter(queryParameter = "NOMBRE", direction = Direction.OUT, type = String.class),				
				@StoredProcedureParameter(queryParameter = "FECHANACIMIENTO", direction = Direction.OUT, type = Date.class),
				@StoredProcedureParameter(queryParameter = "PROFESION", direction = Direction.OUT, type = String.class),
				@StoredProcedureParameter(queryParameter = "RAZONSOCIAL", direction = Direction.OUT, type = String.class),
				@StoredProcedureParameter(queryParameter = "TIDREPLEGAL", direction = Direction.OUT, type = String.class),
				@StoredProcedureParameter(queryParameter = "IDREPLEGAL", direction = Direction.OUT, type = BigDecimal.class),
				@StoredProcedureParameter(queryParameter = "NOMBREREPLEGAL", direction = Direction.OUT, type = String.class),
				@StoredProcedureParameter(queryParameter = "FECHAEXPEDICION", direction = Direction.OUT, type = Date.class),
				@StoredProcedureParameter(queryParameter = "DIRECCIONOFICINA", direction = Direction.OUT, type = String.class),
				@StoredProcedureParameter(queryParameter = "CIUDADOFICINA", direction = Direction.OUT, type = String.class),
				@StoredProcedureParameter(queryParameter = "TELEFONOOFICINA", direction = Direction.OUT, type = String.class),
				@StoredProcedureParameter(queryParameter = "TELEFONOMOVIL", direction = Direction.OUT, type = String.class),
				@StoredProcedureParameter(queryParameter = "EMAIL", direction = Direction.OUT, type = String.class)
		}	
)
})
public class Abogado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SEC_ABOGADO", nullable=false, precision=16)
	private BigDecimal secuenciaAbogado;

	public BigDecimal getSecuenciaAbogado() {
		return secuenciaAbogado;
	}

	public void setSecuenciaAbogado(BigDecimal secuenciaAbogado) {
		this.secuenciaAbogado = secuenciaAbogado;
	}

	@Column(name="ESTADO_ABOGADO", nullable=false, length=120)
	private String estadoAbogado;

	@Column(name="NOMBRE_ABOGADO", length=4000)
	private String nombreAbogado;

	@Column(name="NUMERO_ID_ABOGADO", nullable=false, precision=16)
	private BigDecimal numeroIdAbogado;

	@Column(name="TIPO_ID_ABOGADO", nullable=false, length=3)
	private String tipoIdAbogado;

	@Column(name="MCOORDINADOR", nullable=false, length=10)
	private String mCoordinador;



	public String getmCoordinador() {
		return mCoordinador;
	}

	public void setmCoordinador(String mCoordinador) {
		this.mCoordinador = mCoordinador;
	}

	/*//bi-directional many-to-one association to Proceso
	@OneToMany(mappedBy="abogado")
	private List<Proceso> procesos;*/

	//bi-directional many-to-many association to VAbogado
	@ManyToMany
	@JoinTable(
			name="ABOGADOS_COORDINADOR"
				, joinColumns={
					@JoinColumn(name="SECUENCIA_ABOGADO", referencedColumnName="SEC_ABOGADO")
			}
			, inverseJoinColumns={
					@JoinColumn(name="SECUENCIA_ABOGADO_CNADO", referencedColumnName="SEC_ABOGADO")
			}
	)
	private List<Abogado> coordinados;

	//bi-directional many-to-many association to VAbogado
	@ManyToMany(mappedBy="coordinados")
	private List<Abogado> coordinadores;



	public Abogado() {
	}

	public String getEstadoAbogado() {
		return this.estadoAbogado;
	}

	public void setEstadoAbogado(String estadoAbogado) {
		this.estadoAbogado = estadoAbogado;
	}

	public String getNombreAbogado() {
		return this.nombreAbogado;
	}

	public void setNombreAbogado(String nombreAbogado) {
		this.nombreAbogado = nombreAbogado;
	}

	public BigDecimal getNumeroIdAbogado() {
		return this.numeroIdAbogado;
	}

	public void setNumeroIdAbogado(BigDecimal numeroIdAbogado) {
		this.numeroIdAbogado = numeroIdAbogado;
	}

	public String getTipoIdAbogado() {
		return this.tipoIdAbogado;
	}

	public void setTipoIdAbogado(String tipoIdAbogado) {
		this.tipoIdAbogado = tipoIdAbogado;
	}

	/*public List<Proceso> getProcesos() {
		return this.procesos;
	}

	public void setProcesos(List<Proceso> procesos) {
		this.procesos = procesos;
	}*/

	public List<Abogado> getCoordinadores() {
		return this.coordinadores;
	}

	public void setCoordinadores(List<Abogado> coordinadores) {
		this.coordinadores = coordinadores;
	}

	public List<Abogado> getCoordinados() {
		return this.coordinados;
	}

	public void setCoordinados(List<Abogado> coordinados) {
		this.coordinados = coordinados;
	}

}