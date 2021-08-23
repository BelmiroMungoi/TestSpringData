package com.bbm.testspringdata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bbm.testspringdata.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	@Query(value = "select p from Usuario p where p.username like %?1%")
	public List<Usuario> findByName(String name);
	
	@Query(value = "select p from Usuario p where p.username =:paramNome")
	public Usuario findByNameParam(@Param("paramNome") String paramNome);
	
	@Modifying
	@Transactional
	@Query(value = "delete from Usuario u where u.username = ?1")
	public void deleteByName(String name);
	
	@Modifying
	@Transactional
	@Query(value = "update Usuario u set u.email = ?1 where username = ?2")
	public void updateByName(String email, String name);
	
}
