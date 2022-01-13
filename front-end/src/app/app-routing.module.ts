import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { RegcountriesComponent } from './components/regcountries/regcountries.component';
import { NavhorizontalComponent } from './components/navhorizontal/navhorizontal.component';
import { NavverticalComponent } from './components/navvertical/navvertical.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { ListcountriesComponent } from './components/listcountries/listcountries.component';
import { TituloComponent } from './components/titulo/titulo.component';
import { AboutComponent } from './components/about/about.component';
import { WorkComponent } from './components/work/work.component';
import {ListprovinciesComponent} from './components/listprovincies/listprovincies.component';


const routes: Routes = [
    {path : 'Login', component:LoginComponent},
    {path : 'Register', component:RegisterComponent},
    {path : 'NavHorizontal', component:NavhorizontalComponent},
    { path : 'NavVertical', component:NavverticalComponent,
      children: [
        {path : 'RegisterCountries', component:RegcountriesComponent},
        {path : 'ListCountries', component:ListcountriesComponent},
        {path : 'ListProvincies', component:ListprovinciesComponent}
      ]
    },
    { path : 'ApiPaises/Home', component: HomeComponent},
    { path : 'ApiPaises/home', component:TituloComponent},
    {path : 'ApiPaises/About', component:AboutComponent},
    {path : 'ApiPaises/Work', component:WorkComponent},
    {path : '**', redirectTo: 'ApiPaises/Home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const app_routing = RouterModule.forRoot(routes)
