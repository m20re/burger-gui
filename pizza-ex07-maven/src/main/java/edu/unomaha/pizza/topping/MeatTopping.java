package edu.unomaha.pizza.topping;
public class MeatTopping extends PizzaTopping {
	protected Integer spiciness;

	public MeatTopping() {
		this.spiciness = 0;
	}
	
	public MeatTopping(Integer spiciness) {
		this.spiciness = spiciness;
	}

	public String toString() {
		return "Meat Topping";
	}
	
	public Integer getSpiciness() {
		return this.spiciness;
	}
	
	public void setSpiciness(Integer spiciness) {
		this.spiciness = spiciness;
	}
	
	@Override
	public String toNiceString() {
		return super.toNiceString() + " spiciness: " + spiciness;
	}

	@Override
	public Double getPrice() {
		return 0.60; 
	}

}
