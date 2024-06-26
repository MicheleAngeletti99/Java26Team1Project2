package enumarazioni;

public enum TipoMenu {
    CARNE("Menu di carne"),
    PESCE("Menu di pesce"),
    VEGETARIANO("Menu vegetariano"),
    VEGANO("Menu vegano"),
    DELGIORNO("Menu speciale del giorno"),
    FINESETTIMANA("Menu del fine settimana"),
    ORDINARIO("Menu ordinario"),
    COMPLETO("Menu completo");

    private String descrizione;

    TipoMenu(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
