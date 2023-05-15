import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HBlanda } from '../model/hblanda';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HBlandaService {

  hblandaURL = environment.apiURL + 'habiblanda/'

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<HBlanda[]>{
    return this.httpClient.get<HBlanda[]>(this.hblandaURL + 'lista');
  }

  public detail(id: number): Observable<HBlanda>{
    return this.httpClient.get<HBlanda>(this.hblandaURL + `detail/${id}`);
  } 

  public save(hblanda: HBlanda): Observable<any>{
    return this.httpClient.post<any>(this.hblandaURL + 'create', hblanda);
  }

  public update(id: number, hblanda: HBlanda): Observable<any>{
    return this.httpClient.put<any>(this.hblandaURL + `update/${id}`, hblanda);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.hblandaURL + `delete/${id}`);
  }
}
