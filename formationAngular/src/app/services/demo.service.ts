import { Injectable } from '@angular/core';

@Injectable()
export class DemoService {
  constructor() {
    console.log('creation du service');
  }

  public methodeDuService(): string {
    return 'message du service';
  }
}
