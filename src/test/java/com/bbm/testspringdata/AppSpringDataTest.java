package com.bbm.testspringdata;

import java.util.Optional;

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
	
	@Test
	public void testFindById() {
		Optional<Usuario> usuario = repository.findById(2L);
		
		System.out.println(usuario.get().toString());
	}
	
	@Test
	public void testFindAll() {
		Iterable<Usuario> userList = repository.findAll();
		
		for (Usuario usuario : userList) {
			System.out.println(usuario.toString());
			System.out.println("-----------------------------------------------");
		}
	}
	
	@Test
	public void testUpdate() {
		Optional<Usuario> usuario = repository.findById(1L);
		Usuario user = usuario.get();
		
		user.setUsername("BemiasSilvaJunior");
		
		repository.save(user);
	}
	
	@Test
	public void testDelete() {
		Optional<Usuario> usuario = repository.findById(5L);

		repository.delete(usuario.get());
		//repository.deleteById(3L);
	}
}
