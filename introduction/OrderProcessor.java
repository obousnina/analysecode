/*
 * Refactoring :
 * - Extraction de constantes pour remplacer les valeurs codées en dur.
 * - Remplacement de la boucle for par un stream pour une meilleure lisibilité.
 * - Création de deux méthodes privées : calculateItemPrice et applyOrderLevelDiscounts.
 * - Utilisation de "HOLIDAY".equals(discountCode) pour éviter les NullPointerException.
 * - Respect des bonnes pratiques de nommage pour les constantes et les méthodes.
 */
public class OrderProcessor {

    private static final double PREMIUM_DISCOUNT_RATE = 0.9;
    private static final double HOLIDAY_DISCOUNT_RATE = 0.8;
    private static final double BULK_ORDER_DISCOUNT = 50.0;
    private static final double LARGE_ITEM_DISCOUNT = 20.0;
    private static final double INTERNATIONAL_SHIPPING_FEE = 100.0;
    private static final int LARGE_ITEM_THRESHOLD = 10;
    private static final double BULK_ORDER_THRESHOLD = 1000.0;

    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = order.getItems().stream()
                .mapToDouble(item -> calculateItemPrice(item, isPremiumCustomer, discountCode))
                .sum();

        total = applyOrderLevelDiscounts(order, total);

        if (order.isInternational()) {
            total += INTERNATIONAL_SHIPPING_FEE;
        }

        return total;
    }

    private double calculateItemPrice(OrderItem item, boolean isPremiumCustomer, String discountCode) {
        double price = item.getQuantity() * item.getUnitPrice();

        if (isPremiumCustomer) {
            price *= PREMIUM_DISCOUNT_RATE;
        }

        if ("HOLIDAY".equals(discountCode)) {
            price *= HOLIDAY_DISCOUNT_RATE;
        }

        return price;
    }

    private double applyOrderLevelDiscounts(Order order, double total) {
        if (total > BULK_ORDER_THRESHOLD) {
            total -= BULK_ORDER_DISCOUNT;
        }

        if (order.getItems().size() > LARGE_ITEM_THRESHOLD) {
            total -= LARGE_ITEM_DISCOUNT;
        }

        return total;
    }
}