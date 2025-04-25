package cupcake.factory.enums;

public enum BaseType {
    NATURE(1.0),
    CHOCOLAT(1.2),
    FOURREE(1.5);

    private final double prix;

    BaseType(double prix) {
        this.prix = prix;
    }

    public double getPrix() {
        return prix;
    }
}
