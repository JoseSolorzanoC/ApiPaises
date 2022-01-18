import { Injectable } from '@angular/core';
import { CountryI } from 'src/app/components/model/country.interface';
import { ResponseI } from 'src/app/components/model/response.interface';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiRestService {

  dir: string = ''

  constructor(private http:HttpClient) { }

  public get(url:string){
    return this.http.get(url);
  }

  public getWParam(url:string): Observable<any>{
    return this.http.get(url);
  }

  postCountry(form:CountryI): Observable<ResponseI>{
    let dir = 'http://localhost:8080/CountriesApi/Insert'
    return this.http.post<ResponseI>(dir, form);
  }

}
