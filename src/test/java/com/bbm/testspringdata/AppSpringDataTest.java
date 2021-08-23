package com.bbm.testspringdata;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbm.testspringdata.dao.TelefoneRepository;
import com.bbm.testspringdata.dao.UsuarioRepository;
import com.bbm.testspringdata.model.Telefone;
import com.bbm.testspringdata.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class AppSpringDataTest {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private TelefoneRepository telefoneRepository;

	@Test
	public void testSave() {
		Usuario usuario = new Usuario();

		usuario.setUsername("Seila Mungoi");
		usuario.setPassword("osvasa");
		usuario.setEmail("seila@adsad.com");
		usuario.setIdade(29);

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
		// repository.deleteById(3L);
	}

	@Test
	public void testFindByName() {
		List<Usuario> list = repository.findByName("Belmiro");

		for (Usuario usuario : list) {
			System.out.println(usuario.toString());
			System.out.println("-----------------------------------------------");
		}
	}

	@Test
	public void testFindByParam() {
		Usuario usuario = repository.findByNameParam("Belmiro");

		System.out.println(usuario.toString());
		System.out.println("--------------------------------------------------");
	}

	@Test
	public void testDeleteByName() {
		repository.deleteByName("Belmiro");
	}

	@Test
	public void testUpdateByName() {
		repository.updateByName("junior@gmail.com", "Juniioor");
	}

	@Test
	public void testSavePhone() {
		Optional<Usuario> usuario = repository.findById(1L);

		Telefone telefone = new Telefone();
		telefone.setPhoneType("Home and Work");
		telefone.setPhoneNumber("21231");
		telefone.setUsuario(usuario.get());

		telefoneRepository.save(telefone);
	}
	
	@Test
	public void testFindPhoneById() {
		Optional<Telefone> telefone = telefoneRepository.findById(2L);
		
		System.out.println(telefone.get());
	}
	
	@Test
	public void testFindAllPhone() {
		Iterable<Telefone> telefones = telefoneRepository.findAll();
		
		for (Telefone telefone : telefones) {
			System.out.println(telefone.toString());
			System.out.println("----------------------------------------------");
		}
	}
}
