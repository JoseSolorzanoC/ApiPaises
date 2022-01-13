import { Component, OnInit } from '@angular/core';
import { ApiRestService } from 'src/app/servicios/api/api-rest.service';
import { Router } from '@angular/router';

declare var run:any;

@Component({
  selector: 'app-listcountries',
  templateUrl: './listcountries.component.html',
  styleUrls: ['./listcountries.component.sass']
})
export class ListcountriesComponent implements OnInit{

  public dato = 'Ecuador';
  public seleccion = 'Nombre del país';
  public lista:any = [];
  public dat: string = '';
  public categorias:any = [
    { value: 'http://localhost:8080/CountriesApi/findByname?name=', nombre:'Nombre del país'},
    { value: 'http://localhost:8080/CountriesApi/findByenglishName?englishName=', nombre:'Nombre en inglés'},
    { value: 'http://localhost:8080/CountriesApi/findBycapital?capital=', nombre:'Capital'},
    { value: 'http://localhost:8080/CountriesApi/findBylatitude?latitude=', nombre:'Latitud'},
    { value: 'http://localhost:8080/CountriesApi/findBylongitude?longitude=', nombre:'Longitud'}
  ];


  constructor(private RestService:ApiRestService, private router:Router) { }

  ngOnInit(): void {
    this.cargarData();
  }

  public cargarData(){
    this.RestService.get('http://localhost:8080/CountriesApi/findAll')
    .subscribe(respuesta => {
      this.lista = respuesta;
      console.log(this.lista = respuesta);
    })
  }

  public consultarDatos(){
    this.RestService.get(this.seleccion + this.dato)
    .subscribe(respuesta => {
      this.lista = respuesta;
      console.log(this.lista = respuesta);
    })
  }

  public getValue(value:string){
    this.dato = value
  }

}
