import { ListaDonutComponent } from './controller/donut-lista/donut-lista.component';
import { DonutDetailsComponent } from './controller/donut-details/donut-details.component';
import { ListaClientesComponent } from './controller/cliente-lista/cliente-lista.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { DonutCadastroComponent } from './controller/donut-cadastro/donut-cadastro.component';
import { LoginRegisterComponent } from './controller/login-register/login-register.component';
import { HomeComponent } from './controller/home/home.component';
import { CartComponent } from './controller/cart/cart.component';

@NgModule({
  declarations: [
    AppComponent,
    ListaDonutComponent,
    ListaClientesComponent,
    DonutCadastroComponent,
    DonutDetailsComponent,
    LoginRegisterComponent,
    HomeComponent,
    CartComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
