package com.geekshubsacademy.junit.pfs.manager;

import java.util.Properties;
import java.util.concurrent.Executor;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

@SuppressWarnings("deprecation")
@Service("subastaManager")
public class SubastaManager implements SubastaApi {
	
//	@Autowired
//	private ApiProxyFactory proxyFactory;
//
	@Autowired
	private GenericABMDao genericDao;
//
//	@Autowired
//	private SubastaDao subastaDao;	
//
//	@Autowired
//	private OficinaDao oficinaDao;	
//	
//	@Autowired
//	private NMBBienDao nmbBienDao;
//	
//	@Autowired
//	private Executor executor;
//
//	@Resource
//	private Properties appProperties;
	
	DiccionarioApi diccionarioApi;

	private SubastaProcedimientoApi subastaProcedimientoApi;


	//@Override
	//@Transactional(readOnly = false)
	@Transactional
	public void guardaInstruccionesLoteSubasta(GuardarInstruccionesDto dto) {
		LoteSubasta loteSubasta = this.getLoteSubasta(Long.parseLong(dto.getIdLote()));

		if (!Checks.esNulo(loteSubasta)) {
			loteSubasta.setInsPujaSinPostores(Checks.esNulo(dto.getPujaSinPostores()) ? null : Float.parseFloat(dto.getPujaSinPostores()));
			loteSubasta.setInsPujaPostoresDesde(Checks.esNulo(dto.getPujaPostoresDesde()) ? null : Float.parseFloat(dto.getPujaPostoresDesde()));
			loteSubasta.setInsPujaPostoresHasta(Checks.esNulo(dto.getPujaPostoresHasta()) ? null : Float.parseFloat(dto.getPujaPostoresHasta()));
			loteSubasta.setInsValorSubasta(Checks.esNulo(dto.getValorSubasta()) ? null : Float.parseFloat(dto.getValorSubasta()));
			loteSubasta.setIns50DelTipoSubasta(Checks.esNulo(dto.getTipoSubasta50()) ? null : Float.parseFloat(dto.getTipoSubasta50()));
			loteSubasta.setIns60DelTipoSubasta(Checks.esNulo(dto.getTipoSubasta60()) ? null : Float.parseFloat(dto.getTipoSubasta60()));
			loteSubasta.setIns70DelTipoSubasta(Checks.esNulo(dto.getTipoSubasta70()) ? null : Float.parseFloat(dto.getTipoSubasta70()));
			loteSubasta.setObservaciones(Checks.esNulo(dto.getObservaciones()) ? null : HtmlUtils.htmlUnescape(dto.getObservaciones()));
			if (!Checks.esNulo(dto.getRiesgoConsignacion())) {
				DDSiNo sino = (DDSiNo)diccionarioApi.dameValorDiccionarioByCod(DDSiNo.class, dto.getRiesgoConsignacion());	
				loteSubasta.setRiesgoConsignacion(sino!=null && DDSiNo.SI.equals(sino.getCodigo()));
			}
			loteSubasta.setDeudaJudicial(Checks.esNulo(dto.getDeudaJudicial()) ? null : Float.parseFloat(dto.getDeudaJudicial()));
			genericDao.update(LoteSubasta.class, loteSubasta);
			
			//Calculamos el tipo de subasta en este momento
			subastaProcedimientoApi.determinarTipoSubasta(loteSubasta.getSubasta());  // <<<<<<<<< Este método cambia el estado de la subasta según los valores actuales.
		}

	}


	private LoteSubasta getLoteSubasta(long parseLong) {
		// TODO Auto-generated method stub
		return null;
	}


}
