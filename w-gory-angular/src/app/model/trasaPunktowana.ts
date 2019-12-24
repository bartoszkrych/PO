import { Miejsce } from './miejsce';
import { OdcinekTrasy } from './odcinekTrasy';

export class TrasaPunktowana implements OdcinekTrasy{
    id: number;
    punkty: number;
    
    poczatek: Miejsce;
    koniec: Miejsce;
}