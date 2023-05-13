import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ProyectoService } from 'src/app/service/proyecto.service';

@Component({
  selector: 'app-new-proyecto',
  templateUrl: './new-proyecto.component.html',
  styleUrls: ['./new-proyecto.component.css']
})
export class NewProyectoComponent implements OnInit{

    personaId: number = 1;
    nombreProye: String = "";
    descripcionProye: String = "";
    imgUrl: String = "";
    repoUrl: String = "";

    constructor(private sProyecto: ProyectoService, private router: Router){

    }

    ngOnInit(): void {
    
    }

    onCreate(): void {
      const pro = new Proyecto(this.personaId, this.nombreProye, this.descripcionProye, this.imgUrl, this.repoUrl);
      if(pro.imgUrl == ""){
        pro.imgUrl = "https://empresas.infoempleo.com/hrtrends/media/2020/08/HRTrends-como-se-valora-un-curr%C3%ADculum.jpg"
      }
  
      this.sProyecto.save(pro).subscribe(
        data => {
          alert("Proyecto añadido");
          this.router.navigate(['']);
        }, err => {
          alert("Falló");
          this.router.navigate(['']);
        }
      )
    }
}
