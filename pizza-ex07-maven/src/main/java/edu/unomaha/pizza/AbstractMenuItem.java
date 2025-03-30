package edu.unomaha.pizza;

public abstract class AbstractMenuItem implements MenuItem, Comparable<MenuItem> {
	
    public int compareTo(MenuItem m) {
        return (this.getPrice() > m.getPrice()) ?  1 : (this.getPrice() < m.getPrice()) ? -1 : 0;
    }
}
