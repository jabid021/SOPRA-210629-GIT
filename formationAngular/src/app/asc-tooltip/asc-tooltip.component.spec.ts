import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AscTooltipComponent } from './asc-tooltip.component';

describe('AscTooltipComponent', () => {
  let component: AscTooltipComponent;
  let fixture: ComponentFixture<AscTooltipComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AscTooltipComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AscTooltipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
