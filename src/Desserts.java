public class Desserts extends Portata {

    // i field
    private Boolean glutenFree;

    // override dei costruttore
    public Desserts(String nome, Double prezzo, String descrizione, String ingredienti, Boolean glutenFree) {
        super(nome, prezzo, descrizione, ingredienti);
        this.glutenFree = glutenFree;
    }

    // i getter and setter

    public Boolean getGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }


    // stampadettagli method from parent class

    @Override
    public void stampaDettagli() {
        super.stampaDettagli();
        System.out.println("is this Vegan: " + glutenFree);
    }
}
