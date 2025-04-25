package cupcake.factory.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Commande {
    private List<Cupcake> cupcakes;

    public Commande() {
        this.cupcakes = new ArrayList<>();
    }

    public void ajouterCupcake(Cupcake c) {
        cupcakes.add(c);
    }

    public double calculerTotal() {
        if (cupcakes.isEmpty()) return 0.0;

        double total = 0.0;

        if (cupcakes.size() >= 6) {
            // règle : le moins cher est offert (hors cupcake du jour, à gérer ailleurs)
            Cupcake moinsCher = cupcakes.stream()
                    .min(Comparator.comparingDouble(Cupcake::calculerPrix))
                    .orElse(null);
            total = cupcakes.stream().mapToDouble(Cupcake::calculerPrix).sum();
            if (moinsCher != null) {
                total -= moinsCher.calculerPrix();
            }
        } else {
            total = cupcakes.stream().mapToDouble(Cupcake::calculerPrix).sum();
        }

        return total;
    }

    public List<Cupcake> getCupcakes() {
        return cupcakes;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "cupcakes=" + cupcakes +
                ", total=" + calculerTotal() +
                '}';
    }
}

