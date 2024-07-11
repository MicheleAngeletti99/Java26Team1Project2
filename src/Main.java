import enumarazioni.Colori;
import enumarazioni.Cottura;
import enumarazioni.TipoChef;
import enumarazioni.TipoMenu;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Antipasti
        Portata antipasto1 = new Antipasti("Bruschette", 5.99, "pane tostato e pomodoro", "pane, pomodoro, olio, aglio","Pomodori e aglio originari dalla Sicilia, pane di nostra produzione");
        Portata antipasto2 = new Antipasti("Misto caldo", 8.99, "patatine fritte, arancine fritte e panelle fritte", "patate, farina di ceci, palle di riso fritte","Prodotti originari dal tipo streetFood Siciliano");
        Portata antipasto3 = new Antipasti("Polenta fritta", 10.55, "polenta fritta servita con funghi", "farina di mais e funghi", "Prodotti e tipo di piatto originario dalla Toscana");

        //Primi
        Portata primi1 = new Primi("Carbonara", 30.99, "Guanciale come sempre", "Uova,guanciale,pecorino a sentimento", "Pentola", "Firenze");
        Portata primi2 = new Primi("Bolognese", 15.51, "Ragù bono", "Ragù alla bolognese", "Pentola", "Calabria");
        Portata primi3 = new Primi("Genovese", 14.00, "pasta con cipolle e carne", "Cipolle, carne","Pentola", "Sicilia");


        // Secondi
        Portata fiorentina = new Secondi("Fiorentina", 17.48, "bella bisteccona", "fassona, contorno1", Cottura.ALSANGUE);
        Portata pollo = new Secondi("Pollo", 13.67, "pieno di proteine", "Pollo, Patate", Cottura.MEDIA);
        Portata maiale = new Secondi("Maiale", 23.15, "carne grassa", "Costate, Contorno2", Cottura.BENCOTTA);

        // desserts
        Portata tiramisu = new Desserts("Tiramisu", 3.99, "dessert, di origine italiana", "ladyfingers (savoiardi), egg yolks, sugar, coffee, mascarpone and cocoa powder." , false);
        Portata cheeseCake = new Desserts("CheeseCake", 4.00, "un dolce a base di formaggio fresco a pasta molle", " eggs, and sugar. It may have a crust or base made from crushed cookies (or digestive biscuits), graham crackers, pastry, or sometimes sponge cake.", true);
        Portata chocolateFudge = new Desserts("Chocolate Fudge", 5.00, "a dense, rich confection", "sugar, milk or cream, butter and chocolate or other flavorings.", false);

        // Bevande
        Portata acqua = new Bevande("Acqua", 1.0, "bottiglia da 1l naturale o frizzante", "acqua con sali di sodio, potassio, calcio, magnesio", 2024, false);
        Portata vinoBianco = new Bevande("Vino bianco", 9.90, "bottiglia da 0,75l di Passerina", "uva da vitigni a bacca bianca del sud delle Marche", 2018, true);
        Portata vinoRosso = new Bevande("Vino rosso", 9.90, "bottiglia da 0,75l di Rosso Piceno", "uva da vitigni di Montepulciano e Sangiovese", 2015, true);
        Portata cocaCola = new Bevande("Coca cola", 0.95, "lattina da 33cl di coca cola", "acqua, anidride carbonica, zucchero, colorante caramello (E 150D), aromi naturali, caffeina e acido fosforico (E 338)", 2024, false);

        // Menu
        Menu menuCarne = new Menu(TipoMenu.CARNE);
        //Antipasti
        menuCarne.aggiungiPortata(antipasto1);
        menuCarne.aggiungiPortata(antipasto2);
        menuCarne.aggiungiPortata(antipasto3);
        menuCarne.aggiungiPortata(new Antipasti("Patatine Fritte", 3.50, "patate lavate e fritte", "patate", "Patate originarie del Piemonte"));
        menuCarne.modificaPrezzo(antipasto1, 4.50);
        //Primi
        menuCarne.aggiungiPortata(primi1);
        menuCarne.aggiungiPortata(primi2);
        menuCarne.aggiungiPortata(primi3);
        menuCarne.aggiungiPortata(new Primi("Aglio e olio", 18.89, "Pasta aglio, olio e peperoncino", "Pasta di grano duro, aglio, olio, peperoncino","Pentola", "Lazio"));
        menuCarne.modificaPrezzo(primi1, 8.30);
        //Secondi
        menuCarne.aggiungiPortata(fiorentina);
        menuCarne.aggiungiPortata(pollo);
        menuCarne.aggiungiPortata(maiale);
        menuCarne.aggiungiPortata(new Secondi("Gulasch", 25.99,"Stufato di carne","Carne e spezie varie",Cottura.BENCOTTA));
        menuCarne.modificaPrezzo(pollo, 7.50);

        //Dessert
        menuCarne.aggiungiPortata(tiramisu);
        menuCarne.aggiungiPortata(cheeseCake);
        menuCarne.aggiungiPortata(chocolateFudge);
        menuCarne.aggiungiPortata(new Desserts("Torta al cioccolato", 5.70, "Torta al cioccolato al forno", "Uova burro cioccolato e farina", false));
        menuCarne.modificaPrezzo(tiramisu, 6.55);
        //Bevande
        menuCarne.aggiungiPortata(acqua);
        menuCarne.aggiungiPortata(vinoBianco);
        menuCarne.aggiungiPortata(vinoRosso);
        menuCarne.aggiungiPortata(cocaCola);
        menuCarne.aggiungiPortata(new Bevande("Aranciata", 3.50, "Spremuta di arancia frizzante", "Arancia zucchero e anidridecarbonica", 2024, false) );
        menuCarne.modificaPrezzo(vinoRosso, 10.50);

        // Ristorante Patona
        Ristorante ristorantePatona = new Ristorante("Patona", "Palermo", 30, TipoChef.Riccardo);

        //Stampa menu carne del ristorante Patona
        ristorantePatona.aggiungiMenu(menuCarne);
        ristorantePatona.stampaTipoMenu(TipoMenu.CARNE);

        // Stampa menu completo del ristorante Patona
        ristorantePatona.stampaDettagliRistorante();
        ristorantePatona.stampaMenuCompleto();

        // aggiungo clienti
        Cliente alberto = new Cliente("Alberto", "Pippa");
        Cliente ludmilla = new Cliente("Ludmilla", "Santo");
        Cliente francesco = new Cliente("Francesco", "cavaleri");
        Cliente paolo = new Cliente("Paolo", "Vecchione");
        Cliente roselia = new Cliente("Rosalia", "Rocca");

        // aggiungo prenotazioni
        Prenotazione prenotazioneAlberto = new Prenotazione(alberto, 11);
        Prenotazione prenotazioneLudmilla = new Prenotazione(ludmilla, 5);
        Prenotazione prenotazioneFrancesco = new Prenotazione(francesco, 10);
        Prenotazione prenotazionePaolo = new Prenotazione(paolo, 7);
        Prenotazione prenotazioneRoselia = new Prenotazione(roselia, 2);

        // creo la mappa per prenotazioni
        ristorantePatona.aggiungiPrenotazioni(prenotazioneAlberto);
        ristorantePatona.aggiungiPrenotazioni(prenotazioneLudmilla);
        ristorantePatona.aggiungiPrenotazioni(prenotazioneFrancesco);
        ristorantePatona.aggiungiPrenotazioni(prenotazionePaolo);
        ristorantePatona.aggiungiPrenotazioni(prenotazioneRoselia);

        // stampo la lista di prenotazioni
        ristorantePatona.stampaListaDiPrenotazioni();
        ristorantePatona.mostraCopertiDisponibili();
        //rimuovo un cliente
        ristorantePatona.rimuoviPrenotazione(prenotazioneFrancesco);


        //Ristorante Lumière
        Ristorante ristoranteLumiere = new Ristorante("Lumière" ,"Napoli",50,TipoChef.Michele);

        //Stampa menu del ristorante Lumière
        ristoranteLumiere.stampaDettagliRistorante();
        ristoranteLumiere.aggiungiMenu(menuCarne);
        ristoranteLumiere.stampaMenuCompleto();





        // aggiungo clienti
        Cliente iresha = new Cliente("Iresha", "Warnakulasuriya");
        Cliente michele = new Cliente("Michele", "Angeletti");
        Cliente riccardo = new Cliente("Riccardo", "cavaleri");
        Cliente andrea = new Cliente("Andrea", "Vecchione");
        Cliente santo = new Cliente("Santo", "Rocca");

        // aggiungo prenotazioni
        Prenotazione prenotazioneIresha = new Prenotazione(iresha, 3);
        Prenotazione prenotazioneMichele = new Prenotazione(michele, 10);
        Prenotazione prenotazioneRiccardo = new Prenotazione(riccardo, 2);
        Prenotazione prenotazioneAndrea = new Prenotazione(andrea, 7);
        Prenotazione prenotazioneSanto = new Prenotazione(santo, 10);

        // creo la mappa per prenotazioni
        ristoranteLumiere.aggiungiPrenotazioni(prenotazioneIresha);
        ristoranteLumiere.aggiungiPrenotazioni(prenotazioneMichele);
        ristoranteLumiere.aggiungiPrenotazioni(prenotazioneRiccardo);
        ristoranteLumiere.aggiungiPrenotazioni(prenotazioneAndrea);
        ristoranteLumiere.aggiungiPrenotazioni(prenotazioneSanto);

        // stampo la lista di prenotazioni
        ristoranteLumiere.stampaListaDiPrenotazioni();
        ristoranteLumiere.mostraCopertiDisponibili();

        //rimuovo un cliente
        ristoranteLumiere.rimuoviPrenotazione(prenotazioneAndrea);

        ristoranteLumiere.stampaListaDiPrenotazioni();


    }
}
