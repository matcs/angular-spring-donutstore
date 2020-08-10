import { ListaDonutComponent } from './controller/donut-lista/donut-lista.component';
import { HomeComponent } from './controller/home/home.component';
import { CartComponent } from './controller/cart/cart.component';
import { LoginRegisterComponent } from './controller/login-register/login-register.component';
import { DonutDetailsComponent } from './controller/donut-details/donut-details.component'
import { DonutCadastroComponent } from './controller/donut-cadastro/donut-cadastro.component';
import { ListaClientesComponent } from './controller/cliente-lista/cliente-lista.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [  
  {path:'home', component: HomeComponent},
  {path:'', redirectTo: 'home', pathMatch: 'full' },
  {path: 'donuts', component: ListaDonutComponent},
  {path: 'cart', component: CartComponent},
  {path: 'clientes', component: ListaClientesComponent},
  {path: 'registerSabor', component: DonutCadastroComponent},
  {path: 'details/:id', component: DonutDetailsComponent },
  {path: 'loginoregister', component: LoginRegisterComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
