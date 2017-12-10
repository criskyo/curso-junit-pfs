package com.geekshubsacademy.junit.pfs.manager;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;

public class SubastaManagerTest {
	
	@Test
	public void testActualizarLoteConObservaciones() throws Exception {
		// Setup
		SubastaManager manager = new SubastaManager();
		
		SubastaProcedimientoApi api = mock(SubastaProcedimientoApi.class);
		manager.setSubastaProcedimientoApi(api);
		
		GenericABMDao dao = mock(GenericABMDao.class);
		when(dao.find(LoteSubasta.class, new Long(1L))).thenReturn(new LoteSubasta());
		manager.setGenericDao(dao);
		
		GuardarInstruccionesDto dto = new GuardarInstruccionesDto();
		dto.setIdLote("1");
		dto.setObservaciones("Observaciones");
		
		// Test
		manager.guardaInstruccionesLoteSubasta(dto);
		
		// Assert
		ArgumentCaptor<LoteSubasta> captor = ArgumentCaptor.forClass(LoteSubasta.class);
		verify(dao).update(any(Class.class), captor.capture());
		assertEquals("Observaciones", captor.getValue().getObservaciones());
	}

}
