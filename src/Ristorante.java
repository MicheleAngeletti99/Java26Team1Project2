import java.util.ArrayList;

public class Ristorante {
    private String nome;
    private String citta;
    private ArrayList<Menu> listaMenu;

    public Ristorante(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
        this.listaMenu = new ArrayList<>();
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

    public void aggiungiMenu (Menu menu){
        listaMenu.add(menu);
    }

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
}
