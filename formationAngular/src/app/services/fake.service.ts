import { Injectable } from '@angular/core';

@Injectable()
export class FakeService {
  constructor() {}

  public methodeDuService(): string {
    return 'le faux service de test';
  }
}
