public enum DiscountType {
    HOLIDAY,
    NONE;

    public static DiscountType fromCode(String code) {
        if ("HOLIDAY".equalsIgnoreCase(code)) {
            return HOLIDAY;
        }
        return NONE;
    }
}
