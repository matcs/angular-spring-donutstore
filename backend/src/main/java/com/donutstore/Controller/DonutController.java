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

import com.donutstore.Model.Donut;
import com.donutstore.Repository.DonutRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DonutController {
	
	@Autowired(required = true)
	private DonutRepository dr;
	
	//PROCURA E RETORNA TODOS OS SABORES
	@GetMapping("/donuts")
	public List<Donut> getAllDonut() {
		return dr.findAll();
	}
	
	//PROCURA UM SABOR EM ESPECIFICO
	@GetMapping("/donuts/{id}")
	public ResponseEntity<Donut> findDonuById(
			@PathVariable(value = "id") Long idDonut){
		Donut donut = dr.findByIdDonut(idDonut);
		return ResponseEntity.ok().body(donut);
	}
	
	//CRIA UM NOVO SABOR
	@PostMapping("/donuts")
	public Donut criarDonut(
			@RequestBody Donut sabor) {
		return dr.save(sabor);
	}
	
	//ATUALIZA SABOR
	@PutMapping("/donuts/{id}")
	public ResponseEntity<Donut> updateDonut(
			@PathVariable(value = "id") Long idDonut,
			@Valid @RequestBody Donut findDonutById){
		Donut sabor = dr.findByIdDonut(idDonut);
		
		sabor.setNomeSabor(findDonutById.getNomeSabor());
		sabor.setPreco(findDonutById.getPreco());
	
		final Donut updateSabor = dr.save(sabor);
		
		return ResponseEntity.ok(updateSabor);
	}
	
	//DELETA UM SABOR DESEJADO
	@DeleteMapping("/donuts/{id}")
	public Map<String, Boolean> deletarDonut(
			@PathVariable(value = "id") Long idDonut) {
		Donut sabor = dr.findByIdDonut(idDonut);
		dr.delete(sabor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
	
}