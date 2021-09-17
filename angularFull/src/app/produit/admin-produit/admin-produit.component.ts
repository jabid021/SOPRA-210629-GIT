import { ProduitService } from 'src/app/services/produit.service';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'admin-produit',
  templateUrl: './admin-produit.component.html',
  styleUrls: ['./admin-produit.component.css'],
})
export class AdminProduitComponent implements OnInit {
  @Input('id')
  id: number | undefined;
  @Output()
  deleteEvent: EventEmitter<string> = new EventEmitter();

  constructor(private produitService: ProduitService) {}

  ngOnInit(): void {}

  delete() {
    this.produitService.delete(this.id).subscribe((res) => {
      this.deleteEvent.emit();
    });
  }
}
