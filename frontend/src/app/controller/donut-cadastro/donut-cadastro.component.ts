import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { Donut } from '../../classes/Donut';
import { DonutService } from '../../services/donut.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cadastro-sabor',
  templateUrl: './donut-cadastro.component.html',
  styleUrls: ['./donut-cadastro.component.scss']
})
export class DonutCadastroComponent implements OnInit {

  donuts: Observable<Donut[]>;

  constructor(private service: DonutService,
      private route:Router ) { }

  donut: Donut = new Donut();
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
      this.donut=new Donut();
    }

    private save(){
      this.service.saveDonut(this.donut)
        .subscribe(data => console.log(data), error => console.log(error));
        this.donut = new Donut();
    }

    private getSabores(){
      let resp = this.service.getAllDonuts();
      this.donuts = resp;
    }

    private deleteSabor(idDonut){
      this.service.deleteDonut(idDonut)
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
