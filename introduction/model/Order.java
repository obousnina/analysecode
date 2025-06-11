package model;

import java.util.List;

/**
 * Represents an order containing multiple items, with methods to calculate the
 * total price
 * after applying various discounts and fees.
 */
public class Order {
  private static final double BULK_ORDER_DISCOUNT = 50.0;
  private static final double LARGE_ITEM_DISCOUNT = 20.0;
  private static final double INTERNATIONAL_SHIPPING_FEE = 100.0;

  private List<OrderItem> items;
  private boolean international;

  public Order(List<OrderItem> items, boolean international) {
    this.items = items;
    this.international = international;
  }

  public List<OrderItem> getItems() {
    return this.items;
  }

  public void setItems(List<OrderItem> items) {
    this.items = items;
  }

  public boolean isInternational() {
    return this.international;
  }

  public void setInternational(boolean international) {
    this.international = international;
  }

  /**
   * Calculates the total price of the order after applying discounts and fees.
   *
   * @param discountMultiplier The multiplier to apply based on customer type and
   *                           discount codes.
   * @return The total price after applying all discounts and fees.
   */
  public double getTotalPrice(double discountMultiplier) {
    if (items == null || items.isEmpty()) {
      return 0;
    }

    double total = 0;
    for (OrderItem item : items) {
      total += item.getPrice();
    }

    // Apply discount multiplier
    total *= discountMultiplier;

    // Apply order discounts
    total = applyBulkOrderDiscount(total);
    total = applyLargeItemDiscount(total);
    total = applyInternationalShippingFee(total);

    return total;
  }

  private double applyBulkOrderDiscount(double total) {
    return total > 1000 ? total - BULK_ORDER_DISCOUNT : total;
  }

  private double applyLargeItemDiscount(double total) {
    return items.size() > 10 ? total - LARGE_ITEM_DISCOUNT : total;
  }

  private double applyInternationalShippingFee(double total) {
    return international ? total + INTERNATIONAL_SHIPPING_FEE : total;
  }
}
