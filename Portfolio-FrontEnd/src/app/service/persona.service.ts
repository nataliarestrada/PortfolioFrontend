import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../model/Persona.model';

@Injectable({
  providedIn: 'root'
})

export class PersonaService {
  URL = 'http://localhost:8080/personas';
  httpClient: any;

  constructor(private http: HttpClient) { }

  public getPersona(): Observable<persona>{
    return this.http.get<persona>(this.URL+'/detail/1')
  }

  public update(id: number, persona: persona): Observable<any>{
    return this.http.put<any>(this.URL + `/update/${id}`, persona);
  }
}
