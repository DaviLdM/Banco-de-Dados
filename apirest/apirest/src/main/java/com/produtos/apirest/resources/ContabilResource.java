package com.produtos.apirest.resources;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.LivroCaixaContabil;
import com.produtos.apirest.models.Cliente;
import com.produtos.apirest.models.Contabil;
import com.produtos.apirest.models.LivroCaixa;
import com.produtos.apirest.repository.ClienteRepository;

import com.produtos.apirest.repository.LivrocaixaRepository;

@RestController
@RequestMapping(value="/apico")
public class ContabilResource {

	@Autowired
	ClienteRepository clienterepository;
	@Autowired
	LivrocaixaRepository livrocaixarepository;
	
	
	
	
	
	@GetMapping("/contabil/{id}/{datalancamento}")
	public Contabil getContabil(@PathVariable (value = "id") Integer id , @PathVariable (value = "datalancamento") String datalancamento) throws ParseException {
		Contabil contabil = new Contabil();
		Cliente x = (Cliente) clienterepository.getById(id);
		contabil.setId(x.getId());
		contabil.setCpfcnpj(x.getCpfcnpj());
		contabil.setEmail(x.getEmail());
		contabil.setNome(x.getNome());
		
		/*livrocaixa y = (livrocaixa) livrocaixarepository.findnumid(id);
		contabil.setDescricao(y.getDescricao());
		contabil.setDatalancamento(y.getDatalancamento());
		contabil.setTipo(y.getTipo());
		contabil.setValor(y.getTipo());*/
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date novodate =  format.parse(datalancamento);
		
		java.sql.Date sql = new java.sql.Date(novodate.getTime());
		
		List<LivroCaixa> y = (List<LivroCaixa>) livrocaixarepository.findcontabil(id, novodate);
		List<LivroCaixaContabil> Listcontabil = new ArrayList<LivroCaixaContabil>();
		
		float Saldo =  0;
		
		
		
		for(int i = 0;i<y.size();i++ ) {
		
		if(y.get(i).getTipo() == 'C') {
			Saldo += y.get(i).getValor();
			
		}else {
			Saldo -= y.get(i).getValor();
		}
		
			
			
		LivroCaixaContabil z = new  LivroCaixaContabil();
		System.out.println("nd");
		z.setTipo(y.get(i).getTipo());
		z.setDatalancamento(y.get(i).getDatalancamento());
		z.setDescricao(y.get(i).getDescricao());
		z.setValor(y.get(i).getValor());	
		z.setSaldo((int)Saldo);
		z.setId(y.get(i).getId());
		
		Listcontabil.add(z);
		
		
		}
		
		contabil.setContabeis(Listcontabil);
		
		
		
		
		
		
		
		
		return contabil ;
	
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
