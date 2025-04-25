package cupcake.factory;

import cupcake.factory.enums.*;
import cupcake.factory.models.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Bienvenue à la Cupcake Factory !");
        double totalCA = 0;
        // Création de stock
        StockManager stock = new StockManager();
        stock.ajouterIngredient(new Base(BaseType.CHOCOLAT), 10);
        stock.ajouterIngredient(new Creme(CremeType.VANILLE), 10);
        stock.ajouterIngredient(new Topping(ToppingType.MARSHMALLOW), 10);
        stock.ajouterIngredient(new Topping(ToppingType.COOKIE_DOUGH), 10);

        //Cupcake du jour:
        CupcakeDuJour offer1 = new CupcakeDuJour("ChocoVanille", 2 );
        stock.ajouterCupcakeDuJour(offer1.getNom(), 20);

        // Affichage du menu:
        Menu menu = new Menu(stock);
        menu.showMenu();

        // Création d'un cupcake
        Cupcake cupcake = new Cupcake(
                new Base(BaseType.CHOCOLAT),
                new Creme(CremeType.VANILLE)
        );
        cupcake.ajouterTopping(new Topping(ToppingType.MARSHMALLOW));

        // Ajout dans une commande
        Commande commande = new Commande();
        commande.ajouterCupcake(cupcake, stock, 5);
        commande.ajouterCupcakeDuJour(offer1, stock, 2);

        // Affichage
        commande.afficherDetailsCommande();
        totalCA+=commande.calculerTotal();

        System.out.println("CA total: " + String.format("%.2f", totalCA));

    }
}
