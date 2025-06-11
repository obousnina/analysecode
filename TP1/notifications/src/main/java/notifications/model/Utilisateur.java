package notifications.model;

public class Utilisateur {
    private String email;
    private String numeroTelephone;
    private String deviceToken;

    public Utilisateur(String email, String numeroTelephone, String deviceToken) {
        this.email = email;
        this.numeroTelephone = numeroTelephone;
        this.deviceToken = deviceToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
} 