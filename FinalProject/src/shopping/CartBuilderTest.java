package shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CartBuilderTest {

    @Test
    void addProduct_ShouldAddProductToCart() {
	// Arrange
	CartBuilder cartBuilder = new CartBuilder();
	Product product = new Product("P1001", "Test Product", 19.99);
	int quantity = 2;

	// Act
	ShoppingCart cart = cartBuilder.addProduct(product, quantity).build();

	// Assert
	assertTrue(cart.containsProduct(product), "Product should be added to the cart.");
	assertEquals(quantity, cart.getProductQuantity(product), "Product quantity should be correct.");
    }

    @Test
    void removeProduct_ShouldRemoveProductFromCart() {
	// Arrange
	CartBuilder cartBuilder = new CartBuilder();
	Product product = new Product("P1002", "Another Product", 29.99);

	// Act
	ShoppingCart cart = cartBuilder.addProduct(product, 1).removeProduct(product).build();

	// Assert
	assertFalse(cart.containsProduct(product), "Product should be removed from the cart.");
    }

    @Test
    void updateProductQuantity_ShouldUpdateProductQuantityInCart() {
	// Arrange
	CartBuilder cartBuilder = new CartBuilder();
	Product product = new Product("P1003", "Yet Another Product", 39.99);
	int initialQuantity = 2;
	int updatedQuantity = 3;

	// Act
	ShoppingCart cart = cartBuilder.addProduct(product, initialQuantity)
		.updateProductQuantity(product, updatedQuantity).build();

	// Assert
	assertEquals(updatedQuantity, cart.getProductQuantity(product), "Product quantity should be updated.");
    }

    @Test
    void calculateTotalCost_ShouldCalculateCorrectTotalCost() {
	// Arrange
	CartBuilder cartBuilder = new CartBuilder();
	Product product1 = new Product("P1004", "Product 1", 10.0);
	Product product2 = new Product("P1005", "Product 2", 20.0);
	int quantity1 = 2;
	int quantity2 = 3;

	// Act
	double totalCost = cartBuilder.addProduct(product1, quantity1).addProduct(product2, quantity2)
		.calculateTotalCost();

	// Assert
	assertEquals((quantity1 * product1.getPrice() + quantity2 * product2.getPrice()), totalCost, 0.001,
		"Total cost should be calculated correctly.");
    }

    @Test
    void clearCart_ShouldRemoveAllProductsFromCart() {
	// Arrange
	CartBuilder cartBuilder = new CartBuilder();
	Product product1 = new Product("P1006", "Product A", 15.0);
	Product product2 = new Product("P1007", "Product B", 25.0);

	// Act
	ShoppingCart cart = cartBuilder.addProduct(product1, 1).addProduct(product2, 2).clearCart().build();

	// Assert
	assertTrue(cart.isEmpty(), "Cart should be empty after clearing.");
    }
}
