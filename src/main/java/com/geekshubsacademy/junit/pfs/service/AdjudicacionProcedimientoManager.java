package com.geekshubsacademy.junit.pfs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adjudicacionProcedimientoManagerDelegated")
public class AdjudicacionProcedimientoManager implements AdjudicacionProcedimientoDelegateApi {

//	@Autowired
//	private ApiProxyFactory proxyFactory;

	@Autowired
	private Executor executor;

//	@Autowired
//	private GenericABMDao genericDao;

	@Override
//	@BusinessOperation(overrides = BO_ADJUDICACION_COMPROBAR_ESTADO_CARGAS_CANCELACION)
	public Boolean comprobarEstadoCargasCancelacion(Long prcId) {

		@SuppressWarnings("unchecked")
		List<Bien> listaBienes = (List<Bien>) executor.execute(ExternaBusinessOperation.BO_PRC_MGR_GET_BIENES_DE_UN_PROCEDIMIENTO, prcId);
		if (listaBienes != null && listaBienes.size() > 0) {
			for (Bien bien : listaBienes) {
				if (bien instanceof NMBBien) {
					NMBBien nmbBien = (NMBBien) bien;
					List<NMBBienCargas> cargas = nmbBien.getBienCargas();
					// no hay cargas
					if ((cargas == null || cargas != null && cargas.size() == 0)) {
						NMBAdicionalBien adicionalBien = ((NMBBien) bien).getAdicional();
						// y se ha revisado
						if (adicionalBien.getSinCargas()) {
							return true;
						} else {
							return false;
						}
					} else {
						// hay cargas
						Boolean verificadasCargas = false;
						Boolean hayRegistrales = false;
						for (NMBBienCargas carga : cargas) {
							// TODOS LOS TIPOS DE CARGA, Antes solo se
							// comprobaban los anteriores
							if (carga.getRegistral()) {
								hayRegistrales = true;
								if (DDSituacionCarga.CANCELADA.compareTo(carga.getSituacionCarga().getCodigo()) == 0
										|| DDSituacionCarga.RECHAZADA.compareTo(carga.getSituacionCarga().getCodigo()) == 0) {
									verificadasCargas = true;
								} else {
									return false;
								}
							}
						}
						if (verificadasCargas || !hayRegistrales) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}


}
