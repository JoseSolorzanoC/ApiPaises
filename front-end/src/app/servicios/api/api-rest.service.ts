import { Injectable } from '@angular/core';
import { CountryI } from 'src/app/components/model/country.interface';
import { ResponseI } from 'src/app/components/model/response.interface';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable} from 'rxjs';
import { ProvinceI } from 'src/app/components/model/province.interface';
import { CityI } from 'src/app/components/model/city.interface';
import { ProvinceU } from 'src/app/components/model/provinceU.interface';
import { CountryU } from 'src/app/components/model/countryU.interface';
import { CityU } from 'src/app/components/model/cityU.interface';

@Injectable({
  providedIn: 'root'
})
export class ApiRestService {

  dir: string = ''
  urlDelete: string = "http://localhost:8080/Rest/CountriesApi/DeleteById?id=";

  urlDeleteP: string = "http://localhost:8080/Rest/ProvincesApi/DeleteId?id=";
  urlUpdateP: string = "http://localhost:8080/Rest/ProvincesApi/Update";

  urlDeleteC: string = "http://localhost:8080/Rest/CitiesApi/DeleteName?name=";
  urlUpdateC: string = "http://localhost:8080/Rest/CitiesApi/Update";

  constructor(private http:HttpClient) { }

  public get(url:string){
    return this.http.get(url);
  }

  public getWParam(url:string): Observable<any>{
    return this.http.get(url);
  }

  //Country
  postCountry(form:CountryI): Observable<ResponseI>{
    let dir = 'http://localhost:8080/Rest/CountriesApi/Insert'
    return this.http.post<ResponseI>(dir, form);
  }

  deleteCountry(name: string): Observable<{}>{
    this.urlDelete = `${this.urlDelete}${name}`;
    return this.http.delete(this.urlDelete);
  }

  updateCountry(form: CountryU): Observable<ResponseI>{
    let dir = 'http://localhost:8080/Rest/CountriesApi/Update'
    return this.http.put<ResponseI>(dir, form);
  }

  //Province
  postProvince(form:ProvinceI): Observable<ResponseI>{
    let dir = 'http://localhost:8080/Rest/ProvincesApi/Insert'
    return this.http.post<ResponseI>(dir, form);
  }

  deleteProvince(name: string): Observable<{}>{
    this.urlDeleteP = `${this.urlDeleteP}${name}`;
    return this.http.delete(this.urlDeleteP);
  }

  updateProvince(form: ProvinceU): Observable<ResponseI>{
    let dir = 'http://localhost:8080/Rest/ProvincesApi/Update'
    return this.http.put<ResponseI>(dir, form);
  }

  //City
  postCity(form:CityI): Observable<ResponseI>{
    let dir = 'http://localhost:8080/Rest/CitiesApi/Insert'
    return this.http.post<ResponseI>(dir, form);
  }

  deleteCity(name: string): Observable<{}>{
    this.urlDeleteC = `${this.urlDeleteC}${name}`;
    return this.http.delete(this.urlDeleteC);
  }

  updateCity(form: CityU): Observable<ResponseI>{
    let dir = 'http://localhost:8080/Rest/CitiesApi/Update'
    return this.http.put<ResponseI>(dir, form);
  }

}
