import enumarazioni.TipoMenu;

public class Cliente {

    // gli field
    private String nome;
    private String cognome;
    private TipoMenu menuCliente;

    // il costruttore
    public Cliente(String nome,String cognome, TipoMenu menuCliente){
        this.nome = nome;
        this.cognome = cognome;
        this.menuCliente = menuCliente;
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

    public TipoMenu getMenuCliente() {
        return menuCliente;
    }

    public void setMenuCliente(TipoMenu menuCliente) {
        this.menuCliente = menuCliente;
    }

    // methodo per stampare gli dettagli del classe cliente
    public  void stampaDettagli(){
        System.out.println(this.nome + " " + this.cognome);
    }


}
