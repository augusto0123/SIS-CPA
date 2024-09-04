import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FooterComponent } from '../shared/footer/footer.component';
import { NavbarComponent } from '../shared/navbar/navbar.component';

@Component({
  selector: 'app-instituition-profile',
  standalone: true,
  imports: [NavbarComponent, RouterLink, FooterComponent],
  templateUrl: './instituition-profile.component.html',
  styleUrl: './instituition-profile.component.css'
})
export class InstituitionProfileComponent {

}
