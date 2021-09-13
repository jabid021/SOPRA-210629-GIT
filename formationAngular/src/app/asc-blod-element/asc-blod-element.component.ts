import { Component, OnInit, Input, HostListener } from '@angular/core';

@Component({
  selector: 'asc-bold-element',
  templateUrl: './asc-blod-element.component.html',
  styleUrls: ['./asc-blod-element.component.css'],
})
export class AscBlodElementComponent implements OnInit {
  @Input()
  prefix: string = '';
  @Input()
  text: string = '';

  constructor() {}

  ngOnInit(): void {}

  @HostListener('click')
  public click() {
    console.log(this.text);
  }
}
