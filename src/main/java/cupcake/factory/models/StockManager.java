package cupcake.factory.models;

import java.util.HashMap;
import java.util.Map;

public class StockManager {

    // Stock des ingrédients (tous types confondus)
    private Map<String, Integer> stockIngrédients;

    // Stock des cupcakes du jour : nom du cupcake → quantité
    private Map<String, Integer> stockCupcakesDuJour;

    public StockManager() {
        this.stockIngrédients = new HashMap<>();
        this.stockCupcakesDuJour = new HashMap<>();
    }

    // Ajouter un ingrédient avec une quantité initiale
    public void ajouterIngredient(Ingredient ingredient, int quantite) {
        stockIngrédients.put(ingredient.getNom(), quantite);
    }

    public void reapprovisionnerIngredient(String nom, int quantite) {
        stockIngrédients.put(nom, stockIngrédients.getOrDefault(nom, 0) + quantite);
    }

    // Vérifier si un ingrédient est dispo
    public boolean estDisponible(Ingredient ingredient) {
        return stockIngrédients.getOrDefault(ingredient.getNom(), 0) > 0;
    }

    // Consommer un ingrédient
    public boolean consommer(Ingredient ingredient) {
        String nom = ingredient.getNom();
        if (estDisponible(ingredient)) {
            stockIngrédients.put(nom, stockIngrédients.get(nom) - 1);
            return true;
        }
        return false;
    }

    // Cupcake du jour

    public void ajouterCupcakeDuJour(String nom, int quantite) {
        stockCupcakesDuJour.put(nom, quantite);
    }

    public boolean estCupcakeDuJourDisponible(String nom) {
        return stockCupcakesDuJour.getOrDefault(nom, 0) > 0;
    }

    public boolean consommerCupcakeDuJour(String nom) {
        if (estCupcakeDuJourDisponible(nom)) {
            stockCupcakesDuJour.put(nom, stockCupcakesDuJour.get(nom) - 1);
            return true;
        }
        return false;
    }

    // Affichage pour debug
    public void afficherStock() {
        System.out.println("Ingrédients :");
        stockIngrédients.forEach((nom, qte) -> System.out.println(nom + " : " + qte));
        System.out.println("\nCupcakes du jour :");
        stockCupcakesDuJour.forEach((nom, qte) -> System.out.println(nom + " : " + qte));
    }

    // Accès direct si besoin
    public Map<String, Integer> getStockIngrédients() {
        return stockIngrédients;
    }

    public Map<String, Integer> getStockCupcakesDuJour() {
        return stockCupcakesDuJour;
    }
}

