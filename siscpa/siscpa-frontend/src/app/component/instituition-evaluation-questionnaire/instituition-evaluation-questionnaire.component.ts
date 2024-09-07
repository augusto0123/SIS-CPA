import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { NavbarComponent } from '../shared/navbar/navbar.component';
import { FooterComponent } from '../shared/footer/footer.component';

@Component({
  selector: 'app-instituition-evaluation-questionnaire',
  standalone: true,
  imports: [NavbarComponent, RouterLink, FooterComponent],
  templateUrl: './instituition-evaluation-questionnaire.component.html',
  styleUrl: './instituition-evaluation-questionnaire.component.css'
})
export class InstituitionEvaluationQuestionnaireComponent {

}
