package introduction;

import java.util.Map;

import introduction.OrderConstants;

public class OrderProcessor {

    /**
     * Calculates the total amount of an order by applying all applicable discounts
     * and additional fees based on customer profile and order characteristics.
     *
     * @param orderItems        List of order items as a Map (key: item ID, value: array [quantity, unit price])
     * @param isInternational   Indicates if the order is international
     * @param isPremiumCustomer Indicates if the customer has premium status
     * @param discountCode      Optional promotional code (can be null)
     * @return The final total amount of the order after applying all rules
     * @throws IllegalArgumentException if orderItems is null
     */
    public double processOrder(Map<String, double[]> orderItems, boolean isInternational,
                               boolean isPremiumCustomer, String discountCode) {
        if (orderItems == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        double total = calculateItemsSubtotal(orderItems, isPremiumCustomer, discountCode);
        total = applyOrderLevelDiscounts(orderItems, total);
        total = applyAdditionalFees(isInternational, total);
        return total;
    }

    /**
     * Calculates the items subtotal with individual discounts applied.
     *
     * @param orderItems        Map of items (key: item ID, value: array [quantity, unit price])
     * @param isPremiumCustomer Premium customer status
     * @param discountCode      Promotional code
     * @return Subtotal after item-level discounts
     */
    private double calculateItemsSubtotal(Map<String, double[]> orderItems, boolean isPremiumCustomer, String discountCode) {
        double subtotal = 0.0;
        boolean isHolidayDiscount = OrderConstants.HOLIDAY_DISCOUNT_CODE.equals(discountCode);

        for (Map.Entry<String, double[]> item : orderItems.entrySet()) {
            double quantity = item.getValue()[0];
            double unitPrice = item.getValue()[1];
            double itemPrice = quantity * unitPrice;

            // Apply item-level discounts
            if (isPremiumCustomer) {
                itemPrice *= OrderConstants.PREMIUM_DISCOUNT;
            }

            if (isHolidayDiscount) {
                itemPrice *= OrderConstants.HOLIDAY_DISCOUNT;
            }

            subtotal += itemPrice;
        }

        return subtotal;
    }

    /**
     * Applies discounts based on total amount or number of items.
     *
     * @param orderItems Map of items
     * @param total      Current total amount
     * @return Amount after applying order-level discounts
     */
    private double applyOrderLevelDiscounts(Map<String, double[]> orderItems, double total) {
        if (total > OrderConstants.BULK_ORDER_THRESHOLD) {
            total -= OrderConstants.BULK_ORDER_DISCOUNT;
        }

        if (orderItems.size() > OrderConstants.LARGE_ORDER_THRESHOLD) {
            total -= OrderConstants.LARGE_ORDER_DISCOUNT;
        }

        return total;
    }

    /**
     * Applies additional fees based on order characteristics.
     *
     * @param isInternational Indicates if the order is international
     * @param total           Current total amount
     * @return Final amount after adding fees
     */
    private double applyAdditionalFees(boolean isInternational, double total) {
        if (isInternational) {
            total += OrderConstants.INTERNATIONAL_SHIPPING_FEE;
        }

        return total;
    }
}
