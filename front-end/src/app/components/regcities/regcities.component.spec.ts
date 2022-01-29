import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegcitiesComponent } from './regcities.component';

describe('RegcitiesComponent', () => {
  let component: RegcitiesComponent;
  let fixture: ComponentFixture<RegcitiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegcitiesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegcitiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
