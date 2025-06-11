public class OrderProcessor {
    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            double price = item.getQuantity() * item.getUnitPrice();
            // 10% discount for premium customers
            if (isPremiumCustomer) {
                price *= 0.9;
            }
            // 20% holiday discount
            if (discountCode != null && discountCode.equals("HOLIDAY")) {
                price *= 0.8;
            }
            total += price;
        }
        if (total > 1000) {
            // bulk order discount
            total -= 50;
        }
        if (order.getItems().size() > 10) {
            // discount for large number of items
            total -= 20;
        }
        if (order.isInternational()) {
            // international shipping fee
            total += 100;
        }
        return total;
    }
}

import introduction.OrderConstants;

public class OrderProcessorRefactorized {
    private Map<String, Double> discountCodes;
    // TODO : Consider using a database / API for discount codes
    public OrderProcessorRefactorized() {
        this.discountCodes = new HashMap<>();
        this.discountCodes.put("HOLIDAY", 0.8);
        // Example of other discount codes
        // this.discountCodes.put("SUMMER", 0.85);
        // this.discountCodes.put("WELCOME", 0.95);
    }

    // Method with improved processing logic
    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = calculateBaseTotal(order, isPremiumCustomer, discountCode);
        total = setBulkOrderDiscount(total);
        total = setLargeItemDiscount(total, order);
        total = setInternationalShippingFee(total, order);
        return total;
    }

    private double calculateBaseTotal(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            double price = item.getQuantity() * item.getUnitPrice();
            
            if (isPremiumCustomer) {
                price *= OrderConstants.PREMIUM_DISCOUNT_RATE;
            }
            
            if (discountCode != null && discountCodes.containsKey(discountCode)) {
                price *= discountCodes.get(discountCode);
            }
            
            total += price;
        }
        return total;
    }

    private double setBulkOrderDiscount(double total) {
        if (total > OrderConstants.BULK_ORDER_THRESHOLD) {
            return total - OrderConstants.BULK_ORDER_DISCOUNT;
        }
        return total;
    }

    private double setLargeItemDiscount(double total, Order order) {
        if (order.getItems().size() > OrderConstants.LARGE_ITEM_THRESHOLD) {
            return total - OrderConstants.LARGE_ITEM_DISCOUNT;
        }
        return total;
    }

    private double setInternationalShippingFee(double total, Order order) {
        if (order.isInternational()) {
            return total + OrderConstants.INTERNATIONAL_FEE;
        }
        return total;
    }
}


// Example usage
Order order = new Order();
OrderProcessorRefactorized.processOrder(order, true, "HOLIDAY");