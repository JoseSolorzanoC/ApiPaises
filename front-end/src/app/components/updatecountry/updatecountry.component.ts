import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { ApiRestService } from 'src/app/servicios/api/api-rest.service';
import { Router } from '@angular/router';
import { CountryI } from '../model/country.interface';
import { CountryU } from '../model/countryU.interface';

@Component({
  selector: 'app-updatecountry',
  templateUrl: './updatecountry.component.html',
  styleUrls: ['./updatecountry.component.sass']
})
export class UpdatecountryComponent implements OnInit {

  public dato = 'Ecuador';
  public seleccion = 'Nombre del país';
  public lista:any = [];
  public dat: string = '';
  public categorias:any = [
    { value: 'http://localhost:8080/Rest/CountriesApi/findByname?name=', nombre:'Country name'},
    { value: 'http://localhost:8080/Rest/CountriesApi/findByenglishName?englishName=', nombre:'English name'},
    { value: 'http://localhost:8080/Rest/CountriesApi/findBycapital?capital=', nombre:'Capital'},
    { value: 'http://localhost:8080/Rest/CountriesApi/findBylatitude?latitude=', nombre:'Latitude'},
    { value: 'http://localhost:8080/Rest/CountriesApi/findBylongitude?longitude=', nombre:'Longitude'}
  ];

  public data: any= {};


  public newFormA = new FormGroup({
    id: new FormControl(''),
    countryId: new FormControl(''),
    name: new FormControl(''),
    englishName: new FormControl(''),
    flag: new FormControl(''),
    capital: new FormControl(''),
    latitude: new FormControl(''),
    longitude: new FormControl(''),
    fips: new FormControl(''),
    iso2: new FormControl(''),
    iso3: new FormControl(''),
    isoN: new FormControl(''),
    tld: new FormControl(''),
    statecountry: new FormControl('')
  })

  constructor(private RestService:ApiRestService, private router:Router,private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.newFormA = this.formBuilder.group({
      id: ['', [Validators.required]],
      countryId: ['', [Validators.required]],
      name: ['', [Validators.required]],
      englishName: ['', [Validators.required]],
      flag: ['', [Validators.required]],
      capital: ['', [Validators.required]],
      latitude: ['', [Validators.required]],
      longitude: ['', [Validators.required]],
      fips: ['', [Validators.required]],
      iso2: ['', [Validators.required]],
      iso3: ['', [Validators.required]],
      isoN: ['', [Validators.required]],
      tld: ['', [Validators.required]],
      callCode: ['', [Validators.required]],
      statecountry: ['', [Validators.required]]
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
      countryId: [this.data.countryId, [Validators.required]],
      name: [this.data.name, [Validators.required]],
      englishName: [this.data.englishName, [Validators.required]],
      flag:[this.data.flag, [Validators.required]],
      capital: [this.data.capital, [Validators.required]],
      latitude: [this.data.latitude, [Validators.required]],
      longitude: [this.data.longitude, [Validators.required]],
      fips: [this.data.countryCodes.fips, [Validators.required]],
      iso2: [this.data.countryCodes.iso2, [Validators.required]],
      iso3: [this.data.countryCodes.iso3, [Validators.required]],
      isoN: [this.data.countryCodes.isoN, [Validators.required]],
      tld: [this.data.countryCodes.tld, [Validators.required]],
      callCode: [this.data.callCode, [Validators.required]],
      statecountry: [this.data.statecountry, [Validators.required]]
    });
  }

  public updateData(form: CountryU){
    this.RestService.updateCountry(form).subscribe( data =>{
      console.log(data);
      window.location.reload();
    })
    console.log(form);
  }
  send(): any{
  }

}
