package com.pizzaria.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pizzaria.Model.Cliente;
import com.pizzaria.Model.Sabor;
import com.pizzaria.Repository.ClienteRepositoy;
import com.pizzaria.Repository.PedidoRepository;
import com.pizzaria.Repository.SaborRepository;

@Controller
public class IndexController {
	
	@Autowired(required = true)
	SaborRepository sr;
	
	@Autowired(required = true)
	ClienteRepositoy cr;
	
	@Autowired(required = true)
	PedidoRepository pr;
	
	
	@RequestMapping("/")
	public ModelAndView sabores() {
		ModelAndView mv = new ModelAndView("/pages/index");
		Iterable<Sabor> sabor = sr.findAll();
		mv.addObject("sabor",sabor);
		return mv;
	}
	
	@RequestMapping("/clientes")
	public ModelAndView clientes() {
		ModelAndView mv = new ModelAndView("/pages/clientes");
		Iterable<Cliente> cliente = cr.findAll();
		mv.addObject("cliente",cliente);
		return mv;
	}
	
	@RequestMapping("/{idCliente}")
	public ModelAndView pedidoFazer (@PathVariable("idCliente") long idCliente) {
		Cliente cliente = cr.findByIdCliente(idCliente);
		ModelAndView mv = new ModelAndView("pages/pedidos");
		mv.addObject("cliente",cliente);
		
		//ENCONTRAR SABORES 
		Iterable<Sabor> sabor = sr.findAll();
		mv.addObject("sabor",sabor);
		
		return mv;
	}
	
}
