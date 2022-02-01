import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { ApiRestService } from 'src/app/servicios/api/api-rest.service';
import { Router } from '@angular/router';
import { ProvinceU } from '../model/provinceU.interface';
import { CityU } from '../model/cityU.interface';

@Component({
  selector: 'app-updatecities',
  templateUrl: './updatecities.component.html',
  styleUrls: ['./updatecities.component.sass']
})
export class UpdatecitiesComponent implements OnInit {
  public dato = 'Ecuador';
  public seleccion = 'Nombre del país';
  public lista:any = [];
  public dat: string = '';
  public categorias:any = [
    { value: 'http://localhost:8080/Rest/CitiesApi/findBynamecity?namecity=', nombre:'City name'},
    { value: 'http://localhost:8080/Rest/CitiesApi/findBycabeceracity?cabeceracity=', nombre:'City cabecera'}
  ];

  public data: any= {};


  public newFormA = new FormGroup({
    id: new FormControl(''),
    idprovince: new FormControl(''),
    idcity: new FormControl(''),
    namecity: new FormControl(''),
    cabeceracity: new FormControl(''),
    flagcity: new FormControl(''),
    coordinatelat: new FormControl(''),
    coordinatealt: new FormControl(''),
    callcodecity: new FormControl(''),
    statecity: new FormControl('')
  })

  constructor(private RestService:ApiRestService, private router:Router,private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.newFormA = this.formBuilder.group({
      id: ['', [Validators.required]],
      idprovince: [''],
      idcity: ['', [Validators.required]],
      namecity: ['', [Validators.required]],
      cabeceracity:['', [Validators.required]],
      flagcity: ['', [Validators.required]],
      coordinatelat: ['', [Validators.required]],
      coordinatealt: ['', [Validators.required]],
      callcodecity: ['', [Validators.required]],
      statecity: ['', [Validators.required]]
    });
  }

  public getValue(value:string){
    this.dato = value
  }

  public consultarDatos(){
    this.RestService.get(this.seleccion + this.dato)
    .subscribe(respuesta => {
      this.lista = respuesta;
      this.data = this.lista[0];
      this.llenarcampo();
    })
  }

  public llenarcampo(){
    this.newFormA = this.formBuilder.group({
      id: [this.data.id, [Validators.required]],
      idprovince: [this.data.idprovince],
      idcity: [this.data.idcity, [Validators.required]],
      namecity: [this.data.namecity, [Validators.required]],
      cabeceracity:[this.data.cabeceracity, [Validators.required]],
      flagcity: [this.data.flagcity, [Validators.required]],
      coordinatelat: [this.data.coordinatelat, [Validators.required]],
      coordinatealt: [this.data.coordinatealt, [Validators.required]],
      callcodecity: [this.data.callcodecity, [Validators.required]],
      statecity: [this.data.statecity, [Validators.required]]
    });
  }
  public updateData(form: CityU){
    this.RestService.updateCity(form).subscribe( data =>{
      console.log(data);
      window.location.reload();
    })
    console.log(form);
  }
  send(): any{
  }

}
