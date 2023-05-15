import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacion.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-new-educacion',
  templateUrl: './new-educacion.component.html',
  styleUrls: ['./new-educacion.component.css']
})
export class NewEducacionComponent implements OnInit{
  
  personaId: number = environment.personaId;
  tituloEdu: String = "";
  periodoEdu: String = "";
  institucionEdu: String = "";
  descripcionEdu: String = "";
  urlLogoEdu: String = "";

  constructor(private sEducacion: EducacionService, private router: Router){}

  ngOnInit(): void {
    
  }

  onCreate(): void {
    const edu = new Educacion(this.personaId, this.tituloEdu, this.periodoEdu, this.institucionEdu, this.descripcionEdu, this.urlLogoEdu);
    if(edu.urlLogoEdu == ""){
      edu.urlLogoEdu = "https://empresas.infoempleo.com/hrtrends/media/2020/08/HRTrends-como-se-valora-un-curr%C3%ADculum.jpg"
    }

    this.sEducacion.save(edu).subscribe(
      data => {
        alert("Educacion añadida");
        this.router.navigate(['']);
      }, err => {
        alert("Falló");
        this.router.navigate(['']);
      }
    )
  }



}
