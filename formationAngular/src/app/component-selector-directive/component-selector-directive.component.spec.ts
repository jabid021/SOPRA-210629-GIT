import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentSelectorDirectiveComponent } from './component-selector-directive.component';

describe('ComponentSelectorDirectiveComponent', () => {
  let component: ComponentSelectorDirectiveComponent;
  let fixture: ComponentFixture<ComponentSelectorDirectiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComponentSelectorDirectiveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentSelectorDirectiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
