import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ZatwierdzenieWycieczkiComponent } from './component/zatwierdzenie-wycieczki/zatwierdzenie-wycieczki.component';


const routes: Routes = [
  {path:'wycieczki', component: ZatwierdzenieWycieczkiComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
