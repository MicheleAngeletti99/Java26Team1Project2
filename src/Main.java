public class Main {
    public static void main(String[] args) {

        Desserts tiramisu = new Desserts("Tiramisu", 3.99,"dessert, di origine italiana", "ladyfingers (savoiardi), egg yolks, sugar, coffee, mascarpone and cocoa powder.");
        tiramisu.stampaDettagli();
        Desserts cheeseCake = new Desserts("cheeseCake",4.00,"un dolce a base di formaggio fresco a pasta molle"," eggs, and sugar. It may have a crust or base made from crushed cookies (or digestive biscuits), graham crackers, pastry, or sometimes sponge cake.");
        cheeseCake.stampaDettagli();
        Desserts chocolateFudge = new Desserts("Chocolate Fudge", 5.00,"a dense, rich confection", "sugar, milk or cream, butter and chocolate or other flavorings.");
        chocolateFudge.stampaDettagli();
    }
}
