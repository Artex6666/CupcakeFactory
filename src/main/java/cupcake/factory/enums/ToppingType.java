package cupcake.factory.enums;

public enum ToppingType {
    VERMICELLES(0.5),
    MARSHMALLOW(0.7),
    COOKIE_DOUGH(1.0);

    private final double prix;

    ToppingType(double prix) {
        this.prix = prix;
    }

    public double getPrix() {
        return prix;
    }
}