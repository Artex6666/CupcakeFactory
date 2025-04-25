package cupcake.factory.models;

import cupcake.factory.enums.ToppingType;

public class Topping extends Ingredient {
    private ToppingType type;

    public Topping(ToppingType type) {
        super(type.name(), type.getPrix());
        this.type = type;
    }

    public ToppingType getType() {
        return type;
    }
}
