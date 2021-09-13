import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AscBlodElementComponent } from './asc-blod-element.component';

describe('AscBlodElementComponent', () => {
  let component: AscBlodElementComponent;
  let fixture: ComponentFixture<AscBlodElementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AscBlodElementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AscBlodElementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
