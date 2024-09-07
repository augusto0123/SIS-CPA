import { Component } from '@angular/core';
import { NavbarComponent } from '../shared/navbar/navbar.component';
import { RouterLink } from '@angular/router';
import { FooterComponent } from '../shared/footer/footer.component';

@Component({
  selector: 'app-instituition-sign-up',
  standalone: true,
  imports: [NavbarComponent, RouterLink, FooterComponent],
  templateUrl: './instituition-sign-up.component.html',
  styleUrl: './instituition-sign-up.component.css'
})
export class InstituitionSignUpComponent {

}
