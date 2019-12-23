import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WycieczkaService } from 'src/app/controller/service/wycieczka.service';
import { Wycieczka } from 'src/app/model/wycieczka';
import { OdcinekWycieczki } from 'src/app/model/odcinekWycieczki';
import { OdcinekTrasy } from 'src/app/model/odcinekTrasy';

@Component({
  selector: 'app-zatwierdzenie-wycieczki',
  templateUrl: './zatwierdzenie-wycieczki.component.html',
  styleUrls: ['./zatwierdzenie-wycieczki.component.css']
})
export class ZatwierdzenieWycieczkiComponent implements OnInit {

  wycieczka : Wycieczka;
  odcinki: OdcinekTrasy[];
  id: number;

  constructor(private route: ActivatedRoute, private router: Router, private wycieczkaService: WycieczkaService) { }

  ngOnInit() {
    this.wycieczka = new Wycieczka();
    this.id = this.route.snapshot.params['id'];

    this.wycieczkaService.getWycieczkaById(this.id)
    .subscribe(w => {
      this.wycieczka = w;
      for (let o of w.odcinkiWycieczki)
      {
        this.odcinki.push(o.odcinekTrasy);
      }
    },
    error => console.log(error));
  }

  setDone(){
    if(this.wycieczka.planowanaData.getTime > Date.now)
      this.wycieczkaService.setWycieczkaDone(this.id);
        
  }

}
