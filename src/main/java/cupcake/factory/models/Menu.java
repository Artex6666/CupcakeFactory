package cupcake.factory.models;

import java.util.Map;

public class Menu {

    private StockManager stock;

    public Menu(StockManager stock) {
        this.stock = stock;
    }

    public void showMenu() {
        System.out.println("📋 --- MENU CUPCAKE FACTORY --- 📋");

        // Ingrédients disponibles
        Map<String, Integer> stockDispo = stock.getStocksDisponibles();

        System.out.println("\nBases disponibles :");
        stockDispo.keySet().stream()
                .filter(n -> n.equalsIgnoreCase("NATURE") || n.equalsIgnoreCase("CHOCOLAT") || n.equalsIgnoreCase("FOURREE"))
                .forEach(nom -> System.out.println("- " + nom + " (" + stockDispo.get(nom) + " en stock)"));

        System.out.println("\nCrèmes disponibles :");
        stockDispo.keySet().stream()
                .filter(n -> n.equalsIgnoreCase("VANILLE") || n.equalsIgnoreCase("CHOCOLAT") || n.equalsIgnoreCase("FRAMBOISE"))
                .forEach(nom -> System.out.println("- " + nom + " (" + stockDispo.get(nom) + " en stock)"));

        System.out.println("\nToppings disponibles :");
        stockDispo.keySet().stream()
                .filter(n -> !n.equalsIgnoreCase("NATURE") && !n.equalsIgnoreCase("CHOCOLAT") &&
                        !n.equalsIgnoreCase("FOURREE") && !n.equalsIgnoreCase("VANILLE") &&
                        !n.equalsIgnoreCase("FRAMBOISE"))
                .forEach(nom -> System.out.println("- " + nom + " (" + stockDispo.get(nom) + " en stock)"));

        // Cupcakes du jour
        System.out.println("\n🧁 Cupcakes du jour disponibles :");
        stock.getStockCupcakesDuJour().forEach((nom, qte) -> {
            if (qte > 0) {
                System.out.println("- " + nom + " (" + qte + " restants)");
            }
        });

        System.out.println("\n--------------------------------\n");
    }
}
