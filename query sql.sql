#creazione del database
create database progetto_ristorante;
#selezione del database su cui si lavora
use progetto_ristorante;


# creazione tabella ristorante
create table ristoranti(
id int primary key auto_increment,
nome varchar(255),
citta varchar(255),
tipo_chef enum('RICCARDO','IRESHA','ANDREA','SANTO','MICHELE'),
coperti_disponibili int
);

# aggiungi valori alla tabella ristorante
insert into ristoranti (nome,citta,coperti_disponibili,tipo_chef)
values ('Patona','Palermo',30,'RICCARDO'), ('Lumière','Napoli',50,'MICHELE');


#creo tabella menu
create table Menu(
Id int primary key auto_increment,
tipo_menu enum('CARNE','PESCE','VEGETARIANO','VEGANO','DELGIORNO','FINESETTIMANA','ORDINARIO','COMPLETO'),
ristorante_id int,
foreign key (ristorante_id) references ristoranti(id)
);

insert INTO Menu (tipo_menu, ristorante_id)
values('CARNE',1), ('CARNE',2);


#creazione tabella antipasti
create table Antipasti(
Id int primary key auto_increment,
nome varchar (255),
prezzo decimal (10,2),
descrizione varchar(255),
ingredienti varchar(255),
origine_prodotto varchar(255)
);
 
#creazione colonna per riferimento chiave esterna
alter table Antipasti 
add column menu_id int;

#chiave esterna
alter table Antipasti
add foreign key (menu_id) references menu(Id);

#inserisco valori all'interno di antipasti
insert into Antipasti (nome, prezzo, descrizione, ingredienti, origine_prodotto)
values  ('Bruschette',5.99,'pane tostato e pomodoro', 'pane, pomodoro, olio, aglio', 'Pomodori e aglio originari dalla Sicilia, pane di nostra produzione'),
		('Misto caldo',8.99,'patatine fritte, arancine fritte e panelle fritte','patate, farina di ceci, palle di riso fritte','Prodotti originari dal tipo streetFood Siciliano'),
  		('Polenta fritta',10.55,'polenta fritta servita con funghi','farina di mais e funghi','Prodotti e tipo di piatto originario dalla Toscana');
  	
#aggiungo una portata alla tabella		
insert INTO Antipasti (nome, prezzo, descrizione, ingredienti, origine_prodotto)
values('Patatine Fritte',3.50,'patate lavate e fritte','patate','Patate originarie del Piemonte');
 
#aggiorno il valore di menu id in base al tipo di menu scelto (1)
update antipasti
SET menu_id = 1
where id IN (1,2,3,4);

#inserisco gli antipasti nel secondo menu
insert into Antipasti (nome, prezzo, descrizione, ingredienti, origine_prodotto, menu_id)
values  ('Bruschette',5.99,'pane tostato e pomodoro', 'pane, pomodoro, olio, aglio', 'Pomodori e aglio originari dalla Sicilia, pane di nostra produzione',2),
		('Misto caldo',8.99,'patatine fritte, arancine fritte e panelle fritte','patate, farina di ceci, palle di riso fritte','Prodotti originari dal tipo streetFood Siciliano',2),
  		('Polenta fritta',10.55,'polenta fritta servita con funghi','farina di mais e funghi','Prodotti e tipo di piatto originario dalla Toscana',2),
        ('Patatine Fritte',3.50,'patate lavate e fritte','patate','Patate originarie del Piemonte',2);


#creazione tabella primi
create table Primi(
id int primary key auto_increment,
nome varchar (255),
prezzo decimal (10,2),
descrizione varchar (255),
ingredienti varchar (255),
cottura varchar (255),
regioneProvenienza varchar (255)
);

#creazione  colonna in riferimento alla chiave esterna
alter table primi
add column menu_id int;

#chiave esterna primi
alter table primi
add foreign key (menu_id) references menu(Id);

#inserisco valori all'interno dei primi
insert into Primi (nome,prezzo,descrizione,ingredienti,cottura,regioneProvenienza)
values ('Carbonara', 30.99, 'Guanciale come sempre', 'Uova,guanciale,pecorino a sentimento', 'Pentola', 'Firenze'),
       ('Bolognese', 15.51, 'Ragù bono', 'Ragù alla bolognese', 'Pentola', 'Calabria'),
       ('Genovese', 14.00, 'pasta con cipolle e carne', 'Cipolle, carne','Pentola', 'Sicilia');

# Aggiungo i primi piatti al primo menu
update primi
set menu_id = 1
where id in (1,2,3);

#inserisco i primi nel secondo menu
insert into Primi (nome,prezzo,descrizione,ingredienti,cottura,regioneProvenienza,menu_id)
values ('Carbonara', 30.99, 'Guanciale come sempre', 'Uova,guanciale,pecorino a sentimento', 'Pentola', 'Firenze',2),
       ('Bolognese', 15.51, 'Ragù bono', 'Ragù alla bolognese', 'Pentola', 'Calabria',2),
       ('Genovese', 14.00, 'pasta con cipolle e carne', 'Cipolle, carne','Pentola', 'Sicilia',2);


#creazione tabella secondi
create table secondi (
id INT primary key auto_increment,
menu_id INT,
nome VARCHAR(50) not null,
prezzo DECIMAL(10,2) not null,
descrizione VARCHAR(255),
ingredienti VARCHAR(255),
cottura ENUM('ALSANGUE','MEDIA','BENCOTTA'),
foreign key (menu_id) references menu(id)
);
#inserisco i dati nella tabella secondi
insert into secondi (nome, prezzo, descrizione, ingredienti, cottura)
values ('Fiorentina',17.48,'bella bisteccona','fassona, contorno1','ALSANGUE'),
       ('Pollo',13.67,'pieno di proteine','Pollo, Patate','MEDIA'),
       ('Maiale',23.15,'carne grassa','Costate, Contorno2','BENCOTTA'),
       ('Gulasch',25.99,'Stufato di carne','Carne e spezie varie','BENCOTTA');
#aggiungo i secondi al primo menu
update secondi
set menu_id = 1
where id in (1,2,3,4);
#inserisco i secondi nel secondo menu
insert into secondi (nome, prezzo, descrizione, ingredienti, cottura, menu_id)
values ('Fiorentina',17.48,'bella bisteccona','fassona, contorno1','ALSANGUE',2),
       ('Pollo',13.67,'pieno di proteine','Pollo, Patate','MEDIA',2),
       ('Maiale',23.15,'carne grassa','Costate, Contorno2','BENCOTTA',2),
       ('Gulasch',25.99,'Stufato di carne','Carne e spezie varie','BENCOTTA',2);


# creazione tabella desserts
create table desserts(
Id int primary key auto_increment,
menu_id INT,
foreign key (menu_id) references menu(id),
nome varchar (255),
prezzo decimal (10,2),
descrizione varchar(255),
ingredienti varchar(255),
glutenfree tinyint(0)
);

# inserire valori alla tabella dessert
insert into desserts(nome, prezzo, descrizione, ingredienti,glutenfree)
values( 'Tiramisu', 3.99, 'dessert, di origine italiana', 'ladyfingers (savoiardi), egg yolks, sugar, coffee, mascarpone and cocoa powder.',0),
('CheeseCake', 4.00, 'un dolce a base di formaggio fresco a pasta molle', 'eggs, and sugar. It may have a crust or base made from crushed cookies (or digestive biscuits), graham crackers, pastry, or sometimes sponge cake.',1),
('Chocolate Fudge', 5.00, 'a dense, rich confection', 'sugar, milk or cream, butter and chocolate or other flavorings.',0);

#aggiorno il valore di menu id in base al tipo di menu scelto (1)
update desserts
SET menu_id = 1
where id IN (1,2,3);

#inserisco i desserts nel secondo menu
insert into desserts(nome, prezzo, descrizione, ingredienti,glutenfree,menu_id)
values( 'Tiramisu', 3.99, 'dessert, di origine italiana', 'ladyfingers (savoiardi), egg yolks, sugar, coffee, mascarpone and cocoa powder.',0,2),
('CheeseCake', 4.00, 'un dolce a base di formaggio fresco a pasta molle', 'eggs, and sugar. It may have a crust or base made from crushed cookies (or digestive biscuits), graham crackers, pastry, or sometimes sponge cake.',1,2),
('Chocolate Fudge', 5.00, 'a dense, rich confection', 'sugar, milk or cream, butter and chocolate or other flavorings.',0,2);


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
# Inserisco le bevande nel secondo menu
insert into bevande (nome, prezzo, descrizione, ingredienti, anno_di_produzione, certificazione_DOP, menu_id)
values ('Acqua',1.00,'bottiglia da 1l naturale o frizzante','acqua con sali di sodio, potassio, calcio, magnesio',2024,false,2),
       ('Vino bianco',9.90,'bottiglia da 0,75l di Passerina','uva da vitigni a bacca bianca del sud delle Marche',2018,true,2),
       ('Vino rosso',9.90,'bottiglia da 0,75l di Rosso Piceno','uva da vitigni di Montepulciano e Sangiovese',2015,true,2),
       ('Coca cola',0.95,'lattina da 33cl di coca cola','acqua, anidride carbonica, zucchero, colorante caramello (E 150D), aromi naturali, caffeina e acido fosforico (E 338)',2024,false,2),
       ('Aranciata',3.50,'Spremuta di arancia frizzante','Arancia zucchero e anidride carbonica',2024,false,2);


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
  

# create table prenotazione
create table prenotazioni(
id int primary key auto_increment,
cliente_id int not null,
ristorante_id int not null,
numero_coperti int not null,
stato_prenotazione enum('INATTIVO','ATTIVO','RIMOSSO'),
foreign key (cliente_id) references clienti(id),
foreign key (ristorante_id) references ristoranti(id)
);
#inserimento dati nella tabella prenotazioni
insert into prenotazioni (cliente_id,ristorante_id,numero_coperti,stato_prenotazione)
values (1,1,11,'ATTIVO'),
	   (2,1,5,'ATTIVO'),
	   (3,1,10,'RIMOSSO'),
	   (4,1,7,'RIMOSSO'),
	   (5,1,2,'ATTIVO'),
	   (6,2,3,'ATTIVO'),
	   (7,2,10,'ATTIVO'),
	   (8,2,2,'ATTIVO'),
	   (9,2,7,'RIMOSSO'),
	   (10,2,10,'ATTIVO');