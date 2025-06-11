public class OrderProcessor {

    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = calculateOrderTotal(order, isPremiumCustomer, discountCode);
        total = applyBulkOrderDiscount(total);
        total = applyLargeItemDiscount(total, order);
        total = applyInternationalShippingFee(total, order);
        return total;
    }

// Calcul du total de la commande avec des réductions pour les clients premium et les vacances

    private double calculateOrderTotal(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            double price = item.getQuantity() * item.getUnitPrice();
            price = applyPremiumCustomerDiscount(price, isPremiumCustomer);
            price = applyHolidayDiscount(price, discountCode);
            total += price;
        }
        return total;
    }

// Réduction pour les clients premium et les vacances

    private double applyPremiumCustomerDiscount(double price, boolean isPremiumCustomer) {
        if (isPremiumCustomer) {
            price *= 0.9;
        }
        return price;
    }

    private double applyHolidayDiscount(double price, String discountCode) {
        if ("HOLIDAY".equals(discountCode)) {
            price *= 0.8; // Réduction de 20% pour les vacances
        }
        return price;
    }

// Réduction pour les commandes en gros

    private double applyBulkOrderDiscount(double total) {
        if (total > 1000) {
            total -= 50;
        }
        return total;
    }
// Réduction pour les articles volumineux

    private double applyLargeItemDiscount(double total, Order order) {
        if (order.getItems().size() > 10) {
            total -= 20;
        }
        return total;
    }

// Frais d'expédition pour les commandes internationales

    private double applyInternationalShippingFee(double total, Order order) {
        if (order.isInternational()) {
            total += 100;
        }
        return total;
    }
}