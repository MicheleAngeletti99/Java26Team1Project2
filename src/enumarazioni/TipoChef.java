package enumarazioni;

public enum TipoChef {
    Riccardo("Chef: Riccardo"),
    Iresha("Chef: Iresha"),
    Michele("Chef: Michele"),
    Santo("Chef: Santo"),
    Andrea("Chef: Andrea");

    private String chef;

    TipoChef(String chef) {
        this.chef = chef;
    }

    public String getChef() {
        return chef;
    }
}

