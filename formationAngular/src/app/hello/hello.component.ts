import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrls: ['./hello.component.css'],
})
export class HelloComponent implements OnInit {
  nom: string = '';

  constructor(private activatedRoute: ActivatedRoute, private router: Router) {
    this.activatedRoute.params.subscribe((params) => {
      this.nom = params.nom;
    });
    this.activatedRoute.queryParams.subscribe((params) => {
      console.log(params);
    });
    //instructions
  }

  ngOnInit(): void {}

  fonction() {
    this.router.navigate(['/home'], { queryParams: { lien: 'ok' } });
  }
}
