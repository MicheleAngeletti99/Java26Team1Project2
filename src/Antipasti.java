import enumarazioni.Colori;

public class Antipasti extends Portata {
    private String origineProdotto;


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

    @Override
    public String stampaColore() {
        return Colori.VERDE.getColore();
    }

    @Override
    public void stampaDettagli() {
        super.stampaDettagli();
        System.out.println("Origine prodotto : " + origineProdotto);
    }
}
