import { Component, OnInit } from '@angular/core';
import { HBlanda } from 'src/app/model/hblanda';
import { HBlandaService } from 'src/app/service/hblanda.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-h-blanda',
  templateUrl: './h-blanda.component.html',
  styleUrls: ['./h-blanda.component.css']
})
export class HBlandaComponent implements OnInit{

  hblanda: HBlanda[] = [];

  constructor(private sHBlanda: HBlandaService, private tokenService: TokenService){}
  
  isLogged = false;

  ngOnInit(): void {
    this.cargarHBlanda();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarHBlanda(): void {
    this.sHBlanda.lista().subscribe(data => { this.hblanda = data; })
  }

  delete(id?: number){
    if(id != undefined){
      this.sHBlanda.delete(id).subscribe(
        data => {
          this.cargarHBlanda();
        }, err => {
          alert("No se pudo borrar la habilidad");
        }
      )
    }
  }

}
