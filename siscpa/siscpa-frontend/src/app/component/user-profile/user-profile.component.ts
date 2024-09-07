import { Component } from '@angular/core';
import { NavbarComponent } from '../shared/navbar/navbar.component';
import { RouterLink } from '@angular/router';
import { FooterComponent } from '../shared/footer/footer.component';

@Component({
  selector: 'app-user-profile',
  standalone: true,
  imports: [NavbarComponent, RouterLink, FooterComponent],
  templateUrl: './user-profile.component.html',
  styleUrl: './user-profile.component.css'
})
export class UserProfileComponent {

}
