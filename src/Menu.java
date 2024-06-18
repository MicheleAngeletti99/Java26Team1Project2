import java.util.List;

public class Menu {

    private String tipo;
    private List<Portata> listaPortate;

    public Menu(String tipo, List<Portata> listaPortate) {
        this.tipo = tipo;
        this.listaPortate = listaPortate;
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
    public void aggiungiPortata(Portata portata){
    listaPortate.add(portata);
    }
    // rimuoviPortata
    public void rimuoviPortata(Portata portata){ listaPortate.remove(portata);}
    // modificaPrezzo

    // stampaMenu
}
