import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FooterComponent } from '../shared/footer/footer.component';
import { NavbarComponent } from '../shared/navbar/navbar.component';

@Component({
  selector: 'app-instituition-list',
  standalone: true,
  imports: [ RouterLink, NavbarComponent, FooterComponent],
  templateUrl: './instituition-list.component.html',
  styleUrl: './instituition-list.component.css'
})
export class InstituitionListComponent {

}
