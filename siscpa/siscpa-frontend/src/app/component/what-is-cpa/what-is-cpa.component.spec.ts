import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WhatIsCpaComponent } from './what-is-cpa.component';

describe('WhatIsCpaComponent', () => {
  let component: WhatIsCpaComponent;
  let fixture: ComponentFixture<WhatIsCpaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WhatIsCpaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WhatIsCpaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
