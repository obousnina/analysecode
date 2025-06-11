public class OrderProcessor {
    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            total += this.calculateItemPrice(item, isPremiumCustomer, discountCode);
        }
        total = this.applyBulkOrderDiscount(total);
        total = this.applyLargeNumberDiscount(order.getItems().size(), total);
        total = this.applyInternationnalShippingFee(total);
        return total;
    }

    private double calculateItemPrice(OrderItem item, boolean isPremiumCustomer, String discountCode) {
        double price = item.getQuantity() * item.getUnitPrice();
        // 10% discount for premium customers
        if(isPremiumCustomer) {
            price *= Constants.PREMIUM_DISCOUNT;
        }
        // 20% holiday discount
        if(discountCode !=null&&discountCode.equals("HOLIDAY")){
            price *= Constants.HOLIDAY_DISCOUNT;
        }
        return price;
    }
    private double applyBulkOrderDiscount(double total) {
        return total > Constants.BULK_ORDER_THRESHOLD
                ? total - Constants.BULK_ORDER_DISCOUNT
                : total;
    }
    private double applyLargeNumberDiscount(int order.getItems().size(), double total) {
        // discount for large number of items
        return order.getItems().size() > Constants.LARGE_NUMBER_THRESHOLD
                ? total - Constants.LARGE_NUMBER_DISCOUNT
                : total;
    }
    private double applyInternationnalShippingFee(double total) {
        // international shipping fee
        return order.isInternational()
                ? total + Constants.INTERNATIONAL_SHIPPING_FEE
                : total;
    }
}
