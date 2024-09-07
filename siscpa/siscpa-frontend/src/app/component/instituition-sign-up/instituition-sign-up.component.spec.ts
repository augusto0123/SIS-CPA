import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstituitionSignUpComponent } from './instituition-sign-up.component';

describe('InstituitionSignUpComponent', () => {
  let component: InstituitionSignUpComponent;
  let fixture: ComponentFixture<InstituitionSignUpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InstituitionSignUpComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(InstituitionSignUpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
