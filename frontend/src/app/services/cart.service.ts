import { Router } from '@angular/router';
import { Cliente } from 'src/app/classes/Cliente';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Donut } from '../classes/Donut';
import { Subject } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class CartService {
  items = [];

  cliente: Cliente = new Cliente();
  donut: Donut = new Donut();
  constructor(
    private http: HttpClient
    ) { }
    
    private _refreshm = new Subject<void>();

    get refresh(){
        return this._refreshm;
    }

  addToCart(product) {
    localStorage.setItem('cart',JSON.stringify(this.items.push(product)));
  }

  removeItem(){
      this.items.pop();
  }

  getItems() {
    return this.items;
  }

  clearCart() {
    localStorage.setItem('cart','');
    this.items = [];
    return ;
  }

  finishShop(){
    this.cliente = JSON.parse(localStorage.getItem('clienteBody'));
    const donut = this.getItems();
    return this.http.post(`http://localhost:8080/compraSave/${this.cliente.idCliente}`,donut)
      .subscribe((data) => {
        console.log(data);
          this._refreshm.next();
    })
  }
}