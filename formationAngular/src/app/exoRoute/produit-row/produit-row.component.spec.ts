import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProduitRowComponent } from './produit-row.component';

describe('ProduitRowComponent', () => {
  let component: ProduitRowComponent;
  let fixture: ComponentFixture<ProduitRowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProduitRowComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProduitRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
