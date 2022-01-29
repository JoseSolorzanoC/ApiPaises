import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteprovinceComponent } from './deleteprovince.component';

describe('DeleteprovinceComponent', () => {
  let component: DeleteprovinceComponent;
  let fixture: ComponentFixture<DeleteprovinceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteprovinceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteprovinceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
