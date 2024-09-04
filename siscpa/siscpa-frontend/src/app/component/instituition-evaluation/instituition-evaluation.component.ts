import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FooterComponent } from '../shared/footer/footer.component';
import { NavbarComponent } from '../shared/navbar/navbar.component';

@Component({
  selector: 'app-instituition-evaluation',
  standalone: true,
  imports: [NavbarComponent, RouterLink, FooterComponent],
  templateUrl: './instituition-evaluation.component.html',
  styleUrl: './instituition-evaluation.component.css'
})
export class InstituitionEvaluationComponent {

}
