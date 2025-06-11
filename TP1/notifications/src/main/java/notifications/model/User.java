package notifications.model;

/**
 * Class User which is the user who can send and receive messages.
 * <p>
 * It has some attributes like email, number phone and a device token.
 */
public class User {

    private String email;
    private String phoneNumber;
    private String deviceToken;

    public User(String email, String phoneNumber, String deviceToken) {
    /**
     * Constructor which define a User and its attributes.
     *
     * @param email       which is a String corresponding the the email of the User.
     * @param numberPhone which is a String corresponding to the number phone of the User.
     * @param deviceToken which is a String corresponding to the token of the device used by the User.
     */
    public User(String email, String numberPhone, String deviceToken) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.deviceToken = deviceToken;
    }

    /**
     * Getter to get the email of the User.
     *
     * @return a String corresponding to the email of the User.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter to set the email of the User.
     *
     * @param email is a Strign corresponding to the new email of the User.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    /**
     * Getter to get the phone number of the User.
     *
     * @returna a String corresponding to the phone number of the User.
     */
    public String getNumberphone() {
        return numberphone;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    /**
     * Setter to set the phone number of the User.
     *
     * @param numberPhone is a Strign corresponding to the new phone number of the User.
     */
    public void setNumberphone(String numberPhone) {
        this.numberphone = numberPhone;
    }

    /**
     * Getter to get the deviceToken of the User.
     *
     * @return a String corresponding to the token of the device.
     */
    public String getDeviceToken() {
        return deviceToken;
    }

    /**
     * Setter to set the device token of the User.
     *
     * @param deviceToken is a Strign corresponding to the new token of the device.
     */
    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}