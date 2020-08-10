package com.donutstore.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.donutstore.Model.Cliente;
import com.donutstore.Repository.ClienteRepository;

@Repository
public class UserDetailsImpl implements UserDetailsService {
	
	public Cliente clienteStatic;
	
	@Autowired
	private ClienteRepository cr;

	@Override
	public UserDetails loadUserByUsername(String email) 
			throws UsernameNotFoundException {
		
		Cliente cliente = cr.findByEmail(email);		
		
		if(cliente == null) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		cliente.setSenha(new BCryptPasswordEncoder().encode(cliente.getSenha()));
		
		return cliente;
	}
}
