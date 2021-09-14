import { FakeService } from './services/fake.service';
import { DemoService } from './services/demo.service';
import { routes } from './routes';
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
import { ListProduitComponent } from './list-produit/list-produit.component';
import { DemoDirectiveDirective } from './demo-directive.directive';
import { HomeComponent } from './home/home.component';
import { RouterModule } from '@angular/router';
import { HelloComponent } from './hello/hello.component';
import { ProduitComponent } from './exoRoute/produit/produit.component';
import { ProduitDetailComponent } from './exoRoute/produit-detail/produit-detail.component';
import { ProduitRowComponent } from './exoRoute/produit-row/produit-row.component';
import { DemoPipePipe } from './pipes/demo-pipe.pipe';

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
    ShowProduitComponent,
    ListProduitComponent,
    DemoDirectiveDirective,
    HomeComponent,
    HelloComponent,
    ProduitComponent,
    ProduitDetailComponent,
    ProduitRowComponent,
    DemoPipePipe,
  ],
  imports: [BrowserModule, FormsModule, RouterModule.forRoot(routes)],
  providers: [{ provide: DemoService, useClass: DemoService }],
  bootstrap: [AppComponent],
})
export class AppModule {}
