package src.main;

public class SmsNotification implements CanalNotification {
    @Override
    public void envoyer(Utilisateur utilisateur, String message) {
        String numero = utilisateur.getCanal("sms");
        if (numero != null) {
            System.out.println("Envoi du SMS à " + numero + " : " + message);
        }
    }
}
