import { Routes } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import path from 'path';
import { HomePageComponent } from './component/home-page/home-page.component';
import { register } from 'module';
import { RegisterInstitutionComponent } from './component/register-institution/register-institution.component';
import { RegisterComponent } from './component/register/register.component';
import { WhatIsCpaComponent } from './component/what-is-cpa/what-is-cpa.component';
import { InstituitionListComponent } from './component/instituition-list/instituition-list.component';
import { AboutUsComponent } from './component/about-us/about-us.component';
import { InstituitionProfileComponent } from './component/instituition-profile/instituition-profile.component';
import { InstituitionEvaluationComponent } from './component/instituition-evaluation/instituition-evaluation.component';
import { InstituitionEvaluationQuestionnaireComponent } from './component/instituition-evaluation-questionnaire/instituition-evaluation-questionnaire.component';
import { ForgetPasswordComponent } from './component/forget-password/forget-password.component';
import { UserProfileComponent } from './component/user-profile/user-profile.component';
import { EditProfileComponent } from './component/edit-profile/edit-profile.component';
import { InstituitionSignUpComponent } from './component/instituition-sign-up/instituition-sign-up.component';

export const routes: Routes = [
    {path:'login', component:LoginComponent},
    {path:'home-page', component:HomePageComponent},
    {path:'register', component:RegisterComponent},
    {path:'register-instituition', component:RegisterInstitutionComponent},
    {path:'what-is-cpa', component:WhatIsCpaComponent},
    {path:'instituition-list', component:InstituitionListComponent},
    {path:'about-us', component:AboutUsComponent},
    {path:'instituition-profile', component:InstituitionProfileComponent},
    {path:'instituition-evaluation', component:InstituitionEvaluationComponent},
    {path:'instituition-evaluation-questionnaire', component:InstituitionEvaluationQuestionnaireComponent},//empty
    {path:'user-profile', component:UserProfileComponent},
    {path:'forget-password', component:ForgetPasswordComponent},
    {path:'instituition-sign-up', component:InstituitionSignUpComponent},
    {path:'edit-profile', component:EditProfileComponent},
    {path:'**', redirectTo:'/login'}
];