import { Produit } from './../../model/produit';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-edit-produit',
  templateUrl: './edit-produit.component.html',
  styleUrls: ['./edit-produit.component.css'],
})
export class EditProduitComponent implements OnInit {
  produit: Produit = new Produit();

  constructor(
    private ar: ActivatedRoute,
    private produitService: ProduitService,
    private router: Router
  ) {
    this.ar.params.subscribe((params) => {
      if (params.id) {
        this.produitService.get(params.id).subscribe((res) => {
          this.produit = res;
        });
      }
    });
  }

  ngOnInit(): void {}

  save() {
    if (this.produit.id) {
      console.log('update');
      this.produitService.update(this.produit).subscribe((res) => {
        this.goListProduit();
      });
    } else {
      console.log('create');
      this.produitService.create(this.produit).subscribe((res) => {
        this.goListProduit();
      });
    }
  }

  goListProduit() {
    this.router.navigate(['/produit']);
  }
}
