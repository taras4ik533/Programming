import java.util.*;

public class ProductSearchService {

    private List<OnlineStore> shopList;

    public ProductSearchService() {
        this.shopList = new ArrayList<>();
    }

    public void addStore(OnlineStore store) {
        shopList.add(store);
    }

    public Double findMinPrice(Product product) {
        Double minPrice = null;
        Iterator<OnlineStore> iterator = shopList.iterator();

        while (iterator.hasNext()) {
            OnlineStore current = iterator.next();
            Double price = current.getPrice(product);

            if (price == null)
                continue;
            if (minPrice == null)
                minPrice = price;
            else if (minPrice > price)
                minPrice = price;
        }
        return minPrice;
    }

    public List<OnlineStore> findStoresWithMinPrice(Product product) {
        List<OnlineStore> result = new ArrayList<>();
        Double minPrice = findMinPrice(product);
        if (minPrice == null)
            return result;
        Iterator iterator = shopList.iterator();


        while (iterator.hasNext()) {
            OnlineStore store = (OnlineStore) iterator.next();
            Double tempPrice = store.getPrice(product);
            if (tempPrice != null && tempPrice.equals(minPrice))
                result.add(store);
        }
        return result;
    }

    public boolean hasStoreWithAllDiscounts() {
        for (OnlineStore store : shopList) {
            boolean allDiscounted = true;
            if (store.getOffers().isEmpty()) continue;
            for (ProductOffer offer : store.getOffers()) {
                if (offer.getPrice() >= offer.getProduct().getRecommendedPrice()) {
                    allDiscounted = false;
                    break;
                }
            }
            if (allDiscounted) return true;
        }
        return false;
    }
}
