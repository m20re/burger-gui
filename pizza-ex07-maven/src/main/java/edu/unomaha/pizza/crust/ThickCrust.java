package edu.unomaha.pizza.crust;
public class ThickCrust extends PizzaCrust {
	private Boolean isDeepDish;
	
	@Override
	public String toString() {
		return "Thick Crust";
	}
	
	public Boolean getIsDeepDish() {
		return isDeepDish;
	}
	
	public void setIsDeepDish(Boolean deep) {
		this.isDeepDish = deep;
	}
	
	@Override
	public String toNiceString() {
		return super.toNiceString() + (isDeepDish? " (Deep Dish)": "");
	}	
	
	@Override
	public String checkIntegrity() {
		return ingredient.equals("Cauliflower")? "Handle carefully - thick cauliflower crusts might fall apart." : "";
	}

	@Override
	public Double getPrice() {
		return 1.20; 
	}

}
