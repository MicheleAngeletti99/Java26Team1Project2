public class Main {
    public static void main(String[] args) {
        //Antipasti
        Antipasti antipasto1 = new Antipasti("Bruschette", 5.99, "pane tostato e pomodoro", "pane, pomodoro, olio, aglio");
        antipasto1.stampaDettagli();
        Antipasti antipasto2 = new Antipasti("Misto caldo",8.99, "patatine fritte, arancine fritte e panelle fritte", "patate, farina di ceci, palle di riso fritte");
        antipasto2.stampaDettagli();
        Antipasti antipasto3 = new Antipasti("Polenta fritta", 10.55,"polenta fritta servita con funghi","farina di mais e funghi");
        antipasto3.stampaDettagli();

        // desserts
        Desserts tiramisu = new Desserts("Tiramisu", 3.99,"dessert, di origine italiana", "ladyfingers (savoiardi), egg yolks, sugar, coffee, mascarpone and cocoa powder.");
        tiramisu.stampaDettagli();
        Desserts cheeseCake = new Desserts("cheeseCake",4.00,"un dolce a base di formaggio fresco a pasta molle"," eggs, and sugar. It may have a crust or base made from crushed cookies (or digestive biscuits), graham crackers, pastry, or sometimes sponge cake.");
        cheeseCake.stampaDettagli();
        Desserts chocolateFudge = new Desserts("Chocolate Fudge", 5.00,"a dense, rich confection", "sugar, milk or cream, butter and chocolate or other flavorings.");
        chocolateFudge.stampaDettagli();

        // Bevande
        Portata acqua = new Bevande("Acqua", 1.0, "bottiglia da 1l naturale o frizzante", "acqua con sali di sodio, potassio, calcio, magnesio");
        acqua.stampaDettagli();
        Portata vinoBianco = new Bevande("Vino bianco", 9.90, "bottiglia da 0,75l di Passerina", "uva da vitigni a bacca bianca del sud delle Marche");
        vinoBianco.stampaDettagli();
        Portata vinoRosso = new Bevande("Vino rosso", 9.90, "bottiglia da 0,75l di Rosso Piceno", "uva da vitigni di Montepulciano e Sangiovese");
        vinoRosso.stampaDettagli();
        Portata cocaCola = new Bevande("Coca cola", 0.95, "lattina da 33cl di coca cola", "acqua, anidride carbonica, zucchero, colorante caramello (E 150D), aromi naturali, caffeina e acido fosforico (E 338)");
        cocaCola.stampaDettagli();

    }
}
