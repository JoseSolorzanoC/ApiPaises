import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavverticalComponent } from './navvertical.component';

describe('NavverticalComponent', () => {
  let component: NavverticalComponent;
  let fixture: ComponentFixture<NavverticalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavverticalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavverticalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
