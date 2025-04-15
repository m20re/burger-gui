package edu.unomaha;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import edu.unomaha.burger.Burger;
import edu.unomaha.burger.BurgerManager;
import edu.unomaha.burger.buns.BriocheBun;
import edu.unomaha.burger.buns.BurgerBun;
import edu.unomaha.burger.cheese.AmericanCheese;
import edu.unomaha.burger.cheese.BurgerCheese;
import edu.unomaha.burger.garnishes.BaconGarnish;
import edu.unomaha.burger.garnishes.BurgerGarnish;
import edu.unomaha.burger.meat.BurgerMeat;
import edu.unomaha.burger.meat.ChickenMeat;
import edu.unomaha.pizza.Pizza;
import edu.unomaha.pizza.crust.PizzaCrust;
import edu.unomaha.pizza.crust.ThickCrust;
import edu.unomaha.pizza.sauce.PizzaSauce;
import edu.unomaha.pizza.sauce.TomatoSauce;
import edu.unomaha.pizza.topping.MozzarellaTopping;
import edu.unomaha.pizza.topping.PizzaTopping;

public class TestBurger {

    BurgerBun bun;
    BurgerCheese cheese;
    BurgerMeat meat;
    BurgerGarnish garnish1;

    PizzaCrust crust;
    PizzaSauce sauce;
    PizzaTopping topping;


    @BeforeEach
    public void setUp() {

    }
    
    @Test
    public void testBurgerAdd() {

        /* Creates a random burger */
        Burger burg = new Burger();
        initBurgerComponents();

        /* Checks price upon each added component */
        burg.addComponent(bun);
        assertEquals(0.50, burg.getPrice());

        burg.addComponent(cheese);
        assertEquals(0.75, burg.getPrice());

        burg.addComponent(meat);
        assertEquals(3.50, burg.getPrice());

        burg.addComponent(garnish1);
        assertEquals(3.70, burg.getPrice());
    
        /* Adds a burger to the particular instance, which mirrors GUI interaction. */
        BurgerManager.getInstance().addBurger(burg);
        /* Should return the last added total. */

        return;
    }

    @Test
    public void testPizzaAdd() {

        /* Creates a random burger */
        Pizza pizza = new Pizza();
        initPizzaComponents();

        /* Checks price upon each added component */
        pizza.addComponent(crust);
        assertEquals(1.20, pizza.getPrice());

        pizza.addComponent(sauce);
        assertEquals(1.50, pizza.getPrice());

        pizza.addComponent(topping);
        assertEquals(1.70, pizza.getPrice());

        return;
    }


    private void initBurgerComponents() {
        bun = new BriocheBun();
        cheese = new AmericanCheese();
        meat = new ChickenMeat();
        garnish1 = new BaconGarnish();
        return;
    }

    private void initPizzaComponents() {
        crust = new ThickCrust();
        sauce = new TomatoSauce();
        topping = new MozzarellaTopping();
    }
}
