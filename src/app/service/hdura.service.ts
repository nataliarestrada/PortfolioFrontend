import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HDura } from '../model/hdura';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HDuraService {

  hduraURL = environment.apiURL + 'habidura/'

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<HDura[]>{
    return this.httpClient.get<HDura[]>(this.hduraURL + 'lista');
  }

  public detail(id: number): Observable<HDura>{
    return this.httpClient.get<HDura>(this.hduraURL + `detail/${id}`);
  } 

  public save(hdura: HDura): Observable<any>{
    return this.httpClient.post<any>(this.hduraURL + 'create', hdura);
  }

  public update(id: number, hdura: HDura): Observable<any>{
    return this.httpClient.put<any>(this.hduraURL + `update/${id}`, hdura);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.hduraURL + `delete/${id}`);
  }
}
