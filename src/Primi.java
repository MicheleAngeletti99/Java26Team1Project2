import enumarazioni.Colori;

public class Primi extends Portata {
    private String cottura;
    private String  regioneProvenienza;
    // campo che determina il colore
    private static String colore = Colori.GIALLO.getColore();

    public Primi(String nome, Double prezzo, String descrizione, String ingredienti, String cottura, String regioneProvenienza) {
        super(nome, prezzo, descrizione, ingredienti);
        this.cottura = cottura;
        this.regioneProvenienza = regioneProvenienza;
    }

    public String getCottura() {
        return cottura;
    }

    public void setCottura(String cottura) {
        this.cottura = cottura;
    }

    public String getRegioneProvenienza() {
        return regioneProvenienza;
    }

    public void setRegioneProvenienza(String regioneProvenienza) {
        this.regioneProvenienza = regioneProvenienza;
    }

    // metodo per cambiare il colore
    public static void cambiaColore() {
        System.out.println(colore);
    }

    @Override
    public void stampaDettagli() {
        super.stampaDettagli();
        System.out.println("cottura : " + cottura);
        System.out.println("Regione di provenienza : " + regioneProvenienza);
    }
}