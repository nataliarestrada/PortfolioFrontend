import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HDura } from 'src/app/model/hdura';
import { HDuraService } from 'src/app/service/hdura.service';

@Component({
  selector: 'app-edit-hdura',
  templateUrl: './edit-hdura.component.html',
  styleUrls: ['./edit-hdura.component.css']
})
export class EditHDuraComponent implements OnInit{
  hdura : HDura = null;

  constructor(private sHD: HDuraService, private activatedRouter: ActivatedRoute
    ,private router: Router){}

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sHD.detail(id).subscribe(
      data =>{
        this.hdura = data;
      }, err =>{
        alert("Error al modificar");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.sHD.update(id, this.hdura).subscribe(
      data => {
        alert("Habilidad modificada");
        this.router.navigate(['']);
      }, err =>{
         alert("Error al modificar habilidad");
         this.router.navigate(['']);
      }
    )
  }

}
