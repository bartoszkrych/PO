-- ADD TEREN, OBSZAR, MIEJSCE
INSERT INTO teren (nazwa,numer) VALUES ('Beskid Śląski', 1);
INSERT INTO teren (nazwa,numer) VALUES ('Beskid Żywiecki', 2);

INSERT INTO obszar (symbol,nazwa) VALUES ('BZ', 'BESKIDY ZACHODNIE');

INSERT INTO miejsce VALUES('Dzięgielów - Zamek','BZ','Beskid Śląski'); /* 2/2 */
INSERT INTO miejsce VALUES('Jesioniowa','BZ','Beskid Śląski'); /* 5/3 */

INSERT INTO miejsce VALUES('Bażantowice','BZ','Beskid Śląski');

-- RELATION TEREN-OBSZAR
INSERT INTO obszar_tereny (obszar_symbol,tereny_nazwa) VALUES ('BZ','Beskid Śląski');
INSERT INTO obszar_tereny (obszar_symbol,tereny_nazwa) VALUES ('BZ','Beskid Żywiecki');

-- ADD TRASY
INSERT INTO trasa_punktowana (trasa_punktowana_id, poczatek_nazwa,  koniec_nazwa) VALUES
(1,'Bażantowice','Jesioniowa'),
(2,'Jesioniowa','Bażantowice'),
(3,'Dzięgielów - Zamek','Bażantowice'),
(4,'Bażantowice','Dzięgielów - Zamek');

INSERT INTO trasa_wlasna (dlugosc, nazwa, opis, przewyzszenie, trasa_wlasna_id) VALUES
(1890,'Moja trasa 1','Bylem tu i tam, widzialem to, a dozedlem tam',551,5);

-- ADD TRASY TO JOINED TABLE
INSERT INTO odcinek_trasy(id,punkty) values
(1,2),
(2,2),
(3,5),
(4,3),
(5,7);

-- ADD WYCIECZKA WITH ODZNAKA
INSERT INTO odznaka_turysty (id, czy_normy_spelnione, czy_zdobyta, data_rozpoczecia, data_zdobycia) VALUES
(6,0,0,'2019-12-10 00:00:00.000', null);

INSERT INTO wycieczka (id, data_utworzenia, nazwa , planowana_data , status , odznaka_turysty_id) VALUES
(7, '2019-12-20 00:00:00.000','Moja wycieczka na swieta', '2019-12-24 00:00:00.000','Zaplanowana',6);

-- ADD ONE MORE  TRASA_WLASNA
INSERT INTO trasa_wlasna (dlugosc, nazwa, opis, przewyzszenie, trasa_wlasna_id) VALUES
(800,'Moja trasa 2', null ,151,8);

INSERT INTO odcinek_trasy(id,punkty) values
(8,2);

-- RELATION WYCIECZKA - ODCINKI
INSERT INTO odcinek_wycieczki (odcinek_trasy_id, wycieczka_id) VALUES
(8,7),(3,7),(1,7),(5,7);

INSERT INTO wycieczka_odcinki_wycieczki (wycieczka_id, odcinki_wycieczki_odcinek_trasy_id, odcinki_wycieczki_wycieczka_id) VALUES
(7,8,7),(7,3,7),(7,1,7),(7,5,7);