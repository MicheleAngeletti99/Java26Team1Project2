package enumarazioni;

public enum Cottura {
    ALSANGUE ("leggermente scottata sul fuoco"),
    MEDIA ("la carne è ancora molto tenera"),
    BENCOTTA("la carne è stato lasciato sul fuoco per quanto possibile");

    private String descrizione;

    Cottura(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCottura(){
        return descrizione;
    }
}
