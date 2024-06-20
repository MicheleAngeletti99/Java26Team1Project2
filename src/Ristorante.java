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
}
