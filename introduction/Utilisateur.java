public class Utilisateur {
    private final String email;
    private final String numeroTelephone;
    private final String deviceToken;

    public Utilisateur(String email, String numeroTelephone, String deviceToken) {
        this.email = email;
        this.numeroTelephone = numeroTelephone;
        this.deviceToken = deviceToken;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public String getDeviceToken() {
        return deviceToken;
    }
}