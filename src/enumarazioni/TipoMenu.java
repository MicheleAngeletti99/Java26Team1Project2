package enumarazioni;

public enum TipoMenu {
    CARNE("CARNE", "Menu di carne"),
    PESCE("PESCE", "Menu di pesce"),
    VEGETARIANO("VEGETARIANO", "Menu vegetariano"),
    VEGANO("VEGANO", "Menu vegano"),
    DELGIORNO("DELGIORNO", "Menu speciale del giorno"),
    FINESETTIMANA("FINESETTIMANA", "Menu del fine settimana"),
    ORDINARIO("ORDINARIO", "Menu ordinario"),
    COMPLETO("COMPLETO", "Menu completo");

    private String descrizione;
    private String stringTipo;

    TipoMenu(String stringTipo, String descrizione) {
        this.stringTipo = stringTipo;
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getStringTipo() {
        return stringTipo;
    }
}
