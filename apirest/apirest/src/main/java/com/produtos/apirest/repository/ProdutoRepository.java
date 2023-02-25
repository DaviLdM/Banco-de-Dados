package com.produtos.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.produtos.apirest.models.IdPessoal;

public interface ProdutoRepository extends JpaRepository<IdPessoal, Integer>  {

	@Query(value = "select * from id_pessoal, usuario where id_pessoal.id = usuario.id", nativeQuery = true)
	List<IdPessoal> findInfoByUid();
	
	
}

