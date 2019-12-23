import { OdznakaTurysty } from './odznakaTurysty';
import { OdcinekWycieczki } from './odcinekWycieczki';

export class Wycieczka{
    id: number;
    nazwa: string;
    planowanaData: Date;
    dataUtworzenia: Date;
    status: string;
    punktyWycieczki: number;

    odznakaTurysty: OdznakaTurysty;
    odcinkiWycieczki: OdcinekWycieczki;
}