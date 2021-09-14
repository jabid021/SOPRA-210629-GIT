import { FournisseurService } from './../../services/fournisseur.service';
import { Fournisseur } from './../../model/fournisseur';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-fournisseur',
  templateUrl: './list-fournisseur.component.html',
  styleUrls: ['./list-fournisseur.component.css'],
})
export class ListFournisseurComponent implements OnInit {
  fournisseurs: Fournisseur[] = [];

  constructor(private fournisseurService: FournisseurService) {}

  ngOnInit(): void {
    this.initList();
  }

  initList() {
    this.fournisseurService.getAll().subscribe(
      (res) => {
        this.fournisseurs = res;
      },
      (error) => {
        //traitement erreur
        console.log('on est en erreur');
      }
    );
  }

  // delete(id: number | undefined) {
  //   this.fournisseurService.delete(id).subscribe((ok) => {
  //     this.initList();
  //   });
  // }
}
