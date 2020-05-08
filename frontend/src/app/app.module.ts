import { SaborService } from './services/sabor.service';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaSaborComponent } from './controller/lista-sabor/lista-sabor.component';
import { ListaClientesComponent } from './controller/lista-clientes/lista-clientes.component';
import { FormsModule } from '@angular/forms';
import { CadastroSaborComponent } from './controller/cadastro-sabor/cadastro-sabor.component'
import { Observable } from 'rxjs';
import { DetailsSaborComponent } from './controller/details-sabor/details-sabor.component';
import { UpdateSaborComponent } from './controller/update-sabor/update-sabor.component'

@NgModule({
  declarations: [
    AppComponent,
    ListaSaborComponent,
    ListaClientesComponent,
    CadastroSaborComponent,
    DetailsSaborComponent,
    UpdateSaborComponent,
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
