import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contoh.Item;
import contoh.Kasir;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KasirTest {
    private Kasir cashierService;

    @BeforeEach
    public void setUp() {
        cashierService = new Kasir();
    }

    @Test
    public void testAddItem() {
        Item item = new Item("Apple", 1.0, 3);
        cashierService.addItem(item);

        assertEquals(1, cashierService.getItems().size());
        assertEquals(item, cashierService.getItems().get(0));
    }

    @Test
    public void testDisplayItems() {
        Item item1 = new Item("Apple", 1.0, 3);
        Item item2 = new Item("Banana", 0.5, 5);
        cashierService.addItem(item1);
        cashierService.addItem(item2);

        // Expected output
        String expectedOutput = "Items in the cart:\n" +
                                "Apple - 3 x 1.0 = 3.0\n" +
                                "Banana - 5 x 0.5 = 2.5\n";

        // Capture output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        cashierService.displayItems();
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

    @Test
    public void testCalculateTotal() {
        Item item1 = new Item("Apple", 1.0, 3);
        Item item2 = new Item("Banana", 0.5, 5);
        cashierService.addItem(item1);
        cashierService.addItem(item2);

        double expectedTotal = 5.5;
        assertEquals(expectedTotal, cashierService.calculateTotal(), 0.001);
    }

    @Test
    public void testCheckout() {
        Item item1 = new Item("Apple", 1.0, 3);
        Item item2 = new Item("Banana", 0.5, 5);
        cashierService.addItem(item1);
        cashierService.addItem(item2);

        // Expected output
        String expectedOutput = "Items in the cart:\n" +
                                "Apple - 3 x 1.0 = 3.0\n" +
                                "Banana - 5 x 0.5 = 2.5\n" +
                                "Total amount: 5.5\n" +
                                "Thank you for your purchase!\n";

        // Capture output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        cashierService.checkout();

        assertEquals(expectedOutput.trim(), outContent.toString().trim());
        assertTrue(cashierService.getItems().isEmpty());
    }
}
