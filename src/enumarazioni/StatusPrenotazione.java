package enumarazioni;

public enum StatusPrenotazione {
    ATTIVO("prenotazione attivo"),
    RIMOSSO("prenotazione rimosso");

    private String descrizione;

    StatusPrenotazione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
