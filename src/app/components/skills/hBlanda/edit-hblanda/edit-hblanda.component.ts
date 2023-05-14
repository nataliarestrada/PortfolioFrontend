import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HBlanda } from 'src/app/model/hblanda';
import { HBlandaService } from 'src/app/service/hblanda.service';

@Component({
  selector: 'app-edit-hblanda',
  templateUrl: './edit-hblanda.component.html',
  styleUrls: ['./edit-hblanda.component.css']
})
export class EditHBlandaComponent implements OnInit{
  hblanda : HBlanda = null;

  constructor(private sHB: HBlandaService, private activatedRouter: ActivatedRoute
    ,private router: Router){}

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sHB.detail(id).subscribe(
      data =>{
        this.hblanda = data;
      }, err =>{
        alert("Error al modificar");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.sHB.update(id, this.hblanda).subscribe(
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
