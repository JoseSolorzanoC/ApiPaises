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

const routes: Routes = [
    {path : 'Login', component:LoginComponent},
    {path : 'Register', component:RegisterComponent},
    {path : 'Home', component:HomeComponent},
    {path : 'NavHorizontal', component:NavhorizontalComponent},
    { path : 'NavVertical', component:NavverticalComponent,
      children: [
        {path : 'RegisterCountries', component:RegcountriesComponent},
        {path : 'ListCountries', component:ListcountriesComponent}
      ]
    },
    {path : '**', redirectTo: '/NavVertical'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const app_routing = RouterModule.forRoot(routes)
