import { UpdateSaborComponent } from './controller/update-sabor/update-sabor.component';
import { DetailsSaborComponent } from './controller/details-sabor/details-sabor.component';
import { CadastroSaborComponent } from './controller/cadastro-sabor/cadastro-sabor.component';
import { ListaClientesComponent } from './controller/lista-clientes/lista-clientes.component';
import { ListaSaborComponent } from './controller/lista-sabor/lista-sabor.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [  
  {path: 'sabores', component: ListaSaborComponent},
  {path: 'clientes', component: ListaClientesComponent},
  {path: 'registerSabor', component: CadastroSaborComponent},
  {path: 'details/:id', component: DetailsSaborComponent },
  {path: 'update/:id', component: UpdateSaborComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
