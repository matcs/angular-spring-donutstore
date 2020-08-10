import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonutDetailsComponent } from './donut-details.component';

describe('DonutDetailsComponent', () => {
  let component: DonutDetailsComponent;
  let fixture: ComponentFixture<DonutDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonutDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonutDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
