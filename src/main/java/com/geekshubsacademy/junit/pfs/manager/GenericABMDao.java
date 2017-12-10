package com.geekshubsacademy.junit.pfs.manager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;

@Repository
@Getter
@Setter
public class GenericABMDao {
	
	@PersistenceContext
    private EntityManager entityManager;

	public void update(Class<?> entityClass, Object data) {
		entityManager.persist(data);
		entityManager.flush();
	}

	public LoteSubasta find(Class<?> entityClass, long idLote) {
		return (LoteSubasta) entityManager.find(entityClass, new Long(idLote));
	}
	
	

}
