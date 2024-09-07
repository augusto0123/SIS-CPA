import { Component } from '@angular/core';
import { NavbarComponent } from '../shared/navbar/navbar.component';
import { RouterLink } from '@angular/router';
import { FooterComponent } from '../shared/footer/footer.component';

@Component({
  selector: 'app-edit-profile',
  standalone: true,
  imports: [NavbarComponent, RouterLink, FooterComponent],
  templateUrl: './edit-profile.component.html',
  styleUrl: './edit-profile.component.css'
})
export class EditProfileComponent {

}
