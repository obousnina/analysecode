import java.util.List;

public class PricingPolicy {

    public static final double BULK_ORDER_THRESHOLD = 1000;
    public static final double BULK_ORDER_DISCOUNT = 50;
    public static final int LARGE_ITEM_THRESHOLD = 10;
    public static final double LARGE_ITEM_COUNT_DISCOUNT = 20;
    public static final double INTERNATIONAL_SHIPPING_FEE = 100;

    private final boolean isPremiumCustomer;
    private final DiscountType discountType;

    public PricingPolicy(boolean isPremiumCustomer, DiscountType discountType) {
        this.isPremiumCustomer = isPremiumCustomer;
        this.discountType = discountType;
    }

    public double calculateTotal(List<OrderItem> items) {
        double total = 0;
        for (OrderItem item : items) {
            double price = item.getQuantity() * item.getUnitPrice();
            price = applyDiscounts(price);
            total += price;
        }
        return total;
    }

    public boolean isBulkOrder(double total) {
        return total > PricingPolicy.BULK_ORDER_THRESHOLD;
    }

    public boolean hasManyItems(Order order) {
        return order.getItems().size() > PricingPolicy.LARGE_ITEM_THRESHOLD;
    }

    private double applyDiscounts(double price) {
        if (isPremiumCustomer) {
            price *= 0.9;
        }
        if (discountType == DiscountType.HOLIDAY) {
            price *= 0.8;
        }
        return price;
    }

}
