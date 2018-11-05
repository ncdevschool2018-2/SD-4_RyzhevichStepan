import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {StudentListComponent} from "./student-list/student-list.component";
import {HttpClientModule} from "@angular/common/http";
import {ModalModule} from "ngx-bootstrap/modal";
import {BsDropdownModule, TooltipModule} from "ngx-bootstrap";
import {FormsModule} from "@angular/forms";
import {HeaderComponent} from "./header/header.component";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {ProfessorListComponent} from "./professor-list/professor-list.component";


@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    ProfessorListComponent,
    HeaderComponent,

  ],
  imports: [
    NgbModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ModalModule.forRoot(),
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent, HeaderComponent]
})
export class AppModule { }
