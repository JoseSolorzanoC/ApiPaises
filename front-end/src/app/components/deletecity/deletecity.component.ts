import { Component, OnInit } from '@angular/core';
import { ApiRestService } from 'src/app/servicios/api/api-rest.service';
import { Router } from '@angular/router';
import {PageEvent} from '@angular/material/paginator';

@Component({
  selector: 'app-deletecity',
  templateUrl: './deletecity.component.html',
  styleUrls: ['./deletecity.component.sass']
})
export class DeletecityComponent implements OnInit {

  public dato = 'Ecuador';
  public seleccion = 'Nombre del país';
  public lista:any = [];
  public dat: string = '';
  public categorias:any = [
    { value: 'http://localhost:8080/Rest/CitiesApi/findBynamecity?namecity=', nombre:'City name'}
  ];

  constructor(private RestService:ApiRestService, private router:Router) { }

  ngOnInit(): void {
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

  deleteCity(name: string):void{
    this.RestService.deleteCity(name).subscribe(
    );
    window.location.reload();
  }

  page_size: number = 10
  page_number: number = 1
  pageSizeOptions = [10, 20, 30, 40, 50]

}
