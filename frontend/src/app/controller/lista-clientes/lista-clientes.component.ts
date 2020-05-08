import { clienteService } from '../../services/cliente.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lista-clientes',
  templateUrl: './lista-clientes.component.html',
  styleUrls: ['./lista-clientes.component.scss']
})
export class ListaClientesComponent implements OnInit {

  clientes:any;

  constructor(private service: clienteService) { }

  ngOnInit() {
    let resp = this.service.getClientes();
    resp.subscribe((data)=>this.clientes=data);
  }

}
