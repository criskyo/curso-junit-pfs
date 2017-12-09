package com.geekshubsacademy.junit.pfs.manager;

import lombok.Data;

@Data
public class LoteSubasta {
	
	private Float insPujaSinPostores;
	private Float insPujaPostoresDesde;
	private Float insPujaPostoresHasta;
	private Float insValorSubasta;
	private Float ins50DelTipoSubasta;
	private Float ins60DelTipoSubasta;
	private Float ins70DelTipoSubasta;
	private String observaciones;
	private Boolean riesgoConsignacion;
	private Float deudaJudicial;
	private Object subasta;

}
