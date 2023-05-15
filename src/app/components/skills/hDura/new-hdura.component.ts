import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HDura } from 'src/app/model/hdura';
import { HDuraService } from 'src/app/service/hdura.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-new-hdura',
  templateUrl: './new-hdura.component.html',
  styleUrls: ['./new-hdura.component.css']
})
export class NewHDuraComponent implements OnInit{
  personaId: number = environment.personaId;
  nombreHD: String = "";
  porcentajeHD: String = "";

  constructor(private sHD: HDuraService, private router: Router){}

  ngOnInit(): void {
    
  }

  onCreate(): void {
    const hd = new HDura(this.personaId, this.nombreHD, this.porcentajeHD);

    console.log(hd)
    this.sHD.save(hd).subscribe(
      data => {
        alert("Habilidad añadida");
        this.router.navigate(['']);
      }, err => {
        alert("Falló");
        this.router.navigate(['']);
      }
    )
  }
}
