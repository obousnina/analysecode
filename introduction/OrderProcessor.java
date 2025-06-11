import java.util.Arrays;
import java.util.Map;

public class OrderProcessor {
    private Map<String, Double> discountCodes;
    private double premiumCustomerDiscount = 1;
    private Integer bulkDiscount = 0;
    private Integer orderSizeDiscount = 0;
    private Integer internationalDiscount = 0;
    // TODO : Add bulk and order size thresholds


    public OrderProcessor(double premiumCustomerDiscount, Map<String, Double> discountCodes, Integer orderSizeDiscount, Integer bulkDiscount, Integer internationalDiscount) {
        this.discountCodes = discountCodes;
        this.premiumCustomerDiscount = premiumCustomerDiscount;
        this.bulkDiscount= bulkDiscount;
        this.orderSizeDiscount = orderSizeDiscount;
        this.internationalDiscount = internationalDiscount;
    }

    // TODO Setters / Getters

    private double applyDiscountCode(double price, String code) {
        if (this.discountCodes.containsKey(code)) {
            double discount = this.discountCodes.get(code);
            price *= discount;
        }
        return price;
    }

    private double applyPremiumCustomerDiscount(double price, Boolean isPremiumCustomer) {
        if (isPremiumCustomer) {
            price *= this.premiumCustomerDiscount;
        }
        return price;
    }

    private double applyOrderDiscount(double total, Order order) {
        if (total > 1000) {
            total += this.bulkDiscount;
        }

        if (order.getItems().size() > 10) {
            total += this.orderSizeDiscount;
        }

        if (order.isInternational()) {
            total += this.internationalDiscount;
        }

        return total;
    }

    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = Arrays.stream(order.getItems())
            .mapToDouble(item -> item.getQuantity() * item.getUnitPrice())
            .map(price -> applyPremiumCustomerDiscount(price, isPremiumCustomer))
            .map(price -> applyDiscountCode(price, discountCode))
            .sum();
        
        return applyOrderDiscount(total, order);
    }
}
