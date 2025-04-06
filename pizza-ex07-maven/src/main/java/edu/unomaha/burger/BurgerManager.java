package edu.unomaha.burger;

import java.util.ArrayList;
import java.util.List;

/* Used for persistent burger management */
public class BurgerManager {
    private static BurgerManager burgerInstance;
    private List<Burger> burgers = new ArrayList<>();

    private BurgerManager() {
        System.out.println("Started burger manager");
    }

    public static BurgerManager getInstance() {

        if (burgerInstance == null) {
            burgerInstance = new BurgerManager();
        }
        return burgerInstance;
    }

    public void addBurger(Burger burger) {
        burgers.add(burger);
    }

    public List<Burger> getBurgers() {
        return burgers;
    }
}

