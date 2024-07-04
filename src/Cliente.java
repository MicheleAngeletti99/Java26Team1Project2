public class Cliente {

    // gli field
    private String nome;
    private String cognome;
    private Integer numeroDiCoperti;

    // il costruttore
    public Cliente(String nome,String cognome,Integer numeroDiCoperti){
        this.nome = nome;
        this.cognome = cognome;
        this.numeroDiCoperti = numeroDiCoperti;
    }

    // i getter e setter

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Integer getNumeroDiCoperti() {
        return numeroDiCoperti;
    }

    public void setNumeroDiCoperti(Integer numeroDiCoperti) {
        this.numeroDiCoperti = numeroDiCoperti;
    }

    // methodo per stampare gli dettagli del classe cliente
    public  void stampaDettagli(){
        System.out.println(this.nome + " " + this.cognome);
    }


}
