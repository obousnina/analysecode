import java.util.concurrent.atomic.AtomicReference;

public class OrderProcessor {

    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        AtomicReference<Double> total = new AtomicReference<>((double) 0);
        order.getItems().foreach((item) -> total.updateAndGet(price -> new Double((double) (price + getPrice(item, isPremiumCustomer, discountCode)))));
        return getRealPrice(total.get(), order);
    }

    private double getPrice(OrderItem item, boolean isPremiumCustomer, String discountCode) {
        double price = item.getQuantity() * item.getUnitPrice();
        if (isPremiumCustomer) {
            price *= DiscountConstant.PREMIUM_DISCOUNT;
        }
        if (discountCode != null && discountCode.equals(DiscountConstant.HOLIDAY_CODE)) {
            price *= DiscountConstant.HOLIDAY_DISCOUNT;
        }
        return price;
    }

    private double getRealPrice(double price, Order order) {
        var newPrice = price;
        if (price > Constant.BULK_ORDER) {
            newPrice -= DiscountConstant.BULK_REDUCE;
        }
        if (order.getItems().size() > Constant.LARGE_ITEM) {
            newPrice -= DiscountConstant.LARGE_ITEM_REDUCE;
        }
        if (order.isInternational()) {
            newPrice += DiscountConstant.INTERNATIONAL_AUGMENTATION;
        }
        return newPrice;
    }
}
