package sai.com.procesosJudiciales.generales;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import sai.com.procesosJudiciales.EntitiesAuxiliares.ProcesoAux;
import sai.com.procesosJudiciales.alistamientos.readOnly.AlistamientosObligacionV;
import sai.com.procesosJudiciales.alistamientos.readOnly.AlistamientosProceso;
import sai.com.procesosJudiciales.alistamientos.readOnly.ObligacionesAlistamientoV;
import sai.com.procesosJudiciales.generales.readOnly.InmobiliariasV;
import sai.com.procesosJudiciales.generales.readOnly.SucursalV;
import sai.com.procesosJudiciales.procesos.readOnly.DeudoresV;
import sai.com.procesosJudiciales.procesos.readOnly.ObligacioneV;
import sai.com.procesosJudiciales.procesos.readOnly.ProcesosAlistamientoV;

public class ConsultaGeneralDTO {

	private String estado; 
	private ObligacioneV obligacionF;
	private AlistamientosObligacionV alistamientoF;
	private ProcesoAux procesoF;

	public ProcesoAux getProcesoF() {
		return procesoF;
	}

	public void setProcesoF(ProcesoAux procesoF) {
		this.procesoF = procesoF;
	}

	public void setAlistamientoF(AlistamientosObligacionV alistamientoF) {
		this.alistamientoF = alistamientoF;
	}

	public void setObligacionF(ObligacioneV obligacionF) {
		this.obligacionF = obligacionF;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**************[SERVICIOS CONSULTA POR OBLIGACION]**************/
	@SuppressWarnings("unchecked")
	public List<ObligacioneV> getItems_paged(int startIndex, int numItems){

		List<ObligacioneV> lista = null; 

		StringBuilder consulta = new StringBuilder("select o from ObligacioneV o");

		StringBuilder where = aplicarFiltro();
		//System.out.println("valores del where: " + where +" *** startIndex: "+startIndex+" *** startIndex: "+numItems);
		
		if(where.length() > 6)
			consulta.append(where.toString());

		consulta.append(" order by o.fechaInicioSiniestro desc");
		
		EntityManager em = EntityManagerImp.getManager();	
		Query query = em.createQuery(consulta.toString());
		query.setFirstResult(startIndex);
		query.setMaxResults(numItems);
		try {			
			lista = query.getResultList();		
			System.out.println("lista de obligaciones: " + lista.size());		
		} catch (Exception e) {
			System.out.println("error en getItems_paged:" + e.getMessage());
		}finally{
			em.close();			
		}
		return lista;
	}

	public int count(){
		EntityManager em = EntityManagerImp.getManager();
		StringBuilder consulta = new StringBuilder("select count(o) from ObligacioneV o");
		StringBuilder where = aplicarFiltro();

		if(where.length() > 6)
			consulta.append(where.toString());

		Query query = em.createQuery(consulta.toString());
		int rows= 0;

		try {			
			rows = Integer.parseInt(  query.getSingleResult().toString());			
		} catch (Exception e) {
			System.out.println("error:" + e);
		}finally{
			em.close();			
		}
		return rows;
	}

	private StringBuilder aplicarFiltro(){
		StringBuilder whereClausule = new StringBuilder(" where");
		if(obligacionF.getNumeroObligacion() != null ){
			if(whereClausule.length() > 6)
				whereClausule.append(" and");
			whereClausule.append(" o.numeroObligacion = ");
			whereClausule.append(obligacionF.getNumeroObligacion());
		}else {

			if(obligacionF.getCodigoSucursal() != null &&  obligacionF.getCodigoSucursal().compareTo("") != 0){

				if(whereClausule.length() > 6)
					whereClausule.append(" and");

				whereClausule.append(" o.codigoSucursal  = '");
				whereClausule.append(obligacionF.getCodigoSucursal());
				whereClausule.append("'");
			}

			if(obligacionF.getDeudor() != null ){

				if(whereClausule.length() > 6)
					whereClausule.append(" and");

				whereClausule.append(" o.deudor.numeroIdDeudor = ");
				whereClausule.append(obligacionF.getDeudor().getNumeroIdDeudor());
				whereClausule.append(" and o.deudor.tipoIdDeudor = '");
				whereClausule.append(obligacionF.getDeudor().getTipoIdDeudor());
				whereClausule.append("'");
			}

			if(obligacionF.getInmobiliaria() != null ){

				if(whereClausule.length() > 6)
					whereClausule.append(" and");

				whereClausule.append(" o.inmobiliaria.numeroInmo = ");
				whereClausule.append(obligacionF.getInmobiliaria().getNumeroInmo());
				whereClausule.append(" and o.inmobiliaria.tipoidInmo = '");
				whereClausule.append(obligacionF.getInmobiliaria().getTipoidInmo());
				whereClausule.append("'");
			}
		}
		return whereClausule;
	}

	@SuppressWarnings("unchecked")
	public List<AlistamientosObligacionV> alistamientosObligacion(){
		List<AlistamientosObligacionV> lista = null; 
		EntityManager em = EntityManagerImp.getManager();

		Query query = em.createQuery("select a from AlistamientosObligacionV a where a.secuenciaDeuda = :num");
		query.setParameter("num", obligacionF.getSecuenciaDeuda());

		try {			
			lista = query.getResultList();			
		} catch (Exception e) {
			System.out.println("error en el metodo alistamientosObligacion():" + e);
		}finally{
			em.close();			
		}
		return lista;

	}

	@SuppressWarnings("unchecked")
	public List<ProcesosAlistamientoV> procesosAlistamiento(BigDecimal numAlistamiento){

		List<ProcesosAlistamientoV> lista = null; 

		EntityManager em = EntityManagerImp.getManager();

		Query query = em.createQuery("select a from ProcesosAlistamientoV a where a.numeroAlistamiento = :num");
		
		query.setParameter("num", numAlistamiento);

		try {			
			lista = (List<ProcesosAlistamientoV>) query.getResultList();	
			

		} catch (Exception e) {
			System.out.println("error en el metodo procesosAlistamiento():" + e);
		}finally{
			em.close();			
		}

		return lista;

	}
	
	
	@SuppressWarnings("unchecked")
	public List<ProcesosAlistamientoV> procesosObligacion(String numeroObligacion){

		List<ProcesosAlistamientoV> lista = null; 

		EntityManager em = EntityManagerImp.getManager();

		Query query = em.createQuery("select a from ProcesosAlistamientoV a where a.numeroObligacion = :num");
		
		query.setParameter("num", new BigDecimal(numeroObligacion));
		
		try {			
			lista = (List<ProcesosAlistamientoV>) query.getResultList();	
			

		} catch (Exception e) {
			System.out.println("error en el metodo procesosAlistamiento():" + e);
		}finally{
			em.close();			
		}

		return lista;

	}
	
	/****************************************************************/


	/*********[SERVICIOS PARA LISTA DE FILTROS]*(PASAR A GENERALESDAO )*********/

	public DeudoresV consultarDeudorPorDocumento(DeudoresV deudorF){

		EntityManager em = EntityManagerImp.getManager();

		StringBuilder consulta = 
			new StringBuilder("select d from DeudoresV d " +
			"where d.numeroIdDeudor = :numId and d.tipoIdDeudor = :tipoId ");

		try {



			Query query = em.createQuery(consulta.toString());

			query.setParameter("numId", deudorF.getNumeroIdDeudor());
			query.setParameter("tipoId", deudorF.getTipoIdDeudor());

			estado = "Consulta Realizada con Exito";

			return (DeudoresV) query.getSingleResult(	);			


		}catch (NoResultException e) {

			estado = "No se obtuvo resultado alguno";

			return null;

		} 
		catch (Exception e) {

			estado = "Error al consultar el deudor. Intenetelo de nuevo, si el error persiste comuniquese con el administrador del sistema.";

			return null;

		}

	} 


	@SuppressWarnings("unchecked")
	public List<InmobiliariasV> getListaInmobiliarias(InmobiliariasV filtro ){

		EntityManager em = EntityManagerImp.getManager();

		StringBuilder consulta = new StringBuilder("select i from  InmobiliariasV i");

		StringBuilder whereClausule = new StringBuilder(" where");


		/***********/
		if(filtro.getInmobiliaria() != null && filtro.getInmobiliaria().compareToIgnoreCase("") != 0){

			if(whereClausule.length() > 6)
				whereClausule.append(" and");

			whereClausule.append(" upper(i.inmobiliaria) like '%");
			whereClausule.append(filtro.getInmobiliaria().toUpperCase());
			whereClausule.append("%'");		
		}

		if(filtro.getTipoidInmo() != null && filtro.getTipoidInmo().compareTo("")!=0){

			if(whereClausule.length() > 6)
				whereClausule.append(" and");

			whereClausule.append(" i.tipoidInmo = '");
			whereClausule.append(filtro.getTipoidInmo());
			whereClausule.append("'");		
		}

		if(filtro.getNumeroInmo() != null ){

			if(whereClausule.length() > 6)
				whereClausule.append(" and");

			whereClausule.append(" i.numeroInmo =");
			whereClausule.append(filtro.getNumeroInmo());
		}
		/***********/


		if(whereClausule.length() > 6){

			consulta.append(whereClausule.toString());
		}		

		try {

			Query query = em.createQuery(consulta.toString());

			estado = "Consulta Realizada con Exito";

			return (List<InmobiliariasV>) query.getResultList();			


		}catch (Exception e) {

			estado = "Error al consultar el deudor. Intenetelo de nuevo, si el error persiste comuniquese con el administrador del sistema.";

			return null;

		}

	}


	public InmobiliariasV getInmobiliariaByDocumento(InmobiliariasV filtro ){

		EntityManager em = EntityManagerImp.getManager();

		StringBuilder consulta = new StringBuilder("select i from  InmobiliariasV i where i.tipoidInmo = :tipoId and i.numeroInmo = :numId");

		InmobiliariasV result = null;

		try {
			
			Query query = em.createQuery(consulta.toString());

			query.setParameter("tipoId", filtro.getTipoidInmo());
			query.setParameter("numId", filtro.getNumeroInmo());

			estado = "Consulta Realizada con Exito";

			result = (InmobiliariasV) query.getSingleResult();			


		}catch (NoResultException e) {

			estado = "No se econtro la inmobiliaria. Intenetelo de nuevo, si el error persiste comuniquese con el administrador del sistema.";
			System.out.println("Error en el metodo getInmobiliariaByDocumento(): " + e);

		} catch (Exception e) {

			estado = "Error al consultar la inmobiliaria. Intenetelo de nuevo, si el error persiste comuniquese con el administrador del sistema.";

			System.out.println("Error en el metodo getInmobiliariaByDocumento(): " + e);

		}finally{

			em.close();

		}


		return result;

	}


	@SuppressWarnings("unchecked")
	public List<SucursalV> getListaSucursales(String codCia){
		List<SucursalV> lista = null; 
		EntityManager em = EntityManagerImp.getManager();
		
		//Query query = em.createQuery("select s from SucursalV s where s.codCia = '42' order by s.nombre");
		Query query = em.createNativeQuery("SELECT SCRSL.SUC_CDGO AS CODIGO, SCRSL.SUC_NMBRE AS NOMBRE, SCRSL.SUC_CIA_CDGO AS COD_CIA FROM SCRSL SCRSL WHERE SCRSL.SUC_CIA_CDGO = '42' ORDER BY SCRSL.SUC_NMBRE", SucursalV.class);
		//query.setParameter("codCia", codCia);

		try {			
			lista = query.getResultList();			
		} catch (Exception e) {
			System.out.println("error en el metodo getListaSucursales():" + e);
		}finally{
			System.out.println("finaliza conexion getListaSucursales()");
			em.close();			
		}		
		return lista;
	}

	/**************************************************/




	/**************[SERVICIOS CONSULTA POR ALISTAMIENTO]***********************************************/ 
	@SuppressWarnings("unchecked")
	public List<AlistamientosObligacionV> getListaAlistamientos(int startIndex, int numItems){						
		List<AlistamientosObligacionV> lista = null; 
		EntityManager em = EntityManagerImp.getManager();
		StringBuilder consulta = new StringBuilder("select a from AlistamientosObligacionV a");
		String whereClausule = null;

		if(alistamientoF != null){
			whereClausule = aplicarFiltroAlistamiento();
			consulta.append(whereClausule);
		}else{
			whereClausule = "where a.numeroAlistamiento = 0";
			consulta.append(whereClausule);
		}
		
		consulta.append(" order by a.codAmparo asc, a.fechaSiniestro desc, a.ultimaMora desc");
		
		System.out.println("getListaAlistamientos() :" + consulta.toString());
		Query query = em.createQuery(consulta.toString());		
		query.setFirstResult(startIndex);
		query.setMaxResults(numItems);

		try {			
			lista = query.getResultList();	
			String observaciones = "";			
			for(AlistamientosObligacionV alistamiento : lista){				
				Query queryObservaciones = em.createNativeQuery(" select PKG_PROCESOS.FUN_RET_COMENTA_ALISTA("+ alistamiento.getNumeroAlistamiento() +") from dual ");												
				observaciones = observaciones  + queryObservaciones.getSingleResult().toString();
				alistamiento.setCausalCambio((observaciones.length()>1)?observaciones.replace("<BR><BR>", "\n"):"");
			}
			
		} catch (Exception e) {
			System.out.println("error en el metodo alistamientosObligacion():" + e);
		}finally{
			em.close();			
		}

		return lista;
	}

	public int countAlistamientos(){
		EntityManager em = EntityManagerImp.getManager();
		StringBuilder consulta = new StringBuilder("select count(a) from AlistamientosObligacionV a");
		if(alistamientoF != null){
			String whereClausule = aplicarFiltroAlistamiento();
			if(whereClausule.length() > 6)
				consulta.append(whereClausule);
		}

		Query query = em.createQuery(consulta.toString());
		int rows= 0;
		try {			
			rows = Integer.parseInt(  query.getSingleResult().toString());			
		} catch (Exception e) {
			System.out.println("error:" + e);
		}finally{
			em.close();			
		}
		return rows;
	}

	/***** validacion para los filtros del alistamiento *****/
	private String aplicarFiltroAlistamiento(){
		String where = null;
		String filtro = null;
		try{
			where = " where";
			filtro = "N";
			
			if(alistamientoF.getNumeroAlistamiento() != null){
				where = where + " a.numeroAlistamiento = " + alistamientoF.getNumeroAlistamiento();
				filtro = "S";				
			}
			
			if(alistamientoF.getNumeroObligacion() != null){
				if(filtro.equals("S")){
					where = where + " and a.numeroObligacion = " + alistamientoF.getNumeroObligacion();
				}else{
					where = where + " a.numeroObligacion = " + alistamientoF.getNumeroObligacion();
					filtro = "S";				
				}
			}
			
			if(alistamientoF.getDeudor() != null ){
				if(filtro.equals("S")){
					where = where + " and a.deudor.numeroIdDeudor  = " + alistamientoF.getDeudor().getNumeroIdDeudor() + 
					                " and a.deudor.tipoIdDeudor = '" + alistamientoF.getDeudor().getTipoIdDeudor() + "'";
				}else{
					where = where + " a.deudor.numeroIdDeudor  = " + alistamientoF.getDeudor().getNumeroIdDeudor() + 
	                                " and a.deudor.tipoIdDeudor = '" + alistamientoF.getDeudor().getTipoIdDeudor() + "'";
 					filtro = "S";				
				}						
			}
			
			if(filtro.equals("N")){ // para que no se vaya sin where..... 
				where = where + " a.numeroAlistamiento = 0";
			}								
		} catch (Exception e) {
			where = " where a.numeroAlistamiento = 0"; // para que no se vaya sin where..... 
			System.out.println("error en el filtro del alistamiento :" + e);
		}
		return where;		
	}


	@SuppressWarnings("unchecked")
	public List<ObligacionesAlistamientoV> obligacionesAlistamiento(){

		List<ObligacionesAlistamientoV> lista = null; 

		StringBuilder consulta = new StringBuilder("select o from ObligacionesAlistamientoV o");

		if(alistamientoF.getNumeroAlistamiento() != null){
			consulta.append(" where o.numeroAlistamiento = ");
			consulta.append(alistamientoF.getNumeroAlistamiento());
		}	

		EntityManager em = EntityManagerImp.getManager();

		Query query = em.createQuery(consulta.toString());

		try {			
			lista = query.getResultList();			
		} catch (Exception e) {
			System.out.println("error:" + e);
		}finally{
			em.close();			
		}
		return lista;

	}


	/*************************************************************/

	@SuppressWarnings("unchecked")
	public List<ProcesoAux> getListaProcesos(int startIndex, int numItems){

		List<ProcesoAux> lista = null; 

		EntityManager em = EntityManagerImp.getManager();

		StringBuilder consulta = new StringBuilder("select new sai.com.procesosJudiciales.EntitiesAuxiliares.ProcesoAux(p) from Proceso p where 1 = 1");

		String where = aplicarFiltrosProceso();
		
		consulta.append(where);		
		
		Query query = em.createQuery(consulta.toString());
		
		
		query.setFirstResult(startIndex);
		query.setMaxResults(numItems);

		try {			
			lista = query.getResultList();			
		} catch (Exception e) {
			System.out.println("error en el metodo getListaProcesos():" + e);
		}finally{
			em.close();			
		}

		return lista;
	}


	public int countProcesos(){

		EntityManager em = EntityManagerImp.getManager();

		StringBuilder consulta = new StringBuilder("select count(p) from Proceso p where 1 = 1");

		String where = aplicarFiltrosProceso();
		
		consulta.append(where);
		 
		Query query = em.createQuery(consulta.toString());

		int rows= 0;

		try {			
			rows = Integer.parseInt(  query.getSingleResult().toString());			
		} catch (Exception e) {
			System.out.println("error:" + e);
		}finally{
			em.close();			
		}

		return rows;
	}


	private String aplicarFiltrosProceso(){


		StringBuilder whereClausule = new StringBuilder();

		if( procesoF.getNumeroProceso()!= null ){

			whereClausule.append(" and p.numeroProceso = ");
			whereClausule.append(procesoF.getNumeroProceso());

		}else if( procesoF.getNumeroAlistamiento()!= null ){

			whereClausule.append(" and p.numeroAlistamiento = ");
			whereClausule.append(procesoF.getNumeroAlistamiento());

		}else if( procesoF.getNumeroObligacion()!= null ){

			whereClausule.append(" and p.numeroObligacion = ");
			whereClausule.append(procesoF.getNumeroObligacion());

		} 
		
		if( procesoF.getTiposProceso()!= null ){

			whereClausule.append(" and p.tiposProceso.secuenciaTipoProceso = ");
			whereClausule.append(procesoF.getTiposProceso().getSecuenciaTipoProceso());
		}
		
		if( procesoF.getAbogado()!= null ){

			whereClausule.append(" and p.abogado.secuenciaAbogado = ");
			whereClausule.append(procesoF.getAbogado().getSecuenciaAbogado());
			
		}

		if( procesoF.getSeqCoordinador() != null ){

			whereClausule.append(" and p.seqCoordinador = ");
			whereClausule.append(procesoF.getSeqCoordinador());
			
		}
		
		
		return whereClausule.toString();
	}

	@SuppressWarnings("unchecked")
	public List<AlistamientosProceso> getAlistamientosProcesos(ProcesoAux proceso){


		List<AlistamientosProceso> lista = null; 

		EntityManager em = EntityManagerImp.getManager();

		Query query = em.createQuery("select a from AlistamientosProceso a where a.numeroProceso = :num");
		query.setParameter("num", proceso.getNumeroProceso());

		try {			
			lista = query.getResultList();			
		} catch (Exception e) {
			System.out.println("error en el metodo getAlistamientosProcesos():" + e);
		}finally{
			em.close();			
		}

		return lista;

	}

	public Date getFechaCreacionAlistamiento(String numAlistamiento, Date fechaDesocupacion){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
									
		Date fechaCreacion = new Date();
		EntityManager em = EntityManagerImp.getManager();

		try{
			if(numAlistamiento != null && fechaDesocupacion != null){
				String sqlQuery = "SELECT	TRUNC(DSE_FCHA_ACTLZCION)" +
						"		   FROM		DSCPCNES_EFCTDAS " +
						"          WHERE	DSE_NMRO_SNSTRO = (SELECT	DC.NUMERO_SINIESTRO " +
						"									   FROM		DEUDAS_CLIENTES DC, " +
						"												OBLIGACIONES_ALISTAMIENTO OA " +
						"									   WHERE	DC.SECUENCIA_DEUDA = OA.SECUENCIA_DEUDA " +
						"									   AND		OA.NUMERO_ALISTAMIENTO = "+numAlistamiento+") " +
						"		   AND		TRUNC(DSE_FCHA_DSCPCION) = TO_DATE('"+sdf.format(fechaDesocupacion)+"','DD/MM/YYYY')";
				
				Query query = em.createNativeQuery(sqlQuery);
				fechaCreacion = (Date)query.getSingleResult();
			} else {
				return null;
			}
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	    
		return fechaCreacion;
	}
	
	//-----------------------------------------------------------------------------------
	
	public static void main(String args[]){
		ConsultaGeneralDTO consultaGeneralDTO = new ConsultaGeneralDTO();
		List<ProcesosAlistamientoV> lista = consultaGeneralDTO.procesosAlistamiento(new BigDecimal(17556));
		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			ProcesosAlistamientoV procesosAlistamientoV = (ProcesosAlistamientoV) iterator.next();
			System.out.println(procesosAlistamientoV.getEstadoProceso()+" "+ procesosAlistamientoV.getEstadoPro());
		}
	}

}
 