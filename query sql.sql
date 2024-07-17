#creazione del database
create database progetto_ristorante;
#selezione del database su cui si lavora
use progetto_ristorante;



 #creo tabella menu
 create table Menu(
 Id int primary key auto_increment,
 tipo_menu enum('CARNE','PESCE','VEGETARIANO','VEGANO','DELGIORNO','FINESETTIMANA','ORDINARIO','COMPLETO')
 );
 insert INTO Menu (tipo_menu)
 values('CARNE');

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
  values('Bruschette',5.99,'pane tostato e pomodoro', 'pane, pomodoro, olio, aglio', 'Pomodori e aglio originari dalla Sicilia, pane di nostra produzione'),
  		('Misto caldo',8.99,'patatine fritte, arancine fritte e panelle fritte','patate, farina di ceci, palle di riso fritte','Prodotti originari dal tipo streetFood Siciliano'),
  		('Polenta fritta',10.55,'polenta fritta servita con funghi','farina di mais e funghi','Prodotti e tipo di piatto originario dalla Toscana');
  	
  #aggiungo una portata alla tabella		
  insert INTO Antipasti (nome, prezzo, descrizione, ingredienti, origine_prodotto)
  values('Patatine Fritte',3.50,'patate lavate e fritte','patate','Patate originarie del Piemonte');
 
#aggiorno il valore di menu id in base al tipo di menu scelto (1)
 update antipasti
 SET menu_id = 1
 where id IN (1,2,3,4);

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
 add foreign key (menu_id) references menu(Id)

 #inserisco valori all'interno dei primi
 insert into Primi (nome,prezzo,descrizione,ingredienti,cottura,regioneProvenienza)
 values ('Carbonara', 30.99, 'Guanciale come sempre', 'Uova,guanciale,pecorino a sentimento', 'Pentola', 'Firenze'),
        ('Bolognese', 15.51, 'Ragù bono', 'Ragù alla bolognese', 'Pentola', 'Calabria'),
        ('Genovese', 14.00, 'pasta con cipolle e carne', 'Cipolle, carne','Pentola', 'Sicilia');

 # Aggiungo i primi piatti al primo menu
 update primi
 set menu_id = 1
 where id in (1,2,3);
 
#creazione tabella per relazione N a N
create table Menu_Ristorante (
menu_id int not null,
ristorante_id int not null,
primary key (menu_id, ristorante_id),
foreign key (menu_id) references menu(id),
foreign key (ristorante_id) references ristoranti(id)
);