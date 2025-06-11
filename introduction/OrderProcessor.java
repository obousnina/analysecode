public class OrderProcessor {
    private static final double PREMIUM_DISCOUNT = 0.10;
    private static final double BULK_ORDER_DISCOUNT = 50.0;
    private static final double MAX_ITEM_COUNT_DISCOUNT = 20.0;
    private static final double INTERNATIONAL_SHIPPING_FEE = 100.0;
    private static final double MAX_BULK_ORDER = 1000.0;
    private static final int MAX_ITEM_COUNT = 10;

    public double processOrder(Order order, boolean isPremiumCustomer, DiscountCode discountCode) {
        double total = calculateSubtotal(order, isPremiumCustomer, discountCode);
        total = applyOrderLevelDiscounts(total, order);
        total = applyShippingFee(total, order);
        return total;
    }

    private double calculateSubtotal(Order order, boolean isPremiumCustomer, DiscountCode discountCode) {
        double subtotal = 0.0;
        for (OrderItem item : order.getItems()) {
            double price = item.getQuantity() * item.getUnitPrice();
            double discount = 0.0;
            if (isPremiumCustomer) {
                price *= (1 - PREMIUM_DISCOUNT);
            }
            if(discountCode != null) {
                discount = discountCode.getDiscount();
            }
            price *= (1 - discount);
            subtotal += price;
        }
        return subtotal;
    }

    private double applyOrderLevelDiscounts(double total, Order order) {
        if (total > MAX_BULK_ORDER) {
            total -= BULK_ORDER_DISCOUNT;
        }
        if (order.getItems().size() > MAX_ITEM_COUNT) {
            total -= MAX_ITEM_COUNT_DISCOUNT;
        }
        return total;
    }

    private double applyShippingFee(double total, Order order) {
        if (order.isInternational()) {
            total += INTERNATIONAL_SHIPPING_FEE;
        }
        return total;
    }
}
