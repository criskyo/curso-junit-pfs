package com.geekshubsacademy.junit.pfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubastaController {

	private static final String DEFAULT = "default"; 

//	@Autowired
//	private ApiProxyFactory proxyFactory;
	
	@Autowired
	private SubastaApi subastaApi;
	
//	@Autowired
//	private SubastaManager subastaManager;
	
//	@Autowired
//	private NMBProjectContext nmbProjectContext;


	@SuppressWarnings("static-access")
	@RequestMapping("/guardarAgregarExcluirBien")
	public String guardarAgregarExcluirBien(
			@RequestParam(value = "idSubasta", required = true) Long idSubasta,
			@RequestParam(value = "idsBien", required = true) String idsBien,
			@RequestParam(value = "lotes", required = false) String lotes,
			@RequestParam(value = "accion", required = true) String accion,			
			ModelMap map) {
		
		String[] arrBien = idsBien.split(",");
		if (subastaApi.ACCION_AGREGAR_BIEN.equals(accion)) {
			String[] arrLotes = lotes.split(",");
			subastaApi.agregarBienes(idSubasta, arrBien, arrLotes);
		} else {
			subastaApi.excluirBienes(idSubasta,arrBien);
		}
		
		return DEFAULT;
	}

	@RequestMapping("/agregarBien")
	public String agregarBien(
			@RequestParam(value = "idSubasta", required = true) Long idSubasta,
			@RequestParam(value = "idsBien", required = true) String[] arrBien,
			@RequestParam(value = "lotes", required = false) String[] arrLotes) {
		
			subastaApi.agregarBienes(idSubasta, arrBien, arrLotes);
		
		return DEFAULT;
	}
	
	public SubastaApi getSubastaApi() {
		return subastaApi;
	}

	public void setSubastaApi(SubastaApi subastaApi) {
		this.subastaApi = subastaApi;
	}

	
}