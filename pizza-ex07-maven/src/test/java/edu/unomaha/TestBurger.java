package edu.unomaha;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import edu.unomaha.burger.garnishes.OnionringGarnish;
import edu.unomaha.burger.meat.BurgerMeat;
import edu.unomaha.burger.meat.ChickenMeat;
import edu.unomaha.pizza.Pizza;
import edu.unomaha.pizza.crust.PizzaCrust;
import edu.unomaha.pizza.crust.ThickCrust;
import edu.unomaha.pizza.sauce.PizzaSauce;
import edu.unomaha.pizza.sauce.TomatoSauce;
import edu.unomaha.pizza.topping.MozzarellaTopping;
import edu.unomaha.pizza.topping.PepperoniTopping;
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
        Burger burg = new Burger();
        initBurgerComponents();

        

    }
    
    @Test
    public void testBurgerAdd() {

        /* Creates a random burger */
        Burger burg = new Burger();
        initBurgerComponents();

        /* Checks price upon each added component */
        burg.addComponent(bun);
        assertEquals(0.50, burg.getPrice(), 0.0001);

        burg.addComponent(cheese);
        assertEquals(0.75, burg.getPrice(), 0.0001);

        burg.addComponent(meat);
        assertEquals(3.50, burg.getPrice(), 0.0001);

        burg.addComponent(garnish1);
        assertEquals(3.70, burg.getPrice(), 0.0001);
    
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
        assertEquals(1.20, pizza.getPrice(), 0.0001);

        pizza.addComponent(sauce);
        assertEquals(1.50, pizza.getPrice(), 0.0001);

        pizza.addComponent(topping);
        assertEquals(1.70, pizza.getPrice(), 0.0001);

        return;
    }

    @Test
    public void testBurgerAssemble() {
        Burger burg = new Burger();
        initBurgerComponents();

        /* Initializes a pizza */
        burg.addComponent(bun);
        burg.addComponent(cheese);
        burg.addComponent(meat);
        burg.addComponent(garnish1);
        /* Ensures the price is correct */
        assertEquals(3.7, burg.getPrice(), 0.0001);

        /* Initialize a garnish and add it */
        BurgerGarnish newGarnish = new OnionringGarnish();
        burg.addTopping(newGarnish);
        assertEquals(3.9, burg.getPrice(), 0.0001);

        /* Add burger to the burger instance */
        BurgerManager.getInstance().addBurger(burg);
        /* Recall that a burger was added in the prior tests */
        assertEquals(7.60, BurgerManager.getInstance().getPrice(), 0.0001);
    }

    

    @Test
    public void testPizzaAssemble() {
        Pizza pizza = new Pizza();
        initPizzaComponents();

        /* Initializes a pizza */
        pizza.addComponent(crust);
        pizza.addComponent(sauce);
        pizza.addComponent(topping);
        /* Ensures the price is correct */
        assertEquals(1.70, pizza.getPrice(), 0.0001);

        /* Initialize a topping and add it */
        PizzaTopping newTopping = new PepperoniTopping();
        pizza.addTopping(newTopping);
        assertEquals(2.30, pizza.getPrice(), 0.0001);
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
