import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { ApiRestService } from 'src/app/servicios/api/api-rest.service';
import { Router } from '@angular/router';
import { ProvinceI} from '../model/province.interface';

@Component({
  selector: 'app-regprovincies',
  templateUrl: './regprovincies.component.html',
  styleUrls: ['./regprovincies.component.sass']
})
export class RegprovinciesComponent implements OnInit {

  public lista:any = [];
  public dat: string = '';
  public categorias:any = [
    { value: 'http://localhost:8080/Rest/CountriesApi/findAll'},
  ];

  public newForm = new FormGroup({
    idcountry: new FormControl(''),
    nameprovince: new FormControl(''),
    capitalprovince: new FormControl(''),
    flagprovince: new FormControl(''),
    callcodeprovince: new FormControl(''),
    coordinatealt: new FormControl(''),
    coordinatelat: new FormControl('')})

  constructor(private RestService:ApiRestService, private router:Router,private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.newForm = this.formBuilder.group({
      idcountry: ['', [Validators.required]],
      nameprovince: ['', [Validators.required]],
      capitalprovince: ['', [Validators.required]],
      flagprovince: ['', [Validators.required]],
      callcodeprovince: ['', [Validators.required]],
      coordinatealt: ['', [Validators.required]],
      coordinatelat: ['', [Validators.required]]})

      this.cargarData();
  }


  postForm(form: ProvinceI){
    this.RestService.postProvince(form).subscribe( data =>{
      console.log(data);
    })
    console.log(form);
  }
  send(): any{
    console.log(this.newForm.value);
  }


  public cargarData(){
    this.RestService.get('http://localhost:8080/Rest/CountriesApi/findAll')
    .subscribe(respuesta => {
      this.lista = respuesta;
      console.log(this.lista = respuesta);
    })
  }

}
