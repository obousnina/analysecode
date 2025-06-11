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
        TotalPrice.bulk(total);
        TotalPrice.large(total);
        TotalPrice.international(total);

        return total;
    }
}
