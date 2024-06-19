public class Secondi extends Portata{

    private Cottura cottura;
    public Secondi(String nome, Double prezzo, String descrizione, String ingredienti,Cottura cottura ) {
        super(nome, prezzo, descrizione, ingredienti);
        this.cottura = cottura;
    }

    @Override
    public void stampaDettagli() {
        super.stampaDettagli();
        System.out.println(cottura);

    }
}

enum Cottura{
    ALSANGUE,
    MEDIA,
    BENCOTTA
}
