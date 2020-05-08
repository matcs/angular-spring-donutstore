import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { Sabor } from './../../classes/sabor';
import { SaborService } from './../../services/sabor.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cadastro-sabor',
  templateUrl: './cadastro-sabor.component.html',
  styleUrls: ['./cadastro-sabor.component.scss']
})
export class CadastroSaborComponent implements OnInit {

  sabores: Observable<Sabor[]>;

  constructor(private service: SaborService, 
      private route:Router ) { }

  sabor: Sabor = new Sabor();
  submitted = false;

  ngOnInit() {
    this.service.refresh
      .subscribe(()=> {
        this.getSabores();
      });

    this.getSabores();
  }

    private newSabor():void{
    this.submitted=false;
    this.sabor=new Sabor();
    }

    private save(){
    this.service.saveSabor(this.sabor)
      .subscribe(data => console.log(data), error => console.log(error));
      this.sabor = new Sabor();
    }

    private getSabores(){
      let resp = this.service.getSabores();
      this.sabores = resp;
    }

    private deleteSabor(idSabor){
      this.service.deleteSabor(idSabor)
        .subscribe (
          data => { 
            console.log(data);
          },
          error => console.log(error));
    }

    onSubmit(){
      this.submitted=true;
      this.save();
    }
}
