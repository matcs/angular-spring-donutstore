import { CartService } from './services/cart.service';
import { Component, OnInit } from '@angular/core';
import { ClienteService } from './services/cliente.service';
import { Router } from '@angular/router';
import { Cliente } from './classes/Cliente';
import { Donut } from './classes/Donut';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  
  items;
  cartItems: Number;

  cliente: Cliente = new Cliente();
  donut: Donut = new Donut();

  ngOnInit(): void {
    this.items = this.cartService.getItems();
  }

  constructor(
    private clienteService: ClienteService,
    private cartService: CartService,
    private router: Router
    ){}
  
  title = 'Donut Store';

  private loginCheck(): Boolean{
    return sessionStorage.getItem('email') ? true : false;
  }

  private getNomeCLiente(): String{
    return sessionStorage.getItem('cliente');
  }

  private logout(){
    console.log(sessionStorage.getItem('email'))
    this.clienteService.logout();
    sessionStorage.clear();
    return this.router.navigate(['/'])
  }
}
