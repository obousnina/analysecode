import model.Order;

public class OrderProcessor {

    /**
     * Processes an order by calculating the total price after applying discounts
     * based on customer type and discount codes.
     *
     * @param order             The order to process.
     * @param isPremiumCustomer Indicates if the customer is a premium customer.
     * @param discountCode      The discount code to apply, if any.
     * @return The total price after applying all discounts and fees.
     */
    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        double discountMultiplier = DiscountProcessor.getDiscountMultiplier(isPremiumCustomer, discountCode);

        return order.getTotalPrice(discountMultiplier);
    }
}
