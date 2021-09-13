import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appDemoDirective]',
})
export class DemoDirectiveDirective {
  constructor(private elementRef: ElementRef, private renderer: Renderer2) {
    console.log(this.elementRef.nativeElement);
    // renderer.setProperty(
    //   this.elementRef.nativeElement,
    //   'innerHTML',
    //   'modifie par la directive'
    // );
    renderer.setStyle(this.elementRef.nativeElement, 'background-color', 'red');
  }
}
