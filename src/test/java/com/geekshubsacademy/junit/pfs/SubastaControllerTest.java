package com.geekshubsacademy.junit.pfs;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.ui.ModelMap;

import com.geekshubsacademy.junit.pfs.controller.SubastaController;

public class SubastaControllerTest {

	@Test(expected = NullPointerException.class)
	public void todosLosParametrosNullLanzaNullPointerEXception() {
		SubastaController controller = new SubastaController();
		Long idSubasta = null;
		String idsBien = null;
		String lotes = null;
		String accion = null;
		ModelMap map = null;
		controller.guardarAgregarExcluirBien(idSubasta, idsBien, lotes, accion, map);
	}

}
