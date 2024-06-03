package shopping;

public interface IProductCatalog {
    void addProduct(Product product);

    Product findProductById(String id);

    void listProducts();

    void removeProduct(String id);
}
