import { OdcinekTrasy } from './odcinekTrasy';

export class TrasaWlasna implements OdcinekTrasy {
    id: number;
    nazwa: string;
    opis: string;
    przewyzszenie: number;
    dlugosc: number;
    punkty: number;
}