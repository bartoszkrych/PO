import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WycieczkaService } from 'src/app/controller/service/wycieczka.service';
import { Wycieczka } from 'src/app/model/wycieczka';
import { OdcinekTrasy } from 'src/app/model/odcinekTrasy';
import { TrasaWlasna } from 'src/app/model/trasaWlasna';
import { TrasaPunktowana } from 'src/app/model/trasaPunktowana';

@Component({
  selector: 'app-zatwierdzenie-wycieczki',
  templateUrl: './zatwierdzenie-wycieczki.component.html',
  styleUrls: ['./zatwierdzenie-wycieczki.component.css']
})
export class ZatwierdzenieWycieczkiComponent implements OnInit {

  wycieczka : Wycieczka;
  odcinki: Array<OdcinekTrasy>;
  odcinkiW: TrasaWlasna[];
  odcinkiP: TrasaPunktowana[];
  id: number;

  constructor(private route: ActivatedRoute, private router: Router, private wycieczkaService: WycieczkaService) { }

  ngOnInit() {
    this.wycieczka = new Wycieczka();
    //this.id = this.route.snapshot.params['id'];
    this.id = 2;
    this.wycieczkaService.getWycieczkaById(this.id)
    .subscribe(w => {
      this.wycieczka = w;
      let odcinkiWycieczki = w.odcinkiWycieczki;
      this.odcinki = new Array(odcinkiWycieczki.length);
      for (let i = 0 ; i < w.odcinkiWycieczki.length; i++)
      {
        this.odcinki[i] = odcinkiWycieczki[i].odcinekTrasy;
      }
    },
    error => console.log(error));
  }

  setDone(){
    if(this.wycieczka.planowanaData.getTime > Date.now)
      this.wycieczkaService.setWycieczkaDone(this.id);
        
  }

}
