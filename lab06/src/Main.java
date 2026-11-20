import java.util.*;

public class Main {
    static void main(String[] args) {

        Product bread = new Product("Хліб", 30.0);
        Product milk = new Product("Молоко", 45.0);
        Product salami = new Product("Ковбаса", 92);
        Product cheese = new Product("Сир", 60);
        Product eggs = new Product("Яйця 10 шт", 75);
        Product water = new Product("Вода", 20); // товару немає в жодному магазині

        System.out.println("\n" + bread);
        System.out.println(milk);
        System.out.println(salami);
        System.out.println(cheese);
        System.out.println(eggs);
        System.out.println(water + "\n");

        OnlineStore silpo = new OnlineStore("Сільпо");
        OnlineStore atb = new OnlineStore("АТБ");
        OnlineStore velmart = new OnlineStore("Велмарт");

        silpo.addProduct(bread, 32);
        silpo.addProduct(milk, 40);
        silpo.addProduct(salami, 104);
        silpo.addProduct(cheese, 58);

        atb.addProduct(eggs, 65);
        atb.addProduct(cheese, 55);
        atb.addProduct(salami, 90);
        atb.addProduct(milk, 40);
        atb.addProduct(bread, 28);

        velmart.addProduct(salami, 88);
        velmart.addProduct(cheese, 65);

        ProductSearchService searchShop = new ProductSearchService();

        searchShop.addStore(silpo);
        searchShop.addStore(atb);
        searchShop.addStore(velmart);

        Double milkMinPrice = searchShop.findMinPrice(milk);
        Double cheeseMinPrice = searchShop.findMinPrice(cheese);
        Double eggsMinPrice = searchShop.findMinPrice(eggs);
        Double waterMinPrice = searchShop.findMinPrice(water);

        System.out.println("Мінімальна ціна на молоко: " + milkMinPrice);
        System.out.println("Мінімальна ціна на сир: " + cheeseMinPrice);
        System.out.println("Мінімальна ціна на яйця: " + eggsMinPrice);
        System.out.println("Мінімальна ціна на воду: " + waterMinPrice);

        List<OnlineStore> cheapMilk = searchShop.findStoresWithMinPrice(milk);
        List<OnlineStore> cheapBread = searchShop.findStoresWithMinPrice(bread);
        List<OnlineStore> cheapSalami = searchShop.findStoresWithMinPrice(salami);
        List<OnlineStore> cheapWater = searchShop.findStoresWithMinPrice(water);

        System.out.println("\n------ Магазини з найнижчою ціною на молоко ------");
        for (OnlineStore store: cheapMilk)
            System.out.println(store.getShopName());
        System.out.println("Магазини з найнижчою ціною на хліб: ");
        for (OnlineStore store: cheapBread)
            System.out.println(store.getShopName());
        System.out.println("Магазин з найнижчою ціною на ковбасу: ");
        for (OnlineStore store: cheapSalami)
            System.out.println(store.getShopName());
        System.out.println("Магазин з найнижчою ціною на воду: ");
        if (cheapWater.isEmpty())
            System.out.println("Немає в жодному магазині");
        for (OnlineStore store: cheapWater)
            System.out.println(store.getShopName());

        System.out.println("\n------ Чи є магазин де всі ціни нижчі за рекомендовані? ------");
        System.out.println(searchShop.hasStoreWithAllDiscounts());

        ProductSearchService test = new ProductSearchService();
        test.addStore(velmart);
        test.addStore(silpo);

        System.out.println("------ Для Сільпо і Велмарт? ------");
        System.out.println(test.hasStoreWithAllDiscounts());
    }
}
