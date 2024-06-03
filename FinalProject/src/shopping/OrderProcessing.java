package shopping;

import java.util.HashMap;

public class OrderProcessing {
    private static int nextOrderId = 1;
    private final PaymentProcessing paymentProcessor;

    public OrderProcessing(PaymentProcessing paymentProcessor) {
	this.paymentProcessor = paymentProcessor;
    }

    public void processOrder(ShoppingCart cart) {
	if (cart.isEmpty()) {
	    System.out.println("Error: Cannot process order. Shopping Cart is empty.");
	    return;
	}

	double totalCost = cart.calculateTotalCost();
	if (!paymentProcessor.processPayment(totalCost)) {
	    System.out.println("Error: Payment failed. Order processing terminates.");
	    return;
	}

	int orderId = generateOrderId();
	Order order = createOrder(orderId, cart, totalCost);
	completeOrderProcessing(order);

	cart.clearCart();
	System.out.println("Success: Order processed successfully. Shopping Cart cleared.");
    }

    private int generateOrderId() {
	return nextOrderId++;
    }

    private Order createOrder(int orderId, ShoppingCart cart, double totalCost) {
	return new Order(orderId, new HashMap<>(cart.getItems()), totalCost);
    }

    private void completeOrderProcessing(Order order) {
	updateInventory(order);
	sendOrderConfirmation(order.getOrderId());
	System.out.println("Order ID: " + order.getOrderId() + " processed with total cost: $" + order.getTotalCost());
    }

    private void updateInventory(Order order) {
	// Implement inventory update logic
	System.out.println("Success: Inventory updated for Order ID: " + order.getOrderId());
    }

    private void sendOrderConfirmation(int orderId) {
	// Implement order confirmation logic
	System.out.println("Success: Order confirmation sent for Order ID: " + orderId);
    }
}
