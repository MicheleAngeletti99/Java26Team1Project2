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
        // stampa del titolo
        System.out.println(tipo.getDescrizione());
        // stampa degli antipasti
        System.out.println("\nANTIPASTI: ");
        Antipasti.cambiaColore();
        for (Portata portata : listaPortate) {
            if (portata instanceof Antipasti) {
                portata.stampaDettagli();
            }
        }
        Colori.resetColore();
        // stampa dei primi
        System.out.println("\nPRIMI: ");
        Primi.cambiaColore();
        for (Portata portata : listaPortate) {
            if (portata instanceof Primi) {
                portata.stampaDettagli();
            }
        }
        Colori.resetColore();
        // stampa dei secondi
        System.out.println("\nSECONDI: ");
        Secondi.cambiaColore();
        for (Portata portata : listaPortate) {
            if (portata instanceof Secondi) {
                portata.stampaDettagli();
            }
        }
        Colori.resetColore();
        // stampa dei desserts
        System.out.println("\nDESSERTS: ");
        Desserts.cambiaColore();
        for (Portata portata : listaPortate) {
            if (portata instanceof Desserts) {
                portata.stampaDettagli();
            }
        }
        Colori.resetColore();
        // stampa delle bevande
        System.out.println("\nBEVANDE: ");
        Bevande.cambiaColore();
        for (Portata portata : listaPortate) {
            if (portata instanceof Bevande) {
                portata.stampaDettagli();
            }
        }
        Colori.resetColore();
    }

}
