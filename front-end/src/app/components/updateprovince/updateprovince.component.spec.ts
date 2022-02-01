import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateprovinceComponent } from './updateprovince.component';

describe('UpdateprovinceComponent', () => {
  let component: UpdateprovinceComponent;
  let fixture: ComponentFixture<UpdateprovinceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateprovinceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateprovinceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
