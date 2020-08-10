import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonutCadastroComponent } from './donut-cadastro.component';

describe('DonutCadastroComponent', () => {
  let component: DonutCadastroComponent;
  let fixture: ComponentFixture<DonutCadastroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonutCadastroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonutCadastroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
