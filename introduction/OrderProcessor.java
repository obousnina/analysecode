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

public class OrderProcessorRefactorized {
    private Map<String, Double> discountCodes;
    
    // Constants for reusability and clarity
    // TODO : Consider importing it from a database / API and not hardcoding
    private static final double PREMIUM_DISCOUNT_RATE = 0.9;
    private static final double BULK_ORDER_THRESHOLD = 1000;
    private static final double BULK_ORDER_DISCOUNT = 50;
    private static final int LARGE_ITEM_THRESHOLD = 10;
    private static final double LARGE_ITEM_DISCOUNT = 20;
    private static final double INTERNATIONAL_FEE = 100;

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
                price *= PREMIUM_DISCOUNT_RATE;
            }
            
            if (discountCode != null && discountCodes.containsKey(discountCode)) {
                price *= discountCodes.get(discountCode);
            }
            
            total += price;
        }
        return total;
    }

    private double setBulkOrderDiscount(double total) {
        if (total > BULK_ORDER_THRESHOLD) {
            return total - BULK_ORDER_DISCOUNT;
        }
        return total;
    }

    private double setLargeItemDiscount(double total, Order order) {
        if (order.getItems().size() > LARGE_ITEM_THRESHOLD) {
            return total - LARGE_ITEM_DISCOUNT;
        }
        return total;
    }

    private double setInternationalShippingFee(double total, Order order) {
        if (order.isInternational()) {
            return total + INTERNATIONAL_FEE;
        }
        return total;
    }
}


// Example usage
Order order = new Order();
OrderProcessorRefactorized.processOrder(order, true, "HOLIDAY");