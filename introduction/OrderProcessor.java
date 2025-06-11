public class OrderProcessor {

    private static final double VIP_CUSTOMER_DISCOUNT = 0.10;
    private static final double FESTIVE_DISCOUNT = 0.20;
    private static final double HIGH_VALUE_ORDER_REDUCTION = 50.0;
    private static final double MANY_ITEMS_REDUCTION = 20.0;
    private static final double EXTRA_CHARGE_FOR_INTERNATIONAL = 100.0;
    private static final double DISCOUNT_TRIGGER_AMOUNT = 1000.0;
    private static final int ITEM_COUNT_LIMIT = 10;
    private static final String HOLIDAY_CODE = "HOLIDAY";

    public double processOrder(Order order, boolean isVipCustomer, String discountCode) {
        validateOrder(order);

        double total = calculateTotalItems(order, isVipCustomer, discountCode);
        total = applyDiscounts(total, order);
        total = applyShippingCost(total, order);

        return total;
    }

    private void validateOrder(Order order) {
        if (order == null || order.getItems() == null) {
            throw new IllegalArgumentException("Order and order items must not be null");
        }
    }

    private double calculateTotalItems(Order order, boolean isVipCustomer, String discountCode) {
        double total = 0.0;
        for (OrderItem item : order.getItems()) {
            double itemTotal = item.getQuantity() * item.getUnitPrice();

            if (isVipCustomer) {
                itemTotal *= (1 - VIP_CUSTOMER_DISCOUNT);
            }

            if (HOLIDAY_CODE.equalsIgnoreCase(discountCode)) {
                itemTotal *= (1 - FESTIVE_DISCOUNT);
            }

            total += itemTotal;
        }
        return total;
    }

    private double applyDiscounts(double total, Order order) {
        if (total > DISCOUNT_TRIGGER_AMOUNT) {
            total -= HIGH_VALUE_ORDER_REDUCTION;
        }

        if (order.getItems().size() > ITEM_COUNT_LIMIT) {
            total -= MANY_ITEMS_REDUCTION;
        }

        return total;
    }

    private double applyShippingCost(double total, Order order) {
        if (order.isInternational()) {
            total += EXTRA_CHARGE_FOR_INTERNATIONAL;
        }
        return total;
    }
}

// Amélioration du code :
// - Suppression des magic numbers via des const nommées
// - Découpage de la méthode processOrder en sous-méthodes private pour plus de lisibilité
// - Ajout d'une vérification de null sur l'objet Order
// - Comparaison de chaînes sécurisée avec equalsIgnoreCase