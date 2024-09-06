import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;


public class ProductData {

    public static void main(String[] args) {

        List<Product> products = ProductData.getProducts();

        // Все товары, которые стоят больше 1000 единиц
        List<Product> expensiveProducts = products.stream()
                .filter(product -> product.getPrice() > 1000)
                .collect(Collectors.toList());
        System.out.println("Товары, которые стоят больше 1000 единиц: " + expensiveProducts);

        // Общее количество товаров на складе в категории "Electronics"
        long electronicsStockCount = products.stream()
                .filter(product -> product.getCategory().equals("Electronics"))
                .mapToLong(Product::getStock)
                .sum();
        System.out.println("Общее количество товаров на складе в категории 'Electronics': " + electronicsStockCount);

        // Самый дорогой товар
        Product mostExpensiveProduct = Collections.max(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("Самый дорогой товар: " + mostExpensiveProduct);

        // Список товаров, отсортированных по количеству на складе в порядке убывания
        List<Product> sortedByStock = products.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getStock(), p1.getStock()))
                .collect(Collectors.toList());
        System.out.println("Список товаров, отсортированных по количеству на складе в порядке убывания: " + sortedByStock);

        // Количество уникальных категорий товаров
        long uniqueCategoriesCount = products.stream()
                .map(Product::getCategory)
                .distinct()
                .count();
        System.out.println("Количество уникальных категорий товаров: " + uniqueCategoriesCount);
    }

    public static List<Product> getProducts() {
        return Arrays.asList(
                new Product("Laptop", "Electronics", 1200.00, 5),
                new Product("Smartphone", "Electronics", 800.00, 10),
                new Product("Refrigerator", "Appliances", 1500.00, 3),
                new Product("T-shirt", "Clothing", 25.00, 50),
                new Product("Blender", "Appliances", 300.00, 7),
                new Product("Jeans", "Clothing", 40.00, 30),
                new Product("Headphones", "Electronics", 150.00, 15),
                new Product("TV", "Electronics", 2200.00, 2),
                new Product("Toaster", "Appliances", 45.00, 10),
                new Product("Sneakers", "Clothing", 60.00, 20)
        );
    }
}

class Product {
    private String name;
    private String category;
    private double price;
    private int stock;

    public Product(String name, String category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}