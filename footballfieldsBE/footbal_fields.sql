CREATE DATABASE IF NOT EXISTS footballFields;

CREATE TABLE IF NOT EXISTS features(
    id INT AUTO_INCREMENT PRIMARY KEY,
    indoor BOOLEAN,
    heating BOOLEAN,
    ac BOOLEAN,
    id_fields int
);

CREATE TABLE IF NOT EXISTS fields(
     id INT AUTO_INCREMENT PRIMARY KEY,
     open VARCHAR(5),  
     close VARCHAR(5)    
);

ALTER TABLE features
ADD FOREIGN KEY (id_fields) REFERENCES field(id);

CREATE TABLE IF NOT EXISTS associate(
    id INT AUTO_INCREMENT PRIMARY KEY,
    first VARCHAR(20),
    last VARCHAR(20),
    mobile VARCHAR(20),
    id_fields INT   
);

ALTER TABLE associate
ADD FOREIGN KEY (id_fields) REFERENCES fields(id);


CREATE TABLE IF NOT EXISTS field(
    id INT AUTO_INCREMENT PRIMARY KEY,    
    id_fields int
);

ALTER TABLE field
ADD FOREIGN KEY (id_fields) REFERENCES fields(id);

CREATE TABLE IF NOT EXISTS booking(
    id int AUTO_INCREMENT PRIMARY KEY,
    time VARCHAR(5),
    id_field INT,
    id_associate INT
);

ALTER TABLE booking
ADD FOREIGN KEY (id_associate) REFERENCES associate(id),
ADD FOREIGN KEY (id_field) REFERENCES field(id);

-- desc nome tabella , serve per mostrare a video i campi della tabella
-- drop nome tabella, serve per cancellare la tabella
-- truncate tabella, serve per svuotare la tabella

-- cancella una colonna dalla tabella
ALTER TABLE fields DROP COLUMN id_associate;

alter table features
add column id_fields int;


alter table features
add FOREIGN KEY (id_fields) REFERENCES fields(id);

alter table field
add FOREIGN KEY (id_fields) REFERENCES fields(id);

insert into fields(name, open, close)
values ('Napoli Football Club', "14:30", "23:30");

insert into associate(first, last, mobile, id_fields)
value("Genny", "Sava", "33344455660", 1);

insert into associate(first, last, mobile, id_fields)
value("Remo", "Smith", "3337778899", 1);

insert into associate(first, last, mobile, id_fields)
value("Ugo", "Fioretti", "3331112244", 1);

insert into associate(first, last, mobile, id_fields)
value("Mario", "Rossi", "3338889911", 1);

insert into field(id_fields)
value(1);

insert into booking(time, id_field, id_associate)
values("16:30", 1, 1);
values("14:30", 3, 2);
values("15:30", 3, 3);
values("20:30", 2, 1);
values("22:30", 4, 4);
values("15:30", 1, 5);



--selezione nome, cognome associato loggato
select first, last
from login l, associate a
where l.id_associate = a.id
and l.user_name = "rino5"
and l.password = "rinorino";

--seleziono nome, cognome , n.ro campo e orario prenotazione
select first, last, id_field, time
from login l, associate a, booking b
where l.id_associate = a.id
and l.user_name = "rino5"
and l.password = "rinorino"
and b.id_associate = a.id;

--visualizzo nome amministratore
select FIRST, LAST
FROM login l, associate a
WHERE l.id_associate = a.id 
and l.user_name = "admin2"
and l.password = "admin"
AND l.ruolo = "admin";