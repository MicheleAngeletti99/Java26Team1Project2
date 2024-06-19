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
    public void modificaPrezzo(String nome, Double prezzo){
       // portata.setPrezzo(prezzo);
        for(Portata portata: listaPortate){
            if (portata.getNome().equals(nome)){
                portata.setPrezzo(prezzo);
            }
        }
    }
    // stampaMenu

    public void stampaMenu() {
        System.out.println("Menu: " + tipo);
        System.out.println("\nANTIPASTI: ");
        for (Portata portata : listaPortate) {
            if (portata instanceof Antipasti) {
                portata.stampaDettagli();
            }
        }
        System.out.println("\nPRIMI: ");
        for (Portata portata : listaPortate) {
            if (portata instanceof Primi) {
                portata.stampaDettagli();
            }
        }
        System.out.println("\nSECONDI: ");
        for (Portata portata : listaPortate) {
            if (portata instanceof Secondi) {
                portata.stampaDettagli();
            }
        }
        System.out.println("\nDESSERTS: ");
        for (Portata portata : listaPortate) {
            if (portata instanceof Desserts) {
                portata.stampaDettagli();
            }
        }
        System.out.println("\nBEVANDE: ");
        for (Portata portata : listaPortate) {
            if (portata instanceof Bevande) {
                portata.stampaDettagli();
            }
        }

    }

}
