package cupcake.factory.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Commande {
    private List<Cupcake> cupcakes;

    public Commande() {
        this.cupcakes = new ArrayList<>();
    }

    public double calculerTotal() {
        if (cupcakes.isEmpty()) return 0.0;

        double total = 0.0;

        if (cupcakes.size() >= 6) {
            Cupcake moinsCher = cupcakes.stream()
                    .min(Comparator.comparingDouble(Cupcake::calculerPrix))
                    .orElse(null);
            total = cupcakes.stream().mapToDouble(Cupcake::calculerPrix).sum();
            if (moinsCher != null) total -= moinsCher.calculerPrix();
        } else {
            total = cupcakes.stream().mapToDouble(Cupcake::calculerPrix).sum();
        }

        return total;
    }

    public List<Cupcake> getCupcakes() {
        return cupcakes;
    }

    public boolean ajouterCupcake(Cupcake cupcake, StockManager stock, int quantite) {
        for (int i = 0; i < quantite; i++) {
            boolean ok = stock.consommer(cupcake.getBase())
                    && stock.consommer(cupcake.getCreme());

            for (Topping topping : cupcake.getToppings()) {
                ok &= stock.consommer(topping);
            }

            if (!ok) {
                System.out.println("❌ Ingrédients insuffisants, commande interrompue à l'exemplaire " + (i + 1));
                return false;
            }

            // Cloner le cupcake pour éviter qu’il pointe sur le même objet
            Cupcake copie = new Cupcake(cupcake.getBase(), cupcake.getCreme());
            for (Topping t : cupcake.getToppings()) {
                copie.ajouterTopping(t);
            }
            cupcakes.add(copie);
        }

        return true;
    }

    public boolean ajouterCupcakeDuJour(CupcakeDuJour cupcakeDuJour, StockManager stock, int quantite) {
        String nom = cupcakeDuJour.getNom();
        double prixReduit = cupcakeDuJour.getPrixReduit();

        for (int i = 0; i < quantite; i++) {
            if (!stock.estCupcakeDuJourDisponible(nom)) {
                System.out.println("❌ Cupcake du jour '" + nom + "' en rupture à l'exemplaire " + (i + 1));
                return false;
            }

            stock.consommerCupcakeDuJour(nom);

            Cupcake cupcakePromo = new Cupcake(null, null) {
                @Override
                public double calculerPrix() {
                    return prixReduit;
                }

                @Override
                public String toString() {
                    return "🧁 Cupcake du jour : " + nom + " (" + prixReduit + "€)";
                }
            };

            cupcakes.add(cupcakePromo);
        }

        return true;
    }

    public void afficherDetailsCommande() {
        System.out.println("📦 Détail de la commande :");
        System.out.println("Nombre total de cupcakes : " + cupcakes.size());

        int compteur = 1;
        for (Cupcake cupcake : cupcakes) {
            System.out.print("🧁 " + compteur++ + " → ");

            if (cupcake.getBase() == null && cupcake.getCreme() == null) {
                // Cupcake du jour (créé via classe anonyme)
                System.out.println(cupcake);
            } else {
                // Cupcake normal
                System.out.println("Cupcake personnalisé :");
                System.out.println("   - Base   : " + cupcake.getBase().getNom());
                System.out.println("   - Crème  : " + cupcake.getCreme().getNom());
                if (cupcake.getToppings().isEmpty()) {
                    System.out.println("   - Toppings : Aucun");
                } else {
                    System.out.println("   - Toppings :");
                    for (Topping t : cupcake.getToppings()) {
                        System.out.println("       * " + t.getNom());
                    }
                }
                System.out.println("   - Prix   : " + cupcake.calculerPrix() + "€");
            }
        }

        System.out.println("\n💰 Total final : " + String.format("%.2f", calculerTotal()) + "€");
        System.out.println("--------------------------------------\n");
    }



    @Override
    public String toString() {
        return "Commande{" +
                "cupcakes=" + cupcakes +
                ", total=" + calculerTotal() +
                '}';
    }
}
