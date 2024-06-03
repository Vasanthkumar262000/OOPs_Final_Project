package shopping;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private static final ShoppingCart INSTANCE = new ShoppingCart();
    private final Map<Product, Integer> items;

    private ShoppingCart() {
	items = new HashMap<>();
    }

    public static ShoppingCart getInstance() {
	return INSTANCE;
    }

    public void addProduct(Product product, int quantity) {
	if (product == null || quantity <= 0) {
	    System.out.println("Invalid product or quantity.");
	    return;
	}
	items.put(product, items.getOrDefault(product, 0) + quantity);
	System.out.println("Added " + quantity + " unit(s) of " + product.getName() + " to the cart.");
    }

    public void removeProduct(Product product) {
	if (product == null || !items.containsKey(product)) {
	    System.out.println("Product not found in the cart.");
	    return;
	}
	items.remove(product);
	System.out.println("Removed " + product.getName() + " from the cart.");
    }

    public void updateProductQuantity(Product product, int quantity) {
	if (product == null || !items.containsKey(product) || quantity <= 0) {
	    System.out.println("Invalid product or quantity.");
	    return;
	}
	items.put(product, quantity);
	System.out.println("Updated quantity of " + product.getName() + " to " + quantity + " in the cart.");
    }

    public Map<Product, Integer> getItems() {
	return new HashMap<>(items);
    }

    public void viewCart() {
	if (items.isEmpty()) {
	    System.out.println("The shopping cart is empty.");
	    return;
	}
	items.forEach((product, quantity) -> System.out.println("Product: " + product + ", Quantity: " + quantity));
    }

    public double calculateTotalCost() {
	return items.entrySet().stream().mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue()).sum();
    }

    public boolean isEmpty() {
	return items.isEmpty();
    }

    public void clearCart() {
	items.clear();
	System.out.println("The shopping cart has been cleared.");
    }

    public Boolean containsProduct(Product product) {
	// TODO Auto-generated method stub
	return items.containsKey(product);
    }

    public Integer getProductQuantity(Product product) {
	// TODO Auto-generated method stub
	return items.get(product);
    }
}
