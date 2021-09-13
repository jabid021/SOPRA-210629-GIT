import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentSelectorBaliseComponent } from './component-selector-balise.component';

describe('ComponentSelectorBaliseComponent', () => {
  let component: ComponentSelectorBaliseComponent;
  let fixture: ComponentFixture<ComponentSelectorBaliseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComponentSelectorBaliseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentSelectorBaliseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
