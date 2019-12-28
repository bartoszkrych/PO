import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ZatwierdzenieWycieczkiComponent } from './component/zatwierdzenie-wycieczki/zatwierdzenie-wycieczki.component';
import { TworzenieTrasyPunktowanejComponent } from './component/tworzenie-trasy-punktowanej/tworzenie-trasy-punktowanej.component';


const routes: Routes = [
  {path:'wycieczki', component: ZatwierdzenieWycieczkiComponent},
  {path:'trasy-punktowane', component: TworzenieTrasyPunktowanejComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
