import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstituitionProfileComponent } from './instituition-profile.component';

describe('InstituitionProfileComponent', () => {
  let component: InstituitionProfileComponent;
  let fixture: ComponentFixture<InstituitionProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InstituitionProfileComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(InstituitionProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
