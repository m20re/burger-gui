package edu.unomaha.burger.cheese;

import edu.unomaha.pizza.AbstractMenuItem;

public abstract class BurgerCheese extends AbstractMenuItem {
    public abstract String toString();

    public String toNiceString() {
        return "Cheese is: " + toString();
    }

    public Double getPrice() {
        return 0.25;
    }
}