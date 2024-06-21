import java.util.Objects;

public abstract class Portata {
    // gli field
    private String nome;
    private Double prezzo;
    private String descrizione;
    private String ingredienti;

    // il costruttore
    public Portata(String nome,Double prezzo,String descrizione,String ingredienti){
        this.nome = nome;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.ingredienti = ingredienti;
    }

    // il getter e setter

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(String ingredienti) {
        this.ingredienti = ingredienti;
    }

    // metodo per stampare il menu
    public void stampaDettagli(){
        System.out.print('\n' + nome + " ");
        // inseriamo i puntini
        Integer puntini = 40 - nome.length();
        for(int i = 0; i<= puntini; i++ ){
            System.out.print(".");
        }

        System.out.println(prezzo + "€");
        System.out.println(descrizione);
        System.out.println(ingredienti);
    }

    // Faccio Override di equals e hashCode così due portate saranno uguali se hanno gli stessi valori nei campi
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Portata portata)) return false;
        return Objects.equals(nome, portata.nome) && Objects.equals(prezzo, portata.prezzo) && Objects.equals(descrizione, portata.descrizione) && Objects.equals(ingredienti, portata.ingredienti);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, prezzo, descrizione, ingredienti);
    }
}
