import { Component, OnInit } from '@angular/core';

interface Proyecto {
  nombre: string;
  fecha: string;
  descripcion: string;
  imagen: string;
  link: string;
}
@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit{
  proyectos: Proyecto[] = [
    {
      nombre: 'Proyecto 1',
      fecha: 'Enero 2022',
      descripcion: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
      imagen: '#',
      link: 'link/a/la/evidencia'
    },
    {
      nombre: 'Proyecto 2',
      fecha: 'Febrero 2022',
      descripcion: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
      imagen: '#',
      link: 'link/a/la/evidencia'
    },
    // Agregar más proyectos aquí
  ];
  
  ngOnInit(): void {
    //throw new Error('Method not implemented.');
  }

 
}
