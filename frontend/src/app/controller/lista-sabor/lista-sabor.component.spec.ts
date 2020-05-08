import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaSaborComponent } from './lista-sabor.component';

describe('ListaSaborComponent', () => {
  let component: ListaSaborComponent;
  let fixture: ComponentFixture<ListaSaborComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaSaborComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaSaborComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
