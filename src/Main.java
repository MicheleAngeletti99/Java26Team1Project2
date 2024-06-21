import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Portata fiorentina = new Secondi("Fiorentina", 17.48, "bella bisteccona", "fassona, contorno1",Cottura.ALSANGUE);
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
        List<Portata> listaPortate = new ArrayList<>(Arrays.asList(antipasto1, antipasto2, antipasto3, primi1, primi2, primi3,
                fiorentina, pollo, maiale, tiramisu, cheeseCake, chocolateFudge, acqua, vinoBianco, vinoRosso, cocaCola));
        Menu menuCarne = new Menu("di carne", listaPortate);
        menuCarne.aggiungiPortata(new Antipasti("Patatine Fritte", 3.50, "patate lavate e fritte", "patate", "Patate originarie del Piemonte"));
        menuCarne.aggiungiPortata(new Primi("Aglio e olio", 18.89, "Pasta aglio, olio e peperoncino", "Pasta di grano duro, aglio, olio, peperoncino","Pentola", "Lazio"));
        menuCarne.aggiungiPortata(new Secondi("Gulasch", 25.99,"Stufato di carne","Carne e spezie varie",Cottura.BENCOTTA));
        menuCarne.aggiungiPortata(new Desserts("Torta al cioccolato", 5.70, "Torta al cioccolato al forno", "Uova burro cioccolato e farina", false));
        menuCarne.aggiungiPortata(new Bevande("Aranciata", 3.50, "Spremuta di arancia frizzante", "Arancia zucchero e anidridecarbonica", 2024, false) );
        menuCarne.stampaMenu();

        // Ristorante
        Ristorante ristorantePatona = new Ristorante("Patona", "Palermo");
        ristorantePatona.aggiungiMenu(menuCarne);
    }
}
