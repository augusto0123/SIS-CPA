import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstituitionListComponent } from './instituition-list.component';

describe('InstituitionListComponent', () => {
  let component: InstituitionListComponent;
  let fixture: ComponentFixture<InstituitionListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InstituitionListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(InstituitionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
