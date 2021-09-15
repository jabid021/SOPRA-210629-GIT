import { InscriptionComponent } from './inscription/inscription.component';
import { FormulaireCodeComponent } from './formulaire/formulaire-code/formulaire-code.component';
import { FormulaireTemplateComponent } from './formulaire/formulaire-template/formulaire-template.component';
import { EditFournisseurComponent } from './fournisseur/edit-fournisseur/edit-fournisseur.component';
import { ListFournisseurComponent } from './fournisseur/list-fournisseur/list-fournisseur.component';
import { Routes } from '@angular/router';
import { EditProduitComponent } from './produit/edit-produit/edit-produit.component';
import { ListProduitComponent } from './produit/list-produit/list-produit.component';

export const routes: Routes = [
  { path: 'produit', component: ListProduitComponent },
  { path: 'produit/edit', component: EditProduitComponent },
  { path: 'produit/edit/:id', component: EditProduitComponent },
  { path: 'fournisseur', component: ListFournisseurComponent },
  { path: 'fournisseur/edit', component: EditFournisseurComponent },
  { path: 'fournisseur/edit/:id', component: EditFournisseurComponent },
  { path: 'formulaire/template', component: FormulaireTemplateComponent },
  { path: 'formulaire/code', component: FormulaireCodeComponent },
  { path: 'inscription', component: InscriptionComponent },
];
