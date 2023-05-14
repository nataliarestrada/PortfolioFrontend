import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HBlanda } from 'src/app/model/hblanda';
import { HBlandaService } from 'src/app/service/hblanda.service';

@Component({
  selector: 'app-new-hblanda',
  templateUrl: './new-hblanda.component.html',
  styleUrls: ['./new-hblanda.component.css']
})
export class NewHBlandaComponent implements OnInit{
  personaId: number = 1;
  nombreHB: String = "";
  porcentajeHB: String = "";

  constructor(private sHB: HBlandaService, private router: Router){}

  ngOnInit(): void {
    
  }

  onCreate(): void {
    const hb = new HBlanda(this.personaId, this.nombreHB, this.porcentajeHB);

    console.log(hb)
    this.sHB.save(hb).subscribe(
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
