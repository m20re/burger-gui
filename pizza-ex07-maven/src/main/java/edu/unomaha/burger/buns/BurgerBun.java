package edu.unomaha.burger.buns;

import edu.unomaha.pizza.AbstractMenuItem;

public abstract class BurgerBun extends AbstractMenuItem {
    public abstract String toString();

    public String toNiceString() {
        return "The bun is: " + toString();
    }

    public Double getPrice() {
        return 0.50;
    }
}
