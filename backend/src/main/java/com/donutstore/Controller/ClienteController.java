package com.donutstore.Controller;

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

import com.donutstore.Model.Cliente;
import com.donutstore.Repository.ClienteRepository;

@CrossOrigin(origins = "*")
@RestController
public class ClienteController {
	
	@Autowired(required = true)
	private ClienteRepository cr;
	
	//PROCURA E RETORNA TODOS OS CLIENTES
	@GetMapping("/cliente")
	public List<Cliente> getAllCliente(){
		return cr.findAll();
	}
	
	//PROCURA E ENCONTRA UM CLIENTE ESPECIFICO
	@PostMapping("/cliente/login")
	public ResponseEntity<Cliente> loginCliente(
			@RequestBody Cliente clienteBody){
		Cliente cliente = cr.findByEmail(clienteBody.getEmail());
		if(cliente.getSenha().equals(clienteBody.getSenha())) {
			return ResponseEntity.ok().body(cliente);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	//CADASTRA UM NOVO CLIENTE
	@PostMapping("/cliente")
	public Cliente criarCliente(
			@RequestBody Cliente cliente) {
		return cr.save(cliente);
	}
	
	//ATUALIZAR UM CLIENTE
	@PutMapping("/cliente/{idCliente}")
	public ResponseEntity<Cliente> updateCliente(
			@PathVariable(value = "idCliente") Long idCliente,
			@Valid @RequestBody Cliente clienteId){ 
		Cliente cliente = cr.findByIdCliente(idCliente);
	  
		cliente.setNomeCliente(clienteId.getNomeCliente());
		cliente.setBairro(clienteId.getBairro());
		cliente.setCidade(clienteId.getCidade());
		cliente.setEmail(clienteId.getEmail());
		cliente.setEstado(clienteId.getEstado());
		cliente.setLogradouro(clienteId.getLogradouro());
		cliente.setRua(clienteId.getRua()); cliente.setSenha(clienteId.getSenha());
		cliente.setTelefoneCliente(clienteId.getTelefoneCliente());
		  
		final Cliente updateCliente = cr.save(cliente);
	  
	  return ResponseEntity.ok(updateCliente); 
	}
 
	
	//DELETAR UM CLIENTE DESEJADO
	@DeleteMapping("/cliente/{idCliente}") public Map<String, Boolean>deletarCliente(
			@PathVariable(value = "idCliente") Long idCliente){ 
		Cliente cliente = cr.findByIdCliente(idCliente);
		cr.delete(cliente);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted",true); 
		
		return response;
	}
	 
}