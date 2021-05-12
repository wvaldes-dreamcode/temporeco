package sai.com.procesosJudiciales.novedades.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.NamedStoredProcedureQueries;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;
import org.eclipse.persistence.annotations.StoredProcedureParameter;


/**
 * The persistent class for the MOVIMIENTOS_NOVEDADES database table.
 * 
 */
@Entity
@Table(name="MOVIMIENTOS_NOVEDADES")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "grabarNovedad", procedureName = "PKG_J_NOVEDADES.PRC_GRABAR_NOVEDAD_MANUAL", returnsResultSet = false, parameters = 
	{
			@StoredProcedureParameter(queryParameter = "p_CodUsrCreacion", direction = Direction.IN, type = String.class),
			@StoredProcedureParameter(queryParameter = "p_CodigoCia", direction = Direction.IN, type = String.class), 
			@StoredProcedureParameter(queryParameter = "p_CodNovedad", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "p_NroAlistamiento", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "p_NroProceso", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "p_NroObligacion", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "p_TipoConsec", direction = Direction.IN, type = String.class),
			@StoredProcedureParameter(queryParameter = "p_mensaje", direction = Direction.OUT, type = String.class)
	}),
	@NamedStoredProcedureQuery(name = "grabarDatoAsociado", procedureName = "PKG_J_NOVEDADES.PRC_INSERTA_DATOS_NOVEDAD", returnsResultSet = false, parameters = 
	{
			@StoredProcedureParameter(queryParameter = "p_SecDatoAsoc", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "p_SecDatoBas", direction = Direction.IN, type = BigDecimal.class), 
			@StoredProcedureParameter(queryParameter = "p_SecMovNov", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "p_ValorDato", direction = Direction.IN, type = String.class),			
			@StoredProcedureParameter(queryParameter = "p_salida", direction = Direction.OUT, type = BigDecimal.class)
	})
	
})
public class MovimientosNovedade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOVIMIENTOS_NOVEDADES_SECUENCIAMOVIMIENTONOVEDAD_GENERATOR", sequenceName="SEQ_MVTOS_TAREAS", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOVIMIENTOS_NOVEDADES_SECUENCIAMOVIMIENTONOVEDAD_GENERATOR")
	@Column(name="SECUENCIA_MOVIMIENTO_NOVEDAD")
	private long secuenciaMovimientoNovedad;

	//uni-directional many-to-one association to NovedadesObligacione
    @ManyToOne
	@JoinColumn(name="SECUENCIA_NOVEDAD")
	private Novedad novedad;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_NOVEDAD")
	private Date fechaNovedad;

	@Column(name="NUMERO_ALISTAMIENTO")
	private BigDecimal numeroAlistamiento;

	@Column(name="NUMERO_PROCESO")
	private BigDecimal numeroProceso;
	
	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	@Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name="USUARIO_MODIFICACION")
	private String usuarioModificacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

    @Column(name="TIPO_ALISTAMIENTO_CREACION")
    private String tipoAlistamientoCreacion;

    @Column(name="ESTADO_ALISTAMIENTO_CREACION")
	private String estadoAlistamientoCreacion;

    @Column(name="TIPO_PROCESO_CREACION")
    private String tipoProcesoCreacion;	

    @Column(name="ESTADO_PROCESO_CREACION")
    private String estadoProcesoCreacion;	

	@Column(name="NOVEDAD_ORIGEN")
	private BigDecimal novedadOrigen;

	@Column(name="NUMERO_OBLIGACION")
	private BigDecimal numeroObligacion;

	@Column(name="SECUENCIA_DEUDA")
	private BigDecimal secuenciaDeuda;

	@Column(name="TIPO_CONSECUENCIA")
	private String tipoConsecuencia;
	    
    @OneToMany(mappedBy = "movimientosNovedade", fetch = FetchType.LAZY)
	private List<MovimientosDatosNovedad> datosAsociados;     

    @OneToMany(mappedBy = "movimientoNovedad", fetch = FetchType.LAZY)
	private List<HistorialCorreosJuridico> historialCorreo;
    

	public MovimientosNovedade() {
    }

	public String getTipoAlistamientoCreacion() {
		return tipoAlistamientoCreacion;
	}

	public void setTipoAlistamientoCreacion(String tipoAlistamientoCreacion) {
		this.tipoAlistamientoCreacion = tipoAlistamientoCreacion;
	}

	public String getEstadoAlistamientoCreacion() {
		return estadoAlistamientoCreacion;
	}

	public void setEstadoAlistamientoCreacion(String estadoAlistamientoCreacion) {
		this.estadoAlistamientoCreacion = estadoAlistamientoCreacion;
	}

	public String getTipoProcesoCreacion() {
		return tipoProcesoCreacion;
	}

	public void setTipoProcesoCreacion(String tipoProcesoCreacion) {
		this.tipoProcesoCreacion = tipoProcesoCreacion;
	}

	public String getEstadoProcesoCreacion() {
		return estadoProcesoCreacion;
	}

	public void setEstadoProcesoCreacion(String estadoProcesoCreacion) {
		this.estadoProcesoCreacion = estadoProcesoCreacion;
	}

	public long getSecuenciaMovimientoNovedad() {
		return this.secuenciaMovimientoNovedad;
	}

	public void setSecuenciaMovimientoNovedad(long secuenciaMovimientoNovedad) {
		this.secuenciaMovimientoNovedad = secuenciaMovimientoNovedad;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaNovedad() {
		return this.fechaNovedad;
	}

	public void setFechaNovedad(Date fechaNovedad) {
		this.fechaNovedad = fechaNovedad;
	}

	public BigDecimal getNovedadOrigen() {
		return this.novedadOrigen;
	}

	public void setNovedadOrigen(BigDecimal novedadOrigen) {
		this.novedadOrigen = novedadOrigen;
	}

	public BigDecimal getNumeroAlistamiento() {
		return this.numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}

	public BigDecimal getNumeroObligacion() {
		return this.numeroObligacion;
	}

	public void setNumeroObligacion(BigDecimal numeroObligacion) {
		this.numeroObligacion = numeroObligacion;
	}

	public BigDecimal getNumeroProceso() {
		return this.numeroProceso;
	}

	public void setNumeroProceso(BigDecimal numeroProceso) {
		this.numeroProceso = numeroProceso;
	}

	public BigDecimal getSecuenciaDeuda() {
		return this.secuenciaDeuda;
	}

	public void setSecuenciaDeuda(BigDecimal secuenciaDeuda) {
		this.secuenciaDeuda = secuenciaDeuda;
	}

	public String getTipoConsecuencia() {
		return this.tipoConsecuencia;
	}

	public void setTipoConsecuencia(String tipoConsecuencia) {
		this.tipoConsecuencia = tipoConsecuencia;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Novedad getNovedad() {
		return this.novedad;
	}

	public void setNovedad(Novedad novedad) {
		this.novedad = novedad;
	}

	public List<HistorialCorreosJuridico> getHistorialCorreo() {
		return historialCorreo;
	}

	public void setHistorialCorreo(List<HistorialCorreosJuridico> historialCorreo) {
		this.historialCorreo = historialCorreo;
	}

	public List<MovimientosDatosNovedad> getDatosAsociados() {
		return datosAsociados;
	}

	public void setDatosAsociados(List<MovimientosDatosNovedad> datosAsociados) {
		this.datosAsociados = datosAsociados;
	}
	
}