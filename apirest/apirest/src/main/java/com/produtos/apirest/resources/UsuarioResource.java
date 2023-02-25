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
import com.produtos.apirest.models.LivroCaixa;
import com.produtos.apirest.models.Usuario;
import com.produtos.apirest.repository.ClienteRepository;
import com.produtos.apirest.repository.ProdutoRepository;
import com.produtos.apirest.repository.UsuarioRepository;

@RestController
@RequestMapping(value="/apiu")
public class UsuarioResource {

	
	
		
	
	
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	ClienteRepository clienterepository;
	@Autowired
	UsuarioRepository usuariorepository;
	
	@GetMapping("/usuarios")
	public List<Usuario> listadados(){
		System.out.println("entrou");
		return usuariorepository.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	public Optional<Usuario> listadadounico(@PathVariable(value="id") int id) {
		
		return usuariorepository.findById(id);
	}
	
	
	
	@GetMapping("/usuarionome/{pesquisar}")
	public List<Usuario> usuarioemailnome(@PathVariable (value = "pesquisar") String pesquisar ) 
	{
		System.out.println(pesquisar);
		List<Usuario> x = (List<Usuario>) usuariorepository.findnome( pesquisar );
		System.out.println(x.size());
		
		
		return x ;
	}
	
	@GetMapping("/testelogin")
	public Usuario teste (@RequestBody Usuario usuario){
		Usuario Verificado  =  usuariorepository.Testeusuario ( usuario.getLogin(), usuario.getSenha());
			
		
		
		
		
		
		return  Verificado;
	}
	
	
	
	
	
	
	@PostMapping("/usuario")
	public Usuario salvadados(@RequestBody Usuario usuario) {
		
		
		return usuariorepository.save(usuario);
		
	}
	
	
		
	@DeleteMapping("/usuario")
	public void deleteadados(@RequestBody Usuario usuario) {
		
		System.out.println("entrou");
		System.out.println(usuario.getId());
		System.out.println(usuario.getLogin());
		usuariorepository.deleteById(usuario.getId());
		
	}
	
	@PutMapping("/usuario")
	public Usuario atualizaadados(@RequestBody Usuario usuario) {
		return usuariorepository.save(usuario);
	}
	
	
	
}
