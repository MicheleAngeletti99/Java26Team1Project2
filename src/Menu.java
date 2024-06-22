import java.util.ArrayList;
import java.util.List;

public class Menu {

    private String tipo;
    private List<Portata> listaPortate;

    public Menu(String tipo) {
        this.tipo = tipo;
        this.listaPortate = new ArrayList<>();
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
    // aggiungiPortata
    public void aggiungiPortata(Portata portata){
    listaPortate.add(portata);
    }
    // rimuoviPortata
    public void rimuoviPortata(Portata portata){ listaPortate.remove(portata);}
    // modificaPrezzo
    public void modificaPrezzo(Portata portata, Double nuovoPrezzo){
       // portata.setPrezzo(prezzo);
        for(Portata elemento : listaPortate){
            if (portata.equals(elemento)){
                portata.setPrezzo(nuovoPrezzo);
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
