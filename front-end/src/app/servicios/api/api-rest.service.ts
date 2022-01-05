import { Injectable } from '@angular/core';
import { CountryI } from 'src/app/components/model/country.interface';
import { ResponseI } from 'src/app/components/model/response.interface';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiRestService {

  url:string = "";

  constructor(private http:HttpClient) { }
}
