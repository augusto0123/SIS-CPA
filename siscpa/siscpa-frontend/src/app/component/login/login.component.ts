import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FooterComponent } from '../shared/footer/footer.component';
import { NavbarComponent } from '../shared/navbar/navbar.component';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [NavbarComponent, RouterLink, FooterComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  ngOnInit(){

  }
}
