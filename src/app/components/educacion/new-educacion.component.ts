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
      edu.urlLogoEdu = "https://img.freepik.com/fotos-premium/gorra-posgrado-negra-desplazamiento-grado-cientifico-aislado-sobre-fondo-blanco_188237-621.jpg"
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
