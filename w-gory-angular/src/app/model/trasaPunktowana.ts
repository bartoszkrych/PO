import { Miejsce } from './miejsce';
import { OdcinekTrasy } from './odcinekTrasy';

export class TrasaPunktowana extends OdcinekTrasy{
    punkty: number;
    
    poczatek: Miejsce;
    koniec: Miejsce;
}