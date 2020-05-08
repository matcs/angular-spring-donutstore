import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateSaborComponent } from './update-sabor.component';

describe('UpdateSaborComponent', () => {
  let component: UpdateSaborComponent;
  let fixture: ComponentFixture<UpdateSaborComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateSaborComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateSaborComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
