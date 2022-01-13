import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListprovinciesComponent } from './listprovincies.component';

describe('ListprovinciesComponent', () => {
  let component: ListprovinciesComponent;
  let fixture: ComponentFixture<ListprovinciesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListprovinciesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListprovinciesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
