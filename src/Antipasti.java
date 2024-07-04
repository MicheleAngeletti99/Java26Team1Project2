import enumarazioni.Colori;

public class Antipasti extends Portata {
    private String origineProdotto;
    // campo che determina il colore
    private static String colore = Colori.VERDE.getColore();

    public Antipasti(String nome, Double prezzo, String descrizione, String ingredienti, String origineProdotto) {
        super(nome, prezzo, descrizione, ingredienti);


        this.origineProdotto = origineProdotto;
    }

    public String getOrigineProdotto() {
        return origineProdotto;
    }

    public void setOrigineProdotto(String origineProdotto) {
        this.origineProdotto = origineProdotto;
    }

    // metodo per cambiare il colore
    public static void cambiaColore() {
        System.out.println(colore);
    }

    @Override
    public void stampaDettagli() {
        super.stampaDettagli();
        System.out.println("Origine prodotto : " + origineProdotto);
    }
}
