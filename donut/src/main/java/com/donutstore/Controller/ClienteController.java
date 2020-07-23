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
import com.donutstore.Repository.ClienteRepositoy;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClienteController {
		
	@Autowired
	ClienteRepositoy cr;
	
	//PROCURA E RETORNA TODOS OS CLIENTES
	@GetMapping("/cliente")
	public List<Cliente> getAllCliente(){
		return cr.findAll();
	}
	
	//PROCURA E ENCONTRA UM CLIENTE ESPECIFICO
	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> clienteId(@PathVariable(value = "id") Long idCliente ){
		Cliente cliente = cr.findByIdCliente(idCliente);
		return ResponseEntity.ok().body(cliente);
	}
	
	//CADASTRA UM NOVO CLIENTE
	@PostMapping("salvarCliente")
	public Cliente criarCliente(@RequestBody Cliente cliente) {
		return cr.save(cliente);
	}
	
	//ATUALIZAR UM CLIENTE
	@PutMapping("/cliente/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable(value = "id") Long idCliente,
			@Valid @RequestBody Cliente clienteId){
		Cliente cliente = cr.findByIdCliente(idCliente);
		
		cliente.setNomeCliente(clienteId.getNomeCliente());
		//cliente.setEnderecoCliente(clienteId.getEnderecoCliente());
		cliente.setTelefoneCliente(clienteId.getTelefoneCliente());
		
		final Cliente updateCliente = cr.save(cliente);
		
		return ResponseEntity.ok(updateCliente);
	}
	
	//DELETAR UM CLIENTE DESEJADO
	@DeleteMapping("/cliente/{id}")
	public Map<String, Boolean> deletarCliente(@PathVariable(value = "id") Long idCliente){
		Cliente cliente = cr.findByIdCliente(idCliente);
		cr.delete(cliente);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted",true);
		return response;
		
	}
}