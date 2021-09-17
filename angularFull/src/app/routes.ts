import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { CanActivateService } from './services/can-activate.service';
import { InscriptionComponent } from './inscription/inscription.component';
import { FormulaireCodeComponent } from './formulaire/formulaire-code/formulaire-code.component';
import { FormulaireTemplateComponent } from './formulaire/formulaire-template/formulaire-template.component';
import { EditFournisseurComponent } from './fournisseur/edit-fournisseur/edit-fournisseur.component';
import { ListFournisseurComponent } from './fournisseur/list-fournisseur/list-fournisseur.component';
import { Routes } from '@angular/router';
import { EditProduitComponent } from './produit/edit-produit/edit-produit.component';
import { ListProduitComponent } from './produit/list-produit/list-produit.component';

export const routes: Routes = [
  {
    path: 'produit',
    component: ListProduitComponent,
    canActivate: [CanActivateService],
  },
  {
    path: 'produit/edit',
    component: EditProduitComponent,
    canActivate: [CanActivateService],
  },
  {
    path: 'produit/edit/:id',
    component: EditProduitComponent,
    canActivate: [CanActivateService],
  },
  { path: 'fournisseur', component: ListFournisseurComponent },
  { path: 'fournisseur/edit', component: EditFournisseurComponent },
  { path: 'fournisseur/edit/:id', component: EditFournisseurComponent },
  { path: 'formulaire/template', component: FormulaireTemplateComponent },
  { path: 'formulaire/code', component: FormulaireCodeComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
