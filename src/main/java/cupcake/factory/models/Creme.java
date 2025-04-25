package cupcake.factory.models;

import cupcake.factory.enums.CremeType;

public class Creme extends Ingredient {
    private CremeType type;

    public Creme(CremeType type) {
        super(type.name(), type.getPrix());
        this.type = type;
    }

    public CremeType getType() {
        return type;
    }
}
