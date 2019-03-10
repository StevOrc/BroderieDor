import { Component, OnInit } from '@angular/core';

import { TokenStorageService } from '../auth/token-storage.service';


@Component({
  selector: 'app-dashboard-basket',
  templateUrl: './dashboard-basket.component.html',
  styleUrls: ['./dashboard-basket.component.css']
})
export class DashboardBasketComponent implements OnInit {

  constructor(private tokenStorage: TokenStorageService) { }

  ngOnInit() {
  }

}
