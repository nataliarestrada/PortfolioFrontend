import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia.component';
import { NewEducacionComponent } from './components/educacion/new-educacion.component';
import { EditEducacionComponent } from './components/educacion/edit-educacion.component';
import { NewProyectoComponent } from './components/proyectos/new-proyecto.component';
import { EditProyectoComponent } from './components/proyectos/edit-proyecto.component';
import { NewHBlandaComponent } from './components/skills/hBlanda/new-hblanda/new-hblanda.component';
import { EditHBlandaComponent } from './components/skills/hBlanda/edit-hblanda/edit-hblanda.component';
import { NewHDuraComponent } from './components/skills/hDura/new-hdura.component';
import { EditHDuraComponent } from './components/skills/hDura/edit-hdura.component';
import { EditAcercaDeComponent } from './components/acerca-de/edit-acerca-de.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'editar/:id', component: EditAcercaDeComponent},
  {path:'nuevaexp', component: NewExperienciaComponent},
  {path:'editexp/:id', component: EditExperienciaComponent},
  {path:'nuevaedu', component: NewEducacionComponent},
  {path:'editedu/:id', component: EditEducacionComponent},
  {path:'nuevopro', component: NewProyectoComponent},
  {path:'editpro/:id', component: EditProyectoComponent},
  {path:'nuevahb', component: NewHBlandaComponent},
  {path:'edithb/:id', component: EditHBlandaComponent},
  {path:'nuevahd', component: NewHDuraComponent},
  {path:'edithd/:id', component: EditHDuraComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
