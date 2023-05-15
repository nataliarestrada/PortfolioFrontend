import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { SExperienciaService } from 'src/app/service/s-experiencia.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-new-experiencia',
  templateUrl: './new-experiencia.component.html',
  styleUrls: ['./new-experiencia.component.css']
})
export class NewExperienciaComponent implements OnInit{
  
  personaId: number = environment.personaId;
  puestoExpe: String = "";
  periodoExpe: String = "";
  organismoExpe: String = "";
  descripcionExpe: String = "";
  urlLogoExpe: String = "";

  constructor(private sExperiencia: SExperienciaService, private router: Router) { }

  ngOnInit(): void {
    
  }

  onCreate(): void {
    const expe = new Experiencia(this.personaId, this.puestoExpe, this.periodoExpe, this.organismoExpe, this.descripcionExpe, this.urlLogoExpe);
    if(expe.urlLogoExpe == ""){
      expe.urlLogoExpe = "https://i0.wp.com/talentocool.com/wp-content/uploads/2020/12/redactar-un-cv-para-programacion-1024x682.jpg"
    }

    this.sExperiencia.save(expe).subscribe(
      data => {
        alert("Experiencia añadida");
        this.router.navigate(['']);
      }, err => {
        alert("Falló");
        this.router.navigate(['']);
      }
    )
  }

}
