import java.util.ArrayList;
import java.util.List;

public class OrderProcessor {
    private static final double PREMIUM_DISCOUNT = 0.1;
    private static final double HOLIDAY_DISCOUNT = 0.2;
    private static final double BULK_DISCOUNT = 50;
    private static final double ITEM_COUNT_DISCOUNT = 20;
    private static final double INTERNATIONAL_FEE = 100;
    private static final double BULK_ORDER_THRESHOLD = 1000;
    private static final int ITEM_COUNT_THRESHOLD = 10;

    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            total += applyItemDiscounts(item, isPremiumCustomer, discountCode);
        }
        total = applyOrderLevelDiscounts(total, order);
        total = applyShippingFees(total, order);
        return total;
    }




    private double applyItemDiscounts(OrderItem item, boolean isPremiumCustomer, String discountCode) {
        double price = item.getQuantity() * item.getUnitPrice();
        if (isPremiumCustomer) price *= (1 - PREMIUM_DISCOUNT);
        if ("HOLIDAY".equals(discountCode)) price *= (1 - HOLIDAY_DISCOUNT);
        return price;
    }

    private double applyOrderLevelDiscounts(double total, Order order) {
        if (total > BULK_ORDER_THRESHOLD) total -= BULK_DISCOUNT;
        if (order.getItems().size() > ITEM_COUNT_THRESHOLD) total -= ITEM_COUNT_DISCOUNT;
        return total;
    }

    private double applyShippingFees(double total, Order order) {
        return order.isInternational() ? total + INTERNATIONAL_FEE : total;
    }
}
