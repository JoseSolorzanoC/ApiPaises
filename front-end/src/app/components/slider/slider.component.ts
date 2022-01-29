import { Component, Input, OnInit } from '@angular/core';
import { ICarouselItem } from './Icarousel.item.metadata';

@Component({
  selector: 'app-slider',
  templateUrl: './slider.component.html',
  styleUrls: ['./slider.component.sass']
})
export class SliderComponent implements OnInit {


  @Input() height = 500;
  @Input() isFullScreen = false;
  @Input() items: ICarouselItem[] = [];


  public finalHeight: string | number = 0;
  public currentPosition = 0;
  constructor() {
    this.finalHeight = this.isFullScreen ? '375px': `${this.height}px`;
  }

  ngOnInit() {
    this.items.map((i, index)=>{
      i.id = index;
      i.marginTop = 0;
      i.marginTopTS = 0;
    });
  }

  setCurrentPosition(position: number){
    this.currentPosition = position;
    this.items.find((i) => i.id === 0)!.marginTop = -103 * position;
    this.items.find((i) => i.id === 0)!.marginTopTS = -150 * position;
  }


  setNext(){
    let finalPercentaje = 0;
    let finalPercentaje2 = 0;
    let nextPosition = this.currentPosition + 1;
    if(nextPosition <= this.items.length - 1){
      finalPercentaje = -103 * nextPosition;
      finalPercentaje2 = -150 * nextPosition;
    }else{
      nextPosition = 0;
    }
    this.items.find((i) => i.id === 0)!.marginTop =  finalPercentaje;
    this.items.find((i) => i.id === 0)!.marginTopTS =  finalPercentaje2;
    this.currentPosition = nextPosition;
  }

  setPrev(){
    let finalPercentaje = 0;
    let finalPercentaje2 = 0;
    let prevPosition = this.currentPosition - 1;
    if(prevPosition >= 0){
      finalPercentaje = -103 * prevPosition;
    }else{
      prevPosition = this.items.length - 1;
      finalPercentaje = -103 * prevPosition;
      finalPercentaje2 = -150 * prevPosition;
    }
    this.items.find((id) => id.id === 0)!.marginTop = finalPercentaje;
    this.items.find((i) => i.id === 0)!.marginTopTS =  finalPercentaje2;
    this.currentPosition = prevPosition;
  }
}
