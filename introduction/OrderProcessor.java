public class OrderProcessor {

    /**
     * Notes pour le cours :
     * Séparation des besoins/méthodes
     * Avoir une méthode "globale" qui gère le process de la commande (processOrder)
     * Sortir la logique métier :
     * - Calculer le prix brut de la commande (calculItemsTotal)
     * - Applicquer la remise pour les membres premiums (applyPremiumDiscount)
     * - Gérer les codes promos (promoCode)
     * - Gérer les remises exceptionnels sans code promo (applyDiscount)
     * Fait un switch / case pour gérer l'ajout d'autres codes promos
     * - Gérer les frais de livraison
     */

    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = calculItemsTotal(order, isPremiumCustomer, discountCode);
        total = applyDiscount(order, total);
        total = applyShipping(order, total);
        return total;
    }

    // Calcule du prix total brut des articles de la commande
    public double calculItemsTotal(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            double itemTotal = item.getQuantity() * item.getUnitPrice();
            itemTotal = applyPremiumDiscount(itemTotal, isPremiumCustomer);
            itemTotal = promoCode(itemTotal, discountCode);
            total += itemTotal;
        }
        return total;
    }

    // Application des réductions en cas de client premium
    private double applyPremiumDiscount(double price, boolean isPremiumCustomer) {
        return isPremiumCustomer ? price * 0.9 : price;
    }

    // Gestion des codes promos
    private double promoCode(double price, String discountCode) {
        switch (discountCode) {
            case "HOLIDAY":
                return price * 0.8;

            default:
                return price;
        }
    }

    // Gestion des remises selon critères de commande
    private double applyDiscount(Order order, double total) {
        if (total > 1000) {
            total -= 50;
        }
        if (order.getItems().size() > 10) {
            total -= 20;
        }
        return total;
    }

    // Gestion des frais de livraison
    private double applyShipping(Order order, double total) {
        if (order.isInternational()) {
            total += 100;
        }
        return total;
    }
}
