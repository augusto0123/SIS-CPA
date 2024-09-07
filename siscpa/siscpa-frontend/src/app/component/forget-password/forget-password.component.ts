import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FooterComponent } from '../shared/footer/footer.component';
import { NavbarComponent } from '../shared/navbar/navbar.component';

@Component({
  selector: 'app-forget-password',
  standalone: true,
  imports: [NavbarComponent, RouterLink, FooterComponent],
  templateUrl: './forget-password.component.html',
  styleUrl: './forget-password.component.css'
})
export class ForgetPasswordComponent {

}
