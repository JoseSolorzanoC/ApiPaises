import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListcitiesComponent } from './listcities.component';

describe('ListcitiesComponent', () => {
  let component: ListcitiesComponent;
  let fixture: ComponentFixture<ListcitiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListcitiesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListcitiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
