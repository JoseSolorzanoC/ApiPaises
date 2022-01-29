import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

//Rutas
import { app_routing } from './app-routing.module';

//Angular Material
import { MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';

import {MatIconModule} from '@angular/material/icon';

import {MatButtonModule} from '@angular/material/button';

import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatCardModule} from '@angular/material/card';

import {MatToolbarModule} from '@angular/material/toolbar';
import {MatPaginatorModule} from '@angular/material/paginator';

//Components
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { RegcountriesComponent } from './components/regcountries/regcountries.component';
import { NavhorizontalComponent } from './components/navhorizontal/navhorizontal.component';
import { NavverticalComponent } from './components/navvertical/navvertical.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { ListcountriesComponent } from './components/listcountries/listcountries.component';
import { HttpClientModule } from '@angular/common/http';
import { AboutComponent } from './components/about/about.component';
import { WorkComponent } from './components/work/work.component';
import { SliderComponent } from './components/slider/slider.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ListprovinciesComponent } from './components/listprovincies/listprovincies.component';
import { PaginatePipe } from './pipes/paginate.pipe';
import { RegprovinciesComponent } from './components/regprovincies/regprovincies.component';
import { ListcitiesComponent } from './components/listcities/listcities.component';
import { RegcitiesComponent } from './components/regcities/regcities.component';
import { DeletecountryComponent } from './components/deletecountry/deletecountry.component';
import { DeleteprovinceComponent } from './components/deleteprovince/deleteprovince.component';
import { DeletecityComponent } from './components/deletecity/deletecity.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    RegcountriesComponent,
    NavhorizontalComponent,
    NavverticalComponent,
    HomepageComponent,
    ListcountriesComponent,
    AboutComponent,
    WorkComponent,
    SliderComponent,
    ListprovinciesComponent,
    PaginatePipe,
    RegprovinciesComponent,
    ListcitiesComponent,
    RegcitiesComponent,
    DeletecountryComponent,
    DeleteprovinceComponent,
    DeletecityComponent,
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    MatCheckboxModule,
    MatCardModule,
    MatToolbarModule,
    app_routing,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    MatPaginatorModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
export class FormFieldAppearanceExample {}

