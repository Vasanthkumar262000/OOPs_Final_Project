package shopping;

public class ProductFactory {

    public Product createProduct(String type, String id, String name, double price, String additionalFeature) {
	validateProductData(id, name, price);

	switch (type.toLowerCase()) {
	case "electronics":
	    return new Electronics(id, name, price, additionalFeature);
	case "clothing":
	    return new Clothing(id, name, price, additionalFeature);
	case "kitchen":
	    return new Kitchen(id, name, price, additionalFeature);

	default:
	    throw new IllegalArgumentException("Unknown product type: " + type);
	}
    }

    private void validateProductData(String id, String name, double price) {
	if (id == null || id.trim().isEmpty()) {
	    throw new IllegalArgumentException("Product ID cannot be null or empty.");
	}
	if (name == null || name.trim().isEmpty()) {
	    throw new IllegalArgumentException("Product name cannot be null or empty.");
	}
	if (price < 0) {
	    throw new IllegalArgumentException("Product price cannot be negative.");
	}
    }
}
