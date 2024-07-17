import enumarazioni.Colori;

public class Bevande extends Portata {

    private Integer annoDiProduzione;
    private Boolean certificazioneDOP;
    // campo che determina il colore
    private static String colore = Colori.BLU.getColore();

    public Bevande(String nome, Double prezzo, String descrizione, String ingredienti, Integer annoDiProduzione, Boolean certificazioneDOP) {
        super(nome, prezzo, descrizione, ingredienti);
        this.annoDiProduzione = annoDiProduzione;
        this.certificazioneDOP = certificazioneDOP;
    }
    // getters e setters
    public Integer getAnnoDiProduzione() {
        return annoDiProduzione;
    }

    public void setAnnoDiProduzione(Integer annoDiProduzione) {
        this.annoDiProduzione = annoDiProduzione;
    }

    public Boolean getCertificazioneDOP() {
        return certificazioneDOP;
    }

    public void setCertificazioneDOP(Boolean certificazioneDOP) {
        this.certificazioneDOP = certificazioneDOP;
    }

    // metodo per cambiare il colore
    public static void cambiaColore() {
        System.out.println(colore);
    }

    @Override
    public void stampaDettagli() {
        super.stampaDettagli();
        System.out.println("Prodotto nell'anno " + annoDiProduzione);
        if (certificazioneDOP) {
            System.out.println("Prodotto con certificazione DOP");
        }
    }
}
