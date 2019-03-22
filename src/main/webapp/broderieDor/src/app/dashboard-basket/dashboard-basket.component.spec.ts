import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardBasketComponent } from './dashboard-basket.component';

describe('DashboardBasketComponent', () => {
  let component: DashboardBasketComponent;
  let fixture: ComponentFixture<DashboardBasketComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashboardBasketComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardBasketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
