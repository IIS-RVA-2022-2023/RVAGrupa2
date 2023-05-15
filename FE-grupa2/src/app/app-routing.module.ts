import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArtiklComponent } from './components/artikl/artikl.component';
import { DobavljacComponent } from './components/dobavljac/dobavljac.component';

const routes: Routes =  [ { path: 'artikl', component: ArtiklComponent },   
{ path: 'dobavljac', component: DobavljacComponent },/*
{ path: 'porudzbina', component: PorudzbinaComponent },
{ path: 'home', component: HomeComponent },
{ path: 'about', component: AboutComponent },
{ path: 'author', component: AuthorComponent },*/
{ path: '', redirectTo: '/artikl', pathMatch: 'full'}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
