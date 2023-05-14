import { Component, OnInit } from '@angular/core';
import { HDura } from 'src/app/model/hdura';
import { HDuraService } from 'src/app/service/hdura.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-h-dura',
  templateUrl: './h-dura.component.html',
  styleUrls: ['./h-dura.component.css']
})
export class HDuraComponent implements OnInit{

  hdura: HDura[] = [];

  constructor(private sHDura: HDuraService, private tokenService: TokenService){}
  
  isLogged = false;

  ngOnInit(): void {
    this.cargarHDura();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarHDura(): void {
    this.sHDura.lista().subscribe(data => { this.hdura = data; })
  }

  delete(id?: number){
    if(id != undefined){
      this.sHDura.delete(id).subscribe(
        data => {
          this.cargarHDura();
        }, err => {
          alert("No se pudo borrar la habilidad");
        }
      )
    }
  }

}
