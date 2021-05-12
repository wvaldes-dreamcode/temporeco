package sai.com.procesosJudiciales.ubicacion.entities;

import static org.eclipse.persistence.annotations.ExistenceType.ASSUME_NON_EXISTENCE;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.ExistenceChecking;
import org.eclipse.persistence.annotations.NamedStoredProcedureQueries;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;
import org.eclipse.persistence.annotations.PrivateOwned;
import org.eclipse.persistence.annotations.StoredProcedureParameter;

import sai.com.procesosJudiciales.generales.readOnly.FuncionariosAreaV;


/**
 * The persistent class for the CARPETA_UBICACION database table.
 * 
 */
@Entity
@Table(name="CARPETA_UBICACION")
@NamedStoredProcedureQueries({
	/*@NamedStoredProcedureQuery(name ="devolucion", procedureName = "PKG_UBICACION.PRC_CNSLTA_DEUDA_DEV", returnsResultSet = false, parameters = {
			@StoredProcedureParameter(queryParameter = "P_NUMERO_ALISTAMIENTO", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "P_VALOR_DEUDA", direction = Direction.OUT, type = Number.class),
			@StoredProcedureParameter(queryParameter = "P_MENSAJE", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_ESTADO", direction = Direction.OUT, type = String.class)		
	}),*/
	@NamedStoredProcedureQuery(name ="devolucion", procedureName = "PKG_UBICACION.PRC_VALIDAR_TERMINADO_PAGO_WEB", returnsResultSet = false, parameters = {
			@StoredProcedureParameter(queryParameter = "P_NUMERO_ALISTAMIENTO", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "P_NEW_UBICACION", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "P_CAUSAL_TERMINADO", direction = Direction.IN, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_USUARIO_ACCION", direction = Direction.IN, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_COD_ERROR", direction = Direction.OUT, type = String.class),		
			@StoredProcedureParameter(queryParameter = "P_DESC_ERROR", direction = Direction.OUT, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_TIPO_ERROR", direction = Direction.OUT, type = String.class)		
	}),
	@NamedStoredProcedureQuery(name ="saneamiento", procedureName = "PKG_UBICACION.PRC_SANEAMIENTO", returnsResultSet = false, parameters = {
			@StoredProcedureParameter(queryParameter = "P_NUMERO_ALISTAMIENTO", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "P_NUMERO_OBLIGACION", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "P_USUARIO", direction = Direction.IN, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_MENSAJE", direction = Direction.OUT, type = String.class)
	}),
	@NamedStoredProcedureQuery(name ="distribucion", procedureName = "PKG_UBICACION.PRC_DISTRIBUYE_CASTIGADO", returnsResultSet = false, parameters = {
			@StoredProcedureParameter(queryParameter = "P_NUMERO_ALISTAMIENTO", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "P_USUARIO", direction = Direction.IN, type = String.class),
			@StoredProcedureParameter(queryParameter = "P_MENSAJE", direction = Direction.OUT, type = String.class)
	}),
	@NamedStoredProcedureQuery(name ="retornaUbicacion", procedureName = "PKG_ALISTAMIENTO.prc_retorna_ubicacion", returnsResultSet = false, parameters = {
			@StoredProcedureParameter(queryParameter = "p_numero_alistamiento", direction = Direction.IN, type = BigDecimal.class),
			@StoredProcedureParameter(queryParameter = "v_ubicacion", direction = Direction.OUT, type = String.class)
	})
})




@ExistenceChecking(ASSUME_NON_EXISTENCE)

public class CarpetaUbicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMERO_CARPETA")
	private BigDecimal numeroCarpeta;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

    @Temporal( TemporalType.DATE)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;
    
	@Column(name="MARCA_TIPO_CARPETA")
	private String marcaTipoCarpeta;

	@Column(name="NUMERO_ALISTAMIENTO")
	private BigDecimal numeroAlistamiento;
 
	@Column(name="NUMERO_CARPETA_PADRE")
	private BigDecimal numeroCarpetaPadre;

	@Column(name="NUMERO_OBLIGACION")
	private BigDecimal numeroObligacion;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION")
	private String usuarioModificacion;

	//bi-directional many-to-one association to AcuerdoPagoUb
	@OneToMany(mappedBy="carpetaUbicacion")
	@PrivateOwned
	private List<AcuerdoPagoUb> acuerdoPagoUbs;
	
	//bi-directional many-to-one association to AcuerdoPagoUb
	@OneToMany(mappedBy="carpetaUbicacion", cascade = CascadeType.ALL)
	@OrderBy("numeroPrestamo DESC")
	private List<PrestamoCarpeta> prestamos;
	
	@OneToMany(mappedBy="carpeta")	
	@PrivateOwned
	private List<PagosDeudore> pagos;
	

	//uni-directional many-to-one association to CausalesTerminacion
    @ManyToOne
	@JoinColumn(name="NUMERO_CAUSAL_TERMINACION")
	private CausalesTerminacion causalTerminacion;

	//uni-directional many-to-one association to Ubicacion
    @ManyToOne
	@JoinColumn(name="NUMERO_UBICACION")
	private Ubicacion ubicacion;
    
    @Column(name="ESTADO")
	private String estado;
    
    @Transient
    private String descripcionEstado;
    
  //bi-directional many-to-one association to AcuerdoPagoUb
	@OneToMany(mappedBy="carpetaUbicacion")
	@OrderBy("numeroHistorialCarpeta DESC")
	//@OrderColumn(name="NUMERO_HISTORIAL_CARPETA")
	private List<HistorialCarpeta> historial;	
	
	
	@Column(name="ID_PER_IMPLICADA", precision=15)
	private BigDecimal idPerImplicada;

	@Column(length=200)
	private String justificacion;


	@Column(name="NOMBRE_PER_IMPLICADA", length=240)
	private String nombrePerImplicada;

	
	@Column(name="TIPO_ID_PER_IMPLICADA", length=3)
	private String tipoIdPerImplicada;


	@Column(precision=15, scale=2)
	private BigDecimal valor;
	
	@Column(name="EN_ARCHIVO", length=1)
	private String enArchivo;
	
	@Column(name="CAUSAL_TERMINADO_PAGO", length=1)
	private String causalterminadoPago;
	
	public List<HistorialCarpeta> getHistorial() {
		return historial;
	}

	public String getCausalterminadoPago() {
		return causalterminadoPago;
	}

	public void setCausalterminadoPago(String causalterminadoPago) {
		this.causalterminadoPago = causalterminadoPago;
	}
	
	public String getEnArchivo() {
		return enArchivo;
	}
	
	public void setEnArchivo(String enArchivo) {
		this.enArchivo = enArchivo;
	}
	
	public void setHistorial(List<HistorialCarpeta> historial) {
		this.historial = historial;
	}

	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}	

	@PostLoad
	public void descifrarEstado(){
		
		if(estado.compareToIgnoreCase("D") == 0){
			
			descripcionEstado = "DISPONIBLE";
			
		}else if(estado.compareToIgnoreCase("P") == 0){
			
			descripcionEstado = "PRESTADA";
			
		}else if(estado.compareToIgnoreCase("E") == 0){
			
			descripcionEstado = "EXTRAVIADA";
		}else if(estado.compareToIgnoreCase("B") == 0){
			
			descripcionEstado = "EN BODEGA";
		}
		
	}	
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	//uni-directional many-to-one association to FuncionariosAreaV
    @ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_RESPONSABLE", referencedColumnName="DOCUMENTO_ID"),
		@JoinColumn(name="TIPO_ID_RESPONSABLE", referencedColumnName="TIPO_ID")
		})
	private FuncionariosAreaV funcionarioEncargado;

    public CarpetaUbicacion() {
    }

	public BigDecimal getNumeroCarpeta() {
		return this.numeroCarpeta;
	}

	public void setNumeroCarpeta(BigDecimal numeroCarpeta) {
		this.numeroCarpeta = numeroCarpeta;
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
	
	public String getMarcaTipoCarpeta() {
		return this.marcaTipoCarpeta;
	}

	public void setMarcaTipoCarpeta(String marcaTipoCarpeta) {
		this.marcaTipoCarpeta = marcaTipoCarpeta;
	}

	public BigDecimal getNumeroAlistamiento() {
		return this.numeroAlistamiento;
	}

	public void setNumeroAlistamiento(BigDecimal numeroAlistamiento) {
		this.numeroAlistamiento = numeroAlistamiento;
	}

	public BigDecimal getNumeroCarpetaPadre() {
		return this.numeroCarpetaPadre;
	}

	public void setNumeroCarpetaPadre(BigDecimal numeroCarpetaPadre) {
		this.numeroCarpetaPadre = numeroCarpetaPadre;
	}

	public BigDecimal getNumeroObligacion() {
		return this.numeroObligacion;
	}

	public void setNumeroObligacion(BigDecimal numeroObligacion) {
		this.numeroObligacion = numeroObligacion;
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

	public List<AcuerdoPagoUb> getAcuerdoPagoUbs() {
		return this.acuerdoPagoUbs;
	}

	public void setAcuerdoPagoUbs(List<AcuerdoPagoUb> acuerdoPagoUbs) {
		this.acuerdoPagoUbs = acuerdoPagoUbs;
	}
	
	public CausalesTerminacion getCausalTerminacion() {
		return this.causalTerminacion;
	}

	public void setCausalTerminacion(CausalesTerminacion causalTerminacion) {
		this.causalTerminacion = causalTerminacion;
	}
	
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public FuncionariosAreaV getFuncionarioEncargado() {
		return this.funcionarioEncargado;
	}

	public void setFuncionarioEncargado(FuncionariosAreaV funcionarioEncargado) {
		this.funcionarioEncargado = funcionarioEncargado;
	}
	
	public List<PrestamoCarpeta> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<PrestamoCarpeta> prestamos) {
		this.prestamos = prestamos;
	}

	public BigDecimal getIdPerImplicada() {
		return idPerImplicada;
	}

	public void setIdPerImplicada(BigDecimal idPerImplicada) {
		this.idPerImplicada = idPerImplicada;
	}

	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	public String getNombrePerImplicada() {
		return nombrePerImplicada;
	}

	public void setNombrePerImplicada(String nombrePerImplicada) {
		this.nombrePerImplicada = nombrePerImplicada;
	}

	public String getTipoIdPerImplicada() {
		return tipoIdPerImplicada;
	}

	public void setTipoIdPerImplicada(String tipoIdPerImplicada) {
		this.tipoIdPerImplicada = tipoIdPerImplicada;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<PagosDeudore> getPagos() {
		return pagos;
	}

	public void setPagos(List<PagosDeudore> pagos) {
		this.pagos = pagos;
	}
	
	
	
	
	
	
	
	
	
}