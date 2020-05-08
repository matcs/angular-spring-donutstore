import { Observable } from 'rxjs';
import { SaborService } from '../../services/sabor.service';
import { Component, OnInit } from '@angular/core';
import { Sabor } from 'src/app/classes/sabor';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-sabor',
  templateUrl: './lista-sabor.component.html',
  styleUrls: ['./lista-sabor.component.scss']
})
export class ListaSaborComponent implements OnInit {

  sabores: Observable<Sabor[]>;
  sabor: Observable<Sabor>

  constructor(private service: SaborService, private rotue: Router) { }

  ngOnInit() {

    this.service.refresh
      .subscribe(()=> {
        this.getSabores();
      });
      
    this.getSabores();
  }

  private getSabores(){
    let resp = this.service.getSabores();
    this.sabores = resp;
  }

  private saborDetails(idSabor){
    this.rotue.navigate(['details',idSabor]);
  }

  
}
