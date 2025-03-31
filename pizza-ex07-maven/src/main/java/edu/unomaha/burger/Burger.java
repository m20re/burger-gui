package edu.unomaha.burger;

import java.util.ArrayList;
import java.util.Collections;

import edu.unomaha.burger.buns.BurgerBun;
import edu.unomaha.burger.cheese.BurgerCheese;
import edu.unomaha.burger.garnishes.BurgerGarnish;
import edu.unomaha.burger.meat.BurgerMeat;
import edu.unomaha.pizza.AbstractMenuItem;
import edu.unomaha.pizza.MenuItem;

public class Burger {
    private BurgerBun bun;
    private BurgerCheese cheese;
    private BurgerMeat meat;
    private ArrayList<BurgerGarnish> garnishList;
    private ArrayList<AbstractMenuItem> burgerComponents;

    public Burger() {
		this.bun = null;
		this.cheese = null;
		this.garnishList = new ArrayList<BurgerGarnish>();
		this.burgerComponents = new ArrayList<AbstractMenuItem>();
	}

	public BurgerBun getBun() {
		return this.bun;
	}

	public void setBun(BurgerBun bun) {
		this.bun = bun;
		this.addComponent(bun);
	}

	public BurgerCheese getCheese() {
		return this.cheese;
	}

	public void setCheese(BurgerCheese cheese) {
		this.cheese = cheese;
		this.addComponent(cheese);
	}

    public BurgerMeat getMeat() {
        return this.meat;
    }

    public void setMeat(BurgerMeat meat) {
        this.meat = meat;
        this.addComponent(meat);
    }

	public ArrayList<BurgerGarnish> getGarnish() {
		return this.garnishList;
	}

	public void setTopping(ArrayList<BurgerGarnish> garnishes) {
		this.garnishList = garnishes;
		this.getComponents().addAll(garnishes);
	}

	public void addTopping(BurgerGarnish garnish) {
		this.garnishList.add(garnish);
		this.addComponent(garnish);
	}

	public ArrayList<AbstractMenuItem> getComponents() {
		return this.burgerComponents;
	}

	public void addComponent(AbstractMenuItem item) {
		this.burgerComponents.add(item);
	}
	
	public String toNiceString() {
		return "Burger is: " + toString();
	}
	
	public String toString() {
		String burgerDescription = bun + ", " + cheese + ", " + meat;
		for (BurgerGarnish t : garnishList) {
			burgerDescription += ", " + t.toString();
		}
		return burgerDescription;
	}
	
	public void display() {
		for (MenuItem m : this.burgerComponents) {
			System.out.printf("%s $%.2f\n", m.toNiceString(), m.getPrice());
		}
	}
	
	public void displaySorted() {
		Collections.sort(this.burgerComponents);
		display();
	}
	
	public Double getPrice() {
		Double total = 0.0;
		for (MenuItem m : burgerComponents) {
			total += m.getPrice();
		}
		return total;
	}
}

// package edu.unomaha.pizza;
// import java.util.ArrayList;
// import java.util.Collections;

// import edu.unomaha.pizza.crust.PizzaCrust;
// import edu.unomaha.pizza.sauce.PizzaSauce;
// import edu.unomaha.pizza.topping.PizzaTopping;

// public class Pizza extends AbstractMenuItem {
// 	private PizzaCrust crust;
// 	private PizzaSauce sauce;
// 	private ArrayList<PizzaTopping> toppingList;
// 	private ArrayList<AbstractMenuItem> pizzaComponents;
	


