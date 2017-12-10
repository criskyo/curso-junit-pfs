package com.geekshubsacademy.junit.pfs.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ModelMap;
//import org.springframework.web.util.NestedServletException;

import com.geekshubsacademy.junit.pfs.TestDeIntegracion;
import com.geekshubsacademy.junit.pfs.controller.SubastaApi;
import com.geekshubsacademy.junit.pfs.controller.SubastaController;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith(SpringRunner.class)
//@WebMvcTest(SubastaController.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Category(TestDeIntegracion.class)
@ContextConfiguration
public class SubastaControllerMockMvcTest {
	
//    @Autowired
//    private MockMvc mvc;
    
//    @MockBean
//    private SubastaApi subastaApi;
	
	@Test//(expected = NestedServletException.class)
	public void elParametroLotesNoEsObligatorioYPorTantoLanzaNullPointerExceptionAlIntentarAgregarUnBien() throws Exception {
//		this.mvc.perform(
//				get("/guardarAgregarExcluirBien")
//				.param("idSubasta", "1")
//				.param("idsBien", "1,2,3")
//				.param("accion", "ACCION_AGREGAR_BIEN")
//				//.param("lotes", null)
//		);
	}

	@Test
	public void springEsCapazDeConvertirUnRequestParamCSVEnUnArrayDeString() throws Exception {
//		this.mvc.perform(
//				get("/agregarBien")
//				.param("idSubasta", "1")
//				.param("idsBien", "1,2,3")
//				//.param("lotes", null)
//		);
//		verify(subastaApi).agregarBienes(1L, new String[] {"1", "2", "3"}, null);
	}


}
