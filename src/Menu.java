import java.util.List;

public class Menu {

    private String nome;
    private String tipo;
    private List<Portata> listaPortate;

    public Menu(String nome, String tipo, List<Portata> listaPortate) {
        this.nome = nome;
        this.tipo = tipo;
        this.listaPortate = listaPortate;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Portata> getListaPortate() {
        return listaPortate;
    }

    public void setListaPortate(List<Portata> listaPortate) {
        this.listaPortate = listaPortate;
    }

    // aggiungiPortata

    // rimuoviPortata

    // stampaMenu
}
