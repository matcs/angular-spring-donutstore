import { Cliente } from './../../classes/Cliente';
import { ClienteService } from '../../services/cliente.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lista-clientes',
  templateUrl: './cliente-lista.component.html',
  styleUrls: ['./cliente-lista.component.scss']
})
export class ListaClientesComponent implements OnInit {

  clientes: Cliente [];

  constructor(
    private service: ClienteService
    ) { }

  ngOnInit() {
    let resp = this.service.getAllClientes();
    resp.subscribe((data)=>this.clientes=data);
  } 

}