import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegcountriesComponent } from './regcountries.component';

describe('RegcountriesComponent', () => {
  let component: RegcountriesComponent;
  let fixture: ComponentFixture<RegcountriesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegcountriesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegcountriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
