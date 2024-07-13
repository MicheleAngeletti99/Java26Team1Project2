create database progetto_ristorante;

# Creazione tabella bevande
create table bevande (
id INT primary key auto_increment,
menu_id INT,
nome VARCHAR(50) not null,
prezzo DECIMAL(10,2) not null,
descrizione VARCHAR(255),
ingredienti VARCHAR(255),
anno_di_produzione INT,
certificazione_DOP BOOL
);
# La chiave esterna funziona solo se esiste la tabella menu
alter table bevande
add foreign key (menu_id) references menu(id);
# Inserimento dati nella tabella bevande
insert into bevande (nome, prezzo, descrizione, ingredienti, anno_di_produzione, certificazione_DOP)
values ('Acqua',1.00,'bottiglia da 1l naturale o frizzante','acqua con sali di sodio, potassio, calcio, magnesio',2024,false),
       ('Vino bianco',9.90,'bottiglia da 0,75l di Passerina','uva da vitigni a bacca bianca del sud delle Marche',2018,true),
       ('Vino rosso',9.90,'bottiglia da 0,75l di Rosso Piceno','uva da vitigni di Montepulciano e Sangiovese',2015,true),
       ('Coca cola',0.95,'lattina da 33cl di coca cola','acqua, anidride carbonica, zucchero, colorante caramello (E 150D), aromi naturali, caffeina e acido fosforico (E 338)',2024,false),
       ('Aranciata',3.50,'Spremuta di arancia frizzante','Arancia zucchero e anidride carbonica',2024,false);
# Aggiungo le bevande al primo menu
update bevande 
set menu_id = 1
where id in (1,2,3,4,5);
# Modifico il prezzo del Vino rosso
update bevande 
set prezzo = 10.50
where nome like 'Vino rosso';

# Creazione tabella clienti
create table clienti (
id INT primary key auto_increment,
nome VARCHAR(50) not null,
cognome VARCHAR(50) not null
);
# Inserimento dati nella tabella clienti
insert into clienti (nome, cognome)
values ('Alberto','Pippa'),
       ('Ludmilla','Santo'),
       ('Francesco','Cavaleri'),
       ('Paolo','Vecchione'),
       ('Rosalia','Rocca'),
       ('Iresha','Warnakulasuriya'),
       ('Michele','Angeletti'),
       ('Riccardo','Cavaleri'),
       ('Andrea','Vecchione'),
       ('Santo','La Rocca');