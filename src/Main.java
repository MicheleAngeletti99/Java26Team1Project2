

public class Main {
    public static void main(String[] args) {
        //Antipasti
        Portata antipasto1 = new Antipasti("Bruschette", 5.99, "pane tostato e pomodoro", "pane, pomodoro, olio, aglio");
        Portata antipasto2 = new Antipasti("Misto caldo", 8.99, "patatine fritte, arancine fritte e panelle fritte", "patate, farina di ceci, palle di riso fritte");
        Portata antipasto3 = new Antipasti("Polenta fritta", 10.55, "polenta fritta servita con funghi", "farina di mais e funghi");

        //Primi
        Portata primi1 = new Primi("Carbonara", 30.99, "Guanciale come sempre", "Uova,guanciale,pecorino a sentimento");
        Portata primi2 = new Primi("Bolognese", 15.51, "Ragù bono", "Ragù alla bolognese");
        Portata primi3 = new Primi("Genovese", 14.00, "pasta con cipolle e carne", "Cipolle, carne");

        // Secondi
        Portata fiorentina = new Secondi("Fiorentina", 17.48, "bella bisteccona", "fassona, contorno1");
        Portata pollo = new Secondi("Pollo", 13.67, "pieno di proteine", "Pollo, Patate");
        Portata maiale = new Secondi("Maiale", 23.15, "carne grassa", "Costate, Contorno2");

        // desserts
        Portata tiramisu = new Desserts("Tiramisu", 3.99, "dessert, di origine italiana", "ladyfingers (savoiardi), egg yolks, sugar, coffee, mascarpone and cocoa powder.");
        Portata cheeseCake = new Desserts("cheeseCake", 4.00, "un dolce a base di formaggio fresco a pasta molle", " eggs, and sugar. It may have a crust or base made from crushed cookies (or digestive biscuits), graham crackers, pastry, or sometimes sponge cake.");
        Portata chocolateFudge = new Desserts("Chocolate Fudge", 5.00, "a dense, rich confection", "sugar, milk or cream, butter and chocolate or other flavorings.");

        // Bevande
        Portata acqua = new Bevande("Acqua", 1.0, "bottiglia da 1l naturale o frizzante", "acqua con sali di sodio, potassio, calcio, magnesio", 2024, false);
        Portata vinoBianco = new Bevande("Vino bianco", 9.90, "bottiglia da 0,75l di Passerina", "uva da vitigni a bacca bianca del sud delle Marche", 2018, true);
        Portata vinoRosso = new Bevande("Vino rosso", 9.90, "bottiglia da 0,75l di Rosso Piceno", "uva da vitigni di Montepulciano e Sangiovese", 2015, true);
        Portata cocaCola = new Bevande("Coca cola", 0.95, "lattina da 33cl di coca cola", "acqua, anidride carbonica, zucchero, colorante caramello (E 150D), aromi naturali, caffeina e acido fosforico (E 338)", 2024, false);

        // Menu
    }
}
