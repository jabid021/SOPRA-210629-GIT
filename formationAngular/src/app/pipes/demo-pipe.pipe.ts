import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'demoPipe',
})
export class DemoPipePipe implements PipeTransform {
  transform(value: unknown, ...args: unknown[]): unknown {
    console.log(value);
    console.log(args);
    return 'une autre valeur';
  }
}
