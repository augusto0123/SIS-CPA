import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FooterComponent } from '../shared/footer/footer.component';
import { NavbarComponent } from '../shared/navbar/navbar.component';

@Component({
  selector: 'app-what-is-cpa',
  standalone: true,
  imports: [NavbarComponent, RouterLink, FooterComponent],
  templateUrl: './what-is-cpa.component.html',
  styleUrl: './what-is-cpa.component.css'
})
export class WhatIsCpaComponent {

}
