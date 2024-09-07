import { Component, OnInit } from '@angular/core';
import { NavbarComponent } from '../shared/navbar/navbar.component';
import { RouterLink } from '@angular/router';
import { FooterComponent } from '../shared/footer/footer.component';

@Component({
  selector: 'app-register-institution',
  standalone: true,
  imports: [NavbarComponent, RouterLink, FooterComponent],
  templateUrl: './register-institution.component.html',
  styleUrl: './register-institution.component.css'
})
export class RegisterInstitutionComponent implements OnInit {
  ngOnInit(){

  }
}
