import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../model/Persona.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class PersonaService {
  URL = environment.apiURL + 'personas';
  httpClient: any;

  constructor(private http: HttpClient) { }

  public getPersona(): Observable<persona>{
    return this.http.get<persona>(this.URL+'/detail/'+environment.personaId)
  }

  public update(id: number, persona: persona): Observable<any>{
    return this.http.put<any>(this.URL + `/update/${id}`, persona);
  }
}
