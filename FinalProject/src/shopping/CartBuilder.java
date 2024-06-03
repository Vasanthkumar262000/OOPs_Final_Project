package shopping;

public class CartBuilder {
    private final ShoppingCart cart;

    public CartBuilder() {
	this.cart = ShoppingCart.getInstance();
    }

    public CartBuilder addProduct(Product product, int quantity) {
	cart.addProduct(product, quantity);
	return this;
    }

    public CartBuilder removeProduct(Product product) {
	cart.removeProduct(product);
	return this;
    }

    public CartBuilder updateProductQuantity(Product product, int quantity) {
	cart.updateProductQuantity(product, quantity);
	return this;
    }

    public CartBuilder viewCart() {
	cart.viewCart();
	return this;
    }

    public double calculateTotalCost() {
	return cart.calculateTotalCost();
    }

    public CartBuilder clearCart() {
	cart.clearCart();
	return this;
    }

    public ShoppingCart build() {
	return cart;
    }
}
