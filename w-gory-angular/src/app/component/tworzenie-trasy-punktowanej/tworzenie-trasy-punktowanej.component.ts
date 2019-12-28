import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MiejsceService } from 'src/app/controller/service/miejsce.service';
import { TrasaPunktowanaService } from 'src/app/controller/service/trasa-punktowana.service';

import { Location } from '@angular/common';
import { TrasaPunktowana } from 'src/app/model/trasaPunktowana';
import { Miejsce } from 'src/app/model/miejsce';
import { Teren } from 'src/app/model/teren';
import { Obszar } from 'src/app/model/obszar';

@Component({
  selector: 'app-tworzenie-trasy-punktowanej',
  templateUrl: './tworzenie-trasy-punktowanej.component.html',
  styleUrls: ['./tworzenie-trasy-punktowanej.component.css']
})
export class TworzenieTrasyPunktowanejComponent implements OnInit {

  trasaPunktowana: TrasaPunktowana;
  miejsca: Array<Miejsce>;
  miejsca_p: Array<Miejsce>;
  miejsca_k: Array<Miejsce>;
  tereny_p: Array<Teren>;
  tereny_k: Array<Teren>;
  obszary: Array<Obszar>;
  message: string;
  isApproved: boolean;

  constructor(private route: ActivatedRoute, private router: Router, private miejsceService: MiejsceService,
    private trasaPunktowanaService: TrasaPunktowanaService, private _location: Location) { }

  ngOnInit() {
    this.isApproved = false;
    this.trasaPunktowana = new TrasaPunktowana();
    this.trasaPunktowana.punkty = 0;
    this.miejsca = new Array();
    this.miejsca_p = new Array();
    this.miejsca_k = new Array();
    this.tereny_p = new Array();
    this.tereny_k = new Array();
    this.obszary = new Array();
    this.miejsceService.getAllMiejsca().subscribe(data => {
      this.miejsca = data;
      for (let m of data) {
        let index = this.obszary.findIndex(o => o.symbol === m.obszarGorski.symbol);

        if (index < 0) {
          this.obszary.push(m.obszarGorski);
        }
      }
      this.callObszar(this.obszary[0].nazwa);
      this.callMiejsceP(this.miejsca_p[0].nazwa);
    })
  }

  callObszar(obszar) {
    let index = this.obszary.findIndex(o => o.nazwa === obszar);
    this.tereny_p = this.obszary[index].tereny;
    this.tereny_k = this.obszary[index].tereny;
    this.callTerenP(this.tereny_p[0].nazwa);
    this.callTerenK(this.tereny_p[0].nazwa);
  }

  callTerenP(teren) {
    let index = this.tereny_p.findIndex(tp => tp.nazwa === teren);
    this.miejsca_p.length = 0;
    for (let m of this.miejsca) {
      if (m.terenGorski.nazwa === teren)
        this.miejsca_p.push(m);
    }
  }

  callTerenK(teren) {
    let index = this.tereny_p.findIndex(tp => tp.nazwa === teren);
    this.miejsca_k.length = 0;
    for (let m of this.miejsca) {
      if (m.terenGorski.nazwa === teren)
        this.miejsca_k.push(m);
    }
  }

  callMiejsceP(miejsce) {
    this.miejsca_k = Object.assign([], this.miejsca_p);
    let index = this.miejsca_k.findIndex(m => m.nazwa === miejsce);
    if (index > -1) {
      this.miejsca_k.splice(index, 1);
    }
    this.trasaPunktowana.poczatek = this.miejsca_p[index];
    this.trasaPunktowana.koniec = this.miejsca_k[0];
  }

  callMiejsceK(miejsce) {
    let index = this.miejsca_k.findIndex(m => m.nazwa === miejsce);
    this.trasaPunktowana.koniec = this.miejsca_k[index];
  }

  addTrasaPunkt() {
    if(this.trasaPunktowana.punkty != null)
    {
      this.trasaPunktowanaService.addTrasaPunkt(this.trasaPunktowana).subscribe(a => {
        if (a != null) this.message = "Dodano nową\ntrase punktowaną."
        else this.message = "Już istnieje taka\n trasa punktowana."
      });
      this.isApproved = true;
    }
  }

  backClicked() {
    this._location.back();
  }
}

