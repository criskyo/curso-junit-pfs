package com.geekshubsacademy.junit.pfs.manager;

import lombok.Data;

@Data
public class GuardarInstruccionesDto {
	
	private String idLote;
	private String pujaSinPostores;
	private String pujaPostoresDesde;
	private String pujaPostoresHasta;
	private String valorSubasta;
	private String tipoSubasta50;
	private String tipoSubasta60;
	private String tipoSubasta70;
	private String observaciones;
	private String riesgoConsignacion;
	private String deudaJudicial;
	

}
