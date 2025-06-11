public class OrderProcessor {

    private static final double PREMIUM_DISCOUNT = 0.9;
    private static final double HOLIDAY_DISCOUNT = 0.8;
    private static final double BULK_DISCOUNT = 50.0;
    private static final double LARGE_ORDER_DISCOUNT = 20.0;
    private static final double INTERNATIONAL_FEE = 100.0;

    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            total += calculateItemPrice(item, isPremiumCustomer, discountCode);
        }

        total = applyBulkDiscount(total);
        total = applyItemCountDiscount(total, order);
        total = addInternationalShipping(total, order);

        return total;
    }

    private double calculateItemPrice(OrderItem item, boolean isPremiumCustomer, String discountCode) {
        double price = item.getQuantity() * item.getUnitPrice();
        if (isPremiumCustomer) {
            price *= PREMIUM_DISCOUNT;
        }
        if ("HOLIDAY".equals(discountCode)) {
            price *= HOLIDAY_DISCOUNT;
        }
        return price;
    }

    private double applyBulkDiscount(double total) {
        return total > 1000 ? total - BULK_DISCOUNT : total;
    }

    private double applyItemCountDiscount(double total, Order order) {
        return order.getItems().size() > 10 ? total - LARGE_ORDER_DISCOUNT : total;
    }

    private double addInternationalShipping(double total, Order order) {
        return order.isInternational() ? total + INTERNATIONAL_FEE : total;
    }
}
