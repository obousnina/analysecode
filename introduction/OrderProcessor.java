/**
 * Classe permettant de calculer le montant d'une commande en prenant en compte le statut du client,
 * un code de réduction et les frais de livraisons
 */
public class OrderProcessor {
    // Constantes utilisées pour calculer le montant d'une commande
    private static final String HOLIDAY_DISCOUNT_CODE = "HOLIDAY";
    private static final double PREMIUM_CUSTOMER_DISCOUNT = 0.9;
    private static final double HOLIDAY_DISCOUNT = 0.8;
    private static final int BULK_ORDER_COND = 1000;
    private static final int BULK_ORDER_DISCOUNT = 50;
    private static final int LARGE_ORDER_ITEM_COND = 10;
    private static final int LARGE_ORDER_DISCOUNT = 20;
    private static final int INTERNATIONAL_SHIPPING_FEE = 100;

    /**
     * Calcule le montant total d'une commande en appliquant les réductions appropriées
     * @param order La commande à traiter
     * @param isPremiumCustomer Le client est premium ?
     * @param discountCode Code de réduction 
     * @return Le montant total de la commande après application des réductions
     * @throws IllegalArgumentException si la commande est null
     */
    public double processOrder(Order order, boolean isPremiumCustomer, String discountCode) {
        if (order == null) {
            throw new IllegalArgumentException("La commande ne peut pas être null");
        }
        
        double total = calculateBaseTotal(order, isPremiumCustomer, discountCode);
        
        if (total > BULK_ORDER_COND) {
            total = total - BULK_ORDER_DISCOUNT;
        }
        
        if (order.getItems().size() > LARGE_ORDER_ITEM_COND) {
            total = total - LARGE_ORDER_DISCOUNT;
        }
        
        // Ajout des frais de livraison si la commande est internationale
        if (order.isInternational()) {
            total = total + INTERNATIONAL_SHIPPING_FEE;
        }
        
        return total;
    }

    /**
     * Calcule le montant de base de la commande en appliquant les réductions de isPremiumCustomer et de discountCode
     * @param order La commande à traiter
     * @param isPremiumCustomer Indique si le client est premium ou non
     * @param discountCode Code de réduction
     * @return Le montant de base avec les réductions de isPremiumCustomer et de discountCode
     */
    private double calculateBaseTotal(Order order, boolean isPremiumCustomer, String discountCode) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            if (item == null) {
                continue; // Ignorer les items null
            }
            
            double itemPrice = item.getQuantity() * item.getUnitPrice();
            
            // Application des réductions pour le client premium
            if (isPremiumCustomer) {
                itemPrice = itemPrice * PREMIUM_CUSTOMER_DISCOUNT;
            }
            
            // Application de la réduction pour le code de réduction de vacances
            if (HOLIDAY_DISCOUNT_CODE.equals(discountCode)) {
                itemPrice = itemPrice * HOLIDAY_DISCOUNT;
            }
            
            total = total + itemPrice;
        }
        return total;
    }
}
