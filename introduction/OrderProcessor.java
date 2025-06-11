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

    // Retourne un prix avec 10 % de réduction si le client est premium
    private double applyPremiumDiscount(double price, boolean isPremiumCustomer) {
        return isPremiumCustomer ? price * (1 - OrderConstants.PREMIUM_DISCOUNT) : price;
    }

    // Retourne un prix avec 20 % de réduction si le code est "HOLIDAY"
    private double applyHolidayDiscount(double price, String discountCode) {
        return OrderConstants.HOLIDAY_CODE.equals(discountCode) ? price * (1 - OrderConstants.HOLIDAY_DISCOUNT) : price;
    }

    // Applique une réduction fixe de 50 € si le total dépasse 1000 €
    private double applyBulkOrderDiscount(double total) {
        return total > 1000 ? total - OrderConstants.BULK_DISCOUNT : total;
    }

    // Applique une réduction fixe de 20 € si le nombre d'articles dépasse 10
    private double applyLargeItemDiscount(double total, int itemCount) {
        return itemCount > OrderConstants.LARGE_ITEM_THRESHOLD ? total - OrderConstants.LARGE_ITEM_DISCOUNT : total;
    }

    // Ajoute un supplément fixe de 100 € si la commande est internationale
    private double applyInternationalShippingFee(double total, boolean isInternational) {
        return isInternational ? total + OrderConstants.INTERNATIONAL_SHIPPING_FEE : total;
    }
}