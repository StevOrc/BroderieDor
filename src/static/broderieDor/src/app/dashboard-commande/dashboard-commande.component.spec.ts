import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardCommandeComponent } from './dashboard-commande.component';

describe('DashboardCommandeComponent', () => {
  let component: DashboardCommandeComponent;
  let fixture: ComponentFixture<DashboardCommandeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashboardCommandeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardCommandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
