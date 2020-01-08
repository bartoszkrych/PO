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
  tereny: Array<Teren>;
  obszary: Array<Obszar>;
  message: string;
  isApproved: boolean;
  isClicked: boolean;

  constructor(private route: ActivatedRoute, private router: Router, private miejsceService: MiejsceService,
    private trasaPunktowanaService: TrasaPunktowanaService, private _location: Location) { }

  ngOnInit() {
    this.isApproved = false;
    this.trasaPunktowana = new TrasaPunktowana();
    this.trasaPunktowana.punkty = 0;
    this.miejsca = new Array();
    this.miejsca_p = new Array();
    this.miejsca_k = new Array();
    this.tereny = new Array();
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
    })
  }

  callObszar(obszar) {
    let index = this.obszary.findIndex(o => o.nazwa === obszar);
    this.tereny = this.obszary[index].tereny;
    this.callTerenP(this.tereny[0].nazwa);
    this.callTerenK(this.tereny[0].nazwa);
  }

  callTerenP(teren) {
    this.miejsca_p.length = 0;
    for (let m of this.miejsca) {
      if (m.terenGorski.nazwa === teren)
        this.miejsca_p.push(m);
    }
    this.trasaPunktowana.poczatek = this.miejsca_p[0];
  }

  callTerenK(teren) {
    this.miejsca_k.length = 0;
    for (let m of this.miejsca) {
      if (m.terenGorski.nazwa === teren)
        this.miejsca_k.push(m);
    }
    this.trasaPunktowana.koniec = this.miejsca_k[0];
  }

  callMiejsceP(miejsce) {
    let index = this.miejsca.findIndex(m => m.nazwa === miejsce);
    this.trasaPunktowana.poczatek = this.miejsca[index];
  }

  callMiejsceK(miejsce) {
    let index = this.miejsca.findIndex(m => m.nazwa === miejsce);
    this.trasaPunktowana.koniec = this.miejsca[index];
  }

  addTrasaPunkt() {
    if (this.trasaPunktowana.punkty && this.trasaPunktowana.koniec && this.trasaPunktowana.poczatek && this.trasaPunktowana.poczatek != this.trasaPunktowana.koniec) {
      console.log(this.trasaPunktowana);
      this.trasaPunktowanaService.addTrasaPunkt(this.trasaPunktowana).subscribe(a => {
        if (a != null) this.message = "Dodano nową\ntrase punktowaną."
      });
      this.isApproved = true;
    }
  }

  backClicked() {
    this._location.back();
  }
}

