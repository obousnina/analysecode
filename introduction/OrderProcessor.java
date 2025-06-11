public class OrderProcessor {

    private static final double PREMIUM_DISCOUNT_RATE = 0.10; // 10% discount for premium customers
    private static final double HOLIDAY_DISCOUNT_RATE = 0.20; // 20% holiday discount
    private static final double BULK_ORDER_DISCOUNT = 50.0; // 50€ if total > 1000
    private static final double LARGE_ITEM_DISCOUNT = 20.0; // 20€ if order > 10
    private static final double INTERNATIONAL_SHIPPING_FEE = 100.0; // 100€ if command is international
    private static final double BULK_ORDER_THRESHOLD = 1000.0; // var for BULK_ORDER_THRESHOLD
    private static final int LARGE_ITEM_COUNT_THRESHOLD = 10; // var for applyLargeItemDiscount

    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = calculateTotalWithDiscounts(order, isPremiumCustomer, discountCode);
        total = applyBulkOrderDiscount(total);
        total = applyLargeItemDiscount(total, order);
        total = applyInternationalShippingFee(total, order);
        return total;
    }

    private double calculateTotalWithDiscounts(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = 0.0;
        for (OrderItem item : order.getItems()) {
            double price = item.getQuantity() * item.getUnitPrice();

            if (isPremiumCustomer) {
                price *= (1 - PREMIUM_DISCOUNT_RATE);
            }

            if ("HOLIDAY".equalsIgnoreCase(discountCode)) {
                price *= (1 - HOLIDAY_DISCOUNT_RATE);
            }

            total += price;
        }
        return total;
    }

    private double applyBulkOrderDiscount(double total) {
        return total > BULK_ORDER_THRESHOLD ? total - BULK_ORDER_DISCOUNT : total;
    }

    private double applyLargeItemDiscount(double total, Order order) {
        return order.getItems().size() > LARGE_ITEM_COUNT_THRESHOLD ? total - LARGE_ITEM_DISCOUNT : total;
    }

    private double applyInternationalShippingFee(double total, Order order) {
        return order.isInternational() ? total + INTERNATIONAL_SHIPPING_FEE : total;
    }
}
