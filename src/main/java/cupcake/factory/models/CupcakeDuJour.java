package cupcake.factory.models;

public class CupcakeDuJour {
    private final String nom;
    private final double prix;

    public CupcakeDuJour(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public double getPrixReduit() {
        return prix * 0.6;
    }

    @Override
    public String toString() {
        return nom + " → " + this.getPrixReduit() + "€";
    }
}
