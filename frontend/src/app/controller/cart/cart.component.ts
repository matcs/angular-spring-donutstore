import { Cliente } from 'src/app/classes/Cliente';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';
import { Donut } from 'src/app/classes/Donut';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  items;
  cartItems:Number;
  cliente: Cliente = new Cliente();
  donut: Donut = new Donut();

  constructor(
    private cartService: CartService,
    private router:Router
  ) { }

  ngOnInit() {
    this.items = this.cartService.getItems();
    this.cartItems = this.cartTotal();
    console.log(this.getAllItensId());
  }

  private cartTotal(){
    return this.items.length;
  }

  private removeItem(){
    return this.cartService.removeItem();
  }

  private valorTotal(){
    let sum: Number = 0;
    this.items.forEach(element => sum += element.preco);
    return sum.toFixed(2);
  }

  private loginCheck(): Boolean{
    return sessionStorage.getItem('email') ? true : false;
  }

  private toLoginOrRegister(){
    return this.router.navigate(['loginoregister']);
  }

  private getClienteBody(){
    return JSON.parse(localStorage.getItem('clienteBody'));
  }

  private getAllItensId(){
    const ids = this.items.map(donut => donut.idDonut);
    return ids;
  }

  private finalizarCompra(){
    this.cartService.finishShop();
    this.cartService.clearCart();        
    return this.router.navigate(['']);
  }

}
