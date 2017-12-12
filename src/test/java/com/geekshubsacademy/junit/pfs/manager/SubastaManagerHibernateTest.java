package com.geekshubsacademy.junit.pfs.manager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
@Transactional
public class SubastaManagerHibernateTest {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Before
	public void setup() {
		LoteSubasta lote = new LoteSubasta();
		lote.setId(1L);
		entityManager.persist(lote);
		entityManager.flush();
	}
	
	@Test
	public void testCountSubastas() {
		// Preparar
		SubastaManager manager = new SubastaManager();
		GenericABMDao genericDao = new GenericABMDao();
		genericDao.setEntityManager(entityManager);
		
		manager.setGenericDao(genericDao);
		SubastaProcedimientoApi api = mock(SubastaProcedimientoApi.class);
		manager.setSubastaProcedimientoApi(api);
		GuardarInstruccionesDto dto = new GuardarInstruccionesDto();
		dto.setIdLote("1");
		
		// Test
		manager.guardaInstruccionesLoteSubasta(dto);
		
		// Assert
		entityManager.clear();
		assertEquals(1, entityManager.find(LoteSubasta.class, 1L).getCountSubastas());
	}

}
