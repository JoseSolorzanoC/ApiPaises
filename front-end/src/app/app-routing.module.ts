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
import { AboutComponent } from './components/about/about.component';
import { WorkComponent } from './components/work/work.component';
import {ListprovinciesComponent} from './components/listprovincies/listprovincies.component';
import {RegprovinciesComponent} from './components/regprovincies/regprovincies.component';
import {ListcitiesComponent} from './components/listcities/listcities.component';
import {RegcitiesComponent} from './components/regcities/regcities.component';
import {DeletecountryComponent} from './components/deletecountry/deletecountry.component';
import {DeleteprovinceComponent} from './components/deleteprovince/deleteprovince.component';
import {DeletecityComponent} from './components/deletecity/deletecity.component';
import {UpdatecountryComponent} from './components/updatecountry/updatecountry.component';
import {UpdateprovinceComponent} from './components/updateprovince/updateprovince.component';
import {UpdatecitiesComponent} from './components/updatecities/updatecities.component';

const routes: Routes = [
    {path : 'Home', component:NavhorizontalComponent},
    { path : 'ApiPaises/MainMenu', component:NavverticalComponent,
      children: [
        {path : 'ListCountries', component:ListcountriesComponent},
        {path : 'RegisterCountries', component:RegcountriesComponent},
        {path : 'DeleteCountrys', component:DeletecountryComponent},
        {path : 'UpdateCountries', component:UpdatecountryComponent},
        {path : 'ListProvincies', component:ListprovinciesComponent},
        {path : 'RegisterProvincies', component:RegprovinciesComponent},
        {path : 'ListCities', component:ListcitiesComponent},
        {path : 'RegisterCity', component:RegcitiesComponent},
        {path : 'DeleteProvinces', component:DeleteprovinceComponent},
        {path : 'DeleteCitites', component:DeletecityComponent},
        {path : 'UpdateProvinces', component:UpdateprovinceComponent},
        {path : 'UpdateCities', component:UpdatecitiesComponent}
      ]
    },
    {path : 'ApiPaises/Home', component: HomeComponent},
    {path : 'ApiPaises/About', component:AboutComponent},
    {path : 'ApiPaises/Work', component:WorkComponent},
    {path : 'ApiPaises/sign/in', component:LoginComponent},
    {path : 'ApiPaises/sign/up', component:RegisterComponent},
    {path : '**', redirectTo: 'ApiPaises/Home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const app_routing = RouterModule.forRoot(routes)
