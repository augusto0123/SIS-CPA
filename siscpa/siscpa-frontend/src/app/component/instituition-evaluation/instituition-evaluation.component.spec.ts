import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstituitionEvaluationComponent } from './instituition-evaluation.component';

describe('InstituitionEvaluationComponent', () => {
  let component: InstituitionEvaluationComponent;
  let fixture: ComponentFixture<InstituitionEvaluationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InstituitionEvaluationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(InstituitionEvaluationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
