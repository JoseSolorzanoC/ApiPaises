import { Component, OnInit } from '@angular/core';
import { ApiRestService } from 'src/app/servicios/api/api-rest.service';
import { Router } from '@angular/router';
import {PageEvent} from '@angular/material/paginator';

@Component({
  selector: 'app-listprovincies',
  templateUrl: './listprovincies.component.html',
  styleUrls: ['./listprovincies.component.sass']
})
export class ListprovinciesComponent implements OnInit {

  public dato = 'Ecuador';
  public seleccion = 'Nombre del país';
  public lista:any = [];
  public dat: string = '';
  public categorias:any = [
    { value: 'http://localhost:8080/Rest/ProvincesApi/findBynameProvince?nameProvince=', nombre:'Province name'},
    { value: 'http://localhost:8080/Rest/ProvincesApi/findBycapitalProvince?capitalProvince=', nombre:'Province capital'}
  ];


  constructor(private RestService:ApiRestService, private router:Router) { }

  ngOnInit(): void {
    this.cargarData();
  }

  public cargarData(){
    this.RestService.get('http://localhost:8080/Rest/ProvincesApi/findAllProvinces')
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

  handlePage(e: PageEvent){
    this.page_size = e.pageSize
    this.page_number = e.pageIndex + 1
  }


  page_size: number = 10
  page_number: number = 1
  pageSizeOptions = [10, 20, 50, 100, 150];
}
