import { Personne } from './model/personne';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  olivier: Personne = new Personne('olivier');
  couleur = 'pink';
  autreCouleur = 'green';

  public log() {
    console.log('click sur le bouton');
  }

  public setCouleur() {
    return 'yellow';
  }
}
