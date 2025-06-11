/**
 * Class to process an Order.
 */
public class OrderProcessor {

    private static final double PREMIUM_CUSTOMER_DISCOUNT = 0.9;
    private static final double HOLIDAY_DISCOUNT = 0.8;
    private static final int BULKER_ORDER_DISCOUNT = 50;
    private static final int BULK_TRESHOLD = 1000;
    private static final int LARGE_ITEM_TRESHOLD = 10;
    private static final int LARGE_ITEM_DISCOUNT = 20;
    private static final int INTERNATIONAL_SHIPPING = 100;
    private static final String HOLIDAY_DISCOUNT_CODE = "HOLIDAY";

    /**
     * Compute the price of the order applying discount code and premium customer discount if needed.
     *
     * @param order             is the Order to compute. The Order contains every items to compute.
     * @param isPremiumCustomer is a boolean which allows to know if the custom is premium or not.
     * @param discountCode      is the discount code to apply to the order.
     * @return a double which is the total of the order with discounts applied.
     */
    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = 0;

        for (OrderItem item : order.getItems()) {
            double price = computePriceOf(item);

            if (isPremiumCustomer) {
                price *= PREMIUM_CUSTOMER_DISCOUNT;
            }

            if (discountCode != null && discountCode.equalsIgnoreCase(HOLIDAY_DISCOUNT_CODE)) {
                price *= HOLIDAY_DISCOUNT;
            }
            total += price;
        }

        if (total > BULK_TRESHOLD) {
            total -= BULKER_ORDER_DISCOUNT;
        }

        if (order.getItems().size() > LARGE_ITEM_TRESHOLD) {
            total -= LARGE_ITEM_DISCOUNT;
        }

        if (order.isInternational()) {
            total += INTERNATIONAL_SHIPPING;
        }
        return total;
    }

    /**
     * Compute the price of an OrderItem
     *
     * @param item is an OrderItem.
     * @return a double which correspond to the price of the OrderItem computed.
     */
    private double computePriceOf(OrderItem item) {
        return item.getQuantity() * item.getUnitPrice();
    }
}
