import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { SaborService } from './../../services/sabor.service';
import { Sabor } from './../../classes/sabor';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-details-sabor',
  templateUrl: './details-sabor.component.html',
  styleUrls: ['./details-sabor.component.scss']
})
export class DetailsSaborComponent implements OnInit {

  sabor: Sabor;
  idSabor: number;

  constructor(private service: SaborService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.sabor = new Sabor();

    this.idSabor = this.route.snapshot.params['id'];

    this.service.getByIdSabor(this.idSabor)
      .subscribe(data =>{
        console.log(data)
        this.sabor = data;
      }, error => console.log(error));

  }

  updateSabor(id: number){
    this.router.navigate(['update',id])
  }

  
}
