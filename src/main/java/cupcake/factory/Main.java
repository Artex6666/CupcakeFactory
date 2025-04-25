package cupcake.factory;

import cupcake.factory.enums.*;
import cupcake.factory.models.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenue à la Cupcake Factory !");

        // Création de stock
        StockManager stock = new StockManager();
        stock.ajouterIngredient(new Base(BaseType.CHOCOLAT), 10);
        stock.ajouterIngredient(new Creme(CremeType.VANILLE), 10);
        stock.ajouterIngredient(new Topping(ToppingType.MARSHMALLOW), 10);

        // Création d'un cupcake
        Cupcake cupcake = new Cupcake(
                new Base(BaseType.CHOCOLAT),
                new Creme(CremeType.VANILLE)
        );
        cupcake.ajouterTopping(new Topping(ToppingType.MARSHMALLOW));

        // Ajout dans une commande
        Commande commande = new Commande();
        commande.ajouterCupcake(cupcake);

        // Affichage
        System.out.println(cupcake);
        System.out.println("Prix du cupcake : " + cupcake.calculerPrix() + "€");
        System.out.println("Total de la commande : " + commande.calculerTotal() + "€");

        // Affichage du stock
        stock.afficherStock();
    }
}
