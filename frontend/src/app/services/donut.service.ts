import { Donut } from '../classes/Donut';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { tap } from 'rxjs/operators';


@Injectable({
    providedIn: 'root'
})

export class DonutService{

    constructor(private http: HttpClient) { }

    private _refreshm = new Subject<void>();

    get refresh(){
        return this._refreshm;
    }

    public getAllDonuts(): Observable<Donut[]>{
        return this.http.get<Donut[]>('http://localhost:8080/donuts');
    }

    public getByIdDonut(idDonut): Observable <Donut>{
        return this.http.get<Donut>(`http://localhost:8080/donuts/${idDonut}`);
    }

    public saveDonut(donut: Object): Observable<Object> {
        return this.http.post('http://localhost:8080/donuts', donut)
        .pipe(
            tap(() => {
                this._refreshm.next();
            })
        ) 
    }

    public updateDonut(idDonut: number, value: any): Observable<Object>{
        return this.http.put(`http://localhost:8080/donuts/${idDonut}`, value)
        .pipe(
            tap(()=>{
                this._refreshm.next();
            })
        );
    }

    public deleteDonut(idDonut: number): Observable <Object>{
        return this.http.delete(`http://localhost:8080/donuts/${idDonut}`, { responseType: 'text' })
        .pipe(
            tap(() => {
                this._refreshm.next();
            })
        )
    }
    
}