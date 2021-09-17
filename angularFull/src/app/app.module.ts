import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ListProduitComponent } from './produit/list-produit/list-produit.component';
import { EditProduitComponent } from './produit/edit-produit/edit-produit.component';
import { RouterModule } from '@angular/router';
import { routes } from './routes';
import { ListFournisseurComponent } from './fournisseur/list-fournisseur/list-fournisseur.component';
import { EditFournisseurComponent } from './fournisseur/edit-fournisseur/edit-fournisseur.component';
import { FormulaireTemplateComponent } from './formulaire/formulaire-template/formulaire-template.component';
import { FormulaireCodeComponent } from './formulaire/formulaire-code/formulaire-code.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AdminProduitComponent } from './produit/admin-produit/admin-produit.component';
import { AchatComponent } from './produit/achat/achat.component';
import { PanierComponent } from './panier/panier.component';

@NgModule({
  declarations: [
    AppComponent,
    ListProduitComponent,
    EditProduitComponent,
    ListFournisseurComponent,
    EditFournisseurComponent,
    FormulaireTemplateComponent,
    FormulaireCodeComponent,
    InscriptionComponent,
    LoginComponent,
    HomeComponent,
    AdminProduitComponent,
    AchatComponent,
    PanierComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
