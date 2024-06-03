package shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    void createOrder_ShouldCorrectlyAssignFields() {
	// Arrange
	int orderId = 1;
	Map<Product, Integer> items = new HashMap<>();
	Product product1 = new Product("P001", "Test Product 1", 10.0);
	Product product2 = new Product("P002", "Test Product 2", 20.0);
	items.put(product1, 1);
	items.put(product2, 2);
	double totalCost = 50.0; // Assuming the total cost is calculated elsewhere

	// Act
	Order order = new Order(orderId, items, totalCost);

	// Assert
	assertEquals(orderId, order.getOrderId());
	assertEquals(items, order.getItems());
	assertEquals(totalCost, order.getTotalCost());
    }

}
