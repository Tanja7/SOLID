import java.util.HashMap;
import java.util.Map;

public class CatalogAndBasket {
    // класс, предназначен для внесения товаров, доступных для покупки и цен на них
    // а также для работы с корзиной
    protected HashMap<String, Integer> products;
    protected Purchase[] purchases;

    public CatalogAndBasket() {
        products = new HashMap<>();
        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);
        purchases = new Purchase[products.size()];
    }

    public void printCatalog() {
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (
                Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
    }

    // метод добавления покупки в корзину
    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public long sum() {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length; i++) {
            Purchase purchase = purchases[i];
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме "
                    + (purchase.count * products.get(purchase.title)) + " руб.");
            sum += purchase.count * products.get(purchase.title);
        }
        return sum;
    }
}
