package com.produtos.apirest.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.IdPessoal;
import com.produtos.apirest.repository.ProdutoRepository;



@RestController
@RequestMapping(value="/api")
public class DadosResource {

	
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/dados")
	public List<IdPessoal> listadados(){
		System.out.println("entrou");
		return produtoRepository.findAll();
	}
	
	@GetMapping("/dados/{id}")
	public Optional<IdPessoal> listadadounico(@PathVariable(value="id") int id) {
		
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/dado")
	public IdPessoal salvadados(@RequestBody IdPessoal id_pessoal) {
		System.out.println("entrou");
		
		List<IdPessoal > x = produtoRepository.findInfoByUid();
		
		for(IdPessoal s:x) {
			System.out.println(s.getId());
					}
		
		return produtoRepository.save(id_pessoal);
		
	}
	
	
	@DeleteMapping("/dado")
	public void deleteadados(@RequestBody IdPessoal id_pessoal) {
		System.out.println("entrou");
		System.out.println(id_pessoal.getId());
		System.out.println(id_pessoal.getEmail());
		produtoRepository.deleteById(id_pessoal.getId());
		
	}
	
	@PutMapping("/dado")
	public IdPessoal atualizaadados(@RequestBody IdPessoal id_pessoal) {
		return produtoRepository.save(id_pessoal);
	}
	
	
	
}







