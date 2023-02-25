package com.produtos.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.produtos.apirest.models.Cliente;
import com.produtos.apirest.models.Usuario;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>  {

	@Query(value = "select * from  cliente where nome LIKE %:pesquisar%  or cpfcnpj LIKE %:pesquisar% or cidade LIKE %:pesquisar% or uf LIKE %:pesquisar% ", nativeQuery = true)
	public List<Cliente> findcidade(@Param ("pesquisar")  String pesquisar );
	
	
}