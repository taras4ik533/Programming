import java.util.*;

public class OnlineStore {

    private String shopName;
    private List<ProductOffer> offers;

    public OnlineStore(String shopName){
        this.shopName = shopName;
        this.offers = new ArrayList<>();
    }

    public void addProduct(Product product, double price){
        ProductOffer productOffer = new ProductOffer(product, price);
        offers.add(productOffer);
    }

    public Double getPrice(Product product){
        for (ProductOffer item: offers) {
            if (item.getProduct().equals(product))
                return item.getPrice();
        }
        return null;
    }

    public String getShopName(){
        return this.shopName;
    }

    public List<ProductOffer> getOffers(){
        return this.offers;
    }
}
