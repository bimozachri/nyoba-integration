package contoh;

import java.util.ArrayList;
import java.util.List;

public class Kasir {
    private List<Item> items;

    public Kasir() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the cart.");
        } else {
            System.out.println("Items in the cart:");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void checkout() {
        displayItems();
        double total = calculateTotal();
        System.out.println("Total amount: " + total);
        items.clear();
        System.out.println("Thank you for your purchase!");
    }
}
