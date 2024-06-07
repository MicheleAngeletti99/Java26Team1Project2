public class Main {
    public static void main(String[] args) {
    Antipasti antipasto1 = new Antipasti("Bruschette", 5.99, "pane tostato e pomodoro", "pane, pomodoro, olio, aglio");
        antipasto1.stampaDettagli();
    Antipasti antipasto2 = new Antipasti("Misto caldo",8.99, "patatine fritte, arancine fritte e panelle fritte", "patate, farina di ceci, palle di riso fritte");
        antipasto2.stampaDettagli();
    Antipasti antipasto3 = new Antipasti("Polenta fritta", 10.55,"polenta fritta servita con funghi","farina di mais e funghi");
        antipasto3.stampaDettagli();
    }
}
