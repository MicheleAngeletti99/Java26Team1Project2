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
    private HashMap<Integer,Cliente> prenotazione;

    // il costruttore
    public Ristorante(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
        this.listaMenu = new ArrayList<>();
        this.prenotazione = new HashMap<>();
    }

    // i getter e setter
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
    public void aggiungiMenu (Menu menu){
        listaMenu.add(menu);
    }

    // il metodo per rimuovere menu
    public void rimuoviMenu(Menu menu){
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

    // il metodo per aggiungere prenotazione
    public void aggiungiPrenotazioni(Cliente cliente){
        prenotazione.put(idCliente,cliente);
        idCliente++;
    }

    // il metodo per rimuovere prenotazione
    public void rimuoviPrenotazione(Integer id){
        prenotazione.remove(id);
    }

    // il metodo per stampare la lista di prenotazione
    public void stampaListaDiPrenotazioni(){
        for (Integer identites: prenotazione.keySet()){
            System.out.println("ID prenotazionel: " + identites + " Info prenotazione: " + prenotazione.get(identites));
        }
    }

}
