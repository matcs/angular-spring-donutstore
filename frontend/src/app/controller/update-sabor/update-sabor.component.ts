import { Router, ActivatedRoute } from '@angular/router';
import { SaborService } from './../../services/sabor.service';
import { Sabor } from './../../classes/sabor';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-update-sabor',
  templateUrl: './update-sabor.component.html',
  styleUrls: ['./update-sabor.component.scss']
})
export class UpdateSaborComponent implements OnInit {

  id: number;
  sabor: Sabor;

  constructor(private service: SaborService, private router:Router,
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.sabor = new Sabor();

    this.id = this.route.snapshot.params['id'];

    this.service.getByIdSabor(this.id)
      .subscribe(data => {
        console.log(data);
        this.sabor = data;
    }, error => console.log(error))
  }

  updateSabor(){
    this.service.updateSabor(this.id, this.sabor)
      .subscribe(data => console.log(data), error => console.log(error));
      this.sabor = new Sabor();
  }

  onSubmit(){
    this.updateSabor();
    this.goToList();
  }

  goToList(){
    this.router.navigate(['sabores']);
  }
}
