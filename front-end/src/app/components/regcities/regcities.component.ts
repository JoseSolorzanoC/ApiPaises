import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { ApiRestService } from 'src/app/servicios/api/api-rest.service';
import { Router } from '@angular/router';
import { CityI} from '../model/city.interface';

@Component({
  selector: 'app-regcities',
  templateUrl: './regcities.component.html',
  styleUrls: ['./regcities.component.sass']
})
export class RegcitiesComponent implements OnInit {

  public lista:any = [];
  public dat: string = '';
  public categorias:any = [
    { value: 'http://localhost:8080/Rest/ProvincesApi/findAllProvinces'},
  ];

  public newForm = new FormGroup({
    idprovince: new FormControl(''),
    namecity: new FormControl(''),
    cabeceracity: new FormControl(''),
    flagcity: new FormControl(''),
    callcodecity: new FormControl(''),
    coordinatealt: new FormControl(''),
    coordinatelat: new FormControl('')})

  constructor(private RestService:ApiRestService, private router:Router,private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    this.newForm = this.formBuilder.group({
      idprovince: ['', [Validators.required]],
      namecity: ['', [Validators.required]],
      cabeceracity: ['', [Validators.required]],
      flagcity: ['', [Validators.required]],
      callcodecity: ['', [Validators.required]],
      coordinatealt: ['', [Validators.required]],
      coordinatelat: ['', [Validators.required]]})

      this.cargarData();
  }

  postForm(form: CityI){
    this.RestService.postCity(form).subscribe( data =>{
      console.log(data);
    })
    console.log(form);
  }
  send(): any{
    console.log(this.newForm.value);
  }


  public cargarData(){
    this.RestService.get('http://localhost:8080/Rest/ProvincesApi/findAllProvinces')
    .subscribe(respuesta => {
      this.lista = respuesta;
      console.log(this.lista = respuesta);
    })
  }

}
