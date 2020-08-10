import { CartService } from './../../services/cart.service';
import { Cliente } from './../../classes/Cliente';
import { ClienteService } from './../../services/cliente.service';
import { Observable } from 'rxjs';
import { DonutService } from '../../services/donut.service';
import { Component, OnInit } from '@angular/core';
import { Donut } from 'src/app/classes/Donut';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-sabor',
  templateUrl: './donut-lista.component.html',
  styleUrls: ['./donut-lista.component.scss']
})
export class ListaDonutComponent implements OnInit {

  donuts: Observable<Donut[]>;
  donut: Observable<Donut>;
  cliente: Cliente = new Cliente();

  constructor(
    private service: DonutService,
    private clienteService: ClienteService,
    private cartService: CartService,
    private router: Router) { }

  ngOnInit() {
    this.service.refresh
      .subscribe(()=> {
        this.getDonuts();
        this.loginCheck();
      });
    this.getDonuts();

  }

  private getDonuts(){
    let resp = this.service.getAllDonuts();
    this.donuts = resp;
    
  }

  private donutsDetails(idDonut){
    this.router.navigate(['details',idDonut]);
  }

  private login(){
    let cliente = this.clienteService.login(this.cliente);
      cliente.subscribe((data)=>{
        sessionStorage.setItem('email', this.cliente.email);
        console.log(this.loginCheck());
        console.log(data);
      })
      return this.router.navigate(['donuts']);  
  }

  private logout(){
    console.log(sessionStorage.getItem('email'))
    this.clienteService.logout();
    sessionStorage.clear();
  }
  
  private loginCheck(): Boolean{
    if(sessionStorage != null)
      return sessionStorage.getItem('email') ? true : false;
  }

  private addCart(Donut:Donut){
    this.cartService.addToCart(Donut);
  }
}
