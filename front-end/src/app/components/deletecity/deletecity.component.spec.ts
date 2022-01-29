import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletecityComponent } from './deletecity.component';

describe('DeletecityComponent', () => {
  let component: DeletecityComponent;
  let fixture: ComponentFixture<DeletecityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeletecityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeletecityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
