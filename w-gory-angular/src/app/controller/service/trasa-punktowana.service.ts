import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { TrasaPunktowana } from 'src/app/model/trasaPunktowana';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TrasaPunktowanaService {
  private url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/trasy-punktowane";
  }

  addTrasaPunkt(trasaPunkt: TrasaPunktowana): Observable<TrasaPunktowana> {
    return this.http.post<TrasaPunktowana>(`${this.url}/addTrasaPunkt`, trasaPunkt);
  }
}
