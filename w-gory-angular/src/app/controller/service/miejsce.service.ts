import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Miejsce } from 'src/app/model/miejsce';

@Injectable({
  providedIn: 'root'
})
export class MiejsceService {
  private url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/miejsca";
  }

  getAllMiejsca(): Observable<Miejsce[]> {
    return this.http.get<Miejsce[]>(`${this.url}/`);
  }
}
