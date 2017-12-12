package com.geekshubsacademy.junit.pfs.manager;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SubastaManagerTest {
	
	@InjectMocks
	private SubastaManager manager;
	
	@Mock
	private SubastaProcedimientoApi api;

	@Mock
	private GenericABMDao dao;

	@Test
	public void testActualizarLoteConObservaciones() throws Exception {
		// Preparar
		when(dao.find(LoteSubasta.class, new Long(1L))).thenReturn(new LoteSubasta());
		
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
