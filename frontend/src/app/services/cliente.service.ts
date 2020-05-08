import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})

export class clienteService{

    constructor(private http:HttpClient) { }

    public getClientes(){
        return this.http.get('http://localhost:8080/clientes');
    }

}