import enumarazioni.Colori;
import enumarazioni.StatusPrenotazione;
import enumarazioni.TipoChef;
import enumarazioni.TipoMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Ristorante{
    // gli field
    private String nome;
    private String citta;
    private ArrayList<Menu> listaMenu;
    private HashSet<Prenotazione> listaPrenotazioni;
    private Integer copertiDisponibili;
    private TipoChef chef;


    // il costruttore
    public Ristorante(String nome, String citta, Integer copertiDisponibili, TipoChef chef) {
        this.nome = nome;
        this.citta = citta;
        this.listaMenu = new ArrayList<>();
        this.listaPrenotazioni = new HashSet<>();
        this.copertiDisponibili = copertiDisponibili;
        this.chef = chef;
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
        // variabile per salvare se c'è un menu dello stesso tipo
        boolean isThere = false;
        // controllo che ci sia un menu per ogni tipo
        for (Menu checkMenu : listaMenu) {
            if (menu.getTipo() == checkMenu.getTipo()) {
                // se trovo un menu dello stesso tipo di quello che sto inserendo me lo salvo
                isThere = true;
            }
        }
        if (isThere) {
            System.out.println("Esiste già un " + menu.getTipo().getDescrizione() +
                    " si prega di aggiornare quello già esistente");
        } else {
            listaMenu.add(menu);
        }
    }

    // il metodo per rimuovere menu
    public void rimuoviMenu(Menu menu) {
        listaMenu.remove(menu);
    }

    // metodo per stampare tutte le portate di tutti i menu del ristorante
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

    // metodo per stampare un tipo di menu particolare
    public void stampaTipoMenu(TipoMenu tipo) {
        // se viene richiesto il menu completo invoco il metodo apposito
        if (tipo == TipoMenu.COMPLETO) {
            stampaMenuCompleto();
        } else {
            // cerco il menu nella listaMenu confrontando il tipo
            for (Menu menu : listaMenu) {
                if (menu.getTipo() == tipo) {
                    // una volta trovato lo stampo
                    menu.stampaMenu();
                    break;
                }
            }
        }
    }

    // metodo per gestire Overbooking, faccio comparazione fra coperti disponibili e coperti richiesti dal cliente
    // true quando i coperti richiesti dal cliente rientrano nella disponibilità dei coperti del ristornate
    // false quando i coperti richiesti dal cliente non rientrano nella disponibilità
    private boolean gestioneOverbooking(Prenotazione prenotazione) {
        if (copertiDisponibili >= prenotazione.getNumeroCoperti()) {
            return true;
        } else {
            return false;
        }
    }

    // metodo per aggiungere prenotazione
    // se la gestioneOverbooking sarà true, verranno aggiunti i coperti prenotati e i coperti diponibili del ristornate verranno diminuiti
    public void aggiungiPrenotazioni(Prenotazione prenotazione) {
        // controllo se posso aggiungere la prenotazione
        if (!gestioneOverbooking(prenotazione)) {
            // se va in overbooking
            listaPrenotazioni.add(prenotazione);
            prenotazione.setStatoPrenotazione(StatusPrenotazione.RIMOSSO);
            System.out.println(prenotazione.getCliente().getNome() + ", il numero dei coperti richiesto non è disponibile");
        } else {
            // se non ci sono problemi
            listaPrenotazioni.add(prenotazione);
            prenotazione.setStatoPrenotazione(StatusPrenotazione.ATTIVO);
            copertiDisponibili = copertiDisponibili - prenotazione.getNumeroCoperti();
        }
    }
    // il metodo per rimuovere prenotazione
    // gestione overbooking, ad ogni coperto rimosso i coperti diponibili del ristorante verranno aumentati
    public void rimuoviPrenotazione(Prenotazione prenotazione) {
        copertiDisponibili = copertiDisponibili + prenotazione.getNumeroCoperti();
        prenotazione.setStatoPrenotazione(StatusPrenotazione.RIMOSSO);
    }
    //metodo per visualizzare quanti sono i coperti disponibili
    public void mostraCopertiDisponibili(){
        System.out.println(Colori.BLU.getColore());
        System.out.println("Coperti disponibili: " + copertiDisponibili);
        Colori.resetColore();
    }

    // il metodo per stampare la lista di prenotazione
    public void stampaListaDiPrenotazioni() {
        System.out.println("      LISTA DI PRENOTAZIONI " + "\n");
        for (Prenotazione prenotazione : listaPrenotazioni) {
            prenotazione.stampaDettagli();
            System.out.println();
        }
    }

    //Metodo per aggiungere dei dati aggiuntivi al ristorante
    public void stampaDettagliRistorante() {
        System.out.println("\nNOME RISTORANTE : " + nome );
        System.out.println("CITTà : " + citta);
        System.out.println("CHEF : " + chef);
        System.out.println("COPERTIDISPONIBILI : " + copertiDisponibili);

    }

    public void stampaMenuScelto(Cliente cliente){
        boolean menuPresente = false;
        for (Menu menu : listaMenu){
            if (menu.getTipo().equals(cliente.getMenuCliente())) {
                menu.stampaMenu();
                menuPresente = true;
            }
        }
        if (!menuPresente){
            System.out.println("Il menu scelto dal cliente non è disponibile in questo ristorante");
        }
    }

}
