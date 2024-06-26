import enumarazioni.Colori;

public class Bevande extends Portata {

    private Integer annoDiProduzione;
    private Boolean certificazioneDOP;

    public Bevande(String nome, Double prezzo, String descrizione, String ingredienti, Integer annoDiProduzione, Boolean certificazioneDOP) {
        super(nome, prezzo, descrizione, ingredienti);
        this.annoDiProduzione = annoDiProduzione;
        this.certificazioneDOP = certificazioneDOP;
    }

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

    @Override
    public String stampaColore() {
        return Colori.BLU.getColore();
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
