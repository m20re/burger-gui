package edu.unomaha.pizza;
import java.util.ArrayList;
import java.util.Collections;

import edu.unomaha.pizza.crust.PizzaCrust;
import edu.unomaha.pizza.sauce.PizzaSauce;
import edu.unomaha.pizza.topping.PizzaTopping;

public class Pizza extends AbstractMenuItem {
	private PizzaCrust crust;
	private PizzaSauce sauce;
	private ArrayList<PizzaTopping> toppingList;
	private ArrayList<AbstractMenuItem> pizzaComponents;
	
	public Pizza() {
		this.crust = null;
		this.sauce = null;
		this.toppingList = new ArrayList<PizzaTopping>();
		this.pizzaComponents = new ArrayList<AbstractMenuItem>();
	}

	public PizzaCrust getCrust() {
		return this.crust;
	}

	public void setCrust(PizzaCrust crust) {
		this.crust = crust;
		this.addComponent(crust);
	}

	public PizzaSauce getSauce() {
		return this.sauce;
	}

	public void setSauce(PizzaSauce sauce) {
		this.sauce = sauce;
		this.addComponent(sauce);
	}

	public ArrayList<PizzaTopping> getTopping() {
		return this.toppingList;
	}

	public void setTopping(ArrayList<PizzaTopping> toppings) {
		this.toppingList = toppings;
		this.getComponents().addAll(toppings);
	}

	public void addTopping(PizzaTopping topping) {
		this.toppingList.add(topping);
		this.addComponent(topping);
	}

	public ArrayList<AbstractMenuItem> getComponents() {
		return this.pizzaComponents;
	}

	public void addComponent(AbstractMenuItem item) {
		this.pizzaComponents.add(item);
	}
	
	public String toNiceString() {
		return "Pizza is: " + toString();
	}
	
	public String toString() {
		String pizzaDesc = crust + ", " + sauce;
		for (PizzaTopping t : toppingList) {
			pizzaDesc += ", " + t.toString();
		}
		return pizzaDesc;
	}
	
	public void display() {
		for (MenuItem m : this.pizzaComponents) {
			System.out.printf("%s $%.2f\n", m.toNiceString(), m.getPrice());
		}
	}
	
	public void displaySorted() {
		Collections.sort(this.pizzaComponents);
		display();
	}
	
	public Double getPrice() {
		Double total = 0.0;
		for (MenuItem m : pizzaComponents) {
			total += m.getPrice();
		}
		return total;
	}
}
