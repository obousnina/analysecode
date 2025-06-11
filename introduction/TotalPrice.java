public class TotalPrice {
    public static void bulk(double total){
        if (total > 1000) {
            total -= 50;
        }
    }

    public static void large(Order order, double total){
        if (order.getItems().size() > 10) {
            total -= 20;
        }
    }

    public static void international(Order order, double total){
        if (order.isInternational()) {
            total += 100;
        }
    }
}
