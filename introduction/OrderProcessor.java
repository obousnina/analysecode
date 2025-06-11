public class OrderProcessor {
    private final int bulkOrderThreshold = 10;
    private final int bulkOrderDiscount = -20;
    private final int internationalShippingFee = 100;
    private final double premiumCustomerPriceRatio = 0.9;
    private final double discountCodePriceRatio = 0.8;
    private final String availableDiscountCode = "HOLIDAY";


    public double applyDiscounts(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = 0;


        for (OrderItem item : order.getItems()) {
            double price = item.getQuantity() * item.getUnitPrice();
            total += price * getPriceRatio(isPremiumCustomer, discountCode);
        }

        total += calculateBulkOrderDiscount(order);
        total += calculateShippingCost(order);

        return total;
    }

    private double getPriceRatio(boolean isPremiumCustomer, String discountCode) {
        double priceRatio = 1.0;
        if (isPremiumCustomer) {
            priceRatio *= premiumCustomerPriceRatio;
        }
        if (discountCode != null && discountCode.equals(availableDiscountCode)) {
            priceRatio *= discountCodePriceRatio;
        }
        return priceRatio;
    }

    private int calculateBulkOrderDiscount(Order order) {
        if (order.getItems().size() > bulkOrderThreshold) {
            return bulkOrderDiscount;
        }
        return 0;
    }

    private int calculateShippingCost(Order order) {
        if (order.isInternational()) {
            return internationalShippingFee;
        }
        return 0;
    }
}
