import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroSaborComponent } from './cadastro-sabor.component';

describe('CadastroSaborComponent', () => {
  let component: CadastroSaborComponent;
  let fixture: ComponentFixture<CadastroSaborComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CadastroSaborComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroSaborComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
