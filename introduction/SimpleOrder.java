import java.util.Arrays;
import java.util.List;

import model.Order;
import model.OrderItem;

public class SimpleOrder {
  public static void main(String[] args) {
    OrderItem item1 = new OrderItem("Laptop", 1, 1200.00);
    OrderItem item2 = new OrderItem("Mouse", 2, 25.00);

    List<OrderItem> items = Arrays.asList(item1, item2);

    Order order = new Order(items, true); // International order

    boolean isPremiumCustomer = true;
    String discountCode = "HOLIDAY";

    OrderProcessor processor = new OrderProcessor();
    double totalPrice = processor.processOrder(order, isPremiumCustomer, discountCode);

    System.out.println("Total Price: " + totalPrice);
  }
}
