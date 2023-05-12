import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { SExperienciaService } from 'src/app/service/s-experiencia.service';

@Component({
  selector: 'app-new-experiencia',
  templateUrl: './new-experiencia.component.html',
  styleUrls: ['./new-experiencia.component.css']
})
export class NewExperienciaComponent implements OnInit{
  
  personaId: number = 1;
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
      expe.urlLogoExpe = "https://empresas.infoempleo.com/hrtrends/media/2020/08/HRTrends-como-se-valora-un-curr%C3%ADculum.jpg"
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
