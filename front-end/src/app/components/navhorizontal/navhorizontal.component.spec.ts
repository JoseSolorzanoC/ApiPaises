import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavhorizontalComponent } from './navhorizontal.component';

describe('NavhorizontalComponent', () => {
  let component: NavhorizontalComponent;
  let fixture: ComponentFixture<NavhorizontalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavhorizontalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavhorizontalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
