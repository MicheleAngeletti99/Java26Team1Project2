import enumarazioni.StatusPrenotazione;

public class Prenotazione {
    // i campi
    private static Integer collectiveId = 1;
    private Integer id;
    private Cliente cliente;
    private Integer numeroCoperti;
    private StatusPrenotazione statoPrenotazione;


    // costruttore
    public Prenotazione(Cliente cliente, Integer numeroCoperti) {
        this.id = collectiveId;
        collectiveId++;
        this.cliente = cliente;
        this.numeroCoperti = numeroCoperti;
        this.statoPrenotazione = StatusPrenotazione.INATTIVO;
    }

    // getters e setters
    public Integer getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getNumeroCoperti() {
        return numeroCoperti;
    }

    public void setNumeroCoperti(Integer numeroCoperti) {
        this.numeroCoperti = numeroCoperti;
    }

    public StatusPrenotazione getStatoPrenotazione() {
        return statoPrenotazione;
    }

    public void setStatoPrenotazione(StatusPrenotazione statoPrenotazione) {
        this.statoPrenotazione = statoPrenotazione;
    }

    // metodo per stampare i dettagli
    public void stampaDettagli() {
        System.out.println("Prenotazione " + id + ": ");
        System.out.print("Cliente: ");
        cliente.stampaDettagli();
        System.out.println("Numero di coperti: " + numeroCoperti);
        System.out.println("Stato prenotazione: " + statoPrenotazione.getDescrizione());
    }

    // metodo prenotazione per visualizzare chi è stato rimosso o ha una prenotazione attiva


}
