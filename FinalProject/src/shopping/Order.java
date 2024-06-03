package shopping;

import java.util.Map;

public class Order {
    private final int orderId;
    private final Map<Product, Integer> items;
    private final double totalCost;

    public Order(int orderId, Map<Product, Integer> items, double totalCost) {
	this.orderId = orderId;
	this.items = items;
	this.totalCost = totalCost;
    }

    public int getOrderId() {
	return orderId;
    }

    public Map<Product, Integer> getItems() {
	return items;
    }

    public double getTotalCost() {
	return totalCost;
    }
}
