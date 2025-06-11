import java.util.List;

public class OrderProcessor {

    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        if (order == null || order.getItems() == null || order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order or order items cannot be null or empty");
        }

        PricingPolicy pricingPolicy = new PricingPolicy(isPremiumCustomer, DiscountType.fromCode(discountCode));
        double total = pricingPolicy.calculateTotal(order.getItems());

        if (pricingPolicy.isBulkOrder(total)) {
            total -= PricingPolicy.BULK_ORDER_DISCOUNT;
        }

        if (pricingPolicy.hasManyItems(order)) {
            total -= PricingPolicy.LARGE_ITEM_COUNT_DISCOUNT;
        }

        if (order.isInternational()) {
            total += PricingPolicy.INTERNATIONAL_SHIPPING_FEE;
        }

        return total;
    }
}
