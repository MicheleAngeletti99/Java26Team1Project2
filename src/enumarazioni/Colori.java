package enumarazioni;

public enum Colori {

    ROSSO ("\033[0;31m"),
    VERDE ("\033[0;32m"),
    BLU ( "\033[0;34m"),
    VIOLA ("\033[0;35m"),
    BIANCO ("\033[0;37m"),
    GIALLO ("\033[0;33m"),
    RESET ("\033[0m");

    private String colore;

    Colori(String colore) {
        this.colore = colore;
    }

    public String getColore(){
        return colore;
    }
}
