package com.donutstore.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.donutstore.Model.Cliente;
import com.donutstore.Model.Compra;
import com.donutstore.Model.CompraProduto;
import com.donutstore.Model.Donut;
import com.donutstore.Repository.ClienteRepository;
import com.donutstore.Repository.CompraProdutoRepository;
import com.donutstore.Repository.DonutRepository;

@CrossOrigin(origins = "*")
@RestController
public class CompraProdutoController {
	
	@Autowired(required = true)
	private CompraProdutoRepository cpr;
	
	@Autowired(required = true)
	private DonutRepository dr;
	
	@Autowired(required = true)
	private ClienteRepository cr;
	
	@GetMapping("/getallcpr")
	public Iterable<CompraProduto> getAll(){
		return cpr.findAll();
	}
	
	
	@PostMapping("/compraSave/{idCliente}")
	@Transactional
	public List<CompraProduto> saveCompra(
			@RequestBody List<Donut> listDonut,
			@PathVariable (value = "idCliente") Long idCliente) {
		
		System.out.println("FUÇÃO COMPRAS OK");
		
		Cliente cliente = cr.findByIdCliente(idCliente); 
		Compra compra = new Compra(cliente);
		
		List<CompraProduto>compras = new ArrayList<>();
		
		
		for(Donut DonutId : listDonut) {
			Donut donut = dr.findByIdDonut(DonutId.getIdDonut());
			CompraProduto compraProduto = new CompraProduto(cliente,donut,compra);
			compras.add(cpr.save(compraProduto));
		}
		
		return compras;
	}
	
}
