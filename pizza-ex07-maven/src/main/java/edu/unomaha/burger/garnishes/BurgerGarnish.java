package edu.unomaha.burger.garnishes;

import edu.unomaha.pizza.AbstractMenuItem;

public abstract class BurgerGarnish extends AbstractMenuItem {
    public abstract String toString();

    public String toNiceString() {
        return "Garnish is: " + toString();
    }

    public Double getPrice() {
        return 0.20;
    }
}