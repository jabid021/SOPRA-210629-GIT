import { Component, OnInit, Input, HostListener } from '@angular/core';

@Component({
  selector: 'asc-tooltip',
  templateUrl: './asc-tooltip.component.html',
  styleUrls: ['./asc-tooltip.component.css'],
})
export class AscTooltipComponent implements OnInit {
  @Input()
  titre: string = '';
  visible: boolean = false;

  constructor() {}

  ngOnInit(): void {}

  @HostListener('mouseover')
  mouseOver() {
    this.visible = true;
  }

  @HostListener('mouseleave')
  mouseLeave() {
    this.visible = false;
  }
}
