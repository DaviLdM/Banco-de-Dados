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

import com.produtos.apirest.models.Cliente;
import com.produtos.apirest.models.LivroCaixa;
import com.produtos.apirest.repository.ClienteRepository;
import com.produtos.apirest.repository.LivrocaixaRepository;
import com.produtos.apirest.repository.ProdutoRepository;
import com.produtos.apirest.repository.UsuarioRepository;

@RestController
@RequestMapping(value="/apil")
public class LivroCaixaResource {

	
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	ClienteRepository clienterepository;
	@Autowired
	UsuarioRepository usuariorepository;
	@Autowired
	LivrocaixaRepository livrocaixarepository;
	
	
	@GetMapping("/caixas")
	public List<LivroCaixa> listadados(){
		System.out.println("entrou");
		return livrocaixarepository.findAll();
	}
	
	@GetMapping("/caixa/{id}")
	public Optional<LivroCaixa> listadadounico(@PathVariable(value="id") int id) {
		
		return livrocaixarepository.findById(id);
	}
	
	
	@GetMapping("/caixaid/{num_id}")
	public List<LivroCaixa> listalivro_cliente(@PathVariable(value="num_id") int num_id) {
		
		List<LivroCaixa> x = (List<LivroCaixa>) livrocaixarepository.findnumid( num_id);
		
		return x ;
	
	}
	
		
	@PostMapping("/caixa")
	public LivroCaixa salvadados(@RequestBody LivroCaixa livrocaixa) {
		
		
	
		
		return livrocaixarepository.save(livrocaixa);
		
	}
	
	
	@DeleteMapping("/caixa")
	public void deleteadados(@RequestBody LivroCaixa livrocaixa) {
		
		livrocaixarepository.deleteById(livrocaixa.getId());
		
	}
	
	@PutMapping("/caixa")
	public LivroCaixa atualizaadados(@RequestBody LivroCaixa livrocaixa) {
		return livrocaixarepository.save(livrocaixa);
	}
	
	
	
	
	
}