import { Civilite } from './../../model/civilite';
import { Fournisseur } from './../../model/fournisseur';
import { FournisseurService } from './../../services/fournisseur.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-fournisseur',
  templateUrl: './edit-fournisseur.component.html',
  styleUrls: ['./edit-fournisseur.component.css'],
})
export class EditFournisseurComponent implements OnInit {
  fournisseur: Fournisseur = new Fournisseur();
  civilites = Civilite;
  constructor(
    private ar: ActivatedRoute,
    private router: Router,
    private fournisseurService: FournisseurService
  ) {
    this.ar.params.subscribe((params) => {
      if (params.id) {
        this.fournisseurService.get(params.id).subscribe((res) => {
          console.log(res);
          this.fournisseur = res;
        });
      }
    });
  }

  save() {
    if (this.fournisseur.id) {
      this.fournisseurService.update(this.fournisseur).subscribe((ok) => {
        this.goList();
      });
    } else {
      this.fournisseurService.create(this.fournisseur).subscribe((ok) => {
        this.goList();
      });
    }
  }

  goList() {
    this.router.navigate(['/fournisseur']);
  }

  ngOnInit(): void {}
}
