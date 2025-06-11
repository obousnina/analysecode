package model;

/**
 * Represents an item in an order, including product name, quantity, unit price,
 * and methods to calculate the total price for that item.
 */
public class OrderItem {
  private String productName;
  private int quantity;
  private double unitPrice;

  public OrderItem(String productName, int quantity, double unitPrice) {
    this.productName = productName;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
  }

  public String getProductName() {
    return this.productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getUnitPrice() {
    return this.unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public double getPrice() {
    return this.quantity * this.unitPrice;
  }

}
