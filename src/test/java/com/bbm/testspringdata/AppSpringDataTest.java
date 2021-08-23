package com.bbm.testspringdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbm.testspringdata.dao.UsuarioRepository;
import com.bbm.testspringdata.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class AppSpringDataTest {

	@Autowired
	private UsuarioRepository repository;

	@Test
	public void testSave() {
		Usuario usuario = new Usuario();
		
		usuario.setUsername("Juniioor");
		usuario.setPassword("hellor");
		usuario.setEmail("heloo@adsad.com");
		usuario.setIdade(20);
		
		repository.save(usuario);
	}
}
