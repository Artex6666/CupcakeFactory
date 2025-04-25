package cupcake.factory.models;

public abstract class Ingredient {
    protected String nom;
    protected double prix;

    public Ingredient(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return nom + " (" + prix + "€)";
    }
}
