package com.produtos.apirest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.produtos.apirest.models.IdPessoal;
import com.produtos.apirest.models.LivroCaixa;

public interface LivrocaixaRepository extends JpaRepository<LivroCaixa, Integer>  {

	@Query(value = "select * from  livrocaixa where num_id = :num_id ", nativeQuery = true)
	public List<LivroCaixa> findnumid(@Param ("num_id")int num_id);

	
	@Query(value = "select * from  livrocaixa where num_id = :num_id and datalancamento = :datalancamento", nativeQuery = true)
	public List<LivroCaixa> findcontabil(@Param ("num_id")int num_id,@Param ("datalancamento") Date datalancamento );
	
	
	
	
}