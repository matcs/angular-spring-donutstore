import { Router } from '@angular/router';
import { ClienteService } from './../../services/cliente.service';
import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/classes/Cliente';

@Component({
  selector: 'app-login-register',
  templateUrl: './login-register.component.html',
  styleUrls: ['./login-register.component.scss']
})
export class LoginRegisterComponent implements OnInit {
  
  cliente: Cliente = new Cliente();

  clienteRegister: Cliente = new Cliente();

  constructor(
    private clienteService:ClienteService,
    private router: Router) { }

  ngOnInit() {
    
  }

  private login(){
    let cliente = this.clienteService.login(this.cliente);
      cliente.subscribe((data)=>{
        sessionStorage.setItem('email', this.cliente.email);
        sessionStorage.setItem('cliente',data.nomeCliente);
        console.log(this.loginCheck());
        console.log(data);
        localStorage.setItem('clienteBody',JSON.stringify(data));
        
        return this.router.navigate(['donuts'])
      })  
  }

  private loginCheck(): Boolean{
    return sessionStorage.getItem('email') ? true : false;
  }

  private register(){
   return this.clienteService.createCliente(this.clienteRegister)
      .subscribe((data) => {
        this.cliente = data;
        this.login();
      })
  }
}
