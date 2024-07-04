import enumarazioni.Colori;
import enumarazioni.Cottura;

public class Secondi extends Portata{
    private Cottura cottura;
    // campo che determina il colore
    private static String colore = Colori.ROSSO.getColore();

    public Secondi(String nome, Double prezzo, String descrizione, String ingredienti,Cottura cottura ) {
        super(nome, prezzo, descrizione, ingredienti);
        this.cottura = cottura;
    }

    // metodo per cambiare il colore
    public static void cambiaColore() {
        System.out.println(colore);
    }

    @Override
    public void stampaDettagli() {
        super.stampaDettagli();
        System.out.println(cottura);

    }
}

