package edu.unomaha.burger.meat;

import edu.unomaha.pizza.AbstractMenuItem;

public abstract class BurgerMeat extends AbstractMenuItem {
    public abstract String toString();

    public String toNiceString() {
        return "Meat is: " + toString();
    }

    public Double getPrice() {
        return 2.10;
    }
}
