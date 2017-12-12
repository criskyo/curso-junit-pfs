package com.geekshubsacademy.junit.pfs.manager;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Formula;

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
	
	private String observaciones;
	private Boolean riesgoConsignacion;
	private Float deudaJudicial;
	
	private Date fechaEstado;
	
	//@Formula("select count(*) from lotesubasta")
	private int countSubastas;
	
	
	public int getCountSubastas() {
		return countSubastas;
	}

	public void setCountSubastas(int countSubastas) {
		this.countSubastas = countSubastas;
	}

	public Date getFechaEstado() {
		return fechaEstado;
	}

	public void setFechaEstado(Date fechaEstado) {
		this.fechaEstado = fechaEstado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getInsPujaSinPostores() {
		return insPujaSinPostores;
	}

	public void setInsPujaSinPostores(Float insPujaSinPostores) {
		this.insPujaSinPostores = insPujaSinPostores;
	}

	public Float getInsPujaPostoresDesde() {
		return insPujaPostoresDesde;
	}

	public void setInsPujaPostoresDesde(Float insPujaPostoresDesde) {
		this.insPujaPostoresDesde = insPujaPostoresDesde;
	}

	public Float getInsPujaPostoresHasta() {
		return insPujaPostoresHasta;
	}

	public void setInsPujaPostoresHasta(Float insPujaPostoresHasta) {
		this.insPujaPostoresHasta = insPujaPostoresHasta;
	}

	public Float getInsValorSubasta() {
		return insValorSubasta;
	}

	public void setInsValorSubasta(Float insValorSubasta) {
		this.insValorSubasta = insValorSubasta;
	}

	public Float getIns50DelTipoSubasta() {
		return ins50DelTipoSubasta;
	}

	public void setIns50DelTipoSubasta(Float ins50DelTipoSubasta) {
		this.ins50DelTipoSubasta = ins50DelTipoSubasta;
	}

	public Float getIns60DelTipoSubasta() {
		return ins60DelTipoSubasta;
	}

	public void setIns60DelTipoSubasta(Float ins60DelTipoSubasta) {
		this.ins60DelTipoSubasta = ins60DelTipoSubasta;
	}

	public Float getIns70DelTipoSubasta() {
		return ins70DelTipoSubasta;
	}

	public void setIns70DelTipoSubasta(Float ins70DelTipoSubasta) {
		this.ins70DelTipoSubasta = ins70DelTipoSubasta;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Boolean getRiesgoConsignacion() {
		return riesgoConsignacion;
	}

	public void setRiesgoConsignacion(Boolean riesgoConsignacion) {
		this.riesgoConsignacion = riesgoConsignacion;
	}

	public Float getDeudaJudicial() {
		return deudaJudicial;
	}

	public void setDeudaJudicial(Float deudaJudicial) {
		this.deudaJudicial = deudaJudicial;
	}

	public Object getSubasta() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
