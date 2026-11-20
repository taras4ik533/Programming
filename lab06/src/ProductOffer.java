public class ProductOffer {

    private Product product;
    private double price;

    public ProductOffer(Product product, double price) {
        this.product = product;
        this.price = price;
    }

    public Product getProduct(){
        return this.product;
    }
    public double getPrice(){
        return this.price;
    }
}
