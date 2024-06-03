package shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class KitchenTest {

    @Test
    void createKitchen_ShouldCorrectlyAssignFields() {
	// Arrange
	String id = "K1001";
	String name = "Test Kitchen";
	double price = 49.99;
	String kitchenFeature = "Test Feature";

	// Act
	Kitchen kitchen = new Kitchen(id, name, price, kitchenFeature);

	// Assert
	assertEquals(id, kitchen.getId(), "ID should be correctly assigned.");
	assertEquals(name, kitchen.getName(), "Name should be correctly assigned.");
	assertEquals(price, kitchen.getPrice(), 0.001, "Price should be correctly assigned with a tolerance of 0.001.");
	assertEquals(kitchenFeature, kitchen.getKitchenFeature(), "Kitchen feature should be correctly assigned.");
    }

    @Test
    void toString_ShouldReturnFormattedString() {
	// Arrange
	String id = "K1001";
	String name = "Test Kitchen";
	double price = 49.99;
	String kitchenFeature = "Test Feature";
	Kitchen kitchen = new Kitchen(id, name, price, kitchenFeature);

	// Act
	String result = kitchen.toString();

	// Assert
	assertTrue(result.contains(id), "Result should contain the ID.");
	assertTrue(result.contains(name), "Result should contain the name.");
	assertTrue(result.contains(String.valueOf(price)), "Result should contain the price.");
	assertTrue(result.contains(kitchenFeature), "Result should contain the kitchen feature.");
    }
}
