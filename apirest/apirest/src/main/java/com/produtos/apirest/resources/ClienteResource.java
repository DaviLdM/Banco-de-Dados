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
import com.produtos.apirest.models.IdPessoal;
import com.produtos.apirest.models.Usuario;
import com.produtos.apirest.repository.ClienteRepository;
import com.produtos.apirest.repository.ProdutoRepository;




@RestController
@RequestMapping(value="/apic")
public class ClienteResource {

	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	ClienteRepository clienterepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listadados(){
		System.out.println("entrou");
		return clienterepository.findAll();
	}
	
	@GetMapping("/cliente/{id}")
	public Optional<Cliente> listadadounico(@PathVariable(value="id") int id) {
		
		return clienterepository.findById(id);
	}
	
	
	@GetMapping("/clientenome/{pesquisar}")
	public List<Cliente> clientecidade(@PathVariable (value = "pesquisar") String pesquisar ) 
	{
		System.out.println(pesquisar);
		List<Cliente> x = (List<Cliente>) clienterepository.findcidade ( pesquisar );
		System.out.println(x.size());
		
		
		return x ;
	}
	
	
	
	@PostMapping("/cliente")
	public Cliente salvadados(@RequestBody Cliente cliente) {
		
		
		return clienterepository.save(cliente);
		
	}
	
	
	@DeleteMapping("/cliente")
	public void deleteadados(@RequestBody Cliente cliente) {
		
		System.out.println("entrou");
		System.out.println(cliente.getId());
		System.out.println(cliente.getLogradouro());
		clienterepository.deleteById(cliente.getId());
		
	}
	
	@PutMapping("/cliente")
	public Cliente atualizaadados(@RequestBody Cliente cliente) {
		return clienterepository.save(cliente);
	}
	
	
	
}
