import enumarazioni.Colori;

public class Desserts extends Portata {
     // i field
    private Boolean glutenFree;
    // campo che determina il colore
    private static String colore = Colori.VIOLA.getColore();

    // override dei costruttore
    public Desserts(String nome, Double prezzo, String descrizione, String ingredienti,Boolean glutenFree) {
        super(nome, prezzo, descrizione, ingredienti);
        this.glutenFree = glutenFree;
    }

    // getter and setter
    public Boolean getGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    // metodo per cambiare il colore
    public static void cambiaColore() {
        System.out.println(colore);
    }

    // override il metodo stampadettagli dal superclass
    @Override
    public void stampaDettagli() {
        super.stampaDettagli();
        if(glutenFree){
            System.out.println("the dessert is gluten free");
        } else{
            System.out.println(" this dessert contains gluten in it");
        }
    }
}
