import enumarazioni.Colori;
import enumarazioni.TipoMenu;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private TipoMenu tipo;
    private List<Portata> listaPortate;

    public Menu(TipoMenu tipo) {
        this.tipo = tipo;
        this.listaPortate = new ArrayList<>();
    }

    public TipoMenu getTipo() {
        return tipo;
    }

    public void setTipo(TipoMenu tipo) {
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
        System.out.println(tipo.getDescrizione());
        System.out.println("\nANTIPASTI: ");
        for (Portata portata : listaPortate) {
            if (portata instanceof Antipasti) {
                System.out.print(portata.stampaColore());
                portata.stampaDettagli();
            }
            System.out.print(Colori.RESET.getColore());
        }

        System.out.println("\nPRIMI: ");
        for (Portata portata : listaPortate) {
            if (portata instanceof Primi) {
                System.out.print(portata.stampaColore());
                portata.stampaDettagli();
            }
            System.out.print(Colori.RESET.getColore());
        }
        System.out.println("\nSECONDI: ");
        for (Portata portata : listaPortate) {
            if (portata instanceof Secondi) {
                System.out.print(portata.stampaColore());
                portata.stampaDettagli();
            }
            System.out.print(Colori.RESET.getColore());
        }
        System.out.println("\nDESSERTS: ");
        for (Portata portata : listaPortate) {
            if (portata instanceof Desserts) {
                System.out.print(portata.stampaColore());
                portata.stampaDettagli();
            }
            System.out.print(Colori.RESET.getColore());
        }
        System.out.println("\nBEVANDE: ");
        for (Portata portata : listaPortate) {
            if (portata instanceof Bevande) {
                System.out.print(portata.stampaColore());
                portata.stampaDettagli();
            }
            System.out.print(Colori.RESET.getColore());
        }

    }

}
