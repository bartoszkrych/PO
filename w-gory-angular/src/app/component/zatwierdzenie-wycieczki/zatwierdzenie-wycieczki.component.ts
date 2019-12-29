import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WycieczkaService } from 'src/app/controller/service/wycieczka.service';
import { Wycieczka } from 'src/app/model/wycieczka';
import { OdcinekTrasy } from 'src/app/model/odcinekTrasy';

import { Location } from '@angular/common';

@Component({
  selector: 'app-zatwierdzenie-wycieczki',
  templateUrl: './zatwierdzenie-wycieczki.component.html',
  styleUrls: ['./zatwierdzenie-wycieczki.component.css']
})
export class ZatwierdzenieWycieczkiComponent implements OnInit {

  wycieczka: Wycieczka;
  odcinki: Array<OdcinekTrasy>;
  id: number;
  message: string;
  isApproved: boolean;

  constructor(private route: ActivatedRoute, private router: Router,
    private wycieczkaService: WycieczkaService, private _location: Location) { }

  ngOnInit() {
    this.isApproved = false;

    this.wycieczka = new Wycieczka();
    //this.id = this.route.snapshot.params['id'];
    this.id = 98;
    this.wycieczkaService.getWycieczkaById(this.id)
      .subscribe(w => {
        this.wycieczka = w;
        let odcinkiZWycieczki = w.odcinkiWycieczki;
        this.odcinki = new Array(odcinkiZWycieczki.length);
        for (let i = 0; i < odcinkiZWycieczki.length; i++) {
          this.odcinki[i] = odcinkiZWycieczki[i].odcinekTrasy;
        }
      },
        error => console.log(error));
  }

  setDone() {
    let dateNow: Date = new Date();
    let plan: Date = new Date(this.wycieczka.planowanaData);
    if (plan.getTime() < dateNow.getTime()) {
      this.wycieczkaService.setWycieczkaDone(this.id).subscribe(a => {
        if (a != null && this.wycieczka.status == 'Zaplanowana') this.message = `Zdobyłeś: ${this.wycieczka.punktyWycieczki}pkt!`;
        else this.message = "Coś poszło nie tak.\nSpróbuj później.";
      });
    }
    else {
      this.message = `Jeszcze nie odbyłeś\ntej wycieczki!`;
    }
    this.isApproved = true;
  }


  backClicked() {
    this._location.back();
  }
}
