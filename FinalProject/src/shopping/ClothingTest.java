package shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ClothingTest {

    @Test
    void createClothing_ShouldCorrectlyAssignFields() {
	// Arrange
	String id = "C1001";
	String name = "Test Clothing";
	double price = 39.99;
	String clothingFeature = "Test Feature";

	// Act
	Clothing clothing = new Clothing(id, name, price, clothingFeature);

	// Assert
	assertEquals(id, clothing.getId(), "ID should be correctly assigned.");
	assertEquals(name, clothing.getName(), "Name should be correctly assigned.");
	assertEquals(price, clothing.getPrice(), 0.001,
		"Price should be correctly assigned with a tolerance of 0.001.");
	assertEquals(clothingFeature, clothing.getClothingFeature(), "Clothing feature should be correctly assigned.");
    }

    @Test
    void toString_ShouldReturnFormattedString() {
	// Arrange
	String id = "C1001";
	String name = "Test Clothing";
	double price = 39.99;
	String clothingFeature = "Test Feature";
	Clothing clothing = new Clothing(id, name, price, clothingFeature);

	// Act
	String result = clothing.toString();

	// Assert
	assertTrue(result.contains(id), "Result should contain the ID.");
	assertTrue(result.contains(name), "Result should contain the name.");
	assertTrue(result.contains(String.valueOf(price)), "Result should contain the price.");
	assertTrue(result.contains(clothingFeature), "Result should contain the clothing feature.");
    }
}
