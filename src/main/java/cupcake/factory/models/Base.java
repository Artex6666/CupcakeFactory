package cupcake.factory.models;

import cupcake.factory.enums.BaseType;

public class Base extends Ingredient {
    private BaseType type;

    public Base(BaseType type) {
        super(type.name(), type.getPrix());
        this.type = type;
    }

    public BaseType getType() {
        return type;
    }
}
