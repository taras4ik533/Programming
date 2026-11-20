public class Product {

    private final String name;
    private final double recommendedPrice;

    public Product(String name, double recommendedPrice) {
        this.name = name;
        this.recommendedPrice = recommendedPrice;
    }
    public String getName(){
        return this.name;
    }

    public double getRecommendedPrice(){
        return this.recommendedPrice;
    }

    @Override
    public String toString() {
        return name + " - Рекомендована ціна: " + recommendedPrice + " грн";
    }
}