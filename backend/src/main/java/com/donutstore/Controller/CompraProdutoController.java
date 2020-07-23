package com.donutstore.Controller;

import java.util.List;

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
import com.donutstore.Repository.ClienteRepositoy;
import com.donutstore.Repository.CompraProdutoRepository;
import com.donutstore.Repository.CompraRepository;
import com.donutstore.Repository.DonutRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CompraProdutoController {
	
	@Autowired(required = true)
	CompraProdutoRepository cpr;
	
	@Autowired(required = true)
	CompraRepository cor;
	
	@Autowired(required = true)
	private ClienteRepositoy cr;
	
	@Autowired(required = true)
	private DonutRepository dr;
	
	@GetMapping("/getallcpr")
	public Iterable<CompraProduto> getAll(){
		return cpr.findAll();
	}
	
	@GetMapping("/getallcor")
	public List<Compra> getAllCompra(){
		return cor.findAll();
	}
	
	//ARRUMAR O METODO PARA UTILIZAR O AUTHORIZATION
	@PostMapping("/compraSave/{idCliente}/{idDonut}")
	public CompraProduto saveCompra(@PathVariable(value = "idDonut") Long idDonut,
			@PathVariable(value="idCliente") Long idCliente) {
		Cliente cliente = cr.findByIdCliente(idCliente);
		Compra compra = new Compra(cliente);
		Donut donut = dr.findByIdDonut(idDonut);	
		CompraProduto compraProduto = new CompraProduto(cliente,donut,compra);
		return cpr.save(compraProduto);
	}
	
	@PostMapping("/jsonPost")
	public CompraProduto postByJson(@RequestBody CompraProduto compraProduto) {
		return cpr.save(compraProduto);
	}
	
}
