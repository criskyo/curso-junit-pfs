package com.geekshubsacademy.junit.pfs.manager;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.geekshubsacademy.junit.pfs.TestDeIntegracion;

import static org.mockito.Mockito.*;

//@RunWith(SpringRunner.class)
//@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
@Category(TestDeIntegracion.class)
public class SubastaManagerDataJpaTest {
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void testActualizarLoteConObservaciones() throws Exception {
		// Setup
		SubastaManager manager = new SubastaManager();
		SubastaProcedimientoApi api = mock(SubastaProcedimientoApi.class);
		manager.setSubastaProcedimientoApi(api );
		GenericABMDao dao = new GenericABMDao();
		dao.setEntityManager(entityManager);
		manager.setGenericDao(dao);
		
		LoteSubasta entity = new LoteSubasta();
		entity.setId(1L);
		entityManager.persist(entity);
		
		GuardarInstruccionesDto dto = new GuardarInstruccionesDto();
		dto.setIdLote("1");
		dto.setObservaciones("Observaciones");
		
		// Test
		manager.guardaInstruccionesLoteSubasta(dto);

		// Assert
		LoteSubasta lote = entityManager.find(LoteSubasta.class, 1L);
		assertEquals("Observaciones", lote.getObservaciones());
	}

	@Test
	public void hibernateAplicaLaFuncionUpperCaseALasObservaciones() throws Exception {
		// Setup
		SubastaManager manager = new SubastaManager();
		SubastaProcedimientoApi api = mock(SubastaProcedimientoApi.class);
		manager.setSubastaProcedimientoApi(api );
		GenericABMDao dao = new GenericABMDao();
		dao.setEntityManager(entityManager);
		manager.setGenericDao(dao);
		
		LoteSubasta entity = new LoteSubasta();
		entity.setId(1L);
		entityManager.persist(entity);
		
		GuardarInstruccionesDto dto = new GuardarInstruccionesDto();
		dto.setIdLote("1");
		dto.setObservaciones("Observaciones");
		
		// Test
		manager.guardaInstruccionesLoteSubasta(dto);
		entityManager.clear();
		
		// Assert
		LoteSubasta lote = entityManager.find(LoteSubasta.class, 1L);
		assertEquals("OBSERVACIONES", lote.getObservaciones());
	}

}
