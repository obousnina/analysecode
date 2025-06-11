public class OrderProcessor {
    public double processOrder(Order order, DiscountCode discount) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            double price = item.getQuantity() * item.getUnitPrice();

            switch (discount){
                case PREMIUM -> price *= 0.9;
                case HOLIDAY -> price *= 0.8;
                case NONE ->  price *= 1; // nécessitera peut-être d'altérer la structure des données
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
