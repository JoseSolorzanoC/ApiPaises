import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { ApiRestService } from 'src/app/servicios/api/api-rest.service';
import { Router } from '@angular/router';
import { ProvinceU } from '../model/provinceU.interface';

@Component({
  selector: 'app-updateprovince',
  templateUrl: './updateprovince.component.html',
  styleUrls: ['./updateprovince.component.sass']
})
export class UpdateprovinceComponent implements OnInit {

  public dato = 'Ecuador';
  public seleccion = 'Nombre del país';
  public lista:any = [];
  public dat: string = '';
  public categorias:any = [
    { value: 'http://localhost:8080/Rest/ProvincesApi/findBynameProvinceAll?nameProvince=', nombre:'Province name'},
    { value: 'http://localhost:8080/Rest/ProvincesApi/findBycapitalProvinceAll?capitalProvince=', nombre:'Province capital'}
  ];

  public data: any= {};


  public newFormA = new FormGroup({
    id: new FormControl(''),
    idprovince: new FormControl(''),
    idcountry: new FormControl(''),
    nameprovince: new FormControl(''),
    capitalprovince: new FormControl(''),
    flagprovince: new FormControl(''),
    callcodeprovince: new FormControl(''),
    coordinatealt: new FormControl(''),
    coordinatelat: new FormControl(''),
    stateprovince: new FormControl('')
  })

  constructor(private RestService:ApiRestService, private router:Router,private formBuilder: FormBuilder) { }


  ngOnInit(): void {
    this.newFormA = this.formBuilder.group({
      id: ['', [Validators.required]],
      idprovince: [''],
      idcountry: ['', [Validators.required]],
      nameprovince: ['', [Validators.required]],
      capitalprovince:['', [Validators.required]],
      flagprovince: ['', [Validators.required]],
      callcodeprovince: ['', [Validators.required]],
      coordinatealt: ['', [Validators.required]],
      coordinatelat: ['', [Validators.required]],
      stateprovince: ['', [Validators.required]]
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
      idcountry: [this.data.idcountry, [Validators.required]],
      nameprovince: [this.data.nameprovince, [Validators.required]],
      capitalprovince:[this.data.capitalprovince, [Validators.required]],
      flagprovince: [this.data.flagprovince, [Validators.required]],
      callcodeprovince: [this.data.callcodeprovince, [Validators.required]],
      coordinatealt: [this.data.coordinatealt, [Validators.required]],
      coordinatelat: [this.data.coordinatelat, [Validators.required]],
      stateprovince: [this.data.stateprovince, [Validators.required]]
    });
  }
  public updateData(form: ProvinceU){
    this.RestService.updateProvince(form).subscribe( data =>{
      console.log(data);
      window.location.reload();
    })
    console.log(form);
  }
  send(): any{
  }

}
