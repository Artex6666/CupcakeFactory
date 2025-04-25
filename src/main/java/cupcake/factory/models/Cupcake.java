package cupcake.factory.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cupcake {
    private Base base;
    private Creme creme;
    private List<Topping> toppings;

    public Cupcake(Base base, Creme creme) {
        this.base = base;
        this.creme = creme;
        this.toppings = new ArrayList<>();
    }

    public void ajouterTopping(Topping topping) {
        if (toppings.size() >= 2) {
            throw new IllegalArgumentException("Un cupcake ne peut avoir que 2 toppings maximum.");
        }
        toppings.add(topping);
    }

    public double calculerPrix() {
        double prix = base.getPrix() + creme.getPrix();

        if (toppings.isEmpty()) return prix;

        // le moins cher est offert
        Topping moinsCher = toppings.stream()
                .min(Comparator.comparingDouble(Topping::getPrix))
                .orElse(null);

        for (Topping t : toppings) {
            prix += t.getPrix();
        }

        if (moinsCher != null) {
            prix -= moinsCher.getPrix(); // premier topping offert (le moins cher)
        }

        return prix;
    }

    @Override
    public String toString() {
        return "Cupcake : " + base.getNom() + ", " + creme.getNom() + ", toppings=" + toppings;
    }
}
