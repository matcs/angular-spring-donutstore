import { Sabor } from './../classes/sabor';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})

export class SaborService{

    constructor(private http: HttpClient) { }

    private _refreshm = new Subject<void>();

    get refresh(){
        return this._refreshm;
    }

    public getSabores(): Observable<Sabor[]>{
        return this.http.get<Sabor[]>('http://localhost:8080/sabores');
    }

    public getByIdSabor(idSabor: number): Observable <Sabor>{
        return this.http.get<Sabor>(`http://localhost:8080/sabor/${idSabor}`);
    }

    public saveSabor(sabor: Object): Observable<Object> {
        return this.http.post('http://localhost:8080/salvarSabor', sabor)
        .pipe(
            tap(() => {
                this._refreshm.next();
            })
        ) 
    }

    public updateSabor(idSabor: number, value: any): Observable<Object>{
        return this.http.put(`http://localhost:8080/sabor/${idSabor}`, value)
        .pipe(
            tap(()=>{
                this._refreshm.next();
            })
        );
    }

    public deleteSabor(idSabor: number): Observable <Object>{
        return this.http.delete(`http://localhost:8080/sabor/${idSabor}`, { responseType: 'text' })
        .pipe(
            tap(() => {
                this._refreshm.next();
            })
        )
    }
    



}