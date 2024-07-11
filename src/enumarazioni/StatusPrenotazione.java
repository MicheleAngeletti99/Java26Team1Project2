package enumarazioni;

public enum StatusPrenotazione {
    INATTIVO("prenotazione ancora non finita"),
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
