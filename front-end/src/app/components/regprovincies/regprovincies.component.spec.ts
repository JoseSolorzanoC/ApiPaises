import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegprovinciesComponent } from './regprovincies.component';

describe('RegprovinciesComponent', () => {
  let component: RegprovinciesComponent;
  let fixture: ComponentFixture<RegprovinciesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegprovinciesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegprovinciesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
