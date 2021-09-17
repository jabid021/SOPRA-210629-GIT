import { NoAuthCanActivateService } from './services/no-auth-can-activate.service';
import { AdminCanActivateService } from './services/admin-can-activate.service';
import { UserCanActivateService } from './services/user-can-activate.service';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AllUserCanActivateService } from './services/all-user-can-activate.service';
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
    canActivate: [AllUserCanActivateService],
  },
  {
    path: 'produit/edit',
    component: EditProduitComponent,
    canActivate: [AdminCanActivateService],
  },
  {
    path: 'produit/edit/:id',
    component: EditProduitComponent,
    canActivate: [AdminCanActivateService],
  },
  {
    path: 'fournisseur',
    component: ListFournisseurComponent,
    canActivate: [AdminCanActivateService],
  },
  {
    path: 'fournisseur/edit',
    component: EditFournisseurComponent,
    canActivate: [AdminCanActivateService],
  },
  {
    path: 'fournisseur/edit/:id',
    component: EditFournisseurComponent,
    canActivate: [AdminCanActivateService],
  },
  { path: 'formulaire/template', component: FormulaireTemplateComponent },
  { path: 'formulaire/code', component: FormulaireCodeComponent },
  {
    path: 'inscription',
    component: InscriptionComponent,
    canActivate: [NoAuthCanActivateService],
  },
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [NoAuthCanActivateService],
  },
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
