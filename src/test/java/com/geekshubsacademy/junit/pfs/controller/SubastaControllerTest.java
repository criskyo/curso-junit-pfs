package com.geekshubsacademy.junit.pfs.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.ModelMap;

import com.geekshubsacademy.junit.pfs.controller.SubastaApi;
import com.geekshubsacademy.junit.pfs.controller.SubastaController;

import static org.mockito.Mockito.*;

public class SubastaControllerTest {

	@Test(expected = NullPointerException.class)
	public void conTodosLosParametrosANullLanzaUnNullPointerException() {
		SubastaController controller = new SubastaController();
		Long idSubasta = null;
		String idsBien = null;
		String lotes = null;
		String accion = null;
		ModelMap map = null;
		controller.guardarAgregarExcluirBien(idSubasta, idsBien, lotes, accion, map);
	}

	@Test
	public void agregaBienesConArrayDeBienesYLotes() {
		SubastaController controller = new SubastaController();
		SubastaApi subastaApi = mock(SubastaApi.class);
		controller.setSubastaApi(subastaApi);
		Long idSubasta = null;
		String idsBien = "1,2,3";
		String lotes = "a,b,c";
		String accion = "ACCION_AGREGAR_BIEN";
		ModelMap map = null;
		String resultado = controller.guardarAgregarExcluirBien(idSubasta, idsBien, lotes, accion, map);
		assertEquals("default", resultado);
		verify(subastaApi).agregarBienes(null, new String[] {"1", "2", "3"}, new String[] {"a", "b", "c"});
	}

	@Test
	public void unaAccionDesconocidaSiempreExcluyeBienes() {
		SubastaController controller = new SubastaController();
		SubastaApi subastaApi = mock(SubastaApi.class);
		controller.setSubastaApi(subastaApi);
		Long idSubasta = null;
		String idsBien = "1,2,3";
		String lotes = "a,b,c";
		String accion = "ACCION_DESCONOCIDA";
		ModelMap map = null;
		String resultado = controller.guardarAgregarExcluirBien(idSubasta, idsBien, lotes, accion, map);
		assertEquals("default", resultado);
		verify(subastaApi).excluirBienes(null, new String[] {"1", "2", "3"});
	}

}
