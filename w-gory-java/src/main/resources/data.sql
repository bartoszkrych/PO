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
(91,'Bażantowice','Jesioniowa'),
(92,'Jesioniowa','Bażantowice'),
(93,'Dzięgielów - Zamek','Bażantowice'),
(94,'Bażantowice','Dzięgielów - Zamek');

INSERT INTO trasa_wlasna (dlugosc, nazwa, opis, przewyzszenie, trasa_wlasna_id) VALUES
(1890,'Moja trasa 1','Bylem tu i tam, widzialem to, a dozedlem tam',551,95);

-- ADD TRASY TO JOINED TABLE
INSERT INTO odcinek_trasy(id,punkty) values
(91,2),
(92,2),
(93,5),
(94,3),
(95,7);

-- ADD WYCIECZKA WITH ODZNAKA
INSERT INTO odznaka_turysty (id, czy_normy_spelnione, czy_zdobyta, data_rozpoczecia, data_zdobycia) VALUES
(97,0,0,'2019-12-10 00:00:00.000', null);

INSERT INTO wycieczka (id, data_utworzenia, nazwa , planowana_data , status , odznaka_turysty_id) VALUES
(98, '2019-12-20 00:00:00.000','Moja wycieczka na swieta', '2019-12-24 00:00:00.000','Zaplanowana',97);

-- ADD ONE MORE  TRASA_WLASNA
INSERT INTO trasa_wlasna (dlugosc, nazwa, opis, przewyzszenie, trasa_wlasna_id) VALUES
(800,'Moja trasa 2', null ,151,96);

INSERT INTO odcinek_trasy(id,punkty) values
(96,2);

-- RELATION WYCIECZKA - ODCINKI
INSERT INTO odcinek_wycieczki (odcinek_trasy_id, wycieczka_id,czy_odbyta) VALUES
(96,98,1),(93,98,1),(91,98,0),(95,98,1);

INSERT INTO wycieczka_odcinki_wycieczki (wycieczka_id, odcinki_wycieczki_odcinek_trasy_id, odcinki_wycieczki_wycieczka_id) VALUES
(98,96,98),(98,93,98),(98,91,98),(98,95,98);