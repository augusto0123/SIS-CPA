import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FooterComponent } from '../footer/footer.component';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterLink, NavbarComponent, FooterComponent],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit {
  ngOnInit(){
    
  }
}
