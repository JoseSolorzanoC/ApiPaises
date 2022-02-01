import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { ApiRestService } from 'src/app/servicios/api/api-rest.service';
import { Router } from '@angular/router';
import { CountryI } from '../model/country.interface';


@Component({
  selector: 'app-regcountries',
  templateUrl: './regcountries.component.html',
  styleUrls: ['./regcountries.component.sass']
})
export class RegcountriesComponent implements OnInit {

  public newForm = new FormGroup({
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
    tld: new FormControl('')
  })
  constructor(private RestService:ApiRestService, private router:Router,private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.newForm = this.formBuilder.group({
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
      tld: ['', [Validators.required]]
    });
  }

  postForm(form: CountryI){
    this.RestService.postCountry(form).subscribe( data =>{
      console.log(data);
      window.location.reload();
    })
    console.log(form);
  }
  send(): any{
    console.log(this.newForm.value);
  }
}
