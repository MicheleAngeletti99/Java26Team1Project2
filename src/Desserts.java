public class Desserts extends Portata {
     // i field
    private Boolean glutenFree;

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
