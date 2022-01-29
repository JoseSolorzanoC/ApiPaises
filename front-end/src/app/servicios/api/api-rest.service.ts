import { Injectable } from '@angular/core';
import { CountryI } from 'src/app/components/model/country.interface';
import { ResponseI } from 'src/app/components/model/response.interface';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable} from 'rxjs';
import { ProvinceI } from 'src/app/components/model/province.interface';
import { CityI } from 'src/app/components/model/city.interface';

@Injectable({
  providedIn: 'root'
})
export class ApiRestService {

  dir: string = ''
  urlDelete: string = "http://localhost:8080/Rest/CountriesApi/DeleteName?name=";
  urlDeleteP: string = "http://localhost:8080/Rest/ProvincesApi/DeleteId?id=";
  urlDeleteC: string = "http://localhost:8080/Rest/CitiesApi/DeleteId?id=";

  constructor(private http:HttpClient) { }

  public get(url:string){
    return this.http.get(url);
  }

  public getWParam(url:string): Observable<any>{
    return this.http.get(url);
  }

  postCountry(form:CountryI): Observable<ResponseI>{
    let dir = 'http://localhost:8080/Rest/CountriesApi/Insert'
    return this.http.post<ResponseI>(dir, form);
  }

  deleteCountry(name: string): Observable<{}>{
    this.urlDelete = `${this.urlDelete}${name}`;
    return this.http.delete(this.urlDelete);
  }

  postProvince(form:ProvinceI): Observable<ResponseI>{
    let dir = 'http://localhost:8080/Rest/ProvincesApi/Insert'
    return this.http.post<ResponseI>(dir, form);
  }

  deleteProvince(name: string): Observable<{}>{
    this.urlDeleteP = `${this.urlDeleteP}${name}`;
    return this.http.delete(this.urlDeleteP);
  }

  deleteCity(name: string): Observable<{}>{
    this.urlDeleteC = `${this.urlDeleteC}${name}`;
    return this.http.delete(this.urlDeleteC);
  }

  postCity(form:CityI): Observable<ResponseI>{
    let dir = 'http://localhost:8080/Rest/CitiesApi/Insert'
    return this.http.post<ResponseI>(dir, form);
  }

}
