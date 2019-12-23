import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TrasaPunktowana } from 'src/app/model/trasaPunktowana';
import { Wycieczka } from 'src/app/model/wycieczka';

@Injectable({
  providedIn: 'root'
})
export class WycieczkaService {

  private url : string;

  constructor(private http: HttpClient) { 
    this.url = "http://localhost:8080/wycieczki";
  }

  getWycieczkaById(id) : Observable<Wycieczka>{
    return this.http.get<Wycieczka>(`${this.url}/${id}`);
  }

  setWycieczkaDone(id) : Observable<Wycieczka>{
    return this.http.get<Wycieczka>(`${this.url}/done/${id}`);
  }
}
