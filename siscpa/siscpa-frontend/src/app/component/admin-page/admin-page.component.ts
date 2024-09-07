import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FooterComponent } from '../shared/footer/footer.component';
import { NavbarComponent } from '../shared/navbar/navbar.component';

@Component({
  selector: 'app-admin-page',
  standalone: true,
  imports: [NavbarComponent, RouterLink, FooterComponent],
  templateUrl: './admin-page.component.html',
  styleUrl: './admin-page.component.css'
})
export class AdminPageComponent {

}
