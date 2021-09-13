import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FirstComponent } from './first/first.component';
import { AutreComponent } from './autre/autre.component';
import { ComponentSelectorBaliseComponent } from './component-selector-balise/component-selector-balise.component';
import { ComponentSelectorDirectiveComponent } from './component-selector-directive/component-selector-directive.component';
import { AscBoldComponent } from './asc-bold/asc-bold.component';
import { AscBlodElementComponent } from './asc-blod-element/asc-blod-element.component';
import { AscTooltipComponent } from './asc-tooltip/asc-tooltip.component';
import { OutputComponent } from './output/output.component';
import { FormProduitComponent } from './form-produit/form-produit.component';
import { ShowProduitComponent } from './show-produit/show-produit.component';

@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    AutreComponent,
    ComponentSelectorBaliseComponent,
    ComponentSelectorDirectiveComponent,
    AscBoldComponent,
    AscBlodElementComponent,
    AscTooltipComponent,
    OutputComponent,
    FormProduitComponent,
    ShowProduitComponent
  ],
  imports: [
    BrowserModule, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
