import { Component, OnInit } from '@angular/core';


declare var run:any;

@Component({
  selector: 'app-listcountries',
  templateUrl: './listcountries.component.html',
  styleUrls: ['./listcountries.component.sass']
})
export class ListcountriesComponent implements OnInit{

  OnClick1  (){
    run();
  }

//https://github-com.translate.goog/lula/ngx-soap/blob/master/src/app/app.component.ts?_x_tr_sl=en&_x_tr_tl=es&_x_tr_hl=es&_x_tr_pto=op,sc


  constructor() { }
  ngOnInit(): void {
  }

}
