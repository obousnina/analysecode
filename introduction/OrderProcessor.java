
/**
 * Calcule le total final d'une commande après application des remises et frais.
 */
public class OrderProcessor {
    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = 0;
        // Traite chaque article de la commande
        for (OrderItem item : order.getItems()) {
            // Prix de base = quantité * prix unitaire
            double price = item.getQuantity() * item.getUnitPrice();
            // Applique une réduction de 10 % pour les clients premium
            price = applyPremiumDiscount(price, isPremiumCustomer);
            // Applique une réduction de 20 % si le code "HOLIDAY" est utilisé
            price = applyHolidayDiscount(price, discountCode);
            total += price;
        }

        // Applique une remise de 50 € pour les commandes dépassant 1000 €
        total = applyBulkOrderDiscount(total);
        // Applique une remise de 20 € si plus de 10 articles sont commandés
        total = applyLargeItemDiscount(total, order.getItems().size());
        // Ajoute un supplément de 100 € pour les commandes internationales
        total = applyInternationalShippingFee(total, order.isInternational());

        return total;
    }

    // Retourne un prix avec 10 % de réduction si le client est premium
    private double applyPremiumDiscount(double price, boolean isPremiumCustomer) {
        return isPremiumCustomer ? price * 0.9 : price;
    }

    // Retourne un prix avec 20 % de réduction si le code est "HOLIDAY"
    private double applyHolidayDiscount(double price, String discountCode) {
        return "HOLIDAY".equals(discountCode) ? price * 0.8 : price;
    }

    // Applique une réduction fixe de 50 € si le total dépasse 1000 €
    private double applyBulkOrderDiscount(double total) {
        return total > 1000 ? total - 50 : total;
    }

    // Applique une réduction fixe de 20 € si le nombre d'articles dépasse 10
    private double applyLargeItemDiscount(double total, int itemCount) {
        return itemCount > 10 ? total - 20 : total;
    }

    // Ajoute un supplément fixe de 100 € si la commande est internationale
    private double applyInternationalShippingFee(double total, boolean isInternational) {
        return isInternational ? total + 100 : total;
    }
}