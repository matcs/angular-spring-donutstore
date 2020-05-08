import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsSaborComponent } from './details-sabor.component';

describe('DetailsSaborComponent', () => {
  let component: DetailsSaborComponent;
  let fixture: ComponentFixture<DetailsSaborComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsSaborComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsSaborComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
