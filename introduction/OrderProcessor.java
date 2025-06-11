public class OrderProcessor {
    private static final double PREMIUM_DISCOUNT = 0.9;
    private static final double HOLIDAY_DISCOUNT = 0.8;
    private static final String HOLIDAY_CODE = "HOLIDAY";
    private static final double HIGH_AMOUNT_THRESHOLD = 1000;
    private static final double HIGH_AMOUNT_DISCOUNT = 50;
    private static final int BULK_ITEMS_THRESHOLD = 10;
    private static final double BULK_ITEMS_DISCOUNT = 20;
    private static final double INTERNATIONAL_FEE = 100;
    
    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            double price = item.getQuantity() * item.getUnitPrice();
            total += price;
        }
        
        total = applyDiscounts(total, order, isPremiumCustomer, discountCode);
        total = applyTaxesAndFees(total, order);
        
        return total;
    }
    
    private double applyDiscounts(double total, Order order, boolean isPremiumCustomer, String discountCode) {
        if (isPremiumCustomer) {
            total *= PREMIUM_DISCOUNT;
        }
        
        if (discountCode != null && discountCode.equals(HOLIDAY_CODE)) {
            total *= HOLIDAY_DISCOUNT;
        }
        
        if (total > HIGH_AMOUNT_THRESHOLD) {
            total -= HIGH_AMOUNT_DISCOUNT;
        }
        
        if (order.getItems().size() > BULK_ITEMS_THRESHOLD) {
            total -= BULK_ITEMS_DISCOUNT;
        }
        
        return total;
    }
    
    private double applyTaxesAndFees(double total, Order order) {
        if (order.isInternational()) {
            total += INTERNATIONAL_FEE;
        }
        
        return total;
    }
}

// Séparation des discounts et des taxes en 2 méthodes différentes + changement des valeurs hardcodées en constantes