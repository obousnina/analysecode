/**
 * This class provides methods to calculate discount multipliers based on
 * customer type and discount codes.
 */
public class DiscountProcessor {
  private static final double DEFAULT_MULTIPLIER = 1.0;
  private static final double PREMIUM_CUSTOMER_DISCOUNT = 0.9; // 10%
  private static final double HOLIDAY_DISCOUNT = 0.8; // 20%

  private static final String HOLIDAY_DISCOUNT_CODE = "HOLIDAY";

  public static double getDiscountMultiplier(boolean isPremiumCustomer, String discountCode) {
    double multiplier = DEFAULT_MULTIPLIER;

    multiplier *= getPremiumMultiplier(isPremiumCustomer);
    multiplier *= getDiscountCodeMultiplier(discountCode);

    return multiplier;
  }

  private static double getDiscountCodeMultiplier(String discountCode) {
    switch (discountCode) {
      case HOLIDAY_DISCOUNT_CODE:
        return HOLIDAY_DISCOUNT;
      default:
        return DEFAULT_MULTIPLIER;
    }
  }

  private static double getPremiumMultiplier(boolean isPremiumCustomer) {
    return isPremiumCustomer ? PREMIUM_CUSTOMER_DISCOUNT : DEFAULT_MULTIPLIER;
  }
}
