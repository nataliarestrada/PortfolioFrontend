import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ProyectoService } from 'src/app/service/proyecto.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-new-proyecto',
  templateUrl: './new-proyecto.component.html',
  styleUrls: ['./new-proyecto.component.css']
})
export class NewProyectoComponent implements OnInit{

    personaId: number = environment.personaId;
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
        pro.imgUrl = "https://website-assets-fs.freshworks.com/attachments/ckbsryqms00q2heg19ekuza1r-it-product-management0.one-half.png"
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
