package edu.unomaha.pizza.topping;
public class SausageTopping extends MeatTopping {
	// public Float getPrice() {
		// return this.price;
	// }
	
	// public void setPrice(Float price) {
		// this.price = price;
	// }
	
	public void adjustSpiciness() {
		spiciness = spiciness * 2;
	}
	
	public String toString() {
		return "Sausage Topping";
	}
}
