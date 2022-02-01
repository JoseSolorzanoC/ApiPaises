import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import { RestService } from 'src/app/rest.service';

@Component({
  selector: 'app-navvertical',
  templateUrl: './navvertical.component.html',
  styleUrls: ['./navvertical.component.sass']
})
export class NavverticalComponent implements OnInit {

  @ViewChild('asOpc', {static: true}) asOpc: any;

  constructor(private RestService: RestService, private renderer: Renderer2) { }

  ngOnInit(): void {
    this.createAddC();
    this.createDeleteC();
    this.createUpdateC();
  }
  createAddC(){
    const asOpc2 = this.asOpc.nativeElement;
    let div = this.renderer.createElement('div');
    let a = this.renderer.createElement('a');
    let txta = this.renderer.createText('Add countries');

    this.renderer.appendChild(asOpc2, div);
    this.renderer.addClass(div, 'accordion-body');
    this.renderer.appendChild(div, a);
    this.renderer.appendChild(a, txta);
    this.renderer.setProperty(a, 'href', 'ApiPaises/MainMenu/RegisterCountries');
  }

  createDeleteC(){
    const asOpc2 = this.asOpc.nativeElement;
    let div = this.renderer.createElement('div');
    let a = this.renderer.createElement('a');
    let txta = this.renderer.createText('Delete countries');

    this.renderer.appendChild(asOpc2, div);
    this.renderer.addClass(div, 'accordion-body');
    this.renderer.appendChild(div, a);
    this.renderer.appendChild(a, txta);
    this.renderer.setProperty(a, 'href', 'ApiPaises/MainMenu/DeleteCountrys');
  }

  createUpdateC(){
    const asOpc2 = this.asOpc.nativeElement;
    let div = this.renderer.createElement('div');
    let a = this.renderer.createElement('a');
    let txta = this.renderer.createText('Update countries');

    this.renderer.appendChild(asOpc2, div);
    this.renderer.addClass(div, 'accordion-body');
    this.renderer.appendChild(div, a);
    this.renderer.appendChild(a, txta);
    this.renderer.setProperty(a, 'href', 'ApiPaises/MainMenu/UpdateCountries');
  }
}


