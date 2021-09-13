import { HelloComponent } from './hello/hello.component';
import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';
import { ProduitComponent } from './exoRoute/produit/produit.component';
import { ProduitDetailComponent } from './exoRoute/produit-detail/produit-detail.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produits', component: ProduitComponent },
  {path:'produits/new',component:ProduitDetailComponent},
  { path: 'produits/:index', component: ProduitDetailComponent },
  { path: 'home/:nom', component: HelloComponent, outlet: 'second' },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
