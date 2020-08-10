import { CartService } from './../../services/cart.service';
import { ActivatedRoute } from '@angular/router';
import { Donut } from './../../classes/Donut';
import { DonutService } from './../../services/donut.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-donut-details',
  templateUrl: './donut-details.component.html',
  styleUrls: ['./donut-details.component.scss']
})
export class DonutDetailsComponent implements OnInit {

  donut: Donut = new Donut();

  constructor(
    private donutService: DonutService,
    private activatedRoute: ActivatedRoute,
    private cartService: CartService
  ) { }

  ngOnInit() {
    const id : Number = Number.parseInt(this.activatedRoute.snapshot.paramMap.get('id'))
    this.donutService.getByIdDonut(id)
      .subscribe((data =>{
        this.donut = data;    
      }));
  }

  private adicionarAoCart(donut){
    return this.cartService.addToCart(donut);        
  }

}
