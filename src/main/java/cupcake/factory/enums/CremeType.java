package cupcake.factory.enums;

public enum CremeType {
    VANILLE(0.8),
    CHOCOLAT(1.0),
    FRAMBOISE(1.1);

    private final double prix;

    CremeType(double prix) {
        this.prix = prix;
    }

    public double getPrix() {
        return prix;
    }
}

