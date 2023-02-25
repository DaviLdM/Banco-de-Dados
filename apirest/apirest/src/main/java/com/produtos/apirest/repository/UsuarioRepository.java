package com.produtos.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.produtos.apirest.models.LivroCaixa;
import com.produtos.apirest.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>  {

	@Query(value = "select * from  usuario where nome LIKE %:pesquisar%  or email LIKE %:pesquisar% ", nativeQuery = true)
	public List<Usuario> findnome(@Param ("pesquisar")  String pesquisar );
	
	@Query(value = "select * from  usuario where login = :login and senha = :senha  ", nativeQuery = true)
	public Usuario Testeusuario(@Param ("login")  String login, @Param ("senha")  String senha  );
	
}
