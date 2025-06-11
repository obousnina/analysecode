package introduction;

/*
* This files holds all constants related to order processing.
*/
public final class OrderConstants {
    private OrderConstants() {
        throw new AssertionError("Cette classe ne doit pas être instanciée");
    }

    public static final double PREMIUM_DISCOUNT_RATE = 0.9;
    public static final double BULK_ORDER_THRESHOLD = 1000;
    public static final double BULK_ORDER_DISCOUNT = 50;
    public static final int LARGE_ITEM_THRESHOLD = 10;
    public static final double LARGE_ITEM_DISCOUNT = 20;
    public static final double INTERNATIONAL_FEE = 100;
}