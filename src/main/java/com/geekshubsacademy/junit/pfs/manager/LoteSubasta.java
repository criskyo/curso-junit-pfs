package com.geekshubsacademy.junit.pfs.manager;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnTransformer;

import lombok.Data;

@Data
@Entity
public class LoteSubasta {
	@Id
	private Long id;
	private Float insPujaSinPostores;
	private Float insPujaPostoresDesde;
	private Float insPujaPostoresHasta;
	private Float insValorSubasta;
	private Float ins50DelTipoSubasta;
	private Float ins60DelTipoSubasta;
	private Float ins70DelTipoSubasta;
	
	@ColumnTransformer(write="upper(?)")
	private String observaciones;
	private Boolean riesgoConsignacion;
	private Float deudaJudicial;
	
	@Transient
	private Object subasta;

}
