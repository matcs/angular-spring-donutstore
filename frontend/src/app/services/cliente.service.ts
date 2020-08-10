import { Cliente } from './../classes/Cliente';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})

export class ClienteService{

    public cleinte : Cliente;

    public USER_NAME_AUTH : string;

    constructor(private http:HttpClient) { }

    public getAllClientes(): Observable<Cliente[]>{
        return this.http.get<Cliente[]>(`http://localhost:8080/cliente`);
    }

    createCliente(cliente: Cliente): Observable<Cliente>{
        return this.http.post<Cliente>(`http://localhost:8080/cliente`,cliente);
    }

    public login(cliente:Cliente): Observable<Cliente>{
        return this.http.post<Cliente>(`http://localhost:8080/cliente/login`,cliente,
            {headers: {Authorization: this.creteBasicAuthToken(cliente.email, cliente.senha)}})
            .pipe(catchError(this.handleError));
    }

    public creteBasicAuthToken(email:string, senha:string){
        return 'Basic ' + btoa(email+':'+senha);
    }

    public handleError (error: HttpErrorResponse){
        console.log('error ao fazer login');
        return throwError(error);
    }

    public logout(){
        return this.http.get(`http://localhost:8080/logout`);
    }
}