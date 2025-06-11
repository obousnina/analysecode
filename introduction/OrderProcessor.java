public class OrderProcessor {
    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            double price = item.getQuantity() * item.getUnitPrice();
            // 10% discount for premium customers
            if (isPremiumCustomer) {
                price *= 0.9;
            }
            // 20% holiday discount
            if (discountCode != null && discountCode.equals("HOLIDAY")) {
                price *= 0.8;
            }
            total += price;
        }
        if (total > 1000) {
            // bulk order discount
            total -= 50;
        }
        if (order.getItems().size() > 10) {
            // discount for large number of items
            total -= 20;
        }
        if (order.isInternational()) {
            // international shipping fee
            total += 100;
        }
        return total;
    }
}
