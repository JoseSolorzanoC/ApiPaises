import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatecitiesComponent } from './updatecities.component';

describe('UpdatecitiesComponent', () => {
  let component: UpdatecitiesComponent;
  let fixture: ComponentFixture<UpdatecitiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatecitiesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatecitiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
