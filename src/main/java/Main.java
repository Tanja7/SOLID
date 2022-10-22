import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CatalogAndBasket catalogAndBasket = new CatalogAndBasket();
        catalogAndBasket.printCatalog();
        System.out.println("Введите два слова: название товара и количество. Или end");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)) break;
            String[] parts = line.split(" ");
            String product = parts[0];
            int count = Integer.parseInt(parts[1]);
            catalogAndBasket.addPurchase(product, count);
        }
        long sum = catalogAndBasket.sum();
        System.out.println("ИТОГО: " + sum);
    }
}
