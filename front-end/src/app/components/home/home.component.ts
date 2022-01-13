import { Component, OnInit } from '@angular/core';
import { CAROUSEL_DATA_ITEMS } from '../slider/constans';
import { ICarouselItem } from '../slider/Icarousel.item.metadata';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.sass']
})
export class HomeComponent implements OnInit {

  public carouselData: ICarouselItem[] = CAROUSEL_DATA_ITEMS;

  constructor() { }

  ngOnInit(): void {
  }

}
