package shopping;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProductCatalog implements IProductCatalog {
    private final Map<String, Product> products;

    public ProductCatalog() {
	this.products = new LinkedHashMap<>();
    }

    @Override
    public void addProduct(Product product) {
	if (product == null) {
	    System.out.println("Product cannot be null.");
	    return;
	}
	if (products.containsKey(product.getId())) {
	    System.out.println("Product with ID " + product.getId() + " already exists.");
	    return;
	}
	products.put(product.getId(), product);
	// System.out.println("Product added: " + product);
    }

    @Override
    public Product findProductById(String id) {
	if (id == null || id.trim().isEmpty()) {
	    System.out.println("Product ID cannot be null or empty.");
	    return null;
	}
	return products.get(id);
    }

    @Override
    public void listProducts() {
	if (products.isEmpty()) {
	    System.out.println("No products in the catalog.");
	    return;
	}
	products.values().forEach(System.out::println);
    }

    public void removeProduct(String id) {
	if (id == null || id.trim().isEmpty() || !products.containsKey(id)) {
	    System.out.println("Invalid ID or product does not exist.");
	    return;
	}
	products.remove(id);
	System.out.println("Product removed with ID: " + id);
    }
}