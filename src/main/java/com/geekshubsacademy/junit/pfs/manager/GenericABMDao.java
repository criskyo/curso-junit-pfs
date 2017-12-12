package com.geekshubsacademy.junit.pfs.manager;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class GenericABMDao {
	
	@PersistenceContext
    private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void update(Class<?> entityClass, Object data) {
		entityManager.persist(data);
		entityManager.flush();
	}

	public LoteSubasta find(Class<?> entityClass, long idLote) {
		return (LoteSubasta) entityManager.find(entityClass, new Long(idLote));
	}

	public int selectCount(String sql) {
		Query query = entityManager.createNativeQuery(sql);
		Object singleResult = query.getSingleResult();
		return ((BigInteger)singleResult).intValue();
	}
	
	

}
