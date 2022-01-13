import { Component, OnInit } from '@angular/core';
import { RestService } from 'src/app/rest.service';

@Component({
  selector: 'app-navvertical',
  templateUrl: './navvertical.component.html',
  styleUrls: ['./navvertical.component.sass']
})
export class NavverticalComponent implements OnInit {

  constructor(private RestService: RestService) { }

  ngOnInit(): void {
    //this.cargarData();
  }

  public cargarData(){
    this.RestService.get("localhost:8080/ProvincesApi/findBynameprovince?Province=Queensland")
    .subscribe(respuesta =>{
      console.log(respuesta);
    })
  }

}
