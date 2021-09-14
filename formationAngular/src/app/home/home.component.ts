import { FakeService } from './../services/fake.service';
import { DemoService } from './../services/demo.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  message: string;
  constructor(private demoService: DemoService) {
    this.message = demoService.methodeDuService();
  }

  ngOnInit(): void {}
}
