package com.geekshubsacademy.junit.pfs;

import org.junit.Test;
//import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@Category(TestDeIntegracion.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class CursoJunitPfsApplicationTests {

	@Test
	public void contextLoads() {
	}

}
