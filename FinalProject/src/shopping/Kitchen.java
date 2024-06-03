package shopping;

public class Kitchen extends Product {
    private String kitchenFeature;

    public Kitchen(String id, String name, double price, String kitchenFeature) {
	super(id, name, price);
	this.kitchenFeature = kitchenFeature;
    }

    // Getters and setters for kitchenFeature

    @Override
    public String toString() {
	return super.toString() + ", KitchenFeature='" + kitchenFeature + "'";
    }

    public String getKitchenFeature() {
	// TODO Auto-generated method stub
	return kitchenFeature;
    }
}