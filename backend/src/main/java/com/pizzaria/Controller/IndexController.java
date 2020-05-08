package com.pizzaria.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaria.Model.Cliente;
import com.pizzaria.Model.Sabor;
import com.pizzaria.Repository.ClienteRepositoy;
import com.pizzaria.Repository.SaborRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class IndexController {
	
	@Autowired(required = true)
	SaborRepository sr;	
	
	@Autowired(required = true)
	ClienteRepositoy cr;
	
	
	//PROCURA TODOS OS SABORES
	@GetMapping("/sabores")
	public List<Sabor> getAllSabores() {
		return sr.findAll();
	}
	
	//PROCURA UM SABOR EM ESPECIFICO
	@GetMapping("/sabor/{id}")
	public ResponseEntity<Sabor> findSaborById(@PathVariable(value = "id") Long idSabor){
		Sabor sabor = sr.findByIdSabor(idSabor);
		return ResponseEntity.ok().body(sabor);
	}
	
	//REMOVER PARA UMA PARTE PRÓPRIA
	@GetMapping("/clientes")
	public List<Cliente> getAllClientes() {
		return cr.findAll();
	}
	
	//CRIA UM NOVO SABOR
	@PostMapping("/salvarSabor")
	public Sabor criarSabor(@RequestBody Sabor sabor) {
		return sr.save(sabor);
	}
	
	//ATUALIZA SABOR
	@PutMapping("/sabor/{id}")
	public ResponseEntity<Sabor> updateSabor(@PathVariable(value = "id") Long idSabor,
			@Valid @RequestBody Sabor findSaborById){
		Sabor sabor = sr.findByIdSabor(idSabor);
		
		sabor.setNomeSabor(findSaborById.getNomeSabor());
		sabor.setPreco(findSaborById.getPreco());
	
		final Sabor updateSabor = sr.save(sabor);
		
		return ResponseEntity.ok(updateSabor);
	}
	
	
	//DELETA UM SABOR DESEJADO
	@DeleteMapping("/sabor/{id}")
	public Map<String, Boolean> deletarSabor(@PathVariable(value = "id") Long idSabor) {
		Sabor sabor = sr.findByIdSabor(idSabor);
		sr.delete(sabor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
	
	
	
//	@RequestMapping("/{idCliente}")
//	public ModelAndView pedidoFazer (@PathVariable("idCliente") long idCliente) {
//		Cliente cliente = cr.findByIdCliente(idCliente);
//		ModelAndView mv = new ModelAndView("pages/pedidos");
//		mv.addObject("cliente",cliente);
//		
//		//ENCONTRAR SABORES 
//		Iterable<Sabor> sabor = sr.findAll();
//		mv.addObject("sabor",sabor);
//		
//		return mv;
//	}
//	
}
