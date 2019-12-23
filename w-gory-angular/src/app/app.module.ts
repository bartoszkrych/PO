import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MiejsceService } from './controller/service/miejsce.service';
import { TrasaPunktowanaService } from './controller/service/trasa-punktowana.service';
import { WycieczkaService } from './controller/service/wycieczka.service';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [MiejsceService, TrasaPunktowanaService, WycieczkaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
