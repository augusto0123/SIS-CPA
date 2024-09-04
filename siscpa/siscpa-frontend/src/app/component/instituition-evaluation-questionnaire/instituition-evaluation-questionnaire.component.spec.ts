import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstituitionEvaluationQuestionnaireComponent } from './instituition-evaluation-questionnaire.component';

describe('InstituitionEvaluationQuestionnaireComponent', () => {
  let component: InstituitionEvaluationQuestionnaireComponent;
  let fixture: ComponentFixture<InstituitionEvaluationQuestionnaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InstituitionEvaluationQuestionnaireComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(InstituitionEvaluationQuestionnaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
