import enumarazioni.Colori;
import enumarazioni.TipoMenu;

import java.util.ArrayList;
import java.util.HashMap;

public class Ristorante {
    // gli field
    private String nome;
    private String citta;
    private ArrayList<Menu> listaMenu;
    private Integer idCliente = 1;
    private HashMap<Integer, Cliente> prenotazione;
    private Integer copertiDisponibili;

    // il costruttore
    public Ristorante(String nome, String citta, Integer copertiDisponibili) {
        this.nome = nome;
        this.citta = citta;
        this.listaMenu = new ArrayList<>();
        this.prenotazione = new HashMap<>();
        this.copertiDisponibili = copertiDisponibili;
    }

    // i getter e setter

    public Integer getCopertiDisponibili() {
        return copertiDisponibili;
    }

    public void setCopertiDisponibili(Integer copertiDisponibili) {
        this.copertiDisponibili = copertiDisponibili;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    // il metodo per aggiungere menu
    public void aggiungiMenu(Menu menu) {
        listaMenu.add(menu);
    }

    // il metodo per rimuovere menu
    public void rimuoviMenu(Menu menu) {
        listaMenu.remove(menu);
    }

    public void stampaMenuCompleto() {
        // Inizializzo un menu che conterrà tutte le portate disponibili
        Menu menuCompleto = new Menu(TipoMenu.COMPLETO);
        // Faccio un ciclo per leggere tutti i menu
        for (Menu menu : listaMenu) {
            // Faccio un ciclo per leggere tutte le portate del menu corrente
            for (Portata portata : menu.getListaPortate()) {
                // Controllo se la portata è già stata inserita nel menu completo (poteva essere in un altro menu)
                if (!menuCompleto.getListaPortate().contains(portata)) {
                    // Se non è già nel menu completo la aggiungo
                    menuCompleto.aggiungiPortata(portata);
                }
            }
        }
        // Stampo il menu completo con il suo metodo
        menuCompleto.stampaMenu();

    }

    // metodo per gestire Overbooking
    private boolean gestioneOverbooking(Cliente cliente) {
        if (copertiDisponibili >= cliente.getNumeroDiCoperti()) {
            return true;
        } else {
            return false;
        }
    }

    // il metodo per aggiungere prenotazione
    // gestione overbooking
    public void aggiungiPrenotazioni(Cliente cliente) {
        if (gestioneOverbooking(cliente)) {
            prenotazione.put(idCliente, cliente);
            idCliente++;
            copertiDisponibili = copertiDisponibili - cliente.getNumeroDiCoperti();
        } else {
            System.out.println("Coperti non disponibili");
        }
    }

    // il metodo per rimuovere prenotazione
    public void rimuoviPrenotazione(Integer id) {
        copertiDisponibili = copertiDisponibili + prenotazione.get(id).getNumeroDiCoperti();
        prenotazione.remove(id);
    }

    // il metodo per stampare la lista di prenotazione
    public void stampaListaDiPrenotazioni() {
        System.out.println("      LISTA DI PRENOTAZIONI " + "\n");
        for (Integer identites : prenotazione.keySet()) {
            System.out.println("ID prenotazione: " + identites);
            prenotazione.get(identites).stampaDettagli();
        }
    }
}
