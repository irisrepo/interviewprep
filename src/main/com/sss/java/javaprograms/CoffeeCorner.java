package src.main.com.sss.java.javaprograms;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class CoffeeCorner {

    public static class Item {
        String name;
        double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    public static class Order {
        List<Item> items;
        int beverageCount;

        public Order() {
            this.items = new ArrayList<>();
            this.beverageCount = 0;
        }

        public void addItem(Item item) {
            this.items.add(item);
            if (item.name.toLowerCase().contains("coffee") || item.name.toLowerCase().contains("juice")) {
                this.beverageCount++;
            }
        }

        public double calculateTotal() {
            double total = 0;
            int beverageCount = 0;
            boolean hasSnack = false;
            boolean hasExtra = false;

            for (Item item : this.items) {
                total += item.price;
                if (item.name.toLowerCase().contains("coffee") || item.name.toLowerCase().contains("juice")) {
                    beverageCount++;
                }
                if (item.name.toLowerCase().contains("roll")) {
                    hasSnack = true;
                }
                if (item.name.toLowerCase().contains("milk") || item.name.toLowerCase().contains("roast")) {
                    hasExtra = true;
                }
            }

            if (beverageCount % 5 == 0 && beverageCount > 0) {
                total -= this.items.stream()
                        .filter(item -> item.name.toLowerCase().contains("coffee") || item.name.toLowerCase().contains("juice"))
                        .mapToDouble(item -> item.price)
                        .min()
                        .orElse(0);
            }

            if (hasSnack && hasExtra) {
                total -= this.items.stream()
                        .filter(item -> item.name.toLowerCase().contains("milk") || item.name.toLowerCase().contains("roast"))
                        .mapToDouble(item -> item.price)
                        .min()
                        .orElse(0);
            }

            return total;
        }

        public void printReceipt() {
            System.out.println("Charlene's Coffee Corner");
            System.out.println("------------------------");
            for (Item item : this.items) {
                System.out.printf("%-30s %.2f CHF\n", item.name, item.price);
            }
            System.out.println("------------------------");
            System.out.printf("Total: %.2f CHF\n", calculateTotal());
        }
    }

    public static void main(String[] args) {
        Order order = new Order();
        order.addItem(new Item("Large Coffee with Extra Milk", 3.50 + 0.30));
        order.addItem(new Item("Small Coffee with Special Roast", 2.50 + 0.90));
        order.addItem(new Item("Bacon Roll", 4.50));
        order.addItem(new Item("Orange Juice", 3.95));
        order.printReceipt();
    }

    public static class CoffeeCornerTest {

        @Test
        public void testCalculateTotal_NoDiscount() {
            Order order = new Order();
            order.addItem(new Item("Small Coffee", 2.50));
            order.addItem(new Item("Bacon Roll", 4.50));
            assertEquals(7.00, order.calculateTotal(), 0.01);
        }

        @Test
        public void testCalculateTotal_FifthBeverageFree() {
            Order order = new Order();
            order.addItem(new Item("Small Coffee", 2.50));
            order.addItem(new Item("Medium Coffee", 3.00));
            order.addItem(new Item("Large Coffee", 3.50));
            order.addItem(new Item("Orange Juice", 3.95));
            order.addItem(new Item("Small Coffee", 2.50));
            assertEquals(12.95, order.calculateTotal(), 0.01);
        }

        @Test
        public void testCalculateTotal_FreeExtra() {
            Order order = new Order();
            order.addItem(new Item("Small Coffee with Extra Milk", 2.50 + 0.30));
            order.addItem(new Item("Bacon Roll", 4.50));
            assertEquals(6.80, order.calculateTotal(), 0.01);
        }

        @Test
        public void testCalculateTotal_BothDiscounts() {
            Order order = new Order();
            order.addItem(new Item("Small Coffee", 2.50));
            order.addItem(new Item("Medium Coffee", 3.00));
            order.addItem(new Item("Large Coffee", 3.50));
            order.addItem(new Item("Orange Juice", 3.95));
            order.addItem(new Item("Small Coffee with Extra Milk", 2.50 + 0.30));
            order.addItem(new Item("Bacon Roll", 4.50));
            assertEquals(15.95, order.calculateTotal(), 0.01);
        }
    }
}
