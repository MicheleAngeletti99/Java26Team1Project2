public class Prenotazione {
    // i campi
    private static Integer collectiveId = 1;
    private Integer id;
    private Cliente cliente;
    private Ristorante ristorante;
    private Integer numeroCoperti;
    private boolean isActive;

    // costruttore
    public Prenotazione(Cliente cliente, Ristorante ristorante, Integer numeroCoperti) {
        this.id = collectiveId;
        collectiveId++;
        this.cliente = cliente;
        this.ristorante = ristorante;
        this.numeroCoperti = numeroCoperti;
        this.isActive = true;
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

    public Ristorante getRistorante() {
        return ristorante;
    }

    public void setRistorante(Ristorante ristorante) {
        this.ristorante = ristorante;
    }

    public Integer getNumeroCoperti() {
        return numeroCoperti;
    }

    public void setNumeroCoperti(Integer numeroCoperti) {
        this.numeroCoperti = numeroCoperti;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // metodo per stampare i dettagli
    public void stampaDettagli() {
        System.out.println("Prenotazione " + id + ": ");
        System.out.print("Cliente: ");
        cliente.stampaDettagli();
        System.out.print("Ristorante: ");
        ristorante.stampaDettagli();
        System.out.println("Numero di coperti: " + numeroCoperti);
    }
}
