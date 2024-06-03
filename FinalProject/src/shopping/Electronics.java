package shopping;

public class Electronics extends Product {
    private String electronicFeature;

    public Electronics(String id, String name, double price, String electronicFeature) {
	super(id, name, price);
	this.electronicFeature = electronicFeature;
    }

    // Getters and setters methods- electronicFeature

    @Override
    public String toString() {
	return super.toString() + ", ElectronicFeature='" + electronicFeature + "'";
    }
}
