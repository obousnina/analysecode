import java.util.concurrent.atomic.AtomicReference;

public class OrderProcessor {
    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        AtomicReference<Double> total = new AtomicReference<>((double) 0);
        order.getItems().foreach((item) -> total.updateAndGet(price -> new Double((double) (price + getPrice(item, isPremiumCustomer, discountCode)))));
        return getRealPrice(total.get(), order);
    }

    private double getPrice(OrderItem item, boolean isPremiumCustomer, String discountCode) {
        double price = item.getQuantity() * item.getUnitPrice();
        // 10% discount for premium customers
        if (isPremiumCustomer) {
            price *= 0.9;
        }
        // 20% holiday discount
        if (discountCode != null && discountCode.equals(DiscountCode.HOLIDAY_CODE)) {
            price *= 0.8;
        }
        return price;
    }

    private double getRealPrice(double price, Order order) {
        var newPrice = price;
        if (price > Constant.BULK_ORDER) {
            // bulk order discount
            newPrice -= 50;
        }
        if (order.getItems().size() > Constant.LARGE_ITEM) {
            // discount for large number of items
            newPrice -= 20;
        }
        if (order.isInternational()) {
            // international shipping fee
            newPrice += 100;
        }
        return newPrice;
    }
}
