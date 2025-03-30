package edu.unomaha.pizza.topping;
public class CheeseTopping extends PizzaTopping {
	@Override
	public String toString() {
		return "Cheese Topping";
	}

	@Override
	public Double getPrice() {
		return 0.20; 
	}
}
